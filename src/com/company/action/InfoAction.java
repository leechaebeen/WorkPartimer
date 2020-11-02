package com.company.action;

import com.company.data.Cafe;
import com.company.data.User;
import com.company.run.SubRun;

public class InfoAction
{

    public void myInfo()// 내 정보 확인
    {
        int week = (User.getWorkingDays() / 7) + 1;               // 주차 = 일한날짜/7 + 1
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
        System.out.printf(" %s님의 체력   : %d\n", User.getName(), User.getSetHp());
        System.out.printf(" %s님의 인내력 : %d\n", User.getName(), User.getSetFeeling());
        System.out.printf(" %s님의 숙련도 : %d\n ", User.getName(), User.getSkillLevel());
        System.out.println();

        SubRun subRun = new SubRun();
        subRun.info(); // 이전으로

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
        System.out.printf(" 의자의 수    : %d\n", Cafe.getSetChair());
        System.out.printf(" 유리잔의 수  : %d\n", Cafe.getSetCup());
        System.out.printf(" 머그잔의 수  : %d\n", Cafe.getSetMug());
        System.out.println();

        SubRun subRun = new SubRun();
        subRun.info(); // 이전으로
    }
}
