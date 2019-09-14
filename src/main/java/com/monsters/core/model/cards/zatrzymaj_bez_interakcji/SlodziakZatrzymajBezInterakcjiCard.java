package com.monsters.core.model.cards.zatrzymaj_bez_interakcji;

import com.monsters.core.Logger;
import com.monsters.core.model.DiceResult;
import com.monsters.core.model.DiceResultType;
import com.monsters.core.model.GameState;
import com.monsters.core.model.cards.CardType;
import com.monsters.core.model.cards.ZatrzymajBezInterakcjiCard;

public class SlodziakZatrzymajBezInterakcjiCard extends ZatrzymajBezInterakcjiCard {
    @Override
    public void performAction(GameState gameState) {
        for (DiceResult result : gameState.finalCubesResults) {
            if (result.type == DiceResultType.POWER) {
                Logger.d("Final cubes results contain power.");
                gameState.finalCubesResults.add(new DiceResult(DiceResultType.POWER));
                return;
            }
        }
    }

    public SlodziakZatrzymajBezInterakcjiCard() {
        super(3, "SLODZIAK", "Kiedy zdobywasz POWER, zdobywasz\n" +
                "dodatkowo 1 POWER", CardType.ZATRZYMAJ_BEZ_INTERAKCJI);
    }
}
