package com.company.cafe;

import com.company.beverage.Beverage;
import com.company.character.*;
import com.company.run.Ending;
import com.company.run.Run;

import java.util.Random;
import java.util.Scanner;

public class CafeAction
{

    // 하루 시작 메소드: 몇주차 며칠인지 보여줌
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

        Cafe.setTodayCustomerNum(0);                // 하루 방문자 수 0으로 초기화
        Cafe.setChair(Cafe.getSetChair());          // 자리를 세팅된 값으로 초기화
        Cafe.setCup(Cafe.getSetCup());              // 유리컵을 세팅된 값으로 초기화
        Cafe.setMug(Cafe.getSetMug());              // 머그잔을 세팅된 값으로 초기화


        if(days.equals("토"))    // 토요일이라면
        {
            System.out.println();
            System.out.println("                         ✨ 주말이 되었습니다 ✨ ");
            System.out.println();
            Partimer.setWorkingDays(Partimer.getWorkingDays() + 1); // 일요일 지나가도록 하루 추가

            weekend();  // 주말 메소드
        }
        else
        {
            System.out.println();
            System.out.println("                         ✨ 카페를 열었습니다 ✨ ");
            System.out.println();
            business(); // 카페 운영하면서 손님 받는 메소드
        }


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
        System.out.println("                        " + nums[Cafe.getTodayCustomerNum()] + "번째 손님이 등장했습니다.");
        System.out.println("------------------------------------------------------------------------");

        // 랜덤으로 손님 또는 특별 손님 등장시키기.
        Random rd = new Random();
        int randomNum = rd.nextInt(10)+1;   // 1 ~ 10 사이의 랜덤값을 생성한다.

        if(randomNum <=7)  // 랜덤값이 1 ~ 7 인 경우 일반 손님이 방문한다.
        {
            comeCustomer(); // 음료 객체 생성하고, 손님이 주문하고, 음료 만든다.
        }
        else if(randomNum==8||randomNum==9) // 랜덤값이 8,9인 경우 특별 손님이 방문한다.
        {
            comeSpecialCustomer(); // 음료 객체 생성하고, 손님이 주문하고, 음료 만든다.
        }
        else // 랜덤값이 10인 경우 특별 손님이 방문한다.
        {
            comeSecretCustomer();   // 음료 객체 생성하고, 손님이 주문하고, 유저가 음료 만든다.
        }

        final int KEEP = 1; // 하루 손님 계속 받는 선택지
        final int STOP = 2; // 하루 손님 그만받는 선택지

        do {

            System.out.println(" 다음 손님을 받을까요? ");
            System.out.println(" 1. 계속하기 2. 마감하기 ");

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

            if(result != KEEP || result != STOP)// 주어진 값 이외의 수를 선택한 경우
            {
                System.out.println("========================================================================");
                System.out.println(" 올바른 값을 입력해주세요.");
                check = true;
            }
            else if(result == KEEP && Cafe.getTodayCustomerNum() == Partimer.getSkillLevel()) // 계속하기를 선택했는데 숙련도와 방문한 손님 수가 같으면
            {
                System.out.println("========================================================================");
                System.out.printf("  %s님의 숙련도가 낮아 더이상 손님을 받을 수 없습니다. \n",Partimer.getName());
                result = 2;     // 손님을 그만 받는 선택지를 택하고
                check = false;  // 반복 멈춘다.
            }

        }while (check);

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

        Beverage beverage = customer.orderBeverage(); // 주문할 음료 객체 생성
        customer.orderToPartimer(beverage);           // 손님이 음료 주문

        PartimerAction partimerAction = new PartimerAction();   // 유저 액션 객체 생성
        boolean result = partimerAction.makeBeverage(beverage); // 음료 만들기 수행하고 결과를 반환한다.
        partimerAction.makeBeverageResult(result);              // 결과에 따른 출력

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

