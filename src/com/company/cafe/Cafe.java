package com.company.cafe;

public class Cafe
{
    // 카페 상태
    private static int cup;                 // 현재 사용가능한 유리잔 수 : ICE 음료용
    private static int mug;                 // 현재 사용가능한 머그잔 수 : HOT 음료용
    private static int chair;               // 현재 사용가능한 자리 수 : 한 자리당 한 손님이 앉을 수 있다.
    private static int todayCustomerNum;    // 현재 하루 방문자 수
    private static int totalCustomerNum;    // 총 카페 방문자 수 , 일정 기준이 자나면 게임 엔딩

    // 카페 설정값
    private static int setCup = 1;          // 설정되어 있는 유리잔 수
    private static int setMug = 1;          // 설정되어 있는 머그잔 수
    private static int setChair = 2;        // 설정되어 있는 자리 수

    // getter/setter
    public static int getCup()
    {
        return cup;
    }

    public static void setCup(int cup)
    {
        Cafe.cup = cup;
    }

    public static int getMug()
    {
        return mug;
    }

    public static void setMug(int mug)
    {
        Cafe.mug = mug;
    }

    public static int getChair()
    {
        return chair;
    }

    public static void setChair(int chair)
    {
        Cafe.chair = chair;
    }

    public static int getTodayCustomerNum()
    {
        return todayCustomerNum;
    }

    public static void setTodayCustomerNum(int todayCustomerNum)
    {
        Cafe.todayCustomerNum = todayCustomerNum;
    }

    public static int getTotalCustomerNum()
    {
        return totalCustomerNum;
    }

    public static void setTotalCustomerNum(int totalCustomerNum)
    {
        Cafe.totalCustomerNum = totalCustomerNum;
    }

    public static int getSetCup()
    {
        return setCup;
    }

    public static void setSetCup(int setCup)
    {
        Cafe.setCup = setCup;
    }

    public static int getSetMug()
    {
        return setMug;
    }

    public static void setSetMug(int setMug)
    {
        Cafe.setMug = setMug;
    }

    public static int getSetChair()
    {
        return setChair;
    }

    public static void setSetChair(int setChair)
    {
        Cafe.setChair = setChair;
    }


}
