package com.company.action;

import com.company.data.Beverage;
import com.company.data.Cafe;
import com.company.data.User;
import com.company.run.Ending;
import java.util.Random;

// 게임에 등장하는 손님의 가장 기본이 되는 기능을 담은 클래스.
public class CustomerAction
{
    // 일반손님 등장 메소드
    public void comeCustomer()
    {
        Cafe.setTodayCustomerNum(Cafe.getTodayCustomerNum() + 1); // 기존의 하루 방문자 수에 한명 더하기
        Cafe.setTotalCustomerNum(Cafe.getTotalCustomerNum() + 1); // 기존의 총 방문자 수에 한명 더하기
        Cafe.setWeekCustomerNum(Cafe.getWeekCustomerNum() + 1); // 기존의 주 방문자 수에 한명 더하기

        System.out.println();

        Beverage beverage = orderBeverage();             // 주문할 음료 객체 생성
        boolean orderResult = orderToPartimer(beverage); // 손님이 음료 주문 - 확정된 경우 true 반환

        if (orderResult) // 음료주문이 확정된 경우
        {
            UserAction userAction = new UserAction();           // 유저 액션 객체 생성
            boolean result = userAction.makeBeverage(beverage); // 음료 만들기 수행하고 결과를 반환한다. 성공 시 true, 실패시 false 반환
            userAction.makeBeverageResult(result);              // 결과에 따른 출력

            // 여기서 실패, 성공횟수 더하기
            if (result)                                          // 음료만들기 성공한경우
            {
                User.setTotalSuccessNum(User.getTotalSuccessNum() + 1); // 총 음료 제조 성공 횟수 1 증가
                User.setWeekSuccessNum(User.getWeekSuccessNum() + 1);   // 이번주 음료제조 성공횟수 1 증가
            } else                                                // 음료만들기 실패한 경우
            {
                User.setTotalFailNum(User.getTotalFailNum() + 1); // 총 음료제조 실패 횟수 1 증가
                User.setWeekFailNum(User.getWeekFailNum() + 1);   // 이번주 음료제조 실패 횟수 1 증가
            }

        }

        Ending ending = new Ending();                        // 엔딩 객체 생성
        if (User.getHp() == 0)                                  // 만약 유저의 체력이 0이 된다면
        {
            //test
            //System.out.println(User.getHp());
            ending.fallDownEnding();                         // 과로 엔딩 메소드 호출
        } else if (User.getTotalFailNum() / User.getSkillLevel() < User.getWeekFailNum())// 총 음료 제조 횟수/숙련도 < 이번 주 실패 횟수라면
        {
            ending.getFireEnding();                         // 해고 엔딩 실행
        }

    }

    // 테이크아웃 여부 정하는 메소드 : 테이크아웃하면 true 반환, 테이크아웃 하지 않으면 false 반환
    public boolean checkTakeout()
    {
        Random rd = new Random();               // 랜덤 객체 생성
        int takeout = rd.nextInt(1);      // 0, 1의 랜덤값을 변수 takeout 에 저장.

        //테이크 아웃 여부 확인
        if(takeout == 1)                         // 랜덤값이 1이면
        {
            return false;                        // 테이크아웃 하지 않는다.(false 반환)
        }

        return true;                             // 랜덤값이 0이면 테이크아웃한다.(true 반환)

    } // end checkTakeout()

    // 랜덤으로 음료 생성하는 랜덤
    public Beverage orderBeverage()
    {
        Random rd = new Random();                 // 랜덤 클래스 객체 생성

        // Ice or Hot 랜덤 선택
        int iceOption = rd.nextInt(2);      // 0 또는 1의 랜덤값을 변수 iceOption 에 저장한다.

        // 휘핑크림 유무 랜덤 선택
        int whippingCream = rd.nextInt(2);  // 0 또는 1의 랜덤값을 변수 whippingCream 에 저장한다.

        // 음료 선택
        int beverageSel = rd.nextInt(5)+1;   // 1 ~ 5 의 랜덤값(음료 종류)을 변수 beverageSel 에 저장한다.

        final int AMERICANO = 1;     // 아메리카노
        final int CAFE_LATTE = 2;    // 카페라떼
        final int VANILLA_LATTE = 3; // 바닐라라떼
        final int HAZEL_LATTE = 4;   // 헤이즐넛라떼
        final int CAFE_MOCHA = 5;    // 카페모카

        String name=""; // 음료 이름
        int makeLevel = 0;  // 음료 제조 난이도
        boolean isMilk = true;   // 우유들어가는지 여부

        switch (beverageSel)
        {
            case AMERICANO:
                name = "아메리카노";
                makeLevel = 1;
                isMilk = false;
                break;

            case CAFE_LATTE:
                name = "카페라떼";
                makeLevel = 2;
                isMilk = true;
                break;
            case VANILLA_LATTE:
                name = "바닐라라떼";
                makeLevel = 3;
                isMilk = true;
                break;
            case HAZEL_LATTE:
                name = "헤이즐넛 라떼";
                makeLevel = 4;
                isMilk = true;
                break;
            case CAFE_MOCHA:
                name = "카페모카";
                makeLevel = 5;
                isMilk = true;
                break;

        }
        // 랜덤으로 선택한 값들을 매개변수로 넘기며 음료 객체 생성하는 메소드 호출
        Beverage beverage = new  Beverage(iceOption,isMilk,whippingCream,makeLevel,name);

        return beverage;  // 음료 객체 반환

    }// end orderBeverage()

    // 손님이 음료를 주문하는 메소드 :  음료를 주문하는 경우 true, 주문하지 않는 경우 false 반환
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
            if(Cafe.getChairNum()==0)    // 매장에 자리가 없으면
            {
                System.out.println("========================================================================");
                System.out.println(" 매장에 자리가 없어서 손님이 나갔습니다. ");
                System.out.println("========================================================================");

                return false;                   // false 반환, 메소드 종료
            }
            else                                // 매장에 자리가 있으면
            {
                Cafe.setChairNum(Cafe.getChairNum()-1);// 매장 자리를 하나 줄인다.
            }

            // 유리잔 또는 머그잔 감소시키기.
            if(beverage.getIceOption()==0 && Cafe.getMugNum() !=0 ) // 뜨거운 음료이고 머그잔이 있으면
            {
                Cafe.setMugNum(Cafe.getMugNum() - 1); // 머그잔 1 감소
            }
            else if(beverage.getIceOption()==1 && Cafe.getCupNum() != 0) // 차가운 음료이고 유리잔이 있으면
            {
                Cafe.setCupNum(Cafe.getCupNum() - 1); // 유리잔 1 감소
            }
            else    // 뜨거운 음료인데 머그잔이 없거나 차가운 음료인데 유리잔이 없으면 컴플레인 발생, 유저 인내력 1 감소
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
