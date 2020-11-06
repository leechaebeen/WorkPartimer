package com.company.thread;

import javax.sound.sampled.*;
import java.io.File;

public class Sound2 extends Thread
{
    File file;
    AudioInputStream ais;
    AudioFormat format;
    DataLine.Info info;

    public Sound2()
    {
    }

    public Sound2(String name)
    {
        String soundPath = "C:\\Users\\billie\\IdeaProjects\\WorkPartimer\\music\\";
        try
        {
            this.file = new File(soundPath + name);
            format = ais.getFormat();
            info = new DataLine.Info(Clip.class, format);

        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }

    @Override
    public void run()
    {
        Clip clip ;

        if(!isInterrupted())
        {
            try
            {
                ais = AudioSystem.getAudioInputStream(file);
                format = ais.getFormat();
                info = new DataLine.Info(Clip.class, format);
                clip = (Clip) AudioSystem.getLine(info);
                clip.open(ais);
                clip.start();
                if(Thread.interrupted())
                {
                    System.out.println("노래멈춤");
                    clip.stop();
                    this.interrupt();

                    return;
                }

            } catch (Exception e)
            {
                System.out.println("err : " + e);
            }

        }


    }


}


