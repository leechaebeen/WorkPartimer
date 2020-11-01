package com.company.run;

import com.company.cafe.Cafe;
import com.company.cafe.CafeAction;
import com.company.cafe.Item;
import com.company.character.Partimer;

import java.util.Scanner;

public class Ending
{
    private static int endingTypeNum = 6;
    // static 이어야하는 이유 :
    // Partimer 클래스의 모은 엔딩 유형을 저장하는 배열이 static 변수라서
    // 배열 초기화할 때 길이를 나타내는 변수도 static 이어야한다.
    // → private static int[] endings = new int[Ending.getEndingTypeNum()];

    private final int FALL_DOWN_ENDING = 1; // 쓰러지는 엔딩
    private final int QUIT_ENDING = 2;      // 그만두는 엔딩
    private final int SCOUT_ENDING = 3;     // 스카웃 엔딩
    private final int BOSS_ENDING = 4;      // 사장 엔딩
    private final int GET_FIRE_ENDING = 5;  // 해고 엔딩
    private final int PARTIMER_ENDING = 6;  // 알바 엔딩

    // 1. HP == 0 엔딩 : 쓰러짐 엔딩
    public void fallDownEnding()
    {
        // 엔딩 저장
        int[] endings = Partimer.getEndings();

        for (int i = 0; i < endings.length; i++)    // 0부터 배열 길이만큼 반복해서
        {
            if(endings[i] == 0) // 배열 칸 비어있는 곳에(비어있는 배열 칸은 0으로 초기화된다.)
            {
                endings[i] = FALL_DOWN_ENDING;  // 엔딩 유형을 저장한다.
            }
        }

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
        System.out.printf("\t\t %s님은 고된 노동을 견디지 못하고 쓰러졌습니다.\n",Partimer.getName());
        System.out.println("　　.　　　　　　　　.　　　　　.　　　　　　　　　　。　　.　");
        System.out.println();
        finalEnding();
    }


    // 2. Feeling == 0 엔딩 : 자발적 퇴사 엔딩
    public void toQuitEnding()
    {
        // 엔딩 저장
        int[] endings = Partimer.getEndings();

        for (int i = 0; i < endings.length; i++)    // 0부터 배열 길이만큼
        {
            if(endings[i] == 0) // 배열 칸 비어있는 곳에(비어있는 배열 칸은 0으로 초기화된다.)
            {
                endings[i] = QUIT_ENDING;
            }
        }

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
        System.out.printf("\t\t %s님은 스트레스를 견디지 못하고 자발적으로 카페를 떠났습니다.\n", Partimer.getName());
        System.out.println("　　.　　　　　　　　.　　　　　.　　　　　　　　　　。　　.　");
        System.out.println();
        finalEnding();

    }
    // 3. n주차 지나고 숙련도 일정 수준 이상, secret 손님 방문 n회 이상 : 스카웃 엔딩
    public void scoutEnding()
    {
        // 엔딩 저장
        int[] endings = Partimer.getEndings();

        for (int i = 0; i < endings.length; i++)    // 0부터 배열 길이만큼
        {
            if(endings[i] == 0) // 배열 칸 비어있는 곳에(비어있는 배열 칸은 0으로 초기화된다.)
            {
                endings[i] = SCOUT_ENDING;
            }
        }

    }

    // 4. n주차 지나고 코인 일정 수준 이상 : 사장 엔딩
    public void bossEnding()
    {
        // 엔딩 저장
        int[] endings = Partimer.getEndings();

        for (int i = 0; i < endings.length; i++)    // 0부터 배열 길이만큼
        {
            if(endings[i] == 0) // 배열 칸 비어있는 곳에(비어있는 배열 칸은 0으로 초기화된다.)
            {
                endings[i] = BOSS_ENDING;
            }
        }

    }

    // 5. 총 손님수/fail 횟수 > 0.5인 경우 : 해고 엔딩
    public void getFireEnding()
    {
        // 엔딩 저장
        int[] endings = Partimer.getEndings();

        for (int i = 0; i < endings.length; i++)    // 0부터 배열 길이만큼
        {
            if(endings[i] == 0) // 배열 칸 비어있는 곳에(비어있는 배열 칸은 0으로 초기화된다.)
            {
                endings[i] = GET_FIRE_ENDING;
            }
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("\t\t\t\t 오늘도 또 실수했다... ");

        System.out.println();
        System.out.println();

        System.out.println("。　　　　　　　　　　　　　　　　　ﾟ　　　.　　　　　　　　　　　　　　.");
        System.out.println("　　　　　　　　　.　 .　　　　　　　　.");
        System.out.println(" 　　　　　。　　　　　　　　　　　　　　　　　　　ﾟ　　　　　　　　　。");
        System.out.println("　　.　　　　　　　　.　　　　　.　　　　　　　　　　。　　.　");
        System.out.println("　.　　　　　　　　　　　　　　                   ㅤㅤㅤㅤㅤㅤㅤㅤㅤ 　 。　　.");
        System.out.printf("\t\t %s님은 실수가 잦아 카페에서 해고되었습니다. \n",Partimer.getName());
        System.out.println("　　.　　　　　　　　.　　　　　.　　　　　　　　　　。　　.　");
        System.out.println();
        System.out.println();
        finalEnding();

    }


    // 6. 이도저도 아닌 경우 : 알바생 엔딩
    public void partimerEnding()
    {
        // 엔딩 저장
        int[] endings = Partimer.getEndings();

        for (int i = 0; i < endings.length; i++)    // 0부터 배열 길이만큼
        {
            if(endings[i] == 0) // 배열 칸 비어있는 곳에(비어있는 배열 칸은 0으로 초기화된다.)
            {
                endings[i] = PARTIMER_ENDING;
            }
        }
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
                    reset();  // 이전 플레이의 모든 세팅값 리셋하는 메소드
                    Run run = new Run();
                    run.initialRun();
                    break;
            }
        }

    }

    // 이전 플레이의 모든 값 리셋
    public void reset()
    {
        // 유저 관련
        Partimer.setSetHp(5);
        Partimer.setSetFeeling(5);
        Partimer.setHp(5);
        Partimer.setFeeling(5);
        Partimer.setProperty(0);
        Partimer.setSkillLevel(1);
        Partimer.setWorkingDays(0);
        Partimer.setSuccessNum(0);
        Partimer.setFailNum(0);

        // 아이템 관련
        Item.setCake(0);
        Item.setSandwich(0);
        Item.setChoco(0);
        Item.setMacaron(0);

        // 카페 관련
        Cafe.setTotalCustomerNum(0);
        Cafe.setSetChair(2);
        Cafe.setSetCup(1);
        Cafe.setSetMug(1);

    }

    public static int getEndingTypeNum()
    {
        return endingTypeNum;
    }

    public static void setEndingTypeNum(int endingTypeNum)
    {
        Ending.endingTypeNum = endingTypeNum;
    }
}
