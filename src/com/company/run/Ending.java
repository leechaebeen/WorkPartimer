package com.company.run;

import com.company.action.UserAction;
import com.company.data.User;

import java.util.Scanner;

public class Ending
{
    private final static int ENDING_TYPE_NUM = 6;
    // static 이어야하는 이유 :
    // User 클래스의 모은 엔딩 유형을 저장하는 배열이 static 변수라서
    // 배열 초기화할 때 길이를 나타내는 변수도 static 이어야한다.
    // → private static int[] endings = new int[Ending.getEndingTypeNum()-1];


    /*
        final int FALL_DOWN_ENDING = 1; // 과로 엔딩
        final int QUIT_ENDING = 2;      // 퇴사 엔딩
        final int SCOUT_ENDING = 3;     // 이직 엔딩
        final int BOSS_ENDING = 4;      // 사장 엔딩
        final int GET_FIRE_ENDING = 5;  // 해고 엔딩
        final int PARTIMER_ENDING = 6;  // 알바 엔딩
    */

    // 1. 과로 엔딩 : 유저의 체력이 0이 되면 (호출 완료)
    public void fallDownEnding()
    {
        boolean flag = true;                    // 배열 안에 중복되는 값이 있는지 구분하기 위한 변수

        // 공개된 엔딩 유형을 저장할 배열을 호출해서 변수에 담는다.
        int[] endings = User.getEndings();

        // 과로 엔딩
        int FALL_DOWN_ENDING = 1;

        // 배열에 중복되는 엔딩 유형 있는지 비교
        for (int ending : endings)             // 공개된 엔딩 유형 저장할 배열 호출해서 변수에 담는다.
        {
            if (ending == FALL_DOWN_ENDING)   // 엔딩 유형과 중복되는 값이 있는지 비교한다.
            {
                flag = false;                    // flag 에 false 대입하고
                break;                           // 반복문 빠져나온다.
            }
        }

        if(flag) // flag 가 true 일 때(== 중복되는 값이 없다면) 조건문 실행
        {
            for (int i = 0; i < endings.length; i++)    // 0부터 배열 길이만큼 반복해서
            {
                if(endings[i] == 0) // 배열 칸 비어있는 곳에(비어있는 배열 칸은 0으로 초기화된다.)
                {
                    endings[i] = FALL_DOWN_ENDING;  // 엔딩 유형을 저장한다.
                    break;                          // 그리고 반복문을 빠져나온다.
                }
            }
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("\t\t\t\t 으 아 아 아 ㅇㅏ");
        System.out.println("\t\t\t\t　　　　　　       ㅇ");
        System.out.println("\t\t\t\t　　　　　          ⋌");
        System.out.println("\t\t\t\t　　　　 　　   　      ㅇ");
        System.out.println("\t\t\t\t　 　 　　　　           ㅜ");
        System.out.println("\t\t\t\t　　　　　　　　　  　　     .");
        System.out.println("\t\t\t\t　 　　　　　　　　　   　      .");
        System.out.println("\t\t\t\t 　 　　　　　　　　　　　         .");
        System.out.println("\t\t\t\t 　 　　　　　　　　　　　             ඞ");

        System.out.println();
        System.out.println();

        System.out.println("。　　　　　　　　　　　　　　　　　ﾟ　　　.　　　　　　　　　　　　　　.");
        System.out.println("　　　　　　　　　.　 .　　　　　　　　.");
        System.out.println(" 　　　　　。　　　　　　　　　　　　　　　　　　　ﾟ　　　　　　　　　。");
        System.out.println("　　.　　　　　　　　.　　　　　.　　　　　　　　　　。　　.　");
        System.out.println("　.　　　　　　　　　　　　　　                   ㅤㅤㅤㅤㅤㅤㅤㅤㅤ 　 。　　.");
        System.out.printf("\t\t\t\t %s님은 고된 노동을 견디지 못하고 쓰러졌습니다.\n", User.getName());
        System.out.println("　　.　　　　　　　　.　　　　　.　　　　　　　　　　。　　.　");
        System.out.println();
        finalEnding();
    }


    // 2. 퇴사엔딩 : 유저의 인내력이 0이 되면 (호출 완료)
    public void toQuitEnding()
    {
        boolean flag = true;                    // 배열 안에 중복되는 값이 있는지 구분하기 위한 변수

        // 공개된 엔딩 유형을 저장할 배열을 호출해서 변수에 담는다.
        int[] endings = User.getEndings();

        // 퇴사 엔딩
        int QUIT_ENDING = 2;

        // 배열에 중복되는 엔딩 유형 있는지 비교
        for (int ending : endings)       // 0부터 (배열의 길이-1)까지 반복(== 엔딩 유형의 수만큼 반복)
        {
            if (ending == QUIT_ENDING)   // 엔딩 유형과 중복되는 값이 있다면
            {
                flag = false;            // flag 에 false 대입하고
                break;                   // 반복문 빠져나온다.
            }
        }

        if(flag) // flag 가 true 일 때(== 중복되는 값이 없다면) 조건문 실행
        {
            for (int i = 0; i < endings.length; i++)    // 0부터 배열 길이만큼 반복해서
            {
                if(endings[i] == 0) // 배열 칸 비어있는 곳에(비어있는 배열 칸은 0으로 초기화된다.)
                {
                    endings[i] = QUIT_ENDING;  // 엔딩 유형을 저장한다.
                    break;                     // 그리고 반복문을 빠져나온다.
                }
            }
        }


        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("\t\t\t\t 더러워서 못 해먹겠다... 때려쳐야지. ");

        System.out.println();
        System.out.println();

        System.out.println("。　　　　　　　　　　　　　　　　　ﾟ　　　.　　　　　　　　　　　　　　.");
        System.out.println("　　　　　　　　　.　 .　　　　　　　　.");
        System.out.println(" 　　　　　。　　　　　　　　　　　　　　　　　　　ﾟ　　　　　　　　　。");
        System.out.println("　　.　　　　　　　　.　　　　　.　　　　　　　　　　。　　.　");
        System.out.println("　.　　　　　　　　　　　　　　                   ㅤㅤㅤㅤㅤㅤㅤㅤㅤ 　 。　　.");
        System.out.printf("\t\t %s님은 스트레스를 견디지 못하고 자발적으로 카페를 떠났습니다.\n", User.getName());
        System.out.println("　　.　　　　　　　　.　　　　　.　　　　　　　　　　。　　.　");
        System.out.println();
        finalEnding();

    }
    // 3. 숙련도 4 이상, secret 손님 방문 4회 이상 : 이직 엔딩 (호출 완료)
    public void scoutEnding()
    {
        boolean flag = true;               // 배열 안에 중복되는 값이 있는지 구분하기 위한 변수

        // 공개된 엔딩 유형을 저장할 배열을 호출해서 변수에 담는다.
        int[] endings = User.getEndings();

        // 이직 엔딩
        int SCOUT_ENDING = 3;

        // 배열에 중복되는 엔딩 유형 있는지 비교
        for (int ending : endings)        // 0부터 (배열의 길이-1)까지 반복(== 엔딩 유형의 수만큼 반복)
        {
            if (ending == SCOUT_ENDING)   // 엔딩 유형과 중복되는 값이 있다면
            {
                flag = false;                    // flag 에 false 대입하고
                break;                           // 반복문 빠져나온다.
            }
        }

        if(flag) // flag 가 true 일 때(== 중복되는 값이 없다면) 조건문 실행
        {
            for (int i = 0; i < endings.length; i++)    // 0부터 배열 길이만큼 반복해서
            {
                if(endings[i] == 0) // 배열 칸 비어있는 곳에(비어있는 배열 칸은 0으로 초기화된다.)
                {
                    endings[i] = SCOUT_ENDING;      // 엔딩 유형을 저장한다.
                    break;                          // 그리고 반복문을 빠져나온다.
                }
            }
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("。　　　　　　　　　　　　　　　　　ﾟ　　　.　　　　　　　　　　　　　　.");
        System.out.println("　　　　　　　　　.　 .　　　　　　　　.");
        System.out.println(" 　　　　　。　　　　　　　　　　　　　　　　　　　ﾟ　　　　　　　　　。");
        System.out.println("　　.　　　　　　　　.　　　　　.　　　　　　　　　　。　　.　");
        System.out.println("　.　　　　　　　　　　　　　　                   ㅤㅤㅤㅤㅤㅤㅤㅤㅤ 　 。　　.");
        System.out.println("\t\t 종종 방문하던 특이한 손님의 일부는 몰래 방문한 인근 카페 사장이었습니다... ");
        System.out.printf(" \t\t %s님을 시험하고 눈여겨본 사장은 %s님을 스카웃했습니다. \n", User.getName(), User.getName());
        System.out.println("　　.　　　　　　　　.　　　　　.　　　　　　　　　　。　　.　");
        System.out.println();
        finalEnding();


    }

    // 4. 사장 엔딩 : 3주차 지나고 코인 10개 이상, 총 방문자 수 30명 이상, 숙련도 4 이상 (호출 완료)
    //    숙련도 매주 올렸을 때 3주간 모을 수 있는 최대 코인     : 12개
    //    숙련도 매주 올렸을 때 3주간 등장할 수 있는 최대 손님 수 : 30명
    public void bossEnding()
    {
        boolean flag = true;                    // 배열 안에 중복되는 값이 있는지 구분하기 위한 변수

        // 공개된 엔딩 유형을 저장할 배열을 호출해서 변수에 담는다.
        int[] endings = User.getEndings();

        // 사장 엔딩
        int BOSS_ENDING = 4;

        // 배열에 중복되는 엔딩 유형 있는지 비교
        for (int ending : endings)              // 0부터 (배열의 길이-1)까지 반복(== 엔딩 유형의 수만큼 반복)
        {
            if (ending == BOSS_ENDING)          // 엔딩 유형과 중복되는 값이 있다면
            {
                flag = false;                   // flag 에 false 대입하고
                break;                          // 반복문 빠져나온다.
            }
        }

        if(flag) // flag 가 true 일 때(== 중복되는 값이 없다면) 조건문 실행
        {
            for (int i = 0; i < endings.length; i++)    // 0부터 배열 길이만큼 반복해서
            {
                if(endings[i] == 0) // 배열 칸 비어있는 곳에(비어있는 배열 칸은 0으로 초기화된다.)
                {
                    endings[i] = BOSS_ENDING;  // 엔딩 유형을 저장한다.
                    break;                     // 그리고 반복문을 빠져나온다.
                }
            }
        }


        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("。　　　　　　　　　　　　　　　　　ﾟ　　　.　　　　　　　　　　　　　　.");
        System.out.println("　　　　　　　　　.　 .　　　　　　　　.");
        System.out.println(" 　　　　　。　　　　　　　　　　　　　　　　　　　ﾟ　　　　　　　　　。");
        System.out.println("　　.　　　　　　　　.　　　　　.　　　　　　　　　　。　　.　");
        System.out.println("　.　　　　　　　　　　　　　　                   ㅤㅤㅤㅤㅤㅤㅤㅤㅤ 　 。　　.");
        System.out.printf("\t\t 코인을 아끼며 열심히 일한 %s님은 모은 코인으로 카페를 차렸습니다.\n", User.getName());
        System.out.printf("\t\t %s님은 더이상 알바생이 아닙니다.\n", User.getName());
        System.out.println("　　.　　　　　　　　.　　　　　.　　　　　　　　　　。　　.　");
        System.out.println();
        finalEnding();

    }

    // 5. 해고 엔딩 :  총 음료 제조 횟수/ 숙련도 < 이번 주 실패 횟수(호출 완료)
    public void getFireEnding()
    {
        // 엔딩 저장
        int[] endings = User.getEndings();
        boolean flag = true;                    // 배열 안에 중복되는 값이 있는지 구분하기 위한 변수

        // 해고 엔딩
        int GET_FIRE_ENDING = 5;

        // 배열에 중복되는 엔딩 유형 있는지 비교
        for (int ending : endings)           // 0부터 (배열의 길이-1)까지 반복(== 엔딩 유형의 수만큼 반복)
        {
            if (ending == GET_FIRE_ENDING)   // 엔딩 유형과 중복되는 값이 있다면
            {
                flag = false;                // flag 에 false 대입하고
                break;                       // 반복문 빠져나온다
            }
        }

        if(flag) // flag 가 true 일 때(== 중복되는 값이 없다면) 조건문 실행
        {
            for (int i = 0; i < endings.length; i++)    // 0부터 배열 길이만큼 반복해서
            {
                if(endings[i] == 0) // 배열 칸 비어있는 곳에(비어있는 배열 칸은 0으로 초기화된다.)
                {
                    endings[i] = GET_FIRE_ENDING;  // 엔딩 유형을 저장한다.
                    break;                          // 그리고 반복문을 빠져나온다.
                }
            }
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("。　　　　　　　　　　　　　　　　　ﾟ　　　.　　　　　　　　　　　　　　.");
        System.out.println("　　　　　　　　　.　 .　　　　　　　　.");
        System.out.println(" 　　　　　。　　　　　　　　　　　　　　　　　　　ﾟ　　　　　　　　　。");
        System.out.println("　　.　　　　　　　　.　　　　　.　　　　　　　　　　。　　.　");
        System.out.println("　.　　　　　　　　　　　　　　                   ㅤㅤㅤㅤㅤㅤㅤㅤㅤ 　 。　　.");
        System.out.printf("\t\t\t\t %s님은 음료 제조 실수가 잦아 해고되었습니다.\n", User.getName());
        System.out.println("\t\t\t\t 괜찮습니다. 카페는 많으니까요... 힘내세요! ");
        System.out.println("　　.　　　　　　　　.　　　　　.　　　　　　　　　　。　　.　");
        System.out.println();
        finalEnding();

    }


    // 6. 4주차가 지나고 이도저도 아닌 경우 : 알바 엔딩 (호출 완료)
    public void partimerEnding()
    {
        // 엔딩 저장
        int[] endings = User.getEndings();
        boolean flag = true;                 // 배열 안에 중복되는 값이 있는지 구분하기 위한 변수

        // 알바 엔딩
        int PARTIMER_ENDING = 6;

        // 배열에 중복되는 엔딩 유형 있는지 비교
        for (int ending : endings)           // 0부터 (배열의 길이-1)까지 반복(== 엔딩 유형의 수만큼 반복)
        {
            if (ending == PARTIMER_ENDING)   // 엔딩 유형과 중복되는 값이 있다면
            {
                flag = false;                // flag 에 false 대입하고
                break;                       // 반복문 빠져나오기 
            }
        }

        if(flag) // flag 가 true 일 때(== 중복되는 값이 없다면) 조건문 실행
        {
            for (int i = 0; i < endings.length; i++)    // 0부터 배열 길이만큼 반복해서
            {
                if(endings[i] == 0) // 배열 칸 비어있는 곳에(비어있는 배열 칸은 0으로 초기화된다.)
                {
                    endings[i] = PARTIMER_ENDING;  // 엔딩 유형을 저장한다.
                    break;                          // 그리고 반복문을 빠져나온다.
                }
            }
        }


        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("。　　　　　　　　　　　　　　　　　ﾟ　　　.　　　　　　　　　　　　　　.");
        System.out.println("　　　　　　　　　.　 .　　　　　　　　.");
        System.out.println(" 　　　　　。　　　　　　　　　　　　　　　　　　　ﾟ　　　　　　　　　。");
        System.out.println("　　.　　　　　　　　.　　　　　.　　　　　　　　　　。　　.　");
        System.out.println("　.　　　　　　　　　　　　　　                   ㅤㅤㅤㅤㅤㅤㅤㅤㅤ 　 。　　.");
        System.out.printf("\t\t %s님은 카페 아르바이트를 능숙하게 해내고 있습니다.\n", User.getName());
        System.out.println("\t\t\t\t 스파이보다 적성에 잘 맞는 일을 찾았습니다 ! ");
        System.out.println("　　.　　　　　　　　.　　　　　.　　　　　　　　　　。　　.　");
        System.out.println();
        finalEnding();


    }

    // 7. END
    public void finalEnding()
    {
        boolean check =true;    // 반복여부 체크하기 위한 변수
        String resultStr;
        int result = 0;


        System.out.println("　.　　　　　　　　　　　　　　                   ㅤㅤㅤㅤㅤㅤㅤㅤㅤ 　 。　　.");
        System.out.println("　 　　　　　　。　　　　　　　　- End - 　　ﾟ　　　.　　　　　　　　　　　　　　.");
        System.out.println(",　　　　　　　　　.　 .　　　　　　　　.");
        System.out.println("　　　　　。　　　　　　　　　　　　　　　　　　　ﾟ　　　　　　　　　。");
        System.out.println("　　.　　　　　　　　.　　　　　.　　　　　　　　　　。　　.");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();


        while(check) // check 는 위에서 입력받은 유저이름이 한글인걸 확인했기 때문에 true 인 상황이다.
        {
            System.out.println("========================================================================");
            System.out.println(" 1.끝내기  2.다시 시작하기 ");
            System.out.println("------------------------------------------------------------------------");
            System.out.print(" 선택 : ");
            Scanner sc = new Scanner(System.in);
            resultStr = sc.nextLine();
            System.out.println("========================================================================");

            // 입력받은 값이 숫자인지 확인
            try
            {
                // 입력받은 값의 공백을 제거하고
                // 자료형 변경한 뒤(String → int) int형에 담는다.
                result = Integer.parseInt(resultStr.replace(" ",""));
                check = false;
                // int 형으로 변경되면 check 에 false 담아서 반복문 빠져나간다.
                // int형으로 변경되지 않는다면 NumberFormatException 발생
            }
            catch (NumberFormatException e) // NumberFormatException 발생한다면
            {
                check = true;   // check 에 true 담아서 다시 반복
                                // result = 0; 으로 초기화된 상태이므로  하단 if문 내부까지 실행하고 반복된다.
            }

            if(result < 1 || result > 2 )// 주어진 값 이외의 수를 선택한 경우
            {
                System.out.println("========================================================================");
                System.out.println(" 올바른 값을 입력해주세요.");
                check = true;
            }

        }

        final int STOP = 1;     // 프로그램 종료하는 선택지
        final int RESTART = 2;  // 다시 시작하는 선택지
        while(true)
        {
            switch(result)
            {
                case STOP : // 프로그램 종료
                    System.exit(0);
                    break;

                case RESTART: // 다시 시작하기

                    UserAction userAction = new UserAction();   // 유저 기능 객체 생성 
                    userAction.reset();                         // 기존 값 초기화하는 메소드 호출 
                    GameRun gameRun = new GameRun();            // 게임 실행 객체 생성
                    gameRun.initialRun();                       // 최초 실행 메소드 호츨
                    break;
            }
        }

    }

    public void openEndings()
    {
        int[] endings = User.getEndings();      // 공개된 엔딩 유형 저장한 배열 불러오기

        if(endings[0]==0)                       // 첫번째 배열 칸이 0 이면 공개된 엔딩이 없다는 뜻이다.
        {
            System.out.println("========================================================================");
            System.out.println(" 현재 공개된 엔딩이 없습니다.");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();


            GameRun gameRun = new GameRun();
            gameRun.initialRun(); // 이전으로
        }
        else    // 공개된 엔딩이 있으면
        {
            final int FALL_DOWN_ENDING = 1; // 과로 엔딩
            final int QUIT_ENDING = 2;      // 퇴사 엔딩
            final int SCOUT_ENDING = 3;     // 이직 엔딩
            final int BOSS_ENDING = 4;      // 사장 엔딩
            final int GET_FIRE_ENDING = 5;  // 해고 엔딩
            final int PARTIMER_ENDING = 6;  // 알바 엔딩

            System.out.println("                         ╔═══━━━─────────━━━═══╗                         ");
            System.out.println("=========================       공개된 엔딩       =========================");
            System.out.println("                         ╚═══━━━─────────━━━═══╝                         ");
            System.out.println();

            int cnt = 0;                    // 공개되지 않은 엔딩의 수를 세기 위한 변수

            // for(대입받을 변수 정의 : 배열)
            for (int endingType : endings)  // int[] endings 배열 각 칸의 값을 배열의 길이만큼 반복하며 int형 EndingType 에 담고 반복문 실행
            {
                if (endingType == 0) // 비어있는 칸이면
                {
                    cnt += 1;      // cnt 변수를 1씩 증가시킨다.
                }
            }

            // test
            //System.out.println(cnt);

            // test
            //for (int i = 0; i < endings.length; i++)
            //{
            // System.out.println(endings[i]);
            //}


            // for(대입받을 변수 정의 : 배열)
            for (int endingType : endings)
            {
                if (endingType == FALL_DOWN_ENDING)
                {
                    System.out.printf(" [과로 엔딩] %s님은 고된 노동에 시달리다 쓰러졌습니다. \n", User.getName());
                    System.out.println("------------------------------------------------------------------------");
                    System.out.println(" ✨ 과로 엔딩 tip ✨ ");
                    System.out.println("    체력이 0 이 되면 과로 엔딩의 조건이 달성됩니다. ");
                    System.out.println("    아이템을 적절히 이용해서 체력을 관리해주세요 ! ");
                    System.out.println("------------------------------------------------------------------------");
                }

                if (endingType == QUIT_ENDING)
                {
                    System.out.printf(" [사표 엔딩] %s님은 극심한 스트레스를 견디지 못해 카페를 떠났습니다. \n", User.getName());
                    System.out.println("------------------------------------------------------------------------");
                    System.out.println(" ✨ 사표 엔딩 tip ✨ ");
                    System.out.println("    인내력이 0 이 되면 사표 엔딩의 조건이 달성됩니다. ");
                    System.out.println("    아이템을 이용해서 인내력을 관리해주세요 ! ");
                    System.out.println("------------------------------------------------------------------------");
                }

                if (endingType == SCOUT_ENDING)
                {
                    System.out.println(" [이직 엔딩] 종종 방문하던 특이한 손님의 일부는 몰래 방문한 인근 카페 사장이었습니다.");
                    System.out.printf("             %s님을 시험하고 눈여겨본 사장은 %s님을 스카웃했습니다.\n", User.getName(), User.getName());
                    System.out.println("------------------------------------------------------------------------");
                    System.out.println(" ✨ 이직 엔딩 tip ✨ ");
                    System.out.println("    숙련도와 비밀 손님의 방문 횟수가 일정 기준 이상이면 이직 엔딩의 조건이 달성됩니다. ");
                    System.out.println("------------------------------------------------------------------------");
                }

                if (endingType == BOSS_ENDING)
                {
                    System.out.printf(" [사장 엔딩] 코인을 아끼며 열심히 일한 %s님은 모은 코인으로 카페를 차렸습니다.\n", User.getName());
                    System.out.printf("            %s님은 더이상 알바생이 아닙니다.\n", User.getName());
                    System.out.println("------------------------------------------------------------------------");
                    System.out.println(" ✨ 사장 엔딩 tip ✨ ");
                    System.out.println("    보유하고 있는 코인과 %s님의 숙련도, 방문한 손님 수가 일정 기준 이상이면 ");
                    System.out.println("    사장 엔딩의 조건이 달성됩니다.");
                    System.out.println("------------------------------------------------------------------------");
                }

                if (endingType == GET_FIRE_ENDING)
                {
                    System.out.printf(" [해고 엔딩] %s님은 음료제조 실수가 잦아 해고되었습니다.\n", User.getName());
                    System.out.println("            괜찮습니다 카페는 많으니까요... 힘내세요!");
                    System.out.println("------------------------------------------------------------------------");
                    System.out.println(" ✨ 해고 엔딩 tip ✨ ");
                    System.out.println("    음료제조 실패 확률이 높아지면 해고 엔딩의 조건이 달성됩니다.");
                    System.out.println("------------------------------------------------------------------------");
                }

                if (endingType == PARTIMER_ENDING)
                {
                    System.out.printf(" [알바 엔딩] %s님은 카페 아르바이트를 능숙하게 해내고 있습니다.\n", User.getName());
                    System.out.println("------------------------------------------------------------------------");
                    System.out.println(" ✨ 알바 엔딩 tip ✨ ");
                    System.out.println("    비밀입니다.");
                    System.out.println("------------------------------------------------------------------------");
                }

                // 엔딩 유형 추가하기... 멋진 카페 엔딩

            }

            System.out.printf(" 아직 공개되지 않은 엔딩이 %d개 남아있습니다 !\n", cnt);
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();


        }

        GameRun gameRun = new GameRun();
        gameRun.initialRun();  // 이전으로

    }//end openEnding()

    // 외부에서 속성에 접근할 수 있도록 getter 생성
    public static int getEndingTypeNum()
    {
        return ENDING_TYPE_NUM;
    }

}
