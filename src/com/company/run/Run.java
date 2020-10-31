package com.company.run;
import java.util.Scanner;

import com.company.cafe.Cafe;
import com.company.cafe.CafeAction;
import com.company.character.Partimer;
import java.util.regex.Pattern;

// 선택지에 따른 출력을 실행하는 클래스
public class Run
{
    // int result;          → 인스턴스 변수
    // static int result;   → 클래스 변수

    // 1.초기화면 실행하는 메소드
    public int initialRun()
    {
        // 반환값을 담을 변수 선언
        // 초기화해야하는 이유  : 지역변수는 자동으로 초기화가 안된다. 클래스 변수와 인스턴스 변수는 자료형에 맞게 기본값으로 초기화된다.
        // → 예측할 수 없는 값을 담는걸 방지하기 위해
        String resultStr;
        int result = 0;

        // 스캐너 객체 생성
        Scanner sc = new Scanner(System.in);

        // 게임 소개
        System.out.println();
        System.out.println();

        System.out.println("。　　　　　　　　　　　　　　　　　ﾟ　　　.　　　　　　　　　　　　　　.");
        System.out.println("　　　　　　　　　.　 .　　　　　　　　.");
        System.out.println(" 　　　　　。　　　　　　　　　　　　　　　　　　　ﾟ　　　　　　　　　。");
        System.out.println("　　.　　　　　　　　.　　　　　.　　　　　　　　　　。　　.　");
        System.out.println("　.　　　　　　　　　　　　　　                   ㅤㅤㅤㅤㅤㅤㅤㅤㅤ 　 。　　.");
        System.out.println("　 　　　　　　。　　　　   　Work! partimer ! 　　ﾟ　　　.　 　　　　　　　　.");
        System.out.println(",　　　　　　　　　.　 .　　　　　　　　.");
        System.out.println("　　　　　。　　　　　　　　　　　　　　　　　　　ﾟ　　　　　　　　　。");
        System.out.println("　　.　　　　　　　　.　　　　　.　　　　　　　　　　。　　.");
        System.out.println();
        System.out.println();
        System.out.println();

        String userName; // 유저이름을 저장할 변수
        boolean check;   // 조건에 맞게 이름 입력했는지 확인할 변수

        do {
            System.out.print(" 이름을 입력해주세요(한글만 가능) : ");
            userName = sc.nextLine();                                   // 유저이름을 입력받고
            userName = userName.replaceAll(" ", "");    // 공백을 제거하고
            check = Pattern.matches("^[가-힣]*$", userName);       // 정규표현식을 이용해서 한글인지 확인한다. 한글인 경우 true 반환

        }while (!check); // 입력받은 이름이 한글이 아니면 반복

        Partimer.setName(userName);         // 입력받은 유저이름 속성에 넣기

        System.out.println(" 어쩌구 저쩌구 스토리 설명 쫓겨난 이유 ");

        System.out.println();
        System.out.println();

        System.out.println("。　　　　　　　　　　　　　　　　　ﾟ　　　.　　　　　　　　　　　　　　.     ");
        System.out.println("　　　　　　　　　.　 .　　　　　　　　.");
        System.out.println(" 　　　　　。　　　　　　　　　　　　　　　　　　　ﾟ　　　　　　　　　。    ");
        System.out.println("　　.　　　　　　　　.　　　　　.　　　　　　　　　　。　　.　");
        System.out.println("　.　　　　　　　　　　　　　　                   ㅤㅤㅤㅤㅤㅤㅤㅤㅤ 　 。　　.");
        System.out.println("　 　　　　　　。　　　 。      　三 ඞ;;   　  　ﾟ　　　.　 　　　　　　　　.");
        System.out.println(". 　。　　　        　    　。　　　　      •　 　        　　　     　　");
        System.out.printf("\t\t。\t\t\t %s님은 결국 추방당했습니다 . . .     .          。\n", Partimer.getName());
        System.out.println(",　　　　　　　　　.　 .　　　　　　　　.");
        System.out.println("　　　　　。　　　　　　　　　　　　　　　　　　　ﾟ　　　　　　　　　。");
        System.out.println("　　.　　　　　　　　.　　　　　.　　　　　　　　　　。　　.");
        System.out.println();
        System.out.println();
        System.out.println();


        System.out.println();
        System.out.println();
        System.out.printf(" %s님은 오늘부터 카페 아르바이트를 시작했습니다.\n", Partimer.getName());
        System.out.println(" 아르바이트를 진행하면서 다양한 엔딩을 볼 수 있습니다.");

        // 올바른 선택지를 선택할 때까지 반복
        while(check) // check 는 위에서 입력받은 유저이름이 한글인걸 확인했기 때문에 true 인 상황이다.
        {
            System.out.println("========================================================================");
            System.out.println(" 1. 시작하기  2.처음부터 다시하기 ");
            System.out.println("------------------------------------------------------------------------");
            System.out.print(" 선택 : ");
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

            if(result < 1 || result > 2 )// 주어진 값 이외의 수를 선택한 경우
            {
                System.out.println("========================================================================");
                System.out.println(" 올바른 값을 입력해주세요.");
                check = true;
            }
        }

        return result;

    } //end initialRun()





