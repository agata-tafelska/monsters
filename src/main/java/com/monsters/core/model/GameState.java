package com.monsters.core.model;

import com.monsters.core.Logger;

import java.util.List;

public class GameState {

    public List<Monster> monsters;
    public Monster whoIsInTokyo;
    public Monster whoseTurn;

    public GameState(List<Monster> monsters, Monster whoIsInTokyo, Monster whoseTurn) {
        this.monsters = monsters;
        this.whoIsInTokyo = whoIsInTokyo;
        this.whoseTurn = whoseTurn;
    }

    public void printState() {
        for (int i = 0; i < monsters.size(); i++) {
            Logger.d("Monster " + i + ": score - " + monsters.get(i).score
                    + ", life - " + monsters.get(i).life
                    + ", power - " + monsters.get(i).power);
        }
        if (whoIsInTokyo == null) {
            Logger.d("Monster in Tokyo: " + whoIsInTokyo);
        } else {
            Logger.d("Monster in Tokyo: " + whoIsInTokyo.name);
        }
        Logger.d("Whose turn: " + whoseTurn.name);
    }

        
}


