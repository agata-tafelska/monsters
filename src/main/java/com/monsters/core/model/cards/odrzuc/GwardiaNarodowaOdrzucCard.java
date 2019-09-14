package com.monsters.core.model.cards.odrzuc;

import com.monsters.core.model.GameState;
import com.monsters.core.model.cards.CardType;
import com.monsters.core.model.cards.OdrzucCard;

public class GwardiaNarodowaOdrzucCard extends OdrzucCard {
    @Override
    public void performAction(GameState gameState) {
        gameState.whoseTurn.score += 2;
        gameState.whoseTurn.life -= 2;
    }

    public GwardiaNarodowaOdrzucCard() {
        super(3, "GWARDIA NARODOWA", "+2 score -2 life", CardType.ODRZUC);
    }
}
