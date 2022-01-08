package com.company;

import java.awt.*;

/**
 * @ClassName
 * @Description TODO
 * @Author LeviFan
 * @Date 2022/1/8 22:21
 * @Version 1.0
 **/
public class Wall extends GameObject {
    public int width,height;

    public Wall(int x, int y, int width, int height) {
        this.x=x;
        this.y=y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void paint(Graphics g) {
        g.fillRect(x,y,width,height);
    }
}
