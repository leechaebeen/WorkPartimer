package com.company.run;

import com.company.character.Partimer;

import java.util.Scanner;

public class Ending
{
    // 1. HP == 0 엔딩 : 쓰러짐 엔딩
    public void fallDownEnding()
    {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("========================================================================");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(" 으 아 아 아 ㅇㅏ");
        System.out.println("　　　　　　       ㅇ");
        System.out.println("　　　　　          ⋌");
        System.out.println("　　　　 　　   　      ㅇ");
        System.out.println("　 　 　　　　           ㅜ");
        System.out.println("　　　　　　　　　  　　     .");
        System.out.println("　 　　　　　　　　　   　      .");
        System.out.println(" 　 　　　　　　　　　　　         .");

        System.out.println();
        System.out.printf(" %s님은 고된 노동과 스트레스를 견디지 못하고 쓰러졌습니다.\n",Partimer.getName());
        System.out.println();
        finalEnding();
    }


    // 2. Mood == 0 엔딩 : 자발적 퇴사 엔딩
    public void toQuitEnding()
    {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("========================================================================");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(" 더러워서 못 해먹겠다... 때려쳐야지. ");
        System.out.println();
        System.out.printf(" %s님은 스트레스를 견디지 못하고 자발적으로 카페를 떠났습니다.\n", Partimer.getName());
        System.out.println();
        System.out.println();
        finalEnding();

    }
    // 3. n주차 지나고 HP, Mood,숙련도 일정 수준 이상 : 캐스팅 엔딩

    // 4. n주차 지나고 코인 일정 수준 이상 : 사장 엔딩

    // 5. 이도저도 아닌 경우 : 알바생 엔딩


    // 6. 엔딩
    public void finalEnding()
    {
        boolean check =true;    // 반복여부 체크하기 위한 변수
        String resultStr;
        int result = 0;
        
        System.out.println("。　　　　　　　　　　　　　　　　　ﾟ　　　.　　　　　　　　　　　　　　.");
        System.out.println("　　　　　　　　　.　 .　　　　　　　　.");
        System.out.println(" 　　　　　。　　　　　　　　　　　　　　　　　　　ﾟ　　　　　　　　　。");
        System.out.println("　　.　　　　　　　　.　　　　　.　　　　　　　　　　。　　.　");
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
                // 자료형 변경한 뒤(String → int) int형에 담는다.
                result = Integer.parseInt(resultStr);
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

        	final int STOP = 1;  // 다시 처음부터 시작하는 선택지
            final int RESTART = 2;     // 프로그램 종료하는 선택지

            while(true)
            {
                switch(result)
                {
                    case STOP : // 프로그램 종료
                        System.exit(0);
                        break;

                    case RESTART: // 다시 시작하기
                        Run run = new Run();
                        run.initialRun();// result =
                        break;
                }
            }

    }

}
