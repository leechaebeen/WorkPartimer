package com.company.cafe;

public class Item
{
    // 아이템 가격 : 계산할 때만 사용
    private int chairPrice = 2;
    private int cupPrice = 2;
    private int mugPrice = 2;
    private int hpPrice = 4;
    private int feelingPrice = 4;

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
}
