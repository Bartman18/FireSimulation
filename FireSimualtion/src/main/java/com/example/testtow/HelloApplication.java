package com.example.testtow;

import com.example.testtow.firetrucks.FireTruck;
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

        MapGenerator mapGenerator = new MapGenerator();
        Fire fire = new Fire();
        mapGenerator.MapGeneration(primaryStage);
            FireTruck fireTruck1 = new FireTruck(1, 2,2,2,2);




        }
        public static void main(String[] args) {
            launch(args);
        }
    }