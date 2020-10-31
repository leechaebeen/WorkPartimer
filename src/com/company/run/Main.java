package com.company.run;

import com.company.cafe.CafeAction;

// 게임의 초기 실행을 담은 클래스
public class Main
{
    public static void main(String[] args)
    {
        final int START = 1;                // 게임 시작
        final int INITIAL_RUN = 2;          // 초기화면 실행

        Run run = new Run();                // Run 객체 생성
        int initialSel = run.initialRun();  // 초기화면 실행하면 유저의 선택값 반환한다.
                                            // (1.시작하기 2.다시 시작하기)

        CafeAction cafeAction = new CafeAction(); // Cafe 객체 생성


        while(true)
        {
            switch(initialSel)              // 유저의 선택값에 따라 분기 처리
            {
                case  START:                // 1. 시작하기를 선택한 경우
                    cafeAction.start();
                    break;

                case INITIAL_RUN :          // 2. 다시 시작하기를 선택한 경우
                    initialSel = run.initialRun();
                    break;
            }

        }



    }
}
