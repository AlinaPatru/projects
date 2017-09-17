package server;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class AppSocketServer 
{
	int port=7004;
	ServerSocket serverSocket=null;
	
	public void runServer()
	{
		try
		{
			serverSocket=new ServerSocket(port);
			new Thread(new ThreadRunnable()).start();
			
		}catch(IOException e)
		{
			System.out.println(e.getMessage());
		} 
		
		while(true)
		{
			try
			{
				Socket clientSocket=serverSocket.accept();
				System.out.println("Server Waiting");
				new Thread(new AppRunnable(clientSocket)).start();
				
			}catch(IOException e)
			{
				System.out.println(e.getMessage());
			}
	
		}
	}

}
