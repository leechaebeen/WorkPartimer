package com.company.thread;

import com.company.action.SecretCustomerAction;
import com.company.data.Cafe;
import com.company.data.User;
import com.company.run.Ending;

public class CheckEnding extends Thread
{
    @Override
    public void run()
    {
        while(!isInterrupted())
        {
            try
            {
                Thread.sleep(100);    // 1초마다 자동으로
                autoEnding();               // 엔딩 체크
            }
            catch (InterruptedException e)
            {
                System.out.println(e.toString());
            }

        }

        Ending ending = new Ending();
        ending.finalEnding();
    }

    public void autoEnding()
    {
        int week = (User.getWorkingDays() /6) + 1;
        // 토요일이 될 때 주차를 계산하면(일한 일수/요일배열 길이) 한 주 적게 나오기 때문에 1을 더해준다.
        // 첫번째 토요일 : 5/6 == 0
        // 두번째 토요일 : 11/6 == 1

        // 엔딩 객체 생성
        Ending ending = new Ending();
        if (User.getHp() == 0)          // 만약 유저의 체력이 0이 된다면
        {
            ending.fallDownEnding();    // 1. 과로 엔딩 메소드 호출
        }
        else if(User.getFeeling() == 0) // 유저의 인내력이 0이 된다면
        {
            ending.toQuitEnding();      // 2.퇴사 엔딩
        }

    }
}
