package com.company.run;
import java.util.Scanner;

import com.company.cafe.Cafe;
import com.company.cafe.CafeAction;
import com.company.cafe.Item;
import com.company.character.Partimer;
import java.util.regex.Pattern;

// 선택지에 따른 출력을 실행하는 클래스
public class Run
{
    // int result;          → 인스턴스 변수
    // static int result;   → 클래스 변수

    // 1.초기화면 실행하는 메소드
    public int initialRun()
    {
        // 반환값을 담을 변수 선언
        // 초기화해야하는 이유  : 지역변수는 자동으로 초기화가 안된다. 클래스 변수와 인스턴스 변수는 자료형에 맞게 기본값으로 초기화된다.
        // → 예측할 수 없는 값을 담는걸 방지하기 위해
        String resultStr;
        int result = 0;

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

        Partimer.setName(userName);         // 입력받은 유저이름 속성에 넣기

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
        System.out.printf("\t\t。\t\t\t %s님은 결국 추방당했습니다 . . .     .          。\n", Partimer.getName());
        System.out.println(",　　　　　　　　　.　 .　　　　　　　　.");
        System.out.println("　　　　　。　　　　　　　　　　　　　　　　　　　ﾟ　　　　　　　　　。");
        System.out.println("　　.　　　　　　　　.　　　　　.　　　　　　　　　　。　　.");
        System.out.println();
        System.out.println();
        System.out.println();


        System.out.println();
        System.out.println();
        System.out.printf(" %s님은 오늘부터 카페 아르바이트를 시작했습니다.\n", Partimer.getName());
        System.out.println(" 아르바이트를 진행하면서 다양한 엔딩을 볼 수 있습니다.");

        // 올바른 선택지를 선택할 때까지 반복
        while(check) // check 는 위에서 입력받은 유저이름이 한글인걸 확인했기 때문에 true 인 상황이다.
        {
            System.out.println("========================================================================");
            System.out.println(" 1. 시작하기  2.처음부터 다시하기 ");
            System.out.println("------------------------------------------------------------------------");
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

            if(result < 1 || result > 2 )// 주어진 값 이외의 수를 선택한 경우
            {
                System.out.println("========================================================================");
                System.out.println(" 올바른 값을 입력해주세요.");
                check = true;
            }
        }

        return result;

    } //end initialRun()

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
            System.out.printf(" 1. %s님의 정보 보기  2.카페정보 보기 3.이전 화면 \n", Partimer.getName());
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
        int week = (Partimer.getWorkingDays() / 7) + 1;               // 주차 = 일한날짜/7 + 1
        System.out.println("                         ╔═══━━━─────────━━━═══╗                         ");
        System.out.printf("==========================     %d주차   정보      =========================\n", week);
        System.out.println("                         ╚═══━━━─────────━━━═══╝                         ");
        System.out.println();
        System.out.println(" 설정값 : 최대 능력치입니다. 아이템을 통해 증가시킬 수 있습니다.");
        System.out.println("         능력치는 주말마다 설정값으로 초기화됩니다. ");
        System.out.println("------------------------------------------------------------------------");
        System.out.printf(" %s님의 인내력 : %d\n",Partimer.getName(), Partimer.getSetFeeling());
        System.out.printf(" %s님의 체력 : %d\n", Partimer.getName(), Partimer.getSetHp());
        System.out.println("------------------------------------------------------------------------");
        System.out.println(" 숙련도 : 음료 제조 성공 확률과 카페 운영 기간을 고려하여 ");
        System.out.println("         주말마다 숙련도가 업데이트됩니다.");
        System.out.println("------------------------------------------------------------------------");
        System.out.printf(" %s님의 숙련도 : %d\n ", Partimer.getName(),Partimer.getSkillLevel());
        System.out.println("========================================================================");

