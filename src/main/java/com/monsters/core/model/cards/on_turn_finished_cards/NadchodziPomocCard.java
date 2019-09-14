package com.monsters.core.model.cards.on_turn_finished_cards;

import com.monsters.core.model.GameState;
import com.monsters.core.model.Monster;
import com.monsters.core.model.cards.CardType;
import com.monsters.core.model.cards.OnTurnFinishedCard;

public class NadchodziPomocCard extends OnTurnFinishedCard {
    @Override
    public void performAction(GameState gameState) {
        int monstersWithLessScore = 0;
        for (Monster monster : gameState.monsters) {
            if (monster != gameState.whoseTurn) {
                if (gameState.whoseTurn.score >= monster.score) {
                    monstersWithLessScore++;
                }
            }
        }
        if (monstersWithLessScore == 0) {
            gameState.whoseTurn.score += 1;
        }
    }

    public NadchodziPomocCard() {
        super(3, "NADCHODZI POMOC", "Jezeli na koniec swojej tury\n" +
                "masz najmniej SCORE ze wszystkich\ngraczy, zdobywasz 1 SCORE.", CardType.ON_TURN_FINISHED);
    }
}
