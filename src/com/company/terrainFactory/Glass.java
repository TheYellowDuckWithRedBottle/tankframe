package com.company.terrainFactory;

import com.company.GameObject;
import com.company.ResourceMgr;

import java.awt.*;

/**
 * @ClassName
 * @Description TODO
 * @Author LeviFan
 * @Date 2022/1/16 18:01
 * @Version 1.0
 **/
public class Glass extends Terrain {
    public int width,height;
    public Glass(int x, int y) {
        this.x=x;
        this.y=y;
        this.width = ResourceMgr.stell.getWidth();
        this.height = ResourceMgr.stell.getHeight();
    }

    @Override
    public void paint(Graphics g) {

    }
}
