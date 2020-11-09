package com.company.thread;

public class Time extends Thread
{

    @Override
    public void run()
    {
        timeCheck();
    }

    // 10초 경과하면 안내문구 출력하는 메소드
    public void timeCheck()
    {

        Sound sound = new Sound("clock.mp3",false);
        sound.start();

        for(int i= 10; i > 0; i--)
        {
            try{
                Thread.sleep(1000); // 1초
                //System.out.println(i);
            }catch (InterruptedException e)
            {
                return;
            }
        }

        System.out.println();
        System.out.printf("\n※※※ 10초 경과 ※※※\nenter 키를 눌러주세요 !\n");
        sound.finish();
    }

    public void finish()
    {
        this.interrupt();
    }
}
