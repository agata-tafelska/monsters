package com.monsters.core.model;

import com.monsters.core.model.cards.Card;

import java.util.ArrayList;
import java.util.List;

public class Monster {
    public int id;
    public String name;
    public int score;
    public int life = 10;
    public int maxLife = 10;
    public int power;
    public boolean isAlive = true;
    public List<Card> cards = new ArrayList<>();

    public Monster(int id, String name) {
        this.id = id;
        this.name = name;
    }
}