package com.company.model;

import com.company.GameModel;
import com.company.mediaLoad.ResourceMgr;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @ClassName
 * @Description TODO
 * @Author LeviFan
 * @Date 2022/1/30 15:34
 * @Version 1.0
 **/
public class Born extends GameObject {
    private int step = 0;
    private BufferedImage[] born = ResourceMgr.born;

    public Born(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void paint(Graphics g) {
        g.drawRect(x-born[1].getWidth()/2,y,1,1);
        g.drawImage(born[step++], x-born[2].getWidth()/2, y, null);
        if (step > born.length - 1) {
            GameModel.getInstance().objects.remove(this);
            step = 0;
        }
    }
}
