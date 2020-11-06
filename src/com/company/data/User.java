package com.company.data;

import com.company.run.Ending;

// 게임을 진행하는 유저의 속성을 담은 클래스
public class User
{
    // 유저에게 입력받은 이름
    private static String name;

    // 유저의 현재 능력치
    private static int skillLevel = 1;    // 현재 숙련도 : 하루에 등장하는 손님 수와 같다. 조건을 만족하면 주말마다 1씩 증가할 수 있다.
                                          // 조건 : 총 음료제조 성공 횟수 >= 숙련도 *4
    protected static int hp = 2;          // 현재 체력 // 임의로 2
    private static int feeling = 5;       // 현재 인내력
    // 체력과 인내력은 한 주가 지날 때마다 세팅된 값으로 초기화된다. 첫 주는 초기화되지 않으므로 5로 초기화해준다.


    // 캐릭터의 능력치 세팅값 : 아이템을 구입해 증가시킬 수 있다.
    protected static int setHp = 5;        // 세팅된 초기 체력값
    private static int setFeeling = 5;     // 세팅된 초기 인내력값

    // 유저가 소유하고 있는 총 재산. 단위는 코인이다.
    private static int property;

    // 소유하고 있는 소비아이템 수
    private static int cakeNum;
    private static int sandwichNum;
    private static int chocoNum;
    private static int macaronNum;


    // 음료 제조 관련 변수
    private static int totalFailNum;     // 총 음료제조 실패 횟수
    private static int totalSuccessNum;  // 총 음료제조 성공 횟수

    private static int weekFailNum;    // 이번주 음료제조 실패 횟수
    private static int weekSuccessNum; // 이번주 음료제조 성공 횟수

    // 근무 일수 변수
    private static int workingDays;  // 총 근무일수 : 평일과 주말을 구분하고 몇 주차인지 나타내기 위해 사용한다.

    // 엔딩 관련 변수
    private final static int[] endings = new int[Ending.getEndingTypeNum()];  // 공개된 엔딩 유형을 저장하는 배열.

    // 클래스 외부에서 속성에 접근할 수 있도록 getter/setter 생성
    public static int getHp()
    {
        return hp;
    }

    public static void setHp(int hp)
    {
        User.hp = hp;
    }

    public static int getSetHp()
    {
        return setHp;
    }

    public static void setSetHp(int setHp)
    {
        User.setHp = setHp;
    }

    public static String getName()
    {
        return name;
    }

    public static void setName(String name)
    {
        User.name = name;
    }

    public static int getSkillLevel()
    {
        return skillLevel;
    }

    public static void setSkillLevel(int skillLevel)
    {
        User.skillLevel = skillLevel;
    }

    public static int getFeeling()
    {
        return feeling;
    }

    public static void setFeeling(int feeling)
    {
        User.feeling = feeling;
    }

    public static int getProperty()
    {
        return property;
    }

    public static void setProperty(int property)
    {
        User.property = property;
    }

    public static int getWorkingDays()
    {
        return workingDays;
    }

    public static void setWorkingDays(int workingDays)
    {
        User.workingDays = workingDays;
    }

    public static int getSetFeeling()
    {
        return setFeeling;
    }

    public static void setSetFeeling(int setFeeling)
    {
        User.setFeeling = setFeeling;
    }

    public static int getTotalFailNum()
    {
        return totalFailNum;
    }

    public static void setTotalFailNum(int totalFailNum)
    {
        User.totalFailNum = totalFailNum;
    }

    public static int getTotalSuccessNum()
    {
        return totalSuccessNum;
    }

    public static void setTotalSuccessNum(int totalSuccessNum)
    {
        User.totalSuccessNum = totalSuccessNum;
    }

    public static int[] getEndings()
    {
        return endings;
    }

    public static int getWeekFailNum()
    {
        return weekFailNum;
    }

    public static void setWeekFailNum(int weekFailNum)
    {
        User.weekFailNum = weekFailNum;
    }

    public static int getWeekSuccessNum()
    {
        return weekSuccessNum;
    }

    public static void setWeekSuccessNum(int weekSuccessNum)
    {
        User.weekSuccessNum = weekSuccessNum;
    }

    public static int getCakeNum()
    {
        return cakeNum;
    }

    public static void setCakeNum(int cakeNum)
    {
        User.cakeNum = cakeNum;
    }

    public static int getSandwichNum()
    {
        return sandwichNum;
    }

    public static void setSandwichNum(int sandwichNum)
    {
        User.sandwichNum = sandwichNum;
    }

    public static int getChocoNum()
    {
        return chocoNum;
    }

    public static void setChocoNum(int chocoNum)
    {
        User.chocoNum = chocoNum;
    }

    public static int getMacaronNum()
    {
        return macaronNum;
    }

    public static void setMacaronNum(int macaronNum)
    {
        User.macaronNum = macaronNum;
    }
}
