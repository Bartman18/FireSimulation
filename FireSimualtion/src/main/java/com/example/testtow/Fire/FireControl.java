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
    Random generator = new Random();
    //region fires
    Rectangle fire0 = RightUpper();
    Rectangle fire1 = LeftUpper();
    Rectangle fire2 = RightDown();
    Rectangle fire3 = LeftDown();
    Rectangle additionalFire0 = RightUpper();
    Rectangle additionalFire1 = LeftUpper();
    Rectangle additionalFire2 = RightDown();
    Rectangle additionalFire3 = LeftDown();
    //endregion
    public Rectangle getFire(int Xstart, int Xend, int Ystart, int Yend) {
        Fire fire = new Fire(generator.nextInt(10,30),generator.nextInt(Xstart,Xend), generator.nextInt(Ystart,Yend));
            Rectangle fireSprite = new Rectangle(fire.getCenterOfFireY(), fire.getCenterOfFireX(), fire.getStrengh(), fire.getStrengh());
            fireSprite.setFill(Color.ORANGE);
            return fireSprite;
    }

    public Rectangle RightUpper()
    {
        Rectangle fire;
        fire = getFire(30,265,30,265);
        fire = GetBetterPosition(fire,new Line(150,200,150,300),30,265,30,265);
        return fire;
    }
    public Rectangle LeftUpper()
    {
        Rectangle fire;
        fire = getFire(335,570,30,265);
        fire = IsOnFireStation(fire,new Line(300, 150, 400, 150),335,570,30,265);
        return fire;
    }
    public Rectangle RightDown()
    {
        Rectangle fire;
        fire = getFire(30,265,335,570);
        fire = GetBetterPosition(fire,new Line(200, 500, 300, 500),30,265,335,570);
        return fire;
    }
    public Rectangle LeftDown()
    {
        Rectangle fire;
        fire = getFire(335,570,335,570);
        fire = GetBetterPosition(fire,new Line(300,400,400,400),335,570,335,570);
        return fire;
    }
    public Rectangle GetBetterPosition(Rectangle fire, Line line, int Xstart, int Xend, int Ystart, int Yend)
    {
        for (int i = 0; i < 200; i++)
        {
            if (fire.getX() >= line.getStartX() - 30 &&
                    fire.getX() <= line.getEndX() + 30 &&
                    fire.getY() >= line.getStartY() - 30 &&
                    fire.getY() <= line.getEndY() + 30)
            {
                fire = getFire(Xstart,Xend, Ystart,Yend);
            }
            else {break;}
        }
        return fire;
    }
    public Rectangle IsOnFireStation(Rectangle fire, Line line, int Xstart, int Xend, int Ystart,int Yend)
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

