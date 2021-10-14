package com.example.demo;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.scene.control.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CircleControll extends Application{

    Label label1 = new Label("Слайдер");
    Label label2 = new Label("Цвет круга");
    Label label3 = new Label("Цвет поля");
    Slider slider = new Slider();
    ColorPicker colp1 = new ColorPicker();
    ColorPicker colp2 = new ColorPicker();
    Circle circle = new Circle();
    Pane pane = new Pane();
    VBox vbox = new VBox();
    HBox hbox = new HBox();


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Messanger");

        Parent parent = createInterface();
        primaryStage.setScene(new Scene(parent, 640, 480));

        primaryStage.show();
        initIteraction();
    }

    private void initIteraction() {
        circle.radiusProperty().bind(slider.valueProperty());
        circle.fillProperty().bind(colp1.valueProperty());
        colp2.valueProperty().addListener(e -> {
           pane.setBackground(new Background(new BackgroundFill(colp2.getValue(), null, null)));
        });
        circle.centerXProperty().bind(pane.widthProperty().divide(2));
        circle.centerYProperty().bind(pane.heightProperty().divide(2));
        ReadOnlyDoubleProperty x ;
        if (pane.getWidth() < pane.getHeight()){
            x = pane.widthProperty();
        } else {
            x = pane.heightProperty();
        }
        slider.maxProperty().bind(x.divide(2));
    }

    private Parent createInterface() {
        vbox.getChildren().addAll(label1, slider, label2, colp1, label3, colp2);
        pane.getChildren().addAll(circle);
        hbox.getChildren().addAll(vbox, pane);
        HBox.setHgrow(pane, Priority.ALWAYS);
        VBox.setVgrow(vbox, Priority.ALWAYS);
        return hbox;
    }
}
