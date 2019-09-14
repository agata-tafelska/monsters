package com.monsters.core.model.cards.odrzuc;

import com.monsters.core.Logger;
import com.monsters.core.model.GameState;
import com.monsters.core.model.Monster;
import com.monsters.core.model.cards.CardType;
import com.monsters.core.model.cards.OdrzucCard;

public class BombardowanieOdrzucCard extends OdrzucCard {
    @Override
    public void performAction(GameState gameState) {
        for (Monster monster : gameState.monsters) {
            monster.life -= 3;
        }
        Logger.d("Bombardowanie action");
    }

    public BombardowanieOdrzucCard() {
        super(4, "BOMBARDOWANIE",
                "Kazdy gracz (z toba wlacznie)\ntraci 3 life.",
                CardType.ODRZUC);
    }
}
