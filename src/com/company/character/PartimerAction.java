package com.company.character;

import com.company.beverage.Beverage;
import java.util.Random;
import java.util.Scanner;

public class PartimerAction
{
    // 음료 만드는 메소드
    public boolean makeBeverage(Beverage beverage)
    {
        final int typingGame = 1;
        boolean result = false;

        Random rd = new Random();
        int makeBeverageType = rd.nextInt(3) + 1; // 1~3의 랜덤값을 makeBeverageType 변수에 담는다.
        PartimerAction partimerAction = new PartimerAction();

        switch (makeBeverageType)
        {
            case 1:
                result = partimerAction.makeBeverageTyping(beverage);   // 타이핑 게임
                break;

            case 2:
                result = makeBeverageQuiz(beverage);    // 퀴즈 게임

                break;

            case 3:
                result = makeBeverageQuiz(beverage);    // 변경하기@@

                break;
        }

        return result;
    }

    // 음료 만드는 미니게임 메소드1 : 제시하는 문자 따라치기
    public boolean makeBeverageTyping(Beverage beverage)
    {
        final int RANDOM_NUM = 1;
        final int RANDOM_SMALL_LETTER = 2;
        final int RANDOM_CAPITAL_LETTER = 3;

        int makeLevel = beverage.getMakeLevel();            // 음료 만드는 난이도. 1~5의 수
        boolean result = false;

        System.out.println();
        System.out.println("------------------------------------------------------------------------");
        System.out.println("                            음료 만들기 ");
        System.out.println("------------------------------------------------------------------------");
        System.out.println(" 하단에 제시된 문자를 동일하게 타이핑해주세요. ");
        System.out.println();

        // 랜덤 문자열 생성
        Random rd = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < makeLevel * 2; i++)   // 난이도에 따라 문자열 길이가 증가한다.
        {
            /*
            아스키코드에서 영어 대문자는 65~90이고, 영어 소문자는 97~122 이다.
            0~25까지의 난수에 + 65 를 하면 대문자를 얻을 수있고
            동일한 범위의 난수에 + 97을 하면 소문자를 얻을 수 있다.
            */
            int rdNum = rd.nextInt(3) + 1; // 1~3 범위의 난수 반환해서 rdNum 변수에 담는다.
            switch (rdNum)
            {
                case RANDOM_SMALL_LETTER: // 랜덤 소문자 생성
                    sb.append((char) (rd.nextInt(26) + 65));
                    break;
                case RANDOM_CAPITAL_LETTER: // 랜덤 대문자 생성
                    sb.append((char) (rd.nextInt(26) + 97));
                    break;
                case RANDOM_NUM:    // 한 자리의 랜덤 숫자 생성
                    sb.append(rd.nextInt(10));
                    break;
            }
        }

        System.out.println(" " + sb);

        System.out.printf(" 입력 : ");
        Scanner sc = new Scanner(System.in);
        String inputStr = sc.nextLine();

        inputStr = inputStr.replaceAll(" ", ""); // 입력받은 문자열 공백 제거

        // stringbuffer → String으로
        String sbStr = sb.toString();

        /*
        String →  Object 클래스의 equals() 오버라이딩
        Stringbuffer → equals() 오버라이딩 x , Object 클래스의 equals() 사용.

        Object 클래스의 equals() 는 메모리주소와 값이 모두 같아야 true 반환
        String 클래스의 equals() 는 메모리주소가 달라도 값이 같으면 true 반환
        */

        // 제시한 문자열과 입력받은 문자열이 일치하는지 비교
        if (sbStr.equals(inputStr)) // 일치하면
        {
            result = true;

            Partimer.setSuccessNum(Partimer.getSuccessNum() + 1); // 음료제조 성공횟수 1 증가
        } else    // 일치하지 않으면
        {
            Partimer.setFailNum(Partimer.getFailNum() + 1);   // 음료제조 실패 횟수 1 증가
            Partimer.setHp(Partimer.getHp() - 1 );            // 유저 체력 1 감소
        }

