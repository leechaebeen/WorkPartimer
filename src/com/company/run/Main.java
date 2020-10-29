package com.company.run;

public class Main {

    public static void main(String[] args)
    {
        final int START = 1;            // 게임 시작
        final int INITIAL_RUN = 2;      // 초기화면 실행

        Run run = new Run();                // Run 객체 생성
        int initialSel = run.initialRun();  // 초기화면 실행 후 유저의 선택값 반환한다.
                                            // (1.시작하기 2.다시 시작하기)

        while(true)
        {
            switch(initialSel)
            {
                case  START:
                    break;

                case INITIAL_RUN :
                    initialSel = run.initialRun();
                    break;
            }

        }



    }
}
