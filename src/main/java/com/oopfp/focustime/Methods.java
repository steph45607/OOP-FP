package com.oopfp.focustime;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import javafx.stage.Stage;

public class Methods {

    public static String randomGreet(){
        Random random = new Random();
        int max = Storage.greetings.length;
        int numRand = random.nextInt(max);
        return Storage.greetings[numRand];
    }

    public static ArrayList<FTButton> loadDeckLib(Stage stage) throws IOException {
        Gson gson = new Gson();
        Reader read = Files.newBufferedReader(Paths.get("decks.json"));
        ArrayList<FTButton> allDeck = new ArrayList<>();

        JsonArray array = gson.fromJson(read, JsonArray.class);
        if(array == null){
            return allDeck;
        }else{
            for(int i = 0 ; i <array.size();i++){
                ArrayList<Card> cardArr = new ArrayList<>();
                JsonArray cardList = (JsonArray) ((JsonObject) array.get(i)).get("cards");
                for(int j = 0; j < cardList.size(); j++){
                    JsonObject cards = (JsonObject) cardList.get(j);
                    String front = String.valueOf(cards.get("front")).replaceAll("^\"|\"$", "");
                    String back = String.valueOf(cards.get("back")).replaceAll("^\"|\"$", "");
                    Card card = new Card(front, back);
                    cardArr.add(card);
                }
                String name = String.valueOf(((JsonObject)array.get(i)).get("title")).replaceAll("^\"|\"$", "");
                FTButton btn = new FTButton(name, 20);
                btn.setOnAction(e -> Screens.LearnScreen(stage, name, cardArr));
                allDeck.add(btn);
            }
        }
        return allDeck;
        }

    public static void doneCreating(Deck deck, Stage stage) throws IOException {
        Gson database = new GsonBuilder().setPrettyPrinting().create();

        Type listType = new TypeToken<List<Deck>>(){}.getType();
        FileReader reader = new FileReader("decks.json");
        List<Deck> deckList = database.fromJson(reader, listType);
        reader.close();

        if(null == deckList){
            deckList = new ArrayList<>();
        }

        deckList.add(deck);
        FileWriter writer = new FileWriter("decks.json");
        database.toJson(deckList, writer);
        writer.close();

        Screens.CardScreen(stage);
    }

    public static String calculate(Square square){
        return square.resultPrint();
    }
    public static String calculate(Triangle triangle){
        return triangle.resultPrint();
    }
    public static String calculate(Circle circle){
        return circle.resultPrint();
    }
    public static String calculate(Parallelogram parallelogram){
        return parallelogram.resultPrint();
    }




}
