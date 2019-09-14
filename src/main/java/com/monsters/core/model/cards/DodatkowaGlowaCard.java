package com.monsters.core.model.cards;

import com.monsters.core.model.GameState;

public class DodatkowaGlowaCard extends Card {
    public DodatkowaGlowaCard() {
        super(7, "DODATKOWA GLOWA", "Rzucasz dodatkowo 1 kostka.", CardType.DODATKOWA_GLOWA);
    }
    @Override
    public void performAction(GameState gameState) {
    }


}
