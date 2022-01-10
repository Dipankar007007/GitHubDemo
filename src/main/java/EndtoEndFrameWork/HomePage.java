package EndtoEndFrameWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	HomePage(WebDriver driver)
	{
		
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[text()='Login']")
	private WebElement login;
	
	
	
	public WebElement getLogin()
	{
		return login;
	}
	
	@FindBy(xpath="//div[@class='text-center']/h2")
	private WebElement courseName;
	
	public WebElement getCourseName()
	{
		return courseName;
	}
	@FindBy(xpath="//nav[contains(@class,'navbar-collapse collapse')]")
	private WebElement navigationBar;
	
	public WebElement NavigationBar()
	{
		return navigationBar;
	}
	

}
