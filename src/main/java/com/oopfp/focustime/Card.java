package com.oopfp.focustime;

import com.google.gson.annotations.SerializedName;

public class Card {
    @SerializedName("front")
    private String front;
    @SerializedName("back")
    private String back;

    public Card() {
    }

    public Card(String front, String back){
        this.front = front;
        this.back = back;
    }

    public void setFront(String front) {
        this.front = front;
    }

    public void setBack(String back) {
        this.back = back;
    }

    public String getFront() {
        return front;
    }

    public String getBack() {
        return back;
    }
}

