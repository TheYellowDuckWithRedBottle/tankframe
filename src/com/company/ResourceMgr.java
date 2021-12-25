package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ResourceMgr {
    public static BufferedImage goodTankL,goodTankR,goodTankU,goodTankD;
    public static BufferedImage badTankL,badTankR,badTankU,badTankD;
    public static BufferedImage bulletL,bulletR,bulletU,bulletD;
    public static BufferedImage[] explores=new BufferedImage[16];

    static{
        try {
            goodTankU = ImageIO.read(new File("G:\\jpa\\tankframe\\src\\resource\\GoodTank1.png"));
            goodTankL =ImageUtility.rotateImage(goodTankU,-90);
            goodTankR =ImageUtility.rotateImage(goodTankU,90);
            goodTankD =ImageUtility.rotateImage(goodTankU,180);

            badTankU = ImageIO.read(new File("G:\\jpa\\tankframe\\src\\resource\\BadTank1.png"));
            badTankL =ImageUtility.rotateImage(badTankU,-90);
            badTankR =ImageUtility.rotateImage(badTankU,90);
            badTankD =ImageUtility.rotateImage(badTankU,180);

            bulletU = ImageIO.read(new File("G:\\jpa\\tankframe\\src\\resource\\bulletU.png"));
            bulletL = ImageUtility.rotateImage(bulletU,-90);
            bulletR = ImageUtility.rotateImage(bulletU,90);
            bulletD = ImageUtility.rotateImage(bulletU,180);
            for(var i =1;i<=16;i++){
                explores[i-1]=ImageIO.read(new File("G:\\jpa\\tankframe\\src\\resource\\e"+i+".gif"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
