package com.oopfp.focustime;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class PopUp {

    public static void show(String title, String message, String btnText){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(500);
        window.setMinHeight(350);
        window.setTitle(title);

        Text text = new Text(message);
        text.setFont(Font.font("Inter", 20));
        text.setWrappingWidth(450);
        text.setTextAlignment(TextAlignment.CENTER);
        FTButton btn = new FTButton(btnText,15);
        btn.setOnAction(e -> window.close());

        VBox layout = new VBox(20);
        layout.getChildren().addAll(text, btn);
        layout.setAlignment(Pos.CENTER);
        layout.setBackground(new Background(new BackgroundFill(Color.web("#B2D7E2"), CornerRadii.EMPTY, Insets.EMPTY)));

        Scene scene = new Scene(layout);
        scene.setFill(Color.web("#B2D7E2"));
        window.setScene(scene);
        window.showAndWait();
    }

}
