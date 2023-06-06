package com.example.testtow;

import com.example.testtow.Fire.FireControl;
import com.example.testtow.firetrucks.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;

import java.util.Random;

/**
 * Główna funkcja programu. Jest tu wywoływanie wszystkich ważnych funkcji (z kontroli ognia, wozów strażackich i tworzenia mapy)
 * Jest zawarta tutaj pętla która sprawia że symulacja działa w kółko
 * Znajdują się też tutaj 3 rodzaje dodatkowych funkcji:
 * - PuttingOff, służaca aby gasić (zmniejszać wielkość) ognie
 * - windBehaviour, sprawdzająca czy boolean od wiatru jest prawdziwy i jeśli tak to dodawanie dodatkowych ogni
 * każdy dodatkowy płomień ma 1% szansy na sekunde aby się wygenerować
 * - choose fireTruck która sprawdza jak duze są ognie w danych częściach mapy i wysyła do nich odpowiedni wóż strażacki
 * Są też mniejsze funkcje które służą do zawracania wozów strażackich gdy skończą gasić ognie oraz getery
 * booleanów które sprawdzają czy dodatkowe ognie są wygenerowane
 */
public class HelloApplication extends Application {

    //region zmienna
    ControlRoom controlRoom = new ControlRoom();
    FireControl fireControl = new FireControl();
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
    static FireTruck fireTruck0;
    static FireTruck fireTruck1;
    static FireTruck fireTruck2;
    static FireTruck fireTruck3;

    //endregion
    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(mapGenerator.getRoot(), 800, 600, Color.GREEN);
        mapGenerator.MapGeneration(primaryStage);
        ChooseFireTruck();
        ControlRoom controlRoom = new ControlRoom();
        controlRoom.moveRectangleBasedOnFirePosition(fire0, mapGenerator.root, fireTruck0);
        controlRoom.moveRectangleBasedOnFirePosition(fire1, mapGenerator.root, fireTruck1);
        controlRoom.moveRectangleBasedOnFirePosition(fire2, mapGenerator.root, fireTruck2);
        controlRoom.moveRectangleBasedOnFirePosition(fire3, mapGenerator.root, fireTruck3);
        mapGenerator.root.getChildren().addAll(fire0, fire1, fire2, fire3);

