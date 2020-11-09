package com.company.action;

import com.company.data.Beverage;
import com.company.data.Cafe;
import com.company.data.User;
import com.company.run.Ending;

import java.util.Random;


// CustomerAction <- 상속 -  SpecialCustomerAction <- 상속 - SecretCustomer
// 비밀손님은 특별 손님과 달리 유저의 체력이나 인내력이 소모되지 않는다.
public class SecretCustomerAction extends SpecialCustomerAction
{
    private static int secretCustomerCnt; // 등장횟수 누적해서 담는 변수

    // 비밀 손님 등장 메소드
    public void comeSecretCustomer()
    {
        final int COMMON = 1;           // 일반 손님 유형
        final int TALK_DOWN = 2;        // 반말하는 유형
        final int FIGHT = 3;            // 시비거는 유형

        Cafe.setTodayCustomerNum(Cafe.getTodayCustomerNum() + 1); // 기존의 하루 방문자 수에 하나 더하기
        Cafe.setTotalCustomerNum(Cafe.getTotalCustomerNum() + 1); // 기존의 총 방문자 수에 한명 더하기
        Cafe.setWeekCustomerNum(Cafe.getWeekCustomerNum() + 1); // 기존의 주 방문자 수에 한명 더하기

        SecretCustomerAction secretCustomer = new SecretCustomerAction();  // 비밀 손님 객체 생성
        Beverage beverage = secretCustomer.orderBeverage();    // 주문할 음료 객체 생성

        System.out.println();

        // 음료 주문 유형 랜덤으로 실행하기
        Random rd = new Random();
        int typeNum = rd.nextInt(3) + 1; //1~3 랜덤값 반환해서 typeNum 변수에 저장

        // 랜덤값에 따라 유형 별 손님이 음료 주문 -  음료를 주문한 경우 true 반환
        boolean orderResult = true;
        switch (typeNum)
        {
            case COMMON:
                orderResult = secretCustomer.orderToPartimer(beverage);   // 일반 손님
                break;

            case TALK_DOWN:
                orderResult = secretCustomer.orderTalkDown(beverage);    // 반말하는 손님
                break;

            case FIGHT:
                orderResult = secretCustomer.orderFight(beverage);       // 시비거는 손님
                break;
        }

        if (orderResult)                                         // 주문이 확정된 경우
        {
            // 유저가 음료 만들기
            UserAction userAction = new UserAction();           // 유저 액션 객체 생성
            boolean result = userAction.makeBeverage(beverage); // 음료 만들기 수행하고 결과를 반환한다.
            userAction.makeBeverageResult(result);              // 결과에 따른 출력




            // 여기서 실패, 성공횟수 더하기
            if (result)                                          // 음료만들기 성공한경우
            {
                User.setTotalSuccessNum(User.getTotalSuccessNum() + 1); // 총 음료 제조 성공 횟수 1 증가
                User.setWeekSuccessNum(User.getWeekSuccessNum() + 1);   // 이번주 음료제조 성공횟수 1 증가
                giveTips(tip);                                          // 팁 주기
            } else
            {
                User.setTotalFailNum(User.getTotalFailNum() + 1); // 총 음료제조 실패 횟수 1 증가
                User.setWeekFailNum(User.getWeekFailNum() + 1);   // 이번주 음료제조 실패 횟수 1 증가
            }
        }

        // 엔딩 주석 처리
        Ending ending = new Ending();       // 엔딩 객체 생성
        if (User.getHp() == 0)             // 만약 유저의 체력이 0이 된다면
        {
            ending.fallDownEnding();        //  과로 엔딩 실행
        } else if (User.getFeeling() == 0) // 만약 유저의 인내력이 0이 된다면
        {
            ending.toQuitEnding();          // 퇴사 엔딩 실행
        } else if(User.getTotalFailNum()+User.getTotalSuccessNum()/User.getSkillLevel() < User.getWeekFailNum())
        // 총 음료제조 실패횟수/숙련도 < 이번 주 실패횟수
        {
            ending.getFireEnding();         // 해고 엔딩 실행
        }


    }

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

