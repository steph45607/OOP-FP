package com.oopfp.focustime;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Welcome extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("FocusTime");

        Label welcomeText = new Label("Welcome to FocusTime");
        welcomeText.setFont(Font.font("Inter", 96));

        Label descText = new Label("Your one stop focus center");
        descText.setFont(Font.font("Inter", 20));

        Label labelName = new Label("Name: ");
        TextField input = new TextField();
        input.minWidth(40);
        labelName.setFont(Font.font("Inter", 32));

        FTButton btn = new FTButton("Enter", 32);
        btn.setOnAction(e -> {
            if(input.getText() == null || input.getText().trim().isEmpty()){
                PopUp.show("Input error", "Name can't be empty", "Ok");
            }else{
                Screens.MenuScreen(stage, Methods.randomGreet() + input.getText());
            }
        });

        HBox inputName = new HBox();
        inputName.getChildren().addAll(labelName, input);
        inputName.setAlignment(Pos.CENTER);

        VBox layout = new VBox(10);
        layout.getChildren().addAll(welcomeText, descText, inputName, btn);

        layout.setAlignment(Pos.CENTER);

        FTScene scene = new FTScene(layout);
        stage.setScene(scene);
        stage.setResizable(false);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}