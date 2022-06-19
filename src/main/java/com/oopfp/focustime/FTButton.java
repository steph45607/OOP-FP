package com.oopfp.focustime;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.text.Font;

// FTButton inherit the methods from Javafx Button object
public class FTButton extends Button{
// Constructor with text and fontSize attributes
    public FTButton(String text, int fontSize){
//        Super class to set the text to the text attribute from Button class
        super(text);
//        Set the text font to "Inter" font and desired fontSize
        setFont(Font.font("Inter", fontSize));
//        Set the text to wrap inside the button
        setWrapText(true);
//        Button styling - background color, height and width, border radius
        setStyle(
                "-fx-background-color: #FFFFFF; " + "-fx-pref-height: 45px; " + "-fx-pref-width: 200px;" + "-fx-background-radius: 30px;"
        );
//        When hovered, pointer change to hand pointer
        setCursor(Cursor.HAND);
    }

//    Method to change button to a 1:1 round button
    public void round(){
        setStyle(
                "-fx-background-color: #FFFFFF; " + "-fx-pref-height: 45px; " + "-fx-pref-width: 45px;" + "-fx-background-radius: 30px;"
        );
    }

}
