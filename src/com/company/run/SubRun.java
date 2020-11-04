package com.company.run;
import java.util.Random;
import java.util.Scanner;

import com.company.action.*;
import com.company.data.*;

// 게임의 메인 흐름(게임시작, 평일, 주말) 이외의 흐름을 담은 클래스
public class SubRun
{
    // 손님 등장 메소드-------------------------------------------------------------------------------------------------------

    // 일반손님 등장 메소드
    public void comeCustomer()
    {
        Cafe.setTodayCustomerNum(Cafe.getTodayCustomerNum()+1); // 기존의 하루 방문자 수에 한명 더하기
        Cafe.setTotalCustomerNum(Cafe.getTotalCustomerNum()+1); // 기존의 총 방문자 수에 한명 더하기
        Cafe.setWeekCustomerNum(Cafe.getWeekCustomerNum() + 1); // 기존의 주 방문자 수에 한명 더하기

        System.out.println();

        CustomerAction customerAction = new CustomerAction();           // 손님 객체 생성

        Beverage beverage = customerAction.orderBeverage();             // 주문할 음료 객체 생성
        boolean orderResult = customerAction.orderToPartimer(beverage); // 손님이 음료 주문 - 확정된 경우 true 반환

        if(orderResult) // 음료주문이 확정된 경우
        {
            UserAction userAction = new UserAction();           // 유저 액션 객체 생성
            boolean result = userAction.makeBeverage(beverage); // 음료 만들기 수행하고 결과를 반환한다. 성공 시 true, 실패시 false 반환
            userAction.makeBeverageResult(result);              // 결과에 따른 출력

            // 여기서 실패, 성공횟수 더하기
            if(result)                                          // 음료만들기 성공한경우
            {
                User.setTotalSuccessNum(User.getTotalSuccessNum() + 1 ); // 총 음료 제조 성공 횟수 1 증가
                User.setWeekSuccessNum(User.getWeekSuccessNum() + 1);    // 이번주 음료제조 성공횟수 1 증가
            }
            else                                                // 음료만들기 실패한 경우
            {
                User.setTotalFailNum(User.getTotalFailNum() + 1); // 총 음료제조 실패 횟수 1 증가
                User.setWeekFailNum(User.getWeekFailNum() + 1);   // 이번주 음료제조 실패 횟수 1 증가
            }

        }

        Ending ending = new Ending();                        // 엔딩 객체 생성
        if(User.getHp()==0)                                  // 만약 유저의 체력이 0이 된다면
        {
            //test
            //System.out.println(User.getHp());
            ending.fallDownEnding();                         // 과로 엔딩 메소드 호출
        }
        else if(User.getTotalFailNum()/User.getSkillLevel() < User.getWeekFailNum() )// 총 음료 제조 횟수/숙련도 < 이번 주 실패 횟수라면
        {
            ending.getFireEnding();                         // 해고 엔딩 실행
        }

    }

