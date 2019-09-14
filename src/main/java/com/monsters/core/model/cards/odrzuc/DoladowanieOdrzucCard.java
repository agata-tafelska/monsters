package com.monsters.core.model.cards.odrzuc;

import com.monsters.core.Logger;
import com.monsters.core.model.GameState;
import com.monsters.core.model.Monster;
import com.monsters.core.model.cards.CardType;
import com.monsters.core.model.cards.OdrzucCard;

public class DoladowanieOdrzucCard extends OdrzucCard {

    @Override
    public void performAction(GameState gameState) {
        gameState.whoseTurn.power += 9;
    }

    public DoladowanieOdrzucCard() {
        super(8, "DOLADOWANIE", "+9 power", CardType.ODRZUC);
    }
}
