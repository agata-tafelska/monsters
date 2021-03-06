package com.monsters.core.model;

public class DiceResult {
    public boolean isSelected;
    public DiceResultType type;

    public DiceResult(DiceResultType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type.toString();
    }
}
