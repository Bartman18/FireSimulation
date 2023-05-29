package com.example.testtow.firetrucks;


import com.example.testtow.HelloApplication;
import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class ControlRoom {

    private float howBigIsFire;
    private boolean isFireOccupied;
    static Rectangle rect1;
    static Rectangle rect2;
    static Rectangle rect3;
    static Rectangle rect4;
    static Line waterLine1;
    static Line waterLine2;
    static Line waterLine3;
    static Line waterLine4;
    static Line waterLine5;
    static Line waterLine6;
    static Line waterLine7;
    static Line waterLine8;

    public static double intitalX1;
    public static double initialY1 ;

    private static double intitalX2;
    private static double inititalY2;
    private static double intitalX3;
    private static double inititalY3;
    private static double intitalX4;
    private static double inititalY4;



    public static Rectangle LeftUpper(Rectangle fire,Rectangle additionalFire,Group root) {

        rect1 = new Rectangle(470, 270, 50, 30);

        rect1.setFill(Color.VIOLET);

        TranslateTransition ttLeft = new TranslateTransition(Duration.millis(2000), rect1);
        ttLeft.setByX(-340);

        TranslateTransition ttUp = new TranslateTransition(Duration.millis(1000), rect1);
        ttUp.setByY(-100);



        SequentialTransition sequentialTransition = new SequentialTransition(ttLeft, ttUp);
        sequentialTransition.play();
        sequentialTransition.setOnFinished(event -> {
            intitalX1 = rect1.getX() + ttLeft.getByX();
            initialY1 = rect1.getY() + ttUp.getByY();

            waterLine1 = new Line(intitalX1, initialY1, fire.getX(), fire.getY());
            waterLine1.setStroke(Color.BLUE);
            root.getChildren().add(waterLine1);
            HelloApplication.schouldPutOff0=true;});
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



        return rect1;
    }

    public static Rectangle RightUpper(Rectangle fire,Rectangle additionalFire,Group root) {

        rect2 = new Rectangle(470, 270, 50, 30);

        rect2.setFill(Color.VIOLET);

        TranslateTransition ttLeft = new TranslateTransition(Duration.millis(2000), rect2);
        ttLeft.setByX(-190);

        TranslateTransition ttUp = new TranslateTransition(Duration.millis(1000), rect2);
        ttUp.setByY(-135);

        TranslateTransition ttRight = new TranslateTransition(Duration.millis(2000), rect2);
        ttRight.setByX(100);






        SequentialTransition sequentialTransition = new SequentialTransition(ttLeft, ttUp, ttRight);
        sequentialTransition.play();

        sequentialTransition.setOnFinished(event -> {
            intitalX2 = rect2.getX() +ttLeft.getByX() +ttRight.getByX();
            inititalY2 = rect2.getY() + ttUp.getByY();
            waterLine2 = new Line(rect2.getX() + ttLeft.getByX()+ ttRight.getByX(), rect2.getY() + ttUp.getByY(), fire.getX(), fire.getY());
            waterLine2.setStroke(Color.BLUE);
            root.getChildren().add(waterLine2);
            HelloApplication.schouldPutOff1 = true;
        });

       /* sequentialTransition.setOnFinished(event -> {
            Line waterLine = new Line(rect.getX() + ttLeft.getByX()+ ttRight.getByX(), rect.getY() + ttUp.getByY(), fire.getX(), fire.getY());
            if(additionalFire.getHeight()>0) {
                waterLine.setStroke(Color.BLUE);
                root.getChildren().add(waterLine);
            }
            if(additionalFire.getHeight()<=0){
                root.getChildren().remove(waterLine);
            }
        });
*/
        /*if(fire.getHeight()<=0) {
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
       }*/

        return rect2;

    }

    public static Rectangle RightLower(Rectangle fire,Rectangle additionalFire,Group root) {


        rect3 = new Rectangle(470, 270, 50, 30);
        rect3.setFill(Color.VIOLET);

        TranslateTransition ttLeft = new TranslateTransition(Duration.millis(2000), rect3);
        ttLeft.setByX(-190) ;

        TranslateTransition ttUp = new TranslateTransition(Duration.millis(2000), rect3);
        ttUp.setByY(115);

        TranslateTransition ttRight = new TranslateTransition(Duration.millis(2000), rect3);
        ttRight.setByX(100);




        SequentialTransition sequentialTransition = new SequentialTransition(ttLeft, ttUp, ttRight);
        sequentialTransition.play();

        sequentialTransition.setOnFinished(event -> {
            intitalX3 = rect3.getX() + ttLeft.getByX()+ttRight.getByX();
            inititalY3 = rect3.getY()+ttUp.getByY();
            waterLine3 = new Line(rect3.getX() + ttLeft.getByX()+ttRight.getByX(), rect3.getY() + ttUp.getByY(), fire.getX(), fire.getY());
            waterLine3.setStroke(Color.BLUE);
            root.getChildren().add(waterLine3);
            HelloApplication.schouldPutOff2 = true;

        });

/*
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
*/

       /* if(fire.getHeight()<=0) {
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
        }*/


        return rect3;

    }

    public static Rectangle LeftLower(Rectangle fire,Rectangle additionalFire,Group root) {
        rect4 = new Rectangle(470, 270, 50, 30);
        rect4.setFill(Color.VIOLET);

        TranslateTransition ttLeft = new TranslateTransition(Duration.millis(2000),rect4);
        ttLeft.setToX(-190);

        TranslateTransition ttUp = new TranslateTransition(Duration.millis(2000),rect4);
        ttUp.setToY(215);

        TranslateTransition ttLeft1 = new TranslateTransition(Duration.millis(2000),rect4);
        ttLeft1.setToX(-300);


        SequentialTransition sequentialTransition = new SequentialTransition(rect4, ttLeft, ttUp,ttLeft1);


        sequentialTransition.play();

        sequentialTransition.setOnFinished(event -> {
            intitalX4 = rect4.getX()+ ttLeft.getByX()+ ttLeft1.getByX();
            inititalY4 = rect4.getY()+ ttUp.getByY();
            waterLine4 = new Line(190,500, fire.getX(), fire.getY());
            waterLine4.setStroke(Color.BLUE);
            root.getChildren().add(waterLine4);
            HelloApplication.schouldPutOff3 = true;
        });

        /*sequentialTransition.setOnFinished(event -> {
            Line waterLine = new Line(190, 500, additionalFire.getX(), additionalFire.getY());
            if(additionalFire.getHeight()>0) {
                waterLine.setStroke(Color.BLUE);
                root.getChildren().add(waterLine);
            }
            if(additionalFire.getHeight()<=0){
                root.getChildren().remove(waterLine);
            }
        });
*/


        /*if(fire.getHeight()<=0) {
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
        }*/

        return rect4;
    }
    public static void moveRectangleBasedOnFirePosition(Rectangle fire,Rectangle additionalFire, Group root) {
        double x = fire.getX();
        double y = fire.getY();
        ControlRoom controlRoom = new ControlRoom();
        if (x >= 300 && x < 600 && y >= 0 && y < 300) {
            rect2 = controlRoom.RightUpper(fire,additionalFire,root);
            root.getChildren().add(rect2);
        } else if (x >= 0 && x < 300 && y >= 0 && y < 300)
        {
            rect1 = controlRoom.LeftUpper(fire,additionalFire,root);
            root.getChildren().add(rect1);
        } else if (x >= 300 && x < 600 && y >= 300 && y < 600) {
             rect3 = controlRoom.RightLower(fire,additionalFire,root);
            root.getChildren().add(rect3);
        } else if (x >= 0 && x < 300 && y >= 300 && y < 600) {
            rect4 = controlRoom.LeftLower(fire,additionalFire,root);
            root.getChildren().add(rect4);
        }

    }
    public Rectangle LeftUpperBack(Rectangle fire) {



        TranslateTransition ttUpback = new TranslateTransition(Duration.millis(2000), rect1);
        ttUpback.setByY(100);

        TranslateTransition ttLeftBack = new TranslateTransition(Duration.millis(1000), rect1);
        ttLeftBack.setByX(340);
        FadeTransition fadeOut = new FadeTransition(Duration.millis(1000), rect1);
        fadeOut.setToValue(0);

        SequentialTransition sequentialTransition1 = new SequentialTransition(ttUpback, ttLeftBack, fadeOut);

        sequentialTransition1.play();
        return rect1;
    }

    public Rectangle RightUpperBack(Rectangle fire){

            TranslateTransition ttRigthBack = new TranslateTransition(Duration.millis(2000), rect2);
            ttRigthBack.setByX(-100);

            TranslateTransition ttUpback = new TranslateTransition(Duration.millis(1000), rect2);
            ttUpback.setByY(135);

            TranslateTransition ttLeftBack = new TranslateTransition(Duration.millis(2000), rect2);
            ttLeftBack.setByX(190);

            FadeTransition fadeOut = new FadeTransition(Duration.millis(1000), rect2);
            fadeOut.setToValue(0);

            SequentialTransition sequentialTransition1 = new SequentialTransition(
                    ttRigthBack, ttUpback, ttLeftBack, fadeOut);
            sequentialTransition1.play();

            return rect2;

    }

    public Rectangle RightLowerBack(Rectangle fire){
        TranslateTransition ttRightBack = new TranslateTransition(Duration.millis(2000), rect3);
        ttRightBack.setByX(-100);

        TranslateTransition ttUPBack = new TranslateTransition(Duration.millis(2000), rect3);
        ttUPBack.setByY(-115);

        TranslateTransition ttRightBack1 = new TranslateTransition(Duration.millis(2000), rect3);
        ttRightBack1.setByX(190);

        FadeTransition fadeOut = new FadeTransition(Duration.millis(1000), rect3);
        fadeOut.setToValue(0);

        SequentialTransition sequentialTransition1 = new SequentialTransition(
                ttRightBack, ttUPBack, ttRightBack1, fadeOut);
        sequentialTransition1.play();

        return rect3;
    }

    public Rectangle LeftLowerBack(Rectangle fire){

            TranslateTransition ttBack = new TranslateTransition(Duration.millis(2000), rect4);
            ttBack.setByX(100);

            TranslateTransition ttDown = new TranslateTransition(Duration.millis(2000), rect4);
            ttDown.setByY(-215);

            TranslateTransition ttRightBack = new TranslateTransition(Duration.millis(2000), rect4);
            ttRightBack.setByX(190);

            FadeTransition fadeOut = new FadeTransition(Duration.millis(1000), rect4);
            fadeOut.setToValue(0);

            SequentialTransition sequentialTransition1 = new SequentialTransition(
                    ttBack, ttDown, ttRightBack, fadeOut);
            sequentialTransition1.play();

            return rect4;


    }

    public Line getLine1Remove(Group root){
        root.getChildren().remove(waterLine1);
        return waterLine1;
    }
    public Line getLine2Remove(Group root){
        root.getChildren().remove(waterLine2);
        return waterLine2;
    }
    public Line getLine3Remove(Group root){
        root.getChildren().remove(waterLine3);
        return waterLine3;
    }
    public Line getLine4Remove(Group root){
        root.getChildren().remove(waterLine4);
        return waterLine4;
    }


    public Line getLine5Remove(Group root){
        root.getChildren().remove(waterLine5);
        return waterLine5;
    }
    public Line getLine6Remove(Group root){
        root.getChildren().remove(waterLine6);
        return waterLine6;
    }
    public Line getLine7Remove(Group root){
        root.getChildren().remove(waterLine7);
        return waterLine7;
    }
    public Line getLine8Remove(Group root){
        root.getChildren().remove(waterLine8);
        return waterLine8;
    }

    public static Line LeftLowerAdditionalFIRE(Rectangle additionalFire, Group root) {
        waterLine5 = new Line(190, 500, additionalFire.getX(), additionalFire.getY());
        if (additionalFire.getHeight() > 0) {
            waterLine5.setStroke(Color.BLUE);
            root.getChildren().add(waterLine5);
        }
        return waterLine5;
    }

    public static Line LeftUpperAdditionalFire(Rectangle additionalFire, Group root){
        waterLine6 = new Line(intitalX1 ,initialY1, additionalFire.getX(), additionalFire.getY());
        if(additionalFire.getHeight()>0) {
            waterLine6.setStroke(Color.BLUE);
            root.getChildren().add(waterLine6);
        }
        return waterLine6;
    }

    public static Line RightUpperAdditionalFire(Rectangle additionalFire, Group root){
        waterLine7 = new Line(intitalX2,inititalY2, additionalFire.getX(), additionalFire.getY());
        if(additionalFire.getHeight()>0) {
            waterLine7.setStroke(Color.BLUE);
            root.getChildren().add(waterLine7);
        }

        return waterLine7;
    }

    public static Line RightLowerAdditionalFire(Rectangle additionalFire, Group root){
        waterLine8= new Line(intitalX3,inititalY3, additionalFire.getX(), additionalFire.getY());
        if(additionalFire.getHeight()>0) {
            waterLine8.setStroke(Color.BLUE);
            root.getChildren().add(waterLine8);
        }
        return waterLine8;
    }





}



