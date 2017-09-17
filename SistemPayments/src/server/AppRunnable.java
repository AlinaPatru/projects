package server;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import model.Client;
import model.ClientTable;
import model.FinesTable;
import model.Provider;
import model.ProviderTable;
import validation.DAOMethods;

public class AppRunnable implements Runnable
{
	protected Socket clientSocket=null;
	
	public AppRunnable(Socket clientSocket)
	{
		this.clientSocket=clientSocket;
	}

	@Override
	public void run() 
	{
		try 
		{
			ObjectInputStream serverInputStream = new ObjectInputStream(clientSocket.getInputStream());
			ObjectOutputStream serverOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
			serverOutputStream.flush();
			
			List<String> messageList = new ArrayList<>();
			DAOMethods dAOMethods=new DAOMethods();
			
			Client client=new Client();
			Provider provider=new Provider();
			
			String message = (String) serverInputStream.readObject();
			
			for(String m:message.split("\\^"))
			{
				messageList.add(m);
			}
			
			if(messageList.get(0).equals("createAccount"))
			{
				
				if(dAOMethods.createNewAccount(messageList.get(1), messageList.get(2),messageList.get(3) , messageList.get(4), messageList.get(5))==true)
					serverOutputStream.writeObject("succes");
				else
					serverOutputStream.writeObject("Username is already in use");
				
			}
			
			if( messageList.get(0).equals("login"))
			{
				client = dAOMethods.clientAuthenticate(messageList.get(1), messageList.get(2));
				
				if(client!=null)
				{
					serverOutputStream.writeObject("succes");
				    serverOutputStream.writeObject(client);
				    
					List<ClientTable> list = new ArrayList<>();
					list=dAOMethods.getDataForClientTable(client.getIdClient());
					serverOutputStream.writeObject(list.size());
					for(int i=0;i<list.size();i++)
					{
						serverOutputStream.writeObject(list.get(i));
					}
					List<String> notifications = dAOMethods.getNotifications();
					serverOutputStream.writeObject(notifications.size());
					for(int i=0;i<notifications.size();i++)
					{
						serverOutputStream.writeObject(notifications.get(i));
					}
				}
				else 
				{
					provider=dAOMethods.providerAuthenticate(messageList.get(1), messageList.get(2));
					if(provider!=null)
					{
						serverOutputStream.writeObject("succes");
					    serverOutputStream.writeObject(provider);
					    
					    List<ProviderTable> list = new ArrayList<>();
						list=dAOMethods.getDataForProviderTable(provider.getIdProvider());
						serverOutputStream.writeObject(list.size());
						for(int i=0;i<list.size();i++)
						{
							serverOutputStream.writeObject(list.get(i));
						}
					}
					else
					{
						serverOutputStream.writeObject("Username-ul si/sau parola introduse sunt gresite.");
					}
				}
   
			}
			
			if( messageList.get(0).equals("changeData"))
			{
				dAOMethods.changeClientData(Integer.parseInt(messageList.get(1)), messageList.get(2),messageList.get(3));
			}
			if( messageList.get(0).equals("addToDeposit"))
			{
				client=dAOMethods.addToDeposit(Integer.parseInt(messageList.get(1)), messageList.get(2));
				serverOutputStream.writeObject(client);
			}
			if( messageList.get(0).equals("deleteFromDeposit"))
			{
				dAOMethods.deleteFromDeposit(Integer.parseInt(messageList.get(1)),Double.parseDouble(messageList.get(2)));
				dAOMethods.deleteBill(Integer.parseInt(messageList.get(3)),Double.parseDouble(messageList.get(2)));
				client = dAOMethods.getClient(Integer.parseInt(messageList.get(1)));
				serverOutputStream.writeObject(client);
				
			}
			if( messageList.get(0).equals("createFinesTable"))
			{
				List<FinesTable> list = new ArrayList<>();
			    list=dAOMethods.getDataForFinesTable(Integer.parseInt(messageList.get(1)));
			    serverOutputStream.writeObject(list.size());
				for(int i=0;i<list.size();i++)
				{
					serverOutputStream.writeObject(list.get(i));
				}
			}
			if( messageList.get(0).equals("payFine"))
			{
				dAOMethods.payFine(Integer.parseInt(messageList.get(1)));
				serverOutputStream.writeObject(client);
			}
			if(messageList.get(0).equals("createClientTable"))
			{
				List<ClientTable> list = new ArrayList<>();
				list=dAOMethods.getDataForClientTable(Integer.parseInt(messageList.get(1)));
				serverOutputStream.writeObject(list.size());
				for(int i=0;i<list.size();i++)
				{
					serverOutputStream.writeObject(list.get(i));
				}
				List<String> notifications = dAOMethods.getNotifications();
				serverOutputStream.writeObject(notifications.size());
				for(int i=0;i<notifications.size();i++)
				{
					serverOutputStream.writeObject(notifications.get(i));
				}
				
			}
			if( messageList.get(0).equals("createProviderTableSubscribe"))
			{
				List<Provider> list = new ArrayList<>();
				list=dAOMethods.getDataTableSubscribe(Integer.parseInt(messageList.get(1)));
				serverOutputStream.writeObject(list.size());
				for(int i=0;i<list.size();i++)
				{
					serverOutputStream.writeObject(list.get(i));
				}
			}
			if( messageList.get(0).equals("createProviderTableUnsubscribe"))
			{
				List<Provider> list = new ArrayList<>();
				list=dAOMethods.getDataTableUnsubscribe(Integer.parseInt(messageList.get(1)));
				serverOutputStream.writeObject(list.size());
				for(int i=0;i<list.size();i++)
				{
					serverOutputStream.writeObject(list.get(i));
				}
			}
			if( messageList.get(0).equals("createRelation"))
			{
				client =(Client) serverInputStream.readObject();
				provider=(Provider) serverInputStream.readObject();
				dAOMethods.createRelation(client,provider);
			}
			if( messageList.get(0).equals("deleteRelation"))
			{
				client =(Client) serverInputStream.readObject();
				provider=(Provider) serverInputStream.readObject();
				dAOMethods.deleteRelation(client,provider);
			}

		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
