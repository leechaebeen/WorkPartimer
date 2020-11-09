package com.company.thread;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import javazoom.jl.player.Player;

public class SoundThread extends Thread {
    private Player player;
    private boolean loop;
    private File file;
    private FileInputStream fis;
    private BufferedInputStream bis;


    public SoundThread(String name, boolean loop) {

        String soundPath = "C:\\Users\\billie\\IdeaProjects\\WorkPartimer\\music\\";

        try {
            this.loop=loop;
            file=new File(soundPath + name);
            fis=new FileInputStream(file);
            bis=new BufferedInputStream(fis);
            player=new Player(bis);
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void finish() {
        loop=false;
        player.close();
        this.interrupt();
    }

    @Override
    public void run() {
        try {
            do {
                player.play();
                fis=new FileInputStream(file);
                bis=new BufferedInputStream(fis);
                player=new Player(bis);
            }while(loop);
        }catch(Exception e) {
            System.out.println(e.toString());
        }
    }



}

