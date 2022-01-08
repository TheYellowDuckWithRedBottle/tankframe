package com.company.Collide;

import com.company.GameObject;
import com.company.Tank;
import com.company.Wall;

import java.awt.*;

/**
 * @ClassName
 * @Description TODO
 * @Author LeviFan
 * @Date 2022/1/8 22:52
 * @Version 1.0
 **/
public class TankWallCollider implements Collider {
    @Override
    public boolean collide(GameObject go1, GameObject go2) {
        if(go1 instanceof Tank &&go2 instanceof Wall){
            Tank tank = (Tank) go1;
            Wall wall = (Wall) go2;
            Rectangle tankRec = new Rectangle(tank.getX(),tank.getY(),tank.getWidth(),tank.getHeight());
            Rectangle wallRect =new Rectangle(wall.x,wall.y,wall.width,wall.height);
            if(wallRect.intersects(tankRec)){
                tank.setX(tank.oldX);
                tank.setY(tank.oldY);
            };
        }
        if(go1 instanceof Wall &&go2 instanceof Tank){
            Wall wall = (Wall) go1;
            Tank tank = (Tank) go2;
            Rectangle tankRec = new Rectangle(tank.getX(),tank.getY(),tank.getWidth(),tank.getHeight());
            Rectangle wallRect =new Rectangle(wall.x,wall.y,wall.width,wall.height);
            if(wallRect.intersects(tankRec)){
                tank.setX(tank.oldX);
                tank.setY(tank.oldY);
            };
        }
        return  true;
    }
}
