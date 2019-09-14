package com.monsters.core.model.cards.odrzuc;

import com.monsters.core.Logger;
import com.monsters.core.model.GameState;
import com.monsters.core.model.cards.CardType;
import com.monsters.core.model.cards.OdrzucCard;

public class PierwszaPomocOdrzucCard extends OdrzucCard {
    @Override
    public void performAction(GameState gameState) {
        gameState.whoseTurn.life += 2;
        if (gameState.whoseTurn.life > 10) {
            gameState.whoseTurn.life = 10;
        }
        Logger.d("Pierwsza pomoc action");
    }

    public PierwszaPomocOdrzucCard() {
        super(3, "PIERWSZA POMOC", "+2 life", CardType.ODRZUC);
    }
}
