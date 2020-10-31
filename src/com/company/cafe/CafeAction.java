package com.company.cafe;

import com.company.character.*;
import com.company.run.Ending;
import com.company.run.Run;

import java.util.Random;
import java.util.Scanner;

// 게임의 메인 흐름을 담은 클래스
public class CafeAction
{
    // 하루 시작 메소드: 몇주차 며칠인지 보여줌
    public void start()
    {
        String[] days = {"월", "화", "수", "목","금","토"};    // 카페 운영하는 요일 출력하는 배열.
        // 게임을 시작할 때 일한 일수가 1 증가하면서 월요일이 된다.
        // 1%6 == 1 화
        // 2%6 == 2 수
        // 3%6 == 3 목
        // 4%6 == 4 금
        // 5%6 == 5 토
        // 6%6 == 0 월
        int week = (Partimer.getWorkingDays() / 6) + 1;   // 첫 주(월~금)는 연산결과가 0이 되므로 1을 더해준다.
        String day = days[Partimer.getWorkingDays() % 6]; // 요일 = 일한날짜%5

        if(!day.equals("토"))    // 평일이라면
        {
            Partimer.setWorkingDays(Partimer.getWorkingDays() + 1);  // 지금까지 일한 일수에 하루를 더해준다.

            Cafe.setTodayCustomerNum(0);                // 하루 방문자 수 0으로 초기화
            Cafe.setChair(Cafe.getSetChair());          // 자리를 세팅된 값으로 초기화
            Cafe.setCup(Cafe.getSetCup());              // 유리컵을 세팅된 값으로 초기화
            Cafe.setMug(Cafe.getSetMug());              // 머그잔을 세팅된 값으로 초기화

            System.out.println("                         ╔═══━━━─────────━━━═══╗                         ");
            System.out.printf("=========================     %d주차     %s요일    =========================\n", week, day);
            System.out.println("                         ╚═══━━━─────────━━━═══╝                         ");
            System.out.println();
            System.out.println("                         ✨ 카페를 열었습니다 ✨ ");
            System.out.println();
            business(); // 카페 운영하면서 손님 받는 메소드
        }
        else    // 토요일이라면
        {
            System.out.println();
            System.out.println("                         ✨ 주말이 되었습니다 ✨ ");
            System.out.println();
            System.out.println();
            System.out.println();

            weekendInfo();  // 주말에 한 주의 카페 운영을 정산하는 메소드

        }


    }// end start()


    // 카페 운영하면서 손님 받는 메소드
    public void business()
    {
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

        Run run = new Run();    // 실행 객체 생성

        if(randomNum <=7)  // 랜덤값이 1 ~ 7 인 경우 일반 손님이 방문한다.
        {
            run.comeCustomer(); // 음료 객체 생성하고, 손님이 주문하고, 음료 만든다.
        }
        else if(randomNum==8||randomNum==9) // 랜덤값이 8,9인 경우 특별 손님이 방문한다.
        {
            run.comeSpecialCustomer(); // 음료 객체 생성하고, 손님이 주문하고, 음료 만든다.
        }
        else // 랜덤값이 10인 경우 특별 손님이 방문한다.
        {
            run.comeSecretCustomer();   // 음료 객체 생성하고, 손님이 주문하고, 유저가 음료 만든다.
        }

        selBusiness();  // 선택지 호출

    }// end business()

