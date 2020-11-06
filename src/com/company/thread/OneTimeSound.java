package com.company.thread;

import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class OneTimeSound implements Runnable
{
    private Player player;
    private File file;
    private FileInputStream fis;
    private BufferedInputStream bis;
    private boolean isLoop = true;

    public OneTimeSound()
    {
    }

    public OneTimeSound(String name)
    {
        String soundPath = "C:\\Users\\billie\\IdeaProjects\\WorkPartimer\\music\\";
        try
        {
            file = new File(soundPath + name);
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            player = new Player(bis);

        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }

    public void run()
    {
        System.out.println("OneTimeSound run() 시작");
        //this.setName("SoundThread");

        try
        {
            player.play();

        } catch (Exception e)
        {
            System.out.println(e.toString());
        }

        player.close();

    } // end run

}
