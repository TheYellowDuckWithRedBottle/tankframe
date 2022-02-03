package com.company.decorator;

import com.company.model.GameObject;

import java.awt.*;

/**
 * @ClassName
 * @Description TODO
 * @Author LeviFan
 * @Date 2022/1/9 13:11
 * @Version 1.0
 **/
public class GameObectDecorator extends GameObject {
    public GameObject gm;

    public GameObectDecorator(GameObject gm) {
        this.gm = gm;
    }

    @Override
    public void paint(Graphics g) {
        gm.paint(g);
        Color color =g.getColor();
        g.setColor(Color.YELLOW);
        g.drawLine(x,y,x+10,y+10);
        g.setColor(color);
    }
}