    public void selBusiness()
    {
        boolean check;      // 장사 계속 할지말지 반복여부 체크하는 변수
        int result = 0;     // 주어진 값(1.장사 계속 2.장사 마감) 외의 수를 입력했는지 비교할 때 사용할 변수

        final int KEEP = 1; // 하루 손님 계속 받는 선택지
        final int STOP = 2; // 하루 손님 그만받는 선택지
        final int ITEM = 3; // 아이템 사용하는 선택지

        do {

            System.out.println(" 다음 손님을 받을까요? ");
            System.out.println(" 1. 계속하기 2. 마감하기 3.아이템 사용");

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

            if(result < 1 || result >3)// 주어진 값 이외의 수를 선택한 경우
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

                case ITEM : // 보유한 아이템 보여주는 메소드 호출
                    Run run = new Run();
                    run.myItem();
                    break;
            }
        }
    }

    // 주말 초기화면  메소드(정보 확인 가능, 상점 이용 가능, 아이템 사용 가능)
    public void weekendInfo()
    {
        int week = (Partimer.getWorkingDays() /6) + 1;
        // 토요일이 될 때 주차를 계산하면(일한 일수/요일배열 길이) 한 주 적게 나오기 때문에 1을 더해준다.
        /* 첫번째 토요일 : 5/6 == 0
           두번째 토요일 : 11/6 == 1
        */

        // 숙련도 업데이트

        // 급여 코인 제공 (조건 : 음료 제조 성공 횟수/주차가 숙련도와 같거나 높아야 한다.)
        if(Partimer.getSuccessNum()/week >= Partimer.getSkillLevel())
        {
            Partimer.setProperty(Partimer.getProperty() + Partimer.getSalary());
            // 전재산 = 현재 전재산 + 제공받는 급여코인
            System.out.println();
            System.out.printf("                         ✨ 급여로 %d코인을 획득했습니다 ✨\n", Partimer.getSalary());
            System.out.println();
            System.out.println();

        }
        else
        {
            System.out.println();
            System.out.println("                         코인을 획득하지 못했습니다! ");
            System.out.println("                          더 열심히 일해야합니다 ");
            System.out.println();
            System.out.println();

        }

        // 체력, 인내력 설정값으로 초기화
        Partimer.setHp(Partimer.getSetHp());
        Partimer.setFeeling(Partimer.getSetFeeling());


        System.out.println("                         ╔═══━━━─────────━━━═══╗                         ");
        System.out.printf("=========================       %d주차 정산       =========================\n", week);
        System.out.println("                         ╚═══━━━─────────━━━═══╝                         ");
        System.out.println();
        System.out.printf(" 현재까지 방문한 손님 수 : %d \n", Cafe.getTotalCustomerNum());
        System.out.printf(" 음료제조에 성공한 횟수 : %d \n", Partimer.getSuccessNum());
        System.out.printf(" 음료제조에 실패한 횟수 : %d \n", Partimer.getFailNum());
        System.out.printf(" 보유한 코인 : %d\n", Partimer.getProperty());
        //System.out.println(" 비밀 손님 방문 여부 : ");
        System.out.println();

        weekend(); // 주말 선택지 호출

    }

    public void weekend()
    {
        boolean check = true;   // 반복여부 체크하는 변수
        String resultStr;       // 사용자의 선택값을 담을 변수(1. 정보 확인  2.상점가기 3.모은 엔딩 확인)
        int result = 0;         // resultStr를 int 로 변환해 사용자의 선택값을 담을 변수

        final int INFO = 1;     //1. 정보 확인 - 1.내 정보 확인 2.카페 정보 확인 3.이전 화면
        final int SHOP = 2;     //2. 상점가기 - 1.아이템 구입 2.보유 아이템 3.이전 화면
        final int ENDING = 3;   //3. 모은 엔딩 확인
        final int SKIP = 4;     //4. 지나가기

        while(check)
        {
            System.out.println("========================================================================");
            System.out.println(" 1. 정보 확인  2.상점가기  3.공개된 엔딩 확인  4.지나가기");
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
            case  INFO: run.info();     // 1. 정보 확인

                break;

            case  SHOP: run.goShop();   // 2. 상점 가기

                break;

            case  ENDING: run.openEnding();// 3.공개된 엔딩 확인

                break;

            case SKIP : // 지나가기 : 다음날 카페 오픈하기
                Partimer.setWorkingDays(Partimer.getWorkingDays() + 1); // 주말이 지나도록 하루를 더한다. 토→월로 요일 변경
                start();
                break;
        }
    }

    // 점수 계산하는 메소드 - 주마다 열람 가능 / 누적 총점은 못봄. 총점에 따라서 엔딩 갈림
}
