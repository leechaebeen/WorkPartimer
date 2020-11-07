package com.company.thread;

import com.company.data.Bug;
import com.company.data.Cafe;
import com.company.data.User;
import com.company.run.Ending;

import java.util.Random;
import java.util.Scanner;

public class ComeBug implements Runnable
{
    private static boolean isMonitoring = false;

    @Override
    public void run()
    {

        Bug bug = createBug();  // 불청객 등장

        comeBug(bug);           // 불청객 등장 나타내는 출력 메소드 호출

        Random rd = new Random();
        int randomNum = rd.nextInt(2) + 1;//  1 ~ 2 사이의 랜덤값 생성

        final int AutoBattle = 1;   // 자동전투
        final int miniGame = 2;     // 미니게임(타이밍 맞추기 게임)

        // 랜덤값에 따라서 자동 전투 또는 미니게임을 통해 불청객을 퇴치한다.
        switch (randomNum)
        {
            case AutoBattle:        // 자동전투 메소드 호출
                autoBattle(bug);
                break;

            case miniGame:
                autoBattle(bug); // 나중에 바꾸기
        }

    }



    // 벌레 객체 만드는 메소드
    public Bug createBug()
    {
        Random rd = new Random();
        int randomNum = rd.nextInt(4)+1;    // 1 ~ 4 사이의 랜덤값 생성

        final int MOSQUITO = 1;  // 모기
        final int FLY = 2;       // 파리
        final int COCKROACH = 3; // 바퀴벌레
        final int RAT = 4;       // 쥐

        Bug bug = new Bug();

        switch (randomNum)
        {

            case MOSQUITO:  // 모기 생성
                bug = new Bug("모기",3, 1);
                break;

            case FLY:       // 파리 생성
                bug = new Bug("파리",5, 1);
                break;

            case COCKROACH: // 바퀴 생성
                bug = new Bug("바퀴벌레", 6, 2);
                break;

            case RAT:       // 쥐 생성
                bug = new Bug("쥐",6, 3);
                break;
        }

        return bug;

    }// end createBug()


    // 벌레 등장 출력 메소드
    public void comeBug(Bug bug)
    {
        System.out.println();
        System.out.println("------------------------------------------------------------------------");
        System.out.println(" ! ! ! ! ! ! ! ! ! ! ! ! !   불청객 등장  ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ");
        System.out.println("------------------------------------------------------------------------");
        System.out.printf(" " + bug.getName() + "가 등장했습니다 ! \n");
        System.out.println(" ");

    }

