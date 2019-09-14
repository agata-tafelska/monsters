package com.monsters.core.model.cards.zatrzymaj_bez_interakcji;

import com.monsters.core.Logger;
import com.monsters.core.model.DiceResult;
import com.monsters.core.model.DiceResultType;
import com.monsters.core.model.GameState;
import com.monsters.core.model.cards.CardType;
import com.monsters.core.model.cards.ZatrzymajBezInterakcjiCard;

public class MiastozernyZatrzymajBezInterakcjiCard extends ZatrzymajBezInterakcjiCard {
    @Override
    public void performAction(GameState gameState) {
        if (gameState.whoseTurn == gameState.whoIsInTokyo) {
            gameState.whoseTurn.score += 1;
            for (DiceResult result : gameState.finalCubesResults) {
                if (result.type == DiceResultType.ATTACK) {
                    gameState.finalCubesResults.add(new DiceResult(DiceResultType.ATTACK));
                    return;
                }
            }
        }
    }

    public MiastozernyZatrzymajBezInterakcjiCard() {
        super(4, "MIASTOZERNY", "Jezeli na poczatku swojej tury jestes w \n" +
                "Tokio, zdobywasz dodatkowo 1 SCORE. \nGdy bedac w Tokio wyrzucisz\n" +
                "przynajmniej 1 ATTACK, dodaj ATTACK\ndo swojego wyniku.", CardType.ZATRZYMAJ_BEZ_INTERAKCJI);
    }
}
