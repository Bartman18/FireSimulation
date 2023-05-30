package com.example.testtow.firetrucks;

import javafx.scene.paint.Color;

public class FireTruck {
    private final int ID;
    private final double howFastIsPuttingOff;
    private final Color color;

    public FireTruck(int ID, double howFastIsPuttingOff, Color color){
        this.ID = ID;
        this.howFastIsPuttingOff = howFastIsPuttingOff;
        this.color = color;
    }
    public int getID() {
        return ID;
    }

    public double getHowFastIsPuttingOff() {
        return howFastIsPuttingOff;
    }

    public Color getColor() {
        return color;
    }
}


