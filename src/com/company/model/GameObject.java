package com.company.model;

import java.awt.*;

/**
 * @ClassName
 * @Description TODO
 * @Author LeviFan
 * @Date 2022/1/8 16:17
 * @Version 1.0
 **/
public abstract class GameObject {
    public int x, y;
    public int width,heigh;
    public abstract void paint(Graphics g);

}
