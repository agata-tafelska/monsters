package com.monsters.core.model.cards.odrzuc;

import com.monsters.core.Logger;
import com.monsters.core.model.GameState;
import com.monsters.core.model.Monster;
import com.monsters.core.model.cards.CardType;
import com.monsters.core.model.cards.OdrzucCard;

public class EwakuacjaOdrzucCard extends OdrzucCard {
    @Override
    public void performAction(GameState gameState) {
        for (Monster monster : gameState.monsters) {
            if (monster != gameState.whoseTurn) {
                monster.score -= 5;
                if (monster.score <= 0) {
                    monster.score = 0;
                }
            }
        }
        Logger.d("Ewakuacja2 action");
    }

    public EwakuacjaOdrzucCard() {
        super(7, "EWAKUACJA", "Pozostali gracze traca 5 score", CardType.ODRZUC);
    }
}
