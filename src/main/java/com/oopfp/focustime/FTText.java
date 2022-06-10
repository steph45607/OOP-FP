package com.oopfp.focustime;

import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class FTText extends Text {

    public FTText(String text, int fontSize){
        super(text);
        setFont(Font.font("Inter", fontSize));
    }

}
