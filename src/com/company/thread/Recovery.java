package com.company.thread;

import com.company.data.User;
import com.company.run.GameRun;

public class Recovery extends Thread
{
    @Override
    public void run()
    {
        recovery();
    }

    public void recovery()
    {
        while(true)
        {
            try{

                // 공백 출력
                for (int i = 0; i < 60; i++)
                {
                    System.out.println();
                }
                Sound sound = new Sound("weekInfo.mp3",false);
                sound.start();

                System.out.printf(" %s님은 휴식을 취하고 있습니다...\n", User.getName());
                System.out.println();

                for (int i = 0; i < 30; i++)    // 3초동안 출력
                {
                    System.out.print("▀");
                    Thread.sleep(100);
                }

                // 현재 체력이 설정값보다 작으면 1 추가
                if(User.getHp() < User.getSetHp())
                {
                    User.setHp(User.getHp()+1);

                    System.out.println();
                    System.out.println();
                    Thread.sleep(500);

                    System.out.println("  ✨ 체력을 1 회복했습니다 ✨");
                }

                // 현재 인내력이 설정값보다 1추가
                if(User.getFeeling() < User.getSetFeeling())
                {
                    User.setFeeling(User.getFeeling() + 1);
                    Thread.sleep(500);
                    System.out.println();
                    System.out.println(" ✨ 인내력을 1 회복했습니다 ✨");
                    System.out.println();
                    System.out.println();
                }

                Thread.sleep(500);
                System.out.println("========================================================================");
                System.out.printf(" 현재 체력   : %d\n", User.getHp());
                System.out.printf(" 현재 인내력 : %d\n", User.getFeeling());
                System.out.println("========================================================================");
                Thread.sleep(500);

                if(User.getHp()==User.getSetHp()&& User.getFeeling() == User.getSetFeeling())
                {
                    Sound fullSound = new Sound("success.mp3", false);
                    fullSound.start();

                    System.out.println(" 체력과 인내력이 모두 회복되었습니다 ! ");

                    GameRun gameRun = new GameRun();
                    gameRun.weekend();
                }
            }
            catch (InterruptedException e){
                return;
            }
        }
    }

}
