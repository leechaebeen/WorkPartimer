package com.company.action;

import com.company.data.Beverage;
import com.company.data.Cafe;
import com.company.data.User;
import com.company.run.Ending;
import java.util.Random;

// 게임에 등장하는 손님의 가장 기본이 되는 기능을 담은 클래스.
public class CustomerAction
{
    // 테이크아웃 여부 정하는 메소드
    public boolean checkTakeout()
    {
        Random rd = new Random();               // 랜덤 객체 생성
        int takeout = rd.nextInt(10)+1;   // 1 ~ 10의 랜덤값을 변수 takeout 에 저장.
        boolean checkTakeout = true;            // 테이크아웃 여부를 담을 변수

        //테이크 아웃 여부 확인
        if(takeout > 5)                         // 랜덤값이 6~10 이면 테이크아웃 하지 않는다.
        {
            checkTakeout = false;
        }

        return checkTakeout;                    // 랜덤값이 1~5 이면 테이크아웃 한다.

    } // end checkTakeout()

    // 랜덤으로 음료 주문하는 메소드(음료, Hot/Ice 옵션, 휘핑)
    public Beverage orderBeverage()
    {
        Random rd = new Random();               // 랜덤 클래스 객체 생성

        // Ice or Hot 랜덤 선택
        int iceOption = rd.nextInt(2);      // 0 또는 1의 랜덤값을 변수 iceOption 에 저장한다.

        // 휘핑크림 유무 랜덤 선택
        int whippingCream = rd.nextInt(2);  // 0 또는 1의 랜덤값을 변수 whippingCream 에 저장한다.

        // 음료 선택
        int beverageSel = rd.nextInt(5)+1;               // 1 ~ 5 의 랜덤값(음료 메뉴 번호)을 변수 beverageSel 에 저장한다.

        BeverageAction beverageAction = new BeverageAction();  // 음료 객체 생성하는 메소드 가진 객체 생성
        Beverage beverage = beverageAction.createBeverage(beverageSel, iceOption, whippingCream); // 선택한 값들을 매개변수로 넘기며 음료 객체 생성하는 메소드 호출

        return beverage;  // 음료 객체 반환

    }// end orderBeverage()

    // 손님이 음료를 주문하는 메소드
    // 음료를 주문하는 경우 true, 주문하지 않는 경우 false 반환
    public boolean orderToPartimer(Beverage beverage)
    {
        String iceOption;       // ICE/HOT 선택하는 손님대사 담는 변수
        String whippingCream;   // 휘핑크림 여부 선택하는 손님대사 담는 변수
        String takeout;         // 테이크아웃 여부 선택하는 손님대사 담는 변수 

        // ICE / HOT 선택에 따른 대사 담기
        if(beverage.getIceOption() ==0)  // HOT 선택했을 때 
        {
            iceOption = "뜨거운 ";
        }
        else                            // ICE 선택했을 때 
        {
            iceOption = "차가운 ";
        }

        // 휘핑 선택에 따른 대사 담기
        if(beverage.getWhippingCream()==0) // 휘핑크림 안올릴 때
        {
            whippingCream = "";
        }
        else                                // 휘핑크림 올릴 때
        {
            whippingCream = "휘핑크림 추가할게요.";
        }

        // 테이크아웃 선택에 따른 대사 담기
        boolean checkTakeout = checkTakeout();  // 테이크아웃 여부 반환하는 메소드 호출(테이크아웃하면 true 반환)
        if(checkTakeout)                        // 테이크아웃한다면
        {
            takeout = " 가지고 갈거에요.";
        }
        else                                    // 테이크아웃 안한다면
        {
            takeout = " 먹고 갈거에요.";
        }

        System.out.println(" 손님 : " + iceOption + beverage.getName() + " 주세요.");
        System.out.println("       " + whippingCream + takeout );

        if(!checkTakeout)              // 테이크아웃 안한다면
        {
            // 매장에 자리가 있는지 확인
            if(Cafe.getChair()==0)    // 매장에 자리가 없으면 
            {
                System.out.println("========================================================================");
                System.out.println(" 매장에 자리가 없어서 손님이 나갔습니다. ");
                System.out.println("========================================================================");

                return false;                   // false 반환, 메소드 종료
            }
            else                                // 매장에 자리가 있으면
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
                User.setFeeling(User.getFeeling() - 1);
                System.out.println(" 매장에 잔이 모자라 일회용 컵을 사용했습니다. 컴플레인이 들어왔습니다. ");
                System.out.printf(" %s님의 인내력이 1 감소합니다.\n", User.getName());
                System.out.printf(" 현재 %s님의 인내력 : %d\n", User.getName(), User.getFeeling());
                System.out.println("========================================================================");

                // 유저 상태 체크
                if(User.getFeeling()==0)            // 인내력이 이 0이 된다면
                {
                    Ending ending = new Ending();   // 엔딩 객체 생성
                    ending.toQuitEnding();          // 자발적으로 관두는 엔딩 메소드 호출
                }
            }
        }

        return true;
    }

}