    // 자동 전투
    public void autoBattle(Bug bug)
    {

        try
        {

            Thread.sleep(500);
            System.out.println("------------------------------------------------------------------------");
            System.out.println("                        자동 전투를 시작합니다   ");
            System.out.println("------------------------------------------------------------------------");

        } catch (Exception e)
        {
        }

        // 벌레 정보 출력
        bugInfo(bug);

        // 유저 객체 생성
        User user = new User();
        // 유저 정보 출력
        userInfo(user);

        // 자동 전투 실행
        while (true)
        {

            // 벌레가 유저를 공격하는 쓰레드 호출
            Thread attackUser = new Thread(new AttackUser(bug, user));
            attackUser.start();

            try
            {
                attackUser.join();    // 불청객이 유저 공격하는거 끝날때까지 기다리기

                if (user.getBattleHp() < bug.getDamage()&& user.getBattleHp()>0) // 유저의 퇴치체력이 불청객의 공격력보다 작고 0보다 클때
                {
                    monitoring(bug, user);
                    if (bug.getHp() <= 0) // 벌레가 죽으면 반복 멈추기
                    {
                        break;
                    }
                }
                else if (user.getBattleHp() <= 0) // 유저가 죽으면 반복 멈추기
                {
                    break;
                }

                // 유저가 벌레를 공격하는 쓰레드 호출
                Thread attackBug = new Thread(new AttackBug(bug));
                attackBug.start();
                attackBug.join(); // 유저가 불청객 공격하는거 기다리기

                if (bug.getHp() <= 0) // 벌레가 죽으면 반복 멈추기
                {
                    break;
                }

            } catch (Exception e)
            {
            }
        }

        // 누가 이겼는지 판별
        if (bug.getHp() <= 0) // 벌레가 졌으면
        {
            try
            {
                Thread.sleep(500);
                System.out.println("------------------------------------------------------------------------");
                System.out.printf("                           %s를 퇴치했습니다 ! \n", bug.getName());
                System.out.println("------------------------------------------------------------------------");

            } catch (Exception e)
            {
            }

        } else if (user.getBattleHp() <= 0)    // 유저가 졌으면
        {
            try
            {
                Thread.sleep(500);
                System.out.println("------------------------------------------------------------------------");
                System.out.printf("                        %s를 퇴치하지 못했습니다 ! \n", bug.getName());
                Thread.sleep(300);
                System.out.println();
                System.out.println("                  퇴치 업체를 불러야 합니다. 1코인이 필요합니다.");

                if (User.getProperty() >= 1) // 1코인이 있다면
                {
                    Thread.sleep(500);
                    User.setProperty(User.getProperty() - 1);   // 1코인 소모
                    System.out.println("------------------------------------------------------------------------");
                    System.out.println("                       1코인을 사용했습니다.");
                    System.out.println("------------------------------------------------------------------------");
                    System.out.printf(" 현재 보유한 코인 : %d\n", User.getProperty());

                } else    // 1코인이 없다면
                {
                    Thread.sleep(500);
                    System.out.println("------------------------------------------------------------------------");
                    System.out.println("                        코인이 부족합니다.");

                    if (User.getSkillLevel() >= 2) // 숙련도가 2 이상이라면
                    {
                        User.setSkillLevel(User.getSkillLevel() - 1);   // 숙련도 낮추기

                        Thread.sleep(300);
                        System.out.println();
                        System.out.println("                        숙련도가 내려갑니다.");
                        System.out.println("------------------------------------------------------------------------");
                        System.out.printf(" 현재 숙련도 : %d\n", User.getSkillLevel());

                    } else // 숙련도도 없다면..
                    {
                        Thread.sleep(500);
                        System.out.println("------------------------------------------------------------------------");
                        System.out.println("                        숙련도가 낮습니다.");
                        System.out.println("------------------------------------------------------------------------");

                        Ending ending = new Ending();
                        ending.getFireEnding();         // 해고 엔딩 호출
                    }

                }


            } catch (Exception e)
            {
            }
        }


    }

    // 벌레 정보 출력
    public void bugInfo(Bug bug)
    {
        try{
            Thread.sleep(500);
            System.out.println();
            System.out.println("==================================");
            System.out.printf("              %s\n", bug.getName());
            System.out.println("==================================");
            System.out.printf("          체력    : %d\n", bug.getHp());
            System.out.printf("          공격력  : %d\n", bug.getDamage());
            System.out.println("==================================");

        }
        catch (Exception e){

        }

    }


    // 유저 정보 출력
    public void userInfo(User user)
    {
        try{

            Thread.sleep(500);
            System.out.println("");
            System.out.println("                                      ==================================");
            System.out.printf("                                                    %s님\n", User.getName());
            System.out.println("                                      ==================================");
            System.out.printf("                                                   퇴치 체력    : %d\n", user.getBattleHp());
            System.out.printf("                                                     퇴치력     : %d\n", User.getSkillLevel());
            System.out.println("                                      ==================================");

        }catch (Exception e){

        }
    }

    public void monitoring(Bug bug, User user)
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
                System.out.println(" 1. 박카스 구매( 퇴치 체력 + 5 / 1코인)   2.손님에게 도움 요청 ");
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
                    user.setBattleHp(user.getBattleHp() + 5); // 퇴치체력 5 회복
                    System.out.println("------------------------------------------------------------------------");
                    System.out.println("                       퇴치 체력을 5 회복합니다 !    ");
                    break;

                case 2: // 손님에게 도움 요청
                    Random rd = new Random();
                    int randomNum = rd.nextInt(2) + 1;

                    if (randomNum == 1)// 랜덤값이 1이면 손님이 퇴치 성공
                    {
                        bug.setHp(0);


                    } else if (randomNum == 2) // 랜덤값이 2이면 퇴치 실패
                    {
                        System.out.println("------------------------------------------------------------------------");
                        System.out.println("                        아무일도 일어나지 않았습니다 !    ");
                    }

                    break;
            }
    }


}
