package com.company.text;

import com.company.data.Cafe;
import com.company.thread.OneTimeSound;

public class LoadEndings implements Runnable
{
    String[] array;

    public LoadEndings(){}

    public LoadEndings(String[] array)
    {
        this.array = array;
    }

    @Override
    public void run()
    {
        try
        {
            Thread sound = new Thread(new OneTimeSound("typing.mp3"));
            sound.start();

            System.out.println();
            Thread.sleep(100);
            System.out.println();
            Thread.sleep(100);
            System.out.println();
            Thread.sleep(100);
            System.out.println();
            Thread.sleep(100);
            System.out.println();
            Thread.sleep(100);
            System.out.println();
            Thread.sleep(100);
            System.out.println();
            Thread.sleep(100);
            System.out.println();
            Thread.sleep(100);
            System.out.println("。　　　　　　　　　　　　　　　　　ﾟ　　　.　　　　　　　　　　　　　　.");
            Thread.sleep(100);
            System.out.println("　　　　　　　　　.　 .　　　　　　　　.");
            Thread.sleep(100);
            System.out.println(" 　　　　　。　　　　　　　　　　　　　　　　　　　ﾟ　　　　　　　　　。");
            Thread.sleep(100);
            System.out.println("　　.　　　　　　　　.　　　　　.　　　　　　　　　　。　　.　");
            Thread.sleep(100);
            System.out.println("　.　　　　　　　　　　　　　　                   ㅤㅤㅤㅤㅤㅤㅤㅤㅤ 　 。　　.");
            Thread.sleep(100);
            Thread.sleep(100);

            for (int i = 0; i < array.length; i++)
            {
                System.out.printf(array[i]);
                Thread.sleep(100);
            }
            System.out.println();

            System.out.println("　　.　　　　　　　　.　　　　　.　　　　　　　　　　。　　.　");
            Thread.sleep(100);
            System.out.println();
            Thread.sleep(100);

            System.out.print("　   　       　　　　　　");
            Thread.sleep(100);
            System.out.print("- ");
            Thread.sleep(100);
            System.out.print("E");
            Thread.sleep(100);
            System.out.print("n");
            Thread.sleep(100);
            System.out.print("d");
            Thread.sleep(100);
            System.out.print(" -");
            Thread.sleep(100);
            System.out.println(" 　　ﾟ　　　.　　　　　　　　　　　　　　.");
            Thread.sleep(100);
            System.out.println(",　　　　　　　　　.　 .　　　　　　　　.");
            Thread.sleep(100);
            System.out.println("　　　　　。　　　　　　　　　　　　　　　　　　　ﾟ　　　　　　　　　。");
            Thread.sleep(100);
            System.out.println("　　.　　　　　　　　.　　　　　.　　　　　　　　　　。　　.");
            Thread.sleep(100);
            System.out.println();
            Thread.sleep(100);
            System.out.println();
            Thread.sleep(100);
            System.out.println();
            Thread.sleep(100);
            System.out.println();
            Thread.sleep(100);
            System.out.println();
            Thread.sleep(100);
            System.out.println();
            Thread.sleep(100);
            System.out.println();
            Thread.sleep(100);
            System.out.println();
            Thread.sleep(100);
            System.out.println();
            Thread.sleep(100);
            System.out.println();
            Thread.sleep(100);

            sound.stop();
        }
        catch (InterruptedException e)
        {
            System.out.println(e.toString());
        }

    }
}