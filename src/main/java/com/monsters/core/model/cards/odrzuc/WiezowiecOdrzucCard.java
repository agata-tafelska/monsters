package com.monsters.core.model.cards.odrzuc;

import com.monsters.core.model.GameState;
import com.monsters.core.model.cards.CardType;
import com.monsters.core.model.cards.OdrzucCard;

public class WiezowiecOdrzucCard extends OdrzucCard {
    @Override
    public void performAction(GameState gameState) {
        gameState.whoseTurn.score += 4;
    }

    public WiezowiecOdrzucCard() {
        super(6, "WIEZOWIEC", "+4 score", CardType.ODRZUC);
    }
}
