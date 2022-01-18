package com.company.props;

import com.company.GameModel;
import com.company.GameObject;

import java.awt.*;
import java.util.Random;

/**
 * @ClassName
 * @Description TODO
 * @Author LeviFan
 * @Date 2022/1/17 13:38
 * @Version 1.0
 **/
public abstract class Prop extends GameObject {
    Random randomPos = new Random();
    public boolean isLiving = true;
    @Override
    public  void paint(Graphics g){
        if(!isLiving){
            GameModel.getInstance().objects.remove(this);
        }
    }
}
