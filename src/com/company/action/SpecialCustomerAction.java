package com.company.action;

import com.company.data.Beverage;
import com.company.data.Cafe;
import com.company.data.User;
import com.company.run.Ending;
import com.company.thread.OneTimeSound;

import java.util.Random;
import java.util.Scanner;

// CustomerAction <- 상속 -  SpecialCustomerAction
// checkTakeout() 메소드 사용
public class SpecialCustomerAction extends CustomerAction
{
    protected int tip = 1;    // 랜덤으로 주는 팁

    // 특별 손님 등장 메소드
    public void comeSpecialCustomer()
    {
        final int TALK_DOWN = 1;        // 반말하는 유형
        final int FIGHT = 2;            // 시비거는 유형
        final int FALSE_RELIGION = 3;   // 사이비 유형
        final int WRONG = 4;            // 잘못 찾아온 유형
        final int PRESENT = 5;          // 선물주는 유형

        Cafe.setTodayCustomerNum(Cafe.getTodayCustomerNum()+1); // 기존의 하루 방문자 수에 하나 더하기
        Cafe.setTotalCustomerNum(Cafe.getTotalCustomerNum()+1); // 기존의 총 방문자 수에 한명 더하기
        Cafe.setWeekCustomerNum(Cafe.getWeekCustomerNum() + 1); // 기존의 주 방문자 수에 한명 더하기

        SpecialCustomerAction specialCustomer = new SpecialCustomerAction(); // 특별 손님 객체 생성
        Beverage beverage = specialCustomer.orderBeverage();                 // 주문할 음료 객체 생성

        System.out.println();

        // 음료 주문 유형 랜덤으로 실행하기
        Random rd = new Random();
        int typeNum = rd.nextInt(5)+1; //1~5 랜덤값 반환해서 typeNum 변수에 저장

        boolean orderResult = true;         // 주문이 확정되었는지의 여부를 저장하는 변수

        // 랜덤값에 따라 유형 별 손님이 음료 주문 -  음료를 주문하는 경우 true 반환, 주문하지 않는 경우 false 반환
        switch(typeNum)
        {
            case TALK_DOWN:
                orderResult = specialCustomer.orderTalkDown(beverage);      // 반말하는 손님
                break;

            case FIGHT:
                orderResult = specialCustomer.orderFight(beverage);         // 시비거는 손님
                break;

            case FALSE_RELIGION:
                orderResult = specialCustomer.orderFalseReligion();         // 사이비 손님
                break;

            case WRONG:
                orderResult = specialCustomer.orderWrong();                 // 잘못찾아온 손님
                break;

            case PRESENT:
                orderResult = specialCustomer.orderPresent();               // 선물주는 손님
                break;

        }

        // 엔딩 주석 처리
        Ending ending = new Ending();       // 엔딩 객체 생성
        if(User.getHp()==0)                 // 만약 유저의 체력이 0이 된다면
        {
            ending.fallDownEnding();        //  과로 엔딩 메소드 호출
        }
        else if(User.getFeeling() == 0)     // 만약 유저의 인내력이 0이 된다면
        {
            ending.toQuitEnding();          // 퇴사 엔딩 메소드 호출
        }


        if(orderResult)     // 주문이 확정된 경우
        {
            // 유저가 음료 만들기
            UserAction userAction = new UserAction();           // 유저 액션 객체 생성
            boolean result = userAction.makeBeverage(beverage); // 음료 만들기 수행하고 결과를 반환한다.
            userAction.makeBeverageResult(result);              // 결과에 따른 출력

            // 여기서 실패, 성공횟수 더하기
            if(result)                                          // 음료만들기 성공한경우
            {
                User.setTotalSuccessNum(User.getTotalSuccessNum() + 1 ); // 총 음료 제조 성공 횟수 1 증가
                User.setWeekSuccessNum(User.getWeekSuccessNum() + 1);    // 이번주 음료제조 성공횟수 1 증가
                giveTips(tip);                                           // 팁 주기
            }
            else
            {
                User.setTotalFailNum(User.getTotalFailNum() + 1); // 총 음료제조 실패 횟수 1 증가
                User.setWeekFailNum(User.getWeekFailNum() + 1);   // 이번주 음료제조 실패 횟수 1 증가
            }
        }

        // 엔딩 주석 처리
        if(User.getHp()==0)                 // 만약 유저의 체력이 0이 된다면
        {
            //test
            //System.out.println(User.getHp());
            ending.fallDownEnding();        //  과로 엔딩 메소드 호출
        }
        else if(User.getFeeling() == 0)     // 만약 유저의 인내력이 0이 된다면
        {
            ending.toQuitEnding();          // 퇴사 엔딩 메소드 호출
        }
        else if(User.getTotalFailNum()+User.getTotalSuccessNum()/User.getSkillLevel() < User.getWeekFailNum())
        // 총 음료 제조 횟수 / 숙련도 < 이번주 실패 횟수
        {
            ending.getFireEnding();         // 해고 엔딩 메소드 호출
        }

    }

