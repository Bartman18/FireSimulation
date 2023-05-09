package com.example.testtow;

import javafx.scene.image.Image;

public class LightFireTruck extends FireTruck {
    public LightFireTruck(int ID, int maxWaterStorage, int actualWaterStorage, float speed, float refillingSpeed){
        super(ID,maxWaterStorage,actualWaterStorage,speed,refillingSpeed);
    }
    Image lightTruck = new Image("C:\\Users\\User\\Downloads\\images.png");


}
