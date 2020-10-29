package com.company.run;

import com.company.character.Partimer;

import java.util.Scanner;
import java.util.regex.Pattern;

// 게임 선택지에 따른 출력을 실행하는 클래스
public class Run
{
    // int result;          → 인스턴스 변수
    // static int result;   → 클래스 변수

    // 게임을 처음 시작하면 등장하는 초기화면
    public int initialRun()
    {
        // 반환값을 담을 변수 선언
        // 초기화해야하는 이유  : 지역변수는 자동으로 초기화가 안된다. 클래스 변수와 인스턴스 변수는 자료형에 맞게 기본값으로 초기화된다.
        // → 예측할 수 없는 값을 담는걸 방지하기 위해
        String resultStr = "";
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

        Partimer partimer = new Partimer(); // 유저 객체 생성
        partimer.setName(userName);         // 입력받은 유저이름 속성에 넣기

        System.out.println(" 어쩌구 저쩌구 스토리 설명 쫓겨난 이유 ");

        System.out.println();
        System.out.println();
        System.out.println(" 　　 。               　.       。　      .         　            。. ");
        System.out.println(". 　。　　　　•　 　ﾟ　　   　。　　　　•　 　ﾟ　　。. 　。　　　　•　 　 　　。");
        System.out.println("　　      .　　　.　　　 　　.　　　.       　　.　　　.　　　 　　.　　　   　");
        System.out.println("。　　              。　　 。　        。　　      　　          　 。　.  ");
        System.out.println("       .　　　.　　　　.　    　  三 ඞ;; 　      •  .　　　.　　        .  ");
        System.out.println(". 　。　　　        　      　。　　　　    •　 　     。　　　　•　 　ﾟ　　。");
        System.out.printf("\t\t。\t\t %s님은 결국 지구로 추방당했습니다 . . .     .          。\n", partimer.getName());
        System.out.println("　　      .　　　.　　　 。                 　　.　　　 　　　 　　.　　　   　");
        System.out.println("。　　 。　.          　　  　.     。　　      　 。　      .  。　　 。　.  ");

        System.out.println();
        System.out.println();
        System.out.printf(" %s님은 오늘부터 카페 아르바이트를 시작했습니다.\n", partimer.getName());
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
            try {
                Integer.parseInt(resultStr);
                check = false;

                // 자료형 변경 (String → int), 여기서 NumberFormatException 발생
                result = Integer.parseInt(resultStr);
            }
            catch (NumberFormatException e)
            {
                check = true;
            }

            if(result < 1 || result > 2 )// 주어진 값 이외의 수를 선택한 경우
            {
                System.out.println("========================================================================");
                System.out.println(" 올바른 값을 입력해주세요.");
                check = true;
            }
            else
            {
                check = false;  // 반복문을 빠져나간다.
            }
        }

        return result;

    } //end initialRun()




}
