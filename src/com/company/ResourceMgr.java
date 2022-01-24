package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ResourceMgr {
    public static BufferedImage tankL,tankR,tankU,tankD;
    public static BufferedImage bulletL,bulletR,bulletU,bulletD;
    public static BufferedImage badTankL,badTankR,badTankU,badTankD;
    public static BufferedImage[] explodes=new BufferedImage[17];
    public static BufferedImage wall;
    public static BufferedImage stell;
    public static BufferedImage grass;

    public static BufferedImage bomb;
    public static BufferedImage timer;
    public static BufferedImage gun;
    public static BufferedImage protect;
    public static BufferedImage pantacel;
    public static BufferedImage life;
    public static BufferedImage iron;


    static{
        try {

            tankU =ImageIO.read(new File("G:\\jpa\\tankframe\\src\\resource\\GoodTank1.png"));
            tankR = ImageUtility.RotateImage(tankU,90);
            tankL = ImageUtility.RotateImage(tankU,-90);
            tankD = ImageUtility.RotateImage(tankU,180);

            badTankU =ImageIO.read(new File("G:\\jpa\\tankframe\\src\\resource\\BadTank1.png"));
            badTankR = ImageUtility.RotateImage(badTankU,90);
            badTankL = ImageUtility.RotateImage(badTankU,-90);
            badTankD = ImageUtility.RotateImage(badTankU,180);

            bulletU = ImageIO.read(new File("G:\\jpa\\tankframe\\src\\resource\\bulletU.png"));
            bulletL = ImageUtility.RotateImage(bulletU,-90);
            bulletR = ImageUtility.RotateImage(bulletU,90);
            bulletD = ImageUtility.RotateImage(bulletU,180);

            wall = ImageIO.read(new File("G:\\jpa\\tankframe\\src\\resource\\walls.gif"));
            stell = ImageIO.read(new File("G:\\jpa\\tankframe\\src\\resource\\steels.gif"));
            grass = ImageIO.read(new File("G:\\jpa\\tankframe\\src\\resource\\glass.gif"));

            pantacel= ImageIO.read(new File("G:\\jpa\\tankframe\\src\\resource\\food_star.png"));
            timer= ImageIO.read(new File("G:\\jpa\\tankframe\\src\\resource\\food_clock.png"));
            bomb =ImageIO.read(new File("G:\\jpa\\tankframe\\src\\resource\\food_boom.png"));
            gun =ImageIO.read(new File("G:\\jpa\\tankframe\\src\\resource\\food_gun.png"));
            protect =ImageIO.read(new File("G:\\jpa\\tankframe\\src\\resource\\food_protect.png"));
            life =ImageIO.read(new File("G:\\jpa\\tankframe\\src\\resource\\food_tank.png"));
            iron =ImageIO.read(new File("G:\\jpa\\tankframe\\src\\resource\\food_iron.png"));

            for(var i =1;i<17;i++){
                explodes[i]=ImageIO.read(new File("G:\\jpa\\tankframe\\src\\resource\\e"+i+".gif"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
