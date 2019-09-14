package com.monsters.core.model;


import java.util.List;

public class GameState {

    public List<Monster> monsters;
    public Monster whoseTurn;
    public Monster whoIsInTokyo;
    public Monster whoIsNext;
    public List<DiceResult> finalCubesResults;

    private GameState(List<Monster> monsters) {
        this.monsters = monsters;
        this.whoseTurn = monsters.get(0);
    }

    public static GameState of(List<Monster> monsters) {
        return new GameState((monsters));
    }
}


