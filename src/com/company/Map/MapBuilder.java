package com.company.Map;

import com.company.enums.Dir;
import com.company.model.GameObject;
import com.company.terrainFactory.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

/**
 * @ClassName
 * @Description TODO
 * @Author LeviFan
 * @Date 2022/2/6 21:19
 * @Version 1.0
 **/
public class MapBuilder {
    public static List<GameObject> ReadMap()  {
        String originData = readFileByChars("F:\\Java\\network-pop3\\tankframe\\src\\com\\company\\Map\\data\\2.map");
        Map map = formatData(originData);
        List<GameObject> gameObjects= processFormatData(map);
        return gameObjects;
    }
    public static Map formatData (String originData){
        Map temp=new HashMap();
        Pattern pattern = Pattern.compile("BRICK=([\\d,;]*)");
        Matcher matcherBRICK =pattern.matcher(originData);
        if(matcherBRICK.find()){
            var BRICKPos =matcherBRICK.group(1);
            temp.put("BRICK",BRICKPos);
            System.out.println(matcherBRICK.group(1));
        }
        Pattern pattern1 = Pattern.compile("IRON=([\\d,;].*)");
        Matcher matcherIRON =pattern1.matcher(originData);
        if(matcherIRON.find()){
            var IRONPos =matcherIRON.group(1);
            temp.put("IRON",IRONPos);
            System.out.println(matcherIRON.group(1));
        }
        Pattern pattern2 = Pattern.compile("GLASS=(.*)");
        Matcher matcherGLASS =pattern1.matcher(originData);
        if(matcherIRON.find()){
            var GLASSPOS =matcherGLASS.group(1);
            temp.put("GLASS",GLASSPOS);
            System.out.println(matcherIRON.group(1));
        }
        Pattern patternTank = Pattern.compile("GLASS=(.*)");
        Matcher matcherTank =pattern1.matcher(originData);

        return temp;
    }

    private static List<GameObject> processFormatData(Map terrain) {
        List<GameObject> gameObjects = new ArrayList<>();
        CreateTerrain factory = null;
        if(terrain.containsKey("BRICK")){
           var coords = (String)terrain.get("BRICK");
            factory = new WallFactory();
            List<GameObject> brickObjects= processCoord(coords,factory);
            gameObjects.addAll(brickObjects);
        } if(terrain.containsKey("IRON")){
            var coords = (String)terrain.get("IRON");
            factory = new SteelFactory();
            List<GameObject> IRONObjects= processCoord(coords,factory);
            gameObjects.addAll(IRONObjects);
        } if(terrain.containsKey("GLASS")){
            var coords = (String)terrain.get("GLASS");
            factory = new GlassFactory();
            List<GameObject> GLASSObjects= processCoord(coords,factory);
            processCoord(coords,factory);
        }
        return gameObjects;
    }

    private static List<GameObject> processCoord(String coords,CreateTerrain factory) {
        List<GameObject> gameObjects = new ArrayList<>();
       String[] coordCouple = coords.split(";");
       for(var coord:coordCouple){
           var coordxy= coord.split(",");
           if(coordxy.length<2){
               System.out.println(coordxy[0]);
           }
           try{
               int y =parseInt(coordxy[0]);
               int x =parseInt(coordxy[1]);
               List<Terrain> terrain =null;
               if(coordxy.length==3){
                   int up =parseInt(coordxy[2]);
                   if(up==0){
                       terrain = factory.CreateTerrain(x*48,y*48, Dir.RIGHT,2,false);
                   }else if(up ==1){
                       terrain = factory.CreateTerrain(x*48,y*48+24, Dir.RIGHT,2,false);
                   }
                   gameObjects.addAll(terrain);
               }else{
                   terrain = factory.CreateCompWall(x*48,y*48);
                   gameObjects.addAll(terrain);
               }
           }catch (Exception e){
               System.out.println(e);
           }
       }
       return gameObjects;
    }

    public static List<Object> BuildMap(String data) {
        List<Object> objects = new ArrayList<>();
        return objects;
    }
    public static String readFileContent(InputStream inputStream) {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader reader = null;
        StringBuffer sbf = new StringBuffer();
        try {
            reader = new BufferedReader(inputStreamReader);
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                sbf.append(tempStr);
            }
            reader.close();
            return sbf.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return sbf.toString();
    }
    public static String readFileByChars(String fileName)  {
        File file = new File(fileName);
        String stringData = "";
        try{
            stringData = readFileContent(new FileInputStream(file));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return stringData;
    }
}
