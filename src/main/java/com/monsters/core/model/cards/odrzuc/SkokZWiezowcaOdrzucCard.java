package com.monsters.core.model.cards.odrzuc;

import com.monsters.core.Logger;
import com.monsters.core.model.GameState;
import com.monsters.core.model.cards.CardType;
import com.monsters.core.model.cards.OdrzucCard;

public class SkokZWiezowcaOdrzucCard extends OdrzucCard {
    @Override
    public void performAction(GameState gameState) {
        gameState.whoseTurn.score += 2;
        gameState.whoIsInTokyo = gameState.whoseTurn;
        Logger.d("Skok z wiezowca action");
    }

    public SkokZWiezowcaOdrzucCard() {
        super(5, "SKOK Z WIEZOWCA", "+2 score i wchodzisz do Tokyo\n(jezeli jestes poza Tokyo).", CardType.ODRZUC);
    }
}
