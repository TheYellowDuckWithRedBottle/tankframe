package com.company;

import com.company.Collide.ColliderChain;
import com.company.enums.Dir;
import com.company.enums.Group;
import com.company.mediaLoad.BgMusicMgr;
import com.company.model.Explode;
import com.company.model.GameObject;
import com.company.model.Home;
import com.company.model.Tank;
import com.company.props.Prop;
import com.company.terrainFactory.*;

import java.applet.AudioClip;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @ClassName
 * @Description TODO
 * @Author LeviFan
 * @Date 2022/1/7 23:36
 * @Version 1.0
 **/
public class GameModel {
    //    public List<Bullet> bullets=new ArrayList<>();
//    List<Tank> tanks = new ArrayList<>();
//    List<Explode> explodes = new ArrayList<>();

    public List<GameObject> objects = new ArrayList<>();
    Tank tank = new Tank(200, 200, Group.GOOD, this);
    ColliderChain colliderChain = new ColliderChain();
    List<AudioClip> audioClips = BgMusicMgr.getAudios();

    private static final GameModel INSTANCE = new GameModel();
    public static GameModel getInstance() {
        return INSTANCE;
    }
    private GameModel() {
        for (var i = 1; i < 2; i++) {
            objects.add(new Tank(i * 100, i * 100, Group.BAD, this));
        }
        objects.add(tank);//添加坦克
        objects.add(Home.getInstance());//添加老窝
        CreateTerrain createTerrain = new SteelFactory();//钢铁工厂
        List<Terrain> terrains= createTerrain.CreateTerrain(500,100, Dir.LEFT,5);
        CreateTerrain createWall =new WallFactory();//墙工厂
        List<Terrain> walls = createWall.CreateTerrain(600,100,Dir.RIGHT,10);
        for (var i =0;i<terrains.size();i++){
            objects.add(terrains.get(i));
        }
        for (var i =0;i<walls.size();i++){
            objects.add(walls.get(i));
        }
        Prop prop= new Prop();
        objects.add(prop);
        buildFortress(createWall);
    }
    public void add(GameObject gm){
        this.objects.add(gm);
    }
    public void destroyEmeryTanks(){
        for(var i =0;i<objects.size();i++){
            if(objects.get(i) instanceof Tank){
                Tank tank = (Tank)objects.get(i);
                Explode explode = new Explode(tank.getX(),tank.getY());
                if(tank.getGroup()==Group.BAD){
                    objects.remove(i);
                    GameModel.getInstance().objects.add(explode);
                }
            }
        }
    }
    public void freezeEmeryTanks(){
        for(var i =0;i<objects.size();i++){
            if(objects.get(i) instanceof Tank){
                Tank tank = (Tank)objects.get(i);
                if(tank.getGroup()==Group.BAD){
                    tank.setMoving(false);
//                    new Timer().schedule(new TimerTask() {
//                        public void run() {
//
//                        }
//                    }, 2000);
                }
            }
        }
    }
    public void buildFortress(CreateTerrain createTerrain){
        Home home= Home.getInstance();
        List<Terrain> fortresses = createTerrain.CreateTerrain(home.x-home.width-10,home.y,Dir.UP,2);
        fortresses.addAll(createTerrain.CreateTerrain(home.x,home.y-home.heigh-10,Dir.RIGHT,2));
        fortresses.addAll( createTerrain.CreateTerrain(home.x+home.width,home.y,Dir.DOWN,1));
        for(var fortress :fortresses){
            objects.add(fortress);
        }
    }
    public void remove(GameObject gm){
        this.objects.remove(gm);
    }
    public void paint(Graphics g) {
        //tank.paint(g);
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).paint(g);
        }
        for (var i = 0; i < objects.size(); i++) {
            for (var j = i + 1; j < objects.size(); j++) {
                var object1 = objects.get(i);
                var object2 = objects.get(j);
                colliderChain.collide(object1,object2);
            }
        }

    }
}
