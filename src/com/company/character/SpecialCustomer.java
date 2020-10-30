package com.company.character;

import com.company.beverage.Beverage;
import com.company.run.Ending;

// Customer 클래스를 상속받아 Character 클래스의 속성과 Customer 클래스의 속성과 기능 사용가능
// 특별손님 고유 기능을 추가한 클래스이다.
public class SpecialCustomer extends Customer
{
    // 음료 주문 전 조건 확인하는 메소드 checkTakeout() - 상속받음
    // 주문할 음료 객체 생성하는 메소드 orderBeverage() - 상속받음

    // 음료 주문하는 메소드
    // 유형1 반말하고 매장에서 먹고가는거 말 안하는 손님 - hp - 기분
    public void orderTalkDown(Beverage beverage)
    {
        // 반말 주문 받으면 유저의 hp 와 mood 가 -1씩 감소한다.
        Partimer.setMood(Partimer.getMood()-1);
        Partimer.setHp(Partimer.getHp()-1);

        if(Partimer.getHp()==0)             // 만약 유저의 HP 0이 된다면
        {
            Ending ending = new Ending();   // 쓰러지는 엔딩
            ending.fallDownEnding();
        }
        else if(Partimer.getMood()==0)       // Mood 가 0이 된다면
        {
            Ending ending = new Ending();   // 자발적으로 관두는 엔딩
            ending.toQuitEnding();
        }

        String iceOption;
        String whippingCream;
        String takeout;

        // ICE / HOT 선택값에 따라 대사 분기
        if(beverage.getIceOption()==0)  // 0이면 HOT
        {
            iceOption = " 뜨거운걸로.";
        }
        else    // 1이면 ICE
        {
            iceOption = " 차가운걸로. ";
        }

        // 휘핑 선택값에 따라 대사 분기
        if(beverage.getWhippingCream()==0) // 0 이면 휘핑크림 X
        {
            whippingCream = "휘핑크림.";
        }
        else // 1 이면 휘핑크림 O
        {
            whippingCream = "";
        }

        // 테이크아웃 선택 값에 따라 대사 분기
        if(checkTakeout())  // checkTakeout() 는 테이크아웃하면 true 반환
        {
            takeout = " 테이크아웃.";
        }
        else    // false 인 경우
        {
            takeout = "";
        }

        System.out.println(" 손님 : " + iceOption + beverage.getName() + iceOption);
        System.out.println("       " + whippingCream + takeout );

    }


    // 유형2 시비걸기
    public void orderFight(Beverage beverage)
    {
        // 반말 주문 받으면 유저의 hp 와 mood 가 -1씩 감소한다.
        Partimer.setMood(Partimer.getMood()-1);
        Partimer.setHp(Partimer.getHp()-1);

        if(Partimer.getHp()==0)             // 만약 유저의 HP 0이 된다면
        {
            Ending ending = new Ending();   // 쓰러지는 엔딩
            ending.fallDownEnding();
        }
        else if(Partimer.getMood()==0)       // Mood 가 0이 된다면
        {
            Ending ending = new Ending();   // 자발적으로 관두는 엔딩
            ending.toQuitEnding();
        }

        String iceOption;
        String whippingCream;
        String takeout;

        // ICE / HOT 선택값에 따라 대사 분기
        if(beverage.getIceOption()==0)  // 0이면 HOT
        {
            iceOption = " 뜨거운걸로.";
        }
        else    // 1이면 ICE
        {
            iceOption = " 차가운걸로. ";
        }

        // 휘핑 선택값에 따라 대사 분기
        if(beverage.getWhippingCream()==0) // 0 이면 휘핑크림 X
        {
            whippingCream = "휘핑크림.";
        }
        else // 1 이면 휘핑크림 O
        {
            whippingCream = "";
        }

        // 테이크아웃 선택 값에 따라 대사 분기
        if(checkTakeout())  // checkTakeout() 는 테이크아웃하면 true 반환
        {
            takeout = " 테이크아웃.";
        }
        else    // false 인 경우
        {
            takeout = "";
        }

        System.out.println(" 손님 : " + iceOption + beverage.getName() + iceOption);
        System.out.println("       " + whippingCream + takeout );
    }
    // 유형3 잔 깨기
    public void orderToPartimer3(Beverage beverage)
    {

    }

    // 유형4 아이템 선물 - 저기요 . . . 제가 보이시나요 . . .
    public void orderToPartimer4(Beverage beverage)
    {

    }
}
