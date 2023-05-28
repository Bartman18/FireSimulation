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
    FireControl fireControl = new FireControl();
    static Text testText = new Text(650,200,"0");
    static MapGenerator mapGenerator = new MapGenerator();
    Random generator = new Random();
    boolean isUsed0 = true;
    boolean isUsed1 = true;
    boolean isUsed2 = true;
    boolean isUsed3 = true;

    Rectangle additionalFire0 = fireControl.getAdditionalFire0();
    Rectangle additionalFire1 = fireControl.getAdditionalFire1();
    Rectangle additionalFire2 = fireControl.getAdditionalFire2();
    Rectangle additionalFire3 = fireControl.getAdditionalFire3();
    //endregion
        @Override
        public void start(Stage primaryStage) throws Exception {
            Rectangle rect = new Rectangle(600, 600);
            Scene scene = new Scene(mapGenerator.getRoot(),800, 600, Color.GREEN);
            mapGenerator.MapGeneration(primaryStage);
            FireTruck fireTruck1 = new FireTruck(1, 2, 2, 2, 2);
            Rectangle fire0 = fireControl.getFire0();
            Rectangle fire1 = fireControl.getFire1();
            Rectangle fire2 = fireControl.getFire2();
            Rectangle fire3 = fireControl.getFire3();

            mapGenerator.root.getChildren().addAll(fire0, fire1, fire2, fire3);
            primaryStage.setScene(scene);
            primaryStage.show();
            new AnimationTimer() {
                @Override public void handle(long currentNanoTime) {

                    //puttingOff(fire0 , 0.03);
                    if (FireControl.wind) {
                        windBehavior();
                    }
                    try {
                        Thread.sleep(10);
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

    public void windBehavior()
    {
        double random = generator.nextInt(4000);
        if (random == 1 && isUsed0)
        {
            mapGenerator.root.getChildren().add(additionalFire0);
            isUsed0 = false;
        }
        if (random == 2 && isUsed1)
        {
            mapGenerator.root.getChildren().add(additionalFire1);
            isUsed1 = false;
        }
        if (random == 3 && isUsed2)
        {
            mapGenerator.root.getChildren().add(additionalFire2);
            isUsed2 = false;
        }
        if (random == 4 && isUsed3)
        {
            mapGenerator.root.getChildren().add(additionalFire3);
            isUsed3 = false;
        }
    }
    public void puttingOff(Rectangle fire, double power)
    {
        fire.setHeight(fire.getHeight()-power);
        fire.setWidth(fire.getWidth()-power);
    }
}