    // 특별 손님 등장 메소드
    public void comeSpecialCustomer()
    {
        final int TALK_DOWN = 1;        // 반말하는 유형
        final int FIGHT = 2;            // 시비거는 유형
        final int FALSE_RELIGION = 3;   // 사이비 유형
        final int WRONG = 4;            // 잘못 찾아온 유형
        final int PRESENT = 5;          // 선물주는 유형

        Cafe.setTodayCustomerNum(Cafe.getTodayCustomerNum()+1); // 기존의 하루 방문자 수에 하나 더하기
        Cafe.setTotalCustomerNum(Cafe.getTotalCustomerNum()+1); // 기존의 총 방문자 수에 한명 더하기
        Cafe.setWeekCustomerNum(Cafe.getWeekCustomerNum() + 1); // 기존의 주 방문자 수에 한명 더하기

        SpecialCustomerAction specialCustomer = new SpecialCustomerAction(); // 특별 손님 객체 생성
        Beverage beverage = specialCustomer.orderBeverage();                 // 주문할 음료 객체 생성

        System.out.println();

        // 음료 주문 유형 랜덤으로 실행하기
        Random rd = new Random();
        int typeNum = rd.nextInt(5)+1; //1~5 랜덤값 반환해서 typeNum 변수에 저장

        boolean orderResult = true;         // 주문이 확정되었는지의 여부를 저장하는 변수

        // 랜덤값에 따라 유형 별 손님이 음료 주문 -  음료를 주문하는 경우 true 반환, 주문하지 않는 경우 false 반환
        switch(typeNum)
        {
            case TALK_DOWN:
                orderResult = specialCustomer.orderTalkDown(beverage);      // 반말하는 손님
                break;

            case FIGHT:
                orderResult = specialCustomer.orderFight(beverage);         // 시비거는 손님
                break;

            case FALSE_RELIGION:
                orderResult = specialCustomer.orderFalseReligion();         // 사이비 손님
                break;

            case WRONG:
                orderResult = specialCustomer.orderWrong();                 // 잘못찾아온 손님
                break;

            case PRESENT:
                orderResult = specialCustomer.orderPresent();               // 선물주는 손님
                break;

        }


        Ending ending = new Ending();       // 엔딩 객체 생성
        if(User.getHp()==0)                 // 만약 유저의 체력이 0이 된다면
        {
            ending.fallDownEnding();        //  과로 엔딩 메소드 호출
        }
        else if(User.getFeeling() == 0)     // 만약 유저의 인내력이 0이 된다면
        {
            ending.toQuitEnding();          // 퇴사 엔딩 메소드 호출
        }

        if(orderResult)     // 주문이 확정된 경우
        {
            // 유저가 음료 만들기
            UserAction userAction = new UserAction();           // 유저 액션 객체 생성
            boolean result = userAction.makeBeverage(beverage); // 음료 만들기 수행하고 결과를 반환한다.
            userAction.makeBeverageResult(result);              // 결과에 따른 출력

            // 여기서 실패, 성공횟수 더하기
            if(result)                                          // 음료만들기 성공한경우
            {
                User.setTotalSuccessNum(User.getTotalSuccessNum() + 1 ); // 총 음료 제조 성공 횟수 1 증가
                User.setWeekSuccessNum(User.getWeekSuccessNum() + 1);    // 이번주 음료제조 성공횟수 1 증가
            }
            else
            {
                User.setTotalFailNum(User.getTotalFailNum() + 1); // 총 음료제조 실패 횟수 1 증가
                User.setWeekFailNum(User.getWeekFailNum() + 1);   // 이번주 음료제조 실패 횟수 1 증가
            }
        }


        if(User.getHp()==0)                 // 만약 유저의 체력이 0이 된다면
        {
            //test
            //System.out.println(User.getHp());
            ending.fallDownEnding();        //  과로 엔딩 메소드 호출
        }
        else if(User.getFeeling() == 0)     // 만약 유저의 인내력이 0이 된다면
        {
            ending.toQuitEnding();          // 퇴사 엔딩 메소드 호출
        }
        else if(User.getTotalFailNum()/User.getSkillLevel() < User.getWeekFailNum() ) // 총 음료 제조 횟수/숙련도 < 이번 주 실패 횟수
        {
            ending.getFireEnding();         // 해고 엔딩 메소드 호출
        }

    }

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
                User.setWeekSuccessNum(User.getWeekSuccessNum() + 1);    // 이번주 음료제조 성공횟수 1 증가
            } else
            {
                User.setTotalFailNum(User.getTotalFailNum() + 1); // 총 음료제조 실패 횟수 1 증가
                User.setWeekFailNum(User.getWeekFailNum() + 1);   // 이번주 음료제조 실패 횟수 1 증가
            }
        }

        Ending ending = new Ending();       // 엔딩 객체 생성
        if (User.getHp() == 0)             // 만약 유저의 체력이 0이 된다면
        {
            ending.fallDownEnding();        //  과로 엔딩 실행
        } else if (User.getFeeling() == 0) // 만약 유저의 인내력이 0이 된다면
        {
            ending.toQuitEnding();          // 퇴사 엔딩 실행
        } else if (User.getTotalFailNum() / User.getSkillLevel() < User.getWeekFailNum())
        // 총 음료제조 실패횟수/숙련도 < 이번 주 실패횟수
        {
            ending.getFireEnding();         // 해고 엔딩 실행
        }


    }

