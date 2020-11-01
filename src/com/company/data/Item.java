package com.company.data;

// 아이템 클래스
public class Item
{
    // 아이템 가격 저장하는 변수
    private int chairPrice = 2;
    private int cupPrice = 2;
    private int mugPrice = 2;
    private int hpPrice = 4;
    private int feelingPrice = 4;

    private int cakePrice = 3;
    private int sandwichPrice = 5;
    private int chocoPrice = 3;
    private int macaronPrice = 5;

    // 보유한 아이템 수 저장하는 변수
    private static int cake;
    private static int sandwich;
    private static int choco;
    private static int macaron;


    // 외부에서 속성에 접근할 수 있도록 getter/setter 생성
    public int getChairPrice()
    {
        return chairPrice;
    }

    public void setChairPrice(int chairPrice)
    {
        this.chairPrice = chairPrice;
    }

    public int getCupPrice()
    {
        return cupPrice;
    }

    public void setCupPrice(int cupPrice)
    {
        this.cupPrice = cupPrice;
    }

    public int getMugPrice()
    {
        return mugPrice;
    }

    public void setMugPrice(int mugPrice)
    {
        this.mugPrice = mugPrice;
    }

    public int getHpPrice()
    {
        return hpPrice;
    }

    public void setHpPrice(int hpPrice)
    {
        this.hpPrice = hpPrice;
    }

    public int getFeelingPrice()
    {
        return feelingPrice;
    }

    public void setFeelingPrice(int feelingPrice)
    {
        this.feelingPrice = feelingPrice;
    }

    public int getCakePrice()
    {
        return cakePrice;
    }

    public void setCakePrice(int cakePrice)
    {
        this.cakePrice = cakePrice;
    }

    public int getSandwichPrice()
    {
        return sandwichPrice;
    }

    public void setSandwichPrice(int sandwichPrice)
    {
        this.sandwichPrice = sandwichPrice;
    }

    public int getChocoPrice()
    {
        return chocoPrice;
    }

    public void setChocoPrice(int chocoPrice)
    {
        this.chocoPrice = chocoPrice;
    }

    public int getMacaronPrice()
    {
        return macaronPrice;
    }

    public void setMacaronPrice(int macaronPrice)
    {
        this.macaronPrice = macaronPrice;
    }

    public static int getCake()
    {
        return cake;
    }

    public static void setCake(int cake)
    {
        Item.cake = cake;
    }

    public static int getSandwich()
    {
        return sandwich;
    }

    public static void setSandwich(int sandwich)
    {
        Item.sandwich = sandwich;
    }

    public static int getChoco()
    {
        return choco;
    }

    public static void setChoco(int choco)
    {
        Item.choco = choco;
    }

    public static int getMacaron()
    {
        return macaron;
    }

    public static void setMacaron(int macaron)
    {
        Item.macaron = macaron;
    }
}
