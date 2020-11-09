package com.company.thread;
import com.company.action.BattleAction;
import com.company.data.Bug;
import com.company.data.User;


public class AttackUser extends Thread
{
    private Bug bug;
    private User user;

    public AttackUser(){};

    public AttackUser(Bug bug, User user)
    {
        this.bug = bug;
        this.user = user;
    }

    @Override
    public void run()
    {
        attackUser();
    }

    public void attackUser()
    {
        // 벌레가 유저를 공격한다.
                System.out.printf(
                        "------------------------------------------------------------------------\n" +
                                "                       %s가 %s님을 공격했습니다!\n" +
                                "------------------------------------------------------------------------\n\n" +
                                "                                     >>> %s님이 %d 데미지를 입었습니다 <<<\n"
                        ,bug.getName(), User.getName(), User.getName() , bug.getDamage());

                user.setBattleHp(user.getBattleHp() - bug.getDamage());

                //System.out.println("벌레가 공격, 벌레 체력 : " + bug.getHp() + " 유저 체력 : " + user.getBattleHp() );
                BattleAction battleAction = new BattleAction();
                battleAction.userInfo(user);

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

    }



}
