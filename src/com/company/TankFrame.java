package com.company;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import   java.util.List;

public class TankFrame extends Frame {
   public static int GAME_WIDTH = 1200,GAME_HEIGHT=800;
    Tank tank = new Tank(200,200,Group.GOOD,this);

   public List<Bullet> bullets=new ArrayList<>();
    List<Tank> tanks = new ArrayList<>();
    List<Explode> explodes = new ArrayList<>();

    public TankFrame() throws HeadlessException {
        setSize(GAME_WIDTH,GAME_HEIGHT);
        setResizable(false);
        setVisible(true);
        Graphics g =getGraphics();
        paint(g);
        addKeyListener(new MyKeyListener());
    }

    @Override
    public void paint(Graphics g) {
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
    Image offsetScreenImage = null;

    @Override
    public void update(Graphics g) {
        if(offsetScreenImage==null){
            offsetScreenImage = this.createImage(GAME_WIDTH,GAME_HEIGHT);
        }
        Graphics gOffScreen = offsetScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.white);
        gOffScreen.fillRect(0,0,GAME_WIDTH,GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offsetScreenImage,0,0,null);
    }

    class MyKeyListener implements KeyListener {
        boolean LEFT = false,
                RIGHT = false,
                UP= false,
                DOWN=false;
        @Override
        public void keyTyped(KeyEvent e) {
        }
        @Override
        public void keyPressed(KeyEvent e) {
           int keyCode = e.getKeyCode();
            switch (keyCode){
                case KeyEvent.VK_UP:
                    UP = true;
                    break;
                case KeyEvent.VK_DOWN:
                   DOWN = true;
                    break;
                case KeyEvent.VK_LEFT:
                    LEFT = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    RIGHT = true;
                    break;
                default:
                    break;
            }
            setTankDirection();
        }

        private void setTankDirection() {
            if(!LEFT&&!RIGHT&&!UP&&!DOWN){
                tank.setMoving(false);
            }else{
                tank.setMoving(true);
                if(LEFT) tank.setDir(Dir.LEFT);
                if(RIGHT) tank.setDir(Dir.RIGHT);
                if(UP) tank.setDir(Dir.UP);
                if(DOWN) tank.setDir(Dir.DOWN);
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode){
                case KeyEvent.VK_UP:
                    UP = false;
                    break;
                case KeyEvent.VK_DOWN:
                    DOWN = false;
                    break;
                case KeyEvent.VK_LEFT:
                    LEFT = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    RIGHT = false;
                    break;
                case KeyEvent.VK_CONTROL:
                    tank.fireStrategy.Fire(tank);
                default:
                    break;
            }
            setTankDirection();
        }
    }
}
