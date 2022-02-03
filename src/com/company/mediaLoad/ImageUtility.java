package com.company.mediaLoad;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @ClassName
 * @Description TODO
 * @Author LeviFan
 * @Date 2021/12/27 10:35
 * @Version 1.0
 **/
public class ImageUtility {
    public static BufferedImage RotateImage(BufferedImage bufferdImage, int Angle) {
        if (bufferdImage == null) {
            return null;
        }
        if (Angle < 0) {
            Angle = Angle + 360;
        }
        int imageWidth = bufferdImage.getWidth();
        int imageHeight = bufferdImage.getHeight();

        int type = bufferdImage.getColorModel().getTransparency();
        BufferedImage img;
        Graphics2D graphics2d;
        (graphics2d = (img = new BufferedImage(imageWidth, imageHeight, type)).createGraphics()).setRenderingHint(
                RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR
        );
        graphics2d.rotate(Math.toRadians(Angle), imageWidth / 2, imageHeight / 2);
        graphics2d.drawImage(bufferdImage, 0, 0, null);
        graphics2d.dispose();
        return img;

    }
}