        info(); // 이전으로

    }// end myInfo()

    public void cafeInfo()  // 카페 정보
    {
        int week = (Partimer.getWorkingDays() / 7) + 1;               // 주차 = 일한날짜/7 + 1
        System.out.println("                         ╔═══━━━─────────━━━═══╗                         ");
        System.out.printf("==========================    %d주차  카페 정보    =========================\n", week);
        System.out.println("                         ╚═══━━━─────────━━━═══╝                         ");
        System.out.println();
        System.out.println(" 의자 : 카페에 존재하는 의자의 수입니다. 의자는 설정된 값으로 매일 초기화됩니다. ");
        System.out.println("       매장에서 음료를 마시길 원하는 손님은 의자가 없으면 카페를 나갑니다.");
        System.out.println("       아이템 구매를 통해 의자의 수를 늘릴 수 있습니다. ");
        System.out.println("------------------------------------------------------------------------");
        System.out.println(" 유리잔 : 매장 내 취식하는 손님이 차가운 음료를 마실 경우 사용하는 잔입니다. ");
        System.out.println("         알맞은 잔이 없을 경우 컴플레인이 들어오고, 유저의 인내력이 1 감소합니다. ");
        System.out.println("         아이템 구매를 통해 유리잔의 수를 늘릴 수 있습니다. ");
        System.out.println("------------------------------------------------------------------------");
        System.out.println(" 머그잔 : 매장 내 취식하는 손님이 따뜻한 음료를 마실 경우 사용하는 잔입니다. ");
        System.out.println("         알맞은 잔이 없을 경우 컴플레인이 들어오고, 유저의 인내력이 1 감소합니다. ");
        System.out.println("         아이템 구매를 통해 머그잔의 수를 늘릴 수 있습니다. ");
        System.out.println("------------------------------------------------------------------------");
        System.out.printf(" 의자의 수   : %d\n", Cafe.getSetChair());
        System.out.printf(" 유리잔의 수 : %d\n ", Cafe.getSetCup());
        System.out.printf(" 머그잔의 수 : %d\n ", Cafe.getSetMug());
        System.out.println("========================================================================");
        System.out.println();

        info(); // 이전으로

    }

