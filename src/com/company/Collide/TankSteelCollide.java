package com.company.Collide;

import com.company.model.GameObject;
import com.company.model.Tank;
import com.company.terrainFactory.Steel;

import java.awt.*;

/**
 * @ClassName
 * @Description TODO
 * @Author LeviFan
 * @Date 2022/1/16 22:48
 * @Version 1.0
 **/
public class TankSteelCollide implements Collider {
    @Override
    public boolean collide(GameObject go1, GameObject go2) {
        if(go1 instanceof Tank &&go2 instanceof Steel){
            Tank tank = (Tank) go1;
            Steel steel = (Steel) go2;
            Rectangle tankRec = new Rectangle(tank.getX(),tank.getY(),tank.getWidth(),tank.getHeight());
            Rectangle steelRect =new Rectangle(steel.x,steel.y,steel.width,steel.height);
            if(steelRect.intersects(tankRec)){
                tank.setX(tank.oldX);
                tank.setY(tank.oldY);
            };
        }
        if(go1 instanceof Steel &&go2 instanceof Tank){
            Steel steel = (Steel) go1;
            Tank tank = (Tank) go2;
            Rectangle tankRec = new Rectangle(tank.getX(),tank.getY(),tank.getWidth(),tank.getHeight());
            Rectangle steelRect =new Rectangle(steel.x,steel.y,steel.width,steel.height);
            if(steelRect.intersects(tankRec)){
                tank.setX(tank.oldX);
                tank.setY(tank.oldY);
            };
        }
        return  true;
    }
}
