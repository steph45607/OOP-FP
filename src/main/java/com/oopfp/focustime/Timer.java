package com.oopfp.focustime;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Timer {
    static int second = 0;
    static int minute = 0;
    static int hour = 0;
    static boolean timeStop = true;

    public static void runTime(Text text){
        if(second == 60){
            minute++;
            second = 0;
        }
        if(minute == 60){
            hour++;
            minute = 0;
        }

        String hourStr, minuteStr, secondStr;

        if((hour/10) == 0){
            hourStr = "0" + hour + ":";
        }else{
            hourStr = hour + ":";
        }

        if((minute/10) == 0){
            minuteStr = "0" + minute + ":";
        }else{
            minuteStr = minute + ":";
        }

        if((second/10) == 0){
            secondStr = "0" + second++;
        }else{
            secondStr = String.valueOf(second++);

        }

        text.setText(hourStr + minuteStr + secondStr);
    }

    public static void show(){
        Stage timerWin = new Stage();
        timerWin.setTitle("FousTime - Stopwatch");
        timerWin.setMinWidth(500);
        timerWin.setMinHeight(300);

        Text clock = new Text("00:00:00");
        clock.setFont(Font.font("Inter", 40));
        KeyFrame keyframe = new KeyFrame(Duration.seconds(1.0), e -> runTime(clock));
        Timeline time = new Timeline(keyframe);
        time.setCycleCount(Timeline.INDEFINITE);
        time.setAutoReverse(false);

        Text statusTxt = new Text("");

        FTButton startBtn = new FTButton("Start", 15);
        startBtn.setOnAction(e ->{
            if(timeStop){
                time.play();
                timeStop = false;
                statusTxt.setText("");
            }
        });

        FTButton pauseBtn = new FTButton("Pause", 15);
        pauseBtn.setOnAction(e ->{
            if(!timeStop){
                time.pause();
                timeStop = true;
                statusTxt.setText("paused");
            }
        });

        FTButton resetBtn = new FTButton("Reset", 15);
        resetBtn.setOnAction(e ->{
            hour = 0;
            minute = 0;
            second = 0;
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
        layout.getChildren().addAll(clockNstatus, buttons);
        layout.setBackground(new Background(new BackgroundFill(Color.web("#B2D7E2"), CornerRadii.EMPTY, Insets.EMPTY)));

        FTScene scene = new FTScene(layout, 500, 300);
        scene.setFill(Color.web("#B2D7E2"));
        timerWin.setScene(scene);
        timerWin.show();
    }

}
