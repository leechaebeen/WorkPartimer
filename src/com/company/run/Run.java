package com.company.run;

import com.company.character.Partimer;

import java.util.Scanner;
import java.util.regex.Pattern;

// 게임 선택지에 따른 출력을 실행하는 클래스
public class Run
{
    // 게임을 처음 시작하면 등장하는 초기화면
    public void firstRun()
    {
        // 게임 소개
        System.out.println(" 일해라 알바생 ! ");
        System.out.println(" Work! partimer ! ");
        System.out.println();

        Scanner sc = new Scanner(System.in);
        String userName; // 유저이름 값 저장할 변수
        boolean check;   // 조건에 맞게 이름 입력했는지 확인할 변수

        do {
            System.out.print(" 이름을 입력해주세요(한글로 입력해주세요) : ");
            userName = sc.nextLine();                                   // 유저이름 입력받기
            userName = userName.replaceAll(" ", "");    //공백 제거
            check = Pattern.matches("^[가-힣]*$", userName);      // 정규표현식 이용해서 한글인지 확인

        }while (!check); // 입력받은 이름이 한글이 아니면 반복

        Partimer partimer = new Partimer(); // 유저 객체 생성
        partimer.setName(userName);         // 입력받은 유저이름 속성에 넣기

        System.out.println(" 어쩌구 저쩌구 스토리 설명 쫓겨난 이유 ");

        System.out.println();
        System.out.println();
        System.out.println(". 　。　　　　•　 　ﾟ　　。. 　。　　　　•　 　ﾟ　　。. 　。　　　　•　 　ﾟ　　。");
        System.out.println("　　      .　　　.　　　 　　.　　　.       　　.　　　.　　　 　　.　　　   　");
        System.out.println("。　　              。　　 。　        。　　      　　          　 。　.  ");
        System.out.println("       .　　　.　　　　.　    　  　 ඞ   　      •  .　　　.　　        .  ");
        System.out.println(". 　。　　　        　      　。　　　　    •　 　     。　　　　•　 　ﾟ　　。");
        System.out.printf("\t\t\t\t %s님은 결국 우주로 추방당했습니다 . . .\n", partimer.getName());
        System.out.println("　　      .　　　.　　　 。                 　　.　　　 　　　 　　.　　　   　");
        System.out.println("。　　 。　.          　　  　.     。　　      　 。　      .  。　　 。　.  ");

        System.out.println();
        System.out.println();
        System.out.printf(" %s님은 오늘부터 카페 아르바이트를 시작했습니다.\n", partimer.getName());
        System.out.println(" 아르바이트를 진행하면서 다양한 엔딩을 볼 수 있습니다.");

        // 올바른 선택지를 선택할 때까지 반복
        while()
        {
            System.out.println(" 1. 시작하기  2.처음부터 다시하기 ");

        }

    }

}
