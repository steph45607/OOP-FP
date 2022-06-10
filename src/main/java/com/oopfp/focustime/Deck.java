package com.oopfp.focustime;


import com.google.gson.annotations.SerializedName;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Deck {

    @SerializedName("title")
    private String title;
    @SerializedName("cards")
    private ArrayList<Card> cards;

    public Deck(String title, ArrayList<Card> cards){
        this.title = title;
        this.cards = cards;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }


    public String getTitle() {
        return title;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }


    public void setTitle(String title) {
        this.title = title;
    }


}
