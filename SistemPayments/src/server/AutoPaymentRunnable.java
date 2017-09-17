package server;

import validation.DAOMethods;

public class AutoPaymentRunnable implements Runnable
{
	public void run() 
	{
    	DAOMethods daoMethods = new DAOMethods();
		daoMethods.autoPayment();
	}
}
