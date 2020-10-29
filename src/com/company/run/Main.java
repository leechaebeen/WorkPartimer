package com.company.run;

public class Main {

    public static void main(String[] args)
    {
        final int INITIAL_RUN = 1;
        final int START = 2;

        Run run = new Run();            // Run 객체 생성
        int initialSel = 0;             // 초기화면 실행 후 유저의 선택값 받음
                                        // 1.시작하기 2.다시 시작하기

        switch(initialSel)
        {
            case  INITIAL_RUN: run.initialRun();

            break;

            case  START:

            break;

            default:  run.initialRun();
                break;

        }



    }
}
