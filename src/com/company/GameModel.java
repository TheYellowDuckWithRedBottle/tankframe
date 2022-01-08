package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName
 * @Description TODO
 * @Author LeviFan
 * @Date 2022/1/7 23:36
 * @Version 1.0
 **/
public class GameModel {
    public List<Bullet> bullets=new ArrayList<>();
    List<Tank> tanks = new ArrayList<>();
    List<Explode> explodes = new ArrayList<>();

    Tank tank = new Tank(200,200,Group.GOOD,this);
    public GameModel() {
        for(var i=1;i<5;i++){
            tanks.add(new Tank(i*100,i*100,Group.BAD,this));
        }
    }
    public void paint(Graphics g){
        tank.paint(g);
        for(int i=0;i<bullets.size();i++){
            bullets.get(i).paint(g);
        }
        for(int i =0;i<tanks.size();i++){
            tanks.get(i).paint(g);
        }
        for(var i =0;i<bullets.size();i++){
            for(var j=0;j<tanks.size();j++){
                bullets.get(i).collideWithTank(tanks.get(j));
            }
        }
        for(var i =0;i<explodes.size();i++){
            explodes.get(i).paint(g);
        }
    }
}
