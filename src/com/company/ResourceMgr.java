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
    public static BufferedImage home;
    public static BufferedImage homeDestroy;
    public static BufferedImage wall;
    public static BufferedImage stell;
    public static BufferedImage grass;

    public static BufferedImage pantacel;
    public static BufferedImage timer;
    public static BufferedImage bomb;
    public static BufferedImage gun;
    public static BufferedImage life;
    public static BufferedImage shovel;

    static{
        try {

            tankU =ImageIO.read(new File("F:\\Java\\network-pop3\\tankframe\\src\\resource\\GoodTank1.png"));
            tankR = ImageUtility.RotateImage(tankU,90);
            tankL = ImageUtility.RotateImage(tankU,-90);
            tankD = ImageUtility.RotateImage(tankU,180);

            badTankU =ImageIO.read(new File("F:\\Java\\network-pop3\\tankframe\\src\\resource\\BadTank1.png"));
            badTankR = ImageUtility.RotateImage(badTankU,90);
            badTankL = ImageUtility.RotateImage(badTankU,-90);
            badTankD = ImageUtility.RotateImage(badTankU,180);

            bulletU = ImageIO.read(new File("F:\\Java\\network-pop3\\tankframe\\src\\resource\\bulletU.png"));
            bulletL = ImageUtility.RotateImage(bulletU,-90);
            bulletR = ImageUtility.RotateImage(bulletU,90);
            bulletD = ImageUtility.RotateImage(bulletU,180);

            home =ImageIO.read(new File("F:\\Java\\network-pop3\\tankframe\\src\\resource\\img\\home1.png"));
            homeDestroy = ImageIO.read(new File("F:\\Java\\network-pop3\\tankframe\\src\\resource\\img\\home_destroyed.png"));

            wall = ImageIO.read(new File("F:\\Java\\network-pop3\\tankframe\\src\\resource\\img\\walls.gif"));
            stell = ImageIO.read(new File("F:\\Java\\network-pop3\\tankframe\\src\\resource\\img\\steels.gif"));
            grass = ImageIO.read(new File("F:\\Java\\network-pop3\\tankframe\\src\\resource\\img\\grass.png"));

            pantacel= ImageIO.read(new File("F:\\Java\\network-pop3\\tankframe\\src\\resource\\img\\05.png"));
            timer= ImageIO.read(new File("F:\\Java\\network-pop3\\tankframe\\src\\resource\\img\\01.png"));
            bomb =ImageIO.read(new File("F:\\Java\\network-pop3\\tankframe\\src\\resource\\img\\04.png"));
            gun =ImageIO.read(new File("F:\\Java\\network-pop3\\tankframe\\src\\resource\\img\\06.png"));
            life=ImageIO.read(new File("F:\\Java\\network-pop3\\tankframe\\src\\resource\\img\\03.png"));
            shovel =ImageIO.read(new File("F:\\Java\\network-pop3\\tankframe\\src\\resource\\img\\02.png"));

            for(var i =1;i<17;i++){
                explodes[i]=ImageIO.read(new File("F:\\Java\\network-pop3\\tankframe\\src\\resource\\e"+i+".gif"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
