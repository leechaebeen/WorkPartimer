package com.company.action;

import com.company.data.Cafe;
import com.company.data.User;
import com.company.run.Ending;
import com.company.run.Run;
import java.util.Random;
import java.util.Scanner;

// 카페 운영의 메인 흐름을 담은 클래스(평일과 주말)
public class CafeAction
{
    // 하루 시작 메소드: 몇주차 며칠인지 보여줌
    public void start()
    {
        String[] days = {"월", "화", "수", "목","금","토"};   // 요일 배열. 토요일은 평일과 주말을 구분하기 위해 존재한다.
        String day = days[User.getWorkingDays() % 6];   // 요일 = 일한일수%6
        // 0에서부터 시작한다. 하루가 지날 때마다 일한일수가 1씩 증가한다.
        // 0%6 == 0 월
        // 1%6 == 1 화
        // 2%6 == 2 수
        // 3%6 == 3 목
        // 4%6 == 4 금
        // 5%6 == 5 토

        int week = (User.getWorkingDays() / 6) + 1;
        // 첫 주(월~금)는 연산결과가 0이 되므로 '1주차' 부터 시작하기 위해서 1을 더해준다.

        if(!day.equals("토"))    // 평일이라면
        {
            User.setWorkingDays(User.getWorkingDays() + 1);  // 지금까지 일한 일수에 하루를 더해준다.

            Cafe.setTodayCustomerNum(0);                // 하루 방문자 수 0으로 초기화
            Cafe.setChair(Cafe.getSetChair());          // 현재 카페의 의자 수를 세팅된 값으로 초기화
            Cafe.setCup(Cafe.getSetCup());              // 현재 유리컵 수를 세팅된 값으로 초기화
            Cafe.setMug(Cafe.getSetMug());              // 현재 머그잔 수를 세팅된 값으로 초기화

            System.out.println("                         ╔═══━━━─────────━━━═══╗                         ");
            System.out.printf("=========================     %d주차     %s요일    =========================\n", week, day);
            System.out.println("                         ╚═══━━━─────────━━━═══╝                         ");
            System.out.println();
            System.out.println("                         ✨ 카페를 열었습니다 ✨ ");
            System.out.println();

            business(); // 아르바이트하는 메소드
        }
        else    // 토요일이라면
        {
            System.out.println();
            System.out.println("                         ✨ 주말이 되었습니다 ✨ ");
            System.out.println();

            weekendInfo();  // 한 주의 아르바이트를 정산하는 메소드

        }


    }// end start()


    // 아르바이트하는 메소드
    public void business()
    {
        String[] nums = {"첫", "두", "세", "네", "다섯", "여섯", "일곱", "여덟", "아홉", "열"}; // 손님수 표현하기 위한 배열

        System.out.println("------------------------------------------------------------------------");
        System.out.println("                        " + nums[Cafe.getTodayCustomerNum()] + "번째 손님이 등장했습니다.");
        System.out.println("------------------------------------------------------------------------");

        // 손님 유형 랜덤으로 등장시키기.
        Random rd = new Random();               // 랜덤클래스 객체 생성
        int randomNum = rd.nextInt(10)+1; // 1 ~ 10 사이의 랜덤값을 생성해서 변수에 담는다.

        Run run = new Run();                    // 실행 객체 생성

        if(randomNum <=7)                       // 랜덤값이 1 ~ 7 인 경우 일반 손님이 방문한다.
        {
            run.comeCustomer();                 // 일반 손님이 등장하는 메소드 호출
        }
        else if(randomNum==8||randomNum==9)     // 랜덤값이 8,9인 경우 특별 손님이 방문한다.
        {
            run.comeSpecialCustomer();          // 특별 손님이 등장하는 메소드 호출
        }
        else                                    // 랜덤값이 10인 경우 비밀손님이 방문한다.
        {
            run.comeSecretCustomer();           // 비밀 손님이 등장하는 메소드 호출
        }

        selBusiness();                          // 선택지 고르는 메소드 호출(1. 계속하기 2. 마감하기 3.아이템 사용)

    }// end business()

