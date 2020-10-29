package com.company.character;

// Character 클래스를 상속받아 hp 속성 사용 가능
// 손님 고유의 속성과 기능을 추가한 클래스이다.
public class Customer extends Character
{
    boolean takeout;    // 테이크아웃 여부 담는 변수

    // 음료 주문하는 메소드(음료, Hot/Ice 옵션, 휘핑, 테이크아웃)
    public void orderBeverage()
    {
        Partimer partimer = new Partimer();     // 유저 객체 생성
        String userName = partimer.getName();   // 유저 이름 저장

        System.out.println(" 딸랑 ");
        System.out.printf("%s : 어서오세요");

    }


    // 자리 줄어드는 메소드
}
