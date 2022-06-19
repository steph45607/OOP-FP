package com.oopfp.focustime;


public class FTCardBtn extends FTButton{
//    Inherit the constructor
    public FTCardBtn(String word, int fontSize) {
//        From the superclass constructor method
        super(word, fontSize);
//        Set the Button size to fit the window to look like a card
        setStyle(
                "-fx-background-color: #FFFFFF; " + "-fx-pref-height: 600px; " + "-fx-pref-width: 1000px;" + "-fx-background-radius: 30px;"
        );
    }
}
