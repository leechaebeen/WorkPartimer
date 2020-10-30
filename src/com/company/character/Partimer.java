package com.company.character;

// 게임에 등장하는 캐릭터들(유저, 손님)의 가장 기본이 되는 속성을 담은 클래스
// Character 클래스를 상속받아 hp 속성 사용가능
// 유저 고유의 속성을 추가한 클래스
public class Partimer extends Character
{
    // private : 이 클래스의 메소드를 통해서만 변경 가능하도록 하기 위해서 사용
    // static : 유저는 한 명이니까 프로그램이 종료될 때까지 값이 계속 유지되도록하기 위해서 사용
    private static String name;         // 유저에게 입력받은 이름

    private static int skillLevel = 3;  // 현재 숙련도 : 하루에 등장하는 손님 수 , 일주일에 1 씩 증가

    private static int mood = 10;       // 현재 기분 : 한 주가 지날 때마다 세팅된 기분값으로 초기화
    private static int setMood = 10;    // 세팅된 기분 : 아이템 사용하면 증가 가능

    private static int salary = 10;     // 한 주에 받는 급여. 단위는 코인이다.
    private static int property = 0;    // 유저가 소유하고 있는 총 재산


    private static int workingDays = 0; // 총 근무일자 : 7일마다 상점 방문 가능 / 최대 플레이 가능 일자 설정하기,


    // 클래스 외부에서 속성에 접근할 수 있도록 getter/setter 생성
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

    public static int getMood()
    {
        return mood;
    }

    public static void setMood(int mood)
    {
        Partimer.mood = mood;
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

    public static int getSetMood()
    {
        return setMood;
    }

    public static void setSetMood(int setMood)
    {
        Partimer.setMood = setMood;
    }
}
