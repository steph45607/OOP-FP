package com.oopfp.focustime;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

// A pop-up windows for math formulas.
public class MathPopUp {

    public static void calcSquare(){
        Stage window = new Stage();
//        Disable the application to run without exiting this stage
        window.initModality(Modality.APPLICATION_MODAL);
//        Set stage size
        window.setMinWidth(500);
        window.setMinHeight(350);
//        Set stage title - header
        window.setTitle("Calculate Square");

        Square square = new Square("Square", "a plane figure with four equal straight sides and four right angles");

        Label name = new Label(square.getName());
        name.setFont(Font.font("Inter", 20));
        name.setTextAlignment(TextAlignment.CENTER);
        Text desc = new Text(square.getDesc());
        desc.setFont(Font.font("Inter", 20));
        desc.setWrappingWidth(500);
        desc.setTextAlignment(TextAlignment.CENTER);

//        An empty text - placeholder to show the result after calculation
        Text result = new Text("");
        result.setFont(Font.font("Inter", 20));

//        Prompt and inputField for attributes
        Text inputSide = new Text("Side value: ");
        TextField side = new TextField();

        Text inputHeight = new Text("Height: ");
        TextField height = new TextField();

//        FTButton with Calculate text
        FTButton btn = new FTButton("Calculate",15);
        btn.setOnAction(e -> {
//            Try Catch - throw pop up box if there's an error
            try {
//                Store getText() to a value and set it to object attribute
                double sideValue = Double.parseDouble(side.getText());
                square.setWidth(sideValue);
                double heightValue = Double.parseDouble(height.getText());
                square.setHeight(heightValue);
//                Set the result from Methods.calculate to result text
//                Change the text to the output
                result.setText(Methods.calculate(square));
//                NumberFormatException - convert a string win an incorrect format to a numeric value
            }catch(NumberFormatException nfe){
//                Pop up with warning text - value error
                PopUp.show("Value Error", "Input has to be filled or numbers. If none, input 0", "Ok");
            }
        });
//        Vbox for prompt1 and inputField1
        VBox input1 = new VBox(10);
        input1.getChildren().addAll(inputSide, side);

//        Vbox for prompt1 and inputField1
        VBox input2 = new VBox(10);
        input2.getChildren().addAll(inputHeight, height);

//        Horizontal for both inputs
        HBox inputs = new HBox(20);
        inputs.setAlignment(Pos.CENTER);
        inputs.getChildren().addAll(input1, input2);

//        Vertical for all elements
        VBox layout = new VBox(20);
        layout.getChildren().addAll(name, desc, inputs, result, btn);
        layout.setAlignment(Pos.CENTER);

//        Set the scene using FTScene, so it has the same theme, with
        FTScene scene = new FTScene(layout, 600, 500);
//        Set the scene to window
        window.setScene(scene);
//        Window shows and wait till it's closed by user, "x"
        window.showAndWait();
    }

//    No comments for the rest under, because all the same :)
    public static void calcTriangle(){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(500);
        window.setMinHeight(350);
        window.setTitle("Calculate Triangle");

        Triangle triangle = new Triangle("Triangle", "a plane figure with three straight sides and three angles");

        Label name = new Label(triangle.getName());
        name.setFont(Font.font("Inter", 20));
        name.setTextAlignment(TextAlignment.CENTER);
        Text desc = new Text(triangle.getDesc());
        desc.setFont(Font.font("Inter", 20));
        desc.setWrappingWidth(500);
        desc.setTextAlignment(TextAlignment.CENTER);

        Text result = new Text("");
        result.setFont(Font.font("Inter", 20));

        Text inputSideA = new Text("Side A value: ");
        TextField sideA = new TextField();

        Text inputSideB = new Text("Side B value: ");
        TextField sideB = new TextField();

        Text inputSideC = new Text("Side C value: ");
        TextField sideC = new TextField();

        Text inputHeight = new Text("Height: ");
        TextField height = new TextField();

        FTButton btn = new FTButton("Calculate",15);
        btn.setOnAction(e -> {
            try {
                double sideAValue = Double.parseDouble(sideA.getText());
                triangle.setSideA(sideAValue);
                double sideBValue = Double.parseDouble(sideB.getText());
                triangle.setSideB(sideBValue);
                double sideCValue = Double.parseDouble(sideC.getText());
                triangle.setSideC(sideCValue);
                double heightValue = Double.parseDouble(height.getText());
                triangle.setHeight(heightValue);
                result.setText(Methods.calculate(triangle));
            }catch(NumberFormatException nfe){
                PopUp.show("Value Error", "Input has to be filled or numbers. If none, input 0", "Ok");
            }
        });

        VBox input1 = new VBox(10);
        input1.getChildren().addAll(inputSideA, sideA);

        VBox input2 = new VBox(10);
        input2.getChildren().addAll(inputSideB, sideB);

        VBox input3 = new VBox(10);
        input3.getChildren().addAll(inputSideC, sideC);

        VBox input4 = new VBox(10);
        input4.getChildren().addAll(inputHeight, height);

        HBox inputs = new HBox(20);
        inputs.setAlignment(Pos.CENTER);
        inputs.getChildren().addAll(input1, input2, input3, input4);

        VBox layout = new VBox(20);
        layout.getChildren().addAll(name, desc, inputs, result, btn);
        layout.setAlignment(Pos.CENTER);

        FTScene scene = new FTScene(layout, 800, 500);
        scene.setFill(Color.web("#B2D7E2"));
        window.setScene(scene);
        window.showAndWait();
    }

