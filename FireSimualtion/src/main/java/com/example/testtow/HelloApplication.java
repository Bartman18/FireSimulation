package com.example.testtow;

import com.example.testtow.Fire.Fire;
import com.example.testtow.Fire.FireControl;
import com.example.testtow.firetrucks.ControlRoom;
import com.example.testtow.firetrucks.FireTruck;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    static MapGenerator mapGenerator = new MapGenerator();
    FireControl fireControl = new FireControl();
        @Override
        public void start(Stage primaryStage) throws Exception {
            Rectangle rect = new Rectangle(600, 600);
            mapGenerator.MapGeneration(primaryStage);
            FireTruck fireTruck1 = new FireTruck(1, 2, 2, 2, 2);
            update();
        }
        public static void main(String[] args) {launch(args);}


    /*
    In GUI programming, always consider an event-driven approach before considering loop-based approaches.
    Your while loop simply repeatedly creates controls, registers a listener with one of them (the button),
    places the controls in a new window, and shows the window. The loop is not going to wait for the button to be
    pressed before proceeding to the next iteration. So you end up with lots of windows...
    wziałem z stacka to, idk jak to inaczej rozwiążemy...
     */
    public static void update() throws Exception{
        int i=0;
            for(i=0;i<5;i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
                System.out.println(i);
        }
    }
}