package com.company.data;

public class Cafe
{
    // 카페 기구 상태
    private static int cupNum;                 // 현재 사용가능한 유리잔 수 : ICE 음료용
    private static int mugNum;                 // 현재 사용가능한 머그잔 수 : HOT 음료용
    private static int chairNum;               // 현재 사용가능한 의자 수

    // 카페 방문자 수
    private static int todayCustomerNum;    // 현재 하루 방문자 수
    private static int totalCustomerNum;    // 총 방문자 수
    private static int weekCustomerNum;     // 이번주 방문자 수

    // 카페 설정값
    private static int setCupNum = 1;          // 설정되어 있는 유리잔 수
    private static int setMugNum = 1;          // 설정되어 있는 머그잔 수
    private static int setChairNum = 1;        // 설정되어 있는 의자 수

    // 외부에서 속성에 접근할 수 있도록 getter/setter 생성
    public static int getCupNum()
    {
        return cupNum;
    }

    public static void setCupNum(int cupNum)
    {
        Cafe.cupNum = cupNum;
    }

    public static int getMugNum()
    {
        return mugNum;
    }

    public static void setMugNum(int mugNum)
    {
        Cafe.mugNum = mugNum;
    }

    public static int getChairNum()
    {
        return chairNum;
    }

    public static void setChairNum(int chairNum)
    {
        Cafe.chairNum = chairNum;
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

    public static int getSetCupNum()
    {
        return setCupNum;
    }

    public static void setSetCupNum(int setCupNum)
    {
        Cafe.setCupNum = setCupNum;
    }

    public static int getSetMugNum()
    {
        return setMugNum;
    }

    public static void setSetMugNum(int setMugNum)
    {
        Cafe.setMugNum = setMugNum;
    }

    public static int getSetChairNum()
    {
        return setChairNum;
    }

    public static void setSetChairNum(int setChairNum)
    {
        Cafe.setChairNum = setChairNum;
    }

    public static int getWeekCustomerNum()
    {
        return weekCustomerNum;
    }

    public static void setWeekCustomerNum(int weekCustomerNum)
    {
        Cafe.weekCustomerNum = weekCustomerNum;
    }
}
