package com.monsters.core.model;

public class GameResult {

    public boolean isGameFinished;
    private Monster winnerMonster;

    public GameResult(boolean isGameFinished, Monster winnerMonster) {
        this.isGameFinished = isGameFinished;
        this.winnerMonster = winnerMonster;
    }

    public Monster getWinnerMonster() {
        return winnerMonster;
    }
}
