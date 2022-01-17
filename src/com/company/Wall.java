package com.company;

import com.company.terrainFactory.Terrain;

import java.awt.*;

/**
 * @ClassName
 * @Description TODO
 * @Author LeviFan
 * @Date 2022/1/8 22:21
 * @Version 1.0
 **/
public class Wall extends Terrain {
    public int width,height;

    public Wall(int x, int y) {
        this.x=x;
        this.y=y;
        this.width = ResourceMgr.wall.getWidth();
        this.height = ResourceMgr.wall.getHeight();
    }

    @Override
    public void paint(Graphics g) {
        //g.fillRect(x,y,width,height);
        g.drawImage(ResourceMgr.wall,x,y,null);

    }
}
