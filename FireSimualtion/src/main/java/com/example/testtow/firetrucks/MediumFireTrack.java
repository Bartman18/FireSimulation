package com.example.testtow.firetrucks;

public class MediumFireTrack extends FireTruck {
    private int additionalEqupment;
    public MediumFireTrack(int ID, int maxWaterStorage, int actualWaterStorage, float speed, float refillingSpeed,int additionalEqupment){
        super(ID,maxWaterStorage,actualWaterStorage,speed,refillingSpeed);
        this.additionalEqupment = additionalEqupment;
    }
}
