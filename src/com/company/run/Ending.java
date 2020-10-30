package com.company.run;

public class Ending
{
    // 1. HP == 0 엔딩 : 쓰러짐 엔딩
    public void fallDownEnding()
    {
        System.out.println(" 으 아 아 아 ㅇㅏ");
        System.out.println("　　　　　　      ㅇ");
        System.out.println("　　　　　         ⋌");
        System.out.println("　　　　 　　   　     ㅇ");
        System.out.println("　 　 　　　　          ㅜ");
        System.out.println("　　　　　　　　　  　　     .");
        System.out.println("　 　　　　　　　　　   　      .");
        System.out.println(" 　 　　　　　　　　　　　         .");

        System.out.println();
        System.out.println(" %s님은 고된 노동과 스트레스를 견디지 못하고 쓰러졌습니다.");
        finalEnding();
    }


    // 2. Mood == 0 엔딩 : 자발적 퇴사 엔딩
    public void toQuitEnding()
    {
        System.out.println(" 더러워서 못 해먹겠다... 때려쳐야지. ");
        System.out.println();
        System.out.println(" %s님은 스트레스를 견디지 못하고 자발적으로 카페를 떠났습니다.");
        finalEnding();

    }
    // 3. n주차 지나고 HP, Mood,숙련도 일정 수준 이상 : 캐스팅 엔딩

    // 4. n주차 지나고 코인 일정 수준 이상 : 사장 엔딩

    // 5. 이도저도 아닌 경우 : 알바생 엔딩


    // 6. 엔딩
    public void finalEnding()
    {
        System.out.println("。　　　　　　　　　　　　　　　　　ﾟ　　　.　　　　　　　　　　　　　　.");
        System.out.println("　　　　　　　　　.　 .　　　　　　　　.");
        System.out.println(" 　　　　　。　　　　　　　　　　　　　　　　　　　ﾟ　　　　　　　　　。");
        System.out.println("　　.　　　　　　　　.　　　　　.　　　　　　　　　　。　　.　");
        System.out.println("　.　　　　　　　　　　　　　　                   ㅤㅤㅤㅤㅤㅤㅤㅤㅤ 　 。　　.");
        System.out.println("　 　　　　　　。　　　　　　　　- End - 　　ﾟ　　　.　　　　　　　　　　　　　　.");
        System.out.println(",　　　　　　　　　.　 .　　　　　　　　.");
        System.out.println("　　　　　。　　　　　　　　　　　　　　　　　　　ﾟ　　　　　　　　　。");
        System.out.println("　　.　　　　　　　　.　　　　　.　　　　　　　　　　。　　.");
    }

}
