package com.monsters.core.model.cards.odrzuc;

import com.monsters.core.Logger;
import com.monsters.core.model.GameState;
import com.monsters.core.model.cards.CardType;
import com.monsters.core.model.cards.OdrzucCard;

public class MysliwiecOdrzucCard extends OdrzucCard {
    @Override
    public void performAction(GameState gameState) {
        gameState.whoseTurn.score += 5;
        gameState.whoseTurn.life -= 4;
    }

    public MysliwiecOdrzucCard() {
        super(5, "MYSLIWIEC", "+5 score -4 life", CardType.ODRZUC);
    }
}
