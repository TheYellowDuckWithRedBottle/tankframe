package com.company;

import com.company.tankAbstract.BaseExplode;

import java.awt.*;

public class Explode extends BaseExplode {
    private int x,y;
    private int width=ResourceMgr.explores[0].getWidth(),
                heigth =ResourceMgr.explores[0].getHeight();
    private TankFrame tf;
    private int step=0;

    public Explode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
    }
    @Override
    public void paint(Graphics g){
            g.drawImage(ResourceMgr.explores[step++],x,y,null);
            if(step>=ResourceMgr.explores.length){
                this.tf.explodes.remove(this);
                step =0;
            }

    }

}
