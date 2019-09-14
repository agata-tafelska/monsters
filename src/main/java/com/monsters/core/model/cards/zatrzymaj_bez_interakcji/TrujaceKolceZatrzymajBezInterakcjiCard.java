package com.monsters.core.model.cards.zatrzymaj_bez_interakcji;

import com.monsters.core.model.DiceResult;
import com.monsters.core.model.DiceResultType;
import com.monsters.core.model.GameState;
import com.monsters.core.model.cards.CardType;
import com.monsters.core.model.cards.ZatrzymajBezInterakcjiCard;

public class TrujaceKolceZatrzymajBezInterakcjiCard extends ZatrzymajBezInterakcjiCard {

    @Override
    public void performAction(GameState gameState) {
        int twoCount = 0;
        for (DiceResult result : gameState.finalCubesResults) {
            if (result.type == DiceResultType.TWO) {
                twoCount++;
                if (twoCount == 3) {
                    gameState.finalCubesResults.add(new DiceResult(DiceResultType.ATTACK));
                    gameState.finalCubesResults.add(new DiceResult(DiceResultType.ATTACK));
                    return;
                }
            }
        }
    }

    public TrujaceKolceZatrzymajBezInterakcjiCard() {
        super(3, "TRUJACE KOLCE", "Jesli wyrzucisz TWO TWO TWO,\n" +
                "dodaj 2x ATTACK do swojego wyniku.", CardType.ZATRZYMAJ_BEZ_INTERAKCJI);
    }
}
