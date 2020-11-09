package com.company.action;

import com.company.data.Cafe;
import com.company.data.User;
import com.company.run.GameRun;

import java.util.Scanner;

public class InfoAction
{
    // 정보확인 선택
    public void infoSelect()
    {
        boolean check = true;   // 반복여부 체크하는 변수
        String resultStr;       // 사용자의 선택값을 담을 변수(1. 정보 확인  2.상점가기 3.모은 엔딩 확인)
        int result = 0;         // resultStr를 int 로 변환해 사용자의 선택값을 담을 변수

        while(check)
        {
            System.out.println("========================================================================");
            System.out.printf(" 1. %s님의 정보 보기  2.카페 정보 보기  3.이전으로 \n", User.getName());
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

                if(result < 1 || result > 3 )// 주어진 값 이외의 수를 선택한 경우
                {
                    System.out.println("========================================================================");
                    System.out.println(" 올바른 값을 입력해주세요.");
                    check = true;
                }

            }
            catch (NumberFormatException e) // NumberFormatException 발생한다면
            {
                check = true;   // check 에 true 담아서 다시 반복
            }
        }

        InfoAction infoAction = new InfoAction();   // 정보 기능 객체 생성

        final int MY_INFO = 1;  // 유저 정보
        final int CAFE_INFO = 2;// 카페 정보
        final int EXIT = 3;     // 이전으로

        // 사용자의 선택값에 따라 메소드 호출
        switch(result)
        {
            case  MY_INFO: infoAction.myInfo();     // 내 정보 확인
                break;

            case  CAFE_INFO: infoAction.cafeInfo(); // 카페 정보 확인
                break;

            case EXIT:
                GameRun gameRun = new GameRun();    // 카페 실행 객체 생성
                gameRun.weekend();                  // 주말 초기화면 호출
                break;
        }

    }

    public void myInfo()// 내 정보 확인
    {
        int week = (User.getWorkingDays() / 6) + 1;               // 주차 = 일한날짜/6 + 1
        // 일한 일수는 0에서부터 시작한다. 하루가 지날 때마다 일한일수가 1씩 증가한다.
        // 0%6 == 0 월
        // 1%6 == 1 화
        // 2%6 == 2 수
        // 3%6 == 3 목
        // 4%6 == 4 금
        // 5%6 == 5 토
        // 첫 주(월~토)에 연산결과가 0이 되므로 '1주차' 부터 시작하기 위해서 1을 더해준다.

        System.out.println("                         ╔═══━━━─────────━━━═══╗                         ");
        System.out.printf("==========================     %d주차   정보      =========================\n", week);
        System.out.println("                         ╚═══━━━─────────━━━═══╝                         ");
        System.out.println();
        System.out.println(" 설정값 : 체력, 인내력의 최대치입니다. 아이템을 통해 증가시킬 수 있습니다.");
        System.out.println("         체력과 인내력은 주말마다 설정값으로 초기화됩니다. ");
        System.out.println();
        System.out.println("------------------------------------------------------------------------");
        System.out.println();
        System.out.println(" 숙련도 : 음료 제조 성공 확률과 카페 운영 기간을 고려하여 ");
        System.out.println("         주말마다 숙련도가 업데이트됩니다.");
        System.out.println();
        System.out.println("------------------------------------------------------------------------");
        System.out.println();
        System.out.printf(" %s님의 최대 체력   : %d\n", User.getName(), User.getSetHp());
        System.out.printf(" %s님의 최대 인내력 : %d\n", User.getName(), User.getSetFeeling());
        System.out.println("------------------------------------------------------------------------");
        System.out.printf(" %s님의 현재 체력   : %d\n", User.getName(), User.getHp());
        System.out.printf(" %s님의 현재 인내력 : %d\n", User.getName(), User.getFeeling());
        System.out.printf(" %s님의 숙련도     : %d\n ", User.getName(), User.getSkillLevel());
        System.out.println();

        InfoAction infoAction = new InfoAction();
        infoAction.infoSelect(); // 이전으로

    }// end myInfo()

    public void cafeInfo()  // 카페 정보
    {
        int week = (User.getWorkingDays() / 6) + 1;
        // 주차 = 일한일수/6 + 1

        // 일한 일수는 0에서부터 시작한다. 하루가 지날 때마다 일한일수가 1씩 증가한다.
        // 0%6 == 0 월
        // 1%6 == 1 화
        // 2%6 == 2 수
        // 3%6 == 3 목
        // 4%6 == 4 금
        // 5%6 == 5 토
        // 첫 주(월~토)에 연산결과가 0이 되므로 '1주차' 부터 시작하기 위해서 1을 더해준다.

        System.out.println("                         ╔═══━━━─────────━━━═══╗                         ");
        System.out.printf("==========================    %d주차  카페 정보    =========================\n", week);
        System.out.println("                         ╚═══━━━─────────━━━═══╝                         ");
        System.out.println();
        System.out.println(" 의자 : 카페에 존재하는 의자의 수입니다. 의자는 설정된 값으로 매일 초기화됩니다. ");
        System.out.println("       매장에서 음료를 마시길 원하는 손님은 의자가 없으면 카페를 나갑니다.");
        System.out.println("       아이템 구매를 통해 의자의 수를 늘릴 수 있습니다. ");
        System.out.println();
        System.out.println("------------------------------------------------------------------------");
        System.out.println();
        System.out.println(" 유리잔 : 매장 내 취식하는 손님이 차가운 음료를 마실 경우 사용하는 잔입니다. ");
        System.out.println("         알맞은 잔이 없을 경우 컴플레인이 들어올 수 있습니다.  ");
        System.out.println("         컴플레인을 받을 경우 유저의 인내력이 1 감소합니다.");
        System.out.println("         아이템 구매를 통해 유리잔의 수를 늘릴 수 있습니다. ");
        System.out.println();
        System.out.println("------------------------------------------------------------------------");
        System.out.println();
        System.out.println(" 머그잔 : 매장 내 취식하는 손님이 따뜻한 음료를 마실 경우 사용하는 잔입니다. ");
        System.out.println("         알맞은 잔이 없을 경우 컴플레인이 들어올 수 있습니다.  ");
        System.out.println("         컴플레인을 받을 경우 유저의 인내력이 1 감소합니다.");
        System.out.println("         아이템 구매를 통해 머그잔의 수를 늘릴 수 있습니다. ");
        System.out.println();
        System.out.println("========================================================================");
        System.out.println();
        System.out.printf(" 의자의 수    : %d\n", Cafe.getSetChairNum());
        System.out.printf(" 유리잔의 수  : %d\n", Cafe.getSetCupNum());
        System.out.printf(" 머그잔의 수  : %d\n", Cafe.getSetMugNum());
        System.out.println();

        InfoAction infoAction = new InfoAction();
        infoAction.infoSelect(); // 이전으로
    }
}