    // 팁주는 메소드
    public void giveTips(int tip)
    {
        Random random = new Random();
        if(random.nextInt(1) == 0) // 랜덤값이 0이면
        {
            Thread sound = new Thread(new OneTimeSound("coin.mp3"));
            sound.start();

            // 유저에게 1코인 추가
            User.setProperty(User.getProperty() + 1);
            System.out.println();
            System.out.println("------------------------------------------------------------------------");
            System.out.printf(" 손님에게 %d 코인의 팁을 받았습니다 ! \n", tip);
            System.out.printf(" 현재 보유 코인 : %d\n", User.getProperty());
            System.out.println("------------------------------------------------------------------------");
            System.out.println();
        }
    }

    // 유형1 반말하는 손님 1: 유저의 체력과 인내력이 -1씩 감소한다.
    // 음료를 주문하는 경우 true, 음료를 주문하지 않는 경우 false 반환
    public boolean orderTalkDown(Beverage beverage)
    {
        String iceOption;       // ICE/HOT 선택하는 손님대사 담는 변수
        String whippingCream;   // 휘핑크림 여부 선택하는 손님대사 담는 변수
        String takeout;         // 테이크아웃 여부 선택하는 손님대사 담는 변수

        // ICE / HOT 선택값에 따라 대사 분기
        if(beverage.getIceOption()==0)  // HOT 선택했을 때
        {
            iceOption = " 뜨거운걸로.";
        }
        else                            // ICE 선택했을 때
        {
            iceOption = " 차가운걸로. ";
        }

        // 휘핑크림 선택값에 따라 대사 분기
        if(beverage.getWhippingCream()==0) // 휘핑크림 안올릴 때
        {
            whippingCream = "";
        }
        else                               // 휘핑크림 올릴 때
        {
            whippingCream = " 휘핑크림.";
        }

        // 테이크아웃 선택 값에 따라 대사 분기
        boolean checkTakeout = checkTakeout();  // 테이크아웃 여부 반환하는 메소드 호출(테이크아웃하면 true 반환)

        if(checkTakeout)                        // 테이크아웃한다면
        {
            takeout = " 테이크아웃.";
        }
        else                                    // 테이크아웃 안한다면
        {
            takeout = "";
        }

        String str = " 손님 : " + iceOption + beverage.getName() + ".\n       " + whippingCream + takeout+"\n";
        String[] strArr = str.split("");

        try
        {
            for (int i = 0; i < strArr.length; i++)
            {
                System.out.printf(strArr[i]);
                Thread.sleep(50);
            }
        }
        catch (Exception e){}

        User.setHp(User.getHp()-1);             // 체력 1 감소
        User.setFeeling(User.getFeeling()-1);   // 인내력 1 감소

        System.out.println("========================================================================");
        System.out.println(" 손님이 반말로 주문하였습니다. ");
        System.out.printf(" %s님의 체력이 1 소모되었습니다.\n", User.getName());
        System.out.printf(" %s님의 인내력이 1 소모되었습니다.\n", User.getName());
        System.out.printf(" 현재 %s님의 체력 : %d\n", User.getName(), User.getHp());
        System.out.printf(" 현재 %s님의 인내력 : %d\n", User.getName(), User.getFeeling());
        System.out.println("========================================================================");


        if(!checkTakeout) // 테이크아웃 안한다면
        {
            // 매장에 자리가 있는지 확인
            if(Cafe.getChairNum()==0)    // 매장에 자리가 없으면 손님이 나간다.
            {
                System.out.println("========================================================================");
                System.out.println(" 매장에 자리가 없어서 손님이 나갔습니다. ");
                System.out.println("========================================================================");
                return false;       // false 반환, 메소드 종료
            }
            else                    // 자리가 있다면
            {
                Cafe.setChairNum(Cafe.getChairNum()-1);// 매장 자리를 하나 줄인다.
            }

            // 유리잔 또는 머그잔 감소시키기.
            if(beverage.getIceOption()==0 && Cafe.getMugNum() !=0 ) // 뜨거운 음료이고 머그잔이 있으면
            {
                Cafe.setMugNum(Cafe.getMugNum() - 1); // 머그잔 1 감소
            }
            else if(beverage.getIceOption()==1 && Cafe.getCupNum() != 0) // 차가운 음료이고 유리잔이 있으면
            {
                Cafe.setCupNum(Cafe.getCupNum() - 1); // 유리잔 1 감소
            }
            else    // 뜨거운 음료인데 머그잔이 없거나 차가운 음료인데 유리잔이 없으면 유저 인내력 1 감소
            {
                User.setFeeling(User.getFeeling() - 1);
                System.out.println("========================================================================");
                System.out.println(" 매장에 잔이 모자라 일회용 컵을 사용했습니다. 컴플레인이 들어왔습니다. ");
                System.out.printf(" %s님의 인내력이 1 소모되었습니다.\n", User.getName());
                System.out.printf(" 현재 %s님의 인내력 : %d\n", User.getName(), User.getFeeling());
                System.out.println("========================================================================");
            }
        }

        return true;
    }


