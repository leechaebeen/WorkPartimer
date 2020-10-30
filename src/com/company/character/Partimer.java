package com.company.character;

// 게임에 등장하는 캐릭터들(유저, 손님)의 가장 기본이 되는 속성을 담은 클래스
// Character 클래스를 상속받아 hp 속성 사용가능
// 유저 고유의 속성을 추가한 클래스
public class Partimer extends Character
{
    // private : 이 클래스의 메소드를 통해서만 변경 가능하도록 하기 위해서 사용
    // static : 유저는 한 명이니까 프로그램이 종료될 때까지 값이 계속 유지되도록하기 위해서 사용

    private static String name;         // 유저에게 입력받은 이름

    private static int skillLevel = 3;  // 현재 숙련도 : 하루에 등장하는 손님 수 , 일주일에 1 씩 증가(아직 설정 X)

    protected static int hp = 10;    // 현재 캐릭터의 체력
    protected static int setHp = 10; // 세팅된 캐릭터의 체력 : 아이템을 통해 변경 가능(아직 구현X)

    private static int feeling = 10;       // 현재 인내력 값: 한 주가 지날 때마다 세팅된 기분값으로 초기화(아직 설정X)
    private static int setFeeling = 10;    // 세팅된 인내력 값 : 아이템 사용하면 증가 가능

    private static int salary = 10;     // 한 주에 받는 급여. 단위는 코인이다.
    private static int property;        // 유저가 소유하고 있는 총 재산

    private static int failNum;     // 음료 제조 실패 총 횟수
    private static int successNum;  // 음료 제조 성공 총 횟수

    private static int workingDays; // 총 근무일자 : 7일마다 상점 방문 가능(아직 구현X) / 최대 플레이 가능 일자 설정하기(아직 설정X)


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
}
