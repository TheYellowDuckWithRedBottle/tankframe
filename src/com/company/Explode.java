package com.company;

import com.company.abstractFactory.BaseExplode;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @ClassName
 * @Description TODO
 * @Author LeviFan
 * @Date 2021/12/27 13:53
 * @Version 1.0
 **/
public class Explode extends BaseExplode {
    private int x, y;
    private int step=0;
    private BufferedImage[] explodes = ResourceMgr.explodes;
    private TankFrame tf;

    public Explode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
    }

    public void paint(Graphics g){
        g.drawImage(explodes[step++],x,y,null);
        if(step>explodes.length-1){
            tf.explodes.remove(this);
            step =0;
      }
    }
}
