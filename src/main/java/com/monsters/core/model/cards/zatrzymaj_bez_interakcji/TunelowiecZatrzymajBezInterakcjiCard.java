package com.monsters.core.model.cards.zatrzymaj_bez_interakcji;

import com.monsters.core.model.DiceResult;
import com.monsters.core.model.DiceResultType;
import com.monsters.core.model.GameState;
import com.monsters.core.model.cards.CardType;
import com.monsters.core.model.cards.ZatrzymajBezInterakcjiCard;

public class TunelowiecZatrzymajBezInterakcjiCard extends ZatrzymajBezInterakcjiCard {
    @Override
    public void performAction(GameState gameState) {
        if (gameState.whoseTurn == gameState.whoIsInTokyo) {
            gameState.finalCubesResults.add(new DiceResult(DiceResultType.ATTACK));
        }
    }

    public TunelowiecZatrzymajBezInterakcjiCard() {
        super(5, "TUNELOWIEC", "Jezeli jestes w Tokio, dodaj ATTACK\n" +
                "do swojego wyniku. Kiedy opuszczasz\nTokio, gracz, ktory wchodzi na\n" +
                "Twoje miejsce traci 1 LIFE.", CardType.ZATRZYMAJ_BEZ_INTERAKCJI);
    }
}
