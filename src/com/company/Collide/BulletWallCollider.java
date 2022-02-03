package com.company.Collide;
import com.company.*;
import com.company.model.Born;
import com.company.model.Bullet;
import com.company.model.GameObject;
import com.company.terrainFactory.Wall;

import java.awt.*;

/**
 * @ClassName
 * @Description TODO
 * @Author LeviFan
 * @Date 2022/1/8 22:58
 * @Version 1.0
 **/
public class BulletWallCollider implements Collider {
    @Override
    public boolean collide(GameObject go1, GameObject go2) {
        if(go1 instanceof Bullet &&go2 instanceof Wall){
            Bullet bullet = (Bullet) go1;
            Wall wall = (Wall) go2;
            Rectangle bulletRec = new Rectangle(bullet.getX(),bullet.getY(),bullet.getWidth(),bullet.getHeight());
            Rectangle wallRec =new Rectangle(wall.x,wall.y,wall.width,wall.height);
                if(bulletRec.intersects(wallRec)){
                    wall.disappear();
                    bullet.setLiving(false);
                    Born born = new Born(bullet.x,bullet.y);
                    GameModel.getInstance().add(born);
                    return false;
                };
        }
        if(go1 instanceof Wall &&go2 instanceof Bullet){
            Wall wall = (Wall) go1;
            Bullet bullet = (Bullet) go2;
            Rectangle bulletRec = new Rectangle(bullet.getX(),bullet.getY(),bullet.getWidth(),bullet.getHeight());
            Rectangle wallRec =new Rectangle(wall.x,wall.y,wall.width,wall.height);
            if(bulletRec.intersects(wallRec)){
                Born born = new Born(bullet.x,bullet.y);
                GameModel.getInstance().add(born);
                wall.disappear();
                bullet.setLiving(false);

                return false;
            };
        }
        return true;
    }
}
