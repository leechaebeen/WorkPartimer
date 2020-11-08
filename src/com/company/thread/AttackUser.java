package com.company.thread;
import com.company.data.Bug;
import com.company.data.User;
import com.company.run.Battle;


public class AttackUser extends Thread
{
    private Bug bug;
    private User user;
    private boolean check = true;

    public AttackUser(){};

    public AttackUser(Bug bug, User user)
    {
        this.bug = bug;
        this.user = user;
    }

    @Override
    public synchronized void run()
    {
        attackUser();
    }

    public void finish()
    {
        check = false;
        this.interrupt();
    }

    public synchronized void attackUser()
    {
        // 벌레가 유저를 공격한다.
        try{

            while(!isInterrupted())
            {
                System.out.printf(
                        "------------------------------------------------------------------------\n" +
                                "                       %s가 %s님을 공격했습니다!\n" +
                                "------------------------------------------------------------------------\n\n" +
                                "                                     >>> %s님이 %d 데미지를 입었습니다 <<<\n\n"
                        ,bug.getName(), User.getName(), User.getName() , bug.getDamage());

                user.setBattleHp(user.getBattleHp() - bug.getDamage());

                System.out.println("벌레가 공격, 벌레 체력 : " + bug.getHp() + " 유저 체력 : " + user.getBattleHp() );

                Monitoring monitoring = new Monitoring(bug, user);

                if (user.getBattleHp() < bug.getDamage() && user.getBattleHp() > 0)
                {
                    monitoring.start(); // 쓰레드 실행
                    monitoring.join();  // 쓰레드 기다리기

                    if (bug.getHp() <= 0|| user.getBattleHp()<=0) // 벌레가 죽거나 유저가 죽으면 반복 멈추기
                    {
                        finish();

                        break;
                    }
                }
                else
                {
                    monitoring.finish();
                }

                Thread.sleep(5000);

            }


            /*
            System.out.println("------------------------------------------------------------------------");
            System.out.printf("                       %s가 %s님을 공격했습니다!\n",bug.getName(), User.getName());
            System.out.println("------------------------------------------------------------------------");

            System.out.println("                                   ------------------------------------");

            Thread.sleep(500);
            System.out.println();
            System.out.printf("                                       >>> %s님이 %d 데미지를 입었습니다 <<<\n", User.getName() , bug.getDamage());

            // 유저의 배틀체력에서 불청객이 입힌 데미지를 뺀다.
            user.setBattleHp(user.getBattleHp() - bug.getDamage());
            userInfo(user);
            */

        }catch (InterruptedException e){
            return;
        }
    }



}
