package com.monsters.core.model;

import com.monsters.core.Logger;
import com.monsters.core.model.cards.Card;
import com.monsters.core.model.cards.CardType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Turn {

    public Monster monsterWhoseTurn;
    public List<DiceResult> dices;
    public int rollCount = 1;
    public boolean isFinished = false;
    private int numberOfDices = 6;

    public Turn(Monster monsterWhoseTurn) {
        this.monsterWhoseTurn = monsterWhoseTurn;
        this.dices = initDices();
    }

    private List<DiceResult> initDices() {
        for (Card card : monsterWhoseTurn.cards) {
            if (card.type == CardType.DODATKOWA_GLOWA) {
                numberOfDices++;
                Logger.d("Number of dices: " + numberOfDices);
            }
        }
        List<DiceResult> dicesResults = new ArrayList<>();
        for (int i = 0; i < numberOfDices; i++) {
            dicesResults.add(new DiceResult(rollDice()));
        }
        return dicesResults;
    }

    private DiceResultType rollDice() {
        int pick = new Random().nextInt(DiceResultType.values().length);
        return DiceResultType.values()[pick];
    }

    public void selectDices(List<Integer> selectedDicesIndexes) {
        for (DiceResult dice : dices) {
            dice.isSelected = false;
        }
        for (Integer index : selectedDicesIndexes) {
            dices.get(index).isSelected = true;
        }
    }

    public void continueTurn() {
        int count = 0;
        for (DiceResult dice : dices) {
            if (dice.isSelected) {
                count++;
            }
        }
        if (count == dices.size()) {
            Logger.d("All dices selected. Turn is finished");
            isFinished = true;
            return;
        }

        for (int i = 0; i < dices.size(); i++) {
            if (!dices.get(i).isSelected) {
                dices.get(i).type = rollDice();
            }
        }

        rollCount++;
        if (rollCount == 3) {
            Logger.d("Already rolled 3 times. Turn is finished");
            isFinished = true;
            return;
        }

    }
}
