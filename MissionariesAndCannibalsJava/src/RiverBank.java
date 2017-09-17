
public class RiverBank 
{
	private int missionariesNumber;
	private int cannibalsNumber;
	private int boat;
	
	public RiverBank()
	{
		
	}
	
	public RiverBank(int missionariesNumber, int cannibalsNumber, int boat) 
	{
		this.missionariesNumber = missionariesNumber;
		this.cannibalsNumber = cannibalsNumber;
		this.boat = boat;
	}

	public int getMissionariesNumber() 
	{
		return missionariesNumber;
	}

	public int getCannibalsNumber() 
	{
		return cannibalsNumber;
	}

	public int getBoat() 
	{
		return boat;
	}

	public void setMissionariesNumber(int missionariesNumber) 
	{
		this.missionariesNumber = missionariesNumber;
	}

	public void setCannibalsNumber(int cannibalsNumber) 
	{
		this.cannibalsNumber = cannibalsNumber;
	}

	public void setBoat(int boat) 
	{
		this.boat = boat;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + boat;
		result = prime * result + cannibalsNumber;
		result = prime * result + missionariesNumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RiverBank other = (RiverBank) obj;
		if (boat != other.boat)
			return false;
		if (cannibalsNumber != other.cannibalsNumber)
			return false;
		if (missionariesNumber != other.missionariesNumber)
			return false;
		return true;
	}

	@Override
	public String toString() 
	{
		return "RiverBank [missionariesNumber=" + missionariesNumber + ", cannibalsNumber=" + cannibalsNumber + ", boat="
				+ boat + "]";
	}
	
}
