package com.company.decorator;

import com.company.model.GameObject;

import java.awt.*;

/**
 * @ClassName
 * @Description TODO
 * @Author LeviFan
 * @Date 2022/1/9 13:12
 * @Version 1.0
 **/
public class BulletRecDecorator extends GameObectDecorator {
    public GameObject gm;
    public BulletRecDecorator(GameObject gameObject) {
        super(gameObject);
        this.gm=gameObject;
    }

    @Override
    public void paint(Graphics g) {
        this.x=gm.x;
        this.y=gm.y;
        gm.paint(g);
        Color color = g.getColor();
        g.setColor(Color.RED);
        g.drawRect(gm.x,gm.y,30,30);
        g.setColor(color);
    }
}
