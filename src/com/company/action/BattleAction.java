package com.company.action;

import com.company.data.Bug;
import com.company.data.User;
import com.company.run.Ending;
import com.company.run.GameRun;
import com.company.thread.Monitoring;
import com.company.thread.*;
import com.sun.org.apache.bcel.internal.util.ModularRuntimeImage;

import java.util.Random;
import java.util.Scanner;

public class BattleAction
{
    private Bug bug;        // 불청객 객체 선언

    // 불청객 등장 시키는 메소드
    public void comeBug()
    {
        bug = createBug();  // 불청객 등장

        // 효과음 재생
        Sound sound = new Sound("comeBug.mp3",false);
        sound.start();
        System.out.println();

        try{

            Thread.sleep(1000);
            System.out.println("------------------------------------------------------------------------");
            System.out.println("                      ! ! !   불청객 등장  ! ! !                          ");
            System.out.println("------------------------------------------------------------------------");
            System.out.println("                          " + bug.getName() + "가 등장했습니다 !");

            // 효과음 종료
            sound.finish();

        }catch (Exception e){
            System.out.println(e.toString());
        }

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
                //rememberGame(bug);      // 미니게임 메소드 호출
                autoBattle(bug);
                break;

        }

        GameRun gameRun = new GameRun();
        gameRun.selectWork();                          // 선택지 고르는 메소드 호출(1. 계속하기 2. 마감하기 3.아이템 사용)

    }

    // 불청객 퇴치하는 미니게임
    public void rememberGame(Bug bug)
    {
        boolean result = false;  // 게임 결과 담을 변수

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

        }
        catch (Exception e){
            System.out.println(e.toString());
        }

        String[] numArray = new String[bug.getHp()];  // 불청객의 hp 만큼의 칸을 가진 숫자 배열 선언
        StringBuilder nums = new StringBuilder();     // 랜덤숫자로 만든 문자열을 담을 변수

        for (int i = 0; i < numArray.length; i++)    // 불청객의 hp 만큼 반복해서
        {
            Random rd = new Random();
            int randomNum = rd.nextInt(9)+1;    // 1 ~ 9 사이의 랜덤값을 생성하고
             nums.append(randomNum);                  // 문자열로 만든다. 예) 17423
        }

        numArray = nums.toString().split("");   // 문자열을 한자리씩 잘라서 배열에 담는다.
                                                      // 예) {"1","7","4","2","3"}

        int cnt = 0;                                  // 반복 횟수를 체크하기 위한 변수

        while(cnt < numArray.length) // 문자열의 자릿수만큼 반복한다.
        {
            try{

                for (int i = 0; i < 50; i++) // 공백 출력
                {
                    System.out.println();
                }

                System.out.print(numArray[cnt] + " ");  // 1초마다 문자열의 한 자리 씩 출력.
                Thread.sleep(1000);

            }catch (Exception e){
                System.out.println(e.toString());
            }

            cnt++;
        }

        for (int i = 0; i < 50; i++)    // 공백 출력
        {
            System.out.println();
        }

        System.out.println();
        System.out.print("\n 입력 : ");       // 사용자에게서 값을 입력받는다.
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        // test
        //System.out.println("nums : "+ nums );

        // 입력받은 값과 출력한 값이 같다면
        if(input.replace(" ", "").equals(nums.toString()))
        {
            result = true;  // 결과에 true를 담는다.
        }

        // 전투결과 출력 메소드 호출
        battleResult(result);

    }

    // 불청객  객체 만드는 메소드
    public Bug createBug()
    {
        Random rd = new Random();
        int randomNum = rd.nextInt(4)+1;    // 1 ~ 4 사이의 랜덤값 생성

        final int MOSQUITO = 1;  // 모기
        final int FLY = 2;       // 파리
        final int COCKROACH = 3; // 바퀴벌레
        final int RAT = 4;       // 쥐

        Bug bug = new Bug();

        switch (randomNum)      // 랜덤 값에 따라 불청객 객체를 만든다.
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

    /*// 자동 전투
    public void autoBattle(Bug bug)
    {
        boolean result; //전투 결과 담을 변수

        try
        {
            Thread.sleep(500);
            System.out.println("------------------------------------------------------------------------");
            System.out.println("                        자동 전투를 시작합니다   ");
            System.out.println("------------------------------------------------------------------------");

            bugInfo(bug);           // 벌레 정보 출력

            User user = new User(); // 유저 객체 생성

            userInfo(user);         // 유저 정보 출력

            // 자동 전투 실행
            while (true)
            {
                // 벌레가 유저를 공격하는 쓰레드 호출
                Thread.sleep(1000);
                AttackUser attackUser = new AttackUser(bug, user);
                attackUser.start();
                attackUser.join();      // 쓰레드 진행 기다리기


                // 유저의 퇴치체력이 불청객의 공격력보다 작고 0보다 클때
                if (user.getBattleHp() < bug.getDamage() && user.getBattleHp() > 0)
                {
                    // 모니터링 쓰레드 호출
                    Monitoring monitoring = new Monitoring(bug,user);
                    monitoring.start();
                    monitoring.join();  // 쓰레드 진행 기다리기

                }

                if (bug.getHp() <= 0|| user.getBattleHp()<=0) // 벌레가 죽거나 유저가 죽으면 반복 멈추기
                {
                    break;
                }

               // 유저가 벌레를 공격하는 쓰레드 호출
                Thread.sleep(1000);
                AttackBug attackBug = new AttackBug(bug);
                attackBug.start();
                attackBug.join(); // 쓰레드 진행 기다리기


                if (bug.getHp() <= 0|| user.getBattleHp()<=0) // 벌레가 죽거나 유저가 죽으면 반복 멈추기
                {
                    break;
                }

            }

            // 전투 결과 반환
            if (bug.getHp() <= 0)   // 벌레가 졌으면
            {
                result = true;      // 결과에 true 담고
            }
            else                    // 유저가 졌으면
            {
                result = false;     // 결과에 false 담아서
            }

            battleResult(result);   // 전투 결과 출력

        } catch (InterruptedException e)
        {
            System.out.println(e.toString());
        }

    }*/


    public void autoBattle(Bug bug)
    {
        boolean result; //전투 결과 담을 변수

        System.out.println("------------------------------------------------------------------------");
        System.out.println("                        자동 전투를 시작합니다   ");
        System.out.println("------------------------------------------------------------------------");

        bugInfo(bug);           // 벌레 정보 출력

        User user = new User(); // 유저 객체 생성

        userInfo(user);         // 유저 정보 출력

        // 자동 전투 실행
        // 서로 공격하는 쓰레드
        AttackUser attackUser = new AttackUser(bug, user);
        AttackBug attackBug = new AttackBug(bug,user);
        // 모니터링 쓰레드
        Monitoring monitoring = new Monitoring(bug,user);

        try{

            // 자동전투 쓰레드 시작
            attackUser.start();
            attackBug.start();

            // 자동전투 기다려주기.. 없으면 메인쓰레드 진행되어서 전투기다리지 않고 바로 결과 출력한다
            attackBug.join();
            attackUser.join();

            /*
            if(bug.getHp()>0&&user.getBattleHp()>0&&user.getBattleHp()<=bug.getDamage())
            {
                monitoring.start();
                monitoring.join();
            }*/


        // 전투 결과 반환
        if (bug.getHp() <= 0)   // 벌레가 졌으면
        {
            result = true;      // 결과에 true 담고
        }
        else                    // 유저가 졌으면
        {
            result = false;     // 결과에 false 담아서
        }

        battleResult(result);   // 전투 결과 출력

        }catch (InterruptedException e){

            attackBug.stop();
            attackUser.stop();
            monitoring.interrupt();
        }


    }


    // 전투 결과
    public void battleResult(boolean result)
    {
        try{
            if (result) //  벌레가 졌으면
            {
                Thread.sleep(500);

                Sound sound = new Sound("coin.mp3", false); // 효과음 재생
                sound.start();

                User.setProperty(User.getProperty()+1);     // 코인 1 주기
                System.out.println("========================================================================");
                System.out.printf("                  %s를 퇴치했습니다. 1코인을 획득했습니다!  \n", bug.getName());
                System.out.println();
                System.out.printf(" 현재 보유한 코인 : %d\n", User.getProperty());
                System.out.println("------------------------------------------------------------------------");

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
                    System.out.println("                          1코인을 사용했습니다.");
                    System.out.println("------------------------------------------------------------------------");
                    System.out.printf(" 현재 보유한 코인 : %d\n", User.getProperty());

                } else    // 1코인이 없다면
                {
                    Thread.sleep(500);
                    System.out.println("========================================================================");
                    System.out.println("                           코인이 부족합니다.");

                    if (User.getSkillLevel() >= 2) // 숙련도가 2 이상이라면
                    {
                        User.setSkillLevel(User.getSkillLevel() - 1);   // 숙련도 낮추기

                        Thread.sleep(300);
                        System.out.println();
                        System.out.println("                           숙련도가 내려갑니다.");
                        System.out.println("------------------------------------------------------------------------");
                        System.out.printf(" 현재 숙련도 : %d\n", User.getSkillLevel());

                    } else // 숙련도도 없다면..
                    {
                        Thread.sleep(500);
                        System.out.println("                           숙련도가 낮습니다.");
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

}
