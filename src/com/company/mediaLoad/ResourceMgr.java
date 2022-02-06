package com.company.mediaLoad;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ResourceMgr {
    public static BufferedImage tankL,tankR,tankU,tankD;
    public static BufferedImage tankL1,tankR1,tankU1,tankD1;
    public static BufferedImage tank2L,tank2R,tank2U,tank2D;
    public static BufferedImage bulletL,bulletR,bulletU,bulletD;
    public static BufferedImage badTankL,badTankR,badTankU,badTankD;
    public static BufferedImage[] explodes=new BufferedImage[17];
    public static BufferedImage[] born = new BufferedImage[4];
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
    public static BufferedImage protect;
    public static BufferedImage shovel;

    static{
        try {
            var tank =ImageIO.read(new File("F:\\Java\\network-pop3\\tankframe\\src\\resource\\img\\imgs\\tank_T1_2.png"));
            tankU =tank.getSubimage(0,0,tank.getWidth()/2,tank.getHeight()/4);
            tankD=ImageUtility.RotateImage(tankU,180);;
            tankR = ImageUtility.RotateImage(tankU,90);
            tankL = ImageUtility.RotateImage(tankU,-90);

            var tank1 =ImageIO.read(new File("F:\\Java\\network-pop3\\tankframe\\src\\resource\\img\\imgs\\tank_T2_1.png"));
            tankU1 =tank.getSubimage(0,0,tank1.getWidth()/2,tank1.getHeight()/4);
            tankR1 = ImageUtility.RotateImage(tankU1,90);
            tankD1=ImageUtility.RotateImage(tankR1,90);;
            tankL1 = ImageUtility.RotateImage(tankU1,-90);

            var tank2 =ImageIO.read(new File("F:\\Java\\network-pop3\\tankframe\\src\\resource\\img\\imgs\\tank_T2_2.png"));
            tank2U =tank.getSubimage(0,0,tank2.getWidth()/2,tank2.getHeight()/4);
            tank2D=ImageUtility.RotateImage(tank2U,180);
            tank2R = ImageUtility.RotateImage(tank2U,90);
            tank2L = ImageUtility.RotateImage(tank2U,-90);

            var badTank = ImageIO.read(new File("F:\\Java\\network-pop3\\tankframe\\src\\resource\\img\\imgs\\enemy_1_0.png"));
            badTankU =badTank.getSubimage(0,0,tank.getWidth()/2,tank.getHeight()/4);
            badTankR = ImageUtility.RotateImage(badTankU,90);
            badTankL = ImageUtility.RotateImage(badTankU,-90);
            badTankD = ImageUtility.RotateImage(badTankU,180);

            bulletU = ImageIO.read(new File("F:\\Java\\network-pop3\\tankframe\\src\\resource\\img\\imgs\\bullet_up.png"));
            bulletL = ImageUtility.RotateImage(bulletU,-90);
            bulletR = ImageUtility.RotateImage(bulletU,90);
            bulletD = ImageUtility.RotateImage(bulletU,180);

            home =ImageIO.read(new File("F:\\Java\\network-pop3\\tankframe\\src\\resource\\img\\imgs\\home1.png"));
            homeDestroy = ImageIO.read(new File("F:\\Java\\network-pop3\\tankframe\\src\\resource\\img\\home_destroyed.png"));

            wall = ImageIO.read(new File("F:\\Java\\network-pop3\\tankframe\\src\\resource\\img\\imgs\\brick.png"));
            stell = ImageIO.read(new File("F:\\Java\\network-pop3\\tankframe\\src\\resource\\img\\imgs\\iron.png"));
            grass = ImageIO.read(new File("F:\\Java\\network-pop3\\tankframe\\src\\resource\\img\\grass.png"));

            pantacel= ImageIO.read(new File("F:\\Java\\network-pop3\\tankframe\\src\\resource\\img\\05.png"));
            timer= ImageIO.read(new File("F:\\Java\\network-pop3\\tankframe\\src\\resource\\img\\01.png"));
            bomb =ImageIO.read(new File("F:\\Java\\network-pop3\\tankframe\\src\\resource\\img\\04.png"));
            shovel =ImageIO.read(new File("F:\\Java\\network-pop3\\tankframe\\src\\resource\\img\\imgs\\food_iron.png"));
            gun =ImageIO.read(new File("F:\\Java\\network-pop3\\tankframe\\src\\resource\\img\\06.png"));
            life=ImageIO.read(new File("F:\\Java\\network-pop3\\tankframe\\src\\resource\\img\\03.png"));
            protect = ImageIO.read(new File("F:\\Java\\network-pop3\\tankframe\\src\\resource\\img\\imgs\\food_protect.png"));


            for(var i =1;i<8;i++){
                explodes[i]=ImageIO.read(new File("F:\\Java\\network-pop3\\tankframe\\src\\resource\\img\\blast"+i+".gif"));
            }

            for(var i =1;i<born.length;i++){
                born[i]=ImageIO.read(new File("F:\\Java\\network-pop3\\tankframe\\src\\resource\\img\\born"+i+".gif"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
