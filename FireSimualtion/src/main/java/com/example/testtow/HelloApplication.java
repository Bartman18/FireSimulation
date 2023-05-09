package com.example.testtow;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {




        @Override
        public void start(Stage primaryStage) throws Exception {


            Group root = new Group();
            Scene scene = new Scene(root,600, 600, Color.GREEN);


            primaryStage.setTitle("FireSimulation");


            Line line1 = new Line();
            line1.setStartX(0);
            line1.setStartY(300);
            line1.setEndX(600);
            line1.setEndY(300);
            line1.setStrokeWidth(10);

            Line line2 = new Line();
            line2.setStartX(300);
            line2.setStartY(0);
            line2.setEndX(300);
            line2.setEndY(600);
            line2.setStrokeWidth(10);

            Line line3 = new Line();
            line3.setStartX(150);
            line3.setStartY(200);
            line3.setEndX(150);
            line3.setEndY(300);
            line3.setStrokeWidth(5);

            Line line4 = new Line();
            line4.setStartX(200);
            line4.setStartY(500);
            line4.setEndX(300);
            line4.setEndY(500);
            line4.setStrokeWidth(5);

            Line line5 = new Line();
            line5.setStartX(300);
            line5.setStartY(150);
            line5.setEndX(400);
            line5.setEndY(150);
            line5.setStrokeWidth(5);

            Line line6 = new Line();
            line6.setStartX(300);
            line6.setStartY(400);
            line6.setEndX(400);
            line6.setEndY(400);
            line6.setStrokeWidth(5);


            Rectangle FireStation = new Rectangle(100,50,Color.RED);
            FireStation.setY(250);
            FireStation.setX(500);

            Text text1 = new Text("FIRE STATION");
            text1.setFont(Font.font("Arial", FontWeight.BOLD, 10));
            text1.setFill(Color.BLACK);
            text1.setTextAlignment(TextAlignment.CENTER);
            text1.setWrappingWidth(FireStation.getWidth() + 15);
            text1.setX(FireStation.getX() );
            text1.setY(FireStation.getY() + FireStation.getHeight() / 2 + text1.getBoundsInLocal().getHeight() / 2);




            root.getChildren().addAll(line1, line2, line3, line4, line5, line6, FireStation, text1);




            primaryStage.setScene(scene);
            primaryStage.show();

        }

        public static void main(String[] args) {
            launch(args);
        }
    }