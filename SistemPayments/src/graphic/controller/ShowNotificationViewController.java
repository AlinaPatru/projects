package graphic.controller;

import java.util.ArrayList;
import java.util.List;

import graphic.GraphicMethods;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class ShowNotificationViewController 
{
	@FXML
	private TextArea notificationMessage;
	@FXML
    private Label numberNotifications;
	
	private List<String> notifications = new ArrayList<>();
	
	private int numberOfNotification ;
	
	private GraphicMethods graphicMethods=new GraphicMethods();
	
	public ShowNotificationViewController()
	{
		
	}
	
	public void setNumberOfNotification(int numberOfNotification)
	{
		this.numberOfNotification = numberOfNotification;
	}
	
	public int getNumberOfNotification()
	{
		return this.numberOfNotification;
	}
	
	public void setNotifications(List<String> notifications)
    {
    	this.notifications = notifications;
    }
	
	public void setScene()
	{
		numberNotifications.setText("You have "+notifications.size()+" notifications !");
		if(notifications.size()==0)
		{
			notificationMessage.setText("You have no notifications !");
		}
		else
		{
			notificationMessage.setText(notifications.get(0));
		    int n=getNumberOfNotification();
		    n++;
		    setNumberOfNotification(n);
		}

	}
	
	@FXML
	private void nextNotification(ActionEvent event)
	{
		if( notifications.size()==0)
		{
			numberNotifications.setText("You have "+0+" notifications !");
			notificationMessage.setText("You have no notifications !");
		}
		else
			if(getNumberOfNotification() >= notifications.size() )
			{	
				numberNotifications.setText("You have "+0+" notifications !");
				notificationMessage.setText("You have no more notifications !");
			}
			else
			{
				notificationMessage.setText(notifications.get(getNumberOfNotification()));
				int n = getNumberOfNotification();
				n++;
				setNumberOfNotification(n);
			}
	}
		
	@FXML
	private void exit(ActionEvent event)
	{
		graphicMethods.closeStage(event);
	}
    

}
