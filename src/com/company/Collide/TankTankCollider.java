package com.company.Collide;

import com.company.model.GameObject;
import com.company.model.Tank;

import java.awt.*;

/**
 * @ClassName
 * @Description TODO
 * @Author LeviFan
 * @Date 2022/1/8 20:03
 * @Version 1.0
 **/
public class TankTankCollider implements Collider{
    @Override
    public boolean collide(GameObject go1, GameObject go2) {
        if(go1 instanceof Tank &&go2 instanceof Tank){
            Tank tank = (Tank) go1;
            Tank tank1 = (Tank) go2;
            Rectangle tankRec = new Rectangle(tank.getX(),tank.getY(),tank.getWidth(),tank.getHeight());
            Rectangle tank1Rec =new Rectangle(tank1.getX(),tank1.getY(),tank1.getWidth(),tank1.getHeight());
                if(tank1Rec.intersects(tankRec)){
                    tank.setX(tank.oldX);
                    tank.setY(tank.oldY);
                    tank1.setX(tank1.oldX);
                    tank1.setY(tank1.oldY);
                };
        }
        return  true;
    }
}
