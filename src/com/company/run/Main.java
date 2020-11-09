package com.company.run;

import com.company.action.BattleAction;

// 최초 실행 기능을 담은 클래스
public class Main
{
    public static void main(String[] args)
    {
        BattleAction battleAction = new BattleAction();
        battleAction.comeBug();

        GameRun gameRun = new GameRun();    // 게임 실행 객체 생성
        gameRun.initialRun();               // 프로그램 최초 실행하는 메소드 호출

    }
}
