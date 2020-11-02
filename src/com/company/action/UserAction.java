package com.company.action;
import com.company.data.Beverage;
import com.company.data.Cafe;
import com.company.data.Item;
import com.company.data.User;

import java.util.Random;
import java.util.Scanner;

// 아르바이트생(User)의 기능을 담은 클래스
public class UserAction
{
    // 음료 만드는 메소드
    public boolean makeBeverage(Beverage beverage)
    {
        final int TYPING_GAME = 1;  // 음료 만드는 유형 변수 - 타이핑하기
        final int QUIZ_GAME = 2;    // 음료 만드는 유형 변수 - 퀴즈풀기
        final int RPS_GAME = 3;     // 음료 만드는 유형 변수 - 가위바위보

        boolean result = false;     // 음료 제조 결과 반환하기 위한 변수 (성공하면 true, 실패하면 false를 반환한다)

        Random rd = new Random();                       // 랜덤 객체 생성
        int makeBeverageType = rd.nextInt(3) + 1; // 1~3의 랜덤값을 makeBeverageType 변수에 담는다.

        UserAction userAction = new UserAction();        // 유저 액션 객체 생성
        switch (makeBeverageType)                        // 랜덤값 결과에 따라
        {
            case TYPING_GAME:
                result = userAction.makeBeverageTyping(beverage);   // 타이핑 게임 메소드 호출
                break;

            case QUIZ_GAME:
                result = makeBeverageQuiz(beverage);                // 퀴즈 게임 메소드 호출
                break;

            case RPS_GAME :
                result = makeBeverageRPS();                         // 가위바위보 메소드 호출
                break;
        }

        return result;  // 음료 제조 결과 반환
    }

    // 음료 만드는 미니게임1 : 제시하는 문자열 따라치기
    public boolean makeBeverageTyping(Beverage beverage)
    {
        // 랜덤 값에 따라 생성할 문자 유형 지정하는 변수
        final int RANDOM_NUM = 1;               // 숫자
        final int RANDOM_SMALL_LETTER = 2;      // 소문자
        final int RANDOM_CAPITAL_LETTER = 3;    // 대문자

        int makeLevel = beverage.getMakeLevel(); // 음료 만드는 난이도. 1~5의 수
        boolean result = false;                  // 음료 제조 결과 담기 위한 변수

        System.out.println();
        System.out.println("------------------------------------------------------------------------");
        System.out.println("                             음료 만들기 ");
        System.out.println("------------------------------------------------------------------------");
        System.out.println(" 하단에 제시된 문자를 동일하게 타이핑해주세요. ");
        System.out.println();

        // 랜덤 문자열 생성
        Random rd = new Random();               // 랜덤 객체 생성
        StringBuffer sb = new StringBuffer();   // StringBuffer 객체 생성(String 은 + 연산마다 새로운 객체가 생성된다.)
        for (int i = 0; i < makeLevel * 2; i++) // 난이도에 따라 반복횟수가 늘어나면서 문자열 길이가 증가한다.
        {
            /*
            아스키코드에서 영어 대문자는 65~90이고, 영어 소문자는 97~122 이다.
            0~25까지의 난수에 + 65 를 하면 대문자를 얻을 수있고
            동일한 범위의 난수에 + 97을 하면 소문자를 얻을 수 있다.
            */

            int rdNum = rd.nextInt(3) + 1; // 1~3 범위의 난수 반환해서 어떤 유형의 랜덤값을 생성할지 rdNum 변수에 담는다.
            switch (rdNum)
            {
                case RANDOM_SMALL_LETTER:               // 하나의 랜덤 소문자 생성
                    sb.append((char) (rd.nextInt(26) + 65));
                    break;
                case RANDOM_CAPITAL_LETTER:             // 하나의 랜덤 대문자 생성
                    sb.append((char) (rd.nextInt(26) + 97));
                    break;
                case RANDOM_NUM:                        // 하나의 랜덤 숫자 생성
                    sb.append(rd.nextInt(10));
                    break;
            }
        }

        System.out.println(" " + sb);       // 생성된 랜덤 문자열 출력

        System.out.print(" 입력 : ");       // 사용자에게서 문자열 입력받기
        Scanner sc = new Scanner(System.in);
        String inputStr = sc.nextLine();

        inputStr = inputStr.replace(" ", ""); // 입력받은 문자열 공백 제거

        // stringbuffer → String으로 변환
        String sbStr = sb.toString();

        /*
        String →  Object 클래스의 equals() 오버라이딩
        Stringbuffer → equals() 오버라이딩 x , Object 클래스의 equals() 사용.

        Object 클래스의 equals() 는 메모리주소와 값이 모두 같아야 true 반환
        String 클래스의 equals() 는 메모리주소가 달라도 값이 같으면 true 반환
        */

        // 제시한 문자열과 입력받은 문자열이 일치하는지 비교
        if (sbStr.equals(inputStr))                                   // 일치하면
        {
            result = true;                                            // result 에 true 를 담고(true 반환)
            //User.setTotalSuccessNum(User.getTotalSuccessNum() + 1);   // 음료제조 총 성공횟수 1 증가
            //User.setWeekSuccessNum(User.getWeekSuccessNum() + 1);     // 이번주 음료제조 성공횟수 1 증가
        }
        else                                                          // 일치하지 않으면
        {
            //User.setTotalFailNum(User.getTotalFailNum() + 1);         // 음료제조 총 실패 횟수 1 증가
            //User.setWeekFailNum(User.getWeekFailNum() + 1);           // 이번주 음료제조 실패 횟수 1 증가

            User.setHp(User.getHp() - 1 );                            // 유저 체력 1 감소 , false 반환
        }

        return result;
    }

