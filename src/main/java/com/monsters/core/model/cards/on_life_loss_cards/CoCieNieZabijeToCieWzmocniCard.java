package com.monsters.core.model.cards.on_life_loss_cards;

import com.monsters.core.model.GameState;
import com.monsters.core.model.cards.CardType;
import com.monsters.core.model.cards.OnLifeLossCard;

public class CoCieNieZabijeToCieWzmocniCard extends OnLifeLossCard {
    @Override
    public void performAction(GameState gameState) {

    }

    public CoCieNieZabijeToCieWzmocniCard() {
        super(3,"CO CIE NIE ZABIJE,\nTO CIE WZMOCNI",
                "Kiedy tracisz 2 lub wiecej LIFE\n" +
                        "zdobywasz 1 SCORE.", CardType.ON_LIFE_LOSS_CARD);
    }
}
