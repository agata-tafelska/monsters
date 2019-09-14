package com.monsters.core.model.cards.odrzuc;

import com.monsters.core.Logger;
import com.monsters.core.model.GameState;
import com.monsters.core.model.cards.CardType;
import com.monsters.core.model.cards.OdrzucCard;

public class SzybkaPrzekaskaOdrzucCard extends OdrzucCard {

    @Override
    public void performAction(GameState gameState) {
        gameState.whoseTurn.score += 1;
        Logger.d("Szybka przekaska action");
    }
    public SzybkaPrzekaskaOdrzucCard() {
        super(3, "SZYBKA PRZEKASKA", "+1 score", CardType.ODRZUC);
    }

}
