package com.company.beverage;

// 음료 객체를 생성하는 클래스
public class Beverage
{
    private boolean milk;       // 우유를 사용해서 만드는 음료인지 구분하기 위한 속성
    private int iceOption;      // ICE 인지 HOT 인지 구분하기 위한 속성 - 랜덤값 사용하기 때문에 int
    private int whippingCream;  // 휘핑크림 올리는지 아닌지 구분하기 위한 속성 - 랜덤값 사용하기 때문에 int
    private int makeLevel;      // 음료 제조 난이도를 나타내는 속성
    private String name;        // 음료 이름

    // 생성자란?

    // 매개변수가 없는 기본 생성자
    public Beverage(){}

    // 매개변수 있는 생성자
    public Beverage(int iceOption, boolean milk, int whippingCream, int makeLevel, String name)
    {
        // this
        this.iceOption = iceOption;
        this.milk = milk;
        this.whippingCream = whippingCream;
        this.makeLevel = makeLevel;
        this.name = name;
    }

    // 외부에서 속성에 접근할 수 있도록 getter/setter 생성
    public boolean isMilk()
    {
        return milk;
    }

    public void setMilk(boolean milk)
    {
        this.milk = milk;
    }

    public int getIceOption()
    {
        return iceOption;
    }

    public void setIceOption(int iceOption)
    {
        this.iceOption = iceOption;
    }

    public int getWhippingCream()
    {
        return whippingCream;
    }

    public void setWhippingCream(int whippingCream)
    {
        this.whippingCream = whippingCream;
    }

    public int getMakeLevel()
    {
        return makeLevel;
    }

    public void setMakeLevel(int makeLevel)
    {
        this.makeLevel = makeLevel;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
