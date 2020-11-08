package com.company.data;

public class Bug
{
    private String name;    // 벌레의 이름
    private int hp;         // 벌레의 체력
    private int damage;     // 벌레의 공격력
    private int term;       // 벌레의 공격 텀

    public Bug(){}

    public Bug(String name, int hp, int damage, int term)
    {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
        this.term = term;
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

    public int getTerm()
    {
        return term;
    }

    public void setTerm(int term)
    {
        this.term = term;
    }
}
