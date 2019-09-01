package com.monsters.core;

import com.monsters.core.model.GameState;
import com.monsters.core.model.Monster;
import com.monsters.core.model.Turn;

public interface GameUI {

    void renderState(GameState gameState);

    void displayTurn(Turn turn);

    void requestDiceInput();

    void requestExitTokyoInput(Monster monster);

    void onGameFinished(Monster winnerMonster);
}

