package com.monsters.core.model.cards.odrzuc;

import com.monsters.core.Logger;
import com.monsters.core.model.GameState;
import com.monsters.core.model.cards.CardType;
import com.monsters.core.model.cards.OdrzucCard;

public class SzalBojowyOdrzucCard extends OdrzucCard {
    @Override
    public void performAction(GameState gameState) {
        gameState.whoIsNext = gameState.whoseTurn;
        Logger.d("Szal bojowy action");
    }

    public SzalBojowyOdrzucCard() {
        super(7, "SZAL BOJOWY", "Rozegraj dodatkowa ture, natychmiast\n" +
                "po zakonczeniu tej obecnej.", CardType.ODRZUC);
    }
}
