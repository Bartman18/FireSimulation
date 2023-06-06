package com.example.testtow.Fire;

/**
 * obiekt ogień który przyjmuje trzy integery informujące o sile płomienia, jego środku w osi X i Y
 */
public class Fire  {

    private final int strength;
    private final int centerOfFireX;
    private final int centerOfFireY;

public Fire(int strength_, int centerOfFireY_, int centerOfFireX_)
{
    this.strength = strength_;
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
        return strength;
    }
}




