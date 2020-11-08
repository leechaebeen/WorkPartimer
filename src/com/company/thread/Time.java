package com.company.thread;

public class Time extends Thread
{

    @Override
    public void run()
    {
        timeCheck();
    }

    public void timeCheck()
    {
        for(int i= 10; i > 0; i--)
        {
            try{
                Thread.sleep(1000); // 1초
                //System.out.println(i);
            }catch (Exception e){}
        }

        System.out.printf("\n※※※ 10초 경과 ※※※ enter 키를 눌러주세요 !");
        finish();

    }

    public void finish()
    {
        this.interrupt();
        return;
    }
}
