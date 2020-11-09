package com.company.etc;

import com.company.data.Bug;
import com.company.run.Battle;

import java.util.Random;
import java.util.Scanner;

public class MiniGame extends Thread
{

    Bug bug;
    boolean check = false;

    MiniGame(){};
    public MiniGame(Bug bug)
    {
        this.bug = bug;
    }

    @Override
    public void run()
    {
        game();
    }

    public void finish()
    {
        check = false;
        this.interrupt();
    }

    public void game()
    {
        boolean result = true;  // 게임 결과 담을 변수
        try{

            Thread.sleep(1000);
            System.out.println();
            System.out.println("------------------------------------------------------------------------");
            System.out.println("                             불청객 퇴치하기 ");
            System.out.println("------------------------------------------------------------------------");
            System.out.println(" 제시되는 숫자를 기억하고 동일하게 타이핑해주세요. ");
            System.out.println("------------------------------------------------------------------------");
            System.out.println();


            System.out.println(" 시작 3초 전 ");
            Thread.sleep(1000);
            System.out.println(" 시작 2초 전 ");
            Thread.sleep(1000);
            System.out.println(" 시작 1초 전");
            Thread.sleep(1000);

        }
        catch (Exception e){

        }


        String[] printArray = {"          ", "          ", "          ","          ", "          "}; // 5칸짜리 문자열 배열 선언
        int[] numArray = new int[5];                                        // 5칸짜리 숫자 배열

        for (int i = 0; i < numArray.length; i++)
        {
            Random rd = new Random();
            int randomNum = rd.nextInt(5)+1;    // 1 ~ 5 사이의 랜덤값을 생성해서
            numArray[i] = randomNum;                  // numArray 배열에 담아준다.
        }

        int cnt = 0;

        while(cnt<5)
        {
            try{

                Thread.sleep(1000);

                for (int i = 0; i < 50; i++)
                {
                    System.out.println();
                }

                int index = 0;
                for (int i = 0; i < printArray.length; i++)
                {
                    Random rd = new Random();
                    index = rd.nextInt(5);

                    System.out.println(numArray[i]);
                    //printArray[index] = "    " + numArray[i]+ "    ";
                    //System.out.print(printArray[i]);
                    //printArray[index] = "          ";  //초기화

                }
                System.out.println();


            }catch (Exception e){
            }

            cnt++;
        }

        System.out.print("입력 : ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String numArrayStr = numArray.toString();

        if(input.replace(" ","").equals(numArrayStr))
        {
            result = true;

        }
        else
        {
            result = false;
        }
    }
}
