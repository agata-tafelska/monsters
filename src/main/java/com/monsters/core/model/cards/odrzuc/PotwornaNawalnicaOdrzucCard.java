package com.monsters.core.model.cards.odrzuc;

import com.monsters.core.Logger;
import com.monsters.core.model.GameState;
import com.monsters.core.model.Monster;
import com.monsters.core.model.cards.CardType;
import com.monsters.core.model.cards.OdrzucCard;

public class PotwornaNawalnicaOdrzucCard extends OdrzucCard {
    @Override
    public void performAction(GameState gameState) {
        gameState.whoseTurn.score += 2;
        for (Monster monster : gameState.monsters) {
            if (monster != gameState.whoseTurn) {
                monster.power = monster.power/2;
            }
        }
        Logger.d("Potworna nawalnica action");
    }

    public PotwornaNawalnicaOdrzucCard() {
        super(6, "POTWORNA NAWALNICA", "+2 score. Wszyscy pozostali gracze\n" +
                "traca polowe swojego power\n(zaokraglona w dol)", CardType.ODRZUC);
    }
}
