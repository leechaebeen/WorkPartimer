package com.company.action;

import com.company.data.User;
import com.company.etc.LoopSound;
import com.company.thread.SoundThread;

public class PrintAction
{

    public void printAfterDay()
    {
        try
        {
            SoundThread sound = new SoundThread("weekInfo.mp3",false);
            sound.start();

            System.out.print(" ");
            Thread.sleep(20);
            System.out.print("☾");
            Thread.sleep(30);
            System.out.print(" ");
            Thread.sleep(20);
            System.out.print("⋆");
            Thread.sleep(30);
            System.out.print("*");
            Thread.sleep(30);
            System.out.print("･");
            Thread.sleep(30);
            System.out.print("ﾟ");
            Thread.sleep(30);
            System.out.print(" ");
            Thread.sleep(30);
            System.out.print("⋆");
            Thread.sleep(30);
            System.out.print("*");
            Thread.sleep(30);
            System.out.print("･");
            Thread.sleep(30);
            System.out.print("ﾟ");
            Thread.sleep(30);
            System.out.print(" ");
            Thread.sleep(20);
            System.out.print("⋆");
            Thread.sleep(20);
            System.out.print(".");
            Thread.sleep(20);
            System.out.print(" ");
            Thread.sleep(20);
            System.out.print("･");
            Thread.sleep(20);
            System.out.print("ﾟ");
            Thread.sleep(20);
            System.out.print(".");
            Thread.sleep(20);
            System.out.print(" ");
            Thread.sleep(20);
            System.out.print("⋆");
            Thread.sleep(20);
            System.out.print(" ");
            Thread.sleep(20);
            System.out.print("*");
            Thread.sleep(20);
            System.out.print(" ");
            Thread.sleep(20);
            System.out.print("･");
            Thread.sleep(20);
            System.out.print("ﾟ");
            Thread.sleep(20);
            System.out.print(".");
            Thread.sleep(20);
            System.out.print(" ");
            Thread.sleep(20);
            System.out.print("⋆");
            Thread.sleep(20);
            System.out.print("⋆");
            Thread.sleep(20);
            System.out.print(" ");
            Thread.sleep(20);
            System.out.print("*");
            Thread.sleep(20);
            System.out.print("･");
            Thread.sleep(20);
            System.out.print("ﾟ");
            Thread.sleep(20);
            System.out.print("⋆");
            Thread.sleep(20);
            System.out.print("*");
            Thread.sleep(20);
            System.out.print("･");
            Thread.sleep(20);
            System.out.print("ﾟ");
            Thread.sleep(20);
            System.out.print(" ");
            Thread.sleep(20);
            System.out.print("⋆");
            Thread.sleep(20);
            System.out.print(" ");
            Thread.sleep(20);
            System.out.print(".");
            Thread.sleep(20);
            System.out.print(" ");
            Thread.sleep(20);
            System.out.print("･");
            Thread.sleep(20);
            System.out.print("ﾟ");
            Thread.sleep(20);
            System.out.print(" ");
            Thread.sleep(20);
            System.out.print(".");
            Thread.sleep(20);
            System.out.print("⋆");
            Thread.sleep(20);
            System.out.print("*");
            Thread.sleep(20);
            System.out.print("･");
            Thread.sleep(20);
            System.out.print("ﾟ");
            Thread.sleep(20);
            System.out.print(" ");
            Thread.sleep(20);
            System.out.print(".");
            Thread.sleep(20);
            System.out.print("⋆");
            Thread.sleep(20);
            System.out.print(" ");
            Thread.sleep(20);
            System.out.print("⋆");
            Thread.sleep(20);
            System.out.print("*");
            Thread.sleep(20);
            System.out.print("･");
            Thread.sleep(20);
            System.out.print("ﾟ");
            Thread.sleep(20);
            System.out.print(" ");
            Thread.sleep(20);
            System.out.print("⋆");
            Thread.sleep(20);
            System.out.print("*");
            Thread.sleep(20);
            System.out.print("･");
            Thread.sleep(20);
            System.out.print("ﾟ");
            Thread.sleep(20);
            System.out.print(" ");
            Thread.sleep(20);
            System.out.print("⋆");
            Thread.sleep(20);
            System.out.print("･");
            Thread.sleep(20);
            System.out.print("ﾟ");
            Thread.sleep(20);
            System.out.print("⋆");
            Thread.sleep(20);
            System.out.print(" ");
            Thread.sleep(20);
            System.out.print("*");
            Thread.sleep(20);
            System.out.print("･");
            Thread.sleep(20);
            System.out.print("ﾟ");
            Thread.sleep(20);
            System.out.print(" ");
            Thread.sleep(20);
            System.out.print("⋆");
            Thread.sleep(20);
            System.out.print("･ﾟ");

        }
        catch (InterruptedException e)
        {
            System.out.println(e.toString());
        }

    }