    // 음료 만드는 미니게임 2 : 레시피 외우기(퀴즈)
    public boolean makeBeverageQuiz(Beverage beverage)
    {
        boolean result = false;  // 이 메소드가 반환하는 값을 담을 변수

        String resultStr;        // 사용자에게 입력받은 값을 담기 위한 변수
        int quizResult = 0;      // 사용자에게 입력받은 값을 형변환해서 담기 위한 변수
        boolean check = true;    // 반복여부 결정할 변수

        final int YES = 1;       // 퀴즈 선택지 (1. 그렇다)

        // 음료 관련 변수
        boolean ismilk = beverage.isMilk();                 // 우유 들어가는 음료인지의 여부를 담을 변수
        int whippingCream = beverage.getWhippingCream();    // 0이면 휘핑크림 X , 1이면 휘핑크림 O
        int iceOption = beverage.getIceOption();            // 0이면 ICE , 1이면 HOT

        Scanner sc = new Scanner(System.in);                // 스캐너 객체 생성

        System.out.println();
        System.out.println("------------------------------------------------------------------------");
        System.out.println("                            음료 만들기 ");
        System.out.println("------------------------------------------------------------------------");
        System.out.println(" 퀴즈를 맞혀주세요. ");

        // 퀴즈 1 : 우유 들어가는 음료인지
        while (check)
        {
            System.out.println();
            System.out.println(" Q.주문받은 음료는 우유가 들어간다.");
            System.out.println(" 1. 그렇다  2. 아니다");
            System.out.println("------------------------------------------------------------------------");
            System.out.print(" 선택 : ");

            resultStr = sc.nextLine();      // 사용자에게 입력받은 값을 변수에 담는다.

            // 입력받은 값이 숫자인지 확인
            try
            {
                // 자료형 변경한 뒤(String → int) int형에 담는다.
                quizResult = Integer.parseInt(resultStr);
                check = false;
                // int 형으로 변경되면 check 에 false 담아서 반복문 빠져나간다.
                // int형으로 변경되지 않는다면 NumberFormatException 발생

                if (quizResult < 1 || quizResult > 2)// 주어진 값 이외의 수를 선택한 경우
                {
                    System.out.println("========================================================================");
                    System.out.println(" 올바른 값을 입력해주세요.");
                    System.out.println("========================================================================");
                    check = true;
                }
                else if (ismilk) // 우유가 들어갔다면
                {
                    System.out.println("------------------------------------------------------------------------");

                    if (quizResult == YES)
                    {
                        System.out.println(" 정답입니다. ");
                    }
                    else
                    {
                        System.out.println(" 오답입니다. ");

                        //User.setTotalFailNum(User.getTotalFailNum() + 1); // 총 음료제조 실패 횟수 1 증가
                        //User.setWeekFailNum(User.getWeekFailNum() + 1);   // 이번주 음료제조 실패 횟수 1 증가

                        // test
                        //System.out.println(User.getWeekFailNum() + 1);

                        User.setHp(User.getHp() - 1 );                    // 유저 체력 1 감소
                        return false;                                     // false 반환, 메소드 종료
                    }
                }
                else // 우유가 들어가지 않았다면
                {
                    System.out.println("------------------------------------------------------------------------");
                    if (quizResult == YES)
                    {
                        System.out.println(" 오답입니다. ");
                        //User.setTotalFailNum(User.getTotalFailNum() + 1); // 총 음료제조 실패 횟수 1 증가
                        //User.setWeekFailNum(User.getWeekFailNum() + 1);   // 이번주 음료제조 실패 횟수 1 증가

                        // test
                        //System.out.println(User.getWeekFailNum() + 1);

                        User.setHp(User.getHp() - 1 );                    // 유저 체력 1 감소
                        return false;                                     // false 반환, 메소드 종료
                    }
                    else
                    {
                        System.out.println(" 정답입니다. ");
                    }
                }

            } catch (NumberFormatException e) // NumberFormatException 발생한다면
            {
                System.out.println("========================================================================");
                System.out.println(" 올바른 값을 입력해주세요.");
                System.out.println("========================================================================");
                check = true;   // check 에 true 담아서 다시 반복
            }

        }

        check = true;       // 반복문 다시 작동하도록 true 로 초기화



        // 퀴즈 2 : ICE 인지 HOT 인지
        while (check)
        {
            System.out.println();
            System.out.println(" Q.주문받은 음료는 ICE 이다.");
            System.out.println(" 1. 그렇다  2. 아니다");
            System.out.println("------------------------------------------------------------------------");
            System.out.print(" 선택 : ");

            resultStr = sc.nextLine();      // 사용자에게 입력받은 값을 변수에 담는다.

            // 입력받은 값이 숫자인지 확인
            try
            {
                // 자료형 변경한 뒤(String → int) int형에 담는다.
                quizResult = Integer.parseInt(resultStr);
                check = false;
                // int 형으로 변경되면 check 에 false 담아서 반복문 빠져나간다.
                // int형으로 변경되지 않는다면 NumberFormatException 발생

                if (quizResult < 1 || quizResult > 2)// 주어진 값 이외의 수를 선택한 경우
                {
                    System.out.println("========================================================================");
                    System.out.println(" 올바른 값을 입력해주세요.");
                    System.out.println("========================================================================");
                    check = true;
                }
                else if (iceOption == 1) // ICE 라면
                {
                    System.out.println("------------------------------------------------------------------------");

                    if (quizResult == YES)
                    {
                        System.out.println(" 정답입니다. ");
                    }
                    else
                    {
                        System.out.println(" 오답입니다. ");

                        //User.setTotalFailNum(User.getTotalFailNum() + 1); // 총 음료제조 실패 횟수 1 증가
                        //User.setWeekFailNum(User.getWeekFailNum() + 1);   // 이번주 음료제조 실패 횟수 1 증가

                        // test
                        //System.out.println(User.getWeekFailNum() + 1);

                        User.setHp(User.getHp() - 1 );                    // 유저 체력 1 감소
                        return false;                                     // false 반환, 메소드 종료
                    }
                }
                else // ICE가 아니라면
                {
                    System.out.println("------------------------------------------------------------------------");
                    if (quizResult == YES)
                    {
                        System.out.println(" 오답입니다. ");
                       // User.setTotalFailNum(User.getTotalFailNum() + 1); // 총 음료제조 실패 횟수 1 증가
                       // User.setWeekFailNum(User.getWeekFailNum() + 1);   // 이번주 음료제조 실패 횟수 1 증가

                        // test
                        //System.out.println(User.getWeekFailNum() + 1);

                        User.setHp(User.getHp() - 1);                     // 유저 체력 1 감소
                        return false;                                     // false 반환, 메소드 종료
                    }
                    else
                    {
                        System.out.println(" 정답입니다. ");
                    }
                }

            } catch (NumberFormatException e) // NumberFormatException 발생한다면
            {
                System.out.println("========================================================================");
                System.out.println(" 올바른 값을 입력해주세요.");
                System.out.println("========================================================================");
                check = true;   // check 에 true 담아서 다시 반복
            }

        }
        
            check = true;       // 반복문 다시 작동하도록 true 로 초기화

        
            // 퀴즈 3 : 휘핑크림 추가했는지
            while (check)
            {
                System.out.println();
                System.out.println(" Q.주문받은 음료는 휘핑크림을 올린다.");
                System.out.println(" 1. 그렇다  2. 아니다");
                System.out.println("------------------------------------------------------------------------");
                System.out.print(" 선택 : ");
                resultStr = sc.nextLine();      // 값 입력받기

                // 입력받은 값이 숫자인지 확인
                try
                {
                    // 자료형 변경한 뒤(String → int) int형에 담는다.
                    quizResult = Integer.parseInt(resultStr);
                    check = false;
                    // int 형으로 변경되면 check 에 false 담아서 반복문 빠져나간다.
                    // int형으로 변경되지 않는다면 NumberFormatException 발생

                    if (quizResult < 1 || quizResult > 2)// 주어진 값 이외의 수를 선택한 경우
                    {
                        System.out.println("========================================================================");
                        System.out.println(" 올바른 값을 입력해주세요.");
                        System.out.println("========================================================================");
                        check = true;
                    }
                    else if (whippingCream == 1) // 휘핑크림 올라간다면
                    {
                        System.out.println("------------------------------------------------------------------------");
                        if (quizResult == YES)
                        {
                            System.out.println(" 정답입니다. ");
                            //User.setTotalSuccessNum(User.getTotalSuccessNum() + 1 ); // 총 음료제조 성공 횟수 1 증가
                            //User.setWeekSuccessNum(User.getWeekSuccessNum() + 1);    // 이번주 음료제조 성공횟수 1 증가
                            result = true;  // true 값 반환하도록 변수에 담는다

                        } else
                        {
                            System.out.println(" 오답입니다. ");

                            //User.setTotalFailNum(User.getTotalFailNum() + 1); // 총 음료제조 실패 횟수 1 증가
                            //User.setWeekFailNum(User.getWeekFailNum() + 1);   // 이번주 음료제조 실패 횟수 1 증가

                            // test
                            //System.out.println(User.getWeekFailNum() + 1);

                            User.setHp(User.getHp() - 1 );                    // 유저 체력 1 감소
                            result = false;                                   // false 반환, 메소드 종료
                        }
                    }
                    else // 휘핑크림 올라가지 않는다면
                    {
                        System.out.println("------------------------------------------------------------------------");
                        if (quizResult == YES)
                        {
                            System.out.println(" 오답입니다. ");
                            //User.setTotalFailNum(User.getTotalFailNum() + 1);   // 총 음료제조 실패 횟수 1 증가
                           // User.setWeekFailNum(User.getWeekFailNum() + 1);     // 이번주 음료제조 실패 횟수 1 증가
                            // test
                            //System.out.println(User.getWeekFailNum() + 1);

                            User.setHp(User.getHp() - 1 );                      // 유저 체력 1 감소
                            return false;                                       // false 반환, 메소드 종료

                        } else
                        {
                            System.out.println(" 정답입니다. ");
                           //User.setTotalSuccessNum(User.getTotalSuccessNum() + 1 ); // 총 음료 제조 성공 횟수 1 증가
                            //User.setWeekSuccessNum(User.getWeekSuccessNum() + 1);    // 이번주 음료제조 성공횟수 1 증가
                            result = true;  // true 값 반환
                        }
                    }

                } catch (NumberFormatException e) // NumberFormatException 발생한다면
                {
                    System.out.println("========================================================================");
                    System.out.println(" 올바른 값을 입력해주세요.");
                    System.out.println("========================================================================");
                    check = true;   // check 에 true 담아서 다시 반복
                }

            }

        return result;

    }// end makeBeverageQuiz()


