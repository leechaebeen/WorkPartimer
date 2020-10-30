package com.company.cafe;

import com.company.beverage.Beverage;
import com.company.character.Customer;
import com.company.character.Partimer;
import com.company.character.SpecialCustomer;

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

        int week = (Partimer.getWorkingDays() / 7) + 1;                 // 주차 = 일한날짜/7 + 1
        String day = days[Partimer.getWorkingDays() % 7];             // 요일 = 일한날짜%7

        System.out.println("                         ╔═══━━━─────────━━━═══╗                         ");
        System.out.printf("=========================     %d주차     %s요일    =========================\n", week, day);
        System.out.println("                         ╚═══━━━─────────━━━═══╝                         ");

        Cafe.setTodayCustomerNum(0);                // 카페 오픈 전 하루 방문자 수 0으로 초기화
        Partimer.setMood(10);                       // 카페 오픈 전 유저 Mood 10으로 초기화(매일 세팅되는 값은 변하지 않는다.)
        //Cafe.setChair(Cafe.);

        System.out.println("                           카페를 오픈했습니다. ");

        business(); // 카페 운영하면서 손님 받는 메소드

    }// end start()


    // 카페 운영하면서 손님 받는 메소드
    public void business()
    {
        boolean check;      // 장사 계속 할지말지 반복여부 체크하는 변수
        int result = 0;     // 주어진 값(1.장사 계속 2.장사 마감) 외의 수를 입력했는지 비교할 때 사용할 변수
        String[] nums = {"첫", "두", "세", "네", "다섯", "여섯", "일곱", "여덟", "아홉", "열"}; // 손님수 표현하기 위한 배열

        System.out.println("------------------------------------------------------------------------");
        System.out.println("                           " + nums[Cafe.getTodayCustomerNum()] + "번째 손님이 등장했습니다.");
        System.out.println("------------------------------------------------------------------------");

        // 랜덤으로 손님 또는 특별 손님 등장시키기.
        Random rd = new Random();
        int randomNum = rd.nextInt(10)+1;   // 1 ~ 10 사이의 랜덤수를 생성

        if(randomNum <=7)  // 1 ~ 7 의 70%의 확률로 일반 손님 방문
        {
            comeCustomer();
        }
        else // 8~10 의 30% 의 확률로 특별 손님 방문
        {
            comeSpecialCustomer();
        }

        do {

            System.out.println("------------------------------------------------------------------------");
            System.out.println(" 다음 손님을 받을까요? ");
            System.out.println(" 1. 계속하기 2. 마감하기 ");
            System.out.print(" 선택 : ");
            Scanner sc = new Scanner(System.in);
            String resultStr = sc.nextLine();   // 유저가 입력한 값을

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

        }while (check);

        final int KEEP = 1; // 하루 손님 계속 받는 선택지
        final int STOP = 2; // 하루 손님 그만받는 선택지

        while(true)
        {
            switch(result)
            {
                case KEEP : business();

                    break;

                case STOP: start();

                    break;
            }
        }


    }// end business()

    // 손님 등장 메소드
    public void comeCustomer()
    {
        Cafe.setTodayCustomerNum(Cafe.getTodayCustomerNum()+1); // 기존의 하루 방문자 수에 한명 더하기
        Cafe.setTotalCustomerNum(Cafe.getTotalCustomerNum()+1); // 기존의 총 방문자 수에 한명 더하기

        System.out.println();

        Customer customer = new Customer();           // 손님 객체 생성
        Beverage beverage = customer.orderBeverage(); // 주문할 음료 객체 생성
        customer.orderToPartimer(beverage);           // 손님이 음료 주문

        System.out.println();

        // 음료 만들기 - PartimerAction 에 메소드 정의하기

    }

    // 특별 손님 등장 메소드
    public void comeSpecialCustomer()
    {
        final int TALK_DOWN = 1;    // 반말하는 유형

        Cafe.setTodayCustomerNum(Cafe.getTodayCustomerNum()+1); // 기존의 하루 방문자 수에 하나 더하기
        Cafe.setTotalCustomerNum(Cafe.getTotalCustomerNum()+1); // 기존의 총 방문자 수에 한명 더하기

        System.out.println();

        SpecialCustomer specialCustomer = new SpecialCustomer(); // 특별 손님 객체 생성
        Beverage beverage = specialCustomer.orderBeverage();     // 주문할 음료 객체 생성
        specialCustomer.orderToPartimer(beverage);               // 손님이 음료 주문

        // 유형 나누기
        Random rd = new Random();
        int typeNum = rd.nextInt(4)+1; //1~4 랜덤값 반환해서 typeNum 변수에 저장

        switch(typeNum)
        {
            case 1: // final 상수로 바꾸기

                break;

            case 2:

                break;

            case 3:

                break;

            case 4:

                break;

        }

    }


    // 주말 메소드 상점 - 주말 : HP 회복


    // 하루하루 점수 계산하는 메소드 - 하루마다/주마다 열람 가능 / 누적 총점은 못봄. 총점에 따라서 엔딩 갈림
}
