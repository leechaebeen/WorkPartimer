package com.company.action;

import com.company.data.Cafe;
import com.company.data.Item;
import com.company.data.User;
import com.company.run.GameRun;

import java.util.Scanner;

public class ItemAction
{
    // 구입할 아이템 종류 선택
    public void selectItemType()
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

    // 영구 아이템 구매 메뉴
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

        while(check)
        {
            System.out.println("                         ╔═══━━━─────────━━━═══╗                         ");
            System.out.println("==========================    영구 아이템 구매    ==========================");
            System.out.println("                         ╚═══━━━─────────━━━═══╝                         ");
            System.out.println();
            System.out.println("                             ✨ 현재 보유 정보 ✨");
            System.out.println("------------------------------------------------------------------------");
            System.out.println();
            System.out.printf(" 의자         : %d개\n", Cafe.getSetChairNum());
            System.out.printf(" 유리잔       : %d개\n", Cafe.getSetCupNum());
            System.out.printf(" 머그잔       : %d개\n", Cafe.getSetMugNum());
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

        UserAction userAction = new UserAction();   // 유저 관련 기능 객체 생성

        switch(result)                              // 사용자의 선택 값에 따라서
        {
            case CHAIR:
                Item chair = new Item("의자",2,1);
                userAction.buyItem(chair);
                break;

            case CUP:
                Item cup = new Item("유리잔",2,1);
                userAction.buyItem(cup);
                break;

            case MUG:
                Item mug = new Item("머그잔",2,1);
                userAction.buyItem(mug);
                break;

            case HP:
                Item hp = new Item("체력",4,1);
                userAction.buyItem(hp);
                break;

            case FEELING:
                Item feeling = new Item("인내력",4,1);
                userAction.buyItem(feeling);
                break;

            case EXIT : selectItemType();   // 이전으로
                break;

        }

    }// end buyPermanentItem

    // 소비 아이템 구매 메뉴 
    public void buyConsumableItem()
    {
        boolean check = true;   // 반복여부 체크하는 변수
        String resultStr;       // 사용자의 선택값을 담을 변수
        int result = 0;         // resultStr를 int 로 변환해 사용자의 선택값을 담을 변수

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

            if (result < 1 || result > 5)// 주어진 값 이외의 수를 선택한 경우
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

        UserAction userAction = new UserAction();   // 유저 기능 객체 생성
        switch (result)                             // 사용자의 선택값에 따라
        {
            case CAKE:
                Item cake = new Item("케이크",3,2);
                userAction.buyItem(cake);
                break;

            case SANDWICH:
                Item sandwich = new Item("샌드위치",5,2);
                userAction.buyItem(sandwich);
                break;

            case CHOCO:
                Item choco = new Item("초콜릿",3,2);
                userAction.buyItem(choco);
                break;

            case MACARON:
                Item macaron = new Item("마카롱",5,2);
                userAction.buyItem(macaron);
                break;

            case EXIT: selectItemType();   // 이전으로
                break;

        }
    }


}
