package com.oopfp.focustime;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.kordamp.ikonli.javafx.FontIcon;

public class FTButton extends Button{

    public FTButton(String text, int fontSize){
        super(text);
        setFont(Font.font("Inter", fontSize));
        setWrapText(true);
        setStyle(
                "-fx-background-color: #FFFFFF; " + "-fx-pref-height: 45px; " + "-fx-pref-width: 200px;" + "-fx-background-radius: 30px;"
        );
        setCursor(Cursor.HAND);
    }

    public void round(){
        setStyle(
                "-fx-background-color: #FFFFFF; " + "-fx-pref-height: 45px; " + "-fx-pref-width: 45px;" + "-fx-background-radius: 30px;"
        );
    }

}
