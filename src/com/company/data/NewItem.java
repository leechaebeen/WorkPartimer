package com.company.data;

public class NewItem
{
    // 변수
    private String name;    // 아이템 이름
    private int price;      // 아이템 가격
    private int type;       // 아이템 유형 구분 (1: 영구아이템, 2:소비아이템)

    // 기본생성자
    public NewItem(){}

    // 사용자 정의 생성자
    public NewItem(String name, int price, int type)
    {
        this.name = name;
        this.price = price;
        this.type = type;

    }

    // getter / setter
    public int getPrice()
    {
        return price;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getType()
    {
        return type;
    }

    public void setType(int type)
    {
        this.type = type;
    }
}
