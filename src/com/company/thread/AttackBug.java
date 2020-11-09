package com.company.thread;

import com.company.data.Bug;
import com.company.data.User;
import com.company.run.Battle;

import java.util.Random;

public class AttackBug extends Thread
{
    private Bug bug;
    private User user;

    public AttackBug(){};

    public AttackBug(Bug bug, User user)
    {
        this.bug = bug;
        this.user = user;
    }


    @Override
    public void run()
    {
        attackBug();
    }

    public void attackBug()
    {
        // 유저가 벌레를 공격한다.
        try
        {
            Random rd = new Random();
            int randomNum = rd.nextInt(10)+1;

            int damage = 0;

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

            //System.out.println("유저가 공격, 벌레 체력 : " + bug.getHp() + " 유저 체력 : " + user.getBattleHp());
            Battle battle = new Battle();
            battle.bugInfo(bug);

            //while(check)
            //{
            /*
                Thread.sleep(1000);

                System.out.println("------------------------------------------------------------------------");
                System.out.printf("                      %s님이 %s를 공격했습니다!\n",User.getName(), bug.getName());
                System.out.println("------------------------------------------------------------------------");

                // 불청객의 체력에서 유저가 입힌 데미지(숙련도)를 뺀다.
                bug.setHp(bug.getHp() - User.getSkillLevel());

                Thread.sleep(500);
                System.out.println();
                System.out.printf(" >>> %s가 %d 데미지를 입었습니다 <<<\n", bug.getName() , User.getSkillLevel());

                //BattleThread battle = new BattleThread();
                //battle.bugInfo(bug);

                if(bug.getHp()<=0)
                {
                    check = false;
                }

             */
            //}
        }catch (Exception e){

        }
    }

}
