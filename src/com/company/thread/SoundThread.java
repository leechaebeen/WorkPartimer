package com.company.thread;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import javazoom.jl.player.Player;

public class SoundThread extends Thread
{
    private Player player;          // javazoom 라이브러리에서 제공하는 객체
    private boolean loop;           // 반복 여부 체크할 변수
    private File file;              // 파일 클래스의 객체


    private FileInputStream fis;    // 파일 입력 스트림(파일로부터 1바이트 단위 씩.. )
    private BufferedInputStream bis;// 파일로부터 버퍼의 크기만큼 데이터를 읽어온다.


    public SoundThread(String name, boolean loop)
    {
        // 음악 파일이 존재하는 경로
        String soundPath = "C:\\Users\\billie\\IdeaProjects\\WorkPartimer\\music\\";

        try
        {
            this.loop=loop;
            file = new File(soundPath + name);    // 경로에 해당하는 파일의 File 객체를 생성한다.

            // 바이트 스트림 - 바이트 단위로 입출력 
            fis = new FileInputStream(file);               // 파일 데이터 읽어온다 (지정한 파일에 대한 입력 스트림을 생성한다.)
            bis = new BufferedInputStream(fis);            // 버퍼의 크기만큼 데이터를 읽어온다.
            player = new Player(bis);                      // player 객체 생성
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    // 반복을 멈추고 쓰레드 종료시키는 메소드
    public void finish()
    {
        loop = false;       // 반복 체크하는 변수에 false 담는다
        player.close();     // player 객체 닫음
        this.interrupt();   // 쓰레드 정지
    }

    @Override
    public void run()
    {
        try
        {
           do
           {
                player.play(); // 생성할때 초기화한 값으로 재생

               // 다시 player 객체 생성해서 반복 재생
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                player = new Player(bis);

            }while(loop); // loop == true 이면 반복한다.

        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }



}