    // 음료만드는 미니게임3 : 가위바위보
    public boolean makeBeverageRPS()
    {
        System.out.println("------------------------------------------------------------------------");
        System.out.println("                             음료 만들기 ");
        System.out.println("------------------------------------------------------------------------");
        System.out.println(" 손님과 가위바위보를 해서 이기세요. ");
        System.out.println("------------------------------------------------------------------------");

        boolean result = true;  // 게임 결과 담는 변수
        boolean check = true;   // 반복여부 체크하는 변수
        String selectStr;       // 사용자의 선택값을 담을 변수
        int select = 0;         // selectStr를 int 로 변환해 사용자의 선택값을 담을 변수

        while(check)
        {
            System.out.println(" 1. 가위  2.바위  3.보 ");
            System.out.println("------------------------------------------------------------------------");
            Scanner sc = new Scanner(System.in);
            System.out.print(" 선택 : ");
            selectStr = sc.nextLine();

            // 입력받은 값이 숫자인지 확인
            try
            {
                // 자료형 변경한 뒤(String → int) int형에 담는다.
                select = Integer.parseInt(selectStr);
                // int형으로 변경되지 않는다면 NumberFormatException 발생

                if (select < 1 || select > 3)// 주어진 값 이외의 수를 선택한 경우
                {
                    System.out.println("========================================================================");
                    System.out.println(" 올바른 값을 입력해주세요.");
                    check = true;
                }
                else
                {
                    // 손님의 선택값을 랜덤으로 지정
                    Random rd = new Random();                   // 랜덤 객체 생성
                    int randomNum = rd.nextInt(3);        // 0~2 사이의 랜덤값을 randomNum 변수에 담는다.

                    final int ROCK = 1;     // 바위
                    final int PAPER = 2;    // 보
                    final int SCISSOR = 3;  // 가위

                    if(randomNum == select)     // 손님의 선택값과 유저의 선택값이 같으면
                    {
                        System.out.println("------------------------------------------------------------------------");
                        System.out.println(" 비겼습니다! 다시 진행해주세요 ");
                        check = true;       // 반복하도록 check 에 true 값을 담는다.
                    }
                    else if(randomNum == ROCK && select == PAPER
                            || randomNum == PAPER && select == SCISSOR
                            || randomNum == SCISSOR && select == ROCK)  // 유저가 이기는 경우라면
                    {
                        System.out.println("------------------------------------------------------------------------");
                        System.out.println(" 손님에게 이겼습니다 ! ");
                        result = true;      // 결과에 true 값을 담는다.
                        check = false;      // 반복문을 빠져나간다.


                    }
                    else    // 유저가 지는 경우라면
                    {
                        System.out.println("------------------------------------------------------------------------");
                        System.out.println(" 손님에게 졌습니다 ! ");

                        User.setHp(User.getHp() - 1);   // 유저 체력 1 감소
                        result = false;                 // 결과에 false 값을 담는다.
                        check = false;                  // 반복문을 빠져나간다.
                    }
                }

            }
            catch (NumberFormatException e) // NumberFormatException 발생한다면
            {
              check = true;   // check 에 true 담아서 다시 반복
              // select = 0; 으로 초기화된 상태이므로  하단 if문 내부까지 실행하고 반복된다.
            }

        }

        return result;
    }

