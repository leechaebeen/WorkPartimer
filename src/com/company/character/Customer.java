package com.company.character;

import com.company.beverage.Beverage;
import com.company.beverage.BeverageAction;
import com.company.cafe.Cafe;
import com.company.run.Ending;

import java.util.Random;

// 게임에 등장하는 캐릭터들(유저, 손님)의 가장 기본이 되는 속성을 담은 클래스.
// 이 클래스를 상속받는 클래스가 존재한다.
public class Customer
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
            whippingCream = "";
        }
        else // 1 이면 휘핑크림 O
        {
            whippingCream = "휘핑크림 추가할게요.";
        }

        // 테이크아웃
        boolean checkTakeout = checkTakeout();
        if(checkTakeout)  // checkTakeout() 는 테이크아웃하면 true 반환
        {
            takeout = " 가지고 갈거에요.";
        }
        else
        {
            takeout = " 먹고 갈거에요.";
        }

        System.out.println(" 손님 : " + iceOption + beverage.getName() + " 주세요.");
        System.out.println("       " + whippingCream + takeout );

        if(!checkTakeout) // 매장에서 먹고 간다면
        {
            // 매장에 자리가 있는지 확인
            if(Cafe.getChair()==0)    // 매장에 자리가 없으면 손님이 나간다.
            {
                System.out.println("========================================================================");
                System.out.println(" 매장에 자리가 없어서 손님이 나갔습니다. ");
                System.out.println("========================================================================");
            }
            else
            {
                Cafe.setChair(Cafe.getChair()-1);// 매장 자리를 하나 줄인다.
            }

            // 유리잔 또는 머그잔 감소시키기.
            if(beverage.getIceOption()==0 && Cafe.getMug() !=0 ) // 뜨거운 음료이고 머그잔이 있으면
            {
                Cafe.setMug(Cafe.getMug() - 1); // 머그잔 1 감소
            }
            else if(beverage.getIceOption()==1 && Cafe.getCup() != 0) // 차가운 음료이고 유리잔이 있으면
            {
                Cafe.setCup(Cafe.getCup() - 1); // 유리잔 1 감소
            }
            else    // 뜨거운 음료인데 머그잔이 없거나 차가운 음료인데 유리잔이 없으면 유저 인내력 1 감소
            {
                Partimer.setHp(Partimer.getHp() - 1);
                System.out.println("========================================================================");
                System.out.println(" 매장에 잔이 모자라 일회용 컵을 사용했습니다. 컴플레인이 들어왔습니다. ");
                System.out.printf(" %s님의 인내력이 1 감소합니다.\n", Partimer.getName());
                System.out.printf(" 현재 %s님의 인내력 : %d\n", Partimer.getName(), Partimer.getFeeling());
                System.out.println("========================================================================");
                // 유저 상태 체크
                if(Partimer.getFeeling()==0)       // 인내력이 이 0이 된다면
                {
                    Ending ending = new Ending();   // 자발적으로 관두는 엔딩
                    ending.toQuitEnding();
                }
            }
        }

    }

}
