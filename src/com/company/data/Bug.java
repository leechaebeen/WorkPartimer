package com.company.data;

public class Bug
{
    private String name;    // 벌레의 이름
    private int hp;         // 벌레의 체력
    private int damage;     // 벌레의 공격력

    public Bug(){}

    public Bug(String name, int hp, int damage)
    {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getHp()
    {
        return hp;
    }

    public void setHp(int hp)
    {
        this.hp = hp;
    }

    public int getDamage()
    {
        return damage;
    }

    public void setDamage(int damage)
    {
        this.damage = damage;
    }

}
