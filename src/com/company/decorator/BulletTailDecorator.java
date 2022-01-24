package com.company.decorator;

import com.company.GameObject;

import java.awt.*;

/**
 * @ClassName
 * @Description TODO
 * @Author LeviFan
 * @Date 2022/1/9 13:29
 * @Version 1.0
 **/
public class BulletTailDecorator extends GameObectDecorator {
    public GameObject gm;
    public BulletTailDecorator(GameObject gm) {
        super(gm);
        this.gm = gm;
    }

    @Override
    public void paint(Graphics g) {
        gm.paint(g);
        Color color = g.getColor();
        g.setColor(Color.YELLOW);
        this.x=gm.x;
        this.y=gm.y;
        g.drawRect(x,y,30,10);
        g.setColor(color);
    }
}
