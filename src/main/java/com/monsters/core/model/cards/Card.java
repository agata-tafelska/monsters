package com.monsters.core.model.cards;

import com.monsters.core.model.GameState;
import com.monsters.core.model.Turn;

public abstract class Card {
    public int price;
    public String title;
    public String description;
    public CardType type;

    public Card(int price, String title, String description, CardType type) {
        this.price = price;
        this.title = title;
        this.description = description;
        this.type = type;
    }

    public abstract void performAction(GameState gameState);
}
