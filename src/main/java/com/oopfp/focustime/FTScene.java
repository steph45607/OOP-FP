package com.oopfp.focustime;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

// FTScene to set the scene to my styling
// Prevent repetition
public class FTScene extends Scene {
//    Set initial / default width and height
    static int width = 1440;
    static int height = 900;

//    Constructor with default attribute
    public FTScene(VBox layout){
        super(layout, width, height);
//        Fill in the scene with color
        setFill(Color.web("#B2D7E2"));
//        Set the background the same color and also make CornerRadii and Insets empty
//        CornerRadii.EMPTY - to make the radius to 0, therefore square window
//        Inets.EMPTY - set the all offset inside the window to 0
        layout.setBackground(new Background(new BackgroundFill(Color.web("#B2D7E2"), CornerRadii.EMPTY, Insets.EMPTY)));
    }
//    Constructor with attributes
    public FTScene(VBox layout, int width, int height){
        super(layout, width, height);
        setFill(Color.web("#B2D7E2"));
        layout.setBackground(new Background(new BackgroundFill(Color.web("#B2D7E2"), CornerRadii.EMPTY, Insets.EMPTY)));
    }

}