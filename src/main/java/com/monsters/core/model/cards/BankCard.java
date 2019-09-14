package com.monsters.core.model.cards;

public class BankCard {
    private Card card;
    private boolean isAffordable;

    public BankCard(Card card, boolean isAffordable) {
        this.card = card;
        this.isAffordable = isAffordable;
    }

    public Card getCard() {
        return card;
    }

    public boolean isAffordable() {
        return isAffordable;
    }
}
