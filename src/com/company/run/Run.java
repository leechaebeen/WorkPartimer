package com.company.run;
import java.util.Random;
import java.util.Scanner;

import com.company.action.*;
import com.company.data.Beverage;
import com.company.data.Cafe;
import com.company.data.Item;
import com.company.data.User;

import java.util.regex.Pattern;

// 선택지에 따른 출력을 실행하는 클래스
public class Run<endings>
{
    // int result;          → 인스턴스 변수
    // static int result;   → 클래스 변수

    // 1.초기화면 실행하는 메소드
    public void initialRun()
    {
        String resultStr;
        int result = 0;
        // 초기화해야하는 이유  : Primitive type 인 지역변수는 자동으로 초기화가 안된다.
        // → 예측할 수 없는 값을 담는걸 방지하기 위해 초기화 해줘야 한다.

        // 스캐너 객체 생성
        Scanner sc = new Scanner(System.in);

        // 게임 소개
        System.out.println();
        System.out.println();

        System.out.println("。　　　　　　　　　　　　　　　　　ﾟ　　　.　　　　　　　　　　　　　　.");
        System.out.println("　　　　　　　　　.　 .　　　　　　　　.");
        System.out.println(" 　　　　　。　　　　　　　　　　　　　　　　　　　ﾟ　　　　　　　　　。");
        System.out.println("　　.　　　　　　　　.　　　　　.　　　　　　　　　　。　　.　");
        System.out.println("　.　　　　　　　　　　　　　　                   ㅤㅤㅤㅤㅤㅤㅤㅤㅤ 　 。　　.");
        System.out.println("　 　　　　　　。　　　　   　Work! partimer ! 　　ﾟ　　　.　 　　　　　　　　.");
        System.out.println(",　　　　　　　　　.　 .　　　　　　　　.");
        System.out.println("　　　　　。　　　　　　　　　　　　　　　　　　　ﾟ　　　　　　　　　。");
        System.out.println("　　.　　　　　　　　.　　　　　.　　　　　　　　　　。　　.");
        System.out.println();
        System.out.println();
        System.out.println();

        String userName; // 유저이름을 저장할 변수
        boolean check;   // 조건에 맞게 이름 입력했는지 확인할 변수

        do {
            System.out.print(" 이름을 입력해주세요(한글만 가능) : ");
            userName = sc.nextLine();                                   // 유저이름을 입력받고
            userName = userName.replaceAll(" ", "");    // 공백을 제거하고
            check = Pattern.matches("^[가-힣]*$", userName);       // 정규표현식을 이용해서 한글인지 확인한다. 한글인 경우 true 반환

        }while (!check); // 입력받은 이름이 한글이 아니면 반복

        User.setName(userName);         // 입력받은 유저이름 속성에 넣기

        System.out.println(" 어쩌구 저쩌구 스토리 설명 쫓겨난 이유 ");

        System.out.println();
        System.out.println();

        System.out.println("。　　　　　　　　　　　　　　　　　ﾟ　　　.　　　　　　　　　　　　　　.     ");
        System.out.println("　　　　　　　　　.　 .　　　　　　　　.");
        System.out.println(" 　　　　　。　　　　　　　　　　　　　　　　　　　ﾟ　　　　　　　　　。    ");
        System.out.println("　　.　　　　　　　　.　　　　　.　　　　　　　　　　。　　.　");
        System.out.println("　.　　　　　　　　　　　　　　                   ㅤㅤㅤㅤㅤㅤㅤㅤㅤ 　 。　　.");
        System.out.println("　 　　　　　　。　　　 。      　三 ඞ;;   　  　ﾟ　　　.　 　　　　　　　　.");
        System.out.println(". 　。　　　        　    　。　　　　      •　 　        　　　     　　");
        System.out.printf("\t\t。\t\t\t %s님은 결국 추방당했습니다 . . .     .          。\n", User.getName());
        System.out.println(",　　　　　　　　　.　 .　　　　　　　　.");
        System.out.println("　　　　　。　　　　　　　　　　　　　　　　　　　ﾟ　　　　　　　　　。");
        System.out.println("　　.　　　　　　　　.　　　　　.　　　　　　　　　　。　　.");
        System.out.println();
        System.out.println();
        System.out.println();


        System.out.println();
        System.out.println();
        System.out.printf(" %s님은 오늘부터 카페 아르바이트를 시작했습니다.\n", User.getName());
        System.out.println(" 아르바이트를 진행하면서 다양한 엔딩을 볼 수 있습니다.");

        // 올바른 선택지를 선택할 때까지 반복
        while(check) // check 는 위에서 입력받은 유저이름이 한글인걸 확인했기 때문에 true 인 상황이다.
        {
            System.out.println("========================================================================");
            System.out.println(" 1. 시작하기  2.이름 다시 설정하기 ");
            System.out.println("------------------------------------------------------------------------");
            System.out.print(" 선택 : ");
            resultStr = sc.nextLine();

            // 입력받은 값이 숫자인지 확인
            try
            {
                // 입력받은 값의 공백을 제거하고
                // 자료형 변경한 뒤(String → int) int형에 담는다.
                result = Integer.parseInt(resultStr.replace(" ",""));
                check = false;
                // int 형으로 변경되면 check 에 false 담아서 반복문 빠져나간다. 
                // int형으로 변경되지 않는다면 NumberFormatException 발생
            }
            catch (NumberFormatException e) // NumberFormatException 발생한다면
            {
                check = true;   // check 에 true 담아서 다시 반복
                                // result = 0; 으로 초기화된 상태이므로  하단 if문 내부까지 실행하고 반복된다.
            }

            if(result < 1 || result > 2 )// 주어진 값 이외의 수를 선택한 경우
            {
                System.out.println("========================================================================");
                System.out.println(" 올바른 값을 입력해주세요.");
                check = true;
            }
        }

        final int START = 1;                // 게임 시작
        final int INITIAL_RUN = 2;          // 초기화면 실행

        CafeAction cafeAction = new CafeAction(); // Cafe 객체 생성

        while(true)
        {
            switch(result)              // 유저의 선택값에 따라 분기 처리
            {
                case  START:             // 1. 시작하기를 선택한 경우
                    cafeAction.start();
                    break;

                case INITIAL_RUN :       // 2. 다시 시작하기를 선택한 경우
                    initialRun();
                    break;
            }

        }

    } //end initialRun()

// 손님 등장 메소드

