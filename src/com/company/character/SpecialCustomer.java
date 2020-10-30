package com.company.character;

import com.company.beverage.Beverage;
import com.company.cafe.Cafe;

import java.util.Random;
import java.util.Scanner;

// Customer 클래스를 상속받아 Character 클래스의 속성과 Customer 클래스의 속성과 기능 사용가능
// 특별손님 고유 기능을 추가한 클래스이다.
public class SpecialCustomer extends Customer
{
    // 음료 주문 전 조건 확인하는 메소드 checkTakeout() - 상속받음
    // 주문할 음료 객체 생성하는 메소드 orderBeverage() - 상속받음

    // 음료 주문하는 메소드
    // 유형1 반말하고 매장에서 먹고가는거 말 안하는 손님 : 유저의 hp 와 feeling 이 -1씩 감소한다.
    public void orderTalkDown(Beverage beverage)
    {
        String iceOption;
        String whippingCream;
        String takeout;

        //test
        System.out.println("자리수 : " + Cafe.getChair());

        // ICE / HOT 선택값에 따라 대사 분기
        if(beverage.getIceOption()==0)  // 0이면 HOT
        {
            iceOption = " 뜨거운걸로.";
        }
        else    // 1이면 ICE
        {
            iceOption = " 차가운걸로. ";
        }

        // 휘핑크림 선택값에 따라 대사 분기
        if(beverage.getWhippingCream()==0) // 0 이면 휘핑크림 X
        {
            whippingCream = "휘핑크림.";
        }
        else // 1 이면 휘핑크림 O
        {
            whippingCream = "";
        }

        // 테이크아웃 선택 값에 따라 대사 분기
        boolean checkTakeout = checkTakeout();

        if(checkTakeout)  // checkTakeout() 는 테이크아웃하면 true 반환
        {
            takeout = " 테이크아웃.";
        }
        else
        {
            takeout = "";
        }

        System.out.println(" 손님 : " + iceOption + beverage.getName()+".");
        System.out.println("       " + whippingCream + takeout );

        Partimer.setFeeling(Partimer.getFeeling()-1);
        Partimer.setHp(Partimer.getHp()-1);

        if(!checkTakeout) // 매장에서 먹고 간다면
        {
            Cafe.setChair(Cafe.getChair()-1);// 매장 자리를 하나 줄인다.

            // 유리잔 또는 머그잔 감소시키기.
            if(beverage.getIceOption()==0 && Cafe.getMug() !=0 ) // 뜨거운 음료이고 머그잔이 있으면
            {
                Cafe.setMug(Cafe.getMug() - 1); // 머그잔 1 감소
            }
            else if(beverage.getIceOption()==1 && Cafe.getCup() != 0) // 차가운 음료이고 유리잔이 있으면
            {
                Cafe.setCup(Cafe.getCup() - 1); // 유리잔 1 감소
            }
            else    // 뜨거운 음료인데 머그잔이 없거나 차가운 음료인데 유리잔이 없으면 유저 체력 1 감소
            {
                Partimer.setHp(Partimer.getHp() - 1);
            }
        }
    }