    // 유형2 시비걸기 : 유저의 체력이 1, 인내력이 2 감소한다.
    // 음료를 주문하는 경우 true, 주문하지 않는 경우 false 반환
    public boolean orderFight(Beverage beverage)
    {
        String iceOption;       // ICE/HOT 선택하는 손님대사 담는 변수
        String whippingCream;   // 휘핑크림 여부 선택하는 손님대사 담는 변수
        String takeout;         // 테이크아웃 여부 선택하는 손님대사 담는 변수


        // ICE / HOT 선택값에 따라 대사 분기
        if(beverage.getIceOption()==0)      // HOT 이라면
        {
            iceOption = "이 날씨에 차가운걸 먹겠어요?";
        }
        else                                // ICE 라면
        {
            iceOption = "이 날씨에 뜨거운걸 먹겠어요? ";
        }

        // 휘핑 선택값에 따라 대사 분기
        if(beverage.getWhippingCream()==0) // 휘핑크림 안올린다면
        {
            whippingCream = "누가 여기에 휘핑을 올려요?";
        }
        else                                // 휘핑크림 올린다면
        {
            whippingCream = "당연히 올리죠.";
        }

        // 테이크아웃 선택 값에 따라 대사 분기
        boolean checkTakeout = checkTakeout();  // checkTakeout() 는 테이크아웃하면 true 반환

        if(checkTakeout)                        // 테이크아웃 한다면
        {
            takeout = "하... 테이크아웃이요. 그만 좀 물어보세요";
        }
        else                                    // 테이크아웃 안한다면
        {
            takeout = "하...먹고 갈거에요. 그만 물어보세요.";
        }

        try{

            System.out.println(" 손님 : " + beverage.getName());
            Thread.sleep(200);
            System.out.println();
            Thread.sleep(200);
            System.out.println("         .");
            Thread.sleep(200);
            System.out.println("         .");
            Thread.sleep(200);
            System.out.println("         .");
            Thread.sleep(200);
            System.out.println();
            Thread.sleep(200);
            System.out.printf(" %s님은 ICE/HOT 옵션을 물어봤습니다.\n", User.getName());
            Thread.sleep(200);
            System.out.println();
            Thread.sleep(300);
            System.out.println(" 손님 : " + iceOption);
            Thread.sleep(200);
            System.out.println();
            Thread.sleep(200);
            System.out.printf(" %s님은 휘핑크림을 추가하는지 물어봤습니다.\n", User.getName());
            Thread.sleep(200);
            System.out.println();
            Thread.sleep(300);
            System.out.println(" 손님 : " + whippingCream);
            Thread.sleep(200);
            System.out.println();
            Thread.sleep(200);
            System.out.printf(" %s님은 테이크아웃 여부를 물어봤습니다.\n", User.getName());
            Thread.sleep(200);
            System.out.println();
            Thread.sleep(300);
            System.out.println(" 손님 : " + takeout);
            Thread.sleep(200);
            System.out.println();
            Thread.sleep(200);

        }catch (Exception e){}

        User.setHp(User.getHp()-1);             // 체력 1 감소
        User.setFeeling(User.getFeeling()-2);   // 인내력 2 감소

        System.out.println("========================================================================");
        System.out.println(" 손님이 짜증을 내며 주문했습니다. ");
        System.out.printf(" %s님의 체력이 1 소모되었습니다.\n", User.getName());
        System.out.printf(" %s님의 인내력이 2 소모되었습니다.\n", User.getName());
        System.out.printf(" 현재 %s님의 체력 : %d\n", User.getName(), User.getHp());
        System.out.printf(" 현재 %s님의 인내력 : %d\n", User.getName(), User.getFeeling());
        System.out.println("========================================================================");


        if(!checkTakeout)             // 테이크아웃하지 않는다면
        {
            // 매장에 자리가 있는지 확인
            if(Cafe.getChairNum()==0)    // 매장에 자리가 없으면 손님이 나간다.
            {
                System.out.println("========================================================================");
                System.out.println(" 매장에 자리가 없어서 손님이 나갔습니다. ");
                System.out.println("========================================================================");
                return false;       // false 반환, 메소드 종료
            }
            else                     // 매장에 자리가 있다면 
            {
                Cafe.setChairNum(Cafe.getChairNum()-1);// 매장 자리를 하나 줄인다.
            }

            // 유리잔 또는 머그잔 감소시키기.
            if(beverage.getIceOption()==0 && Cafe.getMugNum() !=0 ) // 뜨거운 음료이고 머그잔이 있으면
            {
                Cafe.setMugNum(Cafe.getMugNum() - 1); // 머그잔 1 감소
            }
            else if(beverage.getIceOption()==1 && Cafe.getCupNum() != 0) // 차가운 음료이고 유리잔이 있으면
            {
                Cafe.setCupNum(Cafe.getCupNum() - 1); // 유리잔 1 감소
            }
            else    // 뜨거운 음료인데 머그잔이 없거나 차가운 음료인데 유리잔이 없으면 유저 인내력 1 감소
            {
                User.setFeeling(User.getFeeling() - 1);
                System.out.println("========================================================================");
                System.out.println(" 매장에 잔이 모자라 일회용 컵을 사용했습니다. 컴플레인이 들어왔습니다. ");
                System.out.printf(" %s님의 인내력이 1 소모되었습니다.\n", User.getName());
                System.out.printf(" 현재 %s님의 인내력 : %d\n", User.getName(), User.getFeeling());
                System.out.println("========================================================================");
            }
        }

        return true;
    }
    
