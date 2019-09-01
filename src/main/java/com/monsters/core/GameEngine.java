package com.monsters.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.monsters.core.model.*;

public class GameEngine {

    private static GameEngine instance = new GameEngine();

    private GameEngine() {
    }

    public static GameEngine getInstance() {
        return instance;
    }

    public GameUI gameUI;
    private GameState gameState;
    private GameResult gameResult;
    private TurnHandler turnHandler;

    public void initGame() {
        Logger.d("initGame");

        Monster monsterOne = new Monster("monsterOne", 0, 10, 0);
        Monster monsterTwo = new Monster("monsterTwo", 0, 10, 0);
        Monster monsterThree = new Monster("monsterThree", 0, 10, 0);

        List<Monster> monsters = new ArrayList<>();
        monsters.add(monsterOne);
        monsters.add(monsterTwo);
        monsters.add(monsterThree);

        Monster whoIsInTokyo = null;
        Monster whoseTurn = monsters.get(0);

        gameState = new GameState(monsters, whoIsInTokyo, whoseTurn);
        turnHandler = new TurnHandler(gameState, gameUI);
    }

    public void startGame() {
        Logger.d("startGame");
        gameUI.renderState(gameState);
        processGame();
    }

    private void processGame() {
        Logger.d("processGame");
        while (!getGameResult().isGameFinished()) {
            turnHandler.playTurn();
        }
        gameUI.onGameFinished(getGameResult().getWinnerMonster());
    }

    public void processDiceInput(List<Integer> selectedDicesResults) {
        turnHandler.processDiceInput(selectedDicesResults);
    }

    public void processExitTokyo(boolean shouldExitTokyo) {
        turnHandler.processExitTokyo(shouldExitTokyo);
    }

    public GameResult getGameResult() {
        List<Monster> aliveMonsters = new ArrayList<>();
        for (Monster monster : gameState.monsters) {
            if (monster.life > 0) {
                aliveMonsters.add(monster);
            }
        }
        if (aliveMonsters.size() == 1) {
            Logger.d(aliveMonsters.get(0).name + " is the only alive monster. Game is finished.");
            gameResult = new GameResult(true, aliveMonsters.get(0));
            return gameResult;
        }
        for (Monster monster : gameState.monsters) {
            if (monster.score >= 20) {
                Logger.d(monster.name + " has more than 20 points. Game is finished.");
                gameResult = new GameResult(true, monster);
                return gameResult;
            }
        }
        gameResult = new GameResult(false, null);
        return gameResult;
    }
}

