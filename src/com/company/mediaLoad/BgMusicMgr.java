package com.company.mediaLoad;

import javafx.scene.media.AudioClip;

import java.applet.Applet;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName
 * @Description TODO
 * @Author LeviFan
 * @Date 2022/2/2 12:05
 * @Version 1.0
 **/
public class BgMusicMgr {
    public static final  String Blast ="";
    public static List<java.applet.AudioClip> getAudios(){
        List<java.applet.AudioClip> audios = new ArrayList<>();
        try{
            audios.add(Applet.newAudioClip(new File(BgMusicMgr.Blast).toURL()));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return audios;
    }

}
