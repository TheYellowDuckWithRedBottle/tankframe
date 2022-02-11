package com.company.tankPool;

import com.company.GameModel;
import com.company.TankFrame;
import com.company.enums.Dir;
import com.company.enums.Group;
import com.company.mediaLoad.ResourceMgr;
import com.company.model.Tank;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @ClassName
 * @Description TODO
 * @Author LeviFan
 * @Date 2022/2/9 14:27
 * @Version 1.0
 **/
public  class TankPool {
    private static TankPool poolFactory =new TankPool(6,6,7);
    private Random randomPos=new Random();
    private int maxObjects = 1;
    private int currentTanks =0;
    private int SpeedTank =0;
    private int Armor =0;
    private int Normal = 0;
    private static int destoryNum = 0;
    List<Tank>  tanks = new ArrayList<>();

    public static TankPool getInstance(int SpeedNum, int ArmorNum, int NormalNum){
        if(SpeedNum+ArmorNum+NormalNum>20){
            System.out.println("当前地图中坦克数量过多");
        }
        if(poolFactory==null){
            poolFactory =new TankPool(SpeedNum,ArmorNum,NormalNum);
        }
        return poolFactory;
    }
    public TankPool(int SpeedNum, int ArmorNum, int NormalNum ) {
        this.SpeedTank =SpeedNum;
        this.Armor = ArmorNum;
        this.Normal = NormalNum;
    }
    public List<Tank> initTanks(){
        while (tanks.size()<=maxObjects){
            Tank tank = getTankInstance();
            tanks.add(tank);
        }
        return tanks;
    }
    public Tank getTankInstance(){
        int[] xy= generateRandomPos();
        GameModel gm = GameModel.getInstance();
        Tank tank = new Tank(xy[0],xy[1], Group.BAD, gm);
        currentTanks+=1;
        tank.setDir(Dir.DOWN);
        tanks.add(tank);
        return tank;
    }
    public String generateRandomType(){
        int type =randomPos.nextInt(2);
        String tankType ="";
        switch (type){
            case 0:
                tankType = "speed";
                break;
            case 1:
                tankType = "armor";
                break;
            case 2:
                tankType = "normal";
                break;
        }
        return tankType;
    }
    public int[] generateRandomPos(){
        int[] xPoses= new int[]{1,TankFrame.GAME_WIDTH/2,TankFrame.GAME_WIDTH};
        int RandomX =xPoses[randomPos.nextInt(2)];
        return new int[]{RandomX, ResourceMgr.tankU.getHeight()};
    }

    public void destoryTank(Tank tank){
        tanks.remove(tank);
        currentTanks-=1;
        destoryNum++;
        if(destoryNum>=20){
            System.out.println("通关");
        }else{
            getTankInstance();
        }
    }
}
