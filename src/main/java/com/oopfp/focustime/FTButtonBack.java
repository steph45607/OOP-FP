package com.oopfp.focustime;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class FTButtonBack extends FTButton {
    public FTButtonBack(Stage stage) {
        super("<",20);
        setStyle(
                "-fx-background-color: #FFFFFF; " + "-fx-pref-height: 45px; " + "-fx-pref-width: 45px;" + "-fx-background-radius: 30px;"
        );
        setOnAction(e -> Screens.MenuScreen(stage, "Menu"));
    }
    public void withText(String text){
        setText(text);
        setStyle(
                "-fx-background-color: #FFFFFF; " + "-fx-pref-height: 45px; " + "-fx-pref-width: 200px;" + "-fx-background-radius: 30px;"
        );
    }

}
