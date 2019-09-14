package com.monsters.core.model.cards.on_turn_finished_cards;

import com.monsters.core.model.DiceResult;
import com.monsters.core.model.DiceResultType;
import com.monsters.core.model.GameState;
import com.monsters.core.model.cards.CardType;
import com.monsters.core.model.cards.OnTurnFinishedCard;

public class WegetarianinCard extends OnTurnFinishedCard {
    @Override
    public void performAction(GameState gameState) {
        int attackCount = 0;
        for (DiceResult result : gameState.finalCubesResults) {
            if(result.type == DiceResultType.ATTACK) {
                attackCount++;
            }
        }
        if (attackCount == 0 || gameState.whoIsInTokyo == null) {
            gameState.whoseTurn.score += 1;
        }
    }

    public WegetarianinCard() {
        super(5, "WEGETARIANIN", "Zdobywasz 1 SCORE po turze,\n" +
                "w ktorej nie zadales nikomu obrazenia.", CardType.ON_TURN_FINISHED);
    }
}