    public void printEnding(String[] array)
    {
        try
        {
            SoundThread sound = new SoundThread("typing.mp3",true);
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

            sound.finish();
        }
        catch (InterruptedException e)
        {
            System.out.println(e.toString());
        }

    }

    public void printIntro()
    {
        try
        {
            for (int i = 0; i <3; i++)
            {
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
            }

            SoundThread typingSound = new SoundThread("typing.mp3", true);
            typingSound.start();

            String str = " " + User.getName() + "님은 우주선에 숨어든 스파이입니다. ";
            String[] strArr = str.split("");

            for (int i = 0; i < strArr.length; i++)
            {
                System.out.print(strArr[i]);
                Thread.sleep(100);
            }



            System.out.println();
            Thread.sleep(100);
            System.out.println();
            Thread.sleep(100);


            str = " 하지만 스파이로서 미션을 수행하던 중 정체를 들켰습니다 ! ";
            strArr = str.split("");

            for (int i = 0; i < strArr.length; i++)
            {
                System.out.print(strArr[i]);
                Thread.sleep(100);
            }


            System.out.println();
            Thread.sleep(100);
            System.out.println();
            Thread.sleep(100);

            str = " 팀원들의 치열한 토론 끝에 . . . ";
            strArr = str.split("");

            for (int i = 0; i < strArr.length; i++)
            {
                System.out.print(strArr[i]);
                Thread.sleep(100);
            }

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
            System.out.print("　 　　　　　　。　　　 。      　");
            Thread.sleep(100);
            System.out.print("三");
            Thread.sleep(100);
            System.out.print(" ");
            Thread.sleep(100);
            System.out.print("ඞ");
            Thread.sleep(100);
            System.out.print(";");
            Thread.sleep(100);
            System.out.print(";");
            Thread.sleep(100);
            System.out.println("   　  　ﾟ　　　.　 　　　　　　　　.");
            Thread.sleep(100);
            System.out.println("　　.　　　　　　　　.　　　　　.　　　　　　　　　　　");
            Thread.sleep(100);

            System.out.print("　   　　。　　 　　 ");


            str = User.getName() + "님은 결국 추방당했습니다 . . .  ";
            strArr = str.split("");

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
            System.out.println();


            System.out.println();
            Thread.sleep(100);
            System.out.println();
            Thread.sleep(100);

            str = " 이곳저곳을 떠돌던 " + User.getName() +
                    "님은 우여곡절 끝에 지구에 도착했습니다.";
            strArr = str.split("");

            for (int i = 0; i < strArr.length; i++)
            {
                System.out.print(strArr[i]);
                Thread.sleep(100);
            }

            System.out.println();
            Thread.sleep(100);
            System.out.println();
            Thread.sleep(100);

            str = " 지구에서 살아남기 위해 " + User.getName() +
                    "님은 오늘부터 카페 아르바이트를 시작합니다.";
            strArr = str.split("");

            for (int i = 0; i < strArr.length; i++)
            {
                System.out.print(strArr[i]);
                Thread.sleep(100);
            }


            System.out.println();
            Thread.sleep(100);
            System.out.println();
            Thread.sleep(100);

            str = " 아르바이트를 진행하면서 다양한 엔딩을 모을 수 있습니다.";
            strArr = str.split("");

            for (int i = 0; i < strArr.length; i++)
            {
                System.out.print(strArr[i]);
                Thread.sleep(100);
            }
            System.out.println("");
            Thread.sleep(100);
            System.out.println();
            Thread.sleep(100);

            str = " 행운을 빕니다 . . . ! ";
            strArr = str.split("");

            for (int i = 0; i < strArr.length; i++)
            {
                System.out.print(strArr[i]);
                Thread.sleep(100);
            }

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


            str = " ※ 주의 ※ 프로그램을 종료하면 공개된 엔딩이 초기화됩니다. ";
            strArr = str.split("");


            for (int i = 0; i < strArr.length; i++)
            {
                System.out.print(strArr[i]);
                Thread.sleep(100);
            }
            System.out.println("");
            Thread.sleep(100);

            typingSound.finish();


        }
        catch (InterruptedException e)
        {
            System.out.println(e.toString());
        }
    }

    public void printTitle()
    {
        try
        {
            SoundThread sound = new SoundThread("typing.mp3", true);
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

            sound.finish();


        } catch (InterruptedException e)
        {
            System.out.println(e.toString());
        }
    }

}
