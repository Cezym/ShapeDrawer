package com.program.shapedrawer;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;

public class ShapeDrawerController {
    private ShapeDrawerView view;
    private ShapeDrawerModel model;
    private Pane root;
    private Stage stage;
    private File file;

    public ShapeDrawerController(ShapeDrawerView view, ShapeDrawerModel model, Stage stage, Pane root) {
        this.view = view;
        this.model = model;
        this.stage = stage;
        this.root = root;
    }

    public void initView() {
        model.getFileChooser().setTitle("Otworz plik tekstowy z danymi");
        file = model.getFileChooser().showOpenDialog(stage);
    }

    public void initController() {
        model.setFile(file);
        model.setRoot(root);
        model.readAndDraw();
    }
}
