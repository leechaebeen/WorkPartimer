package com.company.run;
import com.company.beverage.Beverage;
import com.company.beverage.BeverageAction;
import com.company.cafe.Cafe;
import com.company.character.Customer;
import com.company.character.Partimer;

import java.util.Random;
import java.util.Scanner;
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
        System.out.println();
        System.out.println();
        System.out.println(" 일해라 알바생 ! ");
        System.out.println(" Work! partimer ! ");
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
        System.out.println(" 　　 。               　.       。　      .         　            。. ");
        System.out.println(". 　。　　　　•　 　ﾟ　　   　。　　　　•　 　ﾟ　　。. 　。　　　　•　 　 　　。");
        System.out.println("　　      .　　　.　　　 　　.　　　.       　　.　　　.　　　 　　.　　　   　");
        System.out.println("。　　              。　　 。　        。　　      　　          　 。　.  ");
        System.out.println("       .　　　.　　　　.　    　  三 ඞ;; 　      •  .　　　.　　        .  ");
        System.out.println(". 　。　　　        　      　。　　　　    •　 　     。　　　　•　 　ﾟ　　。");
        System.out.printf("\t\t。\t\t %s님은 결국 지구로 추방당했습니다 . . .     .          。\n", Partimer.getName());
        System.out.println("　　      .　　　.　　　 。                 　　.　　　 　　　 　　.　　　   　");
        System.out.println("。　　 。　.          　　  　.     。　　      　 。　      .  。　　 。　.  ");

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
                //Integer.parseInt(resultStr);


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


    // 2. 하루 시작 메소드: 몇주차 며칠인지, 유저의 상태가 어떤지 보여줌. 그리고 손님오는 메소드 또는 특별손님 오는 메소드 호출
    public void start()
    {
        String[] days = {"일","월", "화", "수", "목", "금", "토"};    // 요일 출력하는 배열
                                                                    // 일한날짜%7 연산을 통해서 요일을 구하므로 일요일을 0번째에 배치한다.

        Partimer.setWorkingDays(Partimer.getWorkingDays()+1);       // 하루가 새롭게 시작되므로 지금까지 일한 날짜에 하루를 더해준다.

        int week = (Partimer.getWorkingDays()/7)+1;                 // 주차 = 일한날짜/7 + 1
        String day = days[Partimer.getWorkingDays()%7];             // 요일 = 일한날짜%7

        System.out.println("                         ╔═══━━━─────────━━━═══╗                         ");
        System.out.printf("=========================     %d주차     %s요일    =========================\n",week,day);
        System.out.println("                         ╚═══━━━─────────━━━═══╝                         ");

        Cafe.setTodayCustomerNum(0);                // 카페 오픈 전 하루 방문자 수 0으로 초기화
        System.out.println(" 카페를 오픈했습니다. ");

        do {
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

            System.out.println("오늘 손님 수 : "+ Cafe.getTodayCustomerNum());

        }while (Cafe.getTodayCustomerNum() < 10); // 10명의 손님이 방문하면 하루 일정 끝



    }//end start()

    // 손님 등장 메소드
    public void comeCustomer()
    {
        Cafe.setTodayCustomerNum(Cafe.getTodayCustomerNum()+1); // 기존의 하루 방문자 수에 하나 더하기
        System.out.printf(" %s : 어서오세요. 그냥손님 \n", Partimer.getName());
        System.out.println();

        Customer customer = new Customer();
        customer.orderBeverage();



    }

    // 특별 손님 등장 메소드
    public void comeSpecialCustomer()
    {
        Cafe.setTodayCustomerNum(Cafe.getTodayCustomerNum()+1); // 기존의 하루 방문자 수에 하나 더하기
        System.out.printf(" %s : 어서오세요. 특별손님\n", Partimer.getName());
    }



}
