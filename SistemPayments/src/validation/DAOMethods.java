package validation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import dao.BillDAO;
import dao.ClientDAO;
import dao.ProviderDAO;
import dao.RelationDAO;
import model.Bill;
import model.Client;
import model.ClientTable;
import model.FinesTable;
import model.Provider;
import model.ProviderTable;
import model.Relation;

public class DAOMethods 
{
	private ClientDAO clientDAO = new ClientDAO();
	private ProviderDAO providerDAO = new ProviderDAO();
	private RelationDAO relationDAO = new RelationDAO();
	private BillDAO billDAO = new BillDAO();
    private List<String> notifications=new ArrayList<>();
	private String startDate , limitDate;
	private int month , year;
	
	public void setNotifications(List<String> notifications)
	{
		this.notifications=notifications;
	}
	
	public List<String> getNotifications()
	{
		return this.notifications;
	}
	
	public Client getClient(int idClient)
	{
		Client client = clientDAO.getClientById(idClient);
		return client;
	}

	public boolean createNewAccount(String username , String password1 , String password2, String name,String state)
	{
		
		List<Client> allClients = clientDAO.getAllClients();
		for(int i = 0 ; i< allClients.size(); i++)
		{
			if(allClients.get(i).getUsername().equalsIgnoreCase(username))
				return false;
		}
		
		Client c = new Client(username, password1, name,Integer.parseInt(state));
		
		clientDAO.addClient(c);
		
		return true;
	}
	
	public Client clientAuthenticate(String username, String password)
	{
		
		List<Client> allClients = clientDAO.getAllClients();// creez lista de clienti
		for(int i=0; i<allClients.size(); i++)
		{
			if(allClients.get(i).getUsername().equalsIgnoreCase(username)) //verifica usernameul
				if(allClients.get(i).getPassword().equals(password))
					return allClients.get(i); //imi returneaza clientul
		}
		
		return null;
	}
	
	
	public Provider providerAuthenticate(String username, String password)
	{
		
		List<Provider> allProviders = providerDAO.getAllProviders();
		for(int i=0; i<allProviders.size(); i++)
		{
			if(allProviders.get(i).getUsername().equalsIgnoreCase(username))
				if(allProviders.get(i).getPassword().equals(password))
					return allProviders.get(i);

		}
		
		return null;
	}
	
	
	public void changeClientData(int idClient,String name, String newPassword1)
	{
		clientDAO.updateClient(idClient, name, newPassword1);
	}
	
	public Client addToDeposit(int idClient,String sum)
	{
		clientDAO.updateDeposit(idClient, Double.parseDouble(sum));
		
		return clientDAO.getClientById(idClient);	
	}
	
	public void deleteFromDeposit(int idClient,double sum)
	{	
		clientDAO.deleteFromDeposit(idClient, sum);
	}
	
	public void deleteBill(int idBill, double sum)
	{
		Bill bill = billDAO.getBillById(idBill);
		int idRelation = bill.getRelation().getIdRelation() ;
		int idProvider = bill.getRelation().getProvider().getIdProvider();
		providerDAO.updateDeposit(idProvider, sum);
		billDAO.deleteBill(idBill);
		
		Relation relation =relationDAO.getRelationById(idRelation);
		
		for(int i=0;i< relation.getBills().size();i++)
		{
			if(relation.getBills().get(i).getIdBill()==idBill)
			{
				relation.getBills().remove(i);
			}
		}
		relationDAO.updateRelation(relation.getIdRelation(), relation.getBills());
	}
	
	public boolean isDate(String date)
	{
		   String regex = "(0[1-9]|[1-2][0-9]|3[0-1]).((1[0-2])|0[1-9]).20[1-2][0-9]";
		   if(date.matches(regex))
				return true;
			return false;
	}
	
