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

//    Method to randomly use greetings from the greetings list in storage
    public static String randomGreet(){
//        Random class initialized
        Random random = new Random();
//        Get the length of list, set to max
        int max = Storage.greetings.length;
//        Use max as end range for random
        int numRand = random.nextInt(max);
//        Return the greeting from the list based on random
        return Storage.greetings[numRand];
    }

//    Method to load the deck to show in the library
    public static ArrayList<FTButton> loadDeckLib(Stage stage) throws IOException {
//        Use gson package
        Gson gson = new Gson();
//        User reader to read the json file
        Reader read = Files.newBufferedReader(Paths.get("decks.json"));
//        Initialized an arrayList to store FTButton objects
        ArrayList<FTButton> allDeck = new ArrayList<>();

//        Create a json array and convert json from the file to jsonArray
        JsonArray array = gson.fromJson(read, JsonArray.class);
//        To check if the array is empty
        if(array == null){
//            Return allDeck Arraylist
//            Which an empty arrayList - will display nothing
            return allDeck;
//        When the array is not empty
        }else{
//            For loop through the json array
            for(int i = 0 ; i <array.size();i++){
//                Initialized ArrayList for Card objects
                ArrayList<Card> cardArr = new ArrayList<>();
//                JsonArray for cardList  - listing all the card in a deck - front and back
                JsonArray cardList = (JsonArray) ((JsonObject) array.get(i)).get("cards");
//                For loop through the cardList json array
                for(int j = 0; j < cardList.size(); j++){
//                    Make it as an object with the name cards, for each front-back card
                    JsonObject cards = (JsonObject) cardList.get(j);
//                    Get the value of the front key of Card object - access using json methods
//                    replaceAll used to get rid of the " mark at the beginning and end
                    String front = String.valueOf(cards.get("front")).replaceAll("^\"|\"$", "");
//                    Get the value of the back key of Card object - access using json methods
                    String back = String.valueOf(cards.get("back")).replaceAll("^\"|\"$", "");
//                    Create a card object with the front and back value from json
                    Card card = new Card(front, back);
//                    Add the card object to the cardArr
                    cardArr.add(card);
                }

//                Get the value of the name key of Deck object - access using json method
                String name = String.valueOf(((JsonObject)array.get(i)).get("title")).replaceAll("^\"|\"$", "");
//                Create a button with deck's name
                FTButton btn = new FTButton(name, 20);
//                Create a Deck object with name from json and cardArr for Card objects array
                Deck deck = new Deck(name, cardArr);
//                Set the button to go to LearnScreen screen with the stage and deck object parameter
                btn.setOnAction(e -> Screens.LearnScreen(stage, deck));
//                Add the button to the button collection that will be displayed called allDeck
                allDeck.add(btn);
            }
        }
//        Return allDeck, to display all the deck buttons
        return allDeck;
        }

//    Method to store just made Deck to json file
    public static void doneCreating(Deck deck, Stage stage) throws IOException {
//        Initialize gsonBuilder object with format (from setPrettyPrinting())
        Gson database = new GsonBuilder().setPrettyPrinting().create();

//        Create Type data type variable to get the return of a list of Deck data type
        Type listType = new TypeToken<List<Deck>>(){}.getType();
//        FileReader to read the "decks.json" file
        FileReader reader = new FileReader("decks.json");
//        Create a list of Deck from the reader and based it on the type return from listType
        List<Deck> deckList = database.fromJson(reader, listType);
//        Close the reader
        reader.close();

//        Check if deckList is empty
        if(deckList == null){
            deckList = new ArrayList<>();
        }

//        Add deck from userInput to deckList list
        deckList.add(deck);
//        Create a file writer named writer with the target to "decks.json" file
        FileWriter writer = new FileWriter("decks.json");
//        Write a json to the file, with the value from deckList
        database.toJson(deckList, writer);
//        Close the writer
        writer.close();

//        Go to the CardScreen screen with passed stage attribute
        Screens.CardScreen(stage);
    }

//    Method to return the square result, allow to print it to the screen
//    Run the passed Square object
    public static String calculate(Square square){
        return square.resultPrint();
    }
//    All the same method, but different passed attribute
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
