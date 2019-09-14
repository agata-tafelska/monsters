package com.monsters.core.model.cards.in_own_turn_with_interaction;

import com.monsters.core.model.GameState;
import com.monsters.core.model.cards.CardType;
import com.monsters.core.model.cards.InOwnTurnWithInteractionCard;

public class WielkiMozgCard extends InOwnTurnWithInteractionCard {
    @Override
    public void performAction(GameState gameState) {

    }

    public WielkiMozgCard() {
        super(5, "WIELKI MOZG", "W kazdej turze mozesz wykonac\n" +
                "1 dodatkowy rzut kostkami.", CardType.IN_OWN_TURN_WITH_INTERACTION);
    }
}
