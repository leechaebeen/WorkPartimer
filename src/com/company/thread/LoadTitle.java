package com.company.thread;

public class LoadTitle implements Runnable
{
    @Override
    public void run()
    {
        try
        {
            Thread sound = new Thread(new LoopSound("typing.mp3"));
            sound.start();   // 노래 재생 쓰레드 실행

            System.out.println();
            System.out.println();

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
            System.out.print("　 　　　　　　。　　　　   　");
            Thread.sleep(100);



            String str = " WORK ! PARTIMER ! ";
            String[] strArr = str.split("");

            for (int i = 0; i < strArr.length; i++)
            {
                System.out.print(strArr[i]);
                Thread.sleep(200);
            }

            System.out.print(" 　　ﾟ　　　.　 　　　　　　　　.");
            Thread.sleep(100);
            System.out.println();
            Thread.sleep(100);
            System.out.println();
            Thread.sleep(100);
            System.out.println(",　　　　　　　　　.　 .　　　　　　　　.");
            Thread.sleep(100);
            System.out.println("　　　　　。　　　　　　　　　　　　　　　　　　　ﾟ　　　　　　　　　。");
            Thread.sleep(100);
            System.out.println("　　.　　　　　　　　.　　　　　.　　　　　　　　　　。　　.");
            Thread.sleep(100);
            System.out.println();
            System.out.println();
            System.out.println();

            sound.stop();

            //sound.interrupt(); // 사운드 쓰레드 interrupted 상태를 false 에서 true로 변경.
            //System.out.println(" sound.isInterrupted() : " + sound.isInterrupted()); // 쓰레드의 interrupted 상태를 반환 , true

        } catch (InterruptedException e)
        {
            return;
        }
    }

}

