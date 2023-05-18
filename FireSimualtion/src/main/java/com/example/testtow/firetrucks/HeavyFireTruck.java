package com.example.testtow.firetrucks;

public class HeavyFireTruck extends FireTruck {
    private int additionalExtinguisher;
    public HeavyFireTruck(int ID, int maxWaterStorage, int actualWaterStorage, float speed, float refillingSpeed,int additionalExtinguisher){
        super(ID,maxWaterStorage,actualWaterStorage,speed,refillingSpeed);
        this.additionalExtinguisher = additionalExtinguisher;

    }
}
