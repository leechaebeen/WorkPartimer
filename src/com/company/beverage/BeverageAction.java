package com.company.beverage;

import sun.net.www.protocol.http.HttpURLConnection;

public class BeverageAction
{
    // 음료 주문이 랜덤으로 들어오면 그에 해당하는 음료 객체를 생성하는 메소드
    public void createBeverage(int beverageOrder, boolean iceOption, boolean whippingCream)
    {
        // 음료를 나타내는 상수. 변경하지 못하도록 final 사용
        final int AMERICANO = 1;     // 아메리카노
        final int CAFE_LATTE = 2;    // 카페라떼
        final int VANILLA_LATTE = 3; // 바닐라라떼
        final int HAZEL_LATTE = 4;   // 헤이즐넛라떼
        final int CAFE_MOCHA = 5;    // 카페모카

        switch(beverageOrder)
        {
              case AMERICANO:
                  Beverage americano = new Beverage(iceOption, false, whippingCream , 1);
                  // 우유가 들어가는 음료인지의 여부와 음료를 만드는 난이도는 정해져있지만
                  // HOT/ICE 옵션과 휘핑크림은 손님의 선택에 따라 바뀌므로 매개변수로 받은 값을 넣는다.
              break;

              case CAFE_LATTE:
                  Beverage cafeLatte = new Beverage(iceOption, true, whippingCream, 2);
              break;

              case VANILLA_LATTE:
                  Beverage vanillaLatte = new Beverage(iceOption, true, whippingCream, 3);
              break;

              case HAZEL_LATTE:
                  Beverage hazelLatte = new Beverage(iceOption, true, whippingCream, 4);
              break;

              case CAFE_MOCHA:
                  Beverage cafeMocha = new Beverage(iceOption, true, whippingCream, 5);
              break;

              default: // 다시 고르도록 돌아가게 하기
                break;
            }

    }// end createBeverage()

    // 주문받은 음료에 따라 머그잡/유리컵 줄어드는 메소드




}
