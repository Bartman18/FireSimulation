package com.example.testtow;

import com.example.testtow.Fire.Fire;
import com.example.testtow.Fire.FireControl;
import com.example.testtow.firetrucks.ControlRoom;
import com.example.testtow.firetrucks.FireTruck;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception {
            FireControl fireControl = new FireControl();
            //fireControl.getFire();


            MapGenerator mapGenerator = new MapGenerator();
        mapGenerator.MapGeneration(primaryStage);
        //(fireControl.getFire());
            FireTruck fireTruck1 = new FireTruck(1, 2,2,2,2);



        }
        public static void main(String[] args) {
            launch(args);
        }
    }