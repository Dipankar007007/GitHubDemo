package EndtoEndFrameWork;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Base;

public class validateNavigationBar extends Base {
	
	
	Logger log=LogManager.getLogger(qaClickTest.class.getClass().getName());//For Logging Purpose
	
	public WebDriver driver;
	
	@BeforeTest
	public void intialize() throws IOException
	{
	    
		
		driver=initializeDriver();
	    driver.get(prop.getProperty("url"));
	    
	}
	
	@Test()
	public void ValidateNavigationBar() throws IOException
	{	
		
	    HomePage homepage=new HomePage(driver);
	    String CourseName=homepage.getCourseName().getText();
	 
	    
	    Assert.assertFalse(homepage.NavigationBar().isDisplayed());
	    
	    
	    	    
	}
	@AfterTest
	public void tearDown()
	{
		  driver.close();
		 
	}


}
