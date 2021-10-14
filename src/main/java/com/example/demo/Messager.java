package com.example.demo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Messager extends Application{

    TextArea ta =  new TextArea();
    TextField tf = new TextField();
    Button b = new Button();
    Label l = new Label();
    ListView<String> list = new ListView<>();
    HBox hb1 = new HBox(tf, b);
    VBox vb1 = new VBox(ta, hb1);
    VBox vb2 = new VBox(l, list);
    HBox hb2 = new HBox(vb1, vb2);


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Messanger");

        Parent parent = createInterface();
        primaryStage.setScene(new Scene(parent, 640, 480));

        primaryStage.show();
        initIteraction();
    }

    private Parent createInterface() {
        b.setText("Послать");
        l.setText("Контакты");
        VBox.setVgrow(ta, Priority.ALWAYS);
        VBox.setVgrow(list, Priority.ALWAYS);
        HBox.setHgrow(tf, Priority.ALWAYS);
        HBox.setHgrow(vb1, Priority.ALWAYS);
        list.getItems().addAll("Иванов", "Петров", "Сидоров");
        return hb2;
    }

    private void initIteraction() {
        b.addEventHandler(ActionEvent.ACTION, e ->{
            String str1 = tf.getText();
            String str2 = ta.getText();
            ta.setText(str2 + str1 + "\n");
            tf.setText("");
        });
    }
}
