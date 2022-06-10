package com.oopfp.focustime;


public class FTCardBtn extends FTButton{
    public FTCardBtn(String word, int fontSize) {
        super(word, fontSize);
        setStyle(
                "-fx-background-color: #FFFFFF; " + "-fx-pref-height: 600px; " + "-fx-pref-width: 1000px;" + "-fx-background-radius: 30px;"
        );
    }
}
