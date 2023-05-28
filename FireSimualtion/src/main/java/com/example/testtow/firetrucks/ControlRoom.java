package com.example.testtow.firetrucks;


import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class ControlRoom {

    private float howBigIsFire;
    private boolean isFireOccupied;
    static Rectangle rect;


    public Rectangle LeftUpper(Rectangle fire,Rectangle additionalFire,Group root) {


        Rectangle rect = new Rectangle(470, 270, 50, 30);

        rect.setFill(Color.VIOLET);

        TranslateTransition ttLeft = new TranslateTransition(Duration.millis(2000), rect);
        ttLeft.setByX(-340);

        TranslateTransition ttUp = new TranslateTransition(Duration.millis(1000), rect);
        ttUp.setByY(-100);


        SequentialTransition sequentialTransition = new SequentialTransition(ttLeft, ttUp);
        sequentialTransition.play();

        /*sequentialTransition.setOnFinished(event -> {
            Line waterLine = new Line(rect.getX() + ttLeft.getByX(), rect.getY() + ttUp.getByY(), fire.getX(), fire.getY());
            waterLine.setStroke(Color.BLUE);
            root.getChildren().add(waterLine);
            if(fire.getHeight()<=0){
                root.getChildren().remove(waterLine);
            }
        });

        sequentialTransition.setOnFinished(event -> {
            Line waterLine = new Line(rect.getX() + ttLeft.getByX(), rect.getY() + ttUp.getByY(), fire.getX(), fire.getY());
            if(additionalFire.getHeight()>0) {
                waterLine.setStroke(Color.BLUE);
                root.getChildren().add(waterLine);
            }
            if(additionalFire.getHeight()<=0){
                root.getChildren().remove(waterLine);
            }
        });
*/


       /* if(fire.getHeight()<=0) {
            TranslateTransition ttUpback = new TranslateTransition(Duration.millis(2000), rect);
            ttLeft.setByX(100);

            TranslateTransition ttLeftBack = new TranslateTransition(Duration.millis(1000), rect);
            ttUp.setByY(340);
            FadeTransition fadeOut = new FadeTransition(Duration.millis(1000), rect);
            fadeOut.setToValue(0);

            SequentialTransition sequentialTransition1 = new SequentialTransition(ttUpback, ttLeftBack, fadeOut);

            sequentialTransition1.play();
        }
*/



        return rect;
    }

    public Rectangle RightUpper(Rectangle fire,Rectangle additionalFire,Group root) {

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

        sequentialTransition.setOnFinished(event -> {
            Line waterLine = new Line(rect.getX() + ttLeft.getByX()+ ttRight.getByX(), rect.getY() + ttUp.getByY(), fire.getX(), fire.getY());
            waterLine.setStroke(Color.BLUE);
            root.getChildren().add(waterLine);
            if(fire.getHeight()<=0){
                waterLine.setEndX(300);
            }
        });

        sequentialTransition.setOnFinished(event -> {
            Line waterLine = new Line(rect.getX() + ttLeft.getByX()+ ttRight.getByX(), rect.getY() + ttUp.getByY(), fire.getX(), fire.getY());
            if(additionalFire.getHeight()>0) {
                waterLine.setStroke(Color.BLUE);
                root.getChildren().add(waterLine);
            }
            if(additionalFire.getHeight()<=0){
                root.getChildren().remove(waterLine);
            }
        });

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

    public Rectangle RightLower(Rectangle fire,Rectangle additionalFire,Group root) {


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

        sequentialTransition.setOnFinished(event -> {
            Line waterLine = new Line(rect.getX() + ttLeft.getByX()+ttRight.getByX(), rect.getY() + ttUp.getByY(), fire.getX(), fire.getY());
            waterLine.setStroke(Color.BLUE);
            root.getChildren().add(waterLine);
            if(fire.getHeight()<=0){
                root.getChildren().remove(waterLine);
            }
        });

        sequentialTransition.setOnFinished(event -> {
            Line waterLine = new Line(rect.getX() + ttLeft.getByX()+ttRight.getByX(), rect.getY() + ttUp.getByY(), additionalFire.getX(), additionalFire.getY());
            if(additionalFire.getHeight()>0) {
                waterLine.setStroke(Color.BLUE);
                root.getChildren().add(waterLine);
            }
            if(additionalFire.getHeight()<=0){
                root.getChildren().remove(waterLine);
            }
        });

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

    public Rectangle LeftLower(Rectangle fire,Rectangle additionalFire,Group root) {
        Rectangle rect = new Rectangle(470, 270, 50, 30);
        rect.setFill(Color.VIOLET);

        TranslateTransition ttLeft = new TranslateTransition(Duration.millis(2000));
        ttLeft.setToX(-190);

        TranslateTransition ttUp = new TranslateTransition(Duration.millis(2000));
        ttUp.setToY(215);

        TranslateTransition ttLeft1 = new TranslateTransition(Duration.millis(2000));
        ttLeft1.setToX(-300);

        SequentialTransition sequentialTransition = new SequentialTransition(rect, ttLeft, ttUp,ttLeft1);


        sequentialTransition.play();

        sequentialTransition.setOnFinished(event -> {
            Line waterLine = new Line(190,500, fire.getX(), fire.getY());
            waterLine.setStroke(Color.BLUE);
            root.getChildren().add(waterLine);
            if(fire.getHeight()<=0){
                root.getChildren().remove(waterLine);
            }
        });

        sequentialTransition.setOnFinished(event -> {
            Line waterLine = new Line(190, 500, additionalFire.getX(), additionalFire.getY());
            if(additionalFire.getHeight()>0) {
                waterLine.setStroke(Color.BLUE);
                root.getChildren().add(waterLine);
            }
            if(additionalFire.getHeight()<=0){
                root.getChildren().remove(waterLine);
            }
        });



        if(fire.getHeight()<=0) {
            TranslateTransition ttBack = new TranslateTransition(Duration.millis(2000), rect);
            ttBack.setByX(300);

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
    public static void moveRectangleBasedOnFirePosition(Rectangle fire,Rectangle additionalFire, Group root) {
        double x = fire.getX();
        double y = fire.getY();
        ControlRoom controlRoom = new ControlRoom();


        if (x >= 300 && x < 600 && y >= 0 && y < 300) {
            Rectangle rect = controlRoom.RightUpper(fire,additionalFire,root);
            root.getChildren().add(rect);
        } else if (x >= 0 && x < 300 && y >= 0 && y < 300)
        {
            Rectangle rect = controlRoom.LeftUpper(fire,additionalFire,root);
            root.getChildren().add(rect);
        } else if (x >= 300 && x < 600 && y >= 300 && y < 600) {
            Rectangle rect = controlRoom.RightLower(fire,additionalFire,root);
            root.getChildren().add(rect);
        } else if (x >= 0 && x < 300 && y >= 300 && y < 600) {
            Rectangle rect = controlRoom.LeftLower(fire,additionalFire,root);
            root.getChildren().add(rect);
        }

    }
    public Rectangle lefupper(Rectangle fire) {



        TranslateTransition ttUpback = new TranslateTransition(Duration.millis(2000), rect);
        ttUpback.setByX(100);

        TranslateTransition ttLeftBack = new TranslateTransition(Duration.millis(1000), rect);
        ttLeftBack.setByY(3400);
        FadeTransition fadeOut = new FadeTransition(Duration.millis(1000), rect);
        fadeOut.setToValue(0);

        SequentialTransition sequentialTransition1 = new SequentialTransition(ttUpback, ttLeftBack, fadeOut);

        sequentialTransition1.play();
        return rect;
    }




}



