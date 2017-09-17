import java.util.ArrayList;
import java.util.List;

public class IpAdress 
{
	private List<Integer> ip=new ArrayList<>();
	private List<String> reteaGazda=new ArrayList<>();
	private List<String> reteaBroadcast=new ArrayList<>();
	private List<String> ipBinar=new ArrayList<>();
	private List<String> clasaTip=new ArrayList<>();
	private int nrBitiGazda;
	private int nrMinimBiti;
	private int nrMaximBiti;
	private int nrMaximGazde;
	private List<String> gazda2014=new ArrayList<>();//zec+bin
	private List<String> mascaRetea=new ArrayList<>();
	private List<String> adresaRetelei=new ArrayList<>();
	private List<String> adresaIpUltSubretea=new ArrayList<>();
	private List<String> broadcastUltSubretea=new ArrayList<>();
	private List<String> gazda19UltSubretea=new ArrayList<>();
	
	public IpAdress() 
	{
		
	}

	

	public IpAdress(List<Integer> ip, List<String> reteaGazda, List<String> reteaBroadcast, List<String> ipBinar,
			List<String> clasaTip, int nrBitiGazda, int nrMinimBiti, int nrMaximBiti, int nrMaximGazde,
			List<String> gazda2014, List<String> mascaRetea, List<String> adresaRetelei,
			List<String> adresaIpUltSubretea, List<String> broadcastUltSubretea, List<String> gazda19UltSubretea) 
	{
		this.ip = ip;
		this.reteaGazda = reteaGazda;
		this.reteaBroadcast = reteaBroadcast;
		this.ipBinar = ipBinar;
		this.clasaTip = clasaTip;
		this.nrBitiGazda = nrBitiGazda;
		this.nrMinimBiti = nrMinimBiti;
		this.nrMaximBiti = nrMaximBiti;
		this.nrMaximGazde = nrMaximGazde;
		this.gazda2014 = gazda2014;
		this.mascaRetea = mascaRetea;
		this.adresaRetelei = adresaRetelei;
		this.adresaIpUltSubretea = adresaIpUltSubretea;
		this.broadcastUltSubretea = broadcastUltSubretea;
		this.gazda19UltSubretea = gazda19UltSubretea;
	}



	public int getNrBitiGazda() 
	{
		return nrBitiGazda;
	}

	public void setNrBitiGazda(int nrBitiGazda) 
	{
		this.nrBitiGazda = nrBitiGazda;
	}
	
	public List<String> getIpBinar() 
	{
		return ipBinar;
	}
	
	public List<Integer> getIp() 
	{
		return ip;
	}
	
	public void setIp(List<Integer> ip) 
	{
		this.ip = ip;
	}
	
	public void setIpBinar(List<String> ipBinar) 
	{
		this.ipBinar = ipBinar;
	}
	
	public List<String> getMascaRetea() 
	{
		return mascaRetea;
	}

	public List<String> getAdresaRetelei() 
	{
		return adresaRetelei;
	}

	public void setMascaRetea(List<String> mascaRetea) 
	{
		this.mascaRetea = mascaRetea;
	}

	public void setAdresaRetelei(List<String> adresaRetelei) 
	{
		this.adresaRetelei = adresaRetelei;
	}

	public int getNrMaximGazde() 
	{
		return nrMaximGazde;
	}

	public void setNrMaximGazde(int nrMaximGazde) 
	{
		this.nrMaximGazde = nrMaximGazde;
	}

	public int getNrMinimBiti() 
	{
		return nrMinimBiti;
	}

	public int getNrMaximBiti() 
	{
		return nrMaximBiti;
	}

	public List<String> getAdresaIpUltSubretea() 
	{
		return adresaIpUltSubretea;
	}

	public List<String> getBroadcastUltSubretea() 
	{
		return broadcastUltSubretea;
	}

	public List<String> getGazda19UltSubretea() 
	{
		return gazda19UltSubretea;
	}

	public void setNrMinimBiti(int nrMinimBiti) 
	{
		this.nrMinimBiti = nrMinimBiti;
	}

	public void setNrMaximBiti(int nrMaximBiti) 
	{
		this.nrMaximBiti = nrMaximBiti;
	}

	public void setAdresaIpUltSubretea(List<String> adresaIpUltSubretea) 
	{
		this.adresaIpUltSubretea = adresaIpUltSubretea;
	}

	public void setBroadcastUltSubretea(List<String> broadcastUltSubretea) 
	{
		this.broadcastUltSubretea = broadcastUltSubretea;
	}

	public void setGazda19UltSubretea(List<String> gazda19UltSubretea) 
	{
		this.gazda19UltSubretea = gazda19UltSubretea;
	}

	public List<String> getReteaGazda() 
	{
		return reteaGazda;
	}

	public List<String> getReteaBroadcast() 
	{
		return reteaBroadcast;
	}

	public List<String> getClasaTip() 
	{
		return clasaTip;
	}

	public List<String> getGazda2014() 
	{
		return gazda2014;
	}

	public void setReteaGazda(List<String> reteaGazda) 
	{
		this.reteaGazda = reteaGazda;
	}

	public void setReteaBroadcast(List<String> reteaBroadcast) 
	{
		this.reteaBroadcast = reteaBroadcast;
	}

	public void setClasaTip(List<String> clasaTip) 
	{
		this.clasaTip = clasaTip;
	}

	public void setGazda2014(List<String> gazda2014) 
	{
		this.gazda2014 = gazda2014;
	}

}
