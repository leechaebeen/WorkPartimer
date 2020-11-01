package com.company.data;

import com.company.run.Ending;

// 게임을 진행하는 유저의 속성을 담은 클래스
public class User
{
    // 유저에게 입력받은 이름
    private static String name;


    // 유저의 현재 능력치
    private static int skillLevel = 1;                      // 현재 숙련도 : 하루에 등장하는 손님 수와 같다. 조건을 만족하면 주말마다 1씩 증가할 수 있다.
                                                            // 조건 : 누적 음료 제조 성공 횟수 >= (하루 최대 방문자 수)*4
    protected static int hp = User.getSetHp();              // 현재 체력
    private static int feeling = User.getSetFeeling();      // 현재 인내력
    // 체력과 인내력은 한 주가 지날 때마다 세팅된 값으로 초기화된다. 첫 주는 초기화되지 않으므로 세팅된 값으로 초기화해준다.


    // 캐릭터의 능력치 세팅값 : 아이템을 구입해 증가시킬 수 있다.
    protected static int setHp = 5;        // 세팅된 초기 체력값
    private static int setFeeling = 5;     // 세팅된 초기 인내력값


    // 코인 관련 변수
    private static int property;                  // 유저가 소유하고 있는 총 재산
    private static int salary = skillLevel*2;     // 한 주에 받는 급여. 단위는 코인이다.
                                                  // 특정 조건을 만족하면 숙련도 두 배만큼의 코인을 받는다.
                                                  // (조건 : 음료 제조 성공 횟수/주차가 숙련도와 같거나 높아야 한다.)


    // 음료 제조 관련 변수
    private static int failNum;     // 음료 제조 실패 총 횟수
    private static int successNum;  // 음료 제조 성공 총 횟수


    // 근무 일자 변수
    private static int workingDays; // 총 근무일자 : 주말마다 상점 방문 가능/ 최대 플레이 가능 일자 설정하기(아직 설정X)


    // 공개된 엔딩 저장하는 변수. 프로그램을 종료할 때까지 유지된다.
    private static int[] endings = new int[Ending.getEndingTypeNum()];




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

    public static int getSalary()
    {
        return salary;
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

    public static int getFailNum()
    {
        return failNum;
    }

    public static void setFailNum(int failNum)
    {
        User.failNum = failNum;
    }

    public static int getSuccessNum()
    {
        return successNum;
    }

    public static void setSuccessNum(int successNum)
    {
        User.successNum = successNum;
    }

    public static int[] getEndings()
    {
        return endings;
    }

}
