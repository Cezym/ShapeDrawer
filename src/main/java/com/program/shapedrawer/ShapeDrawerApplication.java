package com.program.shapedrawer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ShapeDrawerApplication extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        ShapeDrawerView view = new ShapeDrawerView();
        ShapeDrawerModel model = new ShapeDrawerModel();
        ShapeDrawerController controller = new ShapeDrawerController(view, model, stage, view.getRoot());
        controller.initView();
        controller.initController();
        Scene scene = new Scene(view.getRoot());
        stage.setTitle("Rysowanie okregow i prostokatow");
        stage.setScene(scene);
        stage.show();
    }
}
