package com.company.Collide;

import com.company.GameModel;
import com.company.GameObject;
import com.company.Group;
import com.company.Tank;
import com.company.bulletStrategy.FourDirStrategy;
import com.company.bulletStrategy.SpeedFireStrategy;
import com.company.props.Pantacle;
import com.company.props.Prop;
import com.company.props.PropType;

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
        if(go1 instanceof Prop &&go2 instanceof Tank){
            Tank tank =(Tank) go2;
            if((tank.getGroup()== Group.GOOD)){
                Rectangle propRect = new Rectangle(go1.x,go1.y,go1.width,go1.heigh);
                Rectangle tankRec = new Rectangle(tank.x,tank.y,tank.width,tank.heigh);
                if(propRect.intersects(tankRec)){
                    Prop prop = ((Prop) go2);
                    prop.isLiving = false;
                    switch (prop.propType){
                        case Bomb:
                            GameModel.getInstance().destroyEmeryTanks();
                            break;
                        case Helmet:
                            break;
                        case Pantcle:
                            tank.fireStrategy = new SpeedFireStrategy();
                            break;
                        case Pistol:
                            tank.fireStrategy = new FourDirStrategy();
                            break;
                        case Timer:
                            GameModel.getInstance().freezeEmeryTanks();
                            break;
                        default:
                            break;
                    }
                    return false;
                }
            }
        }
        if(go1 instanceof Tank&&go2 instanceof Prop){
            Tank tank =(Tank) go1;
            if((tank.getGroup()== Group.GOOD)){
                Rectangle tankRect = new Rectangle(tank.x,tank.y,tank.width,tank.height);
                Rectangle propRec = new Rectangle(go2.x,go2.y,go2.width,go2.heigh);
                if(propRec.intersects(tankRect)){
                   Prop prop = ((Prop) go2);
                    prop.isLiving = false;
                    switch (prop.propType){
                        case Bomb:
                            GameModel.getInstance().destroyEmeryTanks();
                            break;
                        case Helmet:
                            break;
                        case Pantcle:
                            tank.fireStrategy = new SpeedFireStrategy();
                            break;
                        case Pistol:
                            tank.fireStrategy = new FourDirStrategy();
                            break;
                        case Timer:
                            GameModel.getInstance().freezeEmeryTanks();
                            break;
                        default:
                            break;
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
