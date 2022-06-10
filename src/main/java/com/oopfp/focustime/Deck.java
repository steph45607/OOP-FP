package com.oopfp.focustime;


import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class Deck {

    @SerializedName("title")
    private String title;
    @SerializedName("cards")
    private ArrayList<Card> cards;

    public Deck() {
    }

    public Deck(String title, ArrayList<Card> cards){
        this.title = title;
        this.cards = cards;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
}
