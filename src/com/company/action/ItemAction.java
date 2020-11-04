package com.company.action;

import com.company.data.Cafe;
import com.company.data.Item;
import com.company.data.NewItem;
import com.company.data.User;
import com.company.run.SubRun;

import java.util.Scanner;

public class ItemAction
{
    public void buyItem(NewItem newItem)
    {
        // 매개변수로 받은 객체에서 아이템 유형과 가격 얻기
        int itemPrice = newItem.getPrice();     // 아이템의 가격을 담는 변수
        String itemName = newItem.getName();    // 아이템의 이름을 담는 변수
        int itemType = newItem.getType();       // 아이템의 유형을 담는 변수 (1: 영구아이템, 2: 소비아이템)

        //test
        /*
        System.out.println("itemPrice: " + itemPrice );
        System.out.println("itemName: " + itemName);
        System.out.println("itemType : " + itemType);
        */

        if(User.getProperty() >= itemPrice)  // 아이템 가격보다 보유한 코인이 많거나 같으면
        {
            User.setProperty(User.getProperty() - itemPrice);    // 계산하고

            switch (itemName)
            {
                case "의자":  Cafe.setSetChair(Cafe.getSetChair() + 1); // 의자 개수 추가
                    break;

                case "유리잔": Cafe.setSetCup(Cafe.getSetCup() + 1);     // 유리잔 개수 추가
                    break;

                case "머그잔": Cafe.setSetMug(Cafe.getSetMug() + 1);     // 머그잔 개수 추가
                    break;

                case "체력":  User.setSetHp(User.getSetHp() + 2);        // 체력 추가
                    break;

                case "인내력": User.setSetFeeling(User.getSetFeeling() + 2 );  // 인내력 추가
                    break;

                case "케이크" : User.setCakeNum(User.getCakeNum() + 1);        // 케이크 추가
                    break;

                case "샌드위치" : User.setSandwichNum(User.getSandwichNum() + 1);   // 샌드위치 추가
                    break;

                case "초콜릿" : User.setChocoNum(User.getChocoNum() + 1);          // 초콜릿 추가
                    break;

                case "마카롱" : User.setMacaronNum(User.getMacaronNum() + 1);      // 마카롱 추가
                    break;
            }

            System.out.println("========================================================================");
            System.out.printf(" %d 코인을 사용했습니다.\n", newItem.getPrice());
            System.out.printf(" 보유 코인 : %d코인\n", User.getProperty());
            System.out.println("========================================================================");

        }
        else
        {
            System.out.println("========================================================================");
            System.out.printf(" 보유한 코인으로 %s을(를) 구매할 수 없습니다.\n", newItem.getName());
            System.out.printf(" 보유 코인      : %d코인\n", User.getProperty());
            System.out.println("========================================================================");
            SubRun subRun = new SubRun();    // 실행 객체 생성
        }

        SubRun subRun = new SubRun();    // 실행 객체 생성

        if(itemType == 1)// 영구아이템인 경우
        {
            subRun.buyPermanentItem();  // 영구아이템 선택화면으로
        }
        else if(itemType == 2)  // 소비아이템인 경우
        {
            subRun.buyConsumableItem(); // 소비아이템 선택화면으로
        }


    }// end buyItem(Item item)




