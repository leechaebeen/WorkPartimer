package com.company.thread;

import com.company.action.CustomerAction;
import com.company.action.SecretCustomerAction;
import com.company.action.SpecialCustomerAction;
import com.company.data.Cafe;
import com.company.run.GameRun;

import java.util.Random;

public class ComeCustomer implements Runnable
{
    @Override
    public synchronized void run()
    {
        // 손님수 표현하기 위한 배열, 최대 4주차에서 게임이 끝나기 때문에 최대 숙련도는 5이다.
        // 하루에 방문하는 최대 손님수는 숙련도와 동일하므로 다섯까지 존재
        String[] nums = {"첫", "두", "세", "네", "다섯"};

        try
        {
            Thread.sleep(1000);

            System.out.println("------------------------------------------------------------------------");
            System.out.println("                        " + nums[Cafe.getTodayCustomerNum()] + "번째 손님이 등장했습니다.");
            System.out.println("------------------------------------------------------------------------");

            // 손님 유형 랜덤으로 등장시키기.
            Random rd = new Random();               // 랜덤클래스 객체 생성
            int randomNum = rd.nextInt(10) + 1; // 1 ~ 10 사이의 랜덤값을 생성해서 변수에 담는다.

            if (randomNum <= 6)                       // 랜덤값이 1 ~ 6 인 경우
            {
                // 일반 손님이 등장하는 메소드 호출
                CustomerAction customerAction = new CustomerAction();
                customerAction.comeCustomer();


            } else if (randomNum == 7 || randomNum == 8)     // 랜덤값이 7,8인 경우
            {
                // 특별 손님이 등장하는 메소드 호출
                SpecialCustomerAction specialCustomerAction = new SpecialCustomerAction();
                specialCustomerAction.comeSpecialCustomer();


            } else if (randomNum == 9)                                   // 랜덤값이 9인 경우
            {
                // 비밀 손님이 등장하는 메소드 호출
                SecretCustomerAction secretCustomerAction = new SecretCustomerAction();
                secretCustomerAction.comeSecretCustomer();

            }
            else        // 랜덤값이 10인 경우
            {
                // 불청객 등장
            }

        } catch (Exception e)
        {
            e.toString();
        }

    }
}
