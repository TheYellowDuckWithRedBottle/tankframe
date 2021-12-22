package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ResourceMgr {
    public static BufferedImage tankL,tankR,tankU,tankD;
    public static BufferedImage bulletL,bulletR,bulletU,bulletD;

    static{
        try {

            tankL =ImageIO.read(new File("G:\\jpa\\tankframe\\src\\resource\\tankL.gif"));
            //tankL =ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("tankR.gif"));
            tankR = ImageIO.read(new File("G:\\jpa\\tankframe\\src\\resource\\tankR.gif"));
            tankU = ImageIO.read(new File("G:\\jpa\\tankframe\\src\\resource\\tankU.gif"));
            tankD = ImageIO.read(new File("G:\\jpa\\tankframe\\src\\resource\\tankD.gif"));

            bulletL = ImageIO.read(new File("G:\\jpa\\tankframe\\src\\resource\\bulletL.gif"));
            bulletR = ImageIO.read(new File("G:\\jpa\\tankframe\\src\\resource\\bulletR.gif"));
            bulletU = ImageIO.read(new File("G:\\jpa\\tankframe\\src\\resource\\bulletU.gif"));
            bulletD = ImageIO.read(new File("G:\\jpa\\tankframe\\src\\resource\\bulletD.gif"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