	public List<ClientTable> getDataForClientTable(int idClient)
	{
		List<ClientTable> list = new ArrayList<ClientTable>();
		List<Bill> allBills = new ArrayList<Bill>();
		List<String> listNotifications = new ArrayList<String>();
		List<Relation> allRelations =new ArrayList<Relation>();
		allRelations= relationDAO.getAllRelations();
  		ClientTable ct=new ClientTable();

  		for(int i = 0 ; i < allRelations.size(); i++)
  		{
  			if(allRelations.get(i).getClient().getIdClient() == idClient)
  			{
  				if(allRelations.get(i).getFine() > 0)
  				{
  					listNotifications.add("You have to pay the FINE : " + allRelations.get(i).getFine() + " to " + allRelations.get(i).getProvider().getName());		
  				}
  					
  				allBills = allRelations.get(i).getBills();
  				for(int j = 0 ; j < allBills.size(); j++)
  				{
  					ct=new ClientTable(allRelations.get(i).getProvider().getName(),allRelations.get(i).getProvider().getService(),allBills.get(j).getPrice(),allBills.get(j).getLimitDate(),allBills.get(j).getIdBill());
  					list.add(ct);
  					
  					Provider provider=allRelations.get(i).getProvider();
  					int idBill=allBills.get(j).getIdBill();
					double price=allBills.get(j).getPrice();
					listNotifications.add("You have to pay the BILL : " + idBill + " with price = " + price + " to " + provider.getName());
				
  				}
  			}
  		}
  		setNotifications(listNotifications);
  			
  		
		return list;
	}
	
	public List<String> notificationList(int idClient, List<Bill> allBills)
	{
		List<String> list = new ArrayList<>();
		
		for(int i=0;i<allBills.size();i++)
  		{
			if(idClient ==allBills.get(i).getRelation().getClient().getIdClient())
			{
				if(allBills.get(i).getRelation().getFine() > 0)
				{
					list.add("You have to pay the FINE : " + allBills.get(i).getRelation().getFine() + " to " + allBills.get(i).getRelation().getProvider().getName());
				}
				int numberRel = allBills.get(i).getRelation().getBills().size();
				if(numberRel > 0)
				{
					List <Bill> allBillsClient = allBills.get(i).getRelation().getBills();
					Provider provider=allBills.get(i).getRelation().getProvider();
					for(int j = 0; j< allBillsClient.size() ; j++)
					{
						int idBill=allBillsClient.get(j).getIdBill();
						double price=allBillsClient.get(j).getPrice();
						list.add("You have to pay the BILL : " + idBill + " with price = " + price + " to " + provider.getName());
					}
				}
			}
  		}
		return list;
	}
	
	public List<ProviderTable> getDataForProviderTable(int idProvider)
	{
		List<ProviderTable> list = new ArrayList<>();
		
		List<Bill> allBills =billDAO.getAllBills();
		ProviderTable pt;
  		
  		for(int i=0;i<allBills.size();i++)
  		{
  			if(allBills.get(i).getRelation().getProvider().getIdProvider()==idProvider)
  			{
  				pt=new ProviderTable(allBills.get(i).getRelation().getClient().getName(),allBills.get(i).getPrice(),allBills.get(i).getStartDate(),allBills.get(i).getLimitDate(),allBills.get(i).getIdBill());
  				list.add(pt);
  			}
  		}
		
		return list;
	}
	
	public boolean searchInRelations(List<Relation> allRelations,int idProvider,int idClient)
	{
		for(int i=0;i<allRelations.size();i++)
		{
			if(idClient ==allRelations.get(i).getClient().getIdClient())
				if(idProvider==allRelations.get(i).getProvider().getIdProvider())
				    return false;
		
		}
		return true;
	}
	
	public boolean searchInRelations1(List<Relation> allRelations,int idProvider,int idClient)
	{
		for(int i=0;i<allRelations.size();i++)
		{
			if(idClient ==allRelations.get(i).getClient().getIdClient())
				if(idProvider==allRelations.get(i).getProvider().getIdProvider() && allRelations.get(i).getBills().isEmpty() && allRelations.get(i).getFine()==0)
				    return true;
		
		}
		return false;
	}
	