    // 유형2 시비걸기 : 유저의 hp가 1, feeling이 2 감소한다.
    public void orderFight(Beverage beverage)
    {

        //test
        System.out.println("자리수 : " + Cafe.getChair());


        String iceOption;
        String whippingCream;
        String takeout;

        // ICE / HOT 선택값에 따라 대사 분기
        if(beverage.getIceOption()==0)  // 0이면 HOT
        {
            iceOption = " 이 날씨에 차가운걸 먹겠어요?";
        }
        else    // 1이면 ICE
        {
            iceOption = " 이 날씨에 뜨거운걸 먹겠어요? ";
        }

        // 휘핑 선택값에 따라 대사 분기
        if(beverage.getWhippingCream()==0) // 0 이면 휘핑크림 X
        {
            whippingCream = "누가 여기에 휘핑을 올려요?";
        }
        else // 1 이면 휘핑크림 O
        {
            whippingCream = "당연히 올리죠.";
        }

        // 테이크아웃 선택 값에 따라 대사 분기
        boolean checkTakeout = checkTakeout();

        if(checkTakeout)  // checkTakeout() 는 테이크아웃하면 true 반환
        {
            takeout = " 하... 테이크아웃이요. 그만 좀 물어보세요";
        }
        else    // false 인 경우
        {
            takeout = "하...먹고 갈거에요. 그만 물어보세요.";
        }

        System.out.println(" 손님 : " + beverage.getName());
        System.out.println();
        System.out.println("         .");
        System.out.println("         .");
        System.out.println("         .");
        System.out.println();
        System.out.printf(" %s님은 ICE/HOT 옵션을 물어봤습니다.\n", Partimer.getName());
        System.out.println();
        System.out.println(" 손님 : " + iceOption);
        System.out.println();
        System.out.printf(" %s님은 휘핑크림을 추가하는지 물어봤습니다.\n", Partimer.getName());
        System.out.println();
        System.out.println(" 손님 : " + whippingCream);
        System.out.println();
        System.out.printf(" %s님은 테이크아웃 여부를 물어봤습니다.\n",Partimer.getName());
        System.out.println();
        System.out.println(" 손님 : " + takeout);
        System.out.println();

        Partimer.setHp(Partimer.getHp()-1);
        Partimer.setFeeling(Partimer.getFeeling()-2);

        if(!checkTakeout) // 매장에서 먹고 간다면
        {
            Cafe.setChair(Cafe.getChair()-1);// 매장 자리를 하나 줄인다.

            // 유리잔 또는 머그잔 감소시키기.
            if(beverage.getIceOption()==0 && Cafe.getMug() !=0 ) // 뜨거운 음료이고 머그잔이 있으면
            {
                Cafe.setMug(Cafe.getMug() - 1); // 머그잔 1 감소
            }
            else if(beverage.getIceOption()==1 && Cafe.getCup() != 0) // 차가운 음료이고 유리잔이 있으면
            {
                Cafe.setCup(Cafe.getCup() - 1); // 유리잔 1 감소
            }
            else    // 뜨거운 음료인데 머그잔이 없거나 차가운 음료인데 유리잔이 없으면 유저 체력 1 감소
            {
                Partimer.setHp(Partimer.getHp() - 1);
            }
        }

    }
    
