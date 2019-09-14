package com.monsters.gui;

import com.monsters.core.model.Monster;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MonsterView {
    VBox box;
    Label nameLabel;
    Label scoreLabel;
    Label lifeLabel;
    Label powerLabel;

    Monster monster;

    public MonsterView(VBox box, Label monsterName, Label monsterScore, Label monsterLife, Label monsterPower) {
        this.box = box;
        this.nameLabel = monsterName;
        this.scoreLabel = monsterScore;
        this.lifeLabel = monsterLife;
        this.powerLabel = monsterPower;
    }
    
    public void bindMonster(Monster monster) {
        this.monster = monster;

        nameLabel.setText(monster.name);
        scoreLabel.setText("score: " + monster.score);
        lifeLabel.setText("life: " + monster.life);
        powerLabel.setText("power: " + monster.power);
    }
}
