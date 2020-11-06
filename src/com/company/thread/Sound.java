package com.company.thread;

import javazoom.jl.player.Player;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class Sound implements Runnable
{
    private Player player;
    private File file;
    private FileInputStream fis;
    private BufferedInputStream bis;
    private boolean isLoop = true;

    public Sound()
    {
    }

    public Sound(String name)
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


    @Override
    public void run()
    {
        //System.out.println("Sound run() 시작");
        //this.setName("SoundThread");

        try
        {
            while (!Thread.currentThread().interrupted())
            {
                //System.out.println("노래 재생 중 ...");
                player.play();
                fis = new FileInputStream(file); //해당 음악파일을 불러온다
                bis = new BufferedInputStream(fis); // 불러온 음악파일을 버퍼에 담는다
                player = new Player(bis);

                if(Thread.currentThread().interrupted())
                {
                    System.out.println("노래멈춤");
                    player.close();
                    isLoop = false;
                    return;
                }
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }

    } // end run

} // end class









