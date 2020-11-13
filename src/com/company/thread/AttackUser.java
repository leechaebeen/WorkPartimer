package com.company.thread;
import com.company.action.BattleAction;
import com.company.data.Bug;
import com.company.data.User;


public class AttackUser extends Thread
{
    private Bug bug;
    private User user;

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
        while(true)
        {
            try{
                // 3초마다 공격
                Thread.sleep(3000);

                // 벌레 체력이 0보다 작거나 유저 체력이 0보다 작으면 멈추기
                if(bug.getHp()<=0||user.getBattleHp()<=0)
                {
                    return;
                    //this.stop();

                }

                // 유저 체력 줄이기
                user.setBattleHp(user.getBattleHp() - bug.getDamage());

                System.out.printf(
                        "------------------------------------------------------------------------\n"
                                + "                       %s가 %s님을 공격했습니다!\n"
                                + "------------------------------------------------------------------------\n\n"
                                + "                                     >>> %s님이 %d 데미지를 입었습니다 <<<\n"
                                + "                                    ==================================\n"
                                + "                                                  %s\n"
                                + "                                    ==================================\n"
                                + "                                              체력    : %d\n"
                                + "                                              공격력  : %d\n"
                                + "                                    ==================================\n"
                        ,bug.getName(), User.getName(), User.getName() , bug.getDamage(), User.getName(), user.getBattleHp(), User.getSkillLevel());


                // 벌레 체력이 0보다 작거나, 유저 체력이 0보다 작으면 멈추기
                if(bug.getHp()<=0||user.getBattleHp()<=0)
                {
                    return;
                    //this.stop();

                }

            }
            catch (InterruptedException e)
            {
                return;
            }


        }


    }

    /*
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

        // 유저 정보 출력
        BattleAction battleAction = new BattleAction();
        battleAction.userInfo(user);

    }*/
}
