package com.company.run;

import com.company.data.Bug;
import com.company.data.User;
import com.company.thread.Monitoring;
import com.company.thread.*;

import java.util.Random;
import java.util.Scanner;

public class Battle
{
    volatile Bug bug;
    volatile User user;

    public void comeBug()
    {
        bug = createBug();  // 불청객 등장

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
                miniGame(bug);      // 미니게임 메소드 호출

        }

        // test
        GameRun gameRun = new GameRun();
        gameRun.selectWork();                          // 선택지 고르는 메소드 호출(1. 계속하기 2. 마감하기 3.아이템 사용)

    }

    //
    public void miniGame(Bug bug)
    {

        boolean result;  // 게임 결과 담을 변수
        try{

            Thread.sleep(1000);
            System.out.println();
            System.out.println("------------------------------------------------------------------------");
            System.out.println("                             불청객 퇴치하기 ");
            System.out.println("------------------------------------------------------------------------");
            System.out.println(" 제시되는 숫자를 기억하고 동일하게 타이핑해주세요. ");
            System.out.println("------------------------------------------------------------------------");
            System.out.println();

            System.out.println(" 시작 3초 전 ");
            Thread.sleep(1000);
            System.out.println(" 시작 2초 전 ");
            Thread.sleep(1000);
            System.out.println(" 시작 1초 전");
            Thread.sleep(1000);
            System.out.println(" ↓ 화살표 아래에 숫자가 나타납니다");

        }
        catch (Exception e){
            System.out.println(e.toString());
        }


        String[] numArray = new String[bug.getHp()];  // 불청객의 hp 만큼의 칸을 가진 숫자 배열
        String nums = "";

        for (int i = 0; i < numArray.length; i++)
        {
            Random rd = new Random();
            int randomNum = rd.nextInt(9)+1;    // 1 ~ 9 사이의 랜덤값을 생성해서
             nums += Integer.toString(randomNum);
        }

        int cnt = 0;
        numArray = nums.split("");


        while(cnt<numArray.length)
        {
            try{

                for (int i = 0; i < 50; i++) // 공백 출력
                {
                    System.out.println();
                }

                System.out.print(numArray[cnt]);    //
                Thread.sleep(1000);

            }catch (Exception e){
                System.out.println(e.toString());
            }

            cnt++;
        }

        for (int i = 0; i < 50; i++)
        {
            System.out.println();
        }
        System.out.print("\n 입력 : ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        // test
        //System.out.println("nums : "+ nums );

        result = input.replace(" ", "").equals(nums);

        battleResult(result);

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
                bug = new Bug("모기",User.getSetHp()-2, User.getSkillLevel());
                break;

            case FLY:       // 파리 생성
                bug = new Bug("파리",User.getSetHp()-1, User.getSkillLevel());
                break;

            case COCKROACH: // 바퀴 생성
                bug = new Bug("바퀴벌레", User.getSetHp(), User.getSkillLevel()+1);
                break;

            case RAT:       // 쥐 생성
                bug = new Bug("쥐",User.getSetHp()+1, User.getSkillLevel()+1);
                break;
        }

        return bug;

    }// end createBug()


    // 벌레 등장 출력 메소드
    public void comeBug(Bug bug)
    {
        SoundThread sound = new SoundThread("comeBug.mp3",false);
        sound.start();
        System.out.println();

        try{

            Thread.sleep(1000);
            System.out.println("------------------------------------------------------------------------");
            System.out.println("                      ! ! !   불청객 등장  ! ! !                          ");
            System.out.println("------------------------------------------------------------------------");
            System.out.println("                 " + bug.getName() + "가 등장했습니다 !");
            System.out.println(" ");

        }catch (Exception e){
            System.out.println(e.toString());
        }

    }

    // 자동 전투
    public void autoBattle(Bug bug)
    {
        boolean result; //전투 결과 담을 변수

        try
        {
            Thread.sleep(500);
            System.out.println("------------------------------------------------------------------------");
            System.out.println("                        자동 전투를 시작합니다   ");
            System.out.println("------------------------------------------------------------------------");

            // 벌레 정보 출력
            bugInfo(bug);

            // 유저 객체 생성
            user = new User();
            // 유저 정보 출력
            userInfo(user);

            // 자동 전투 실행
            while (true)
            {
                // 벌레가 유저를 공격하는 쓰레드 호출
                Thread.sleep(1000);
                AttackUser attackUser = new AttackUser(bug, user);
                attackUser.start();
                attackUser.join();


                // 유저의 퇴치체력이 불청객의 공격력보다 작고 0보다 클때
                if (user.getBattleHp() < bug.getDamage() && user.getBattleHp() > 0)
                {
                    //monitoring(bug, user);
                    Monitoring monitoring = new Monitoring(bug,user);
                    monitoring.start();
                    monitoring.join();
                }

                if (bug.getHp() <= 0|| user.getBattleHp()<=0) // 벌레가 죽거나 유저가 죽으면 반복 멈추기
                {
                    //attackUser.interrupt();
                    break;
                }
               // 유저가 벌레를 공격하는 쓰레드 호출
                Thread.sleep(1000);
                AttackBug attackBug = new AttackBug(bug, user);
                attackBug.start();
                attackBug.join(); // 유저가 불청객 공격하는거 기다리기


                if (bug.getHp() <= 0|| user.getBattleHp()<=0) // 벌레가 죽거나 유저가 죽으면 반복 멈추기
                {
                    break;
                }

            }

            // 전투 결과 반환
            if (bug.getHp() <= 0) // 벌레가 졌으면
            {
                result = true;
            }
            else
            {
                result = false;
            }

            battleResult(result);

        } catch (InterruptedException e)
        {
            System.out.println(e.toString());
        }

    }


    // 전투 결과
    public void battleResult(boolean result)
    {
        try{
            // 누가 이겼는지 판별
            if (result) // 벌레가 졌으면
            {
                Thread.sleep(500);
                SoundThread sound = new SoundThread("coin.mp3", false);
                sound.start();
                User.setProperty(User.getProperty()+1);     // 코인 1 주기
                System.out.println("========================================================================");
                System.out.printf("                  %s를 퇴치했습니다. 1코인을 획득했습니다! \" \n", bug.getName());
                System.out.println();
                System.out.printf(" 현재 보유한 코인 : %d\n", User.getProperty());
                System.out.println("------------------------------------------------------------------------");
                // sound.finish()

            } else     // 유저가 졌으면
            {
                Thread.sleep(500);
                System.out.println("========================================================================");
                System.out.printf("                        %s를 퇴치하지 못했습니다 ! \n", bug.getName());
                Thread.sleep(300);
                System.out.println("                  퇴치 업체를 불러야 합니다. 1코인이 필요합니다.");

                if (User.getProperty() >= 1) // 1코인이 있다면
                {
                    Thread.sleep(500);
                    User.setProperty(User.getProperty() - 1);   // 1코인 소모
                    System.out.println("========================================================================");
                    System.out.println("                       1코인을 사용했습니다.");
                    System.out.println("------------------------------------------------------------------------");
                    System.out.printf(" 현재 보유한 코인 : %d\n", User.getProperty());

                } else    // 1코인이 없다면
                {
                    Thread.sleep(500);
                    System.out.println("========================================================================");
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
                        System.out.println("                        숙련도가 낮습니다.");
                        System.out.println("------------------------------------------------------------------------");

                        Ending ending = new Ending();
                        ending.getFireEnding();         // 해고 엔딩 호출
                    }

                }
            }

        }
        catch (Exception e){
            System.out.println(e.toString());
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
            System.out.println(e.toString());
        }

    }


    // 유저 정보 출력
    public void userInfo(User user)
    {
        try{

            Thread.sleep(500);
            System.out.println();
            System.out.println("                                      ==================================");
            System.out.printf("                                                    %s님\n", User.getName());
            System.out.println("                                      ==================================");
            System.out.printf("                                                   퇴치 체력    : %d\n", user.getBattleHp());
            System.out.printf("                                                     퇴치력     : %d\n", User.getSkillLevel());
            System.out.println("                                      ==================================");

        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    /*
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
                System.out.println(" 1.박카스 구매[퇴치력(숙련도) + 1 / - 1코인]    2.손님에게 도움 요청 ");
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

                    if(User.getProperty()>=1)// 코인이 있으면
                    {
                        User.setSkillLevel(User.getSkillLevel() + 1);   // 숙련도 + 1
                        User.setProperty(User.getProperty() - 1);       // 코인 - 1
                        System.out.println("------------------------------------------------------------------------");
                        System.out.println("                       퇴치력(숙련도)을 1 높였습니다 !    ");
                        System.out.println("------------------------------------------------------------------------");
                        System.out.printf(" 현재 퇴치력(숙련도) : %d\n", User.getSkillLevel());
                    }
                    else
                    {
                        System.out.println("------------------------------------------------------------------------");
                        System.out.println("                           코인이 부족합니다 !    ");
                    }
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
                        System.out.println("                        아무일도 일어나지 않았습니다 !    ");
                    }

                    break;
            }
    }*/

//----------------------------------------------------------------------------------------------------------------------
/*public synchronized void attackBug()
{
    // 유저가 벌레를 공격한다.
    try
    {

        System.out.printf("------------------------------------------------------------------------\n" + "                       %s님이 %s를 공격했습니다!\n" + "------------------------------------------------------------------------\n\n" + " >>> %s가 %d 데미지를 입었습니다 <<<\n\n", User.getName(), bug.getName(), bug.getName(), User.getSkillLevel());

        bug.setHp(bug.getHp() - User.getSkillLevel());

        System.out.println("유저가 공격, 벌레 체력 : " + bug.getHp() + " 유저 체력 : " + user.getBattleHp());


        //while(check)
        //{
            *//*
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

             *//*
        //}
    }catch (Exception e){

    }
    }

    public synchronized void attackUser()
    {
        // 벌레가 유저를 공격한다.
        try{

            System.out.printf(
                    "------------------------------------------------------------------------\n" +
                            "                       %s가 %s님을 공격했습니다!\n" +
                            "------------------------------------------------------------------------\n\n" +
                            "                                     >>> %s님이 %d 데미지를 입었습니다 <<<\n\n"
                    ,bug.getName(), User.getName(), User.getName() , bug.getDamage());

            user.setBattleHp(user.getBattleHp() - bug.getDamage());

            System.out.println("벌레가 공격, 벌레 체력 : " + bug.getHp() + " 유저 체력 : " + user.getBattleHp() );


            Thread.sleep(5000);

            *//*
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
            *//*

        }catch (InterruptedException e){
            return;
        }
    }*/

}