    public void useItem(String itemName)
    {
        switch(itemName)
        {
          case "케이크" :
            if(User.getCakeNum() > 0)
            {
                User.setCakeNum(User.getCakeNum() - 1);     // 보유한 개수에서 하나 감소
                User.setHp(User.getHp() + 2 );              // 현재 체력에서 2 회복

                System.out.println("========================================================================");
                System.out.println(" 케이크를 사용했습니다.");
                System.out.println(" 체력이 2 회복되었습니다.");
                System.out.printf(" 보유 케이크  : %d개 \n", User.getCakeNum());
                System.out.printf(" 현재 체력    : %d\n", User.getHp());

            }
            else
            {
                System.out.println(" 보유한 케이크가 없습니다.");
            }
              System.out.println("========================================================================");
              break;

        case "샌드위치":
            if (User.getSandwichNum() > 0)
            {
                User.setSandwichNum(User.getSandwichNum() - 1);     // 보유한 개수에서 하나 감소
                User.setHp(User.getHp() + 4);                       // 현재 체력에서 4 회복

                System.out.println("========================================================================");
                System.out.println(" 샌드위치를 사용했습니다.");
                System.out.println(" 체력이 4 회복되었습니다.");
                System.out.printf(" 보유 샌드위치  : %d개 \n", User.getSandwichNum());
                System.out.printf(" 현재 체력     : %d\n", User.getHp());

            } else
            {
                System.out.println(" 보유한 샌드위치가 없습니다.");
            }
            System.out.println("========================================================================");
            break;

        case "초콜릿":
            if(User.getChocoNum() > 0)
            {
                User.setChocoNum(User.getChocoNum() - 1);     // 보유한 개수에서 하나 감소
                User.setFeeling(User.getFeeling() + 2);       // 현재 인내력에서 2 회복

                System.out.println("========================================================================");
                System.out.println(" 초콜릿을 사용했습니다.");
                System.out.println(" 인내력이 2 회복되었습니다.");
                System.out.printf(" 보유 초콜릿  : %d개 \n", User.getChocoNum());
                System.out.printf(" 현재 인내력  : %d\n", User.getFeeling());

            } else
            {
                System.out.println(" 보유한 초콜릿이 없습니다.");
            }
            System.out.println("========================================================================");
            break;

        case "마카롱":
            if(User.getMacaronNum() > 0)
            {
                User.setMacaronNum(User.getMacaronNum() - 1);     // 보유한 개수에서 하나 감소
                User.setFeeling(User.getFeeling() + 4);           // 현재 인내력에서 4 회복

                System.out.println("========================================================================");
                System.out.println(" 마카롱을 사용했습니다.");
                System.out.println(" 인내력이 4 회복되었습니다.");
                System.out.printf(" 보유 마카롱  : %d개 \n", User.getMacaronNum());
                System.out.printf(" 현재 인내력  : %d\n", User.getFeeling());

            } else
            {
                System.out.println(" 보유한 마카롱이 없습니다.");
            }
            System.out.println("========================================================================");
            break;

        }

        SubRun subRun = new SubRun();
        subRun.useItemSel(); // 이전으로


    }// end userItem(String itemName)

}

    //-------------------------------------------------------------------------------------------------------------------------------
