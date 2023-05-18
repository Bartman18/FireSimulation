package com.example.testtow.Fire;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class FireControl
{

    Random generator = new Random();
    Fire fire = new Fire(3,generator.nextInt(590), generator.nextInt(590));


    public Rectangle getFire() {


        Rectangle fireSprite = new Rectangle(fire.getCenterOfFireY(),fire.getCenterOfFireY()-1,10,10);
        fireSprite.setFill(Color.ORANGE);
        return fireSprite;
    }
}
