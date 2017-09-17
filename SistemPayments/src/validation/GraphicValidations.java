package validation;

import model.Client;

public class GraphicValidations 
{
	public void validationCreateNewAccount(String username , String password1 , String password2, String name) throws MyException
	{
		if(username.isEmpty())
			throw new MyException("Fill in the username field");
		if(password1.isEmpty())
			throw new MyException("Fill in the password field");
		if(password2.isEmpty())
			throw new MyException("Fill in the password field");
		if(name.isEmpty())
			throw new MyException("Fill in the name field");
		if(!password1.equals(password2))
			throw new MyException("Password didn't match");
		
	}
	
	public void validationLogin(String username, String password)throws MyException
	{
		if(username.isEmpty())
			throw new MyException("Fill in the username field");
		if(password.isEmpty())
			throw new MyException("Fill in the password field");
		
	}
	
	public void validationChangeClientData(Client c,String name, String oldPassword, String newPassword1, String newPassword2) throws MyException//*****
	{
		if(name.isEmpty())
			throw new MyException("Fill in the name field");
		if(oldPassword.isEmpty())
			throw new MyException("Fill in the old password field");
		if(newPassword1.isEmpty())
			throw new MyException("Fill in the password field");
		if(newPassword2.isEmpty())
			throw new MyException("Fill in the password field");
		if(!c.getPassword().equals(oldPassword))
			throw new MyException("Wrong old password");
		if(!newPassword1.equals(newPassword2))
			throw new MyException("Password didn't match");
	}
	
	public void validationAddToDeposit(String sum)throws MyException
	{
		if(sum.isEmpty())
			throw new MyException("Fill in the sum you want to add to your deposit");
		if(isDouble(sum)==false)
			throw new MyException("Enter again the sum you want to add to your deposit");		
		
	}
	
	public boolean isDouble(String sum)
	{
		String regex ="(0.[0-9]+)|[1-9]+[0-9]*(.[0-9]+)*";
		if(sum.matches(regex))
			return true;
		return false;
	}
	
	public void validationDeleteFromDeposit(Client client,double sum)throws MyException
	{
		if(client.getDeposit()<sum)
			throw new MyException("You don't have enough money in your deposit to pay this bill");
	}

}
