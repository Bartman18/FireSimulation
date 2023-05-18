package com.example.testtow.Fire;


import java.util.Random;

import static java.lang.Math.random;

public class Fire  {
    private int strengh;
    private  int centerOfFireX;
    private int centerOfFireY;

public Fire(int strengh_, int centerOfFireY_, int centerOfFireX_)
{
    this.strengh = strengh_;
    this.centerOfFireY = centerOfFireY_;
    this.centerOfFireX = centerOfFireX_;
}

    public void setCenterOfFire(int centerOfFireX, int centerOfFireY) {
        this.centerOfFireX = centerOfFireX;
        this.centerOfFireY = centerOfFireY;
    }

    public int getCenterOfFireX() {
        return centerOfFireX;
    }

    public int getCenterOfFireY() {
        return centerOfFireY;
    }

}




