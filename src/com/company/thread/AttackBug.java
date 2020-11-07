package com.company.thread;

import com.company.data.Bug;
import com.company.data.User;

public class AttackBug extends ComeBug implements Runnable
{
    Bug bug;

    public AttackBug(){};

    public AttackBug(Bug bug)
    {
        this.bug = bug;
    }

    @Override
    public synchronized void run()
    {
        // 유저가 벌레를 공격한다.
        try{

            Thread.sleep(500);

            System.out.println("------------------------------------------------------------------------");
            System.out.printf("                      %s님이 %s를 공격했습니다!\n",User.getName(), bug.getName());
            System.out.println("------------------------------------------------------------------------");

            // 불청객의 체력에서 유저가 입힌 데미지(숙련도)를 뺀다.
            bug.setHp(bug.getHp() - User.getSkillLevel());

            Thread.sleep(500);
            System.out.println();
            System.out.printf(" >>> %s에게 %d 데미지를 입혔습니다 <<<\n", bug.getName() , User.getSkillLevel());

            bugInfo(bug);

        }catch (InterruptedException e){
            return;
        }
    }
}
