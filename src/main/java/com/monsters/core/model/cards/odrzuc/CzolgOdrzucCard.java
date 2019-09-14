package com.monsters.core.model.cards.odrzuc;

import com.monsters.core.model.GameState;
import com.monsters.core.model.cards.CardType;
import com.monsters.core.model.cards.OdrzucCard;

public class CzolgOdrzucCard extends OdrzucCard {
    @Override
    public void performAction(GameState gameState) {
        gameState.whoseTurn.score += 4;
        gameState.whoseTurn.life -= 3;
    }

    public CzolgOdrzucCard() {
        super(4, "CZOLG", "+4 score -3 life", CardType.ODRZUC);
    }
}