// 주말 정보확인 메소드 ---------------------------------------------------------------------------------------------------

    // 정보 확인 메소드 1.내 정보 확인 2.카페 정보 확인
    public void info()
    {
        boolean check = true;   // 반복여부 체크하는 변수
        String resultStr;       // 사용자의 선택값을 담을 변수(1. 정보 확인  2.상점가기 3.모은 엔딩 확인)
        int result = 0;         // resultStr를 int 로 변환해 사용자의 선택값을 담을 변수

        final int MY_INFO = 1;
        final int CAFE_INFO = 2;
        final int EXIT = 3;

        while(check)
        {
            System.out.println("========================================================================");
            System.out.printf(" 1. %s님의 정보 보기  2.카페 정보 보기  3.이전으로 \n", User.getName());
            System.out.println("------------------------------------------------------------------------");
            System.out.print(" 선택 : ");
            Scanner sc = new Scanner(System.in);
            resultStr = sc.nextLine();

            // 입력받은 값이 숫자인지 확인
            try
            {
                // 자료형 변경한 뒤(String → int) int형에 담는다.
                result = Integer.parseInt(resultStr);
                check = false;
                // int 형으로 변경되면 check 에 false 담아서 반복문 빠져나간다.
                // int형으로 변경되지 않는다면 NumberFormatException 발생
            }
            catch (NumberFormatException e) // NumberFormatException 발생한다면
            {
                check = true;   // check 에 true 담아서 다시 반복
                // result = 0; 으로 초기화된 상태이므로  하단 if문 내부까지 실행하고 반복된다.
            }

            if(result < 1 || result > 3 )// 주어진 값 이외의 수를 선택한 경우
            {
                System.out.println("========================================================================");
                System.out.println(" 올바른 값을 입력해주세요.");
                check = true;
            }

        }

        InfoAction infoAction = new InfoAction();   // 정보 기능 객체 생성

        switch(result)
        {
            case  MY_INFO: infoAction.myInfo();     // 내 정보 확인
                break;

            case  CAFE_INFO: infoAction.cafeInfo(); // 카페 정보 확인
                break;

            case EXIT:
                GameRun gameRun = new GameRun();    // 카페 실행 객체 생성
                gameRun.weekend();                  // 주말 초기화면 호출
                break;
        }

    }


