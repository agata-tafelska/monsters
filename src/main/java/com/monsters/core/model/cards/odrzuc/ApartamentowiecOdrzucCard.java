package com.monsters.core.model.cards.odrzuc;

import com.monsters.core.Logger;
import com.monsters.core.model.GameState;
import com.monsters.core.model.cards.CardType;
import com.monsters.core.model.cards.OdrzucCard;

public class ApartamentowiecOdrzucCard extends OdrzucCard {
    @Override
    public void performAction(GameState gameState) {
        gameState.whoseTurn.score += 3;
    }

    public ApartamentowiecOdrzucCard() {
        super(5, "APARTAMENTOWIEC", "+3 score", CardType.ODRZUC);
    }
}
