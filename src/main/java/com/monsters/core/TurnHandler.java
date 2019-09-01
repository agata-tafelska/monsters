package com.monsters.core;

import com.monsters.core.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TurnHandler {

    private GameState gameState;
    private GameUI gameUI;
    private Turn currentTurn;

    TurnHandler(GameState gameState, GameUI gameUI) {
        this.gameState = gameState;
        this.gameUI = gameUI;
    }

    void playTurn() {
        Logger.d("Starting turn for: " + gameState.whoseTurn.name);
        currentTurn = new Turn(gameState.whoseTurn);

        // Add 2 points for starting turn in Tokyo
        if (gameState.whoseTurn == gameState.whoIsInTokyo) {
            gameState.whoseTurn.score += 2;

            // Finish game if at that point monster reached 20 points
            if (gameState.whoseTurn.score == 20) {
                gameUI.renderState(gameState);
                return;
            }
        }

        while (!currentTurn.isFinished) {
            gameUI.displayTurn(currentTurn);
            gameUI.requestDiceInput();
            currentTurn.continueTurn();
        }
        gameUI.displayTurn(currentTurn);
        Logger.d("Turn for " + currentTurn.monsterWhoseTurn.name + " finished.");
        StringBuilder builder = new StringBuilder();
        for (DiceResult result : currentTurn.dices) {
            builder.append(result).append(", ");
        }
        Logger.d("Final turn results: " + builder.toString());
        handleResults(currentTurn.dices);
        gameState.whoseTurn = switchMonster();
        gameUI.renderState(gameState);
    }

    void processDiceInput(List<Integer> selectedDicesResults) {
        currentTurn.selectDices(selectedDicesResults);
    }

    private void handleResults(List<DiceResult> dices) {
        Map<DiceResultType, Integer> resultsMap = new HashMap<>();
        Monster activeMonster = currentTurn.monsterWhoseTurn;
        for (DiceResult result : dices) {
            if (resultsMap.containsKey(result.type)) {
                Integer count = resultsMap.get(result.type);
                resultsMap.put(result.type, ++count);
                continue;
            }
            resultsMap.put(result.type, 1);
        }
        for (Map.Entry<DiceResultType, Integer> entry : resultsMap.entrySet()) {
            switch (entry.getKey()) {
                case POWER:
                    handlePowerResult(activeMonster, entry.getValue());
                    break;
                case HEART:
                    handleHeartResult(activeMonster, entry.getValue());
                    break;
                case ATTACK:
                    handleAttackResult(activeMonster, entry.getValue());
                    break;
                case ONE:
                case TWO:
                case THREE:
                    handleNumberResult(activeMonster, entry.getKey(), entry.getValue());
                    break;
                default:
                    throw new IllegalArgumentException("Invalid result type");
            }
        }
    }

    private void handleAttackResult(Monster activeMonster, int count) {
        if (gameState.whoIsInTokyo == null) {
            gameState.whoIsInTokyo = activeMonster;
            activeMonster.score += 1;
            Logger.d("Monster in Tokyo: " + activeMonster);
            return;
        }
        if (gameState.whoIsInTokyo == activeMonster) {
            for (Monster monster : gameState.monsters) {
                if (monster != activeMonster) {
                    monster.life -= count;
                    if (monster.life <= 0) {
                        gameState.monsters.remove(monster);
                    }
                }
            }
        } else {
            gameState.whoIsInTokyo.life -= count;
            if (gameState.whoIsInTokyo.life <= 0) {
                gameState.monsters.remove(gameState.whoIsInTokyo);
                gameState.whoIsInTokyo = gameState.whoseTurn;
            }
            gameUI.requestExitTokyoInput(gameState.whoIsInTokyo);
        }
    }

    void processExitTokyo(boolean shouldExitTokyo) {
        if (shouldExitTokyo) {
            gameState.whoIsInTokyo = gameState.whoseTurn;
            gameState.whoseTurn.score += 1;
        }
    }

    private void handleHeartResult(Monster activeMonster, int count) {
        if (gameState.whoIsInTokyo != activeMonster) {
            activeMonster.life += count;

            // Don't exceed max health 10
            if (activeMonster.life > 10) {
                activeMonster.life = 10;
            }
        }
    }

    private void handlePowerResult(Monster activeMonster, int count) {
        activeMonster.power += count;
    }

    private void handleNumberResult(Monster activeMonster, DiceResultType type, int count) {
        if (count < 3) {
            Logger.d("Number result: " + type + " less than 3, no points this time.");
            return;
        }
        int pointsNumber = 0;
        switch (type) {
            case ONE:
                pointsNumber = 1;
                break;
            case TWO:
                pointsNumber = 2;
                break;
            case THREE:
                pointsNumber = 3;
                break;
        }
        int totalPoints = pointsNumber + (count - 3);
        activeMonster.score += totalPoints;
    }

    private Monster switchMonster() {
        int index = gameState.monsters.indexOf(gameState.whoseTurn);
        index++;
        int newIndex = index % gameState.monsters.size();

        Logger.d("Switching monster, newIndex: " + newIndex);
        return gameState.monsters.get(newIndex);
    }

}