// 주말 상점 메소드----------------------------------------------------------------------------------------------------------

    public void goShop()   // 아이템 구입하기
    {
        System.out.println("                         ╔═══━━━─────────━━━═══╗                         ");
        System.out.println("==========================     아이템  구매      ==========================");
        System.out.println("                         ╚═══━━━─────────━━━═══╝                         ");
        System.out.println();
        System.out.printf(" 현재 %s님이 보유하고 있는 코인 : %d코인\n", User.getName(), User.getProperty());
        boolean check = true;   // 반복여부 체크하는 변수
        String resultStr;       // 사용자의 선택값을 담을 변수(1. 정보 확인  2.상점가기 3.모은 엔딩 확인)
        int result = 0;         // resultStr를 int 로 변환해 사용자의 선택값을 담을 변수

        final int PERMANENT_ITEM = 1;
        final int CONSUMABLE_ITEM = 2;
        final int EXIT = 3;

        while(check)
        {
            System.out.println("========================================================================");
            System.out.println(" 1.영구 아이템  2.소모 아이템  3.이전 화면 ");
            System.out.println("------------------------------------------------------------------------");
            System.out.print(" 선택 : ");
            Scanner sc = new Scanner(System.in);
            resultStr = sc.nextLine();

            // 입력받은 값이 숫자인지 확인
            try
            {
                // 자료형 변경한 뒤(String → int) int형에 담는다.
                result = Integer.parseInt(resultStr);
                check = false;
                // int 형으로 변경되면 check 에 false 담아서 반복문 빠져나간다.
                // int형으로 변경되지 않는다면 NumberFormatException 발생
            }
            catch (NumberFormatException e) // NumberFormatException 발생한다면
            {
                check = true;   // check 에 true 담아서 다시 반복
                // result = 0; 으로 초기화된 상태이므로  하단 if문 내부까지 실행하고 반복된다.
            }

            if(result < 1 || result > 3 )// 주어진 값 이외의 수를 선택한 경우
            {
                System.out.println("========================================================================");
                System.out.println(" 올바른 값을 입력해주세요.");
                check = true;
            }

        }

        switch(result)
        {
            case  PERMANENT_ITEM: buyPermanentItem();   //  영구 아이템 구입
                break;

            case  CONSUMABLE_ITEM: buyConsumableItem(); // 소모 아이템 구입
                break;

            case EXIT:
                GameRun gameRun = new GameRun();
                gameRun.weekend();   // 상점 초기화면 호출
                break;
        }

    }

// 영구 아이템 구매 메소드 ------------------------------------------------------------------------------------------------

    public void buyPermanentItem()
    {
        boolean check = true;   // 반복여부 체크하는 변수
        String resultStr;       // 사용자의 선택값을 담을 변수
        int result = 0;         // resultStr를 int 로 변환해 사용자의 선택값을 담을 변수

        final int CHAIR = 1;    // 의자 구매
        final int CUP   = 2;    // 유리잔 구매
        final int MUG   = 3;    // 머그잔 구매
        final int HP    = 4;    // 체력 늘리기
        final int FEELING = 5;  // 인내력 늘리기
        final int EXIT = 6;

        Item item = new Item(); // 아이템 객체 생성

        while(check)
        {
            System.out.println("                         ╔═══━━━─────────━━━═══╗                         ");
            System.out.println("==========================    영구 아이템 구매    ==========================");
            System.out.println("                         ╚═══━━━─────────━━━═══╝                         ");
            System.out.println();
            System.out.println("                             ✨ 현재 보유 정보 ✨");
            System.out.println("------------------------------------------------------------------------");
            System.out.println();
            System.out.printf(" 의자         : %d개\n", Cafe.getSetChair());
            System.out.printf(" 유리잔       : %d개\n", Cafe.getSetCup());
            System.out.printf(" 머그잔       : %d개\n", Cafe.getSetMug());
            System.out.printf(" 체력 설정값   : %d\n", User.getSetHp());
            System.out.printf(" 인내력 설정값 : %d\n", User.getSetFeeling());
            System.out.println();
            System.out.println("------------------------------------------------------------------------");
            System.out.println();
            System.out.println(" 1.의자 구매         (- 2코인)");
            System.out.println(" 2.유리잔 구매       (- 2코인)");
            System.out.println(" 3.머그잔 구매       (- 2코인)");
            System.out.println(" 4.체력 설정값 +2    (- 4코인)");
            System.out.println(" 5.인내력 설정값 +2  (- 4코인)");
            System.out.println(" 6.이전으로");
            System.out.println();
            System.out.println("========================================================================");
            Scanner sc = new Scanner(System.in);
            System.out.print(" 선택 : ");
            resultStr = sc.nextLine();

            // 입력받은 값이 숫자인지 확인
            try
            {
              // 자료형 변경한 뒤(String → int) int형에 담는다.
              result = Integer.parseInt(resultStr);
              check = false;
              // int 형으로 변경되면 check 에 false 담아서 반복문 빠져나간다.
              // int형으로 변경되지 않는다면 NumberFormatException 발생
            }
            catch (NumberFormatException e) // NumberFormatException 발생한다면
            {
              check = true;   // check 에 true 담아서 다시 반복
              // result = 0; 으로 초기화된 상태이므로  하단 if문 내부까지 실행하고 반복된다.
            }

            if(result < 1 || result > 6 )// 주어진 값 이외의 수를 선택한 경우
            {
              System.out.println("========================================================================");
              System.out.println(" 올바른 값을 입력해주세요.");
              check = true;
            }
        }

        ItemAction itemAction = new ItemAction();   // 아이템 관련 기능 객체 생성
        
        switch(result)                          // 사용자의 선택 값에 따라서
        {
            case CHAIR:
                NewItem chair = new NewItem("의자",2,1);
                itemAction.buyItem(chair);
                //itemAction.buyChair(); // 의자 구매
                break;

            case CUP:
                NewItem cup = new NewItem("유리잔",2,1);
                itemAction.buyItem(cup);
                //itemAction.buyCup();     // 유리잔 구매
                break;

            case MUG:
                NewItem mug = new NewItem("머그잔",2,1);
                itemAction.buyItem(mug);
                //itemAction.buyMug();     // 머그잔 구매

                break;

            case HP:
                NewItem hp = new NewItem("체력",4,1);
                itemAction.buyItem(hp);
                //itemAction.buyHp();       // 체력 증가

                break;

            case FEELING:
                NewItem feeling = new NewItem("인내력",4,1);
                itemAction.buyItem(feeling);
                //itemAction.buyFeeling(); // 인내력 증가

                break;

            case EXIT : goShop();   // 이전으로
                break;

        }

    }// end buyPermanentItem


