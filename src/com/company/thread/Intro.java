package com.company.thread;

import com.company.data.User;

public class Intro implements Runnable
{
    @Override
    public void run()
    {
        try
        {
            System.out.printf(" %s님은 우주선에 탑승한 스파이입니다.\n", User.getName());
            Thread.sleep(500);
            System.out.println();
            Thread.sleep(500);
            System.out.println(" 하지만 스파이로서 미션을 수행하던 중 정체를 들켰습니다 ! ");
            Thread.sleep(500);
            System.out.println();
            Thread.sleep(500);
            System.out.println(" 팀원들의 치열한 토론 끝에 . . . ");
            Thread.sleep(500);

            System.out.println();
            Thread.sleep(500);
            System.out.println();
            Thread.sleep(500);


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
            System.out.println("　　.　　　　　　　　.　　　　　.　　　　　　　　　　。　　.　");
            Thread.sleep(100);

            System.out.print("　   　　。　　 　　 ");
            System.out.printf("%s",User.getName());
            Thread.sleep(200);
            System.out.print("님");
            Thread.sleep(200);
            System.out.print("은");
            Thread.sleep(200);
            System.out.print(" ");
            Thread.sleep(200);
            System.out.print("결");
            Thread.sleep(200);
            System.out.print("국");
            Thread.sleep(200);
            System.out.print(" ");
            Thread.sleep(200);
            System.out.print("추");
            Thread.sleep(200);
            System.out.print("방");
            Thread.sleep(200);
            System.out.print("당");
            Thread.sleep(200);
            System.out.print("했");
            Thread.sleep(200);
            System.out.print("습");
            Thread.sleep(200);
            System.out.print("니");
            Thread.sleep(200);
            System.out.print("다");
            Thread.sleep(200);
            System.out.print(" ");
            Thread.sleep(200);
            System.out.print(".");
            Thread.sleep(200);
            System.out.print(".");
            Thread.sleep(200);
            System.out.print(".");
            Thread.sleep(200);
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
            Thread.sleep(500);
            System.out.println();
            Thread.sleep(500);
            System.out.printf(" 이곳저곳을 떠돌던 %s님은 우여곡절 끝에 지구에 도착했습니다.\n", User.getName());
            Thread.sleep(500);
            System.out.println();
            Thread.sleep(500);
            System.out.printf(" 지구에서 살아남기 위해 %s님은 오늘부터 카페 아르바이트를 시작합니다.\n", User.getName());
            Thread.sleep(500);
            System.out.println();
            Thread.sleep(500);
            System.out.println(" 아르바이트를 진행하면서 다양한 엔딩을 모을 수 있습니다.");
            Thread.sleep(500);
            System.out.println();
            Thread.sleep(500);
            System.out.println(" 행운을 빕니다 . . . ! ");
            Thread.sleep(500);
            System.out.println();
            Thread.sleep(500);
            System.out.println();
            Thread.sleep(500);
            System.out.println();
            Thread.sleep(500);
            System.out.println(" ※ 주의 ※ 프로그램을 종료하면 공개된 엔딩이 사라집니다. ");
            Thread.sleep(500);
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }
}
