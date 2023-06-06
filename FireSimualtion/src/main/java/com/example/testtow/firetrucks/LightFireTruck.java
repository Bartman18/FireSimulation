package com.example.testtow.firetrucks;


import javafx.scene.paint.Color;

/**
 * Obiekt LightFireTruck dziedziczy zmienne od FireTrucka
 */

public class LightFireTruck extends FireTruck {
    public LightFireTruck(int ID, double howFastIsPuttingOff,  Color color){
        super(ID, howFastIsPuttingOff, color);
    }
}
