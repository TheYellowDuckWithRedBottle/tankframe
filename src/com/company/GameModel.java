package com.company;

import com.company.Collide.ColliderChain;
import com.company.Map.MapBuilder;
import com.company.enums.Dir;
import com.company.enums.Group;
import com.company.mediaLoad.BgMusicMgr;
import com.company.mediaLoad.ResourceMgr;
import com.company.model.Explode;
import com.company.model.GameObject;
import com.company.model.Home;
import com.company.model.Tank;
import com.company.props.Prop;
import com.company.tankPool.TankPool;
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

    public List<GameObject> objects = new ArrayList<>();

    Tank tank = new Tank(Home.getInstance().x-ResourceMgr.wall.getWidth()*4, Home.getInstance().y, Group.GOOD, this);
    ColliderChain colliderChain = new ColliderChain();
    List<AudioClip> audioClips = BgMusicMgr.getAudios();
    List<Terrain> terrains = new ArrayList<>();

    private static final GameModel INSTANCE = new GameModel();
    public static GameModel getInstance() {
        return INSTANCE;
    }
    private GameModel() {
        //添加敌方坦克
//        for (var i = 1; i < 2; i++) {
//            objects.add(new Tank(i * 1, i * 1, Group.BAD, this));
//        }
        TankPool tankPool = TankPool.getInstance(5,5,6);
        List<Tank> tanks = tankPool.initTanks();
        for(var tank:tanks){
            objects.add(tank);
        }
        objects.add(tank);//添加我方坦克
        objects.add(Home.getInstance());//添加老窝
        CreateTerrain createWall =new WallFactory();//防御工事
        buildFortress(createWall);

        List<GameObject> terrainObjects =MapBuilder.ReadMap();//添加地图
        objects.addAll(terrainObjects);

        Prop prop= new Prop();//添加道具
        objects.add(prop);

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
                }
            }
        }
    }
    public void buildFortress(CreateTerrain createTerrain){
        Home home= Home.getInstance();
        terrains = new ArrayList<>();
        List<Terrain> fortresses = new ArrayList<>();
        List<Terrain> terrains0 =createTerrain.CreateTerrain(home.x- ResourceMgr.wall.getWidth(),home.y+ResourceMgr.wall.getHeight(),Dir.UP,2,false);
        List<Terrain> terrains1= createTerrain.CreateTerrain(home.x- ResourceMgr.wall.getWidth(),home.y-ResourceMgr.wall.getHeight(),Dir.RIGHT,4,false);//创建一个墙
        List<Terrain> terrains2= createTerrain.CreateTerrain(home.x+home.width,home.y,Dir.DOWN,3,false);

        fortresses.addAll(terrains0);
        fortresses.addAll(terrains1);
        fortresses.addAll(terrains2);

        terrains=fortresses;
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
