package com.example.testtow.Fire;

import com.example.testtow.firetrucks.ControlRoom;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.Random;

public class FireControl
{
    static Text windText = new Text(650,500,"wind: false");
    public static boolean wind = false;
    static Random generator = new Random();
    //region fires
    static Rectangle fire0 = LeftUpper(30,265,30,265);
    static Rectangle fire1 = RightUpper(335,570,30,265);
    static Rectangle fire2 = LeftDown(30,265,335,570);
    static Rectangle fire3 = RightDown(335,570,335,570);
    static Rectangle additionalFire0 = LeftUpper((int)fire0.getX()-70,(int)fire0.getX()+70,(int)fire0.getY()-70,(int)fire0.getY()+70);
    static Rectangle additionalFire1 = RightUpper((int)fire1.getX()-70,(int)fire1.getX()+70,(int)fire1.getY()-70,(int)fire1.getY()+70);
    static Rectangle additionalFire2 = LeftDown((int)fire2.getX()-70,(int)fire2.getX()+70,(int)fire2.getY()-70,(int)fire2.getY()+70);
    static Rectangle additionalFire3 = RightDown((int)fire3.getX()-70,(int)fire3.getX()+70,(int)fire3.getY()-70,(int)fire3.getY()+70);
    //endregion
    public static Rectangle getFire(int Xstart, int Xend, int Ystart, int Yend) {
        Fire fire = new Fire(generator.nextInt(10,30),generator.nextInt(Xstart,Xend), generator.nextInt(Ystart,Yend));
            Rectangle fireSprite = new Rectangle(fire.getCenterOfFireY(), fire.getCenterOfFireX(), fire.getStrengh(), fire.getStrengh());
            fireSprite.setFill(Color.ORANGE);
            return fireSprite;
    }

    public static Rectangle RightUpper(int Xstart, int Xend, int Ystart, int Yend)
    {
        if (Xstart<=335)
            Xstart=335;
        if (Xend>=570)
            Xend=570;
        if (Ystart<=30)
            Ystart=30;
        if (Yend>=265)
            Yend=265;
        Rectangle fire;
        fire = getFire(Xstart,Xend,Ystart,Yend);
        fire = IsOnFireStation(fire,new Line(300, 150, 400, 150),Xstart,Xend,Ystart,Yend);
        return fire;
    }
    public static Rectangle LeftUpper(int Xstart, int Xend, int Ystart, int Yend)
    {
        if (Xstart<=30)
            Xstart=30;
        if (Xend>=265)
            Xend=265;
        if (Ystart<=30)
            Ystart=30;
        if (Yend>=265)
            Yend=265;
        Rectangle fire;
        fire = getFire(Xstart,Xend,Ystart,Yend);
        fire = GetBetterPosition(fire,new Line(150,200,150,300),Xstart,Xend,Ystart,Yend);
        return fire;
    }
    public static Rectangle RightDown(int Xstart, int Xend, int Ystart, int Yend)
    {
        if (Xstart<=335)
            Xstart=335;
        if (Xend>=570)
            Xend=570;
        if (Ystart<=335)
            Ystart=335;
        if (Yend>=570)
            Yend=570;
        Rectangle fire;
        fire = getFire(Xstart,Xend,Ystart,Yend);
        fire = GetBetterPosition(fire,new Line(300,400,400,400),Xstart,Xend,Ystart,Yend);
        return fire;
    }
    public static Rectangle LeftDown(int Xstart, int Xend, int Ystart, int Yend)
    {
        if (Xstart<=30)
            Xstart=30;
        if (Xend>=265)
            Xend=265;
        if (Ystart<=335)
            Ystart=335;
        if (Yend>=570)
            Yend=570;
        Rectangle fire;
        fire = getFire(Xstart,Xend,Ystart,Yend);
        fire = GetBetterPosition(fire,new Line(200, 500, 300, 500),Xstart,Xend,Ystart,Yend);
        return fire;
    }
    public static Rectangle GetBetterPosition(Rectangle fire, Line line, int Xstart, int Xend, int Ystart, int Yend)
    {
        for (int i = 0; i < 200; i++)
        {
            if ((fire.getX() >= line.getStartX() - 30 &&
                    fire.getX() <= line.getEndX() + 30 &&
                    fire.getY() >= line.getStartY() - 30 &&
                    fire.getY() <= line.getEndY() + 30))
            {
                fire = getFire(Xstart,Xend, Ystart,Yend);
            }
            else {break;}
        }
        return fire;
    }
    public static Rectangle IsOnFireStation(Rectangle fire, Line line, int Xstart, int Xend, int Ystart,int Yend)
    {
        fire.setX(490);
        fire.setY(240);
        for (int i = 0; i < 200; i++) {
            if ((fire.getX() >= 470 && fire.getY() >= 220) ||
                    (fire.getX() >= line.getStartX() - 30 &&
                            fire.getX() <= line.getEndX() + 30 &&
                            fire.getY() >= line.getStartY() - 30 &&
                            fire.getY() <= line.getEndY() + 30)) {
                fire = getFire(Xstart, Xend, Ystart, Yend);
            } else {
                break;
            }
        }
        return fire;
    }
    public Rectangle getFire0() {
        return fire0;
    }
    public Rectangle getFire1() {
        return fire1;
    }
    public Rectangle getFire2() {
        return fire2;
    }
    public Rectangle getFire3() {
        return fire3;
    }


    public Rectangle getAdditionalFire0() {
        return additionalFire0;
    }

    public Rectangle getAdditionalFire1() {
        return additionalFire1;
    }

    public Rectangle getAdditionalFire2() {
        return additionalFire2;
    }

    public Rectangle getAdditionalFire3() {
        return additionalFire3;
    }

    public static void windChange()
    {
        wind = (wind) ? false : true;
        windText.setText("wind: "+wind);
    }
    public Text getWindText() {
        return windText;
    }

    public static boolean isWind() {
        return wind;
    }



}

