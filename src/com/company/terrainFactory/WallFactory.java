package com.company.terrainFactory;

import com.company.enums.Dir;

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
    @Override
    public  List<Terrain> CreateTerrain(int x, int y, Dir dir, int number){
        List<Terrain> walls = new ArrayList<>();
        for(int i=0;i<number;i++){
            Wall wall = (new Wall(x,y));
            walls.add(wall);
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
