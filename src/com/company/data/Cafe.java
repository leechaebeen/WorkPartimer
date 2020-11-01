package com.company.data;

public class Cafe
{
    // 카페 기구 상태
    private static int cup;                 // 현재 사용가능한 유리잔 수 : ICE 음료용
    private static int mug;                 // 현재 사용가능한 머그잔 수 : HOT 음료용
    private static int chair;               // 현재 사용가능한 의자 수

    // 카페 방문자 수
    private static int todayCustomerNum;    // 현재 하루 방문자 수
    private static int totalCustomerNum;    // 총 카페 방문자 수

    // 카페 설정값
    private static int setCup = 1;          // 설정되어 있는 유리잔 수
    private static int setMug = 1;          // 설정되어 있는 머그잔 수
    private static int setChair = 1;        // 설정되어 있는 의자 수

    // 외부에서 속성에 접근할 수 있도록 getter/setter 생성
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
