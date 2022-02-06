package com.company.terrainFactory;

import com.company.enums.Dir;
import com.company.mediaLoad.ResourceMgr;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName
 * @Description TODO
 * @Author LeviFan
 * @Date 2022/1/16 18:35
 * @Version 1.0
 **/
public class WallFactory implements CreateTerrain  {
    public List<Terrain> CreateCompWall(int x, int y){
        List<Terrain> walls = new ArrayList<>();
            Wall wall1 = new Wall(x,y);
            Wall wall2 =new Wall(x+(ResourceMgr.wall.getWidth()),y);
            Wall wall3 = new Wall(x,y+ResourceMgr.wall.getHeight());
            Wall wall4 =new Wall(x+(ResourceMgr.wall.getWidth()),y+ResourceMgr.wall.getHeight());
            walls.add(wall1);
            walls.add(wall2);
            walls.add(wall3);
            walls.add(wall4);
        return walls;
    }
    @Override
    public  List<Terrain> CreateTerrain(int x, int y, Dir dir, int number,boolean isWhole){
        List<Terrain> walls = new ArrayList<>();
        for(int i=0;i<number;i++){
            Wall wall = (new Wall(x,y));
            if(isWhole){
                walls.addAll(CreateCompWall(x,y));
            }else{
                walls.add(wall);
            }
            switch (dir) {
                case LEFT:
                    x -=wall.width ;
                    break;
                case RIGHT:
                    x += wall.width;
                    break;
                case UP:
                    y -= wall.height;
                    break;
                case DOWN:
                    y += wall.height;
                    break;
                default:
                    break;
            }

        }
        return walls;
    };
}
