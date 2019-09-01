package com.monsters.console;

import com.monsters.core.GameEngine;

public class ConsoleApp {
    public static void main(String[] args) {
        GameEngine.getInstance().gameUI = new ConsoleUI();
        GameEngine.getInstance().initGame();
        GameEngine.getInstance().startGame();
    }
}
