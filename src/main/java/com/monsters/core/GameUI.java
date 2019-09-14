package com.monsters.core;

import com.monsters.core.model.GameState;
import com.monsters.core.model.Monster;
import com.monsters.core.model.Turn;
import com.monsters.core.model.cards.BankCard;
import com.monsters.core.model.cards.Card;

import java.util.List;

public interface GameUI {

    void prepareBoard();

    void renderStateForStartTurn(GameState gameState);

    void onGameStateChanged(GameState gameState, List<BankCard> bankCards);

    void onMonsterInTheCityChanged(Monster monster);

    void useExtraCube(int numberOfExtraCubes);

    void displayCards(List<Card> cards);

    void displayTurn(Turn turn);

    void requestExitCityInput(Monster monster);

    void onMonsterFinishedGame(Monster monster);

    void onGameFinished(Monster winnerMonster, GameState gameState);
}

