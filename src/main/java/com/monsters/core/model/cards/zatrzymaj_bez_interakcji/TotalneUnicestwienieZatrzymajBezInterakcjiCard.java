package com.monsters.core.model.cards.zatrzymaj_bez_interakcji;

import com.monsters.core.Logger;
import com.monsters.core.model.DiceResult;
import com.monsters.core.model.DiceResultType;
import com.monsters.core.model.GameState;
import com.monsters.core.model.cards.CardType;
import com.monsters.core.model.cards.ZatrzymajBezInterakcjiCard;

public class TotalneUnicestwienieZatrzymajBezInterakcjiCard extends ZatrzymajBezInterakcjiCard {
    @Override
    public void performAction(GameState gameState) {
        if(gameState.finalCubesResults.contains(DiceResultType.ATTACK)) {
            Logger.d("Final result contains ATTACK.");
        }
    }

    public TotalneUnicestwienieZatrzymajBezInterakcjiCard() {
        super(3, "TOTALNE UNICESTWIENIE", "Jeśli wyrzucisz 1, 2, 3, HEART\n" +
                "ATTACK, POWER, zdobywasz dodatkowo\n 9 SCORE", CardType.ZATRZYMAJ_BEZ_INTERAKCJI);
    }
}
