package EndtoEndFrameWork;


import java.io.IOException;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import resources.Base;

public class qaClickTest extends Base{
	
	Logger log=LogManager.getLogger(qaClickTest.class.getClass().getName());//For Logging Purpose

	public WebDriver driver;
	
	
	@Test(dataProvider="getData")
	public void NavigatePage(String UserId,String Password,String Message) throws IOException, SQLException
	{ 
	    
		
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
		
	    HomePage homepage=new HomePage(driver);
	    String CourseName=homepage.getCourseName().getText();
	    
	    log.info("Course Name is correct");
	    homepage.getLogin().click();
	    log.info("Login Button Clicked");
	    
	    
	    LoginPage loginpage=new LoginPage(driver);
	    
	    result=getMySqlData();
	    result.next();
	    
	    log.info(result.getString("id"));
	    loginpage.getUserId().sendKeys(UserId);
	    log.info("User Name Entered");
	    loginpage.getPassword().sendKeys(Password);
	    log.info("Password Entered");
	    loginpage.Login().click();
	    
	    log.info(Message);
	
	    driver.close();
	    
	    
	}
	
	  @DataProvider
	  public Object[][] getData()
	     {
	    	 Object[][] data=new Object[2][3];
	    	 data[0][0]="singhpritam007";
	    	 data[0][1]="lion007007";	
	    	 data[0][2]="For restricted User";
	         data[1][0]="pritamsingh007";
	         data[1][1]="elephant008";
	         data[1][2]="For Valid User";
	         return data;
	     }
	
	  @AfterTest
	  public void update()
	  {
		  log.info("Getting Update");
	  }
	
}
