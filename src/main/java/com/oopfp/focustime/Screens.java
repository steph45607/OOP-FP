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
    public static void MenuScreen(Stage stage, String name){
        Label userName = new Label(name);
        userName.setFont(Font.font("Inter", 96));

        FTButton timerBtn = new FTButton("Timer", 32);
        timerBtn.setOnAction(e -> Timer.show());

        FTButton cardBtn = new FTButton("FlashCard", 32);
        cardBtn.setOnAction(e -> {
            try {
                CardScreen(stage);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        FTButton formulaBtn = new FTButton("Formula", 32);
        formulaBtn.setOnAction(e -> FormulaScreen(stage));

        HBox buttons = new HBox(20);
        buttons.setAlignment(Pos.CENTER);
        buttons.getChildren().addAll(timerBtn, cardBtn, formulaBtn);

        VBox mainlayout = new VBox(40);
        mainlayout.setAlignment(Pos.CENTER);
        mainlayout.getChildren().addAll(userName, buttons);

        FTScene scene2 = new FTScene(mainlayout);
        stage.setScene(scene2);
    }

    public static void CardScreen(Stage stage) throws IOException {
        stage.setTitle("FocusTime - Flashcard");

        Label title = new Label("FlashCard");
        title.setFont(Font.font("Inter", 80));
        title.setLayoutX(550);
        title.setLayoutY(30);


        Text direction = new Text("Click card deck to learn");
        direction.setFont(Font.font("Inter", 20));
        direction.setLayoutX(630);
        direction.setLayoutY(140);

        FTButtonBack backBtn = new FTButtonBack(stage);
        backBtn.setLayoutX(50);
        backBtn.setLayoutY(50);

        FTButton createBtn = new FTButton("+ Create", 20);
        createBtn.setLayoutX(1200);
        createBtn.setLayoutY(50);
        createBtn.setOnAction(e -> createDeck(stage));

        Pane navbar = new Pane();
        navbar.getChildren().addAll(createBtn, backBtn, title, direction);

        VBox decks = new VBox(20);
        decks.setAlignment(Pos.CENTER);

        ArrayList<FTButton> array = Methods.loadDeckLib(stage);
        for (FTButton ftButton : array) {
            decks.getChildren().add(ftButton);
        }

        VBox layout = new VBox(40);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(navbar, decks);

        FTScene scene = new FTScene(layout);
        stage.setScene(scene);

    }

    public static void createDeck(Stage stage){
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

        FTButton cancelBtn = new FTButton("Cancel", 20);
        cancelBtn.setOnAction(e -> {
            cards.clear();
            try {
                Screens.CardScreen(stage);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        FTButton addBtn = new FTButton("+ add", 20);
        addBtn.setOnAction(e -> {
            cards.add(new Card(frontInput.getText(), backInput.getText()));
            frontInput.clear();
            backInput.clear();
        });

        FTButton doneBtn = new FTButton("Done", 20);
        doneBtn.setOnAction(e -> {
            if(deckNameInput.getText() == null || deckNameInput.getText().trim().isEmpty()){
                PopUp.show("Input error", "Deck name can't be empty", "Ok");
            }else{
                try {
                    Methods.doneCreating(deckNameInput.getText(), cards, stage);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
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

    public static void LearnScreen(Stage stage, String title, ArrayList<Card> list){
        stage.setTitle("FocusTime - Learn Flashcards");

        Label deckName = new Label(title);
        deckName.setFont(Font.font("Inter", 50));

        ListIterator<Card> i = list.listIterator();

        AtomicReference<Card> card = new AtomicReference<>(list.get(0));

        String show = card.get().getFront();
        FTCardBtn cardBtn = new FTCardBtn(show, 30);
        cardBtn.setOnAction(e -> {
            if(Objects.equals(cardBtn.getText(), card.get().getFront())){
                cardBtn.setText(card.get().getBack());
            }else{
                cardBtn.setText(card.get().getFront());
            }
        });

        FTButton prevWord = new FTButton("<", 20);
        prevWord.round();
        prevWord.setOnAction(e -> {
            if(i.hasPrevious()){
                card.set(i.previous());
                cardBtn.setText(card.get().getFront());
            }else{
                PopUp.show("Beginning of the deck", "This is the first card.", "Ok");
            }
        });

        FTButton nextWord = new FTButton(">", 20);
        nextWord.round();
        nextWord.setOnAction(e -> {
            if(i.hasNext()){
                card.set(i.next());
                cardBtn.setText(card.get().getFront());
            }else{
                PopUp.show("End of the deck", "This is the last card. Congratulations!", "Ok");            }
        });

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

    public static void FormulaScreen(Stage stage){
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

        FTButton jargonBtn = new FTButton("Jargon", 20);
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