// 소모 아이템 구매 메소드 ------------------------------------------------------------------------------------------------
    public void buyConsumableItem()
    {
        boolean check = true;   // 반복여부 체크하는 변수
        String resultStr;       // 사용자의 선택값을 담을 변수
        int result = 0;         // resultStr를 int 로 변환해 사용자의 선택값을 담을 변수

        Item item = new Item();// 아이템 객체 생성

        while (check)
        {
            System.out.println("                         ╔═══━━━─────────━━━═══╗                         ");
            System.out.println("==========================    소비 아이템 구매    ==========================");
            System.out.println("                         ╚═══━━━─────────━━━═══╝                         ");
            System.out.println();
            System.out.println("                             ✨ 현재 보유 정보 ✨");
            System.out.println();
            System.out.println("------------------------------------------------------------------------");
            System.out.println();
            System.out.printf(" 케이크   : %d개 ( 체력을 2 회복시킨다. )\n", User.getCakeNum());
            System.out.printf(" 샌드위치 : %d개 ( 체력을 4 회복시킨다. )\n", User.getSandwichNum());
            System.out.printf(" 초콜릿   : %d개 ( 인내력을 2 회복시킨다. )\n", User.getChocoNum());
            System.out.printf(" 마카롱   : %d개 ( 인내력을 4 회복시킨다. )\n", User.getMacaronNum());
            System.out.println();
            System.out.println("------------------------------------------------------------------------");
            System.out.println();
            System.out.println(" 1.케이크 구매         (- 3코인)");
            System.out.println(" 2.샌드위치 구매       (- 5코인)");
            System.out.println(" 3.초콜릿 구매         (- 3코인)");
            System.out.println(" 4.마카롱 구매         (- 5코인)");
            System.out.println(" 5.이전으로");
            System.out.println();
            System.out.println("========================================================================");
            Scanner sc = new Scanner(System.in);
            System.out.print(" 선택 : ");
            resultStr = sc.nextLine();

            // 입력받은 값이 숫자인지 확인
            try
            {
                // 자료형 변경한 뒤(String → int) int형에 담는다.
                result = Integer.parseInt(resultStr);
                check = false;
                // int 형으로 변경되면 check 에 false 담아서 반복문 빠져나간다.
                // int형으로 변경되지 않는다면 NumberFormatException 발생
            } catch (NumberFormatException e) // NumberFormatException 발생한다면
            {
                check = true;   // check 에 true 담아서 다시 반복
                // result = 0; 으로 초기화된 상태이므로  하단 if문 내부까지 실행하고 반복된다.
            }

            if (result < 1 || result > 6)// 주어진 값 이외의 수를 선택한 경우
            {
                System.out.println("========================================================================");
                System.out.println(" 올바른 값을 입력해주세요.");
                check = true;
            }
        }
    
        final int CAKE = 1;     // 체력 2 회복
        final int SANDWICH = 2; // 체력 4 회복
        final int CHOCO = 3;    // 인내력 2 회복
        final int MACARON = 4;  // 인내력 4 회복
        final int EXIT = 5;     // 이전으로

        ItemAction itemAction = new ItemAction();   // 아이템 기능 관련 객체 생성
        switch (result)                             // 사용자의 선택값에 따라
        {
            case CAKE:
                NewItem cake = new NewItem("케이크",3,2);
                itemAction.buyItem(cake);
                //itemAction.buyCake();                  // 케이크 구매
                break;

            case SANDWICH:
                NewItem sandwich = new NewItem("샌드위치",5,2);
                itemAction.buyItem(sandwich);
                //itemAction.buySandwich();           // 샌드위치 구매
                break;

            case CHOCO:
                NewItem choco = new NewItem("초콜릿",3,2);
                itemAction.buyItem(choco);
                //itemAction.buyChoco();                 // 초콜릿 구매
                break;

            case MACARON:
                NewItem macaron = new NewItem("마카롱",5,2);
                itemAction.buyItem(macaron);
                //itemAction.buyMacaron();             // 마카롱 구매
                break;

            case EXIT: goShop();   // 이전으로
                break;

        }
    }


