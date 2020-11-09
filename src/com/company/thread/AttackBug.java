package com.company.thread;

import com.company.action.BattleAction;
import com.company.data.Bug;
import com.company.data.User;

import java.util.Random;

public class AttackBug extends Thread
{
    private Bug bug;

    public AttackBug(Bug bug)
    {
        this.bug = bug;
    }


    @Override
    public void run()
    {
        attackBug();
    }

    // 유저가 벌레를 공격한다.
    public void attackBug()
    {
        try
        {
            Random rd = new Random();
            int randomNum = rd.nextInt(10)+1;

            int damage;

            SoundThread sound = new SoundThread("attack.mp3",false);
            sound.start();

            if(randomNum<=7) // 1~7까지의 경우
            {
                damage = User.getSkillLevel();      // 유저의 숙련도 만큼 데미지를 입힌다
                System.out.printf("------------------------------------------------------------------------\n"
                        + "                       %s님이 %s를 공격했습니다!\n"
                        + "------------------------------------------------------------------------\n\n"
                        + " >>> %s가 %d 데미지를 입었습니다 <<<\n", User.getName(), bug.getName(), bug.getName(), damage);

            }
            else
            {
                damage = User.getSkillLevel()*2;    // 유저의 숙련도의 두배만큼 데미지를 입힌다.
                System.out.printf("------------------------------------------------------------------------\n"
                        + "                    %s님이 %s를 강하게 공격했습니다!\n"
                        + "------------------------------------------------------------------------\n\n"
                        + " >>> %s가 %d 데미지를 입었습니다 <<<\n", User.getName(), bug.getName(), bug.getName(), damage);

            }

            bug.setHp(bug.getHp() - damage);

            // test
            //System.out.println("유저가 공격, 벌레 체력 : " + bug.getHp() + " 유저 체력 : " + user.getBattleHp());
            BattleAction battleAction = new BattleAction();
            battleAction.bugInfo(bug);


        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void finish()
    {
        this.interrupt();
    }

}
