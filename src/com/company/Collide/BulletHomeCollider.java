package com.company.Collide;

import com.company.*;
import com.company.model.Bullet;
import com.company.model.Explode;
import com.company.model.GameObject;
import com.company.model.Home;

import java.awt.*;

/**
 * @ClassName
 * @Description TODO
 * @Author LeviFan
 * @Date 2022/1/26 17:07
 * @Version 1.0
 **/
public class BulletHomeCollider implements Collider {
    @Override
    public boolean collide(GameObject go1, GameObject go2) {
        if(go1 instanceof Home && go2 instanceof Bullet){
            Home home = (Home)go1;
            Bullet bullet = (Bullet) go2;
            Rectangle homeRec = new Rectangle(home.x,home.y,home.width,home.heigh);
            Rectangle bulletRec = new Rectangle(bullet.getX(),bullet.getY(),bullet.getWidth(),bullet.getHeight());
            if(homeRec.intersects(bulletRec)){
                if(home.isAlive()){
                    home.setAlive(false);
                    ((Bullet) go2).setLiving(false);
                    Explode explode = new Explode(home.x, home.y);
                    GameModel.getInstance().objects.add(explode);
                }

            }
            return false;
        }
        if(go1 instanceof Bullet && go2 instanceof Home){
            Home home = (Home)go2;
            Bullet bullet = (Bullet) go1;
            Rectangle homeRec = new Rectangle(home.x,home.y,home.width,home.heigh);
            Rectangle bulletRec = new Rectangle(bullet.getX(),bullet.getY(),bullet.getWidth(),bullet.getHeight());
            if(homeRec.intersects(bulletRec)){
                if(home.isAlive()){
                    home.setAlive(false);
                    Explode explode = new Explode(home.x, home.y);
                    GameModel.getInstance().objects.add(explode);
                    ((Bullet) go1).setLiving(false);
                }
            }
            return false;
        }
        return true;
    }
}
