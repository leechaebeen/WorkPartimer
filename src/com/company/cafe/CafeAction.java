package com.company.cafe;

import com.company.beverage.Beverage;
import com.company.character.Customer;
import com.company.character.Partimer;
import com.company.character.PartimerAction;
import com.company.character.SpecialCustomer;
import com.company.run.Ending;

import java.util.Random;
import java.util.Scanner;

public class CafeAction
{

    // 카페 오픈 메소드: 몇주차 며칠인지, 유저의 상태가 어떤지 보여줌. 그리고 손님오는 메소드 또는 특별손님 오는 메소드 호출
    public void start()
    {
        String[] days = {"일", "월", "화", "수", "목", "금", "토"};    // 요일 출력하는 배열
        // 일한날짜%7 연산을 통해서 요일을 구하므로 일요일을 0번째에 배치한다.

        Partimer.setWorkingDays(Partimer.getWorkingDays() + 1);       // 하루가 새롭게 시작되므로 지금까지 일한 날짜에 하루를 더해준다.

        int week = (Partimer.getWorkingDays() / 7) + 1;               // 주차 = 일한날짜/7 + 1
        String day = days[Partimer.getWorkingDays() % 7];             // 요일 = 일한날짜%7

        System.out.println("                         ╔═══━━━─────────━━━═══╗                         ");
        System.out.printf("=========================     %d주차     %s요일    =========================\n", week, day);
        System.out.println("                         ╚═══━━━─────────━━━═══╝                         ");

        Cafe.setTodayCustomerNum(0);                // 카페 오픈 전 하루 방문자 수 0으로 초기화
        Cafe.setChair(Cafe.getSetChair());          // 카페 오픈 전 자리를 세팅된 값으로 초기화
        Cafe.setCup(Cafe.getSetCup());              // 카페 오픈 전 유리컵을 세팅된 값으로 초기화
        Cafe.setMug(Cafe.getSetMug());              // 카페 오픈 전 머그잔을 세팅된 값으로 초기화

        System.out.println();
        System.out.println("                         ✨ 카페를 오픈했습니다 ✨ ");
        System.out.println();

        business(); // 카페 운영하면서 손님 받는 메소드

    }// end start()


    // 카페 운영하면서 손님 받는 메소드
    public void business()
    {

        boolean check;      // 장사 계속 할지말지 반복여부 체크하는 변수
        int result = 0;     // 주어진 값(1.장사 계속 2.장사 마감) 외의 수를 입력했는지 비교할 때 사용할 변수
        String[] nums = {"첫", "두", "세", "네", "다섯", "여섯", "일곱", "여덟", "아홉", "열"}; // 손님수 표현하기 위한 배열

        // 유저 상태 체크
        if(Partimer.getHp()==0)             // 만약 유저의 HP 0이 된다면
        {
            Ending ending = new Ending();   // 쓰러지는 엔딩
            ending.fallDownEnding();
        }
        else if(Partimer.getFeeling()==0)       // feeling 이 0이 된다면
        {
            Ending ending = new Ending();   // 자발적으로 관두는 엔딩
            ending.toQuitEnding();
        }


        System.out.println("------------------------------------------------------------------------");
        System.out.println("                           " + nums[Cafe.getTodayCustomerNum()] + "번째 손님이 등장했습니다.");
        System.out.println("------------------------------------------------------------------------");

        // 랜덤으로 손님 또는 특별 손님 등장시키기.
        Random rd = new Random();
        int randomNum = rd.nextInt(10)+1;   // 1 ~ 10 사이의 랜덤값을 생성한다.

        if(randomNum <=7)  // 랜덤값이 1 ~ 7 인 경우 일반 손님이 방문한다.
        {
            comeCustomer(); // 음료 객체 생성하고, 손님이 주문하고, 음료 만든다.
        }
        else if( 8 <= randomNum && randomNum <=10 ) // 랜덤값이 8,9, 10인 경우 특별 손님이 방문한다.
        {
            comeSpecialCustomer(); // 음료 객체 생성하고, 손님이 주문하고, 음료 만든다.
        }



        do {

            System.out.println(" 다음 손님을 받을까요? ");
            System.out.println(" 1. 계속하기 2. 마감하기 3.아이템 사용하기");
            System.out.print(" 선택 : ");
            Scanner sc = new Scanner(System.in);
            String resultStr = sc.nextLine();   // 유저가 입력한 값을 resultStr 변수에 담는다.

            // 입력받은 값이 숫자 형태인지 확인
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
                // result = 0; 으로 초기화된 상태이므로 아래 if문 내부까지 실행하고 반복된다.
            }

            if(result < 1 || result > 3 )// 주어진 값 이외의 수를 선택한 경우
            {
                System.out.println("========================================================================");
                System.out.println(" 올바른 값을 입력해주세요.");
                check = true;
            }
            else if(result==1 && Cafe.getTodayCustomerNum() == Partimer.getSkillLevel()) // 계속하기를 선택했는데 숙련도와 방문한 손님 수가 같으면
            {
                System.out.println("========================================================================");
                System.out.printf("  %s님의 숙련도가 낮아 더이상 손님을 받을 수 없습니다. \n",Partimer.getName());
                result = 2;     // 손님을 그만 받는 선택지를 택하고
                check = false;  // 반복 멈춘다.
            }

        }while (check);

        final int KEEP = 1; // 하루 손님 계속 받는 선택지
        final int STOP = 2; // 하루 손님 그만받는 선택지
        final int ITEM = 3; // 아이템 사용하는 선택지

