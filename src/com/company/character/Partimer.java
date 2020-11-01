package com.company.character;

import com.company.run.Ending;

// 게임을 진행하는 유저의 속성을 담은 클래스
public class Partimer
{
    private static String name;         // 유저에게 입력받은 이름
    private static int skillLevel = 1;  // 현재 숙련도 : 하루에 등장하는 손님 수 , 일주일에 1 씩 증가(아직 설정 X)

    // 현재 캐릭터의 능력치 :  한 주가 지날 때마다 세팅된 값으로 초기화. 첫 주는 초기화 되지 않으므로 각각 10으로 초기화.
    protected static int hp = 5;           // 현재 체력
    private static int feeling = 5;        // 현재 인내력

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

    private static int[] endings = new int[Ending.getEndingTypeNum()]; // 모은 엔딩 저장하는 배열.





    // 클래스 외부에서 속성에 접근할 수 있도록 getter/setter 생성
    public static int getHp()
    {
        return hp;
    }

    public static void setHp(int hp)
    {
        Partimer.hp = hp;
    }

    public static int getSetHp()
    {
        return setHp;
    }

    public static void setSetHp(int setHp)
    {
        Partimer.setHp = setHp;
    }
    public static String getName()
    {
        return name;
    }
    public static void setName(String name)
    {
        Partimer.name = name;
    }
    public static int getSkillLevel()
    {
        return skillLevel;
    }

    public static void setSkillLevel(int skillLevel)
    {
        Partimer.skillLevel = skillLevel;
    }

    public static int getFeeling()
    {
        return feeling;
    }

    public static void setFeeling(int feeling)
    {
        Partimer.feeling = feeling;
    }

    public static int getSalary()
    {
        return salary;
    }

    public static void setSalary(int salary)
    {
        Partimer.salary = salary;
    }

    public static int getProperty()
    {
        return property;
    }

    public static void setProperty(int property)
    {
        Partimer.property = property;
    }

    public static int getWorkingDays()
    {
        return workingDays;
    }

    public static void setWorkingDays(int workingDays)
    {
        Partimer.workingDays = workingDays;
    }

    public static int getSetFeeling()
    {
        return setFeeling;
    }

    public static void setSetFeeling(int setFeeling)
    {
        Partimer.setFeeling = setFeeling;
    }

    public static int getFailNum()
    {
        return failNum;
    }

    public static void setFailNum(int failNum)
    {
        Partimer.failNum = failNum;
    }

    public static int getSuccessNum()
    {
        return successNum;
    }

    public static void setSuccessNum(int successNum)
    {
        Partimer.successNum = successNum;
    }

    public static int[] getEndings()
    {
        return endings;
    }

    public static void setEndings(int[] endings)
    {
        Partimer.endings = endings;
    }
}