    // 일반손님 등장 메소드
    public void comeCustomer()
    {
        Cafe.setTodayCustomerNum(Cafe.getTodayCustomerNum()+1); // 기존의 하루 방문자 수에 한명 더하기
        Cafe.setTotalCustomerNum(Cafe.getTotalCustomerNum()+1); // 기존의 총 방문자 수에 한명 더하기

        System.out.println();

        CustomerAction customerAction = new CustomerAction();           // 손님 객체 생성

        Beverage beverage = customerAction.orderBeverage(); // 주문할 음료 객체 생성
        customerAction.orderToPartimer(beverage);           // 손님이 음료 주문

        userAction userAction = new userAction();   // 유저 액션 객체 생성
        boolean result = userAction.makeBeverage(beverage); // 음료 만들기 수행하고 결과를 반환한다.
        userAction.makeBeverageResult(result);              // 결과에 따른 출력

        Ending ending = new Ending();       // 엔딩 객체 생성
        if(User.getHp()==0)             // 만약 유저의 체력이 0이 된다면
        {
            ending.fallDownEnding();        // 과로 엔딩 실행
        }
        else if(User.getSuccessNum() < User.getFailNum())   // 음료 제조 성공 누적 횟수 < 실패 누적 횟수라면
        {
            ending.getFireEnding();         // 해고 엔딩 실행
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

        SpecialCustomerAction specialCustomer = new SpecialCustomerAction(); // 특별 손님 객체 생성
        Beverage beverage = specialCustomer.orderBeverage();     // 주문할 음료 객체 생성

        System.out.println();

        // 음료 주문 유형 랜덤으로 실행하기
        Random rd = new Random();
        int typeNum = rd.nextInt(5)+1; //1~5 랜덤값 반환해서 typeNum 변수에 저장

        switch(typeNum)
        {
            case TALK_DOWN : specialCustomer.orderTalkDown(beverage);// 반말하는 손님
                break;

            case FIGHT: specialCustomer.orderFight(beverage);       // 시비거는 손님
                break;

            case FALSE_RELIGION: specialCustomer.orderFalseReligion();// 사이비 손님
                break;

            case WRONG: specialCustomer.orderWrong();                 // 잘못찾아온 손님
                break;

            case PRESENT: specialCustomer.orderPresent();             // 선물주는 손님
                break;

        }

        if(typeNum == 1 ||typeNum == 2)  // 음료를 주문하는 특별손님의 경우에만
        {
            // 유저가 음료 만들기
            userAction userAction = new userAction();   // 유저 액션 객체 생성
            boolean result = userAction.makeBeverage(beverage); // 음료 만들기 수행하고 결과를 반환한다.
            userAction.makeBeverageResult(result);              // 결과에 따른 출력
        }

        Ending ending = new Ending();       // 엔딩 객체 생성
        if(User.getHp()==0)             // 만약 유저의 체력이 0이 된다면
        {
            ending.fallDownEnding();        //  쓰러지는 엔딩 실행
        }
        else if(User.getFeeling() == 0) // 만약 유저의 인내력이 0이 된다면
        {
            ending.toQuitEnding();          // 그만두는 엔딩 실행
        }
        else if(User.getSuccessNum() < User.getFailNum())   // 음료 제조 성공 누적 횟수 < 실패 누적 횟수라면
        {
            ending.getFireEnding();         // 해고 엔딩 실행
        }

    }

    // 비밀 손님 등장 메소드
    public void comeSecretCustomer()
    {
        final int COMMON = 1;           // 일반 손님 유형
        final int TALK_DOWN = 2;        // 반말하는 유형
        final int FIGHT = 3;            // 시비거는 유형

        Cafe.setTodayCustomerNum(Cafe.getTodayCustomerNum()+1); // 기존의 하루 방문자 수에 하나 더하기
        Cafe.setTotalCustomerNum(Cafe.getTotalCustomerNum()+1); // 기존의 총 방문자 수에 한명 더하기

        // 매장에 자리가 있는지 확인
        if(Cafe.getChair()==0)    // 매장에 자리가 없으면 손님이 나간다.
        {
            System.out.println(" 매장에 자리가 없어서 손님이 나갔다 . . .");
            System.out.println(" 자리를 늘리던가 해야지 원 . . . ");
        }
        else
        {
            SecretCustomerAction secretCustomer = new SecretCustomerAction();  // 비밀 손님 객체 생성
            Beverage beverage = secretCustomer.orderBeverage();    // 주문할 음료 객체 생성

            System.out.println();

            // 음료 주문 유형 랜덤으로 실행하기
            Random rd = new Random();
            int typeNum = rd.nextInt(3)+1; //1~3 랜덤값 반환해서 typeNum 변수에 저장

            switch(typeNum)
            {
                case COMMON: secretCustomer.orderToPartimer(beverage);   // 일반 손님
                    break;

                case TALK_DOWN: secretCustomer.orderTalkDown(beverage);    // 반말하는 손님
                    break;

                case FIGHT: secretCustomer.orderFight(beverage);       // 시비거는 손님
                    break;
            }

            // 유저가 음료 만들기
            userAction userAction = new userAction();   // 유저 액션 객체 생성
            boolean result = userAction.makeBeverage(beverage); // 음료 만들기 수행하고 결과를 반환한다.
            userAction.makeBeverageResult(result);              // 결과에 따른 출력

            Ending ending = new Ending();       // 엔딩 객체 생성
            if(User.getHp()==0)             // 만약 유저의 체력이 0이 된다면
            {
                ending.fallDownEnding();        //  쓰러지는 엔딩 실행
            }
            else if(User.getFeeling() == 0) // 만약 유저의 인내력이 0이 된다면
            {
                ending.toQuitEnding();          // 그만두는 엔딩 실행
            }
            else if(User.getSuccessNum() < User.getFailNum())   // 음료 제조 성공 누적 횟수 < 실패 누적 횟수라면
            {
                ending.getFireEnding();         // 해고 엔딩 실행
            }

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
                // 입력받은 값의 공백을 제거하고
                // 자료형 변경한 뒤(String → int) int형에 담는다.
                result = Integer.parseInt(resultStr.replace(" ",""));
                check = false;
                // int 형으로 변경되면 check 에 false 담아서 반복문 빠져나간다.
                // int형으로 변경되지 않는다면 NumberFormatException 발생
            }
            catch (NumberFormatException e) // NumberFormatException 발생한다면
            {
                check = true;   // check 에 true 담아서 다시 반복
                // result = 0; 으로 초기화된 상태이므로  하단 if문 내부까지 실행하고 반복된다.
            }

            if(result < 1 || result > 4 )// 주어진 값 이외의 수를 선택한 경우
            {
                System.out.println("========================================================================");
                System.out.println(" 올바른 값을 입력해주세요.");
                check = true;
            }

        }

        CafeAction cafeAction = new CafeAction();

        switch(result)
        {
            case  MY_INFO: myInfo();    // 내 정보 확인

                break;

            case  CAFE_INFO: cafeInfo(); // 카페 정보 확인

                break;

            case EXIT:  cafeAction.weekend();   // 주말 초기화면 호출
                break;
        }

    }

    public void myInfo()// 내 정보 확인
    {
        int week = (User.getWorkingDays() / 7) + 1;               // 주차 = 일한날짜/7 + 1
        System.out.println("                         ╔═══━━━─────────━━━═══╗                         ");
        System.out.printf("==========================     %d주차   정보      =========================\n", week);
        System.out.println("                         ╚═══━━━─────────━━━═══╝                         ");
        System.out.println();
        System.out.println(" 설정값 : 체력, 인내력의 최대치입니다. 아이템을 통해 증가시킬 수 있습니다.");
        System.out.println("         체력과 인내력은 주말마다 설정값으로 초기화됩니다. ");
        System.out.println();
        System.out.println("------------------------------------------------------------------------");
        System.out.println();
        System.out.println(" 숙련도 : 음료 제조 성공 확률과 카페 운영 기간을 고려하여 ");
        System.out.println("         주말마다 숙련도가 업데이트됩니다.");
        System.out.println();
        System.out.println("------------------------------------------------------------------------");
        System.out.println();
        System.out.printf(" %s님의 체력 : %d\n", User.getName(), User.getSetHp());
        System.out.printf(" %s님의 인내력 : %d\n", User.getName(), User.getSetFeeling());
        System.out.printf(" %s님의 숙련도 : %d\n ", User.getName(), User.getSkillLevel());
        System.out.println();

        info(); // 이전으로

    }// end myInfo()

