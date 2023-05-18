package com.example.testtow.firetrucks;


import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class ControlRoom {

    private float howBigIsFire;
    private boolean isFireOccupied;


    public Rectangle LeftUpper() {


        Rectangle rect = new Rectangle(470, 270, 50, 30);
        rect.setFill(Color.VIOLET);

        TranslateTransition ttLeft = new TranslateTransition(Duration.millis(2000), rect);
        ttLeft.setByX(-340);

        TranslateTransition ttUp = new TranslateTransition(Duration.millis(1000), rect);
        ttUp.setByY(-100);


        SequentialTransition sequentialTransition = new SequentialTransition(ttLeft, ttUp);
        sequentialTransition.play();

        return rect;
    }

    public Rectangle RightUpper() {

        Rectangle rect = new Rectangle(470, 270, 50, 30);
        rect.setFill(Color.VIOLET);

        TranslateTransition ttLeft = new TranslateTransition(Duration.millis(2000), rect);
        ttLeft.setByX(-190);

        TranslateTransition ttUp = new TranslateTransition(Duration.millis(1000), rect);
        ttUp.setByY(-135);

        TranslateTransition ttRight = new TranslateTransition(Duration.millis(2000), rect);
        ttRight.setByX(100);


        SequentialTransition sequentialTransition = new SequentialTransition(ttLeft, ttUp, ttRight);
        sequentialTransition.play();

        return rect;

    }

    public Rectangle RightLower() {


        Rectangle rect = new Rectangle(470, 270, 50, 30);
        rect.setFill(Color.VIOLET);

        TranslateTransition ttLeft = new TranslateTransition(Duration.millis(2000), rect);
        ttLeft.setByX(-190);

        TranslateTransition ttUp = new TranslateTransition(Duration.millis(2000), rect);
        ttUp.setByY(115);

        TranslateTransition ttRight = new TranslateTransition(Duration.millis(2000), rect);
        ttRight.setByX(100);


        SequentialTransition sequentialTransition = new SequentialTransition(ttLeft, ttUp, ttRight);
        sequentialTransition.play();

        return rect;

    }

        public Rectangle LeftLower(){

         Rectangle rect = new Rectangle(470, 270, 50, 30);
        rect.setFill(Color.VIOLET);

        TranslateTransition ttLeft = new TranslateTransition(Duration.millis(2000), rect);
        ttLeft.setByX(-190);

        TranslateTransition ttUp = new TranslateTransition(Duration.millis(2000), rect);
        ttUp.setByY(215);

        TranslateTransition ttRight = new TranslateTransition(Duration.millis(2000),rect);
        ttRight.setByX(-100);


        SequentialTransition sequentialTransition = new SequentialTransition(ttLeft, ttUp,ttRight);
        sequentialTransition.play();




        return rect;


    }
}
