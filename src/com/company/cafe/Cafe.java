package com.company.cafe;

public class Cafe
{
    private static int cup = 5;              // 유리잔 수 - ICE 음료용
    private static int mug = 5;              // 머그잔 수 - HOT 음료용
    private static int chair = 5;            // 자리 수 - 한 자리당 한 손님이 앉을 수 있다.
    private static int todayCustomerNum;     // 하루 방문자 수

    // 유리잔 추가 메소드
    // 유리잔

    // 머그잔 추가 메소드
    // 자리 수 추가 메소드


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
}