// 영구 아이템 구매
//
// 메소드 ------------------------------------------------------------------------------------------------
/*

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

                    case EXIT:
                        SubRun subRun = new SubRun();    // 실행 객체 생성
                        subRun.buyPermanentItem(); // 이전으로
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
            SubRun subRun = new SubRun();    // 실행 객체 생성
            subRun.buyPermanentItem(); // 이전으로
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

                    case EXIT:
                        SubRun subRun = new SubRun();    // 실행 객체 생성
                        subRun.buyPermanentItem(); // 이전으로
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
            SubRun subRun = new SubRun();    // 실행 객체 생성
            subRun.buyPermanentItem(); // 이전으로
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

                    case EXIT:
                        SubRun subRun = new SubRun();    // 실행 객체 생성
                        subRun.buyPermanentItem(); // 이전으로
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
            SubRun subRun = new SubRun();    // 실행 객체 생성
            subRun.buyPermanentItem(); // 이전으로
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
            User.setSetHp(User.getSetHp()+2); // 체력 설정값 증가
            User.setHp(User.getSetHp());      // 증가된 체력 설정값으로 현재 체력 설정

            System.out.println("========================================================================");
            System.out.printf(" %d 코인을 사용했습니다.\n", item.getHpPrice());
            System.out.printf(" 보유 코인        : %d코인\n", User.getProperty());
            System.out.printf(" 체력 설정값      : %d \n", User.getSetHp() );
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

                    case EXIT:
                        SubRun subRun = new SubRun();    // 실행 객체 생성
                        subRun.buyPermanentItem(); // 이전으로
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
            SubRun subRun = new SubRun();    // 실행 객체 생성
            subRun.buyPermanentItem();       // 이전으로
        }

    }// end buyHp()

    // 인내력 구매 메소드
    public void buyFeeling()
    {
        boolean check = true;   // 반복여부 체크하는 변수
        String resultStr;       // 사용자의 선택값을 담을 변수
        int result = 0;         // resultStr를 int 로 변환해 사용자의 선택값을 담을 변수

        // 아이템 객체 생성
        Item item = new Item();

        if(User.getProperty() >= item.getFeelingPrice())  // 인내력 증가 가격보다 보유한 코인이 많거나 같으면
        {
            User.setProperty(User.getProperty() - item.getFeelingPrice());    // 계산하고
            User.setSetFeeling(User.getSetFeeling()+2); // 인내력 설정값 증가
            User.setFeeling(User.getSetFeeling());      // 증가된 인내력으로 현재 인내력 초기화

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

                    case EXIT:
                        SubRun subRun = new SubRun();    // 실행 객체 생성
                        subRun.buyPermanentItem(); // 이전으로
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
            SubRun subRun = new SubRun();    // 실행 객체 생성
            subRun.buyPermanentItem(); // 이전으로
        }

    }// end buyFeeling()


// 소비 아이템 구매 메소드 ------------------------------------------------------------------------------------------------

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

                    case EXIT:
                        SubRun subRun = new SubRun();    // 실행 객체 생성
                        subRun.buyConsumableItem(); // 이전으로
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
            SubRun subRun = new SubRun();    // 실행 객체 생성
            subRun.buyConsumableItem(); // 이전으로

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
            System.out.printf(" 보유 샌드위치   : %d개 \n", Item.getSandwich() );
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

                    case EXIT:
                        SubRun subRun = new SubRun();    // 실행 객체 생성
                        subRun.buyConsumableItem(); // 이전으로
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
            SubRun subRun = new SubRun();    // 실행 객체 생성
            subRun.buyConsumableItem(); // 이전으로
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
            System.out.printf(" 보유 초콜릿     : %d개 \n", Item.getChoco() );
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

                    case EXIT:
                        SubRun subRun = new SubRun();    // 실행 객체 생성
                        subRun.buyConsumableItem(); // 이전으로
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
            SubRun subRun = new SubRun();    // 실행 객체 생성
            subRun.buyConsumableItem(); // 이전으로
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

                    case EXIT:
                        SubRun subRun = new SubRun();    // 실행 객체 생성
                        subRun.buyConsumableItem(); // 이전으로
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
            SubRun subRun = new SubRun();    // 실행 객체 생성
            subRun.buyConsumableItem(); // 이전으로
        }

    }// end buyMacaron()

*/

// 소비 아이템 사용 ------------------------------------------------------------------------------------------------------
/*
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

                    case EXIT:
                        SubRun subRun = new SubRun();
                        subRun.useItemNum(); // 이전으로
                        break;
                }
            }
        }
        else
        {
            System.out.println(" 보유한 케이크가 없습니다.");
            System.out.println("========================================================================");
            SubRun subRun = new SubRun();
            subRun.useItemNum(); // 이전으로

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

                    case EXIT:
                        SubRun subRun = new SubRun();
                        subRun.useItemNum(); // 이전으로
                        break;
                }
            }
        }
        else
        {
            System.out.println(" 보유한 샌드위치가 없습니다.");
            System.out.println("========================================================================");
            SubRun subRun = new SubRun();
            subRun.useItemNum(); // 이전으로
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

                    case EXIT:
                        SubRun subRun = new SubRun();
                        subRun.useItemNum(); // 이전으로
                        break;
                }
            }
        }
        else
        {
            System.out.println(" 보유한 초콜릿이 없습니다.");
            System.out.println("========================================================================");
            SubRun subRun = new SubRun();
            subRun.useItemNum(); // 이전으로
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

                    case EXIT:
                        SubRun subRun = new SubRun();
                        subRun.useItemNum(); // 이전으로
                        break;
                }
            }
        }
        else
        {
            System.out.println(" 보유한 마카롱이 없습니다.");
            System.out.println("========================================================================");
            SubRun subRun = new SubRun();
            subRun.useItemNum(); // 이전으로
        }
    }

*/

