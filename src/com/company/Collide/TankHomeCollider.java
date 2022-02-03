package com.company.Collide;

import com.company.model.GameObject;
import com.company.model.Home;
import com.company.model.Tank;

import java.awt.*;

/**
 * @ClassName
 * @Description TODO
 * @Author LeviFan
 * @Date 2022/1/29 21:49
 * @Version 1.0
 **/
public class TankHomeCollider implements  Collider{
    @Override
    public boolean collide(GameObject go1, GameObject go2) {
        if(go1 instanceof Home &&go2 instanceof Tank){
            Home home = (Home) go1;
            Tank tank = (Tank) go2;
            Rectangle homeRec = new Rectangle(home.x,home.y,home.width,home.heigh);
            Rectangle tankRec =new Rectangle(tank.x,tank.y,tank.width,tank.height);
            if(homeRec.intersects(tankRec)){
                tank.setX(tank.oldX);
                tank.setY(tank.oldY);
            };
        }
        if(go1 instanceof Tank &&go2 instanceof Home){
            Tank tank = (Tank) go1;
            Home home = (Home) go2;
            Rectangle homeRec = new Rectangle(home.x,home.y,home.width,home.heigh);
            Rectangle tankRec =new Rectangle(tank.x,tank.y,tank.width,tank.height);
            if(homeRec.intersects(tankRec)){
                tank.setX(tank.oldX);
                tank.setY(tank.oldY);
            };
        }
        return true;
    }
}