    public void selBusiness()
    {
        boolean check;      // 아르바이트 반복 여부 체크하는 변수
        int result = 0;     // 주어진 값 외의 수를 입력했는지 비교할 때 사용할 변수

        final int KEEP = 1; // 손님 계속 받는 선택지
        final int STOP = 2; // 손님 그만받는 선택지
        final int ITEM = 3; // 아이템 사용하는 선택지

        do {

            System.out.println(" 다음 손님을 받을까요? ");
            System.out.println(" 1. 계속하기 2. 마감하기 3.아이템 사용");
            System.out.println("------------------------------------------------------------------------");

            System.out.print(" 선택 : ");
            Scanner sc = new Scanner(System.in);
            String resultStr = sc.nextLine();   // 유저가 입력한 값을 resultStr 변수에 담는다.

            // 입력받은 값이 숫자 형태인지 확인
            try
            {
                // 입력받은 문자열의 공백을 제거하고
                // 자료형 변경한 뒤(String → int) int 형 변수에 담는다.
                result = Integer.parseInt(resultStr.replace(" ", ""));
                check = false;
                // int 형으로 변경되면 check 에 false 를 담고 반복문을 빠져나간다.
                // int형으로 변경되지 않는다면 NumberFormatException 발생한다.
            }
            catch (NumberFormatException e) // NumberFormatException 발생한다면
            {
                check = true;   // check 에 true 담아서 다시 반복
                                // result = 0; 으로 초기화된 상태이므로 아래 if 문을 실행하고 반복된다.
            }

            if(result < 1 || result >3)// 주어진 값 이외의 수를 선택한 경우
            {
                System.out.println("========================================================================");
                System.out.println(" 올바른 값을 입력해주세요.");
                check = true;   // 반복한다.
            }
            else if(result == KEEP && Cafe.getTodayCustomerNum() == User.getSkillLevel()) // 계속하기를 선택했는데 숙련도와 방문한 손님 수가 같으면
            {
                System.out.println("========================================================================");
                System.out.printf("  %s님의 숙련도가 낮아 더이상 손님을 받을 수 없습니다. \n", User.getName());
                result = 2;     // 손님을 그만 받는 선택지를 택하고
                check = false;  // 반복문을 빠져나간다.
            }

        }while (check);

        while(true)
        {
            switch(result)  // 위에서 선택한 값에 따라서 해당하는 메소드를 호출한다
            {
                case KEEP :                 // 계속 아르바이트한다.
                    business();
                    break;

                case STOP:                  // 다음날로 시간이 흐른다.
                    System.out.println();
                    System.out.println();
                    System.out.println(" ☾ ⋆*･ﾟ ⋆*･ﾟ ⋆. ･ﾟ. ⋆ * ･ﾟ. ⋆⋆ *･ﾟ⋆*･ﾟ ⋆ . ･ﾟ .⋆*･ﾟ .⋆ ⋆*･ﾟ ⋆*･ﾟ ⋆･ﾟ⋆ *･ﾟ ⋆･ﾟ");
                    System.out.println();
                    System.out.println();
                    start();                // 하루 시작하는 메소드 호출
                    break;

                case ITEM :                 // 보유한 아이템을 보여주는 메소드 호출
                    Run run = new Run();
                    run.myItem();
                    break;
            }
        }
    }

