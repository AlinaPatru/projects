package server;

public class ThreadRunnable implements Runnable
{

	public void run() 
	{
        for(int i = 0 ; i < 3 ; i++)
	    {
        	new Thread(new GenerateBillsRunnable()).start();
			
			try
			{
				Thread.sleep(50000);
				System.out.println("auto");
				new Thread(new AutoPaymentRunnable()).start();
				Thread.sleep(55000);
			}catch(InterruptedException e)
			{
				System.out.println(e);
			}
		}
	}
}