// 공개된 엔딩 확인하기 ---------------------------------------------------------------------------------------------------

    public void openEndings()
    {
        int[] endings = User.getEndings();      // 공개된 엔딩 유형 저장한 배열 불러오기

        if(endings[0]==0)                       // 첫번째 배열 칸이 0 이면 공개된 엔딩이 없다는 뜻이다.
        {
            System.out.println("========================================================================");
            System.out.println(" 현재 공개된 엔딩이 없습니다.");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();


            GameRun gameRun = new GameRun();
            gameRun.initialRun(); // 이전으로
        }
        else    // 공개된 엔딩이 있으면
        {
            final int FALL_DOWN_ENDING = 1; // 과로 엔딩
            final int QUIT_ENDING = 2;      // 퇴사 엔딩
            final int SCOUT_ENDING = 3;     // 이직 엔딩
            final int BOSS_ENDING = 4;      // 사장 엔딩
            final int GET_FIRE_ENDING = 5;  // 해고 엔딩
            final int PARTIMER_ENDING = 6;  // 알바 엔딩

            System.out.println("                         ╔═══━━━─────────━━━═══╗                         ");
            System.out.println("=========================       공개된 엔딩       =========================");
            System.out.println("                         ╚═══━━━─────────━━━═══╝                         ");
            System.out.println();

            int cnt = 0;                    // 공개되지 않은 엔딩의 수를 세기 위한 변수

            // for(대입받을 변수 정의 : 배열)
            for (int endingType : endings)  // int[] endings 배열 각 칸의 값을 배열의 길이만큼 반복하며 int형 EndingType 에 담고 반복문 실행
            {
                if (endingType == 0) // 비어있는 칸이면
                {
                    cnt += 1;      // cnt 변수를 1씩 증가시킨다.
                }
            }

            // test
            //System.out.println(cnt);

            // test
            //for (int i = 0; i < endings.length; i++)
            //{
            // System.out.println(endings[i]);
            //}


            // for(대입받을 변수 정의 : 배열)
            for (int endingType : endings)
            {
                if (endingType == FALL_DOWN_ENDING)
                {
                    System.out.printf(" [과로 엔딩] %s님은 고된 노동에 시달리다 쓰러졌습니다. \n", User.getName());
                    System.out.println("------------------------------------------------------------------------");
                    System.out.println(" ✨ 과로 엔딩 tip ✨ ");
                    System.out.println("    체력이 0 이 되면 과로 엔딩의 조건이 달성됩니다. ");
                    System.out.println("    아이템을 적절히 이용해서 체력을 관리해주세요 ! ");
                    System.out.println("------------------------------------------------------------------------");
                }

                if (endingType == QUIT_ENDING)
                {
                    System.out.printf(" [사표 엔딩] %s님은 극심한 스트레스를 견디지 못해 카페를 떠났습니다. \n", User.getName());
                    System.out.println("------------------------------------------------------------------------");
                    System.out.println(" ✨ 사표 엔딩 tip ✨ ");
                    System.out.println("    인내력이 0 이 되면 사표 엔딩의 조건이 달성됩니다. ");
                    System.out.println("    아이템을 이용해서 인내력을 관리해주세요 ! ");
                    System.out.println("------------------------------------------------------------------------");
                }

                if (endingType == SCOUT_ENDING)
                {
                    System.out.println(" [이직 엔딩] 종종 방문하던 특이한 손님의 일부는 몰래 방문한 인근 카페 사장이었습니다.");
                    System.out.printf("             %s님을 시험하고 눈여겨본 사장은 %s님을 스카웃했습니다.\n", User.getName(), User.getName());
                    System.out.println("------------------------------------------------------------------------");
                    System.out.println(" ✨ 이직 엔딩 tip ✨ ");
                    System.out.println("    숙련도와 비밀 손님의 방문 횟수가 일정 기준 이상이면 이직 엔딩의 조건이 달성됩니다. ");
                    System.out.println("------------------------------------------------------------------------");
                }

                if (endingType == BOSS_ENDING)
                {
                    System.out.printf(" [사장 엔딩] 코인을 아끼며 열심히 일한 %s님은 모은 코인으로 카페를 차렸습니다.\n", User.getName());
                    System.out.printf("            %s님은 더이상 알바생이 아닙니다.\n", User.getName());
                    System.out.println("------------------------------------------------------------------------");
                    System.out.println(" ✨ 사장 엔딩 tip ✨ ");
                    System.out.println("    보유하고 있는 코인과 %s님의 숙련도, 방문한 손님 수가 일정 기준 이상이면 ");
                    System.out.println("    사장 엔딩의 조건이 달성됩니다.");
                    System.out.println("------------------------------------------------------------------------");
                }

                if (endingType == GET_FIRE_ENDING)
                {
                    System.out.printf(" [해고 엔딩] %s님은 음료제조 실수가 잦아 해고되었습니다.\n", User.getName());
                    System.out.println("            괜찮습니다 카페는 많으니까요... 힘내세요!");
                    System.out.println("------------------------------------------------------------------------");
                    System.out.println(" ✨ 해고 엔딩 tip ✨ ");
                    System.out.println("    음료제조 실패 확률이 높아지면 해고 엔딩의 조건이 달성됩니다.");
                    System.out.println("------------------------------------------------------------------------");
                }

                if (endingType == PARTIMER_ENDING)
                {
                    System.out.printf(" [알바 엔딩] %s님은 카페 아르바이트를 능숙하게 해내고 있습니다.\n", User.getName());
                    System.out.println("------------------------------------------------------------------------");
                    System.out.println(" ✨ 알바 엔딩 tip ✨ ");
                    System.out.println("    비밀입니다.");
                    System.out.println("------------------------------------------------------------------------");
                }

                // 엔딩 유형 추가하기... 멋진 카페 엔딩
                
            }

            System.out.printf(" 아직 공개되지 않은 엔딩이 %d개 남아있습니다 !\n", cnt);
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();


        }

        GameRun gameRun = new GameRun();
        gameRun.initialRun();  // 이전으로

    }//end openEnding()


