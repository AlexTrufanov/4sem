package com.example.demo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.Random;

public class ExamTask extends Application{

    HBox hbox = new HBox();
    VBox leftvbox = new VBox();
    VBox rightvbox = new VBox();
    Label label1 = new Label("Синий");
    Label label2 = new Label("Желтый");
    Label label3 = new Label("Фиолетовый");
    Label label4 = new Label("Черный");
    Rectangle rectagle1 = new Rectangle(100,25,100,25);
    Rectangle rectangle2 = new Rectangle(100,25,100,25);
    Button b = new Button("Добавить");
    Random i = new Random();
    String color = new String();

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("эффект Струпа");

        Parent parent = createInterface();
        primaryStage.setScene(new Scene(parent, 640, 480));

        primaryStage.show();
        initIteraction();
    }

    private void initIteraction() {
        b.addEventHandler(ActionEvent.ACTION, e ->{
            int n = i.nextInt(8);
            boolean shape = i.nextBoolean();

            if ( shape == true) {
                Label q = new Label(color);
                q.setFont(new Font(30));
                q.setStyle("-fx-font-weight: bold");
                leftvbox.getChildren().add(q);
                if ( n == 0) {
                    color = "Красный";
                    q.setTextFill(Color.RED);
                } else if ( n == 1) {
                    color = "Оранжевый";
                    q.setTextFill(Color.ORANGE);
                } else if( n ==2 ) {
                    color = "YELLOW";
                    q.setTextFill(Color.YELLOW);
                } else if ( n == 3 ) {
                    color = "GREEN";
                    q.setTextFill(Color.GREEN);
                } else if ( n == 4 ) {
                    color = "LIGHTBLUE";
                    q.setTextFill(Color.LIGHTBLUE);
                } else if ( n == 5) {
                    color = "BLUE";
                    q.setTextFill(Color.BLUE);
                } else if ( n == 6) {
                    color = "PURPLE";
                    q.setTextFill(Color.PURPLE);
                } else {
                    color = "BLACK";
                    q.setTextFill(Color.BLACK);
                }
            } else {
                Rectangle r = new Rectangle(100,25);
                r.setStroke(Color.BLACK);
                r.setStyle("-fx-padding: 10, 10, 10, 10" +
                        "-fx- margin 10, 10, 10, 10");
                new Insets(10,10,10,10);
                leftvbox.getChildren().add(r);
                if ( n == 0) {
                    color = "RED";
                    r.setFill(Color.RED);
                } else if ( n == 1) {
                    color = "ORANGE";
                    r.setFill(Color.ORANGE);
                } else if( n ==2 ) {
                    color = "YELLOW";
                    r.setFill(Color.YELLOW);
                } else if ( n == 3 ) {
                    color = "GREEN";
                    r.setFill(Color.GREEN);
                } else if ( n == 4 ) {
                    color = "LIGHTBLUE";
                    r.setFill(Color.LIGHTBLUE);
                } else if ( n == 5) {
                    color = "BLUE";
                    r.setFill(Color.BLUE);
                } else if ( n == 6) {
                    color = "PURPLE";
                    r.setFill(Color.PURPLE);
                } else {
                    color = "BLACK";
                    r.setFill(Color.BLACK);
                }
            }

           if (leftvbox.getChildren().size() == 10) {
                leftvbox.getChildren().remove(0);
           }
        });
    }

    private Parent createInterface() {
        label1.setFont(new Font(30));
        label1.setTextFill(Color.DEEPPINK);
        label1.setStyle("-fx-font-weight: bold");
        label2.setFont(new Font(30));
        label2.setTextFill(Color.GREEN);
        label2.setStyle("-fx-font-weight: bold");
        label3.setFont(new Font(30));
        label3.setTextFill(Color.DARKORANGE);
        label3.setStyle("-fx-font-weight: bold");
        label4.setFont(new Font(30));
        label4.setTextFill(Color.RED);
        label4.setStyle("-fx-font-weight: bold");
        rectagle1.setFill(Color.BLUE);
        rectagle1.setStroke(Color.BLACK);
        rectangle2.setFill(Color.DEEPPINK);
        rectangle2.setStroke(Color.BLACK);
        leftvbox.getChildren().addAll(label1, label2, label3, rectagle1, label4, rectangle2);
        leftvbox.setAlignment(Pos.TOP_CENTER);
        leftvbox.setStyle("-fx-border-width: 1;" +
                "-fx-border-color: black;");
        HBox.setHgrow(leftvbox, Priority.ALWAYS);
        rightvbox.getChildren().addAll(b);
        hbox.getChildren().addAll(leftvbox, rightvbox);
        hbox.setStyle(
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-color: black;");
        return hbox;
    }
}