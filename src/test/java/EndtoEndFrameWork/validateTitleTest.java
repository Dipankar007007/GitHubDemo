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

public class validateTitleTest extends Base {
	
	public WebDriver driver;
    
	Logger log=LogManager.getLogger(qaClickTest.class.getClass().getName());//For Logging Purpose
	@BeforeTest
	public void intialize() throws IOException
	{
		
		driver=initializeDriver();
		 log.info("Driver is initialized");
	    driver.get(prop.getProperty("url"));
	    
	}
	
	@Test()
	public void ValidateTitle()throws IOException
	{
	
			
	    HomePage homepage=new HomePage(driver);
	    String CourseName=homepage.getCourseName().getText();
	    
	    Assert.assertEquals(CourseName,"FEATURED COURSES");
	    log.info("Title is verified");
	    

	  
	}
	
	@AfterTest
	public void tearDown()
	{
		  
		  driver.close();
	}

}
