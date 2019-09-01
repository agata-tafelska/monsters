package com.monsters.console;

import com.monsters.core.GameEngine;
import com.monsters.core.GameUI;
import com.monsters.core.Logger;
import com.monsters.core.model.DiceResult;
import com.monsters.core.model.GameState;
import com.monsters.core.model.Monster;
import com.monsters.core.model.Turn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI implements GameUI {
    @Override
    public void renderState(GameState gameState) {
        for (int i = 0; i < gameState.monsters.size(); i++) {
            ConsoleLogger.print(gameState.monsters.get(i).name + ": score - " + gameState.monsters.get(i).score
                    + ", life - " + gameState.monsters.get(i).life
                    + ", power - " + gameState.monsters.get(i).power);
        }
        if (gameState.whoIsInTokyo == null) {
            ConsoleLogger.print("Tokyo is empty.");
        } else {
            ConsoleLogger.print("Monster in Tokyo: " + gameState.whoIsInTokyo.name);
        }
        ConsoleLogger.print("Whose turn: " + gameState.whoseTurn.name);
    }

    @Override
    public void displayTurn(Turn turn) {
        if (turn.isFinished) {
            displayFinalResult(turn.dices);
            return;
        }
        ConsoleLogger.print(turn.monsterWhoseTurn.name + " turn. Roll count: " + turn.rollCount);
        displayDices(turn.dices);
    }

    private void displayDices(List<DiceResult> dices) {
        for (int i = 0; i < dices.size(); i++) {
            if (dices.get(i).isSelected) {
                ConsoleLogger.print(i + ": [" + dices.get(i) + "]");
            } else {
                ConsoleLogger.print(i + ": " + dices.get(i));
            }
        }
    }

    private void displayFinalResult(List<DiceResult> dices) {
        ConsoleLogger.print("Turn is finished.");
        ConsoleLogger.print("Final turn result: ");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < dices.size(); i++) {
           builder.append(dices.get(i)).append(" ");
        }
        ConsoleLogger.print(builder.toString());
    }

    @Override
    public void requestDiceInput() {
        List<Integer> numbers = Collections.emptyList();
        boolean isInputValid = false;
        while (!isInputValid) {
            Scanner userInput = new Scanner(System.in);
            ConsoleLogger.print("Select results. Type dice number(s) (0-5) separated with space.");
            try {
                numbers = parseDiceNumbers(userInput.nextLine());
                isInputValid = true;
            } catch (NumberFormatException e) {
                Logger.d(e.getClass() + ", Message: " + e.getMessage());
            }
        }
        GameEngine.getInstance().processDiceInput(numbers);
    }

    private List<Integer> parseDiceNumbers(String input) throws NumberFormatException {
        if (input.isEmpty()) {
            return Collections.emptyList();
        }

        List<Integer> numbers = new ArrayList<>();
        String[] inputParts = input.split(" ");

        for (String s : inputParts) {
            numbers.add(Integer.parseInt(s));
        }
        // Check if numbers of dices are correct
        for (int inputNumber : numbers) {
            if (inputNumber < 0 || inputNumber > 5) {
                throw new NumberFormatException("Provided number should be in range of 0-5");
            }
        }

        return numbers;
    }

    @Override
    public void requestExitTokyoInput(Monster monster) {
        String result;
        do {
            Scanner userInput = new Scanner(System.in);
            ConsoleLogger.print("Does " + monster.name + " want to leave Tokyo? Type 'yes' or 'no'.");
            result = userInput.nextLine();
        } while (!result.equals("yes") && !result.equals("no"));
        GameEngine.getInstance().processExitTokyo(result.equals("yes"));
    }

    @Override
    public void onGameFinished(Monster winnerMonster) {
        ConsoleLogger.print(winnerMonster.name + " won the game. Game is finished.");
    }
}