    // 정보 확인 메소드 1.내 정보 확인 2.카페 정보 확인
    public void info()
    {
        boolean check = true;   // 반복여부 체크하는 변수
        String resultStr;       // 사용자의 선택값을 담을 변수(1. 정보 확인  2.상점가기 3.모은 엔딩 확인)
        int result = 0;         // resultStr를 int 로 변환해 사용자의 선택값을 담을 변수

        final int MY_INFO = 1;
        final int CAFE_INFO = 2;
        final int EXIT = 3;

        while(check)
        {
            System.out.println("========================================================================");
            System.out.printf(" 1. %s님의 정보 보기  2.카페정보 보기 3.뒤로가기 \n", Partimer.getName());
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

            if(result < 1 || result > 3 )// 주어진 값 이외의 수를 선택한 경우
            {
                System.out.println("========================================================================");
                System.out.println(" 올바른 값을 입력해주세요.");
                check = true;
            }

        }

        CafeAction cafeAction = new CafeAction();

        switch(result)
        {
            case  MY_INFO: myInfo();    // 내 정보 확인

                break;

            case  CAFE_INFO: cafeInfo(); // 카페 정보 확인

                break;

            case EXIT:  cafeAction.weekend();   // 주말 초기화면 호출
                break;
        }

    }

    public void myInfo()// 내 정보 확인
    {
        int week = (Partimer.getWorkingDays() / 7) + 1;               // 주차 = 일한날짜/7 + 1
        System.out.println("                         ╔═══━━━─────────━━━═══╗                         ");
        System.out.printf("==========================      %d주차   정보     =========================\n", week);
        System.out.println("                         ╚═══━━━─────────━━━═══╝                         ");
        System.out.println();
        System.out.println(" 설정값 : 최대 능력치입니다. 아이템을 통해 증가시킬 수 있습니다.");
        System.out.println("         능력치는 주말마다 설정값으로 초기화됩니다. ");
        System.out.println("------------------------------------------------------------------------");
        System.out.printf(" %s님의 인내력 : %d\n",Partimer.getSetFeeling());
        System.out.printf(" %s님의 체력 : %d\n", Partimer.getSetHp());
        System.out.println("========================================================================");
        System.out.println(" 숙련도 : 음료 제조 성공 확률과 카페 운영 기간을 고려하여 ");
        System.out.println("         주말마다 숙련도가 업데이트됩니다.");
        System.out.println("------------------------------------------------------------------------");
        System.out.printf(" %s님의 숙련도 : %d\n ", Partimer.getSkillLevel());
        System.out.println("------------------------------------------------------------------------");

        boolean check = true;   // 반복여부 체크하는 변수
        String resultStr;       // 사용자의 선택값을 담을 변수
        int result = 0;         // resultStr를 int 로 변환해 사용자의 선택값을 담을 변수

        final int EXIT = 1;

        while(check)
        {
            System.out.println(" 1.나가기");
            System.out.println("------------------------------------------------------------------------");
            Scanner sc = new Scanner(System.in);
            System.out.print(" 선택 : ");
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

            if(result != 1)// 주어진 값 이외의 수를 선택한 경우
            {
              System.out.println("========================================================================");
              System.out.println(" 올바른 값을 입력해주세요.");
              check = true;
            }

        }

        switch(result)
        {
          case  EXIT: info(); // 이전 화면으로 나가기
          break;
        }

    }// end myInfo()

    public void cafeInfo()  // 카페 정보
    {
        int week = (Partimer.getWorkingDays() / 7) + 1;               // 주차 = 일한날짜/7 + 1
        System.out.println("                         ╔═══━━━─────────━━━═══╗                         ");
        System.out.printf("==========================    %d주차  카페 정보    =========================\n", week);
        System.out.println("                         ╚═══━━━─────────━━━═══╝                         ");
        System.out.println();
        System.out.println(" 의자 : 카페에 존재하는 의자의 수입니다. 매장에서 음료를 마시는 한 명의 손님이 하나의 의자를 차지합니다.");
        System.out.println("       매장에서 음료를 마시길 원하는 손님은 의자가 없으면 카페를 나갑니다.");
        System.out.println("       아이템을 통해 의자의 수를 늘릴 수 있습니다. 의자는 설정된 값으로 매일 초기화됩니다.");
        System.out.println("------------------------------------------------------------------------");
        System.out.printf(" 의자의 수 : %d\n", Cafe.getSetChair());
        System.out.println("========================================================================");
        System.out.println(" 유리컵 : 매장 내 취식하는 손님이 차가운 음료를 마실 경우 사용하는 잔입니다. ");
        System.out.println("         알맞은 잔이 없을 경우 유저의 체력이 1 감소합니다. ");
        System.out.println("------------------------------------------------------------------------");
        System.out.printf(" %s님의 숙련도 : %d\n ", Partimer.getSkillLevel());
        System.out.println("------------------------------------------------------------------------");

        boolean check = true;   // 반복여부 체크하는 변수
        String resultStr;       // 사용자의 선택값을 담을 변수
        int result = 0;         // resultStr를 int 로 변환해 사용자의 선택값을 담을 변수

        final int EXIT = 1;

        while(check)
        {
            System.out.println(" 1.나가기");
            System.out.println("------------------------------------------------------------------------");
            Scanner sc = new Scanner(System.in);
            System.out.print(" 선택 : ");
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

            if(result != 1)// 주어진 값 이외의 수를 선택한 경우
            {
                System.out.println("========================================================================");
                System.out.println(" 올바른 값을 입력해주세요.");
                check = true;
            }

        }

        switch(result)
        {
            case  EXIT: info(); // 이전 화면으로 나가기
                break;
        }
    }



}









