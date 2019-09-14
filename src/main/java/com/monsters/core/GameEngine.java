package com.monsters.core;

import java.util.List;

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
    private TurnHandler turnHandler;
    private CardHandler cardHandler;

    public void initGame() {
        Logger.d("initGame");

        gameUI.prepareBoard();
        gameState = GameState.of(ListUtils.listOf(
                new Monster(1, "monsterOne"),
                new Monster(2, "monsterTwo"),
                new Monster(3, "monsterThree")
        ));

        cardHandler = new CardHandler(gameState, gameUI);
        turnHandler = new TurnHandler(gameState, gameUI, cardHandler);
        turnHandler.setNextPlayer();
        gameUI.displayCards(cardHandler.bankCards);
    }

    public void startTurn() {
        gameUI.renderStateForStartTurn(gameState);
    }

    public void processGame() {
        turnHandler.startTurn();
    }

    public void playTurn() {
        turnHandler.playTurn();
    }

    public void buyCard(int cardIndex) {
        cardHandler.buyCard(cardIndex);
    }

    public void shuffleCards() {
        cardHandler.shuffleCards();
        gameUI.displayCards(cardHandler.bankCards);
    }

    public void processDiceInput(List<Integer> selectedDicesResults) {
        turnHandler.processDiceInput(selectedDicesResults);
    }

    public void switchMonster() {
        turnHandler.switchMonster();
    }

    public void processExitTokyo(boolean shouldExitTokyo) {
        turnHandler.processExitTokyo(shouldExitTokyo);
    }

}

