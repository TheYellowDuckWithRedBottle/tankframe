package com.company.Collide;

import com.company.GameObject;
import com.company.Group;
import com.company.Tank;
import com.company.bulletStrategy.FourDirStrategy;
import com.company.props.Pantacle;
import com.company.props.Prop;

import java.awt.*;
import java.security.cert.TrustAnchor;

/**
 * @ClassName
 * @Description TODO
 * @Author LeviFan
 * @Date 2022/1/17 13:37
 * @Version 1.0
 **/
public class TankPropCollider implements Collider{
    @Override
    public boolean collide(GameObject go1, GameObject go2) {
        if(go1 instanceof Pantacle &&go2 instanceof Tank){
            Tank tank =(Tank) go2;
            if((tank.getGroup()== Group.GOOD)){
                Rectangle prop = new Rectangle(go1.x,go1.y,go1.width,go1.heigh);
                Rectangle tankRec = new Rectangle(tank.x,tank.y,tank.width,tank.heigh);
                if(prop.intersects(tankRec)){
                    ((Prop) go1).isLiving =false;
                    if(go2 instanceof Pantacle){
                        tank.fireStrategy = new FourDirStrategy();
                    }
                    return false;
                }
            }
        }
        if(go1 instanceof Tank&&go2 instanceof Pantacle){
            Tank tank =(Tank) go1;
            if((tank.getGroup()== Group.GOOD)){
                Rectangle tankRect = new Rectangle(tank.x,tank.y,tank.width,tank.height);
                Rectangle prop = new Rectangle(go2.x,go2.y,go2.width,go2.heigh);
                if(prop.intersects(tankRect)){
                    ((Prop) go2).isLiving =false;
                    if(go2 instanceof Pantacle){
                        tank.fireStrategy = new FourDirStrategy();
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
