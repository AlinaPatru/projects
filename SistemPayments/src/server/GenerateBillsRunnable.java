package server;

import validation.DAOMethods;

public class GenerateBillsRunnable implements Runnable
{

	public void run() 
	{
    	DAOMethods daoMethods = new DAOMethods();
		daoMethods.generateBills();
	}
}