// 주말 상점가기 메소드----------------------------------------------------------------------------------------------------------

    // 상점가기 메소드 1.아이템 구입 2.보유 아이템 3.이전 화면
    public void goShop()
    {
        boolean check = true;   // 반복여부 체크하는 변수
        String resultStr;       // 사용자의 선택값을 담을 변수(1. 정보 확인  2.상점가기 3.모은 엔딩 확인)
        int result = 0;         // resultStr를 int 로 변환해 사용자의 선택값을 담을 변수

        final int BUY_ITEM = 1;
        final int MY_ITEM = 2;
        final int EXIT = 3;

        while(check)
        {
            System.out.println("========================================================================");
            System.out.println(" 1.아이템 구입  2.보유 아이템  3.이전 화면 ");
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

        CafeAction cafeAction = new CafeAction();

        switch(result)
        {
            case  BUY_ITEM: buyItem(); // 아이템 구입
                break;

            case  MY_ITEM:      // 보유 아이템 정보 보기
                break;

            case EXIT:  cafeAction.weekend();   // 주말 초기화면 호출
                break;
        }

    }

    public void buyItem()   // 아이템 구입하기
    {
        System.out.println("                         ╔═══━━━─────────━━━═══╗                         ");
        System.out.println("==========================     아이템  구매      ==========================");
        System.out.println("                         ╚═══━━━─────────━━━═══╝                         ");
        System.out.println();
        System.out.printf(" 현재 %s님이 보유하고 있는 코인 : %d코인\n", Partimer.getName(), Partimer.getProperty());
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

            case EXIT:  goShop();   // 상점 초기화면 호출
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

        // 아이템 객체 생성
        Item item = new Item();

        while(check)
        {

            System.out.printf(" 1.의자 구매         (- %d코인\n)", item.getChairPrice());
            System.out.printf(" 2.유리잔 구매       (- %d코인)\n", item.getCupPrice());
            System.out.printf(" 3.머그잔 구매       (- %d코인)\n", item.getMugPrice());
            System.out.printf(" 4.체력 +2          (- %d코인)\n", item.getHpPrice());
            System.out.printf(" 5.인내력 +2        (- %d코인)\n", item.getFeelingPrice());
            System.out.println(" 6.이전으로");
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

            case EXIT : goShop();   // 상점 초기화면 호출
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

        if(Partimer.getProperty() >= item.getChairPrice())  // 의자 가격보다 보유한 코인이 많거나 같으면
        {
            Partimer.setProperty(Partimer.getProperty() - item.getChairPrice());    // 계산하고
            Cafe.setSetChair(Cafe.getSetChair()+1); // 의자 설정값 추가

            System.out.println("========================================================================");
            System.out.printf(" %d 코인을 사용했습니다.\n", item.getChairPrice());
            System.out.printf(" 보유 코인      : %d코인\n", Partimer.getProperty());
            System.out.printf(" 카페 의자 수   : %d \n", Cafe.getSetChair() );
            System.out.println("========================================================================");

            final int REPURCHASE = 1;   // 재구매
            final int EXIT = 2;         // 이전으로

            while(check)
            {
                System.out.println("========================================================================");
                System.out.println(" 1.재구매(동일 아이템) 2.이전으로");
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
            System.out.printf(" 보유 코인      : %d코인\n", Partimer.getProperty());
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

        if(Partimer.getProperty() >= item.getCupPrice())  // 유리잔 가격보다 보유한 코인이 많거나 같으면
        {
            Partimer.setProperty(Partimer.getProperty() - item.getCupPrice());    // 계산하고
            Cafe.setSetCup(Cafe.getSetCup()+1); // 유리잔 설정값 추가

            System.out.println("========================================================================");
            System.out.printf(" %d 코인을 사용했습니다.\n", item.getChairPrice());
            System.out.printf(" 보유 코인      : %d코인\n", Partimer.getProperty());
            System.out.printf(" 카페 유리잔 수   : %d \n", Cafe.getSetCup() );
            System.out.println("========================================================================");

            final int REPURCHASE = 1;   // 재구매
            final int EXIT = 2;         // 이전으로

            while(check)
            {
                System.out.println("========================================================================");
                System.out.println(" 1.재구매(동일 아이템) 2.이전으로");
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
            System.out.printf(" 보유 코인      : %d코인\n", Partimer.getProperty());
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

        if(Partimer.getProperty() >= item.getMugPrice())  // 머그잔 가격보다 보유한 코인이 많거나 같으면
        {
            Partimer.setProperty(Partimer.getProperty() - item.getMugPrice());    // 계산하고
            Cafe.setSetMug(Cafe.getSetMug()+1); // 머그잔 설정값 추가

            System.out.println("========================================================================");
            System.out.printf(" %d 코인을 사용했습니다.\n", item.getChairPrice());
            System.out.printf(" 보유 코인      : %d코인\n", Partimer.getProperty());
            System.out.printf(" 카페 머그잔 수   : %d \n", Cafe.getSetMug() );
            System.out.println("========================================================================");

            final int REPURCHASE = 1;   // 재구매
            final int EXIT = 2;         // 이전으로

            while(check)
            {
                System.out.println("========================================================================");
                System.out.println(" 1.재구매(동일 아이템) 2.이전으로");
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
            System.out.printf(" 현재 보유 코인      : %d코인\n", Partimer.getProperty());
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

        if(Partimer.getProperty() >= item.getHpPrice())  // 체력 증가 가격보다 보유한 코인이 많거나 같으면
        {
            Partimer.setProperty(Partimer.getProperty() - item.getHpPrice());    // 계산하고
            Partimer.setSetHp(Partimer.getSetHp()+1); // 체력 설정값 추가

            System.out.println("========================================================================");
            System.out.printf(" %d 코인을 사용했습니다.\n", item.getHpPrice());
            System.out.printf(" 보유 코인      : %d코인\n", Partimer.getProperty());
            System.out.printf(" 체력          : %d \n", Partimer.getSetHp() );
            System.out.println("========================================================================");

            final int REPURCHASE = 1;   // 재구매
            final int EXIT = 2;         // 이전으로

            while(check)
            {
                System.out.println("========================================================================");
                System.out.println(" 1.재구매(동일 아이템) 2.이전으로");
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
            System.out.printf(" 현재 보유 코인      : %d코인\n", Partimer.getProperty());
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

        if(Partimer.getProperty() >= item.getFeelingPrice())  // 체력 증가 가격보다 보유한 코인이 많거나 같으면
        {
            Partimer.setProperty(Partimer.getProperty() - item.getFeelingPrice());    // 계산하고
            Partimer.setSetHp(Partimer.getSetFeeling()+1); // 체력 설정값 추가

            System.out.println("========================================================================");
            System.out.printf(" %d 코인을 사용했습니다.\n", item.getFeelingPrice());
            System.out.printf(" 보유 코인      : %d코인\n", Partimer.getProperty());
            System.out.printf(" 인내력         : %d \n", Partimer.getSetFeeling() );
            System.out.println("========================================================================");

            final int REPURCHASE = 1;   // 재구매
            final int EXIT = 2;         // 이전으로

            while(check)
            {
                System.out.println("========================================================================");
                System.out.println(" 1.재구매(동일 아이템) 2.이전으로");
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
            System.out.printf(" 현재 보유 코인      : %d코인\n", Partimer.getProperty());
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

        // 아이템 객체 생성
        Item item = new Item();

        while (check)
        {

            System.out.printf(" 1.케이크 구매         (- %d코인\n)", item.getCakePrice());
            System.out.printf(" 2.샌드위치 구매       (- %d코인)\n", item.getSandwichPrice());
            System.out.printf(" 3.초콜릿 구매         (- %d코인)\n", item.getChocoPrice());
            System.out.printf(" 4.마카롱 구매         (- %d코인)\n", item.getMacaronPrice());
            System.out.println(" 5.이전으로");
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

            case EXIT: goShop();            // 상점 초기화면 호출
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

        if(Partimer.getProperty() >= item.getCakePrice())  // 체력 증가 가격보다 보유한 코인이 많거나 같으면
        {
            Partimer.setProperty(Partimer.getProperty() - item.getCakePrice());    // 계산하고
            Item.setCake(Item.getCake()+1); // 보유한 개수에 추가

            System.out.println("========================================================================");
            System.out.printf(" %d 코인을 사용했습니다.\n", item.getCakePrice());
            System.out.printf(" 보유 코인      : %d코인\n", Partimer.getProperty());
            System.out.printf(" 보유 케이크     : %d개 \n", Item.getCake() );
            System.out.println("========================================================================");

            final int REPURCHASE = 1;   // 재구매
            final int EXIT = 2;         // 이전으로

            while(check)
            {
                System.out.println("========================================================================");
                System.out.println(" 1.재구매(동일 아이템) 2.이전으로");
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
            System.out.printf(" 현재 보유 코인      : %d코인\n", Partimer.getProperty());
            System.out.println("========================================================================");
            buyPermanentItem(); // 이전으로
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

        if(Partimer.getProperty() >= item.getSandwichPrice())  // 체력 증가 가격보다 보유한 코인이 많거나 같으면
        {
            Partimer.setProperty(Partimer.getProperty() - item.getSandwichPrice());    // 계산하고
            Item.setSandwich(Item.getSandwich()+1); // 보유한 개수에 추가

            System.out.println("========================================================================");
            System.out.printf(" %d 코인을 사용했습니다.\n", item.getSandwichPrice());
            System.out.printf(" 보유 코인      : %d코인\n", Partimer.getProperty());
            System.out.printf(" 보유 케이크     : %d개 \n", Item.getSandwich() );
            System.out.println("========================================================================");

            final int REPURCHASE = 1;   // 재구매
            final int EXIT = 2;         // 이전으로

            while(check)
            {
                System.out.println("========================================================================");
                System.out.println(" 1.재구매(동일 아이템) 2.이전으로");
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
            System.out.printf(" 현재 보유 코인      : %d코인\n", Partimer.getProperty());
            System.out.println("========================================================================");
            buyPermanentItem(); // 이전으로
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

        if(Partimer.getProperty() >= item.getChocoPrice())  // 체력 증가 가격보다 보유한 코인이 많거나 같으면
        {
            Partimer.setProperty(Partimer.getProperty() - item.getChocoPrice());    // 계산하고
            Item.setChoco(Item.getChoco()+1); // 보유한 개수에 추가

            System.out.println("========================================================================");
            System.out.printf(" %d 코인을 사용했습니다.\n", item.getChocoPrice());
            System.out.printf(" 보유 코인      : %d코인\n", Partimer.getProperty());
            System.out.printf(" 보유 케이크     : %d개 \n", Item.getChoco() );
            System.out.println("========================================================================");

            final int REPURCHASE = 1;   // 재구매
            final int EXIT = 2;         // 이전으로

            while(check)
            {
                System.out.println("========================================================================");
                System.out.println(" 1.재구매(동일 아이템) 2.이전으로");
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
            System.out.printf(" 현재 보유 코인      : %d코인\n", Partimer.getProperty());
            System.out.println("========================================================================");
            buyPermanentItem(); // 이전으로
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

        if(Partimer.getProperty() >= item.getMacaronPrice())  // 체력 증가 가격보다 보유한 코인이 많거나 같으면
        {
            Partimer.setProperty(Partimer.getProperty() - item.getMacaronPrice());    // 계산하고
            Item.setMacaron(Item.getMacaron()+1); // 보유한 개수에 추가

            System.out.println("========================================================================");
            System.out.printf(" %d 코인을 사용했습니다.\n", item.getMacaronPrice());
            System.out.printf(" 보유 코인      : %d코인\n", Partimer.getProperty());
            System.out.printf(" 보유 케이크     : %d개 \n", Item.getMacaron() );
            System.out.println("========================================================================");

            final int REPURCHASE = 1;   // 재구매
            final int EXIT = 2;         // 이전으로

            while(check)
            {
                System.out.println("========================================================================");
                System.out.println(" 1.재구매(동일 아이템) 2.이전으로");
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
            System.out.printf(" 현재 보유 코인      : %d코인\n", Partimer.getProperty());
            System.out.println("========================================================================");
            buyPermanentItem(); // 이전으로
        }

    }// end buyMacaron()
    


}// end class









