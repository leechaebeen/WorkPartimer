package com.company.character;

import com.company.cafe.Cafe;

import java.util.Random;

// Character 클래스를 상속받아 hp 속성 사용 가능
// 손님 고유의 속성과 기능을 추가한 클래스이다.
public class Customer extends Character
{
    // 음료 주문하는 메소드(음료, Hot/Ice 옵션, 휘핑, 테이크아웃)
    public void orderBeverage()
    {
        Partimer partimer = new Partimer();     // 유저 객체 생성
        String userName = partimer.getName();   // 유저 이름 저장

        Random rd = new Random();               // 랜덤 클래스 객체 생성
        int takeout = rd.nextInt(2);   // 0 또는 1의 랜덤값을 변수 takeout 에 저장.

        //테이크 아웃 여부 확인
        if(takeout == 0)  // 랜덤값이 0 이면 테이크아웃 하지 않는다.
        {
            if(Cafe.getChair()>0)                   // 매장에 자리가 있으면
            {
                Cafe.setChair(Cafe.getChair()-1);   // 매장 자리를 하나 줄인다.
                
                int iceOption = rd.nextInt(2);// 0 또는 1의 랜덤값을 변수 takeout 에 저장


            }
            else    // 매장에 자리가 없으면
            {
                System.out.println(" 매장에 자리가 없어서 나갔다 . . .");
            }
        }


    }


    // 자리 줄어드는 메소드
}