        return result;
    }

    // 음료 만드는 메소드2 : 레시피 외우기(퀴즈)
    public boolean makeBeverageQuiz(Beverage beverage)
    {
        boolean result = false;  // 이 메소드가 반환하는 값을 담을 변수
        boolean check = true;    // 반복여부 결정할 변수
        String resultStr;
        int quizResult = 0;


        // 음료 관련 변수
        boolean ismilk = beverage.isMilk();                 // 우유 들어가는 음료인지의 여부를 담을 변수
        int whippingCream = beverage.getWhippingCream();    // 0이면 휘핑크림 X , 1이면 휘핑크림 O
        int iceOption = beverage.getIceOption();            // 0이면 ICE , 1이면 HOT

        Scanner sc = new Scanner(System.in);                // 스캐너 객체 생성

        System.out.println();
        System.out.println("------------------------------------------------------------------------");
        System.out.println("                            음료 만들기 ");
        System.out.println("------------------------------------------------------------------------");
        System.out.println(" 하단에 제시된 퀴즈를 맞혀주세요. ");
        System.out.println();

        // 퀴즈 1 : 우유 들어가는 음료인지
        while (check)
        {

            System.out.println(" 주문받은 음료는 우유가 들어간다.");
            System.out.println(" 1. 그렇다  2. 아니다");
            System.out.println("------------------------------------------------------------------------");
            System.out.print(" 선택 : ");

            resultStr = sc.nextLine();

            // 입력받은 값이 숫자인지 확인
            try
            {
                // 자료형 변경한 뒤(String → int) int형에 담는다.
                // int 형으로 변경되면 check 에 false 담아서 반복문 빠져나간다.
                // int형으로 변경되지 않는다면 NumberFormatException 발생
                quizResult = Integer.parseInt(resultStr);
                check = false;

                if (ismilk) // 우유가 들어갔다면
                {
                    if (quizResult == 1)
                    {
                        System.out.println("------------------------------------------------------------------------");
                        System.out.println(" 정답입니다. ");
                    }
                    else
                    {
                        System.out.println("------------------------------------------------------------------------");
                        System.out.println(" 오답입니다. ");

                        Partimer.setFailNum(Partimer.getFailNum() + 1); // 음료 제조 실패 횟수 1 증가
                        Partimer.setHp(Partimer.getHp() - 1 );            // 유저 체력 1 감소
                        return false;
                    }
                }
                else // 우유가 들어가지 않았다면
                {
                    if (quizResult == 1)
                    {
                        System.out.println("------------------------------------------------------------------------");
                        System.out.println(" 오답입니다. ");
                        Partimer.setFailNum(Partimer.getFailNum() + 1); // 음료 제조 실패 횟수 1 증가
                        Partimer.setHp(Partimer.getHp() - 1 );            // 유저 체력 1 감소
                        return false;
                    }
                    else
                    {
                        System.out.println("------------------------------------------------------------------------");
                        System.out.println(" 정답입니다. ");
                    }
                }

            } catch (NumberFormatException e) // NumberFormatException 발생한다면
            {
                check = true;   // check 에 true 담아서 다시 반복
                // result = 0; 으로 초기화된 상태이므로  하단 if문 내부까지 실행하고 반복된다.
            }

            if (quizResult < 1 || quizResult > 2)// 주어진 값 이외의 수를 선택한 경우
            {
                System.out.println("========================================================================");
                System.out.println(" 올바른 값을 입력해주세요.");
                check = true;
            }

        }

        check = true;       // 반복문 다시 작동하도록 true 로 초기화

        // 퀴즈 2 : ICE 인지 HOT 인지
        while (check)
        {
            System.out.println("========================================================================");
            System.out.println();
            System.out.println(" 주문받은 음료는 ICE 이다.");
            System.out.println(" 1. 그렇다  2. 아니다");
            System.out.println("------------------------------------------------------------------------");
            System.out.print(" 선택 : ");

            resultStr = sc.nextLine();

            // 입력받은 값이 숫자인지 확인
            try
            {
                // 자료형 변경한 뒤(String → int) int형에 담는다.
                // int 형으로 변경되면 check 에 false 담아서 반복문 빠져나간다.
                // int형으로 변경되지 않는다면 NumberFormatException 발생
                quizResult = Integer.parseInt(resultStr);
                check = false;

                if (iceOption == 1) // ICE 라면
                {
                    if (quizResult == 1)
                    {
                        System.out.println("------------------------------------------------------------------------");
                        System.out.println(" 정답입니다. ");
                    } else
                    {
                        System.out.println("------------------------------------------------------------------------");
                        System.out.println(" 오답입니다. ");

                        Partimer.setFailNum(Partimer.getFailNum() + 1); // 음료 제조 실패 횟수 1 증가
                        Partimer.setHp(Partimer.getHp() - 1 );            // 유저 체력 1 감소
                        return false;
                    }
                } else // HOT 이라면
                {
                    if (quizResult == 1)
                    {
                        System.out.println("------------------------------------------------------------------------");
                        System.out.println(" 오답입니다. ");
                        Partimer.setFailNum(Partimer.getFailNum() + 1); // 음료 제조 실패 횟수 1 증가
                        Partimer.setHp(Partimer.getHp() - 1 );            // 유저 체력 1 감소

                        return false;
                    } else
                    {
                        System.out.println("------------------------------------------------------------------------");
                        System.out.println(" 정답입니다. ");
                    }
                }


            } catch (NumberFormatException e) // NumberFormatException 발생한다면
            {
                check = true;   // check 에 true 담아서 다시 반복
                // result = 0; 으로 초기화된 상태이므로  하단 if문 내부까지 실행하고 반복된다.
            }

            if (quizResult < 1 || quizResult > 2)// 주어진 값 이외의 수를 선택한 경우
            {
                System.out.println("========================================================================");
                System.out.println(" 올바른 값을 입력해주세요.");
                check = true;
            }

            check = true;       // 반복문 다시 작동하도록 true 로 초기화

            // 퀴즈 3 : 휘핑크림 추가했는지
            while (check)
            {
                System.out.println("========================================================================");
                System.out.println();
                System.out.println(" 주문받은 음료는 휘핑크림을 올린다.");
                System.out.println(" 1. 그렇다  2. 아니다");
                System.out.println("------------------------------------------------------------------------");
                System.out.print(" 선택 : ");
                resultStr = sc.nextLine();      // 값 입력받기

                // 입력받은 값이 숫자인지 확인
                try
                {
                    // 자료형 변경한 뒤(String → int) int형에 담는다.
                    // int 형으로 변경되면 check 에 false 담아서 반복문 빠져나간다.
                    // int형으로 변경되지 않는다면 NumberFormatException 발생
                    quizResult = Integer.parseInt(resultStr);
                    check = false;

                    if (whippingCream == 1) // 휘핑크림 올라간다면
                    {
                        if (quizResult == 1)
                        {
                            System.out.println("------------------------------------------------------------------------");
                            System.out.println(" 정답입니다. ");
                            Partimer.setSuccessNum(Partimer.getSuccessNum() + 1 ); // 음료 제조 성공 횟수 1 증가
                            result = true;  // true 값 반환

                        } else
                        {
                            System.out.println("------------------------------------------------------------------------");
                            System.out.println(" 오답입니다. ");

                            Partimer.setFailNum(Partimer.getFailNum() + 1); // 음료 제조 실패 횟수 1 증가
                            Partimer.setHp(Partimer.getHp() - 1 );            // 유저 체력 1 감소
                            return false;
                        }
                    } else // 휘핑크림 올라가지 않는다면
                    {
                        if (quizResult == 1)
                        {
                            System.out.println("------------------------------------------------------------------------");
                            System.out.println(" 오답입니다. ");
                            Partimer.setFailNum(Partimer.getFailNum() + 1); // 음료 제조 실패 횟수 1 증가
                            Partimer.setHp(Partimer.getHp() - 1 );            // 유저 체력 1 감소
                            return false;

                        } else
                        {
                            System.out.println("------------------------------------------------------------------------");
                            System.out.println(" 정답입니다. ");
                            Partimer.setSuccessNum(Partimer.getSuccessNum() + 1 ); // 음료 제조 성공 횟수 1 증가
                            result = true;  // true 값 반환
                        }
                    }

                } catch (NumberFormatException e) // NumberFormatException 발생한다면
                {
                    check = true;   // check 에 true 담아서 다시 반복
                    // result = 0; 으로 초기화된 상태이므로  하단 if문 내부까지 실행하고 반복된다.
                }

                if (quizResult < 1 || quizResult > 2)// 주어진 값 이외의 수를 선택한 경우
                {
                    System.out.println("========================================================================");
                    System.out.println(" 올바른 값을 입력해주세요.");
                    check = true;
                }

            }

        }
        return result;


    }// end makeBeverageQuiz()


    // 음료 만드는 메소드 3 :


    // 음료 제조 결과 출력하는 메소드
    public void makeBeverageResult(boolean result)
    {
        if(result == false)     // 음료 실패했을 경우
        {
            System.out.println("------------------------------------------------------------------------");
            System.out.println("                            음료 만들기 실패 ! ");
            System.out.println("------------------------------------------------------------------------");
            System.out.printf(" %s님의 체력이 1 소모되었습니다.\n", Partimer.getName());
            System.out.printf(" 현재 %s님의 체력 : %d\n", Partimer.getName(), Partimer.getHp());
            System.out.println("========================================================================");
        }
        else
        {
            System.out.println("------------------------------------------------------------------------");
            System.out.println("                          ✨ 음료 만들기 성공 ✨  ");
            System.out.println("------------------------------------------------------------------------");
        }

    }

    // 주급받기 메소드


    // 장비 구매 시 계산하는 메소드

    // 현재 상태 보여주는 메소드


}// end class