	public List<Provider> getDataTableSubscribe(int idClient)
	{
		List<Provider> list = new ArrayList<>();
		List<Provider> allProviders =providerDAO.getAllProviders();
		List<Relation> allRelations =relationDAO.getAllRelations();
  		
		for(int i=0;i<allProviders.size();i++)
  		{
				
			if(searchInRelations(allRelations,allProviders.get(i).getIdProvider(),idClient)==true)
			{
  				list.add(allProviders.get(i));
			}
  		}
		
		return list;
	}
	
	public List<Provider> getDataTableUnsubscribe(int idClient)
	{
		List<Provider> list = new ArrayList<>();
		List<Provider> allProviders =providerDAO.getAllProviders();
		List<Relation> allRelations =relationDAO.getAllRelations();
  		
		for(int i=0;i<allProviders.size();i++)
  		{
				
			if(searchInRelations1(allRelations,allProviders.get(i).getIdProvider(),idClient)==true)
			{
  				list.add(allProviders.get(i));
			}
  		}
		
		return list;
	}
	
	public List<FinesTable> getDataForFinesTable(int idClient)
	{
		List<FinesTable> list = new ArrayList<>();
		List<Relation> allRelations =relationDAO.getAllRelations();
  		
		for(int i=0;i<allRelations.size();i++)
  		{
			if(idClient ==allRelations.get(i).getClient().getIdClient() && allRelations.get(i).getFine()>0)
			{
				FinesTable fine=new FinesTable(allRelations.get(i).getProvider().getName(),allRelations.get(i).getFine(),allRelations.get(i).getIdRelation());
				list.add(fine);
			}
  		}
		
		return list;
	}
	
	public void createRelation(Client client,Provider provider)
	{
		Relation relation=new Relation();
		relation.setClient(client);
		relation.setProvider(provider);
		relationDAO.addRelation(relation);
		
	}
	
	public void deleteRelation(Client client,Provider provider)
	{
		List<Relation> allRelations = relationDAO.getAllRelations();
		for(int i=0;i<allRelations.size();i++)
  		{
			if(client.getIdClient() ==allRelations.get(i).getClient().getIdClient() && allRelations.get(i).getProvider().getIdProvider()==provider.getIdProvider())
			{
				relationDAO.deleteRelation(allRelations.get(i).getIdRelation());
			}
  		}
		
	}
	
	public void payFine(int idRelation)
	{
		Relation r = relationDAO.getRelationById(idRelation);
		clientDAO.deleteFromDeposit(r.getClient().getIdClient(), r.getFine());
		providerDAO.updateDeposit(r.getProvider().getIdProvider(), r.getFine());
		relationDAO.setNewFine(idRelation,0);
		System.out.println(idRelation);
		
	}
	
	
	public void generateBills()
	{
		getBillDates();
		generateDate();
		List<Relation> allRelations =relationDAO.getAllRelations();
		for(int i = 0 ; i < allRelations.size() ; i++)
		{
			if(allRelations.get(i).getBills().size()  >=3)
			{
				relationDAO.updateFine(allRelations.get(i).getIdRelation(),50);
			}
			else
			{
				Bill bill = new Bill(allRelations.get(i),allRelations.get(i).getProvider().getPrice(),startDate,limitDate);
				billDAO.addBill(bill);
				Relation relation = bill.getRelation();
				relation.getBills().add(bill);
				relationDAO.updateRelation(relation.getIdRelation(), relation.getBills());
			}
		}
	}
	
