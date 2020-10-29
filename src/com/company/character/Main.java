package com.company.character;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args)
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
            userName = sc.nextLine();        // 유저이름 입력받기

            // 정규표현식 이용해서 한글인지 확인
            check = Pattern.matches("^[가-힣]*$", userName);

        }while (!check); // 입력받은 이름이 한글이 아니면 반복

        Partimer partimer = new Partimer(); // 유저 객체 생성
        partimer.setName(userName);         // 입력받은 유저이름 속성에 넣기

        System.out.println();
        System.out.printf(" %s님은 오늘부터 카페 아르바이트를 시작했습니다.\n", partimer.getName());
        System.out.println(" 아르바이트를 진행하면서 다양한 엔딩을 볼 수 있습니다.");


    }
}
