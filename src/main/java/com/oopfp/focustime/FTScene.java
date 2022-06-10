package com.oopfp.focustime;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class FTScene extends Scene {
    static int width = 1440;
    static int height = 900;

    public FTScene(VBox layout){
        super(layout, width, height);
        setFill(Color.web("#B2D7E2"));
        layout.setBackground(new Background(new BackgroundFill(Color.web("#B2D7E2"), CornerRadii.EMPTY, Insets.EMPTY)));
    }
    public FTScene(VBox layout, int width, int height){
        super(layout, width, height);
        setFill(Color.web("#B2D7E2"));
        layout.setBackground(new Background(new BackgroundFill(Color.web("#B2D7E2"), CornerRadii.EMPTY, Insets.EMPTY)));
    }

}