        // 손님 대사 종합
        String str = " 손님 : " + iceOption + beverage.getName() + ".\n       " + whippingCream + takeout+"\n";
        String[] strArr = str.split("");

        try
        {
            // 종합한 손님 대사를 한 글자씩 지연 효과를 줘서 출력
            for (int i = 0; i < strArr.length; i++)
            {
                System.out.printf(strArr[i]);
                Thread.sleep(50);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }

        System.out.println("========================================================================");
        System.out.println(" 손님이 반말로 주문하였습니다. ");
        System.out.println("========================================================================");


        if(!checkTakeout) // 테이크아웃 하지 않는다면
        {
            // 매장에 자리가 있는지 확인
            if(Cafe.getChairNum()==0)    // 매장에 자리가 없으면 손님이 나간다.
            {
                System.out.println("========================================================================");
                System.out.println(" 매장에 자리가 없어서 손님이 나갔습니다. ");
                System.out.println("========================================================================");
                return false;       // false 반환, 메소드 종료
            }
            else
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

        try{

            System.out.println(" 손님 : " + beverage.getName());
            Thread.sleep(200);
            System.out.println();
            Thread.sleep(200);
            System.out.println("         .");
            Thread.sleep(200);
            System.out.println("         .");
            Thread.sleep(200);
            System.out.println("         .");
            Thread.sleep(200);
            System.out.println();
            Thread.sleep(200);
            System.out.printf(" %s님은 ICE/HOT 옵션을 물어봤습니다.\n", User.getName());
            Thread.sleep(200);
            System.out.println();
            Thread.sleep(300);
            System.out.println(" 손님 : " + iceOption);
            Thread.sleep(200);
            System.out.println();
            Thread.sleep(200);
            System.out.printf(" %s님은 휘핑크림을 추가하는지 물어봤습니다.\n", User.getName());
            Thread.sleep(200);
            System.out.println();
            Thread.sleep(300);
            System.out.println(" 손님 : " + whippingCream);
            Thread.sleep(200);
            System.out.println();
            Thread.sleep(200);
            System.out.printf(" %s님은 테이크아웃 여부를 물어봤습니다.\n", User.getName());
            Thread.sleep(200);
            System.out.println();
            Thread.sleep(300);
            System.out.println(" 손님 : " + takeout);
            Thread.sleep(200);
            System.out.println();
            Thread.sleep(200);

        }catch (Exception e)
        {
            System.out.println(e.toString());
        }


        System.out.println("========================================================================");
        System.out.println(" 손님이 짜증을 내며 주문했습니다. ");
        System.out.println("========================================================================");


        if(!checkTakeout) // 매장에서 먹고 간다면
        {
            // 매장에 자리가 있는지 확인
            if(Cafe.getChairNum()==0)    // 매장에 자리가 없으면 손님이 나간다.
            {
                System.out.println("========================================================================");
                System.out.println(" 매장에 자리가 없어서 손님이 나갔습니다. ");
                System.out.println("========================================================================");
                return false;       // false 반환, 메소드 종료
            }
            else
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

        // 손님 대사 종합
        String str = " 손님 : " + iceOption + beverage.getName() + " 주세요. \n       " + whippingCream + takeout+"\n";
        String[] strArr = str.split("");

        try
        {
            // 종합한 손님 대사를 한 글자씩 지연 효과를 줘서 출력
            for (int i = 0; i < strArr.length; i++)
            {
                System.out.printf(strArr[i]);
                Thread.sleep(50);
            }
        }
        catch (Exception e){}


        if(!checkTakeout) // 매장에서 먹고 간다면
        {
            // 매장에 자리가 있는지 확인
            if(Cafe.getChairNum()==0)    // 매장에 자리가 없으면 손님이 나간다.
            {
                System.out.println("========================================================================");
                System.out.println(" 매장에 자리가 없어서 손님이 나갔습니다. ");
                System.out.println("========================================================================");
                return false;       // false 반환, 메소드 종료
            }
            else
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

    public static void setSecretCustomerCnt(int secretCustomerCnt)
    {
        SecretCustomerAction.secretCustomerCnt = secretCustomerCnt;
    }
}
