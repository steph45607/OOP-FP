package com.oopfp.focustime;

import javafx.stage.Stage;

// Inherit the same methods from FTButton
// Use the superclass attribute - text and fontSize
public class FTButtonBack extends FTButton {
    public FTButtonBack(Stage stage) {
        super("<",20);
        setStyle(
                "-fx-background-color: #FFFFFF; " + "-fx-pref-height: 45px; " + "-fx-pref-width: 45px;" + "-fx-background-radius: 30px;"
        );
//        When clicked, go to MenuScreen
        setOnAction(e -> Screens.MenuScreen(stage, "Welcome Back!"));
    }
//    Method to set a back button but instead of '<' can set to other text
//    Used for 'Done' button in learnCards screen
    public void withText(String text){
//        Set the button text - inherited from Button class
        setText(text);
        setStyle(
                "-fx-background-color: #FFFFFF; " + "-fx-pref-height: 45px; " + "-fx-pref-width: 200px;" + "-fx-background-radius: 30px;"
        );
    }

}
