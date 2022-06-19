package com.oopfp.focustime;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

// Deck class that takes title and an array of Card objects
public class Deck {
// Gson name serialization - set key name
    @SerializedName("title")
    private String title;
// Gson name serialization - set key name
    @SerializedName("cards")
//    Association relationship between Deck and Card
//    Deck HAS-A Card object array
    private ArrayList<Card> cards;

// Empty constructor
    public Deck() {
    }

// Constructor with title and array of Card objects
    public Deck(String title, ArrayList<Card> cards){
        this.title = title;
        this.cards = cards;
    }

//    Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

//    Getters
    public String getTitle() {
        return title;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
}
