package com.program.shapedrawer;

import javafx.scene.layout.Pane;

public class ShapeDrawerView {
    private final Pane root;

    public ShapeDrawerView() {
        root = new Pane();
    }

    public Pane getRoot() {
        return root;
    }
}
