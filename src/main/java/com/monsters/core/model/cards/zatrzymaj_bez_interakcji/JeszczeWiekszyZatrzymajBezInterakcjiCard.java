package com.monsters.core.model.cards.zatrzymaj_bez_interakcji;

import com.monsters.core.model.GameState;
import com.monsters.core.model.cards.CardType;
import com.monsters.core.model.cards.ZatrzymajBezInterakcjiCard;

public class JeszczeWiekszyZatrzymajBezInterakcjiCard extends ZatrzymajBezInterakcjiCard {

    boolean addLifePoints;

    @Override
    public void performAction(GameState gameState) {
        // Add life points only on buy card action
        if(!addLifePoints) {
            gameState.whoseTurn.life += 2;
            addLifePoints = true;
        }
        gameState.whoseTurn.maxLife = 12;
    }

    public JeszczeWiekszyZatrzymajBezInterakcjiCard() {
        super(4, "JESZCZE WIEKSZY", "+2 HEART, kiedy kupisz te karte.\n" +
                "Twoje maksymalne HEART jest zwiekszone\n do 12 (dopoki masz te karte).",
                CardType.ZATRZYMAJ_BEZ_INTERAKCJI);
    }
}
