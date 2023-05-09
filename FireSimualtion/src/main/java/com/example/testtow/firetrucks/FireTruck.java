package com.example.testtow.firetrucks;

public class FireTruck {
    private int ID;
    private int maxWaterStorage;
    private int actualWaterStorage;
    private float speed;
    private  float refillingSpeed;

    public FireTruck(int ID, int maxWaterStorage, int actualWaterStorage, float speed, float refillingSpeed){
        this.ID = ID;
        this.maxWaterStorage = maxWaterStorage;
        this.actualWaterStorage = actualWaterStorage;
        this.speed = speed;
        this.refillingSpeed = refillingSpeed;
    }


    public int getID() {
        return ID;
    }

    public float getRefillingSpeed() {
        return refillingSpeed;
    }

    public float getSpeed() {
        return speed;
    }

    public int getActualWaterStorage() {
        return actualWaterStorage;
    }

    public int getMaxWaterStorage() {
        return maxWaterStorage;
    }

}


