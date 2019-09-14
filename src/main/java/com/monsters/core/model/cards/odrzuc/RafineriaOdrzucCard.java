package com.monsters.core.model.cards.odrzuc;

import com.monsters.core.Logger;
import com.monsters.core.model.GameState;
import com.monsters.core.model.Monster;
import com.monsters.core.model.cards.CardType;
import com.monsters.core.model.cards.OdrzucCard;

public class RafineriaOdrzucCard extends OdrzucCard {
    @Override
    public void performAction(GameState gameState) {
        gameState.whoseTurn.score += 2;
        for (Monster monster : gameState.monsters) {
            if (monster != gameState.whoseTurn) {
                monster.life -= 3;
            }
        }
        Logger.d("Rafineria action");
    }

    public RafineriaOdrzucCard() {
        super(6, "RAFINERIA",
                "+2 score. Pozostali gracze traca 3 life.",
                CardType.ODRZUC);
    }
}