// 소비 아이템 사용 -----------------------------------------------------------------------------------------------------------
    public void myItem()// 보유한 소비 아이템 확인하는 메소드
    {
        System.out.println("                         ╔═══━━━─────────━━━═══╗                         ");
        System.out.println("=========================    보유한 소비 아이템    =========================");
        System.out.println("                         ╚═══━━━─────────━━━═══╝                         ");
        System.out.println();
        System.out.println(" 케이크   : 체력을 2 회복합니다.");
        System.out.println(" 샌드위치 : 체력을 4 회복합니다.");
        System.out.println(" 초콜릿   : 인내력을 2 회복합니다.");
        System.out.println(" 마카롱   : 인내력을 4 회복합니다. ");
        System.out.println();
        System.out.println("------------------------------------------------------------------------");
        System.out.println();
        System.out.printf(" 케이크   : %d개\n", User.getCakeNum());
        System.out.printf(" 샌드위치 : %d개\n", User.getSandwichNum());
        System.out.printf(" 초콜릿   : %d개\n", User.getChocoNum());
        System.out.printf(" 마카롱   : %d개\n", User.getMacaronNum());
        System.out.println();
        System.out.println("========================================================================");

        useItemSel();  // 아이템 사용 메소드
    }

    public void useItemSel()// 아이템 사용 메소드
    {
        boolean check = true;   // 반복여부 체크하는 변수
        String resultStr;       // 사용자의 선택값을 담을 변수
        int result = 0;         // resultStr를 int 로 변환해 사용자의 선택값을 담을 변수

        while(check)
        {
            System.out.println(" 사용할 아이템을 골라주세요.");
            System.out.println(" 1.케이크  2.샌드위치  3.초콜릿  4.마카롱  5.이전으로");
            System.out.println("------------------------------------------------------------------------");
            Scanner sc = new Scanner(System.in);
            System.out.print(" 선택 : ");
            resultStr = sc.nextLine();

            // 입력받은 값이 숫자인지 확인
            try
            {
              // 자료형 변경한 뒤(String → int) int형에 담는다.
              result = Integer.parseInt(resultStr);
              check = false;
              // int 형으로 변경되면 check 에 false 담아서 반복문 빠져나간다.
              // int형으로 변경되지 않는다면 NumberFormatException 발생
            }
            catch (NumberFormatException e) // NumberFormatException 발생한다면
            {
              check = true;   // check 에 true 담아서 다시 반복
              // result = 0; 으로 초기화된 상태이므로  하단 if문 내부까지 실행하고 반복된다.
            }

            if(result < 1 || result > 5 )// 주어진 값 이외의 수를 선택한 경우
            {
              System.out.println("========================================================================");
              System.out.println(" 올바른 값을 입력해주세요.");
              check = true;
            }

        }// end while

        final int CAKE = 1;
        final int SANDWICH = 2;
        final int CHOCO = 3;
        final int MACARON = 4;
        final int EXIT = 5;

        ItemAction itemAction = new ItemAction();   // 아이템 관련 기능 객체 생성

        switch (result)                     // 사용자의 선택값에 따라
        {
            case CAKE:
                itemAction.useItem("케이크");
                //itemAction.useCake();           // 케이크 사용
                break;

            case SANDWICH:
                itemAction.useItem("샌드위치");
                //itemAction.useSandwich();   // 샌드위치 사용
                break;

            case CHOCO:
                itemAction.useItem("초콜릿");
                //itemAction.useChoco();         // 초콜릿 사용
                break;

            case MACARON:
                itemAction.useItem("마카롱");
                //itemAction.useMacaron();     // 마카롱 사용
                break;

            case EXIT:  // 이전으로
                GameRun gameRun = new GameRun();
                gameRun.selWork();
                break;
        }

    } // end useItem()

}// end class









