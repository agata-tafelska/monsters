package com.monsters.gui;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;

import java.awt.*;

public class MonstersCard {
    ScrollPane pane;
    Label label;

    public MonstersCard(ScrollPane pane, Label label) {
        this.pane = pane;
        this.label = label;
    }
}
