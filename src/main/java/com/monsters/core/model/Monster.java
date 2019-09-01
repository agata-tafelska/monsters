package com.monsters.core.model;

public class Monster {

    public String name;
    public int score;
    public int life;
    public int power;

    public Monster(String name, int score, int life, int power) {
        this.name = name;
        this.score = score;
        this.life = life;
        this.power = power;
    }
}