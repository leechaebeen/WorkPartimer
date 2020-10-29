package com.company.character;

import com.company.beverage.Beverage;
import com.company.beverage.BeverageAction;
import com.company.cafe.Cafe;

import java.util.Random;

// Character 클래스를 상속받아 hp 속성 사용 가능
// 손님 고유의 속성과 기능을 추가한 클래스이다.
public class Customer extends Character
{
    // 음료 주문 전 조건 확인
    public void checkTakeout()
    {
        Random rd = new Random();
        int takeout = rd.nextInt(10)+1;      // 1 ~ 10의 랜덤값을 변수 takeout 에 저장.

        //테이크 아웃 여부 확인
        if(takeout > 7)  // 랜덤값이 8,9,10 이면 테이크아웃 하지 않는다.
        {
            if(Cafe.getChair()>0)                   // 매장에 자리가 있으면
            {
                Cafe.setChair(Cafe.getChair()-1);   // 매장 자리를 하나 줄인다.
            }
            else    // 매장에 자리가 없으면
            {
                System.out.println(" 매장에 자리가 없어서 나갔다 . . .");
                System.out.println(" 자리를 늘리던가 해야지 원 . . . ");

                return;
            }
        }

    } // end checkTakeout()

    // 주문할 음료 객체 생성하는 메소드(음료, Hot/Ice 옵션, 휘핑, 테이크아웃)
    public Beverage orderBeverage()
    {
        Random rd = new Random();               // 랜덤 클래스 객체 생성

        // Ice or Hot 랜덤 선택
        int iceOption = rd.nextInt(2);      // 0 또는 1의 랜덤값을 변수 iceOption 에 저장한다.

        // 휘핑크림 유무 랜덤 선택
        int whippingCream = rd.nextInt(2);  // 0 또는 1의 랜덤값을 변수 whippingCream 에 저장한다.

        // 음료 주문
        int beverageSel = rd.nextInt(5)+1; // 1 ~ 5 의 랜덤값을 변수 beverage 에 저장한다.
        BeverageAction beverageAction = new BeverageAction();
        Beverage beverage = beverageAction.createBeverage(beverageSel, iceOption, whippingCream);   // 음료 객체 생성

        return beverage;

    }// end orderBeverage()

    // 음료 주문하는 말하기
    public void orderToPartimer(Beverage beverage)
    {
        String iceOption = "";



        // ICE / HOT 선택값에 따라 대사 분기할 수 있도록 변수에 담기
        if(beverage.getIceOption()==0)  // 0이면 HOT
        {

        }
        else
        {

        }

        System.out.println("손님 : " + beverage.getName() + " 한 잔이요.");

    }


}