    public void cafeInfo()  // 카페 정보
    {
        int week = (User.getWorkingDays() / 7) + 1;               // 주차 = 일한날짜/7 + 1
        System.out.println("                         ╔═══━━━─────────━━━═══╗                         ");
        System.out.printf("==========================    %d주차  카페 정보    =========================\n", week);
        System.out.println("                         ╚═══━━━─────────━━━═══╝                         ");
        System.out.println();
        System.out.println(" 의자 : 카페에 존재하는 의자의 수입니다. 의자는 설정된 값으로 매일 초기화됩니다. ");
        System.out.println("       매장에서 음료를 마시길 원하는 손님은 의자가 없으면 카페를 나갑니다.");
        System.out.println("       아이템 구매를 통해 의자의 수를 늘릴 수 있습니다. ");
        System.out.println();
        System.out.println("------------------------------------------------------------------------");
        System.out.println();
        System.out.println(" 유리잔 : 매장 내 취식하는 손님이 차가운 음료를 마실 경우 사용하는 잔입니다. ");
        System.out.println("         알맞은 잔이 없을 경우 컴플레인이 들어오고, 유저의 인내력이 1 감소합니다. ");
        System.out.println("         아이템 구매를 통해 유리잔의 수를 늘릴 수 있습니다. ");
        System.out.println();
        System.out.println("------------------------------------------------------------------------");
        System.out.println();
        System.out.println(" 머그잔 : 매장 내 취식하는 손님이 따뜻한 음료를 마실 경우 사용하는 잔입니다. ");
        System.out.println("         알맞은 잔이 없을 경우 컴플레인이 들어오고, 유저의 인내력이 1 감소합니다. ");
        System.out.println("         아이템 구매를 통해 머그잔의 수를 늘릴 수 있습니다. ");
        System.out.println();
        System.out.println("========================================================================");
        System.out.println();
        System.out.printf(" 의자의 수    : %d\n", Cafe.getSetChair());
        System.out.printf(" 유리잔의 수  : %d\n", Cafe.getSetCup());
        System.out.printf(" 머그잔의 수  : %d\n", Cafe.getSetMug());
        System.out.println();

        info(); // 이전으로

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
                // 입력받은 값의 공백을 제거하고
                // 자료형 변경한 뒤(String → int) int형에 담는다.
                result = Integer.parseInt(resultStr.replace(" ",""));
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
                CafeAction cafeAction = new CafeAction();
                cafeAction.weekend();   // 상점 초기화면 호출
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
            System.out.printf(" 체력 최댓값   : %d개\n", User.getSetHp());
            System.out.printf(" 인내력 최댓값 : %d개\n", User.getSetFeeling());
            System.out.println();
            System.out.println("------------------------------------------------------------------------");
            System.out.println();
            System.out.printf(" 1.의자 구매         (- %d코인)\n", item.getChairPrice());
            System.out.printf(" 2.유리잔 구매       (- %d코인)\n", item.getCupPrice());
            System.out.printf(" 3.머그잔 구매       (- %d코인)\n", item.getMugPrice());
            System.out.printf(" 4.체력 최댓값 +2    (- %d코인)\n", item.getHpPrice());
            System.out.printf(" 5.인내력 최댓값 +2  (- %d코인)\n", item.getFeelingPrice());
            System.out.println(" 6.이전으로");
            System.out.println();
            System.out.println("========================================================================");
            Scanner sc = new Scanner(System.in);
            System.out.print(" 선택 : ");
            resultStr = sc.nextLine();

            // 입력받은 값이 숫자인지 확인
            try
            {
              // 입력받은 값의 공백을 제거하고
              // 자료형 변경한 뒤(String → int) int형에 담는다.
              result = Integer.parseInt(resultStr.replace(" ",""));
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

        switch(result)
        {
            case CHAIR: buyChair(); // 의자 구매
                break;

            case CUP: buyCup();     // 유리잔 구매
                break;

            case MUG: buyMug();     // 머그잔 구매

                break;

            case HP: buyHp();       // 체력 증가

                break;

            case FEELING: buyFeeling(); // 인내력 증가

                break;

            case EXIT : goShop();   // 이전으로
                break;

        }

    }// end buyPermanentItem

    // 의자 구매 메소드
    public void buyChair()
    {
        boolean check = true;   // 반복여부 체크하는 변수
        String resultStr;       // 사용자의 선택값을 담을 변수
        int result = 0;         // resultStr를 int 로 변환해 사용자의 선택값을 담을 변수

        // 아이템 객체 생성
        Item item = new Item();

        if(User.getProperty() >= item.getChairPrice())  // 의자 가격보다 보유한 코인이 많거나 같으면
        {
            User.setProperty(User.getProperty() - item.getChairPrice());    // 계산하고
            Cafe.setSetChair(Cafe.getSetChair()+1); // 의자 설정값 추가

            System.out.println("========================================================================");
            System.out.printf(" %d 코인을 사용했습니다.\n", item.getChairPrice());
            System.out.printf(" 보유 코인      : %d코인\n", User.getProperty());
            System.out.printf(" 카페 의자 수   : %d \n", Cafe.getSetChair() );
            System.out.println("========================================================================");

            final int REPURCHASE = 1;   // 재구매
            final int EXIT = 2;         // 이전으로

            while(check)
            {
                System.out.println(" 1.재구매(동일 아이템) 2.이전으로");
                System.out.println("------------------------------------------------------------------------");
                Scanner sc = new Scanner(System.in);
                System.out.print(" 선택 : ");
                resultStr = sc.nextLine();

                // 입력받은 값이 숫자인지 확인
                try
                {
                    // 입력받은 값의 공백을 제거하고
                    // 자료형 변경한 뒤(String → int) int형에 담는다.
                    result = Integer.parseInt(resultStr.replace(" ",""));
                    check = false;
                    // int 형으로 변경되면 check 에 false 담아서 반복문 빠져나간다.
                    // int형으로 변경되지 않는다면 NumberFormatException 발생
                }
                catch (NumberFormatException e) // NumberFormatException 발생한다면
                {
                    check = true;   // check 에 true 담아서 다시 반복
                    // result = 0; 으로 초기화된 상태이므로  하단 if문 내부까지 실행하고 반복된다.
                }

                if(result < 1 || result > 2 )// 주어진 값 이외의 수를 선택한 경우
                {
                    System.out.println("========================================================================");
                    System.out.println(" 올바른 값을 입력해주세요.");
                    check = true;
                }

                switch(result)
                {
                    case REPURCHASE: buyChair();   // 재구매
                        break;

                    case EXIT: buyPermanentItem(); // 이전으로
                        break;
                }

            }

        }
        else
        {
            System.out.println("========================================================================");
            System.out.println(" 보유한 코인으로 의자를 구매할 수 없습니다.");
            System.out.printf(" 보유 코인      : %d코인\n", User.getProperty());
            System.out.println("========================================================================");
            buyPermanentItem(); // 이전으로
        }

    }

    // 유리잔 구매 메소드
    public void buyCup()
    {
        boolean check = true;   // 반복여부 체크하는 변수
        String resultStr;       // 사용자의 선택값을 담을 변수
        int result = 0;         // resultStr를 int 로 변환해 사용자의 선택값을 담을 변수

        // 아이템 객체 생성
        Item item = new Item();

        if(User.getProperty() >= item.getCupPrice())  // 유리잔 가격보다 보유한 코인이 많거나 같으면
        {
            User.setProperty(User.getProperty() - item.getCupPrice());    // 계산하고
            Cafe.setSetCup(Cafe.getSetCup()+1); // 유리잔 설정값 추가

            System.out.println("========================================================================");
            System.out.printf(" %d 코인을 사용했습니다.\n", item.getChairPrice());
            System.out.printf(" 보유 코인      : %d코인\n", User.getProperty());
            System.out.printf(" 카페 유리잔 수   : %d \n", Cafe.getSetCup() );
            System.out.println("========================================================================");

            final int REPURCHASE = 1;   // 재구매
            final int EXIT = 2;         // 이전으로

            while(check)
            {
                System.out.println(" 1.재구매(동일 아이템) 2.이전으로");
                System.out.println("------------------------------------------------------------------------");
                Scanner sc = new Scanner(System.in);
                System.out.print(" 선택 : ");
                resultStr = sc.nextLine();

                // 입력받은 값이 숫자인지 확인
                try
                {
                    // 입력받은 값의 공백을 제거하고
                    // 자료형 변경한 뒤(String → int) int형에 담는다.
                    result = Integer.parseInt(resultStr.replace(" ",""));
                    check = false;
                    // int 형으로 변경되면 check 에 false 담아서 반복문 빠져나간다.
                    // int형으로 변경되지 않는다면 NumberFormatException 발생
                }
                catch (NumberFormatException e) // NumberFormatException 발생한다면
                {
                    check = true;   // check 에 true 담아서 다시 반복
                    // result = 0; 으로 초기화된 상태이므로 하단 if문 내부까지 실행하고 반복된다.
                }

                if(result < 1 || result > 2 )// 주어진 값 이외의 수를 선택한 경우
                {
                    System.out.println("========================================================================");
                    System.out.println(" 올바른 값을 입력해주세요.");
                    check = true;
                }

                switch(result)
                {
                    case REPURCHASE: buyCup();   // 재구매
                        break;

                    case EXIT: buyPermanentItem(); // 이전으로
                        break;
                }

            }

        }
        else
        {
            System.out.println("========================================================================");
            System.out.println(" 보유한 코인으로 유리잔을 구매할 수 없습니다.");
            System.out.printf(" 보유 코인      : %d코인\n", User.getProperty());
            System.out.println("========================================================================");
            buyPermanentItem(); // 이전으로
        }

    }// end buyCup()

    // 머그잔 구매 메소드
    public void buyMug()
    {
        boolean check = true;   // 반복여부 체크하는 변수
        String resultStr;       // 사용자의 선택값을 담을 변수
        int result = 0;         // resultStr를 int 로 변환해 사용자의 선택값을 담을 변수

        // 아이템 객체 생성
        Item item = new Item();

        if(User.getProperty() >= item.getMugPrice())  // 머그잔 가격보다 보유한 코인이 많거나 같으면
        {
            User.setProperty(User.getProperty() - item.getMugPrice());    // 계산하고
            Cafe.setSetMug(Cafe.getSetMug()+1); // 머그잔 설정값 추가

            System.out.println("========================================================================");
            System.out.printf(" %d 코인을 사용했습니다.\n", item.getChairPrice());
            System.out.printf(" 보유 코인      : %d코인\n", User.getProperty());
            System.out.printf(" 카페 머그잔 수   : %d \n", Cafe.getSetMug() );
            System.out.println("========================================================================");

            final int REPURCHASE = 1;   // 재구매
            final int EXIT = 2;         // 이전으로

            while(check)
            {
                System.out.println(" 1.재구매(동일 아이템) 2.이전으로");
                System.out.println("------------------------------------------------------------------------");
                Scanner sc = new Scanner(System.in);
                System.out.print(" 선택 : ");
                resultStr = sc.nextLine();

                // 입력받은 값이 숫자인지 확인
                try
                {
                    // 입력받은 값의 공백을 제거하고
                    // 자료형 변경한 뒤(String → int) int형에 담는다.
                    result = Integer.parseInt(resultStr.replace(" ",""));
                    check = false;
                    // int 형으로 변경되면 check 에 false 담아서 반복문 빠져나간다.
                    // int형으로 변경되지 않는다면 NumberFormatException 발생
                }
                catch (NumberFormatException e) // NumberFormatException 발생한다면
                {
                    check = true;   // check 에 true 담아서 다시 반복
                    // result = 0; 으로 초기화된 상태이므로  하단 if문 내부까지 실행하고 반복된다.
                }

                if(result < 1 || result > 2 )// 주어진 값 이외의 수를 선택한 경우
                {
                    System.out.println("========================================================================");
                    System.out.println(" 올바른 값을 입력해주세요.");
                    check = true;
                }

                switch(result)
                {
                    case REPURCHASE: buyMug();   // 재구매
                        break;

                    case EXIT: buyPermanentItem(); // 이전으로
                        break;
                }

            }

        }
        else
        {
            System.out.println("========================================================================");
            System.out.println(" 보유한 코인으로 머그잔을 구매할 수 없습니다.");
            System.out.printf(" 현재 보유 코인      : %d코인\n", User.getProperty());
            System.out.println("========================================================================");
            buyPermanentItem(); // 이전으로
        }

    }// end buyMug()

    // 체력 구매 메소드
    public void buyHp()
    {
        boolean check = true;   // 반복여부 체크하는 변수
        String resultStr;       // 사용자의 선택값을 담을 변수
        int result = 0;         // resultStr를 int 로 변환해 사용자의 선택값을 담을 변수

        // 아이템 객체 생성
        Item item = new Item();

        if(User.getProperty() >= item.getHpPrice())  // 체력 증가 가격보다 보유한 코인이 많거나 같으면
        {
            User.setProperty(User.getProperty() - item.getHpPrice());    // 계산하고
            User.setSetHp(User.getSetHp()+1); // 체력 설정값 추가

            System.out.println("========================================================================");
            System.out.printf(" %d 코인을 사용했습니다.\n", item.getHpPrice());
            System.out.printf(" 보유 코인      : %d코인\n", User.getProperty());
            System.out.printf(" 체력          : %d \n", User.getSetHp() );
            System.out.println("========================================================================");

            final int REPURCHASE = 1;   // 재구매
            final int EXIT = 2;         // 이전으로

            while(check)
            {
                System.out.println(" 1.재구매(동일 아이템) 2.이전으로");
                System.out.println("------------------------------------------------------------------------");
                Scanner sc = new Scanner(System.in);
                System.out.print(" 선택 : ");
                resultStr = sc.nextLine();

                // 입력받은 값이 숫자인지 확인
                try
                {
                    // 입력받은 값의 공백을 제거하고
                    // 자료형 변경한 뒤(String → int) int형에 담는다.
                    result = Integer.parseInt(resultStr.replace(" ",""));
                    check = false;
                    // int 형으로 변경되면 check 에 false 담아서 반복문 빠져나간다.
                    // int형으로 변경되지 않는다면 NumberFormatException 발생
                }
                catch (NumberFormatException e) // NumberFormatException 발생한다면
                {
                    check = true;   // check 에 true 담아서 다시 반복
                    // result = 0; 으로 초기화된 상태이므로  하단 if문 내부까지 실행하고 반복된다.
                }

                if(result < 1 || result > 2 )// 주어진 값 이외의 수를 선택한 경우
                {
                    System.out.println("========================================================================");
                    System.out.println(" 올바른 값을 입력해주세요.");
                    check = true;
                }

                switch(result)
                {
                    case REPURCHASE: buyHp();   // 재구매
                        break;

                    case EXIT: buyPermanentItem(); // 이전으로
                        break;
                }

            }

        }
        else
        {
            System.out.println("========================================================================");
            System.out.println(" 보유한 코인으로 체력을 증가시킬 수 없습니다.");
            System.out.printf(" 현재 보유 코인      : %d코인\n", User.getProperty());
            System.out.println("========================================================================");
            buyPermanentItem(); // 이전으로
        }

    }// end buyHp()

    // 체력 구매 메소드
    public void buyFeeling()
    {
        boolean check = true;   // 반복여부 체크하는 변수
        String resultStr;       // 사용자의 선택값을 담을 변수
        int result = 0;         // resultStr를 int 로 변환해 사용자의 선택값을 담을 변수

        // 아이템 객체 생성
        Item item = new Item();

        if(User.getProperty() >= item.getFeelingPrice())  // 체력 증가 가격보다 보유한 코인이 많거나 같으면
        {
            User.setProperty(User.getProperty() - item.getFeelingPrice());    // 계산하고
            User.setSetFeeling(User.getSetFeeling()+1); // 인내력 설정값 추가

            System.out.println("========================================================================");
            System.out.printf(" %d 코인을 사용했습니다.\n", item.getFeelingPrice());
            System.out.printf(" 보유 코인      : %d코인\n", User.getProperty());
            System.out.printf(" 인내력         : %d \n", User.getSetFeeling() );
            System.out.println("========================================================================");

            final int REPURCHASE = 1;   // 재구매
            final int EXIT = 2;         // 이전으로

            while(check)
            {
                System.out.println(" 1.재구매(동일 아이템) 2.이전으로");
                System.out.println("------------------------------------------------------------------------");
                Scanner sc = new Scanner(System.in);
                System.out.print(" 선택 : ");
                resultStr = sc.nextLine();

                // 입력받은 값이 숫자인지 확인
                try
                {
                    // 입력받은 값의 공백을 제거하고
                    // 자료형 변경한 뒤(String → int) int형에 담는다.
                    result = Integer.parseInt(resultStr.replace(" ",""));
                    check = false;
                    // int 형으로 변경되면 check 에 false 담아서 반복문 빠져나간다.
                    // int형으로 변경되지 않는다면 NumberFormatException 발생
                }
                catch (NumberFormatException e) // NumberFormatException 발생한다면
                {
                    check = true;   // check 에 true 담아서 다시 반복
                    // result = 0; 으로 초기화된 상태이므로  하단 if문 내부까지 실행하고 반복된다.
                }

                if(result < 1 || result > 2 )// 주어진 값 이외의 수를 선택한 경우
                {
                    System.out.println("========================================================================");
                    System.out.println(" 올바른 값을 입력해주세요.");
                    check = true;
                }

                switch(result)
                {
                    case REPURCHASE: buyFeeling();   // 재구매
                        break;

                    case EXIT: buyPermanentItem(); // 이전으로
                        break;
                }

            }

        }
        else
        {
            System.out.println("========================================================================");
            System.out.println(" 보유한 코인으로 인내력을 증가시킬 수 없습니다.");
            System.out.printf(" 현재 보유 코인      : %d코인\n", User.getProperty());
            System.out.println("========================================================================");
            buyPermanentItem(); // 이전으로
        }

    }// end buyFeeling()

// 소모 아이템 구매 메소드 ------------------------------------------------------------------------------------------------
    public void buyConsumableItem()
    {
        boolean check = true;   // 반복여부 체크하는 변수
        String resultStr;       // 사용자의 선택값을 담을 변수
        int result = 0;         // resultStr를 int 로 변환해 사용자의 선택값을 담을 변수

        final int CAKE = 1;     // 체력 2 회복
        final int SANDWICH = 2; // 체력 4 회복
        final int CHOCO = 3;    // 인내력 2 회복
        final int MACARON = 4;  // 인내력 4 회복
        final int EXIT = 5;     // 이전으로

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
            System.out.printf(" 케이크   : %d개 ( 체력을 2 회복시킨다. )\n", Item.getCake());
            System.out.printf(" 샌드위치 : %d개 ( 체력을 4 회복시킨다. )\n", Item.getSandwich());
            System.out.printf(" 초콜릿   : %d개 ( 인내력을 2 회복시킨다. )\n", Item.getChoco());
            System.out.printf(" 마카롱   : %d개 ( 인내력을 4 회복시킨다. )\n", Item.getMacaron());
            System.out.println();
            System.out.println("------------------------------------------------------------------------");
            System.out.println();
            System.out.printf(" 1.케이크 구매         (- %d코인)\n", item.getCakePrice());
            System.out.printf(" 2.샌드위치 구매       (- %d코인)\n", item.getSandwichPrice());
            System.out.printf(" 3.초콜릿 구매         (- %d코인)\n", item.getChocoPrice());
            System.out.printf(" 4.마카롱 구매         (- %d코인)\n", item.getMacaronPrice());
            System.out.println(" 5.이전으로");
            System.out.println();
            System.out.println("========================================================================");
            Scanner sc = new Scanner(System.in);
            System.out.print(" 선택 : ");
            resultStr = sc.nextLine();

            // 입력받은 값이 숫자인지 확인
            try
            {
                // 입력받은 값의 공백을 제거하고
                // 자료형 변경한 뒤(String → int) int형에 담는다.
                result = Integer.parseInt(resultStr.replace(" ",""));
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

        switch (result)
        {
            case CAKE:  buyCake();           // 케이크 구매
                break;

            case SANDWICH: buySandwich();   // 샌드위치 구매
                break;

            case CHOCO: buyChoco();         // 초콜릿 구매
                break;

            case MACARON: buyMacaron();     // 마카롱 구매
                break;

            case EXIT: goShop();   // 이전으로
                break;

        }
    }

    // 케이크 구매 메소드
    public void buyCake()
    {
        boolean check = true;   // 반복여부 체크하는 변수
        String resultStr;       // 사용자의 선택값을 담을 변수
        int result = 0;         // resultStr를 int 로 변환해 사용자의 선택값을 담을 변수

        // 아이템 객체 생성
        Item item = new Item();

        if(User.getProperty() >= item.getCakePrice())  // 체력 증가 가격보다 보유한 코인이 많거나 같으면
        {
            User.setProperty(User.getProperty() - item.getCakePrice());    // 계산하고
            Item.setCake(Item.getCake()+1); // 보유한 개수에 추가

            System.out.println("========================================================================");
            System.out.printf(" %d 코인을 사용했습니다.\n", item.getCakePrice());
            System.out.printf(" 보유 코인      : %d코인\n", User.getProperty());
            System.out.printf(" 보유 케이크     : %d개 \n", Item.getCake() );
            System.out.println("========================================================================");

            final int REPURCHASE = 1;   // 재구매
            final int EXIT = 2;         // 이전으로

            while(check)
            {
                System.out.println(" 1.재구매(동일 아이템) 2.이전으로");
                System.out.println("------------------------------------------------------------------------");
                Scanner sc = new Scanner(System.in);
                System.out.print(" 선택 : ");
                resultStr = sc.nextLine();

                // 입력받은 값이 숫자인지 확인
                try
                {
                    // 입력받은 값의 공백을 제거하고
                    // 자료형 변경한 뒤(String → int) int형에 담는다.
                    result = Integer.parseInt(resultStr.replace(" ",""));
                    check = false;
                    // int 형으로 변경되면 check 에 false 담아서 반복문 빠져나간다.
                    // int형으로 변경되지 않는다면 NumberFormatException 발생
                }
                catch (NumberFormatException e) // NumberFormatException 발생한다면
                {
                    check = true;   // check 에 true 담아서 다시 반복
                    // result = 0; 으로 초기화된 상태이므로  하단 if문 내부까지 실행하고 반복된다.
                }

                if(result < 1 || result > 2 )// 주어진 값 이외의 수를 선택한 경우
                {
                    System.out.println("========================================================================");
                    System.out.println(" 올바른 값을 입력해주세요.");
                    check = true;
                }

                switch(result)
                {
                    case REPURCHASE: buyCake();   // 재구매
                        break;

                    case EXIT: buyPermanentItem(); // 이전으로
                        break;
                }
            }
        }
        else
        {
            System.out.println("========================================================================");
            System.out.println(" 보유한 코인으로 케이크를 구매할 수 없습니다.");
            System.out.printf(" 현재 보유 코인      : %d코인\n", User.getProperty());
            System.out.println();
            buyConsumableItem(); // 이전으로
        }

    }// end buyCake()

    // 샌드위치 구매 메소드
    public void buySandwich()
    {
        boolean check = true;   // 반복여부 체크하는 변수
        String resultStr;       // 사용자의 선택값을 담을 변수
        int result = 0;         // resultStr를 int 로 변환해 사용자의 선택값을 담을 변수

        // 아이템 객체 생성
        Item item = new Item();

        if(User.getProperty() >= item.getSandwichPrice())  // 체력 증가 가격보다 보유한 코인이 많거나 같으면
        {
            User.setProperty(User.getProperty() - item.getSandwichPrice());    // 계산하고
            Item.setSandwich(Item.getSandwich()+1); // 보유한 개수에 추가

            System.out.println("========================================================================");
            System.out.printf(" %d 코인을 사용했습니다.\n", item.getSandwichPrice());
            System.out.printf(" 보유 코인      : %d코인\n", User.getProperty());
            System.out.printf(" 보유 케이크     : %d개 \n", Item.getSandwich() );
            System.out.println("========================================================================");

            final int REPURCHASE = 1;   // 재구매
            final int EXIT = 2;         // 이전으로

            while(check)
            {
                System.out.println(" 1.재구매(동일 아이템) 2.이전으로");
                System.out.println("------------------------------------------------------------------------");
                Scanner sc = new Scanner(System.in);
                System.out.print(" 선택 : ");
                resultStr = sc.nextLine();

                // 입력받은 값이 숫자인지 확인
                try
                {
                    // 입력받은 값의 공백을 제거하고
                    // 자료형 변경한 뒤(String → int) int형에 담는다.
                    result = Integer.parseInt(resultStr.replace(" ",""));
                    check = false;
                    // int 형으로 변경되면 check 에 false 담아서 반복문 빠져나간다.
                    // int형으로 변경되지 않는다면 NumberFormatException 발생
                }
                catch (NumberFormatException e) // NumberFormatException 발생한다면
                {
                    check = true;   // check 에 true 담아서 다시 반복
                    // result = 0; 으로 초기화된 상태이므로  하단 if문 내부까지 실행하고 반복된다.
                }

                if(result < 1 || result > 2 )// 주어진 값 이외의 수를 선택한 경우
                {
                    System.out.println("========================================================================");
                    System.out.println(" 올바른 값을 입력해주세요.");
                    check = true;
                }

                switch(result)
                {
                    case REPURCHASE: buySandwich();   // 재구매
                        break;

                    case EXIT: buyPermanentItem(); // 이전으로
                        break;
                }
            }
        }
        else
        {
            System.out.println("========================================================================");
            System.out.println(" 보유한 코인으로 샌드위치를 구매할 수 없습니다.");
            System.out.printf(" 현재 보유 코인      : %d코인\n", User.getProperty());
            System.out.println();
            buyConsumableItem(); // 이전으로
        }

    }// end buySandwich()

    // 초콜릿 구매 메소드
    public void buyChoco()
    {
        boolean check = true;   // 반복여부 체크하는 변수
        String resultStr;       // 사용자의 선택값을 담을 변수
        int result = 0;         // resultStr를 int 로 변환해 사용자의 선택값을 담을 변수

        // 아이템 객체 생성
        Item item = new Item();

        if(User.getProperty() >= item.getChocoPrice())  // 초콜릿 가격보다 보유한 코인이 많거나 같으면
        {
            User.setProperty(User.getProperty() - item.getChocoPrice());    // 계산하고
            Item.setChoco(Item.getChoco()+1); // 보유한 초콜릿 개수 1 증가

            System.out.println("========================================================================");
            System.out.printf(" %d 코인을 사용했습니다.\n", item.getChocoPrice());
            System.out.printf(" 보유 코인      : %d코인\n", User.getProperty());
            System.out.printf(" 보유 케이크     : %d개 \n", Item.getChoco() );
            System.out.println("========================================================================");

            final int REPURCHASE = 1;   // 재구매
            final int EXIT = 2;         // 이전으로

            while(check)
            {
                System.out.println(" 1.재구매(동일 아이템) 2.이전으로");
                System.out.println("------------------------------------------------------------------------");
                Scanner sc = new Scanner(System.in);
                System.out.print(" 선택 : ");
                resultStr = sc.nextLine();

                // 입력받은 값이 숫자인지 확인
                try
                {
                    // 입력받은 값의 공백을 제거하고
                    // 자료형 변경한 뒤(String → int) int형에 담는다.
                    result = Integer.parseInt(resultStr.replace(" ",""));
                    check = false;
                    // int 형으로 변경되면 check 에 false 담아서 반복문 빠져나간다.
                    // int형으로 변경되지 않는다면 NumberFormatException 발생
                }
                catch (NumberFormatException e) // NumberFormatException 발생한다면
                {
                    check = true;   // check 에 true 담아서 다시 반복
                    // result = 0; 으로 초기화된 상태이므로  하단 if문 내부까지 실행하고 반복된다.
                }

                if(result < 1 || result > 2 )// 주어진 값 이외의 수를 선택한 경우
                {
                    System.out.println("========================================================================");
                    System.out.println(" 올바른 값을 입력해주세요.");
                    check = true;
                }

                switch(result)
                {
                    case REPURCHASE: buyChoco();   // 재구매
                        break;

                    case EXIT: buyPermanentItem(); // 이전으로
                        break;
                }
            }
        }
        else
        {
            System.out.println("========================================================================");
            System.out.println(" 보유한 코인으로 초콜릿을 구매할 수 없습니다.");
            System.out.printf(" 현재 보유 코인      : %d코인\n", User.getProperty());
            System.out.println();
            buyConsumableItem(); // 이전으로
        }

    }// end buyChoco()

    // 마카롱 구매 메소드
    public void buyMacaron()
    {
        boolean check = true;   // 반복여부 체크하는 변수
        String resultStr;       // 사용자의 선택값을 담을 변수
        int result = 0;         // resultStr를 int 로 변환해 사용자의 선택값을 담을 변수

        // 아이템 객체 생성
        Item item = new Item();

        if(User.getProperty() >= item.getMacaronPrice())  // 체력 증가 가격보다 보유한 코인이 많거나 같으면
        {
            User.setProperty(User.getProperty() - item.getMacaronPrice());    // 계산하고
            Item.setMacaron(Item.getMacaron()+1); // 보유한 개수에 추가

            System.out.println("========================================================================");
            System.out.printf(" %d 코인을 사용했습니다.\n", item.getMacaronPrice());
            System.out.printf(" 보유 코인      : %d코인\n", User.getProperty());
            System.out.printf(" 보유 케이크     : %d개 \n", Item.getMacaron() );
            System.out.println("========================================================================");

            final int REPURCHASE = 1;   // 재구매
            final int EXIT = 2;         // 이전으로

            while(check)
            {
                System.out.println(" 1.재구매(동일 아이템) 2.이전으로");
                System.out.println("------------------------------------------------------------------------");
                Scanner sc = new Scanner(System.in);
                System.out.print(" 선택 : ");
                resultStr = sc.nextLine();

                // 입력받은 값이 숫자인지 확인
                try
                {
                    // 입력받은 값의 공백을 제거하고
                    // 자료형 변경한 뒤(String → int) int형에 담는다.
                    result = Integer.parseInt(resultStr.replace(" ",""));
                    check = false;
                    // int 형으로 변경되면 check 에 false 담아서 반복문 빠져나간다.
                    // int형으로 변경되지 않는다면 NumberFormatException 발생
                }
                catch (NumberFormatException e) // NumberFormatException 발생한다면
                {
                    check = true;   // check 에 true 담아서 다시 반복
                    // result = 0; 으로 초기화된 상태이므로  하단 if문 내부까지 실행하고 반복된다.
                }

                if(result < 1 || result > 2 )// 주어진 값 이외의 수를 선택한 경우
                {
                    System.out.println("========================================================================");
                    System.out.println(" 올바른 값을 입력해주세요.");
                    check = true;
                }

                switch(result)
                {
                    case REPURCHASE: buyMacaron();   // 재구매
                        break;

                    case EXIT: buyPermanentItem(); // 이전으로
                        break;
                }
            }
        }
        else
        {
            System.out.println("========================================================================");
            System.out.println(" 보유한 코인으로 마카롱을 구매할 수 없습니다.");
            System.out.printf(" 현재 보유 코인      : %d코인\n", User.getProperty());
            System.out.println();
            buyConsumableItem(); // 이전으로
        }

    }// end buyMacaron()

// 공개된 엔딩 확인하기 ---------------------------------------------------------------------------------------------------

    public void openEnding()
    {
        int[] endings = User.getEndings();  // 공개된 엔딩 유형 저장한 배열 불러오기

        if(endings[0]==0)                       // 첫번째 배열 칸이 0 이면 공개된 엔딩이 없다는 뜻이다.
        {
            System.out.println("========================================================================");
            System.out.println(" 현재 공개된 엔딩이 없습니다.");
            CafeAction cafeAction = new CafeAction();
            cafeAction.weekend(); // 이전으로
        }
        else    // 공개된 엔딩이 있으면
        {
            final int FALL_DOWN_ENDING = 1; // 쓰러지는 엔딩
            final int QUIT_ENDING = 2;      // 그만두는 엔딩
            final int SCOUT_ENDING = 3;     // 스카웃 엔딩
            final int BOSS_ENDING = 4;      // 사장 엔딩
            final int GET_FIRE_ENDING = 5;  // 해고 엔딩
            final int PARTIMER_ENDING = 6;  // 알바 엔딩

            System.out.println("                         ╔═══━━━─────────━━━═══╗                         ");
            System.out.println("=========================       공개된 엔딩      =========================");
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
                    System.out.println("    아이템을 이용해서 체력과 인내력을 관리해주세요 ! ");
                    System.out.println("------------------------------------------------------------------------");
                }

                if (endingType == SCOUT_ENDING)
                {
                    System.out.println(" [이직 엔딩] 종종 방문하던 특이한 손님의 일부는 몰래 방문한 인근 카페 사장이었습니다.");
                    System.out.printf("                %s님을 시험하고 눈여겨본 사장은 %s님을 스카웃했습니다. \n", User.getName());
                    System.out.println("------------------------------------------------------------------------");
                    System.out.println(" ✨ 이직 엔딩 tip ✨ ");
                    System.out.println("    숙련도가 4이상 이고 비밀 손님의 방문이 4회 이상이면 이직 엔딩의 조건이 달성됩니다. ");
                    System.out.println("------------------------------------------------------------------------");
                }

                if (endingType == BOSS_ENDING)
                {
                    System.out.printf(" [사장 엔딩] 코인을 아끼며 열심히 일한 %s님은 모은 코인으로 카페를 차렸습니다.\n", User.getName());
                    System.out.printf("            %s님은 더이상 알바생이 아닙니다.\n", User.getName());
                    System.out.println("------------------------------------------------------------------------");
                    System.out.println(" ✨ 사장 엔딩 tip ✨ ");
                    System.out.println("    보유하고 있는 코인이 10개 이상이고 ");
                    System.out.println("    방문한 손님 수가 30명 이상이면 사장 엔딩의 조건이 달성됩니다.");
                    System.out.println("------------------------------------------------------------------------");
                }

                if (endingType == GET_FIRE_ENDING)
                {
                    System.out.printf(" [해고 엔딩] %s님은 음료를 제조하지 못해서 해고되었습니다.\n", User.getName());
                    System.out.printf("            괜찮습니다 카페는 많으니까요... 힘내세요! \n", User.getName());
                    System.out.println("------------------------------------------------------------------------");
                    System.out.println(" ✨ 해고 엔딩 tip ✨ ");
                    System.out.println("    음료제조 성공 횟수보다 실패 횟수가 많아지면 엔딩의 조건이 달성됩니다.");
                    System.out.println("------------------------------------------------------------------------");
                }
                if (endingType == PARTIMER_ENDING)
                {
                    System.out.printf(" [알바 엔딩] %s님은 카페 아르바이트를 능숙하게 해내고 있습니다.\n", User.getName());
                    System.out.println("------------------------------------------------------------------------");
                    System.out.println(" ✨ 알바 엔딩 tip ✨ ");
                    System.out.println("    나머지 엔딩에 해당하지 않으면 알바 엔딩의 조건이 달성됩니다.");
                    System.out.println("    그만큼 잘 맞는다는거겠죠?  ");
                    System.out.println("------------------------------------------------------------------------");
                }
                
            }

            System.out.printf(" 아직 공개되지 않은 엔딩이 %d개 남아있습니다 !\n", cnt);
        }

        CafeAction cafeAction = new CafeAction();
        cafeAction.weekend();  // 이전으로

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
        System.out.println(" 마카롱    : 인내력을 4 회복합니다. ");
        System.out.println();
        System.out.println("------------------------------------------------------------------------");
        System.out.println();
        System.out.printf(" 케이크   : %d개\n", Item.getCake());
        System.out.printf(" 샌드위치 : %d개\n", Item.getSandwich());
        System.out.printf(" 초콜릿   : %d개\n", Item.getChoco());
        System.out.printf(" 마카롱   : %d개\n", Item.getMacaron());
        System.out.println();
        System.out.println("========================================================================");

        useItem();  // 아이템 사용 메소드
    }

