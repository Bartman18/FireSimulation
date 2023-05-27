package com.example.testtow.firetrucks;


import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class ControlRoom {

    private float howBigIsFire;
    private boolean isFireOccupied;



    public Rectangle LeftUpper(Rectangle fire) {


        Rectangle rect = new Rectangle(470, 270, 50, 30);
        rect.setFill(Color.VIOLET);

        TranslateTransition ttLeft = new TranslateTransition(Duration.millis(2000), rect);
        ttLeft.setByX(-340);

        TranslateTransition ttUp = new TranslateTransition(Duration.millis(1000), rect);
        ttUp.setByY(-100);


        SequentialTransition sequentialTransition = new SequentialTransition(ttLeft, ttUp);
        sequentialTransition.play();

        if(fire.getHeight()<=0) {
            TranslateTransition ttUpback = new TranslateTransition(Duration.millis(2000), rect);
            ttLeft.setByX(100);

            TranslateTransition ttLeftBack = new TranslateTransition(Duration.millis(1000), rect);
            ttUp.setByY(3400);
            FadeTransition fadeOut = new FadeTransition(Duration.millis(1000), rect);
            fadeOut.setToValue(0);

            SequentialTransition sequentialTransition1 = new SequentialTransition(ttUpback, ttLeftBack, fadeOut);

            sequentialTransition1.play();
        }




        return rect;
    }



    public Rectangle RightUpper(Rectangle fire) {

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

        if(fire.getHeight()<=0) {
            TranslateTransition ttRigthBack = new TranslateTransition(Duration.millis(2000), rect);
            ttLeft.setByX(-100);

            TranslateTransition ttUpback = new TranslateTransition(Duration.millis(1000), rect);
            ttUp.setByY(135);

            TranslateTransition ttLeftBack = new TranslateTransition(Duration.millis(2000), rect);
            ttRight.setByX(190);

            FadeTransition fadeOut = new FadeTransition(Duration.millis(1000), rect);
            fadeOut.setToValue(0);

            SequentialTransition sequentialTransition1 = new SequentialTransition(
                    ttRigthBack, ttUpback, ttLeftBack, fadeOut);
            sequentialTransition1.play();
        }

        return rect;

    }

    public Rectangle RightLower(Rectangle fire) {


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

        if(fire.getHeight()<=0) {
            TranslateTransition ttRightBack = new TranslateTransition(Duration.millis(2000), rect);
            ttRightBack.setByX(-100);

            TranslateTransition ttDownBack = new TranslateTransition(Duration.millis(2000), rect);
            ttDownBack.setByY(215);

            TranslateTransition ttRightBack1 = new TranslateTransition(Duration.millis(2000), rect);
            ttRightBack1.setByX(-190);

            FadeTransition fadeOut = new FadeTransition(Duration.millis(1000), rect);
            fadeOut.setToValue(0);

            SequentialTransition sequentialTransition1 = new SequentialTransition(
                    ttRightBack, ttDownBack, ttRightBack1, fadeOut);
            sequentialTransition1.play();
        }


        return rect;

    }

    public Rectangle LeftLower(Rectangle fire) {
        Rectangle rect = new Rectangle(470, 270, 50, 30);
        rect.setFill(Color.VIOLET);

        TranslateTransition ttLeft = new TranslateTransition(Duration.millis(2000));
        ttLeft.setToX(-190);

        TranslateTransition ttUp = new TranslateTransition(Duration.millis(2000));
        ttUp.setToY(215);

        TranslateTransition ttRight = new TranslateTransition(Duration.millis(2000));
        ttRight.setToX(-100);

        SequentialTransition sequentialTransition = new SequentialTransition(rect, ttLeft, ttUp, ttRight);
        sequentialTransition.setCycleCount(2);
        sequentialTransition.setAutoReverse(true);

        sequentialTransition.play();

        if(fire.getHeight()<=0) {
            TranslateTransition ttBack = new TranslateTransition(Duration.millis(2000), rect);
            ttBack.setByX(100);

            TranslateTransition ttDown = new TranslateTransition(Duration.millis(2000), rect);
            ttDown.setByY(-215);

            TranslateTransition ttRightBack = new TranslateTransition(Duration.millis(2000), rect);
            ttRightBack.setByX(190);

            FadeTransition fadeOut = new FadeTransition(Duration.millis(1000), rect);
            fadeOut.setToValue(0);

            SequentialTransition sequentialTransition1 = new SequentialTransition(
                    ttBack, ttDown, ttRightBack, fadeOut);
            sequentialTransition1.play();
        }

        return rect;
    }
    public static void moveRectangleBasedOnFirePosition(Rectangle fire, Group root) {
        double x = fire.getX();
        double y = fire.getY();
        ControlRoom controlRoom = new ControlRoom();


        if (x >= 30 && x <= 265 && y >= 30 && y <= 265) {
            Rectangle rect = controlRoom.RightUpper(fire);
            root.getChildren().add(rect);
        } else if (x >= 335 && x <= 570 && y >= 30 && y <= 570)
        {
            Rectangle rect = controlRoom.LeftUpper(fire);
            root.getChildren().add(rect);
        } else if (x >= 30 && x <= 265 && y >= 335 && y <= 570) {
            Rectangle rect = controlRoom.RightLower(fire);
            root.getChildren().add(rect);
        } else if (x >= 335 && x <= 570 && y >= 335 && y <= 570) {
            Rectangle rect = controlRoom.LeftLower(fire);
            root.getChildren().add(rect);
        }

    }
}

