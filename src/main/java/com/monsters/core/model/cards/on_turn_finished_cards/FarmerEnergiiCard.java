package com.monsters.core.model.cards.on_turn_finished_cards;

import com.monsters.core.model.GameState;
import com.monsters.core.model.cards.CardType;
import com.monsters.core.model.cards.OnTurnFinishedCard;

public class FarmerEnergiiCard extends OnTurnFinishedCard {
    @Override
    public void performAction(GameState gameState) {
        int scoreNumberToAdd = gameState.whoseTurn.power/6;
        gameState.whoseTurn.score += scoreNumberToAdd;
    }

    public FarmerEnergiiCard() {
        super(3, "FARMER ENERGII", "Zdobywasz 1 SCORE za kazde\n" +
                "6 POWER, ktore posiadasz na koniec\nswojej tury.", CardType.ON_TURN_FINISHED);
    }
}