    public void useItem()// 아이템 사용 메소드
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
              // 입력받은 값의 공백을 제거하고
              // 자료형 변경한 뒤(String → int) int형에 담는다.
              result = Integer.parseInt(resultStr.replace(" ",""));
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
        switch (result)
        {
            case CAKE: useCake();           // 케이크 사용
                break;

            case SANDWICH: useSandwich();   // 샌드위치 사용
                break;

            case CHOCO: useChoco();         // 초콜릿 사용
                break;

            case MACARON: useMacaron();     // 마카롱 사용
                break;

            case EXIT:  // 이전으로
                CafeAction cafeAction = new CafeAction();
                cafeAction.selBusiness();
                break;
        }

    } // end useItem()

    public void useCake()
    {
        boolean check = true;   // 반복여부 체크하는 변수
        String resultStr;       // 사용자의 선택값을 담을 변수
        int result = 0;         // resultStr를 int 로 변환해 사용자의 선택값을 담을 변수

        if(Item.getCake() > 0)  // 보유한 케이크 수가 0보다 크다면
        {
            Item.setCake(Item.getCake() - 1);           // 보유한 개수에서 하나 감소
            User.setHp(User.getHp() + 2 );   // 현재 체력에서 2 회복

            System.out.println("========================================================================");
            System.out.println(" 케이크를 사용했습니다.");
            System.out.println(" 체력이 2 회복되었습니다.");
            System.out.printf(" 보유 케이크   : %d개 \n", Item.getCake());
            System.out.printf(" 현재 체력     : %d\n", User.getHp());
            System.out.println("========================================================================");

            final int REUSE = 1;   // 재사용
            final int EXIT = 2;         // 이전으로

            while(check)
            {
                System.out.println(" 1.재사용(동일 아이템) 2.이전으로");
                System.out.println("------------------------------------------------------------------------");
                Scanner sc = new Scanner(System.in);
                System.out.print(" 선택 : ");
                resultStr = sc.nextLine();

                // 입력받은 값이 숫자인지 확인
                try
                {
                    // 입력받은 값의 공백을 제거하고
                    // 자료형 변경한 뒤(String → int) int형에 담는다.
                    result = Integer.parseInt(resultStr.replace(" ",""));
                    check = false;
                    // int 형으로 변경되면 check 에 false 담아서 반복문 빠져나간다.
                    // int형으로 변경되지 않는다면 NumberFormatException 발생
                }
                catch (NumberFormatException e) // NumberFormatException 발생한다면
                {
                    check = true;   // check 에 true 담아서 다시 반복
                    // result = 0; 으로 초기화된 상태이므로  하단 if문 내부까지 실행하고 반복된다.
                }

                if(result < 1 || result > 2 )// 주어진 값 이외의 수를 선택한 경우
                {
                    System.out.println("========================================================================");
                    System.out.println(" 올바른 값을 입력해주세요.");
                    check = true;
                }

                switch(result)
                {
                    case REUSE: useCake();   // 재사용
                        break;

                    case EXIT: useItem(); // 이전으로
                        break;
                }
            }
        }
        else
        {
            System.out.println(" 보유한 케이크가 없습니다.");
            System.out.println("========================================================================");
            useItem(); // 이전으로

        }
    }

    public void useSandwich()
    {
        boolean check = true;   // 반복여부 체크하는 변수
        String resultStr;       // 사용자의 선택값을 담을 변수
        int result = 0;         // resultStr를 int 로 변환해 사용자의 선택값을 담을 변수

        if(Item.getSandwich() > 0)  // 보유한 샌드위치 수가 0보다 크다면
        {
            Item.setSandwich(Item.getSandwich() - 1);        // 보유한 개수에서 하나 감소
            User.setHp(User.getHp() + 4 );           // 현재 체력에서 4 회복

            System.out.println("========================================================================");
            System.out.println(" 샌드위치를 사용했습니다.");
            System.out.println(" 체력이 4 회복되었습니다.");
            System.out.printf(" 보유 샌드위치   : %d개 \n", Item.getSandwich());
            System.out.printf(" 현재 체력      : %d\n", User.getHp());
            System.out.println("========================================================================");

            final int REUSE = 1;   // 재사용
            final int EXIT = 2;    // 이전으로

            while(check)
            {
                System.out.println(" 1.재사용(동일 아이템) 2.이전으로");
                System.out.println("------------------------------------------------------------------------");
                Scanner sc = new Scanner(System.in);
                System.out.print(" 선택 : ");
                resultStr = sc.nextLine();

                // 입력받은 값이 숫자인지 확인
                try
                {
                    // 입력받은 값의 공백을 제거하고
                    // 자료형 변경한 뒤(String → int) int형에 담는다.
                    result = Integer.parseInt(resultStr.replace(" ",""));
                    check = false;
                    // int 형으로 변경되면 check 에 false 담아서 반복문 빠져나간다.
                    // int형으로 변경되지 않는다면 NumberFormatException 발생
                }
                catch (NumberFormatException e) // NumberFormatException 발생한다면
                {
                    check = true;   // check 에 true 담아서 다시 반복
                    // result = 0; 으로 초기화된 상태이므로  하단 if문 내부까지 실행하고 반복된다.
                }

                if(result < 1 || result > 2 )// 주어진 값 이외의 수를 선택한 경우
                {
                    System.out.println("========================================================================");
                    System.out.println(" 올바른 값을 입력해주세요.");
                    check = true;
                }

                switch(result)
                {
                    case REUSE: useSandwich();   // 재사용
                        break;

                    case EXIT: useItem(); // 이전으로
                        break;
                }
            }
        }
        else
        {
            System.out.println(" 보유한 샌드위치가 없습니다.");
            System.out.println("========================================================================");
            useItem(); // 이전으로
        }
    }

    public void useChoco()
    {
        boolean check = true;   // 반복여부 체크하는 변수
        String resultStr;       // 사용자의 선택값을 담을 변수
        int result = 0;         // resultStr를 int 로 변환해 사용자의 선택값을 담을 변수

        if(Item.getChoco() > 0)  // 보유한 초콜릿 수가 0보다 크다면
        {
            Item.setChoco(Item.getChoco() - 1);                 // 보유한 개수에서 하나 감소
            User.setFeeling(User.getFeeling() + 2 );    // 현재 인내력에서 2 회복

            System.out.println("========================================================================");
            System.out.println(" 초콜릿을 사용했습니다.");
            System.out.println(" 인내력이 2 회복되었습니다.");
            System.out.printf(" 보유 초콜릿   : %d개 \n", Item.getChoco());
            System.out.printf(" 현재 인내력   : %d\n", User.getFeeling());
            System.out.println("========================================================================");

            final int REUSE = 1;   // 재사용
            final int EXIT = 2;    // 이전으로

            while(check)
            {
                System.out.println(" 1.재사용(동일 아이템) 2.이전으로");
                System.out.println("------------------------------------------------------------------------");
                Scanner sc = new Scanner(System.in);
                System.out.print(" 선택 : ");
                resultStr = sc.nextLine();

                // 입력받은 값이 숫자인지 확인
                try
                {
                    // 입력받은 값의 공백을 제거하고
                    // 자료형 변경한 뒤(String → int) int형에 담는다.
                    result = Integer.parseInt(resultStr.replace(" ",""));
                    check = false;
                    // int 형으로 변경되면 check 에 false 담아서 반복문 빠져나간다.
                    // int형으로 변경되지 않는다면 NumberFormatException 발생
                }
                catch (NumberFormatException e) // NumberFormatException 발생한다면
                {
                    check = true;   // check 에 true 담아서 다시 반복
                    // result = 0; 으로 초기화된 상태이므로  하단 if문 내부까지 실행하고 반복된다.
                }

                if(result < 1 || result > 2 )// 주어진 값 이외의 수를 선택한 경우
                {
                    System.out.println("========================================================================");
                    System.out.println(" 올바른 값을 입력해주세요.");
                    check = true;
                }

                switch(result)
                {
                    case REUSE: useChoco();   // 재사용
                        break;

                    case EXIT: useItem(); // 이전으로
                        break;
                }
            }
        }
        else
        {
            System.out.println(" 보유한 초콜릿이 없습니다.");
            System.out.println("========================================================================");
            useItem(); // 이전으로
        }
    }

    public void useMacaron()
    {
        boolean check = true;   // 반복여부 체크하는 변수
        String resultStr;       // 사용자의 선택값을 담을 변수
        int result = 0;         // resultStr를 int 로 변환해 사용자의 선택값을 담을 변수

        if(Item.getMacaron() > 0)  // 보유한 마카롱 수가 0보다 크다면
        {
            Item.setMacaron(Item.getMacaron() - 1);             // 보유한 개수에서 하나 감소
            User.setFeeling(User.getFeeling() + 4 );    // 현재 인내력에서 4 회복

            System.out.println("========================================================================");
            System.out.println(" 마카롱을 사용했습니다.");
            System.out.println(" 인내력이 4 회복되었습니다.");
            System.out.printf(" 보유 마카롱  : %d개 \n", Item.getMacaron());
            System.out.printf(" 현재 인내력  : %d\n", User.getFeeling());
            System.out.println("========================================================================");

            final int REUSE = 1;   // 재사용
            final int EXIT = 2;    // 이전으로

            while(check)
            {
                System.out.println(" 1.재사용(동일 아이템) 2.이전으로");
                System.out.println("------------------------------------------------------------------------");
                Scanner sc = new Scanner(System.in);
                System.out.print(" 선택 : ");
                resultStr = sc.nextLine();

                // 입력받은 값이 숫자인지 확인
                try
                {
                    // 입력받은 값의 공백을 제거하고
                    // 자료형 변경한 뒤(String → int) int형에 담는다.
                    result = Integer.parseInt(resultStr.replace(" ",""));
                    check = false;
                    // int 형으로 변경되면 check 에 false 담아서 반복문 빠져나간다.
                    // int형으로 변경되지 않는다면 NumberFormatException 발생
                }
                catch (NumberFormatException e) // NumberFormatException 발생한다면
                {
                    check = true;   // check 에 true 담아서 다시 반복
                    // result = 0; 으로 초기화된 상태이므로  하단 if문 내부까지 실행하고 반복된다.
                }

                if(result < 1 || result > 2 )// 주어진 값 이외의 수를 선택한 경우
                {
                    System.out.println("========================================================================");
                    System.out.println(" 올바른 값을 입력해주세요.");
                    check = true;
                }

                switch(result)
                {
                    case REUSE: useMacaron();   // 재사용
                        break;

                    case EXIT: useItem(); // 이전으로
                        break;
                }
            }
        }
        else
        {
            System.out.println(" 보유한 마카롱이 없습니다.");
            System.out.println("========================================================================");
            useItem(); // 이전으로
        }
    }

}// end class









