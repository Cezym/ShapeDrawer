package com.program.shapedrawer;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ShapeDrawerModel {
    private final FileChooser fileChooser;
    private File file;
    private Pane root;

    public ShapeDrawerModel() {
        fileChooser = new FileChooser();
    }

    public FileChooser getFileChooser() {
        return fileChooser;
    }

    public void setFile(File file) {
        this.file = file;
    }

    private Shape getFigure(String line) {
        Integer[] x = new Integer[3];

        int j = -1;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == ' ') {
                x[++j] = i;
            }
        }

        if (x[2] != null)
            return new Rectangle(
                    Double.parseDouble(line.substring(0, x[0])),
                    Double.parseDouble(line.substring(x[0], x[1])),
                    Double.parseDouble(line.substring(x[1], x[2])),
                    Double.parseDouble(line.substring(x[2])));

        return new Circle(
                Double.parseDouble(line.substring(0, x[0])),
                Double.parseDouble(line.substring(x[0], x[1])),
                Double.parseDouble(line.substring(x[1])),
                Color.TRANSPARENT);
    }

    public void readAndDraw() {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String regexRectangle = "^(-{0,1}[0-9]+ ){3}[0-9]+$";
                String regexCircle = "^(-{0,1}[0-9]+ ){2}[0-9]+$";
                if ((line.matches(regexRectangle) || line.matches(regexCircle))) {
                    Shape shape = getFigure(line);
                    Color color = new Color(Math.random(), Math.random(), Math.random(), 1D);
                    if (shape instanceof Rectangle rec) {
                        rec.setFill(color);
                        rec.setStroke(color);
                        root.getChildren().add(rec);
                    } else if (shape instanceof Circle cir) {
                        cir.setStroke(color);
                        root.getChildren().add(cir);
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        root.autosize();
    }


    public void setRoot(Pane root) {
        this.root = root;
    }
}