        primaryStage.setScene(scene);
        primaryStage.show();
        new AnimationTimer() {
            @Override
            public void handle(long currentNanoTime) {

                if (schouldPutOff0) {
                    puttingOff(fire0, fireTruck0.getHowFastIsPuttingOff());
                }
                if (schouldPutOff1) {
                    puttingOff(fire1, fireTruck1.getHowFastIsPuttingOff());
                }
                if (schouldPutOff2) {
                    puttingOff(fire3, fireTruck2.getHowFastIsPuttingOff());
                }
                if (schouldPutOff3) {
                    puttingOff(fire2, fireTruck3.getHowFastIsPuttingOff());
                }


                //additionalFire waterline
                if (additionalFire0.getHeight() > 0 && fire0.getHeight() <= 0 && !isUsed0) {
                    controlRoom.LeftUpperAdditionalFire(additionalFire0, mapGenerator.root);
                    puttingOff(additionalFire0, fireTruck0.getHowFastIsPuttingOff());
                }
                if (additionalFire1.getHeight() > 0 && fire1.getHeight() <= 0 && !isUsed1) {
                    controlRoom.RightUpperAdditionalFire(additionalFire1, mapGenerator.root);
                    puttingOff(additionalFire1, fireTruck1.getHowFastIsPuttingOff());
                }
                if (additionalFire2.getHeight() > 0 && fire2.getHeight() <= 0 && !isUsed2) {
                    controlRoom.LeftLowerAdditionalFIRE(additionalFire2, mapGenerator.root);
                    puttingOff(additionalFire2, fireTruck2.getHowFastIsPuttingOff());
                }
                if (additionalFire3.getHeight() > 0 && fire3.getHeight() <= 0 && !isUsed3) {
                    controlRoom.RightLowerAdditionalFire(additionalFire3, mapGenerator.root);
                    puttingOff(additionalFire3, fireTruck3.getHowFastIsPuttingOff());

                }

                //remove water-fire
                if (fire0.getHeight() <= 0) {
                    controlRoom.getLine1Remove(mapGenerator.root);
                }
                if (fire1.getHeight() <= 0) {
                    controlRoom.getLine2Remove(mapGenerator.root);
                }
                if (fire2.getHeight() <= 0) {
                    controlRoom.getLine4Remove(mapGenerator.root);
                }
                if (fire3.getHeight() <= 0) {
                    controlRoom.getLine3Remove(mapGenerator.root);
                }

                if (additionalFire0.getHeight() <= 0.1) {
                    controlRoom.getLine6Remove(mapGenerator.root);
                }

                if (additionalFire1.getHeight() <= 0.1) {
                    controlRoom.getLine7Remove(mapGenerator.root);
                }

                if (additionalFire2.getHeight() <= 0.1) {
                    controlRoom.getLine5Remove(mapGenerator.root);
                }

                if (additionalFire3.getHeight() <= 0.1) {
                    controlRoom.getLine8Remove(mapGenerator.root);
                }
                if (fire0.getHeight() <= 0 && fire1.getHeight() <= 0 && fire1.getHeight() <= 0 && fire1.getHeight() <= 0)
                    if ((additionalFire0.getHeight() <= 0 || isUsed0) && (additionalFire1.getHeight() <= 0 || isUsed1) && (additionalFire2.getHeight() <= 0 || isUsed2) && (additionalFire3.getHeight() <= 0 || isUsed3)) {
                        MapGenerator.generateReport.setDisable(false);
                    }

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
        GenerateReport.ImportData();
        launch(args);
    }

    public void windBehavior() {
        double random = generator.nextInt(1000);
        if (random == 1 && fire0.getHeight() > 0 && isUsed0) {
            mapGenerator.root.getChildren().add(additionalFire0);
            isUsed0 = false;
        }
        if (random == 2 && fire1.getHeight() > 0 && isUsed1) {
            mapGenerator.root.getChildren().add(additionalFire1);
            isUsed1 = false;
        }
        if (random == 3 && fire2.getHeight() > 0 && isUsed2) {
            mapGenerator.root.getChildren().add(additionalFire2);
            isUsed2 = false;
        }
        if (random == 4 && fire3.getHeight() > 0 && isUsed3) {
            mapGenerator.root.getChildren().add(additionalFire3);
            isUsed3 = false;
        }
    }

    public void puttingOff(Rectangle fire, double power) {
        fire.setHeight(fire.getHeight() - power);
        fire.setWidth(fire.getWidth() - power);
    }

    public void LeftU(Rectangle fire) {
        if (fire.getHeight() <= 0 && isComingBack && (additionalFire0.getHeight() <= 0 || isUsed0)) {
            controlRoom.LeftUpperBack();
            isComingBack = false;
        }
    }

    public void RightU(Rectangle fire) {
        if (fire.getHeight() <= 0 && isComingBack2 && (additionalFire1.getHeight() <= 0 || isUsed1)) {
            controlRoom.RightUpperBack();
            isComingBack2 = false;
        }
    }

    public void RightL(Rectangle fire) {
        if (fire.getHeight() <= 0 && isComingBack3 && (additionalFire3.getHeight() <= 0 || isUsed3)) {
            controlRoom.RightLowerBack();
            isComingBack3 = false;
        }
    }

    public void LeftL(Rectangle fire) {
        if (fire.getHeight() <= 0 && isComingBack1 && (additionalFire2.getHeight() <= 0 || isUsed2)) {
            controlRoom.LeftLowerBack();
            isComingBack1 = false;
        }
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



    public void ChooseFireTruck() {
        if (fire0.getHeight() < 15) {
            fireTruck0 = new LightFireTruck(1, 0.02, Color.YELLOW);
        } else if (fire0.getHeight() > 25) {
            fireTruck0 = new HeavyFireTruck(1, 0.06, Color.PURPLE);
        } else {
            fireTruck0 = new MediumFireTrack(1, 0.04, Color.RED);
        }

        if (fire1.getHeight() < 15) {
            fireTruck1 = new LightFireTruck(1, 0.02, Color.YELLOW);
        } else if (fire1.getHeight() > 25) {
            fireTruck1 = new HeavyFireTruck(1, 0.06, Color.PURPLE);
        } else {
            fireTruck1 = new MediumFireTrack(1, 0.04, Color.RED);
        }

        if (fire2.getHeight() < 15) {
            fireTruck2 = new LightFireTruck(1, 0.02, Color.YELLOW);
        } else if (fire2.getHeight() > 25) {
            fireTruck2 = new HeavyFireTruck(1, 0.06, Color.PURPLE);
        } else {
            fireTruck2 = new MediumFireTrack(1, 0.04, Color.RED);
        }

        if (fire3.getHeight() < 15) {
            fireTruck3 = new LightFireTruck(1, 0.02, Color.YELLOW);
        } else if (fire3.getHeight() > 25) {
            fireTruck3 = new HeavyFireTruck(1, 0.06, Color.PURPLE);
        } else {
            fireTruck3 = new MediumFireTrack(1, 0.04, Color.RED);
        }
    }
}


