package com.company.character;

import com.company.beverage.Beverage;
import com.company.run.Ending;

import java.util.Random;
import java.util.Scanner;

// Customer 클래스를 상속받아 Character 클래스의 속성과 Customer 클래스의 속성과 기능 사용가능
// 특별손님 고유 기능을 추가한 클래스이다.
public class SpecialCustomer extends Customer
{
    // 음료 주문 전 조건 확인하는 메소드 checkTakeout() - 상속받음
    // 주문할 음료 객체 생성하는 메소드 orderBeverage() - 상속받음

    // 음료 주문하는 메소드
    // 유형1 반말하고 매장에서 먹고가는거 말 안하는 손님 : 유저의 hp 와 mood 가 -1씩 감소한다.
    public void orderTalkDown(Beverage beverage)
    {
        Partimer.setMood(Partimer.getMood()-1);
        Partimer.setHp(Partimer.getHp()-1);

        if(Partimer.getHp()==0)             // 만약 유저의 HP 0이 된다면
        {
            Ending ending = new Ending();   // 쓰러지는 엔딩
            ending.fallDownEnding();
        }
        else if(Partimer.getMood()==0)       // Mood 가 0이 된다면
        {
            Ending ending = new Ending();   // 자발적으로 관두는 엔딩
            ending.toQuitEnding();
        }

        String iceOption;
        String whippingCream;
        String takeout;

        // ICE / HOT 선택값에 따라 대사 분기
        if(beverage.getIceOption()==0)  // 0이면 HOT
        {
            iceOption = " 뜨거운걸로.";
        }
        else    // 1이면 ICE
        {
            iceOption = " 차가운걸로. ";
        }

        // 휘핑 선택값에 따라 대사 분기
        if(beverage.getWhippingCream()==0) // 0 이면 휘핑크림 X
        {
            whippingCream = "휘핑크림.";
        }
        else // 1 이면 휘핑크림 O
        {
            whippingCream = "";
        }

        // 테이크아웃 선택 값에 따라 대사 분기
        if(checkTakeout())  // checkTakeout() 는 테이크아웃하면 true 반환
        {
            takeout = " 테이크아웃.";
        }
        else    // false 인 경우
        {
            takeout = "";
        }

        System.out.println(" 손님 : " + iceOption + beverage.getName());
        System.out.println("       " + whippingCream + takeout );

    }


    // 유형2 시비걸기 : 유저의 hp가 1, mood가 2 감소한다.
    public void orderFight(Beverage beverage)
    {
        Partimer.setHp(Partimer.getHp()-1);
        Partimer.setMood(Partimer.getMood()-2);

        if(Partimer.getHp()==0)             // 만약 유저의 HP 0이 된다면
        {
            Ending ending = new Ending();   // 쓰러지는 엔딩
            ending.fallDownEnding();
        }
        else if(Partimer.getMood()==0)       // Mood 가 0이 된다면
        {
            Ending ending = new Ending();   // 자발적으로 관두는 엔딩
            ending.toQuitEnding();
        }

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
            whippingCream = "당연히 올리죠.";
        }
        else // 1 이면 휘핑크림 O
        {
            whippingCream = "누가 여기에 휘핑을 올려요?";
        }

        // 테이크아웃 선택 값에 따라 대사 분기
        if(checkTakeout())  // checkTakeout() 는 테이크아웃하면 true 반환
        {
            takeout = " 하... 테이크아웃이요.";
        }
        else    // false 인 경우
        {
            takeout = "하...먹고 갈거에요";
        }

        System.out.println(" 손님 : " + beverage.getName());
        System.out.println("            .");
        System.out.println("            .");
        System.out.println("            .");
        System.out.println(" %s님은 ICE/HOT 옵션을 물어봤습니다. ");
        System.out.println();
        System.out.println(" 손님 : " + iceOption);
        System.out.println();
        System.out.println(" %s님은 휘핑크림을 추가하는지 물어봤습니다. ");
        System.out.println();
        System.out.println(" 손님 : " + whippingCream);
        System.out.println();
        System.out.println(" %s님은 테이크아웃 여부를 물어봤습니다. ");
        System.out.println(" 손님 : " + takeout);

    }
    
    // 유형3 도를 믿으시나요 : mood -1
    public void orderToPartimer3()
    {
        System.out.println(" 손님 : ..." );
        System.out.println("       얼굴에 복이 많아요. ");
        System.out.println("========================================================================");
        System.out.println(" 1.가세요  2. ");

    }

    // 유형4 잘못찾아옴
    public void orderWrong()
    {

    }

    // 유형5 의문의 아이템 선물
    public void orderToPartimer4()
    {
        boolean check = true;   // 반복 여부 체크하기 위한 변수
        int result = 0;         // 선택값을 비교하기 위한 변수

        System.out.println(" ＿人人人人人人人人＿ ");
        System.out.println("＞　  안녕하세요!   ＜");
        System.out.println("￣^Y^Y^Y^Y^Y^Y^Y￣ ");

        System.out.println();
        System.out.println("========================================================================");
        System.out.println(" 우렁찬 손님이 오른손과 왼손을 내밀었다.");


        while(check) // check 는 위에서 입력받은 유저이름이 한글인걸 확인했기 때문에 true 인 상황이다.
                {
                    System.out.println("------------------------------------------------------------------------");
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

                        // 현재 HP 또는 MOOD 올려주기
                        Random rd = new Random();
                        int randomNum = rd.nextInt(1)+1; // 랜덤으로 1 또는 2를 randomNum 변수에 저장

                        if(result == randomNum)                 // 선택한 값과 랜덤값이 같다면
                        {
                            Partimer.setMood(Partimer.getMood()+1); // 현재 mood에서 1 증가
                            System.out.println("========================================================================");
                            System.out.printf(" %s님의 mood 가 1 회복되었습니다.\n",Partimer.getName());
                            System.out.printf(" 현재 %s님의 mood : %d\n", Partimer.getName(), Partimer.getMood());
                        }
                        else if(result != randomNum)            // 선택한 값과 랜덤값이 다르다면
                        {
                            Partimer.setHp(Partimer.getHp());   // 현재 hp 에서 1 증가
                            System.out.printf(" %s님의 hp 가 1 회복되었습니다.\n",Partimer.getName());
                            System.out.printf(" 현재 %s님의 hp : %d\n", Partimer.getName(), Partimer.getHp());
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


        System.out.println(" ＿人人人人人人人人＿ ");
        System.out.println("＞　  선물입니다!   ＜");
        System.out.println("￣^Y^Y^Y^Y^Y^Y^Y￣ ");


    }
}
