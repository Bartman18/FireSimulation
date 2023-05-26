package com.example.testtow;

import com.example.testtow.Fire.Fire;
import com.example.testtow.Fire.FireControl;
import com.example.testtow.firetrucks.ControlRoom;
import com.example.testtow.firetrucks.FireTruck;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;

import java.util.Random;

public class HelloApplication extends Application {

    //region zmienna
    static Text testText = new Text(650,200,"0");
    static MapGenerator mapGenerator = new MapGenerator();
    Random generator = new Random();
    Rectangle[] additionalFire = new Rectangle[50];
    int j;
    boolean czybylo = false;
    //endregion
    FireControl fireControl = new FireControl();
        @Override
        public void start(Stage primaryStage) throws Exception {
            Rectangle rect = new Rectangle(600, 600);
            Scene scene = new Scene(mapGenerator.getRoot(),800, 600, Color.GREEN);
            mapGenerator.MapGeneration(primaryStage);
            FireTruck fireTruck1 = new FireTruck(1, 2, 2, 2, 2);

            primaryStage.setScene(scene);
            primaryStage.show();
            new AnimationTimer() {
                @Override public void handle(long currentNanoTime) {
                    for (int i = 0; i < 1; i++) {
                        double random = generator.nextInt(100);
                        if (random == 1 && !czybylo)
                        {
                            additionalFire[j] = fireControl.getAdditionalFire0();
                            mapGenerator.root.getChildren().add(additionalFire[j]);
                            j++;
                            czybylo = true;
                        }
                    }

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // Do nothing
                    }
                }
            }.start();
        }
        public static void main(String[] args) {launch(args);}


    public static Text getTestText() {
        return testText;
    }
}