package com.company.thread;

import com.company.data.Bug;
import com.company.data.User;

import java.util.Random;
import java.util.Scanner;

public class Monitoring extends Thread
{
    Bug bug;
    User user;

    public Monitoring(){};

    public Monitoring(Bug bug, User user)
    {
        this.bug = bug;
        this.user = user;
    }

    @Override
    public synchronized void run()
    {
        try{
           Thread.sleep(500);   // 0.5초마다

            //2. test -- 동작 확인 (Battle 에서 if문 사용한 경우)
            monitoring(bug);

            notifyAll();

        }catch (InterruptedException e){
            return;
        }

    }

    public void finish()
    {
        this.interrupt();
    }

    public synchronized void monitoring(Bug bug)
    {
        System.out.println("------------------------------------------------------------------------");
        System.out.printf("                         %s님이 곧 쓰러집니다 !\n", User.getName());

        boolean check = true;   // 반복 여부를 체크하기 위한 변수
        String selectStr;       // 사용자가 입력한 값을 담을 변수
        int select = 0;         // selectStr 변수를 형변환해서 담을 변수

        // 스캐너 객체 생성
        Scanner sc = new Scanner(System.in);

        while (check)            // 올바른 선택지를 선택할 때까지 반복한다.
        {
            System.out.println("========================================================================");
            System.out.println(" 1.박카스 구매[퇴치력(숙련도) + 1 / 1코인]    2.손님에게 도움 요청 ");
            System.out.println("------------------------------------------------------------------------");
            System.out.print(" 선택 : ");


            selectStr = sc.nextLine();

            // 입력받은 값이 숫자인지 확인
            try
            {
                // 자료형 변경한 뒤(String → int) int형에 담는다.
                // int형으로 변경되지 않는다면 NumberFormatException 발생
                select = Integer.parseInt(selectStr);
                check = false;

                if (select < 1 || select > 2)// 주어진 값 이외의 수를 선택한 경우
                {
                    System.out.println("========================================================================");
                    System.out.println(" 올바른 값을 입력해주세요.");
                    check = true;
                }

            } catch (NumberFormatException e) // NumberFormatException 발생한다면
            {
                System.out.println("========================================================================");
                System.out.println(" 올바른 값을 입력해주세요.");
                check = true;   // check 에 true 담아서 다시 반복
            }

        }

        switch (select)
        {
            case 1:  // 박카스 구매
                User.setSkillLevel(User.getSkillLevel() + 1);   // 퇴치력이자 숙련도 + 1
                System.out.println("------------------------------------------------------------------------");
                System.out.println("                       퇴치력(숙련도)을 1 높였습니다 !    ");
                System.out.println("------------------------------------------------------------------------");
                System.out.printf(" 현재 퇴치력(숙련도) : %d\n", User.getSkillLevel());
                break;

            case 2: // 손님에게 도움 요청
                Random rd = new Random();
                int randomNum = rd.nextInt(2) + 1;

                if (randomNum == 1)// 랜덤값이 1이면 손님이 퇴치 성공
                {
                    bug.setHp(0);
                    System.out.println("------------------------------------------------------------------------");
                    System.out.println("                        손님이 흔쾌히 도와줬습니다 !    ");


                } else if (randomNum == 2) // 랜덤값이 2이면 퇴치 실패
                {
                    System.out.println("------------------------------------------------------------------------");
                    System.out.println("                       아무일도 일어나지 않았습니다 !    ");
                }

                break;
        }
    }
}
