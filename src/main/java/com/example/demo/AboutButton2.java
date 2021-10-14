package com.example.demo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class AboutButton2 extends Application {

    private Label label1;
    private Button b;
    private int x = 1;
    private VBox vbox;
    private final ImageView gif = new ImageView();


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Пример про слушателей");

        Parent parent = createInterface();
        primaryStage.setScene(new Scene(parent, 640, 480));

        primaryStage.show();
        initIteraction();
    }

    private void initIteraction() {
        b.addEventHandler(ActionEvent.ACTION, e -> {
            if (x == 1) {
                label1.setText("Хватит нажимать на эту кнопку");
            } else if (x == 2) {
                label1.setText("Я просил, не нажимай больше на эту кнопку");
            } else if (x ==3) {
                label1.setText("Может хватит?");
            } else if (x == 4) {
                label1.setText("Ну все");
            } else {
                vbox.getChildren().removeAll(label1,b);
                vbox.getChildren().add(gif);
            }

            x = x+1;

        });

    }

    private Parent createInterface() {
        b = new Button("Кнопка");
        label1 = new Label("Privet");
        gif.setImage(new Image("https://acegif.com/wp-content/uploads/gif-explosion-49.gif"));
        vbox = new VBox(label1, b);
        vbox.setAlignment(Pos.CENTER);
        return vbox;
    }
}

