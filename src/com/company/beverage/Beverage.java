package com.company.beverage;

// 음료 객체를 생성하는 클래스
public class Beverage
{
    private boolean iceOption;      // ICE 인지 HOT 인지 구분하기 위한 속성
    private boolean milk;           // 우유를 사용해서 만드는 음료인지 구분하기 위한 속성
    private boolean whippingCream;  // 휘핑크림 올리는지 아닌지 구분하기 위한 속성
    private int makeLevel;          // 음료 제조 난이도를 나타내는 속성

    // 생성자란?

    // 매개변수가 없는 기본 생성자
    public Beverage(){}

    // 매개변수가 3개인 생성자
    public Beverage(boolean iceOption, boolean milk, boolean whippingCream, int makeLevel)
    {
        // this
        this.iceOption = iceOption;
        this.milk = milk;
        this.whippingCream = whippingCream;
        this.makeLevel = makeLevel;
    }

}