    public static void calcCircle(){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(500);
        window.setMinHeight(350);
        window.setTitle("Calculate Circle");

        Circle circle = new Circle("Circle", "a round plane figure whose boundary (the circumference) consists of points equidistant from a fixed point (the center)");

        Label name = new Label(circle.getName());
        name.setFont(Font.font("Inter", 20));
        name.setTextAlignment(TextAlignment.CENTER);
        Text desc = new Text(circle.getDesc());
        desc.setFont(Font.font("Inter", 20));
        desc.setWrappingWidth(500);
        desc.setTextAlignment(TextAlignment.CENTER);

        Text result = new Text("");
        result.setFont(Font.font("Inter", 20));

        Text inputRadius = new Text("Radius: ");
        TextField radius = new TextField();

        Text inputHeight = new Text("Height: ");
        TextField height = new TextField();

        FTButton btn = new FTButton("Calculate",15);
        btn.setOnAction(e -> {
            try {
                double sideValue = Double.parseDouble(radius.getText());
                circle.setRadius(sideValue);
                double heightValue = Double.parseDouble(height.getText());
                circle.setHeight(heightValue);
                result.setText(Methods.calculate(circle));
            }catch(NumberFormatException nfe){
                PopUp.show("Value Error", "Input has to be filled or numbers. If none, input 0", "Ok");
            }
        });

        VBox input1 = new VBox(10);
        input1.getChildren().addAll(inputRadius, radius);

        VBox input2 = new VBox(10);
        input2.getChildren().addAll(inputHeight, height);

        HBox inputs = new HBox(20);
        inputs.setAlignment(Pos.CENTER);
        inputs.getChildren().addAll(input1, input2);

        VBox layout = new VBox(20);
        layout.getChildren().addAll(name, desc, inputs, result, btn);
        layout.setAlignment(Pos.CENTER);

        FTScene scene = new FTScene(layout, 600, 500);
        scene.setFill(Color.web("#B2D7E2"));
        window.setScene(scene);
        window.showAndWait();
    }

    public static void calcParallelogram(){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(500);
        window.setMinHeight(350);
        window.setTitle("Calculate Parallelogram");

        Parallelogram parallelogram = new Parallelogram("Parallelogram", "a four-sided plane rectilinear figure with opposite sides parallel");

        Label name = new Label(parallelogram.getName());
        name.setFont(Font.font("Inter", 20));
        name.setTextAlignment(TextAlignment.CENTER);
        Text desc = new Text(parallelogram.getDesc());
        desc.setFont(Font.font("Inter", 20));
        desc.setWrappingWidth(500);
        desc.setTextAlignment(TextAlignment.CENTER);

        Text result = new Text("");
        result.setFont(Font.font("Inter", 20));

        Text inputBase = new Text("Base value: ");
        TextField base = new TextField();

        Text inputSide = new Text("Side value: ");
        TextField side = new TextField();

        Text inputParHeight = new Text("Parallelogram height value: ");
        TextField parHeight = new TextField();

        Text inputHeight = new Text("Height: ");
        TextField height = new TextField();

        FTButton btn = new FTButton("Calculate",15);
        btn.setOnAction(e -> {
            try {
                double baseValue = Double.parseDouble(base.getText());
                parallelogram.setBase(baseValue);
                double sideValue = Double.parseDouble(side.getText());
                parallelogram.setSide(sideValue);
                double parHeightValue = Double.parseDouble(parHeight.getText());
                parallelogram.setParHeight(parHeightValue);
                double heightValue = Double.parseDouble(height.getText());
                parallelogram.setHeight(heightValue);
                result.setText(Methods.calculate(parallelogram));
            }catch(NumberFormatException nfe){
                PopUp.show("Value Error", "Input has to be filled or numbers. If none, input 0", "Ok");
            }
        });

        VBox input1 = new VBox(10);
        input1.getChildren().addAll(inputBase, base);

        VBox input2 = new VBox(10);
        input2.getChildren().addAll(inputSide, side);

        VBox input3 = new VBox(10);
        input3.getChildren().addAll(inputParHeight, parHeight);

        VBox input4 = new VBox(10);
        input4.getChildren().addAll(inputHeight, height);

        HBox inputs = new HBox(20);
        inputs.setAlignment(Pos.CENTER);
        inputs.getChildren().addAll(input1, input2, input3, input4);

        VBox layout = new VBox(20);
        layout.getChildren().addAll(name, desc, inputs, result, btn);
        layout.setAlignment(Pos.CENTER);

        FTScene scene = new FTScene(layout, 800, 500);
        scene.setFill(Color.web("#B2D7E2"));
        window.setScene(scene);
        window.showAndWait();
    }
}
