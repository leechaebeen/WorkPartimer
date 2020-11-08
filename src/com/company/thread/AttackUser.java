package com.company.thread;
import com.company.data.Bug;
import com.company.data.User;
import com.company.run.Battle;


public class AttackUser extends Battle implements Runnable
{
    Bug bug;
    User user;

    public AttackUser(){};

    public AttackUser(Bug bug, User user)
    {
        this.bug = bug;
        this.user = user;
    }

    @Override
    public synchronized void run()
    {
        // 벌레가 유저를 공격한다.
        try{

            System.out.println("------------------------------------------------------------------------");
            System.out.printf("                       %s가 %s님을 공격했습니다!\n",bug.getName(), User.getName());
            System.out.println("------------------------------------------------------------------------");

            Thread.sleep(500);
            System.out.println();
            System.out.printf("                                       >>> %s님이 %d 데미지를 입었습니다 <<<\n", User.getName() , bug.getDamage());

            // 유저의 배틀체력에서 불청객이 입힌 데미지를 뺀다.
            user.setBattleHp(user.getBattleHp() - bug.getDamage());
            userInfo(user);


        }catch (InterruptedException e){
            return;
        }
    }

}
