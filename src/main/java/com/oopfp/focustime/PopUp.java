package com.oopfp.focustime;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class PopUp {

//   Method to pop up the window
//   title - set window title
//   message - set the display message, or prompt
//   btnText - set the button text
    public static void show(String title, String message, String btnText){
//        Create a window
        Stage window = new Stage();
//        Disable the application to run without exiting this stage
        window.initModality(Modality.APPLICATION_MODAL);
//        Set window dimension
        window.setMinWidth(500);
        window.setMinHeight(350);
//        Set window title
        window.setTitle(title);

//        Create text that will display the message inside the window
        FTText text = new FTText(message, 20);
//        Set the size of wrap for the text
        text.setWrappingWidth(450);
//        Set the text to middle, and align center
        text.setTextAlignment(TextAlignment.CENTER);

//        Create a button with passed btnText and font 15
        FTButton btn = new FTButton(btnText,15);
//        Set the function of the button to close the window
        btn.setOnAction(e -> window.close());

//        Vertical layout to set all the elements
        VBox layout = new VBox(20);
        layout.getChildren().addAll(text, btn);
        layout.setAlignment(Pos.CENTER);

//        Set color, corner radius, and insets
        layout.setBackground(new Background(new BackgroundFill(Color.web("#B2D7E2"), CornerRadii.EMPTY, Insets.EMPTY)));

//        Create a scene for the layout
        FTScene scene = new FTScene(layout, 500, 350);
//        Set scene to the window
        window.setScene(scene);
        window.showAndWait();
    }
}