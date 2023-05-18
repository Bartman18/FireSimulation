package com.example.testtow.Fire;

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
    public int getCenterOfFireX() {
        return centerOfFireX;
    }

    public int getCenterOfFireY() {
        return centerOfFireY;
    }

    public int getStrengh() {
        return strengh;
    }
}




