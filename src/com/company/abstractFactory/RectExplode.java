package com.company.abstractFactory;

import com.company.ResourceMgr;
import com.company.TankFrame;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @ClassName
 * @Description TODO
 * @Author LeviFan
 * @Date 2022/1/4 21:58
 * @Version 1.0
 **/
public class RectExplode extends BaseExplode {
    private int x, y;
    private int step=0;
    private BufferedImage[] explodes = ResourceMgr.explodes;
    private TankFrame tf;

    public RectExplode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
    }

    public void paint(Graphics g){
       // g.drawImage(explodes[step++],x,y,null);
        for(int i=1;i<10;i++){
            g.fillOval(x,y,i*20,i*20);
        }
        tf.explodes.remove(this);
    }
}
