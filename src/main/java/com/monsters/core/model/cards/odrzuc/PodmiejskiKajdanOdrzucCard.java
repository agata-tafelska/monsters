package com.monsters.core.model.cards.odrzuc;

import com.monsters.core.Logger;
import com.monsters.core.model.GameState;
import com.monsters.core.model.cards.CardType;
import com.monsters.core.model.cards.OdrzucCard;

public class PodmiejskiKajdanOdrzucCard extends OdrzucCard {
    @Override
    public void performAction(GameState gameState) {
        gameState.whoseTurn.score += 2;
        Logger.d("Podmiejski kajdan action");
    }

    public PodmiejskiKajdanOdrzucCard() {
        super(4, "PODMIEJSKI KAJDAN", "+2 score", CardType.ODRZUC);
    }
}