        SpecialCustomer specialCustomer = new SpecialCustomer(); // 특별 손님 객체 생성
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
            PartimerAction partimerAction = new PartimerAction();   // 유저 액션 객체 생성
            boolean result = partimerAction.makeBeverage(beverage); // 음료 만들기 수행하고 결과를 반환한다.
            partimerAction.makeBeverageResult(result);              // 결과에 따른 출력
        }
    }

    // 비밀 손님 등장 메소드
    public void comeSecretCustomer()
    {
        final int COMMON = 1;           // 일반 손님 유형
        final int TALK_DOWN = 2;        // 반말하는 유형
        final int FIGHT = 3;            // 시비거는 유형

        System.out.println("비밀 손님 등장!");

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
            SecretCustomer secretCustomer = new SecretCustomer();  // 비밀 손님 객체 생성
            Beverage beverage = secretCustomer.orderBeverage();    // 주문할 음료 객체 생성

            System.out.println();

            // 음료 주문 유형 랜덤으로 실행하기
            Random rd = new Random();
            int typeNum = rd.nextInt(3)+1; //1~3 랜덤값 반환해서 typeNum 변수에 저장

            switch(typeNum)
            {
                case 1: secretCustomer.orderToPartimer(beverage);   // 일반 손님
                    break;

                case 2: secretCustomer.orderTalkDown(beverage);    // 반말하는 손님
                    break;

                case 3: secretCustomer.orderFight(beverage);       // 시비거는 손님
                    break;
            }

            // 유저가 음료 만들기
            PartimerAction partimerAction = new PartimerAction();   // 유저 액션 객체 생성
            boolean result = partimerAction.makeBeverage(beverage); // 음료 만들기 수행하고 결과를 반환한다.
            partimerAction.makeBeverageResult(result);              // 결과에 따른 출력
        }

    }


    // 주말 초기화면  메소드(정보 확인 가능, 상점 이용 가능, 아이템 사용 가능)
    public void weekend()
    {
        boolean check = true;   // 반복여부 체크하는 변수
        int week = (Partimer.getWorkingDays() / 7) + 1;               // 주차 = 일한날짜/7 + 1

        String resultStr;       // 사용자의 선택값을 담을 변수(1. 정보 확인  2.상점가기 3.모은 엔딩 확인)
        int result = 0;         // resultStr를 int 로 변환해 사용자의 선택값을 담을 변수


        // 숙련도 업데이트

        // 체력, 인내력 설정값으로 초기화
        Partimer.setHp(Partimer.getSetHp());
        Partimer.setFeeling(Partimer.getSetFeeling());


        System.out.println("                         ╔═══━━━─────────━━━═══╗                         ");
        System.out.printf("=========================          %d주차         =========================\n", week);
        System.out.println("                         ╚═══━━━─────────━━━═══╝                         ");

        System.out.println(" 방문한 총 손님 수 : ");
        System.out.println(" 음료제조에 성공한 횟수 : ");
        System.out.println(" 음료제조에 실패한 횟수 : ");
        //System.out.println(" 비밀 손님 방문 여부 : ");

        final int INFO = 1;     //1. 정보 확인 - 1.내 정보 확인 2.카페 정보 확인
        final int SHOP = 2;     //2. 상점가기 - 1.아이템 구입 2.아이템 사용
        final int ENDING = 3;   //3. 모은 엔딩 확인
        final int SKIP = 4;     //4. 지나가기

        while(check)
        {
            System.out.println("========================================================================");
            System.out.println(" 1. 정보 확인  2.상점가기 3.모은 엔딩 확인 4.지나가기");
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

            if(result < 1 || result > 4 )// 주어진 값 이외의 수를 선택한 경우
            {
              System.out.println("========================================================================");
              System.out.println(" 올바른 값을 입력해주세요.");
              check = true;
            }

        }

        Run run = new Run();

        System.out.println();
        switch(result)
        {
            case  INFO: run.info();

            break;

            case  SHOP: //

            break;

            case  ENDING:

            break;

            case SKIP : start();    // 지나가기 : 다음날 카페 오픈하기
                break;
        }
    }



    // 점수 계산하는 메소드 - 주마다 열람 가능 / 누적 총점은 못봄. 총점에 따라서 엔딩 갈림
}
