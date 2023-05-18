package com.example.testtow.Fire;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class FireControl
{
    Random generator = new Random();


    public Rectangle getFire(int Xstart, int Xend, int Ystart, int Yend) {
        Fire fire = new Fire(generator.nextInt(10,30),generator.nextInt(Xstart,Xend), generator.nextInt(Ystart,Yend));
            Rectangle fireSprite = new Rectangle(fire.getCenterOfFireY(), fire.getCenterOfFireX(), fire.getStrengh(), fire.getStrengh());
            fireSprite.setFill(Color.ORANGE);
            return fireSprite;
    }
    public void FixFirePlace()
    {

    }
}
