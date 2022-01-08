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
public class Explode {
    private int x, y;
    private int step=0;
    private BufferedImage[] explodes = ResourceMgr.explodes;
    private GameModel gameModel;

    public Explode(int x, int y, GameModel gameModel) {
        this.x = x;
        this.y = y;
        this.gameModel = gameModel;
    }

    public void paint(Graphics g){
        g.drawImage(explodes[step++],x,y,null);
        if(step>explodes.length-1){
            gameModel.explodes.remove(this);
            step =0;
      }
    }
}
