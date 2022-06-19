package com.oopfp.focustime;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class Screens{
//    Menu Screen - welcome and name input
    public static void MenuScreen(Stage stage, String name){
//        Display the name to the window
        Label userName = new Label(name);
//        Set the font and size
        userName.setFont(Font.font("Inter", 96));

//        Create Timer button, when clicked, display the Timer Popup
        FTButton timerBtn = new FTButton("Timer", 32);
        timerBtn.setOnAction(e -> {
//            Create a Timer object - allow multiple timer to run at the same time
            Timer timer = new Timer();
//            Display the timer window
            timer.show();
        });

//        Crate FlashCard button, when clicked, go to CardScreen display
        FTButton cardBtn = new FTButton("FlashCard", 32);
        cardBtn.setOnAction(e -> {
            try {
                CardScreen(stage);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

//        Create Booklet button, when clicked, go to BookletScreen display
        FTButton bookletBtn = new FTButton("Booklet", 32);
        bookletBtn.setOnAction(e -> BookletScreen(stage));

//        All buttons set in a horizontal layout
        HBox buttons = new HBox(20);
        buttons.setAlignment(Pos.CENTER);
        buttons.getChildren().addAll(timerBtn, cardBtn, bookletBtn);

//        Vertical layout for all elements
        VBox layout = new VBox(40);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(userName, buttons);

//        Set the scene to the stage
        FTScene scene2 = new FTScene(layout);
        stage.setScene(scene2);
    }

//    CardScreen - display  collection of deck cards
    public static void CardScreen(Stage stage) throws IOException {
        stage.setTitle("FocusTime - Flashcard");

        Label title = new Label("FlashCard");
        title.setFont(Font.font("Inter", 80));
        title.setLayoutX(550);
        title.setLayoutY(30);
//        Show direction to navigate
        Text direction = new Text("Click card deck to learn");
        direction.setFont(Font.font("Inter", 20));
        direction.setLayoutX(630);
        direction.setLayoutY(140);

//        Back button to the main menu
        FTButtonBack backBtn = new FTButtonBack(stage);
        backBtn.setLayoutX(50);
        backBtn.setLayoutY(50);

//        To create deck
        FTButton createBtn = new FTButton("+ Create", 20);
        createBtn.setLayoutX(1200);
        createBtn.setLayoutY(50);
//        To createDeck display
        createBtn.setOnAction(e -> createDeck(stage));

//        Pane - easier to use x and y to plot the position of elements
        Pane navbar = new Pane();
        navbar.getChildren().addAll(createBtn, backBtn, title, direction);

        VBox decks = new VBox(20);
        decks.setAlignment(Pos.CENTER);

//        The returned value from loadDeckLib will be displayed here
//        Assign the array returned to an array and use for loop to
//        create button for each element
        ArrayList<FTButton> array = Methods.loadDeckLib(stage);
        for (FTButton ftButton : array) {
//            Display the buttons in Vbox layout
            decks.getChildren().add(ftButton);
        }

        VBox layout = new VBox(40);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(navbar, decks);

        FTScene scene = new FTScene(layout);
        stage.setScene(scene);

    }

//    CreateDeck - screen to create own deck
    public static void createDeck(Stage stage){
//        Create Deck object
        Deck deck = new Deck();
//        Create list of Card object
        ArrayList<Card> cards = new ArrayList<>();

        stage.setTitle("FocusTime - Create Deck");

        Label title = new Label("Create Deck");
        title.setFont(Font.font("Inter", 80));

        FTText deckName = new FTText("Deck name:", 20);
        TextField deckNameInput = new TextField();
        deckNameInput.minWidth(40);

        FTText frontLabel = new FTText("Front:", 20);
        TextField frontInput = new TextField();
        frontInput.minWidth(40);

        FTText backLabel = new FTText("Back:", 20);
        TextField backInput = new TextField();
        backInput.minWidth(40);

//        Empty the array and go back to the CardScreen display
        FTButton cancelBtn = new FTButton("Cancel", 20);
        cancelBtn.setOnAction(e -> {
            cards.clear();
            try {
                Screens.CardScreen(stage);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

//        Add button, append Card objects to the array
        FTButton addBtn = new FTButton("+ add", 20);
        addBtn.setOnAction(e -> {
            Card card = new Card();
            card.setFront(frontInput.getText());
            card.setBack(backInput.getText());
            cards.add(card);
//            Clear the inputField
            frontInput.clear();
            backInput.clear();
        });

//        Done button, set Deck title and cardArray, and append to the json using doneCreating()
        FTButton doneBtn = new FTButton("Done", 20);
        doneBtn.setOnAction(e -> {
//            Pop up if name is empty
            if(deckNameInput.getText() == null || deckNameInput.getText().trim().isEmpty()){
                PopUp.show("Input error", "Deck name can't be empty", "Ok");
            }else{
                try {
                    deck.setTitle(deckNameInput.getText());
                    deck.setCards(cards);
                    Methods.doneCreating(deck, stage);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

//        Back button to main menu
        FTButton backBtn = new FTButtonBack(stage);
        backBtn.setOnAction(e -> {
            cards.clear();
            try {
                Screens.CardScreen(stage);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        backBtn.setLayoutX(550);

        VBox front = new VBox();
        front.setAlignment(Pos.CENTER);
        front.getChildren().addAll(frontLabel, frontInput);

        VBox back = new VBox();
        back.setAlignment(Pos.CENTER);
        back.getChildren().addAll(backLabel, backInput);

        HBox name = new HBox();
        name.setAlignment(Pos.CENTER);
        name.getChildren().addAll(deckName, deckNameInput);

        HBox cardInput = new HBox(50);
        cardInput.setAlignment(Pos.CENTER);
        cardInput.getChildren().addAll(front, back);

        HBox buttons = new HBox(40);
        buttons.setAlignment(Pos.CENTER);
        buttons.getChildren().addAll(cancelBtn, doneBtn);

        VBox navbar = new VBox(30);
        navbar.setAlignment(Pos.TOP_LEFT);
        navbar.getChildren().add(backBtn);

        VBox layout = new VBox(30);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(navbar, title, name, cardInput, addBtn, buttons);
        VBox.setMargin(navbar, new Insets(20));

        FTScene scene = new FTScene(layout);
        stage.setScene(scene);
    }

//    LearnScreen has a big button act as a card that can be flipped, to learn the chosen deck
    public static void LearnScreen(Stage stage, Deck deck){
        stage.setTitle("FocusTime - Learn Flashcards");

//        Return the deck name using getter
        Label deckName = new Label(deck.getTitle());
        deckName.setFont(Font.font("Inter", 50));

//        Allow iteration through the card array
        ListIterator<Card> i = deck.getCards().listIterator();

//        Object reference that can be updated and changes automatically
        AtomicReference<Card> card = new AtomicReference<>(deck.getCards().get(0));

//        String variable to store the first card front's side
        String show = card.get().getFront();
//        FTCardBtn - object with a big sized button and take superclass of FTButton
        FTCardBtn cardBtn = new FTCardBtn(show, 30);
//        When clicked, change the text to the back or front
        cardBtn.setOnAction(e -> {
            if(Objects.equals(cardBtn.getText(), card.get().getFront())){
                cardBtn.setText(card.get().getBack());
            }else{
                cardBtn.setText(card.get().getFront());
            }
        });

//        Use the iterator and previous button to navigate to the card before
        FTButton prevWord = new FTButton("<", 20);
        prevWord.round();
        prevWord.setOnAction(e -> {
            if(i.hasPrevious()){
                card.set(i.previous());
                cardBtn.setText(card.get().getFront());
            }else{
//                When it's the top of the list, give pop up
                PopUp.show("Beginning of the deck", "This is the first card.", "Ok");
            }
        });

//        Use iterator and next button to navigate to the card after
        FTButton nextWord = new FTButton(">", 20);
        nextWord.round();
        nextWord.setOnAction(e -> {
            if(i.hasNext()){
                card.set(i.next());
                cardBtn.setText(card.get().getFront());
            }else{
                PopUp.show("End of the deck", "This is the last card. Congratulations!", "Ok");            }
        });

//        Done button that act as a back button
        FTButtonBack doneBtn = new FTButtonBack(stage);
        doneBtn.withText("Done");

        HBox mainBtn = new HBox(40);
        mainBtn.setAlignment(Pos.CENTER);
        mainBtn.getChildren().addAll(prevWord, cardBtn, nextWord);

        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(deckName, mainBtn, doneBtn);

        FTScene scene = new FTScene(layout);
        stage.setScene(scene);
    }

//    FormulaScreen - show the subjects for the booklet
    public static void BookletScreen(Stage stage){
        stage.setTitle("FocusTime - Booklet");

        Label title = new Label("Subjects");
        title.setFont(Font.font("Inter", 80));
        title.setLayoutX(550);
        title.setLayoutY(30);

        FTButtonBack backBtn = new FTButtonBack(stage);
        backBtn.setLayoutX(50);
        backBtn.setLayoutY(50);

        Pane navbar = new Pane();
        navbar.getChildren().addAll(backBtn, title);

//        Buttons to go to subject screen
        FTButton englishBtn = new FTButton("English", 20);
        englishBtn.setOnAction(e -> englishScreen(stage));
        FTButton mathBtn = new FTButton("Math", 20);
        mathBtn.setOnAction(e -> mathScreen(stage));

        HBox buttons = new HBox(30);
        buttons.setAlignment(Pos.CENTER);
        buttons.getChildren().addAll(englishBtn, mathBtn);

        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(navbar, buttons);

        FTScene scene = new FTScene(layout);
        stage.setScene(scene);
    }

//    English subject screen
    public static void englishScreen(Stage stage){
        stage.setTitle("FocusTime - English Booklet");

        Label title = new Label("English Lit");
        title.setFont(Font.font("Inter", 80));
        title.setLayoutX(550);
        title.setLayoutY(30);

        FTButtonBack backBtn = new FTButtonBack(stage);
        backBtn.setLayoutX(50);
        backBtn.setLayoutY(50);

        Pane navbar = new Pane();
        navbar.getChildren().addAll(backBtn, title);

//        Different buttons represent the different literary devices
        FTButton jargonBtn = new FTButton("Jargon", 20);
//        Literary devices stored in storage
        jargonBtn.setOnAction(e -> PopUp.show(Storage.jargon.getName(), Storage.jargon.getDesc(), "Ok"));
        FTButton pathosBtn = new FTButton("Pathos", 20);
        pathosBtn.setOnAction(e -> PopUp.show(Storage.pathos.getName(), Storage.pathos.getDesc(), "Ok"));
        FTButton logosBtn = new FTButton("Logos", 20);
        logosBtn.setOnAction(e -> PopUp.show(Storage.logos.getName(), Storage.logos.getDesc(), "Ok"));
        FTButton ethosBtn = new FTButton("Ethos", 20);
        ethosBtn.setOnAction(e -> PopUp.show(Storage.ethos.getName(), Storage.ethos.getDesc(), "Ok"));

        HBox btn1 = new HBox(20);
        btn1.setAlignment(Pos.CENTER);
        btn1.getChildren().addAll(jargonBtn, pathosBtn);

        HBox btn2 = new HBox(20);
        btn2.setAlignment(Pos.CENTER);
        btn2.getChildren().addAll(ethosBtn, logosBtn);

        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(navbar, btn1, btn2);

        FTScene scene = new FTScene(layout);
        stage.setScene(scene);
    }

//    Math subject screen
    public static void mathScreen(Stage stage){
        stage.setTitle("FocusTime - Math Booklet");

        Label title = new Label("Mathematics");
        title.setFont(Font.font("Inter", 80));
        title.setLayoutX(550);
        title.setLayoutY(30);

        FTButtonBack backBtn = new FTButtonBack(stage);
        backBtn.setLayoutX(50);
        backBtn.setLayoutY(50);

        Pane navbar = new Pane();
        navbar.getChildren().addAll(backBtn, title);

//        Different buttons for different shapes
        FTButton squareBtn = new FTButton("Square", 20);
        squareBtn.setOnAction(e -> MathPopUp.calcSquare());
        FTButton triangleBtn = new FTButton("Triangle", 20);
        triangleBtn.setOnAction(e -> MathPopUp.calcTriangle());
        FTButton circleBtn = new FTButton("Circle", 20);
        circleBtn.setOnAction(e -> MathPopUp.calcCircle());
        FTButton parallelogramBtn = new FTButton("Parallelogram", 20);
        parallelogramBtn.setOnAction(e -> MathPopUp.calcParallelogram());

        HBox btn1 = new HBox(20);
        btn1.setAlignment(Pos.CENTER);
        btn1.getChildren().addAll(squareBtn, triangleBtn);

        HBox btn2 = new HBox(20);
        btn2.setAlignment(Pos.CENTER);
        btn2.getChildren().addAll(circleBtn, parallelogramBtn);

        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(navbar, btn1, btn2);

        FTScene scene = new FTScene(layout);
        stage.setScene(scene);
    }

}
