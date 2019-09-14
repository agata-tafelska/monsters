package com.monsters.core;

import com.monsters.core.model.*;
import com.monsters.core.model.cards.Card;
import com.monsters.core.model.cards.CardType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TurnHandler {

    private GameState gameState;
    private GameUI gameUI;
    private Turn currentTurn;
    private CardHandler cardHandler;

    TurnHandler(GameState gameState, GameUI gameUI, CardHandler cardHandler) {
        this.gameState = gameState;
        this.gameUI = gameUI;
        this.cardHandler = cardHandler;
    }

    void startTurn() {
        Logger.d("Starting turn for: " + gameState.whoseTurn.name);
        currentTurn = new Turn(gameState.whoseTurn);

        // Add 2 points for starting turn in Tokyo
        if (gameState.whoseTurn == gameState.whoIsInTokyo) {
            gameState.whoseTurn.score += 2;

            // Finish game if at that point monster reached 20 points
            if (gameState.whoseTurn.score >= 20) {
                gameUI.onGameFinished(gameState.whoseTurn, gameState);
                return;
            }
        }
        gameUI.renderStateForStartTurn(gameState);
        int numberOfDodatkowaGlowa = 0;
        for (Card card : currentTurn.monsterWhoseTurn.cards) {
            if (card.type == CardType.DODATKOWA_GLOWA) {
                numberOfDodatkowaGlowa++;
                Logger.d("Monster has dodatkowa glowa card. Number: " + numberOfDodatkowaGlowa);
            }
        }
        gameUI.useExtraCube(numberOfDodatkowaGlowa);
        gameUI.displayTurn(currentTurn);
    }

    void playTurn() {
        currentTurn.continueTurn();
        if (currentTurn.isFinished) {
            gameUI.displayTurn(currentTurn);
            gameState.finalCubesResults = currentTurn.dices;
            for (Card card : currentTurn.monsterWhoseTurn.cards) {
                if (card.type == CardType.ZATRZYMAJ_BEZ_INTERAKCJI) {
                    card.performAction(gameState);
                }
                if (card.type == CardType.ON_LIFE_LOSS_CARD) {

                }
            }

            handleResults(gameState.finalCubesResults);
            setNextPlayer();
            for (Card card : currentTurn.monsterWhoseTurn.cards) {
                if (card.type == CardType.ON_TURN_FINISHED) {
                    card.performAction(gameState);
                }
            }
            gameUI.onGameStateChanged(gameState, cardHandler.getCardsMonsterCanAfford(gameState.whoseTurn));
            if (getGameResult().isGameFinished) {
                gameUI.onGameFinished(getGameResult().getWinnerMonster(), gameState);
            }
        } else {
            gameUI.displayTurn(currentTurn);
        }
    }

    void processDiceInput(List<Integer> selectedDicesResults) {
        currentTurn.selectDices(selectedDicesResults);
    }

    void processExitTokyo(boolean shouldExitTokyo) {
        if (shouldExitTokyo) {
            gameState.whoIsInTokyo = currentTurn.monsterWhoseTurn;
            currentTurn.monsterWhoseTurn.score += 1;
            gameUI.onMonsterInTheCityChanged(gameState.whoIsInTokyo);
        }
    }

    public void handleResults(List<DiceResult> dices) {
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
            gameUI.onMonsterInTheCityChanged(gameState.whoIsInTokyo);
            return;
        }
        if (gameState.whoIsInTokyo == activeMonster) {
            for (Monster monster : gameState.monsters) {
                if (monster != activeMonster && monster.isAlive) {
                    monster.life -= count;
                    if (monster.life <= 0) {
                        monster.life = 0;
                        monster.isAlive = false;
                        gameUI.onMonsterFinishedGame(monster);
                    }
                }
            }
        } else {
            gameState.whoIsInTokyo.life -= count;
            if (gameState.whoIsInTokyo.life <= 0) {
                gameState.whoIsInTokyo.life = 0;
                gameState.whoIsInTokyo.isAlive = false;
                List<Monster> aliveMonsters = new ArrayList<>();
                for (Monster monster : gameState.monsters) {
                    if (monster.isAlive) {
                        aliveMonsters.add(monster);
                    }
                }
                if (aliveMonsters.size() == 1) {
                    return;
                }
                gameUI.onMonsterFinishedGame(gameState.whoIsInTokyo);
                gameState.whoIsInTokyo = gameState.whoseTurn;
                gameState.whoIsInTokyo.score += 1;
                gameUI.onMonsterInTheCityChanged(gameState.whoIsInTokyo);
                return;
            }
            gameUI.requestExitCityInput(gameState.whoIsInTokyo);
        }
    }

    private void handleHeartResult(Monster activeMonster, int count) {
        if (gameState.whoIsInTokyo != activeMonster) {
            activeMonster.life += count;

            // Don't exceed max health 10
            if (activeMonster.life > activeMonster.maxLife) {
                activeMonster.life = activeMonster.maxLife;
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
        if (activeMonster.score > 20) {
            activeMonster.score = 20;
        }
    }

    public void switchMonster() {
        gameState.whoseTurn = gameState.whoIsNext;
    }

    public void setNextPlayer() {
        gameState.whoIsNext = gameState.monsters.get(calculateNextMonsterIndex());
    }

    private int calculateNextMonsterIndex() {
        int index = gameState.monsters.indexOf(gameState.whoseTurn);
        int newIndex;
        do {
            index++;
            newIndex = index % gameState.monsters.size();
        } while (!gameState.monsters.get(newIndex).isAlive);
        return newIndex;
    }

    public GameResult getGameResult() {
        List<Monster> aliveMonsters = new ArrayList<>();
        gameState.monsters.forEach(monster -> {
            if (monster.life > 0) aliveMonsters.add(monster);
        });

        GameResult gameResult;
        if (aliveMonsters.size() == 1) {
            gameResult = new GameResult(true, aliveMonsters.get(0));
            return gameResult;
        }
        for (Monster monster : gameState.monsters) {
            if (monster.score >= 20) {
                gameResult = new GameResult(true, monster);
                return gameResult;
            }
        }
        gameResult = new GameResult(false, null);
        return gameResult;
    }

}