    // 유형3 도를 믿으시나요 : 내보낸 경우 체력 1 감소, 얘기 듣는 경우 체력과 인내력 1씩 감소
    // 음료를 주문하지 않는 손님이므로 false 반환
    public boolean orderFalseReligion()
    {
        boolean check = true;       // 반복여부 담기 위한 변수
        String resultStr;           // 사용자가 입력한 값을 담기 위한 변수
        int result = 0 ;            // 사용자가 입력한 값을 형변환해서 담기 위한 변수

        try{

            String str = " 손님 : 얼굴에 복이 많으세요.\n";
            String[] strArr = str.split("");

            for (int i = 0; i < strArr.length; i++)
            {
                System.out.printf(strArr[i]);
                Thread.sleep(50);
            }

            System.out.println("              :  ");
            Thread.sleep(50);
            System.out.println("              :  ");
            Thread.sleep(50);
            System.out.println();


        }catch (Exception e){}

        while(check)
        {
                System.out.println("========================================================================");
                System.out.println(" 1.내보낸다.  2.얘기를 들어본다 ");
                System.out.println("------------------------------------------------------------------------");
                System.out.print(" 선택 : ");
                Scanner sc = new Scanner(System.in);    // 스캐너 객체 생성
                resultStr = sc.nextLine();              // 사용자에게 값 입력받기

                // 입력받은 값이 숫자인지 확인
                try
                {
                    // 입력받은 값의 공백을 제거하고
                    // 자료형 변경한 뒤(String → int) int형에 담는다.
                    result = Integer.parseInt(resultStr.replace(" ",""));
                    check = false;
                    // int 형으로 변경되면 check 에 false 담아서 반복문 빠져나간다.
                    // int형으로 변경되지 않는다면 NumberFormatException 발생

                    if(result == 1) // 내보낸 경우 인내력 1 감소
                    {
                        User.setFeeling(User.getFeeling()-1);
                        System.out.println("========================================================================");
                        System.out.println(" 사이비 손님이 찾아왔습니다. ");
                        System.out.printf(" %s님의 인내력이 1 소모되었습니다.\n", User.getName());
                        System.out.printf(" 현재 %s님의 인내력 : %d\n", User.getName(), User.getFeeling());
                        System.out.println("========================================================================");
                    }
                    else // 얘기를 들어본 경우 체력과 인내력 1 씩 감소
                    {
                        User.setHp(User.getHp()-1);
                        User.setFeeling(User.getFeeling()-1);
                        System.out.println("========================================================================");
                        System.out.println(" 이야기를 듣다보니 사이비였습니다. 시간을 낭비했습니다 ! ");
                        System.out.printf(" %s님의 체력이 1 소모되었습니다.\n", User.getName());
                        System.out.printf(" %s님의 인내력이 1 소모되었습니다.\n", User.getName());
                        System.out.printf(" 현재 %s님의 체력 : %d\n", User.getName(), User.getHp());
                        System.out.printf(" 현재 %s님의 인내력 : %d\n", User.getName(), User.getFeeling());
                        System.out.println("========================================================================");
                    }

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

        return false;
    }

    // 유형4 잘못찾아옴
    // 음료를 주문하지 않는 손님이므로 false 반환
    public boolean orderWrong()
    {
        String[] menus = {"냉면", "떡볶이", "치킨", "회", "오므라이스", "커리"} ;  // 잘못찾아온 손님이 찾을 메뉴 목록

        Random rd = new Random();
        int menu = rd.nextInt(menus.length);    // 0부터 메뉴 목록 배열의 길이만큼 랜덤 수를 반환해서 변수 menu에 담는다.

        try{

            String str = " 손님 : 여기 " + menus[menu] + " 파나요 ? \n";
            String[] strArr = str.split("");

            for (int i = 0; i < strArr.length; i++)
            {
                System.out.printf(strArr[i]);
                Thread.sleep(50);
            }

            System.out.println("              :  ");
            Thread.sleep(50);
            System.out.println("              :  ");
            Thread.sleep(50);
            System.out.println();


        }catch (Exception e){

        }

        System.out.println("------------------------------------------------------------------------");
        System.out.println(" 잘못 찾아온 손님이었다. ");
        System.out.println("------------------------------------------------------------------------");

        return false;

    }

    // 유형5 의문의 아이템 선물
    // 음료를 주문하지 않으므로 false 반환
    public boolean orderPresent()
    {
        boolean check = true;   // 반복 여부 체크하기 위한 변수
        int result = 0;         // 선택값을 비교하기 위한 변수

        try{
            Thread.sleep(500);
            System.out.println(" 손님 :     ＿人人人人人人人人＿ ");
            System.out.println("           ＞　안녕하십니까!  ＜");
            System.out.println("           ￣^Y^Y^Y^Y^Y^Y^Y￣ ");

        }catch (Exception e){

        }

        System.out.println();
        System.out.println("========================================================================");
        System.out.println(" 우렁찬 손님이 오른손과 왼손을 내밀었다.");


        while(check)
        {
            System.out.println(" 1.오른손 선택 2.왼손 선택");
            System.out.println("------------------------------------------------------------------------");
            System.out.print(" 선택 : ");
            Scanner sc = new Scanner(System.in);
            String resultStr = sc.nextLine();

            // 입력받은 값이 숫자인지 확인
            try
            {
                // 입력받은 값의 공백을 제거하고
                // 자료형 변경한 뒤(String → int) int형에 담는다.
                result = Integer.parseInt(resultStr.replace(" ",""));
                check = false;
                // int 형으로 변경되면 check 에 false 담아서 반복문 빠져나간다.
                // int형으로 변경되지 않는다면 NumberFormatException 발생

                // 현재 HP 또는 feeling 올려주기
                Random rd = new Random();
                int randomNum = rd.nextInt(2) + 1; // 랜덤으로 1 또는 2를 randomNum 변수에 저장

                if (result == randomNum)                 // 선택한 값과 랜덤값이 같다면
                {
                    if (User.getFeeling() != User.getSetFeeling()) // 현재 인내력이 세팅된 인내력(최대 인내력)이 아니라면
                    {
                        Thread sound = new Thread(new OneTimeSound("present.mp3"));
                        sound.start();

                        User.setFeeling(User.getFeeling() + 1); // 현재 인내력 에서 1 증가
                        System.out.println("========================================================================");
                        System.out.printf(" %s님의 인내력이 1 회복되었습니다.\n", User.getName());
                    }
                    else
                    {
                        System.out.println("========================================================================");
                        System.out.printf(" %s님의 인내력이 최댓값입니다.\n", User.getName());
                    }
                    System.out.printf(" 현재 %s님의 인내력 : %d\n", User.getName(), User.getFeeling());
                    System.out.println("========================================================================");

                } else    // 선택한 값과 랜덤값이 다르다면
                {
                    if (User.getHp() != User.getSetHp()) // 현재 체력이 세팅된 체력(최대 체력)이 아니라면
                    {
                        Thread sound = new Thread(new OneTimeSound("present.mp3"));
                        sound.start();

                        User.setHp(User.getHp() + 1);    // 현재 체력에서 1 증가
                        System.out.println("========================================================================");
                        System.out.printf(" %s님의 체력이 1 회복되었습니다.\n", User.getName());
                    }
                    else
                    {
                        System.out.println("========================================================================");
                        System.out.printf(" %s님의 체력이 최댓값입니다.\n", User.getName());
                    }
                    System.out.printf(" 현재 %s님의 체력 : %d\n", User.getName(), User.getHp());
                    System.out.println("========================================================================");

                }
                System.out.println();

            }
            catch (NumberFormatException e) // NumberFormatException 발생한다면
            {
                check = true;   // check 에 true 담아서 다시 반복
                // result = 0; 으로 초기화된 상태이므로  하단 if문 내부까지 실행하고 반복된다.
            }

            if (result < 1 || result > 2)// 주어진 값 이외의 수를 선택한 경우
            {
                System.out.println("========================================================================");
                System.out.println(" 올바른 값을 입력해주세요.");
                check = true;
            }

        }

        try{

            Thread.sleep(500);
            System.out.println(" 손님 :     ＿人人人人人人人人＿ ");
            System.out.println("           ＞  안녕히 계세요! ＜");
            System.out.println("           ￣^Y^Y^Y^Y^Y^Y^Y￣ ");
            System.out.println();
        }
        catch (Exception e){}

        return false;       

    }// end orderPresent()

}
