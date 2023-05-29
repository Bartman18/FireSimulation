package com.example.testtow;

import com.example.testtow.Fire.Fire;
import com.example.testtow.Fire.FireControl;
import com.example.testtow.firetrucks.ControlRoom;
import com.example.testtow.firetrucks.FireTruck;
import javafx.application.Application;
import javafx.scene.Group;
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
    ControlRoom controlRoom = new ControlRoom();

    FireControl fireControl = new FireControl();
    static Text testText = new Text(650,200,"0");
    static MapGenerator mapGenerator = new MapGenerator();
    Random generator = new Random();
    static boolean isUsed0 = true;
    static boolean isUsed1 = true;
    static boolean isUsed2 = true;
    static boolean isUsed3 = true;
    boolean isComingBack = true;
    boolean isComingBack1 = true;
    boolean isComingBack2 = true;
    boolean isComingBack3 = true;
    public static boolean schouldPutOff0 = false;
    public static boolean schouldPutOff1 = false;
    public static boolean schouldPutOff2 = false;
    public static boolean schouldPutOff3 = false;

    Rectangle fire0 = fireControl.getFire0();
    Rectangle fire1 = fireControl.getFire1();
    Rectangle fire2 = fireControl.getFire2();
    Rectangle fire3 = fireControl.getFire3();
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
            ControlRoom controlRoom = new ControlRoom();
            controlRoom.moveRectangleBasedOnFirePosition(fire0,additionalFire0,mapGenerator.root);
            controlRoom.moveRectangleBasedOnFirePosition(fire1,additionalFire0,mapGenerator.root);
            controlRoom.moveRectangleBasedOnFirePosition(fire2,additionalFire0,mapGenerator.root);
            controlRoom.moveRectangleBasedOnFirePosition(fire3,additionalFire0,mapGenerator.root);
            mapGenerator.root.getChildren().addAll(fire0, fire1, fire2, fire3);

            primaryStage.setScene(scene);
            primaryStage.show();
            new AnimationTimer() {
                @Override public void handle(long currentNanoTime) {

                    if (schouldPutOff0) {
                        puttingOff(fire0, 0.03);
                    }
                    if(schouldPutOff1){
                        puttingOff(fire1, 0.03);
                    }
                   if(schouldPutOff2){
                        puttingOff(fire3, 0.03);
                    }
                    if(schouldPutOff3){
                        puttingOff(fire2, 0.03);
                    }


                    if(fire0.getHeight()<=0){
                        controlRoom.getLine1Remove(mapGenerator.root);
                        controlRoom.LeftUpperAdditionalFire(additionalFire0,mapGenerator.root);

                    }
                    if(fire1.getHeight()<=0){
                        controlRoom.getLine2Remove(mapGenerator.root);
                        controlRoom.RightUpperAdditionalFire(additionalFire1,mapGenerator.root);;

                    }
                    if(fire2.getHeight()<=0){
                        controlRoom.getLine4Remove(mapGenerator.root);
                        controlRoom.LeftLowerAdditionalFIRE(additionalFire2,mapGenerator.root);

                    }
                    if(fire3.getHeight()<=0){
                        controlRoom.getLine3Remove(mapGenerator.root);
                        controlRoom.RightLowerAdditionalFire(additionalFire3,mapGenerator.root);

                    }


                    if(fire0.getHeight()<=0 && fire1.getHeight()<=0 && fire1.getHeight()<=0 && fire1.getHeight()<=0)
                        //if((additionalFire0.getHeight()<=0||isUsed0)&&(additionalFire1.getHeight()<=0||isUsed1)&&(additionalFire2.getHeight()<=0||isUsed2)&&(additionalFire3.getHeight()<=0||isUsed3)){
                            MapGenerator.generateReport.setDisable(false);
                        //}

                    LeftU(fire0);
                    RightU(fire1);
                    LeftL(fire2);
                    RightL(fire3);
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
        public static void main(String[] args) {
            GenerateReport.ImportData(new String[0]);
            launch(args);}


    public static Text getTestText() {
        return testText;
    }

    public void windBehavior()
    {
        double random = generator.nextInt(4000);
        if (random == 1 && fire0.getHeight()>0 && isUsed0)
        {
            mapGenerator.root.getChildren().add(additionalFire0);
            isUsed0 = false;
        }
        if (random == 2 && fire1.getHeight()>0 && isUsed1)
        {
            mapGenerator.root.getChildren().add(additionalFire1);
            isUsed1 = false;
        }
        if (random == 3 && fire2.getHeight()>0 && isUsed2)
        {
            mapGenerator.root.getChildren().add(additionalFire2);
            isUsed2 = false;
        }
        if (random == 4 && fire3.getHeight()>0 && isUsed3)
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
    public Rectangle LeftU(Rectangle fire){

        if(fire.getHeight()<=0 && isComingBack && (additionalFire0.getHeight()<=0 || isUsed0)){
            controlRoom.LeftUpperBack(fire);
            isComingBack =false;
        }

        return fire;
    }
    public Rectangle RightU(Rectangle fire){
            if(fire.getHeight()<=0 && isComingBack2 && (additionalFire1.getHeight()<=0 || isUsed1)){
                controlRoom.RightUpperBack(fire);
                isComingBack2 = false;
            }
            return  fire;
    }
    public Rectangle RightL(Rectangle fire){
        if(fire.getHeight()<=0 && isComingBack3 && (additionalFire3.getHeight()<=0 || isUsed3)  ){
            controlRoom.RightLowerBack(fire);
            isComingBack3 = false;
        }
        return  fire;
    }
    public Rectangle LeftL(Rectangle fire){
        if(fire.getHeight()<=0 && isComingBack1 && (additionalFire2.getHeight()<=0 || isUsed2)){
            controlRoom.LeftLowerBack(fire);
            isComingBack1 = false;
        }
        return  fire;
    }




    public boolean getIsUsed0() {
        return isUsed0;
    }
    public boolean getIsUsed1() {
        return isUsed1;
    }
    public boolean getIsUsed2() {
        return isUsed2;
    }
    public boolean getIsUsed3() {
        return isUsed3;
    }

}


