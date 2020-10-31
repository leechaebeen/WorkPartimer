package com.company.character;

import com.company.beverage.Beverage;

public class SecretCustomer extends SpecialCustomer
{
    private static int count; // 등장횟수 누적해서 카운트 하는 변수

    @Override
    public void orderTalkDown(Beverage beverage)
    {
        super.orderTalkDown(beverage);
        SecretCustomer.setCount(SecretCustomer.getCount() + 1);

        System.out.println(" 비밀손님  ");
    }

    @Override
    public void orderFight(Beverage beverage)
    {
        super.orderFight(beverage);
        SecretCustomer.setCount(SecretCustomer.getCount() + 1);

        System.out.println(" 비밀손님  ");
    }

    @Override
    public void orderToPartimer(Beverage beverage)
    {
        super.orderToPartimer(beverage);
        SecretCustomer.setCount(SecretCustomer.getCount() + 1);

        System.out.println(" 비밀손님  ");
    }

    // 외부에서 속성 값에 접근할 수 있도록 getter/setter 생성
    public static int getCount()
    {
        return count;
    }

    public static void setCount(int count)
    {
        SecretCustomer.count = count;
    }
}
