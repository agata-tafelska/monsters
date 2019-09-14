package com.monsters.core.model.cards.odrzuc;

import com.monsters.core.Logger;
import com.monsters.core.model.GameState;
import com.monsters.core.model.cards.CardType;
import com.monsters.core.model.cards.OdrzucCard;

public class ElektrowniaJadrowaOdrzucCard extends OdrzucCard {
    @Override
    public void performAction(GameState gameState) {
        gameState.whoseTurn.score += 2;
        gameState.whoseTurn.life += 3;
        if (gameState.whoseTurn.life > 10) {
            gameState.whoseTurn.life = 10;
        }
        Logger.d("Elektrownia jadrowa action");
    }

    public ElektrowniaJadrowaOdrzucCard() {
        super(6, "ELEKTROWNIA JADROWA", "+2 score +3 life", CardType.ODRZUC);
    }
}
