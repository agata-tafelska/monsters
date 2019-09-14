package com.monsters.core.model.cards;

public abstract class OnTurnFinishedCard extends Card{
    public OnTurnFinishedCard(int price, String title, String description, CardType type) {
        super(price, title, description, type);
    }
}