        while(true)
        {
            switch(result)
            {
                case KEEP : // 손님 계속 받는다
                    business();

                    break;

                case STOP: // 다음날로 시간이 흐른다.

                    System.out.println();
                    System.out.println();
                    System.out.println(" ☾ ⋆*･ﾟ ⋆*･ﾟ ⋆. ･ﾟ. ⋆ * ･ﾟ. ⋆⋆ *･ﾟ⋆*･ﾟ ⋆ . ･ﾟ .⋆*･ﾟ .⋆ ⋆*･ﾟ ⋆*･ﾟ ⋆･ﾟ⋆ *･ﾟ ⋆･ﾟ");
                    System.out.println();
                    System.out.println();
                    start();

                    break;
                    
                case ITEM : // 아이템을 사용할 수 있는 공간으로 이동한다.

                    break;
            }
        }


    }// end business()

    // 일반손님 등장 메소드
    public void comeCustomer()
    {
        Cafe.setTodayCustomerNum(Cafe.getTodayCustomerNum()+1); // 기존의 하루 방문자 수에 한명 더하기
        Cafe.setTotalCustomerNum(Cafe.getTotalCustomerNum()+1); // 기존의 총 방문자 수에 한명 더하기

        System.out.println();

        Customer customer = new Customer();           // 손님 객체 생성

        //test
        System.out.println("자리수 : " + Cafe.getChair());

        // 매장에 자리가 있는지 확인
        if(Cafe.getChair()==0)    // 매장에 자리가 없으면
        {
            System.out.println(" 매장에 자리가 없어서 손님이 나갔다 . . .");
            System.out.println(" 자리를 늘리던가 해야지 원 . . . ");
        }
        else
        {
            Beverage beverage = customer.orderBeverage(); // 주문할 음료 객체 생성
            customer.orderToPartimer(beverage);           // 손님이 음료 주문

            PartimerAction partimerAction = new PartimerAction(); // 유저 액션 객체 생성
            boolean result = partimerAction.makeBeverage(beverage);       // 음료 만들기 수행하고 결과를 반환한다.

            if(result == false)     // 음료 실패했을 경우
            {
                System.out.println("------------------------------------------------------------------------");
                System.out.println("                            음료 만들기 실패 ! ");
                System.out.println("------------------------------------------------------------------------");
            }
            else
            {
                System.out.println("------------------------------------------------------------------------");
                System.out.println("                          ✨ 음료 만들기 성공 ✨  ");
                System.out.println("------------------------------------------------------------------------");
            }

        }

    }

    // 특별 손님 등장 메소드
    public void comeSpecialCustomer()
    {
        final int TALK_DOWN = 1;    // 반말하는 유형

        Cafe.setTodayCustomerNum(Cafe.getTodayCustomerNum()+1); // 기존의 하루 방문자 수에 하나 더하기
        Cafe.setTotalCustomerNum(Cafe.getTotalCustomerNum()+1); // 기존의 총 방문자 수에 한명 더하기

        // 매장에 자리가 있는지 확인
        if(Cafe.getChair()==0)    // 매장에 자리가 없으면
        {
            System.out.println(" 매장에 자리가 없어서 손님이 나갔다 . . .");
            System.out.println(" 자리를 늘리던가 해야지 원 . . . ");
        }
        else
        {
            SpecialCustomer specialCustomer = new SpecialCustomer(); // 특별 손님 객체 생성
            Beverage beverage = specialCustomer.orderBeverage();     // 주문할 음료 객체 생성

            System.out.println();
            
            // 음료 주문 유형 랜덤으로 실행하기
            Random rd = new Random();
            int typeNum = rd.nextInt(5)+1; //1~5 랜덤값 반환해서 typeNum 변수에 저장

            switch(typeNum)
            {
                case 1: specialCustomer.orderTalkDown(beverage);    // 반말하는 손님 
                    break;

                case 2: specialCustomer.orderFight(beverage);       // 시비거는 손님
                    break;

                case 3: specialCustomer.orderFalseReligion();       // 도를 아십니까 손님
                    break;

                case 4: specialCustomer.orderWrong();               // 잘못찾아온 손님
                    break;

                case 5: specialCustomer.orderPresent();             // 선물주는 손님
                    break;

            }

            if(typeNum == 1 ||typeNum == 2)  // 음료를 주문하는 특별손님의 경우에만
            {
                // 유저가 음료 만들기
                PartimerAction partimerAction = new PartimerAction();   // 유저 액션 객체 생성

                boolean result = partimerAction.makeBeverage(beverage); // 음료 만들기 수행하고 결과를 반환한다.

                if(result == false)     // 음료 실패했을 경우
                {
                    // 음료 실패 반응 보이기
                    System.out.println("------------------------------------------------------------------------");
                    System.out.println("                            음료 만들기 실패 ! ");
                    System.out.println("------------------------------------------------------------------------");

                    Partimer.setFailNum(Partimer.getFailNum()+1);   // 실패 횟수 1 증가
                }
                else
                {
                    System.out.println("------------------------------------------------------------------------");
                    System.out.println("                          ✨ 음료 만들기 성공 ✨  ");
                    System.out.println("------------------------------------------------------------------------");
                }
            }

        }

        
    }


    // 주말 메소드 상점 - 주말 : HP 회복 , mood 회복


    // 하루하루 점수 계산하는 메소드 - 하루마다/주마다 열람 가능 / 누적 총점은 못봄. 총점에 따라서 엔딩 갈림
}
