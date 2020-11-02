package com.company.action;

import com.company.data.Beverage;
import com.company.data.Cafe;
import com.company.data.User;


// CustomerAction <- 상속 -  SpecialCustomerAction <- 상속 - SecretCustomer
// 비밀손님은 특별 손님과 달리 유저의 체력이나 인내력이 소모되지 않는다.
public class SecretCustomerAction extends SpecialCustomerAction
{
    private static int secretCustomerCnt; // 등장횟수 누적해서 담는 변수

    @Override
    // 음료를 주문하는 경우 true, 주문하지 않는 경우 false 반환
    public boolean orderTalkDown(Beverage beverage)
    {
        String iceOption;       // 아이스 옵션 대사 담을 변수
        String whippingCream;   // 휘핑크림 대사 담을 변수
        String takeout;         // 테이크아웃 대사 담을 변수

        SecretCustomerAction.secretCustomerCnt += 1; // 비밀손님 등장횟수 1 증가

        // ICE / HOT 선택값에 따라 대사 분기
        if(beverage.getIceOption()==0)  // HOT 이라면
        {
            iceOption = " 뜨거운걸로.";
        }
        else                            // ICE라면
        {
            iceOption = " 차가운걸로. ";
        }

        // 휘핑크림 선택값에 따라 대사 분기
        if(beverage.getWhippingCream()==0)  // 휘핑크림 선택하지 않았다면
        {
            whippingCream = "";
        }
        else                                // 휘핑크림 선택했다면
        {
            whippingCream = " 휘핑크림.";
        }

        // 테이크아웃 선택 값에 따라 대사 분기
        boolean checkTakeout = checkTakeout(); // checkTakeout() 는 테이크아웃하면 true 반환

        if(checkTakeout)                       // 테이크아웃 한다면
        {
            takeout = " 테이크아웃.";
        }
        else                                    // 테이크아웃 하지 않는다면
        {
            takeout = "";
        }

        System.out.println(" 손님 : " + iceOption + beverage.getName()+".");
        System.out.println("       " + whippingCream + takeout );

        System.out.println("========================================================================");
        System.out.println(" 손님이 반말로 주문하였습니다. ");
        System.out.println("========================================================================");


        if(!checkTakeout) // 테이크아웃 하지 않는다면
        {
            // 매장에 자리가 있는지 확인
            if(Cafe.getChair()==0)    // 매장에 자리가 없으면 손님이 나간다.
            {
                System.out.println("========================================================================");
                System.out.println(" 매장에 자리가 없어서 손님이 나갔습니다. ");
                System.out.println("========================================================================");
                return false;       // false 반환, 메소드 종료
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
            else    // 뜨거운 음료인데 머그잔이 없거나 차가운 음료인데 유리잔이 없는 경우
            {
                System.out.println("========================================================================");
                System.out.println(" 매장에 잔이 모자라 일회용 컵을 사용했습니다.");
                System.out.println("========================================================================");
            }
        }

        return true;
    }

    @Override
    // 음료를 주문하는 경우 true, 주문하지 않는 경우 false 반환
    public boolean orderFight(Beverage beverage)
    {
        String iceOption;       // 아이스 옵션 대사 담을 변수
        String whippingCream;   // 휘핑크림 대사 담을 변수
        String takeout;         // 테이크아웃 대사 담을 변수

        SecretCustomerAction.secretCustomerCnt += 1; // 등장횟수 1 증가

        // ICE / HOT 선택값에 따라 대사 분기
        if(beverage.getIceOption()==0)  // HOT 이라면
        {
            iceOption = "이 날씨에 차가운걸 먹겠어요?";
        }
        else                            // ICE 라면
        {
            iceOption = "이 날씨에 뜨거운걸 먹겠어요? ";
        }

        // 휘핑 선택값에 따라 대사 분기
        if(beverage.getWhippingCream()==0) // 휘핑크림 올린다면
        {
            whippingCream = "누가 여기에 휘핑을 올려요?";
        }
        else                                // 휘핑크림 올리지 않는다면
        {
            whippingCream = "당연히 올리죠.";
        }

        // 테이크아웃 선택 값에 따라 대사 분기
        boolean checkTakeout = checkTakeout(); // checkTakeout() 는 테이크아웃하면 true 반환

        if(checkTakeout)                        // 테이크아웃한다면
        {
            takeout = "테이크아웃이요.";
        }
        else                                    // 테이크아웃 안한다면
        {
            takeout = "먹고 갈거에요.";
        }

        System.out.println(" 손님 : " + beverage.getName());
        System.out.println();
        System.out.println("         .");
        System.out.println("         .");
        System.out.println("         .");
        System.out.println();
        System.out.printf(" %s님은 ICE/HOT 옵션을 물어봤습니다.\n", User.getName());
        System.out.println();
        System.out.println(" 손님 : " + iceOption);
        System.out.println();
        System.out.printf(" %s님은 휘핑크림을 추가하는지 물어봤습니다.\n", User.getName());
        System.out.println();
        System.out.println(" 손님 : " + whippingCream);
        System.out.println();
        System.out.printf(" %s님은 테이크아웃 여부를 물어봤습니다.\n", User.getName());
        System.out.println();
        System.out.println(" 손님 : " + takeout);
        System.out.println();

        System.out.println("========================================================================");
        System.out.println(" 손님이 짜증을 내며 주문했습니다. ");
        System.out.println("========================================================================");


        if(!checkTakeout) // 매장에서 먹고 간다면
        {
            // 매장에 자리가 있는지 확인
            if(Cafe.getChair()==0)    // 매장에 자리가 없으면 손님이 나간다.
            {
                System.out.println("========================================================================");
                System.out.println(" 매장에 자리가 없어서 손님이 나갔습니다. ");
                System.out.println("========================================================================");
                return false;       // false 반환, 메소드 종료
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
            else    // 뜨거운 음료인데 머그잔이 없거나 차가운 음료인데 유리잔이 없는 경우
            {
                System.out.println("========================================================================");
                System.out.println(" 매장에 잔이 모자라 일회용 컵을 사용했습니다.");
                System.out.println("========================================================================");
            }
        }

        return true;
    }

    @Override
    // 음료를 주문하는 경우 true, 주문하지 않는 경우 false 반환
    public boolean orderToPartimer(Beverage beverage)
    {
        String iceOption;       // 아이스 옵션 대사 담을 변수
        String whippingCream;   // 휘핑크림 대사 담을 변수
        String takeout;         // 테이크아웃 대사 담을 변수

        SecretCustomerAction.secretCustomerCnt += 1; // 비밀손님 등장횟수 1 증가

        // ICE / HOT 선택값에 따라 대사 분기할 수 있도록 변수에 담기
        if(beverage.getIceOption()==0)      // HOT 이라면
        {
            iceOption = "뜨거운 ";
        }
        else                                // ICE 라면
        {
            iceOption = "차가운 ";
        }

        // 휘핑 선택
        if(beverage.getWhippingCream()==0) // 휘핑크림 올린다면
        {
            whippingCream = "";
        }
        else                               // 휘핑크림 올리지 않는다면
        {
            whippingCream = "휘핑크림 추가할게요.";
        }

        // 테이크아웃
        boolean checkTakeout = checkTakeout(); // checkTakeout() 는 테이크아웃하면 true 반환

        if(checkTakeout)                        // 테이크아웃 한다면
        {
            takeout = " 가지고 갈거에요.";
        }
        else                                    // 테이크아웃 안한다면
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
                return false;       // false 반환, 메소드 종료
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
            else    // 뜨거운 음료인데 머그잔이 없거나 차가운 음료인데 유리잔이 없으면
            {
                System.out.println("========================================================================");
                System.out.println(" 매장에 잔이 모자라 일회용 컵을 사용했습니다.  ");
                System.out.println("========================================================================");

            }
        }

        return true;
    }

    // 외부에서 속성에 접근할 수 있도록 getter/setter 생성
    public static int getSecretCustomerCnt()
    {
        return secretCustomerCnt;
    }

}
