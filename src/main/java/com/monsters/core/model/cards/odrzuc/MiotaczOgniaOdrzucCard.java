package com.monsters.core.model.cards.odrzuc;

import com.monsters.core.Logger;
import com.monsters.core.model.GameState;
import com.monsters.core.model.Monster;
import com.monsters.core.model.cards.CardType;
import com.monsters.core.model.cards.OdrzucCard;

public class MiotaczOgniaOdrzucCard extends OdrzucCard {

    @Override
    public void performAction(GameState gameState) {
        for (Monster monster : gameState.monsters) {
            if (monster != gameState.whoseTurn) {
                monster.life -= 2;
            }
        }
    }

    public MiotaczOgniaOdrzucCard() {
        super(3, "MIOTACZ OGNIA", "Pozostali gracze traca 2 life", CardType.ODRZUC);
    }
}
