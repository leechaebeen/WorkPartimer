package com.company.thread;

import com.company.data.User;

public class Ending implements Runnable
{
    String[] array;

    public Ending(){}

    public Ending(String[] array)
    {
        this.array = array;
    }

    @Override
    public void run()
    {
        try
        {
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

        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }

    }
}
