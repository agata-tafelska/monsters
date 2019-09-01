package com.monsters.core.model;

public class GameResult {

    private boolean isGameFinished;
    private Monster winnerMonster;

    public GameResult(boolean isGameFinished, Monster winnerMonster) {
        this.isGameFinished = isGameFinished;
        this.winnerMonster = winnerMonster;
    }

    public boolean isGameFinished() {
        return isGameFinished;
    }

    public Monster getWinnerMonster() {
        return winnerMonster;
    }
}