	public void getBillDates()
	{
		List<Bill> allBills = billDAO.getAllBills();
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		Calendar cal = Calendar.getInstance();
		String dateNow = dateFormat.format(cal.getTime());
		List<String> listData;
		
		if(allBills.size() != 0)
		{
			Bill bill = allBills.get(allBills.size()-1);
			String date1 = bill.getLimitDate();
			listData = new ArrayList<>();
	
			for(String m:date1.split("\\."))
			{
				listData.add(m);
			}
			month = Integer.parseInt(listData.get(1));
			year = Integer.parseInt(listData.get(2));
		}
		else
		{
			listData = new ArrayList<>();
			for(String m:dateNow.split("\\."))
			{
				listData.add(m);
			}
			month = Integer.parseInt(listData.get(1));
			year = Integer.parseInt(listData.get(2));
		}
	}
	
	public void generateDate()
	{
		StringBuilder startDate1 = new StringBuilder("");
		StringBuilder limitDate1 = new StringBuilder("");
		if(month==12)
		{
			startDate1.append("01."+month+"."+year);
			startDate = startDate1.toString();
			year +=1; month = 1;
			limitDate1.append("01.0"+month+"."+year);
			limitDate = limitDate1.toString();
		}
		else
		{
			if(month<9)
			{
				startDate1.append("01.0"+month+"."+year);
				startDate = startDate1.toString();
				month += 1;
				limitDate1.append("01.0"+month+"."+year);
				limitDate = limitDate1.toString();
				
			}
			else
			{
				if(month == 9)
				{
					startDate1.append("01.0"+month+"."+year);
					startDate = startDate1.toString();
					month += 1;
					limitDate1.append("01."+month+"."+year);
					limitDate = limitDate1.toString();
					
				}
				else
				{
					startDate1.append("01."+month+"."+year);
					startDate = startDate1.toString();
					month += 1;
					limitDate1.append("01."+month+"."+year);
					limitDate = limitDate1.toString();
					
				}
			}
		}
	}
	
	
	public void autoPayment()
	{
		List<Client> allClients = clientDAO.getAllClients();
		List<Bill> allBills;
		List<Relation> allRelations = relationDAO.getAllRelations();;
		double deposit;
		
		for(int i = 0 ; i < allClients.size(); i++)
		{
			if(allClients.get(i).getState() == 1)
			{
				for(int k = 0 ; k < allRelations.size() ; k++)
				{
					if(allRelations.get(k).getClient().getIdClient() == allClients.get(i).getIdClient())
					{
						if(allRelations.get(k).getFine() > 0 )
						{
							double fine = allRelations.get(k).getFine();
							deposit = allClients.get(i).getDeposit();
							if(deposit >= fine)
							{
								
								deposit = deposit - fine;
								providerDAO.updateDeposit(allRelations.get(k).getProvider().getIdProvider(), fine);
								clientDAO.setNewDeposit(allClients.get(i).getIdClient(),deposit);
								relationDAO.setNewFine(allRelations.get(k).getIdRelation(), 0);
								allRelations.get(k).setFine(0);
							}
						}
					}
				}
				if(allClients.get(i).getDeposit() > 0)
				{
					deposit = allClients.get(i).getDeposit();
					for(int k = 0 ; k < allRelations.size() ; k++)
					{
						if(allRelations.get(k).getClient().getIdClient() == allClients.get(i).getIdClient())
						{
							if(allRelations.get(k).getFine() == 0 )
							{
								allBills = allRelations.get(k).getBills();
								for(int j = 0 ; j < allBills.size() ; j++)
								{
									if(allBills.get(j).getPrice() <= deposit)
									{
										deposit = deposit - allBills.get(j).getPrice();
										providerDAO.updateDeposit(allBills.get(j).getRelation().getProvider().getIdProvider(), allBills.get(j).getPrice());
										billDAO.deleteBill(allBills.get(j).getIdBill());
										//clientDAO.deleteFromDeposit(allClients.get(i).getIdClient(), allBills.get(j).getPrice());
										clientDAO.setNewDeposit(allClients.get(i).getIdClient(), deposit);
										if(j>0)
										{
											allBills.remove(j);
											j--;
										}
										else
											if(j==0)
											{
												allBills.remove(j);
											}
											
										
									}
								}
							}
						}
					}
				}
			}
		}
	}

	
}
