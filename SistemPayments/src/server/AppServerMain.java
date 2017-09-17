package server;

public class AppServerMain 
{

	public static void main(String[] args) 
	{
		AppSocketServer appSocketServer=new AppSocketServer();
		appSocketServer.runServer();
	}

}
