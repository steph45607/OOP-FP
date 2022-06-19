package com.oopfp.focustime;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

// Timer, a pop-up that will keep running in the background
public class Timer {
//    Initialization of vars
    private int second = 0;
    private int minute = 0;
    private int hour = 0;
    private boolean timeStop = true;

//    Constructor
    public Timer(){};

// runTime method to change the displayed value time changes over time
    public void runTime(Text text){
//        Every 60 sec passed, change minute to +1
        if(this.second == 60){
            this.minute++;
            this.second = 0;
        }
//        Every 60 minutes passed, change hour to +1
        if(this.minute == 60){
            this.hour++;
            this.minute = 0;
        }

//        Creation of variables
        String hourStr, minuteStr, secondStr;

//        When hour is divisible by 10 and equal to 0(int), add 0 in the start, so it would look life ex= 05:00:00
        if((this.hour/10) == 0){
            hourStr = "0" + this.hour + ":";
        }else{
            hourStr = this.hour + ":";
        }

//        When minute is divisible by 10 and equal to 0(int), add 0 in the start, so it would look life ex= 00:05:00
        if((this.minute/10) == 0){
            minuteStr = "0" + this.minute + ":";
        }else{
            minuteStr = this.minute + ":";
        }

//        When hour is divisible by 10 and equal to 0(int), add 0 in the start, so it would look life ex= 05:00:00
        if((this.second/10) == 0){
            secondStr = "0" + this.second++;
        }else{
//            String value of - because there are no string indication for second, not like the others
            secondStr = String.valueOf(this.second++);

        }

//        Set the time to the text displayed
        text.setText(hourStr + minuteStr + secondStr);
    }

//    show method to display to the window
    public void show(){
        Stage timerWin = new Stage();
        timerWin.setTitle("FocusTime - Stopwatch");
        timerWin.setMinWidth(500);
        timerWin.setMinHeight(300);

//        Set the timer name - easier to keep track
        TextField name = new TextField();

//        Set the initial condition to 00:00:00
        FTText clock = new FTText("00:00:00", 40);
//        To change text, run the runTime method, for every one second duration
        KeyFrame keyframe = new KeyFrame(Duration.seconds(1.0), e -> runTime(clock));
//        Set timeline animation based on the keyframe time frame
        Timeline time = new Timeline(keyframe);
//        Play it non-stop until animation is stopped
        time.setCycleCount(Timeline.INDEFINITE);
//        Won't go back, it will loop non-stop
        time.setAutoReverse(false);

//        Display the status, empty - running, paused - when paused
        FTText statusTxt = new FTText("", 15);

//        Start the animation, and statusText to empty string
        FTButton startBtn = new FTButton("Start", 15);
        startBtn.setOnAction(e ->{
            if(timeStop){
                time.play();
                timeStop = false;
                statusTxt.setText("");
            }
        });

//        Pause animation, statusText to "Paused"
        FTButton pauseBtn = new FTButton("Pause", 15);
        pauseBtn.setOnAction(e ->{
            if(!timeStop){
                time.pause();
                timeStop = true;
                statusTxt.setText("paused");
            }
        });

//        Set everything to 0, pause the animation
        FTButton resetBtn = new FTButton("Reset", 15);
        resetBtn.setOnAction(e ->{
            this.hour = 0;
            this.minute = 0;
            this.second = 0;
            time.pause();
            clock.setText("00:00:00");
            statusTxt.setText("");
            if(!timeStop){
                timeStop = true;
            }
        });

        HBox buttons = new HBox(20);
        buttons.setAlignment(Pos.CENTER);
        buttons.getChildren().addAll(startBtn, pauseBtn, resetBtn);

        VBox clockNstatus = new VBox();
        clockNstatus.setAlignment(Pos.CENTER);
        clockNstatus.getChildren().addAll(clock, statusTxt);

        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(name, clockNstatus, buttons);
        layout.setBackground(new Background(new BackgroundFill(Color.web("#B2D7E2"), CornerRadii.EMPTY, Insets.EMPTY)));

        FTScene scene = new FTScene(layout, 500, 300);
        scene.setFill(Color.web("#B2D7E2"));
        timerWin.setScene(scene);
        timerWin.show();

//        Set when the window is closed, no matter if its paused, running, or reset
//        Will set everything to 0, same with reset button
        timerWin.setOnCloseRequest(e -> {
            this.hour = 0;
            this.minute = 0;
            this.second = 0;
            time.pause();
            clock.setText("00:00:00");
            statusTxt.setText("");
            if(!timeStop){
                timeStop = true;
            }
        });
    }

}