    // 유형3 도를 믿으시나요 : 내보낸 경우 feeling -1 , 얘기 듣는 경우 hp,feeling 1씩 감소
    public void orderFalseReligion()
    {
        //test
        System.out.println("자리수 : " + Cafe.getChair());


        boolean check = true;
        String resultStr;
        int result = 0 ;

        System.out.println(" 손님 : 얼굴에 복이 많으세요. ");
        System.out.println("              :  ");
        System.out.println("              :  ");
        System.out.println();

        while(check)
        {
                System.out.println("========================================================================");
                System.out.println(" 1.내보낸다.  2.얘기를 들어본다 ");
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

                    if(result == 1) // 내보낸 경우 feeling 1 감소
                    {
                        Partimer.setFeeling(Partimer.getFeeling()-1);
                    }
                    else // 얘기를 들어본 경우 hp 와 feeling 1 씩 감소
                    {
                        System.out.println(" ... ...사이비였다. ");
                        System.out.println("------------------------------------------------------------------------");
                        Partimer.setHp(Partimer.getHp()-1);
                        Partimer.setFeeling(Partimer.getFeeling()-1);
                    }

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


    }

    // 유형4 잘못찾아옴
    public void orderWrong()
    {
        //test
        System.out.println("자리수 : " + Cafe.getChair());

        String[] menus = {"냉면", "떡볶이", "치킨", "회", "오므라이스", "커리"} ;  // 잘못찾아온 손님이 찾을 메뉴 목록

        Random rd = new Random();
        int menu = rd.nextInt(menus.length);    // 0부터 메뉴 목록 배열의 길이만큼 랜덤 수를 반환해서 변수 menu에 담는다.

        System.out.printf(" 손님 : 여기 %s 파나요 ? \n", menus[menu]);
        System.out.println("------------------------------------------------------------------------");
        System.out.println(" 잘못 찾아온 손님이었다. ");
        System.out.println("------------------------------------------------------------------------");

    }

    // 유형5 의문의 아이템 선물
    public void orderPresent()
    {
        //test
        System.out.println("자리수 : " + Cafe.getChair());

        boolean check = true;   // 반복 여부 체크하기 위한 변수
        int result = 0;         // 선택값을 비교하기 위한 변수

        System.out.println(" 손님 :     ＿人人人人人人人人＿ ");
        System.out.println("           ＞　안녕하십니까!  ＜");
        System.out.println("           ￣^Y^Y^Y^Y^Y^Y^Y￣ ");


        System.out.println();
        System.out.println("========================================================================");
        System.out.println(" 우렁찬 손님이 오른손과 왼손을 내밀었다.");


        while(check)
        {
            System.out.println(" 1.오른손 선택 2.왼손 선택");
            System.out.println("------------------------------------------------------------------------");
            System.out.print(" 선택 : ");
            Scanner sc = new Scanner(System.in);
            String resultStr = sc.nextLine();

            // 입력받은 값이 숫자인지 확인
            try
            {
                // 자료형 변경한 뒤(String → int) int형에 담는다.
                result = Integer.parseInt(resultStr);
                check = false;
                // int 형으로 변경되면 check 에 false 담아서 반복문 빠져나간다.
                // int형으로 변경되지 않는다면 NumberFormatException 발생

                // 현재 HP 또는 feeling 올려주기
                Random rd = new Random();
                int randomNum = rd.nextInt(2) + 1; // 랜덤으로 1 또는 2를 randomNum 변수에 저장

                if (result == randomNum)                 // 선택한 값과 랜덤값이 같다면
                {
                    if (Partimer.getFeeling() != Partimer.getSetFeeling()) // 현재 feeling 이 최대 feeling 이 아니라면
                    {
                        Partimer.setFeeling(Partimer.getFeeling() + 1); // 현재 feeling 에서 1 증가
                        System.out.println("========================================================================");
                        System.out.printf(" %s님의 인내력이 1 회복되었습니다.\n", Partimer.getName());
                        System.out.printf(" 현재 %s님의 인내력 : %d\n", Partimer.getName(), Partimer.getFeeling());
                        System.out.println("========================================================================");
                    }
                    else
                    {
                        System.out.println("========================================================================");
                        System.out.printf(" %s님의 인내력이 최댓값입니다.\n", Partimer.getName());
                        System.out.printf(" 현재 %s님의 인내력 : %d\n", Partimer.getName(), Partimer.getFeeling());
                        System.out.println("========================================================================");
                    }

                    System.out.println();

                } else    // 선택한 값과 랜덤값이 다르다면
                {
                    if (Partimer.getHp() != Partimer.getSetHp()) // 현재 hp 가 최대 hp 가 아니라면
                    {
                        Partimer.setHp(Partimer.getHp());         // 현재 hp 에서 1 증가
                        System.out.println("========================================================================");
                        System.out.printf(" %s님의 체력이 1 회복되었습니다.\n", Partimer.getName());
                        System.out.printf(" 현재 %s님의 체력 : %d\n", Partimer.getName(), Partimer.getHp());
                        System.out.println("========================================================================");
                    }
                    else
                    {
                        System.out.println("========================================================================");
                        System.out.printf(" %s님의 체력이 최댓값입니다.\n", Partimer.getName());
                        System.out.printf(" 현재 %s님의 체력 : %d\n", Partimer.getName(), Partimer.getHp());
                        System.out.println("========================================================================");
                    }

                    System.out.println();
                }
            } catch (NumberFormatException e) // NumberFormatException 발생한다면
            {
                check = true;   // check 에 true 담아서 다시 반복
                // result = 0; 으로 초기화된 상태이므로  하단 if문 내부까지 실행하고 반복된다.
            }

            if (result < 1 || result > 2)// 주어진 값 이외의 수를 선택한 경우
            {
                System.out.println("========================================================================");
                System.out.println(" 올바른 값을 입력해주세요.");
                check = true;
            }

        }

        System.out.println(" 손님 :     ＿人人人人人人人人＿ ");
        System.out.println("           ＞  안녕히 계세요! ＜");
        System.out.println("           ￣^Y^Y^Y^Y^Y^Y^Y￣ ");
        System.out.println();

    }// end orderPresent()



}
