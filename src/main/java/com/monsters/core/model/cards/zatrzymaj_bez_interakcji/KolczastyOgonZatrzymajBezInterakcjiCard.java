package com.monsters.core.model.cards.zatrzymaj_bez_interakcji;

import com.monsters.core.Logger;
import com.monsters.core.model.DiceResult;
import com.monsters.core.model.DiceResultType;
import com.monsters.core.model.GameState;
import com.monsters.core.model.cards.CardType;
import com.monsters.core.model.cards.ZatrzymajBezInterakcjiCard;

public class KolczastyOgonZatrzymajBezInterakcjiCard extends ZatrzymajBezInterakcjiCard {

    @Override
    public void performAction(GameState gameState) {
        for (DiceResult result : gameState.finalCubesResults) {
            if (result.type == DiceResultType.ATTACK) {
                Logger.d("Final cubes results contain attack.");
                gameState.finalCubesResults.add(new DiceResult(DiceResultType.ATTACK));
                return;
            }
        }
    }

    public KolczastyOgonZatrzymajBezInterakcjiCard() {
        super(5, "KOLCZASTY OGON", "Kiedy wyrzucisz przynajmniej 1 ATTACK,\n" +
                "dodaj ATTACK do swojego wyniku.", CardType.ZATRZYMAJ_BEZ_INTERAKCJI);
    }
}
