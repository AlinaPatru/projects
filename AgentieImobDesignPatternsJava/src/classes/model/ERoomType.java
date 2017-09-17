package classes.model;

public enum ERoomType
{
	SingleRoom(0), DoubleRoom(1), Apartament(2);
	
	private int value;
	
	ERoomType(int value)
	{
		this.value = value;
	}
	
	public int getValue()
	{
		return this.value;
	}
}
