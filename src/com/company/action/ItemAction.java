package com.company.action;

import com.company.data.Cafe;
import com.company.data.Item;
import com.company.data.User;
import com.company.run.SubRun;

public class ItemAction
{
    public void buyItem(Item item)
    {
        // 매개변수로 받은 객체에서 아이템 유형과 가격 얻기
        int itemPrice = item.getPrice();     // 아이템의 가격을 담는 변수
        String itemName = item.getName();    // 아이템의 이름을 담는 변수
        int itemType = item.getType();       // 아이템의 유형을 담는 변수 (1: 영구아이템, 2: 소비아이템)

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
            System.out.printf(" %d 코인을 사용했습니다.\n", item.getPrice());
            System.out.printf(" 보유 코인 : %d코인\n", User.getProperty());

        }
        else
        {
            System.out.println("========================================================================");
            System.out.printf(" 보유한 코인으로 %s을(를) 구매할 수 없습니다.\n", item.getName());
            System.out.printf(" 보유 코인      : %d코인\n", User.getProperty());
        }
        System.out.println("========================================================================");

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


