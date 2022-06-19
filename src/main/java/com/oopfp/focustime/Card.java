package com.oopfp.focustime;

import com.google.gson.annotations.SerializedName;

// Card class for every individual card stored in an array in Deck
// has two attributes, front and back - reflect the sides
public class Card {
// Gson name serialization - set key name
    @SerializedName("front")
    private String front;
// Gson name serialization - set key name
    @SerializedName("back")
    private String back;

//    Empty constructor - allow create Card object without initial values
    public Card() {
    }

//    Constructor with initializer
    public Card(String front, String back){
        this.front = front;
        this.back = back;
    }

//    Setters
    public void setFront(String front) {
        this.front = front;
    }

    public void setBack(String back) {
        this.back = back;
    }

//    Getters
    public String getFront() {
        return front;
    }

    public String getBack() {
        return back;
    }
}

