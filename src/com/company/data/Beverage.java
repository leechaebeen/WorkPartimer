package com.company.data;

// 음료 객체를 생성하는 클래스
public class Beverage
{
    private boolean isMilk;       // 우유를 사용해서 만드는 음료인지 구분하기 위한 속성
    private int iceOption;      // ICE 인지 HOT 인지 구분하기 위한 속성(랜덤값 사용하기 때문에 int)
    private int whippingCream;  // 휘핑크림 올리는지 아닌지 구분하기 위한 속성(랜덤값 사용하기 때문에 int)
    private int makeLevel;      // 음료 제조 난이도를 나타내는 속성
    private String name;        // 음료 이름

    // 생성자란?
    // 생성자는 객체가 생성될 때 호출된다. 객체가 생성될 때는 new라는 키워드로 객체가 만들어질 때이다.
    // 클래스의 멤버 변수를 적절한 기본값 또는 사용자 제공값으로 초기화한다.


    // 매개변수 있는 생성자 : 사용자 정의 생성자
    public Beverage(int iceOption, boolean isMilk, int whippingCream, int makeLevel, String name)
    {
        // this : 이 클래스의
        this.iceOption = iceOption;
        this.isMilk = isMilk;
        this.whippingCream = whippingCream;
        this.makeLevel = makeLevel;
        this.name = name;
    }

    // 외부에서 속성에 접근할 수 있도록 getter 생성
    public boolean isMilk()
    {
        return isMilk;
    }

    public int getIceOption()
    {
        return iceOption;
    }

    public int getWhippingCream()
    {
        return whippingCream;
    }

    public int getMakeLevel()
    {
        return makeLevel;
    }

    public String getName()
    {
        return name;
    }
}


