
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class ClasaA 
{
	private IpAdress ip=new IpAdress();

	public IpAdress getIp() 
	{
		return ip;
	}

	public void setIp(IpAdress ip) 
	{
		this.ip = ip;
	}
	
	public Boolean isIPv4Address(String adress)
	{
	    if (adress.isEmpty()) 
	    {
	        return false;
	    }
	    else
	    {
	        String regex = "\\b((25[0–5]|2[0–4]\\d|[01]?\\d\\d?)(\\.)){3}(25[0–5]|2[0–4]\\d|[01]?\\d\\d?)\\b";
	        if(Pattern.matches(regex, adress))
	        	return true;
	    }
	    return false;
	}
	
	public boolean verificareClasaA(IpAdress ip)
	{
		if(ip.getIpBinar().get(0).charAt(0)=='0')
			return true;
		return false;
	}
	
	public boolean verificareClasaB(IpAdress ip)
	{
		if(ip.getIpBinar().get(0).charAt(0)=='1' && ip.getIpBinar().get(0).charAt(1)=='0')
		    return true;
		return false;
	}
	
	public boolean verificareClasaC(IpAdress ip)
	{
		if(ip.getIpBinar().get(0).charAt(0)=='1'&& ip.getIpBinar().get(0).charAt(1)=='1' && ip.getIpBinar().get(0).charAt(2)=='0')
			return true;
		return false;
	}
	
	public boolean verificareClasaD(IpAdress ip)
	{
		if(ip.getIpBinar().get(0).charAt(0)=='1' && ip.getIpBinar().get(0).charAt(1)=='1' && ip.getIpBinar().get(0).charAt(2)=='1' && ip.getIpBinar().get(0).charAt(3)=='0')
			return true;
		return false;
	}
	
	public boolean verificareClasaE(IpAdress ip)
	{
		if(ip.getIpBinar().get(0).charAt(0)=='1' && ip.getIpBinar().get(0).charAt(1)=='1' && ip.getIpBinar().get(0).charAt(2)=='1' && ip.getIpBinar().get(0).charAt(3)=='1')
			return true;
		return false;
	}
	
	
	public void determinClass(IpAdress ip)
	{
		List<String> reteaGazda=new ArrayList<>();
		List<String> reteaBroadcast=new ArrayList<>();
	    List<String> clasaTip=new ArrayList<>();
		if(verificareClasaA(ip))
		{
			reteaBroadcast.add(ip.getIp().get(0)+".0.0.0");
			reteaBroadcast.add(ip.getIpBinar().get(0)+".00000000.00000000.00000000");
			reteaBroadcast.add(ip.getIp().get(0)+".255.255.255");
			reteaBroadcast.add(ip.getIpBinar().get(0)+".11111111.11111111.11111111");
			reteaGazda.add(ip.getIpBinar().get(0));
			reteaGazda.add(ip.getIpBinar().get(1)+"."+ip.getIpBinar().get(2)+"."+ip.getIpBinar().get(3));
			ip.setReteaGazda(reteaGazda);
			ip.setReteaBroadcast(reteaBroadcast);
			clasaTip.add("Clasa A");
			if(ip.getIp().get(1)==255)
			{
				if(ip.getIp().get(2)==255)
				{
					if(ip.getIp().get(3)==255)
					{
						clasaTip.add("Broadcast");
					}
				}
			}
			else if(ip.getIp().get(1)==0)
			{
				if(ip.getIp().get(2)==0)
				{
					if(ip.getIp().get(3)==0)
					{
						clasaTip.add("Retea");
					}
				}
			}
			else
				clasaTip.add("Gazda");
			ip.setClasaTip(clasaTip);
			ip.setNrBitiGazda(24);
			ip.setNrMaximGazde(16777214);
		}
		else if(verificareClasaB(ip))
		{
			reteaBroadcast.add(ip.getIp().get(0)+"."+ip.getIp().get(1)+".0.0");
			reteaBroadcast.add(ip.getIpBinar().get(0)+"."+ip.getIpBinar().get(1)+".00000000.00000000");
			reteaGazda.add(ip.getIpBinar().get(0)+"."+ip.getIpBinar().get(1));
			reteaGazda.add(ip.getIpBinar().get(2)+"."+ip.getIpBinar().get(3));
			reteaBroadcast.add(ip.getIp().get(0)+"."+ip.getIp().get(1)+".255.255");
			reteaBroadcast.add(ip.getIpBinar().get(0)+"."+ip.getIpBinar().get(1)+".11111111.11111111");
			clasaTip.add("Clasa B");
			if(ip.getIp().get(2)==255)
			{
				if(ip.getIp().get(3)==255)
				{
					clasaTip.add("Broadcast");
				}
			}
			else if(ip.getIp().get(2)==0)
			{
				if(ip.getIp().get(3)==0)
				{
					clasaTip.add("Retea");
				}
			}
			else
				clasaTip.add("Gazda");
			ip.setReteaGazda(reteaGazda);
			ip.setReteaBroadcast(reteaBroadcast);
			ip.setClasaTip(clasaTip);
			ip.setNrBitiGazda(16);
			ip.setNrMaximGazde(65534);
		}
		else if(verificareClasaC(ip))
		{
			reteaBroadcast.add(ip.getIp().get(0)+"."+ip.getIp().get(1)+"."+ip.getIp().get(2)+".0");
			reteaBroadcast.add(ip.getIpBinar().get(0)+"."+ip.getIpBinar().get(1)+"."+ip.getIpBinar().get(2)+".00000000");
			reteaGazda.add(ip.getIpBinar().get(0)+"."+ip.getIpBinar().get(1)+"."+ip.getIpBinar().get(2));
			reteaGazda.add(ip.getIpBinar().get(3));
			reteaBroadcast.add(ip.getIp().get(0)+"."+ip.getIp().get(1)+"."+ip.getIp().get(2)+".255");
			reteaBroadcast.add(ip.getIpBinar().get(0)+"."+ip.getIpBinar().get(1)+"."+ip.getIpBinar().get(2)+".11111111");
			clasaTip.add("Clasa C");
			if(ip.getIp().get(3)==255)
			{
				clasaTip.add("Broadcast");
			}
			else if(ip.getIp().get(3)==0)
			{
				clasaTip.add("Retea");
			}
			else
				clasaTip.add("Gazda");
			ip.setReteaGazda(reteaGazda);
			ip.setReteaBroadcast(reteaBroadcast);
			ip.setClasaTip(clasaTip);
			ip.setNrBitiGazda(8);
			ip.setNrMaximGazde(254);
		}
		else if(verificareClasaD(ip))
		{
			reteaBroadcast.add(ip.getIp().get(0)+"."+ip.getIp().get(1)+"."+ip.getIp().get(2)+".0");
			reteaBroadcast.add(ip.getIpBinar().get(0)+"."+ip.getIpBinar().get(1)+"."+ip.getIpBinar().get(2)+".00000000");
			reteaGazda.add(ip.getIpBinar().get(0)+"."+ip.getIpBinar().get(1)+"."+ip.getIpBinar().get(2));
			reteaGazda.add(ip.getIpBinar().get(3));
			reteaBroadcast.add(ip.getIp().get(0)+"."+ip.getIp().get(1)+"."+ip.getIp().get(2)+".255");
			reteaBroadcast.add(ip.getIpBinar().get(0)+"."+ip.getIpBinar().get(1)+"."+ip.getIpBinar().get(2)+".11111111");
			clasaTip.add("Clasa D");
			if(ip.getIp().get(3)==255)
			{
				clasaTip.add("Broadcast");
			}
			else if(ip.getIp().get(3)==0)
			{
				clasaTip.add("Retea");
			}
			else
				clasaTip.add("Gazda");
			ip.setReteaGazda(reteaGazda);
			ip.setReteaBroadcast(reteaBroadcast);
			ip.setClasaTip(clasaTip);
			ip.setNrBitiGazda(8);
			ip.setNrMaximGazde(254);
		}
		else if(verificareClasaE(ip))
		{
			reteaBroadcast.add(ip.getIp().get(0)+"."+ip.getIp().get(1)+"."+ip.getIp().get(2)+".0");
			reteaBroadcast.add(ip.getIpBinar().get(0)+"."+ip.getIpBinar().get(1)+"."+ip.getIpBinar().get(2)+".00000000");
			reteaGazda.add(ip.getIpBinar().get(0)+"."+ip.getIpBinar().get(1)+"."+ip.getIpBinar().get(2));
			reteaGazda.add(ip.getIpBinar().get(3));
			reteaBroadcast.add(ip.getIp().get(0)+"."+ip.getIp().get(1)+"."+ip.getIp().get(2)+".255");
			reteaBroadcast.add(ip.getIpBinar().get(0)+"."+ip.getIpBinar().get(1)+"."+ip.getIpBinar().get(2)+".11111111");
			clasaTip.add("Clasa E");
			if(ip.getIp().get(3)==255)
			{
				clasaTip.add("Broadcast");
			}
			else if(ip.getIp().get(3)==0)
			{
				clasaTip.add("Retea");
			}
			else
				clasaTip.add("Gazda");
			ip.setReteaGazda(reteaGazda);
			ip.setReteaBroadcast(reteaBroadcast);
			ip.setClasaTip(clasaTip);
			ip.setNrBitiGazda(8);
			ip.setNrMaximGazde(254);
		}
		else
		{
			
		}
	}
	
	public void setIpBinar1(IpAdress ip)
	{
		List<String> ipBinar=new ArrayList<>();
		for(int i=0;i<ip.getIp().size();i++)
		{
			StringBuilder ip2=new StringBuilder("00000000");
			String ip1=new String(Integer.toString(ip.getIp().get(i),2));
			int j=ip2.length()-1;
			int k=ip1.length()-1;
			while(k>-1)
			{
				ip2.setCharAt(j, ip1.charAt(k));
				k--;
				j--;
			}
			ipBinar.add(ip2.toString());
		}
		ip.setIpBinar(ipBinar);
	}
	
	public void setGazda2014(IpAdress ip)
	{
		List<String> gazda2014=new ArrayList<>();
		if(ip.getNrBitiGazda()>16)
		{
			//String gazda=new String(Integer.toString(2014,2));//111  11011110
			if(ip.getClasaTip().get(0).equals("Clasa B"))
			{
				gazda2014.add(ip.getIp().get(0).toString()+"."+ip.getIp().get(1).toString()+".7.222");
			    gazda2014.add(ip.getReteaGazda().get(0)+".00000111.11011110");
			    ip.setGazda2014(gazda2014);
			}
			else
			{
				gazda2014.add(ip.getIp().get(0).toString()+".0.7.222");
				gazda2014.add(ip.getReteaGazda().get(0)+".00000000.00000111.11011110");
				ip.setGazda2014(gazda2014);
			}
		}
		else
		{
			gazda2014.add("Nu exista");
			gazda2014.add("Nu exista");
			ip.setGazda2014(gazda2014);
		}
	}
	
	public void setMascaReteaSiAdresaRetelei(IpAdress ip)
	{
		List<String> s=new ArrayList<>();
		
		if(ip.getClasaTip().get(0).equals("Clasa A"))
		{
			s.add("11111111");
			s.add("00000000");
			s.add("00000000");
			s.add("00000000");
			s.add("255.0.0.0");
		    ip.setMascaRetea(s);
		    setAdresaDeRetea(ip);
		}
		else if(ip.getClasaTip().get(0).equals("Clasa B"))
		{
			s.add("11111111");
			s.add("11111111");
			s.add("00000000");
			s.add("00000000");
			s.add("255.255.0.0");
		    ip.setMascaRetea(s);
		    setAdresaDeRetea(ip);
		}
		else if(ip.getClasaTip().get(0).equals("Clasa C") || ip.getClasaTip().get(0).equals("Clasa D")||ip.getClasaTip().get(0).equals("Clasa E"))
		{
			s.add("11111111");
			s.add("11111111");
			s.add("11111111");
			s.add("00000000");
			s.add("255.255.255.0");
		    ip.setMascaRetea(s);
		    setAdresaDeRetea(ip);
		}
		
	}
	
	public void setAdresaDeRetea(IpAdress ip)
	{
		StringBuffer rezultat = new StringBuffer("00000000");
		List<String> s=new ArrayList<>();
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<8;j++)
			{
				rezultat.setCharAt(j, and(ip.getIpBinar().get(i).charAt(j),ip.getMascaRetea().get(i).charAt(j)));
			}
			String rez=rezultat.toString();
			s.add(rez);
		}
		List<Integer> s1=new ArrayList<>();
		for(int i=0;i<4;i++)
		{
			s1.add(Integer.parseInt(s.get(i), 2));
		}
		s.add(s1.get(0)+"."+s1.get(1)+"."+s1.get(2)+"."+s1.get(3));
		ip.setAdresaRetelei(s);
		
	}
	
	public int numarMaximBitiImprumutati(IpAdress ip,int nrSubretele)//*****
	{
		int k = 1;
		int nr = 2;
		if(nr <= nrSubretele+2)
		{
			do
			{
				nr *= nr;
				k++;
			}while(nr <=nrSubretele+2);
		}
		if(k>=2 && k<=ip.getNrBitiGazda()-2)
			return k;
		
		return 0;
	}
	
	public int numarMinimBitiImprumutatiGazde(IpAdress ip,int nrGazde,int nrSubretele)//*******
	{
		int k=numarMaximBitiImprumutati(ip,nrSubretele);
		int m=ip.getNrBitiGazda()-k;
		
		if(k!=0)
		{
			if(putere(m)>=nrGazde+2)
			{
				return k;
			}
		}
		
		
		return 0;
	}
	
	public int putere(int m)//******
	{
		int j=2;
		for(int i=0;i<m-1;i++)
		{
			j=j*2;
		}
		return j;
	}
	
	public String adresaPrimeiSubretele(IpAdress ip,int k)
	{
		StringBuilder kC=new StringBuilder("00000000");
		StringBuilder kB=new StringBuilder("0000000000000000");
		StringBuilder kA=new StringBuilder("000000000000000000000000");

		if(k!=0)
		{
			if(ip.getClasaTip().get(0).equals("Clasa A"))
			{
				kA.setCharAt(k-1,'1');
				kA.insert(8, ".");
				kA.insert(16, ".");
				
				return ip.getReteaGazda().get(0)+"."+kA.toString();
			}
			else if(ip.getClasaTip().get(0).equals("Clasa B"))
			{
				kB.setCharAt(k-1,'1');
				kB.insert(8, ".");
				
				return ip.getReteaGazda().get(0)+"."+kB.toString();
			}
			else if(ip.getClasaTip().get(0).equals("Clasa C") || ip.getClasaTip().get(0).equals("Clasa D")||ip.getClasaTip().get(0).equals("Clasa E"))
			{
				kC.setCharAt(k-1,'1');
				
				return ip.getReteaGazda().get(0)+"."+kC.toString();
			}
		}
		
		return "Nu exista";
		
	}
	
	public String adresaUltimeiSubretele(IpAdress ip,int k)
	{
		StringBuilder kC=new StringBuilder("00000000");
		StringBuilder kB=new StringBuilder("0000000000000000");
		StringBuilder kA=new StringBuilder("000000000000000000000000");
		List<String> gazda19UltSubretea=new ArrayList<>();
		List<String> adresa=new ArrayList<>();
		String string=new String(Integer.toString(19,2));
		String s1;

		if(k!=0)
		{
			if(ip.getClasaTip().get(0).equals("Clasa A"))
			{
				k=k-2;
				while(k>-1)
				{
					kA.setCharAt(k,'1');
					k--;
				}
				kA.insert(8, ".");
				kA.insert(16, ".");
				
				if(string.length()>ip.getNrBitiGazda()-k)
				{
					gazda19UltSubretea.add("Nu exista");
					gazda19UltSubretea.add("Nu exista");
				}
				else
				{
					StringBuilder g=new StringBuilder(ip.getReteaGazda().get(0)+"."+kA.toString());
					g.replace(g.length()-string.length(), g.length(), string);
					s1=g.toString();
					adresa=gazda19(s1);
					gazda19UltSubretea.add(Integer.parseInt(adresa.get(0), 2)+"."+Integer.parseInt(adresa.get(1), 2)+"."+Integer.parseInt(adresa.get(2), 2)+"."+Integer.parseInt(adresa.get(3), 2));
					gazda19UltSubretea.add(s1);
					
				}
				ip.setGazda19UltSubretea(gazda19UltSubretea);
				
				return ip.getReteaGazda().get(0)+"."+kA.toString();
			}
			else if(ip.getClasaTip().get(0).equals("Clasa B"))
			{
				k=k-2;
				while(k>-1)
				{
					kB.setCharAt(k,'1');
					k--;
				}
				kB.insert(8, ".");
				
				if(string.length()>ip.getNrBitiGazda()-k)
				{
					gazda19UltSubretea.add("Nu exista");
					gazda19UltSubretea.add("Nu exista");
				}
				else
				{
					StringBuilder g=new StringBuilder(ip.getReteaGazda().get(0)+"."+kB.toString());
					g.replace(g.length()-string.length(), g.length(), string);
					s1=g.toString();
					adresa=gazda19(s1);
					gazda19UltSubretea.add(Integer.parseInt(adresa.get(0), 2)+"."+Integer.parseInt(adresa.get(1), 2)+"."+Integer.parseInt(adresa.get(2), 2)+"."+Integer.parseInt(adresa.get(3), 2));
					gazda19UltSubretea.add(s1);
				}
				ip.setGazda19UltSubretea(gazda19UltSubretea);
				
				return ip.getReteaGazda().get(0)+"."+kB.toString();
			}
			else if(ip.getClasaTip().get(0).equals("Clasa C") || ip.getClasaTip().get(0).equals("Clasa D")||ip.getClasaTip().get(0).equals("Clasa E"))
			{
				k=k-2;
				while(k>-1)
				{
					kC.setCharAt(k,'1');
					k--;
				}
				
				if(string.length()>ip.getNrBitiGazda()-k)
				{
					gazda19UltSubretea.add("Nu exista");
					gazda19UltSubretea.add("Nu exista");
				}
				else
				{
					StringBuilder g=new StringBuilder(ip.getReteaGazda().get(0)+"."+kC.toString());
					g.replace(g.length()-string.length(), g.length(), string);
					s1=g.toString();
					adresa=gazda19(s1);
					gazda19UltSubretea.add(Integer.parseInt(adresa.get(0), 2)+"."+Integer.parseInt(adresa.get(1), 2)+"."+Integer.parseInt(adresa.get(2), 2)+"."+Integer.parseInt(adresa.get(3), 2));
					gazda19UltSubretea.add(s1);
					
				}
				ip.setGazda19UltSubretea(gazda19UltSubretea);
				
				return ip.getReteaGazda().get(0)+"."+kC.toString();
			}
		}
		
		return "Nu exista";
		
	}
	
	public String binarytoDecimal(String s)
	{
		List<String> adresa=new ArrayList<>();
		String adr;
		adresa=gazda19(s);
		adr=Integer.parseInt(adresa.get(0), 2)+"."+Integer.parseInt(adresa.get(1), 2)+"."+Integer.parseInt(adresa.get(2), 2)+"."+Integer.parseInt(adresa.get(3), 2);
		
		return adr;
	}
	
	public String adresaBroadcastUltimeiSubretele(IpAdress ip,int k)
	{
		StringBuilder kC=new StringBuilder("00000000");
		StringBuilder kB=new StringBuilder("0000000000000000");
		StringBuilder kA=new StringBuilder("000000000000000000000000");

		if(k!=0)
		{
			if(ip.getClasaTip().get(0).equals("Clasa A"))
			{
				for(int i=k;i<kA.length();i++)
				{
					kA.setCharAt(i,'1');
				}
				k=k-2;
				while(k>-1)
				{
					kA.setCharAt(k,'1');
					k--;
				}
				kA.insert(8, ".");
				kA.insert(16, ".");
				
				return ip.getReteaGazda().get(0)+"."+kA.toString();
			}
			else if(ip.getClasaTip().get(0).equals("Clasa B"))
			{
				for(int i=k;i<kB.length();i++)
				{
					kB.setCharAt(i,'1');
				}
				k=k-2;
				while(k>-1)
				{
					kB.setCharAt(k,'1');
					k--;
				}
				kB.insert(8, ".");
				
				return ip.getReteaGazda().get(0)+"."+kB.toString();
			}
			else if(ip.getClasaTip().get(0).equals("Clasa C") || ip.getClasaTip().get(0).equals("Clasa D")||ip.getClasaTip().get(0).equals("Clasa E"))
			{
				for(int i=k;i<kC.length();i++)
				{
					kC.setCharAt(i,'1');
				}
				k=k-2;
				while(k>-1)
				{
					kC.setCharAt(k,'1');
					k--;
				}
				
				return ip.getReteaGazda().get(0)+"."+kC.toString();
			}
		}
		
		return "Nu exista";
		
	}
	
	public List<String> gazda19(String adr)
	{
		List<String> adresa=new ArrayList<>();
		StringTokenizer strTkn = new StringTokenizer(adr, ".");
		
		while(strTkn.hasMoreTokens())
		      adresa.add(strTkn.nextToken());
		
		return adresa;
	}
	
	public List<Integer> adrIp(String adr)
	{
		List<Integer> adresaInt=new ArrayList<>();
		List<String> adresa=new ArrayList<>();
		StringTokenizer strTkn = new StringTokenizer(adr, ".");
		
		while(strTkn.hasMoreTokens())
		      adresa.add(strTkn.nextToken());
		for(int i=0;i<adresa.size();i++)
			adresaInt.add(Integer.parseInt(adresa.get(i)));
			
		return adresaInt;
	}
	
	public String prDom(String adr)
	{
		StringBuilder kC=new StringBuilder(adr);
		kC.setCharAt(kC.length()-1, '1');
		
		return kC.toString();
	}
	
	public String ultDom(String adr)
	{
		StringBuilder kC=new StringBuilder(adr);
		kC.setCharAt(kC.length()-1, '0');
		
		return kC.toString();
	}
	
	public char and(char c1,char c2)
	{
		char c = 'a';
		if(c1=='1' && c2=='1')
			c= '1';
		else 
			c='0';
		return c;
	}

}
