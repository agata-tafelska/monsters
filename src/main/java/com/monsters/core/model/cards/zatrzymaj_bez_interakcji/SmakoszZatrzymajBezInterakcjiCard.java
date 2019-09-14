package com.monsters.core.model.cards.zatrzymaj_bez_interakcji;

import com.monsters.core.model.DiceResult;
import com.monsters.core.model.DiceResultType;
import com.monsters.core.model.GameState;
import com.monsters.core.model.cards.CardType;
import com.monsters.core.model.cards.ZatrzymajBezInterakcjiCard;

public class SmakoszZatrzymajBezInterakcjiCard extends ZatrzymajBezInterakcjiCard {
    @Override
    public void performAction(GameState gameState) {
        int oneCount = 0;
        for (DiceResult result : gameState.finalCubesResults) {
            if (result.type == DiceResultType.ONE) {
                oneCount++;
                if (oneCount == 3) {
                    gameState.whoseTurn.score += 2;
                    return;
                }
            }
        }
    }

    public SmakoszZatrzymajBezInterakcjiCard() {
        super(4, "SMAKOSZ", "Jesli wyrzucisz ONE ONE ONE,\n" +
                "zdobywasz dodatkowo 2 SCORE", CardType.ZATRZYMAJ_BEZ_INTERAKCJI);
    }
}
