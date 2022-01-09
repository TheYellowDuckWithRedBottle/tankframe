package com.company;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @ClassName
 * @Description TODO
 * @Author LeviFan
 * @Date 2021/12/27 13:53
 * @Version 1.0
 **/
public class Explode extends GameObject {
    private int step = 0;
    private BufferedImage[] explodes = ResourceMgr.explodes;

    public Explode(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(explodes[step++], x, y, null);
        if (step > explodes.length - 1) {
            GameModel.getInstance().objects.remove(this);
            step = 0;
        }
    }
}
