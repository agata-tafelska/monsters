package com.monsters.core.model.cards.zatrzymaj_bez_interakcji;

import com.monsters.core.model.DiceResult;
import com.monsters.core.model.DiceResultType;
import com.monsters.core.model.GameState;
import com.monsters.core.model.cards.CardType;
import com.monsters.core.model.cards.ZatrzymajBezInterakcjiCard;

public class AtakKwasemZatrzymajBezInterakcjiCard extends ZatrzymajBezInterakcjiCard {
    @Override
    public void performAction(GameState gameState) {
        gameState.finalCubesResults.add(new DiceResult(DiceResultType.ATTACK));
    }

    public AtakKwasemZatrzymajBezInterakcjiCard() {
        super(6, "ATAK KWASEM", "Dodaj ATTACK do swojego wyniku.", CardType.ZATRZYMAJ_BEZ_INTERAKCJI);
    }
}
