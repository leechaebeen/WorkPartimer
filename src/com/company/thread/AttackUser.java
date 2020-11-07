package com.company.thread;
import com.company.data.Bug;
import com.company.data.User;


public class AttackUser extends ComeBug implements Runnable
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

            Thread.sleep(500);
            System.out.println("------------------------------------------------------------------------");
            System.out.printf("                       %s가 %s님을 공격했습니다!\n",bug.getName(), User.getName());
            System.out.println("------------------------------------------------------------------------");

            // 유저의 배틀체력에서 불청객이 입힌 데미지를 뺀다.
            user.setBattleHp(user.getBattleHp() - bug.getDamage());

            Thread.sleep(500);
            System.out.println();
            System.out.printf("                                         >>> %s님에게 %d 데미지를 입혔습니다 <<<\n", User.getName() , bug.getDamage());

            userInfo(user);

        }catch (Exception e){

        }
    }

}
