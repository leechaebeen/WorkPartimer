package com.company.thread;

public class MiniGame extends Thread
{
    boolean check = false;

    @Override
    public void run()
    {
        game();
    }

    public void finish()
    {
        check = false;
        this.interrupt();
    }

    public void game()
    {
        try{

            Thread.sleep(1000);


            //for (int j = 0; j < 40; j++)
            //{
                for (int i = 0; i < 50; i++)
                {
                    System.out.println("");
                }

                for (int i = 0; i <= 100; i++)
                {
                    System.out.printf("▀");
                    Thread.sleep(10);

                }





          //  }





        }catch (Exception e){

        }




    }
}