    // 주말 초기화면  메소드(정보 확인 가능, 상점 이용 가능, 아이템 사용 가능)
    public void weekendInfo()
    {
        int week = (User.getWorkingDays() /6) + 1;
        // 토요일이 될 때 주차를 계산하면(일한 일수/요일배열 길이) 한 주 적게 나오기 때문에 1을 더해준다.
        // 첫번째 토요일 : 5/6 == 0
        // 두번째 토요일 : 11/6 == 1

        // 코인 제공 조건 만족하면
        // 조건 : (음료 제조 성공 총 횟수 - 총 실패 횟수)/숙련도 > 총 방문자 수/2)
        if((User.getSuccessNum()- User.getFailNum())/ User.getSkillLevel() > Cafe.getTotalCustomerNum()/2)
        {
            User.setProperty(User.getProperty() + User.getSalary());    // 코인 제공
            // 전재산 = 현재 전재산 + 제공받는 급여코인

            System.out.printf("                        ✨ %d코인을 획득했습니다 ✨\n", User.getSalary());

        }
        else    // 조건 만족하지 못하면
        {
            System.out.println("                     코인을 획득하지 못했습니다! ");

        }
        System.out.println();

        // 숙련도 증가 조건 만족하면
        // 조건 : 누적 음료 제조 성공 횟수 >= (하루 최대 방문자 수)*4
        if(User.getSkillLevel()*4 <= User.getSuccessNum())
        {
            User.setSkillLevel(User.getSkillLevel()+1);     // 숙련도 1 증가
            System.out.println("                      ✨ 숙련도가 1 증가했습니다 ✨");
            System.out.println();

        }
        else    // 조건 만족하지 못하면
        {
            System.out.println("                     숙련도에 변동이 없습니다! ");
        }

        // 체력, 인내력 설정값으로 초기화
        User.setHp(User.getSetHp());
        User.setFeeling(User.getSetFeeling());
        System.out.println("                    ✨ 체력과 인내력을 회복했습니다 ✨");
        System.out.println();
        System.out.println();


        System.out.println("                         ╔═══━━━─────────━━━═══╗                         ");
        System.out.printf("=========================       %d주차 정산       =========================\n", week);
        System.out.println("                         ╚═══━━━─────────━━━═══╝                         ");
        System.out.println();
        System.out.printf(" 현재까지 방문한 손님 수 : %d \n", Cafe.getTotalCustomerNum());
        System.out.printf(" 음료제조에 성공한 횟수 : %d \n", User.getSuccessNum());
        System.out.printf(" 음료제조에 실패한 횟수 : %d \n", User.getFailNum());
        System.out.printf(" 보유한 코인 : %d\n", User.getProperty());
        System.out.println();

        // 엔딩 호출
        Ending ending = new Ending();                   // 엔딩객체 생성

        if(week >= 3 && User.getSkillLevel() >= 4)  // 3주차 이상 운영하고, 숙련도가 4이상이고
        {
            if(Cafe.getTotalCustomerNum() >= 30)        // 총 방문자 수가 30명 이상일 때
            {
                ending.bossEnding();                    // 사장 엔딩 호출
            }

            else if(SecretCustomerAction.getSecretCustomerCnt() >= 4) // 비밀 손님 방문 횟수가 4 이상이면
            {
                ending.scoutEnding();                        // 이직 엔딩 호출
            }
        }
        else if(week >= 4)                                  // 4주차 이상이고 앞선 조건에 부합하지 않으면
        {
            ending.partimerEnding();                        // 알바 엔딩 호출
        }

        weekend(); // 주말 선택지 메소드 호출(1. 정보 확인  2.상점가기  3.공개된 엔딩 확인  4. 주말 지나가기)
    }

    public void weekend()
    {
        boolean check = true;   // 반복여부 체크하는 변수
        String resultStr;       // 사용자의 선택값을 담을 변수(1. 정보 확인  2.상점가기 3.모은 엔딩 확인)
        int result = 0;         // resultStr 를 int 형으로 변환한 사용자의 선택값을 담을 변수

        final int INFO = 1;     //1. 정보 확인 - 1.내 정보 확인 2.카페 정보 확인 3.이전 화면
        final int SHOP = 2;     //2. 상점가기 - 1.영구 아이템  2.소모 아이템  3.이전 화면
        final int ENDING = 3;   //3. 공개된 엔딩 확인
        final int SKIP = 4;     //4. 주말 지나가기

        while(check)
        {
            System.out.println("========================================================================");
            System.out.println(" 1. 정보 확인  2.상점가기  3.공개된 엔딩 확인  4. 주말 지나가기");
            System.out.println("------------------------------------------------------------------------");
            System.out.print(" 선택 : ");
            Scanner sc = new Scanner(System.in);
            resultStr = sc.nextLine();

            // 입력받은 값이 숫자인지 확인
            try
            {
                // 입력받은 문자열의 공백을 제거하고
                // 자료형 변경한 뒤(String → int) int 형 변수에 담는다.
                result = Integer.parseInt(resultStr.replace(" ", ""));
                check = false;
                // int 형으로 변경되면 check 에 false 담아서 반복문 빠져나간다.
                // int 형으로 변경되지 않는다면 NumberFormatException 발생
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

        Run run = new Run();    // 실행 객체 생성

        System.out.println();

        switch(result)                      // 사용자의 선택값에 따라
        {
            case  INFO: run.info();         // 1. 정보 확인 메소드 호출
                break;

            case  SHOP: run.goShop();       // 2. 상점 가기 메소드 호출
                break;

            case  ENDING: run.openEnding(); // 3.공개된 엔딩 확인 메소드 호출
                break;

            case SKIP :                     // 4. 주말 지나가기 : 다음날 카페 시작하는 메소드 호출
                User.setWorkingDays(User.getWorkingDays() + 1);
                // 주말이 지나도록 하루를 더한다. 토 → 월로 요일 변경
                start();
                break;
        }
    }
}
