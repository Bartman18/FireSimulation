package com.example.testtow.firetrucks;

import com.example.testtow.firetrucks.FireTruck;
import javafx.scene.image.Image;

public class LightFireTruck extends FireTruck {
    private boolean isInRange;
    public LightFireTruck(int ID, int maxWaterStorage, int actualWaterStorage, float speed, float refillingSpeed,boolean isInRange){
        super(ID,maxWaterStorage,actualWaterStorage,speed,refillingSpeed);
        this.isInRange = isInRange;
    }



}
