package com.company.thread;

import com.company.data.Bug;
import com.company.data.User;
import com.company.run.Battle;

public class AttackBug extends Thread
{
    private Bug bug;
    private User user;
    private boolean check = false;

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

    public void finish()
    {
        check = false;
        this.interrupt();
    }

    public synchronized void attackBug()
    {
        // 유저가 벌레를 공격한다.
        try{

            while(!isInterrupted())
            {

                System.out.printf(
                        "------------------------------------------------------------------------\n" +
                                "                       %s님이 %s를 공격했습니다!\n" +
                                "------------------------------------------------------------------------\n\n" +
                                " >>> %s가 %d 데미지를 입었습니다 <<<\n\n"
                        , User.getName(),bug.getName(), bug.getName() , User.getSkillLevel());

                bug.setHp(bug.getHp() - User.getSkillLevel());

                System.out.println("유저가 공격, 벌레 체력 : " + bug.getHp() + " 유저 체력 : " + user.getBattleHp() );


                if (user.getBattleHp() <= bug.getDamage() && user.getBattleHp() > 0)
                {
                    wait();

                } else if (bug.getHp() <= 0 || user.getBattleHp() <= 0) // 벌레가 죽거나 유저가 죽으면 반복 멈추기
                {
                    finish();
                }

                Thread.sleep(4000);
            }


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

                //Battle battle = new Battle();
                //battle.bugInfo(bug);

                if(bug.getHp()<=0)
                {
                    check = false;
                }

             */
            //}



        }catch (InterruptedException e){
            return;
        }
    }

}