    // 음료 제조 결과 출력하는 메소드
    public void makeBeverageResult(boolean result)
    {
        if(result == false)     // 음료 실패했을 경우
        {
            System.out.println("------------------------------------------------------------------------");
            System.out.println("                            음료 만들기 실패 ! ");
            System.out.println("------------------------------------------------------------------------");
            System.out.printf(" %s님의 체력이 1 소모되었습니다.\n", User.getName());
            System.out.printf(" 현재 %s님의 체력 : %d\n", User.getName(), User.getHp());
            System.out.println("========================================================================");

        }
        else
        {
            System.out.println("------------------------------------------------------------------------");
            System.out.println("                          ✨ 음료 만들기 성공 ✨  ");
            System.out.println("------------------------------------------------------------------------");
        }

    }

    // 이전 플레이의 모든 값 리셋
    public void reset()
    {
        // 유저 관련 값 리셋
        User.setSetHp(5);
        User.setSetFeeling(5);
        User.setHp(5);
        User.setFeeling(5);
        User.setProperty(0);
        User.setSkillLevel(1);
        User.setWorkingDays(0);
        User.setTotalSuccessNum(0);
        User.setTotalFailNum(0);
        User.setWeekFailNum(0);
        User.setWeekSuccessNum(0);

        // 아이템 관련 값 리셋
        Item.setCake(0);
        Item.setSandwich(0);
        Item.setChoco(0);
        Item.setMacaron(0);

        // 카페 관련 값 리셋
        Cafe.setTotalCustomerNum(0);
        Cafe.setTodayCustomerNum(0);
        Cafe.setWeekCustomerNum(0);
        Cafe.setSetChair(1);
        Cafe.setSetCup(1);
        Cafe.setSetMug(1);

    }

}// end class