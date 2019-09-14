package com.monsters.core.model.cards.on_turn_finished_cards;

import com.monsters.core.model.GameState;
import com.monsters.core.model.cards.CardType;
import com.monsters.core.model.cards.OnTurnFinishedCard;

public class EnergiaSlonecznaCard extends OnTurnFinishedCard {
    @Override
    public void performAction(GameState gameState) {
        if (gameState.whoseTurn.power == 0) {
            gameState.whoseTurn.power += 1;
        }
    }

    public EnergiaSlonecznaCard() {
        super(2, "ENERGIA SLONECZNA", "Jezeli na koniec swojej tury\n" +
                "nie posiadasz zadnego POWER,\nzdobywasz 1 POWER. Mozesz\n" +
                "wykorzystac te karte w tej samej\nturze, w ktorej ja kupiles.", CardType.ON_TURN_FINISHED);
    }
}
