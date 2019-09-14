package com.monsters.core.model.cards.zatrzymaj_bez_interakcji;

import com.monsters.core.Logger;
import com.monsters.core.model.DiceResult;
import com.monsters.core.model.DiceResultType;
import com.monsters.core.model.GameState;
import com.monsters.core.model.Monster;
import com.monsters.core.model.cards.CardType;
import com.monsters.core.model.cards.ZatrzymajBezInterakcjiCard;

public class NiszczacyOddechZatrzymajBezInterakcjiCard extends ZatrzymajBezInterakcjiCard {

    @Override
    public void performAction(GameState gameState) {
        int attackResultCount = 0;
        for (DiceResult result : gameState.finalCubesResults) {
            if (result.type == DiceResultType.ATTACK) {
                attackResultCount++;
            }
        }
        if (gameState.whoseTurn != gameState.whoIsInTokyo) {
            for (Monster monster : gameState.monsters) {
                if (monster != gameState.whoseTurn && monster != gameState.whoIsInTokyo) {
                    monster.life -= attackResultCount;
                }
            }
        }

    }
    public NiszczacyOddechZatrzymajBezInterakcjiCard() {
        super(7, "NISZCZACY ODDECH", "Kiedy wyrzucisz ATTACK, zadajesz\n" +
                "obrazenia wszystkim graczom\n(niezaleznie od tego czy jestes\n" +
                "w Tokio, czy poza nim).", CardType.ZATRZYMAJ_BEZ_INTERAKCJI);
    }

}
