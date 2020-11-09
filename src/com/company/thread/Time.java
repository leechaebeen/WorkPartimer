package com.company.thread;

public class Time extends Thread
{
    Sound sound = new Sound("clock.mp3",false);

    @Override
    public void run()
    {
        timeCheck();
    }

    // 10초 경과하면 안내문구 출력하는 메소드
    public void timeCheck()
    {
        // 효과음 재생
        sound.start();

        // 1초씩 10번이 지나면
        for(int i= 10; i > 0; i--)
        {
            try{
                Thread.sleep(1000);
                //System.out.println(i);
            }catch (InterruptedException e)
            {
                return;
            }
        }

        // 안내 문구 출력
        System.out.println();
        System.out.printf("\n※※※ 10초 경과 ※※※\nenter 키를 눌러주세요 !\n");
        sound.finish();
    }

    public void finish()
    {
        this.interrupt();
        sound.finish();
    }
}
