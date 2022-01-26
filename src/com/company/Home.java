package com.company;

import java.awt.*;

/**
 * @ClassName
 * @Description TODO
 * @Author LeviFan
 * @Date 2022/1/25 12:42
 * @Version 1.0
 **/
public class Home extends GameObject{
    private static final Home INSTANCE = new Home();
    private boolean isAlive = true;

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    @Override
    public void paint(Graphics g) {
        if(isAlive){
            g.drawImage(ResourceMgr.home,x,y,null);
        }else{
            g.drawImage(ResourceMgr.homeDestroy,x,y,null);
        }

    }
    public static Home getInstance(){
        return INSTANCE;
    }
    private Home() {
        x=TankFrame.GAME_WIDTH/2-ResourceMgr.home.getWidth()/2;
        y=TankFrame.GAME_HEIGHT-ResourceMgr.home.getHeight();
    }
}
