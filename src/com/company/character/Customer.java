package com.company.character;

import com.company.beverage.Beverage;
import com.company.beverage.BeverageAction;
import com.company.cafe.Cafe;

import java.util.Random;

// Character 클래스를 상속받아 hp 속성 사용 가능
// 손님 고유의 속성과 기능을 추가한 클래스이다.
public class Customer extends Character
{
    // 음료 주문 전 테이크아웃 확인
    public boolean checkTakeout()
    {
        Random rd = new Random();
        int takeout = rd.nextInt(10)+1;      // 1 ~ 10의 랜덤값을 변수 takeout 에 저장.
        boolean checkTakeout = true;

        //테이크 아웃 여부 확인
        if(takeout > 7)  // 랜덤값이 8,9,10 이면 테이크아웃 하지 않는다.
        {
            checkTakeout = false;
            if(Cafe.getChair()>0)                   // 매장에 자리가 있으면
            {
                Cafe.setChair(Cafe.getChair()-1);   // 매장 자리를 하나 줄인다.
            }
            else    // 매장에 자리가 없으면
            {
                System.out.println(" 매장에 자리가 없어서 손님이 나갔다 . . .");
                System.out.println(" 자리를 늘리던가 해야지 원 . . . ");
            }
        }

        return checkTakeout;

    } // end checkTakeout()

    // 주문할 음료 객체 생성하는 메소드(음료, Hot/Ice 옵션, 휘핑)
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

    // 손님이 음료를 주문하는 메소드
    public void orderToPartimer(Beverage beverage)
    {
        String iceOption;
        String whippingCream;
        String takeout;

        // ICE / HOT 선택값에 따라 대사 분기할 수 있도록 변수에 담기
        if(beverage.getIceOption()==0)  // 0이면 HOT
        {
            iceOption = "뜨거운 ";
        }
        else    // 1이면 ICE
        {
            iceOption = "차가운 ";
        }

        // 휘핑 선택
        if(beverage.getWhippingCream()==0) // 0 이면 휘핑크림 X
        {
            whippingCream = "휘핑크림 추가할게요.";
        }
        else // 1 이면 휘핑크림 O
        {
            whippingCream = "";
        }

        // 테이크아웃
        if(checkTakeout())  // checkTakeout() 는 테이크아웃하면 true 반환
        {
            takeout = " 가지고 갈거에요.";
        }
        else
        {
            takeout = " 먹고 갈거에요.";
        }

        System.out.println(" 손님 : " + iceOption + beverage.getName() + " 주세요.");
        System.out.println("       " + whippingCream + takeout );

    }

    // 음료 잘못 나왔을 때 반응

}
