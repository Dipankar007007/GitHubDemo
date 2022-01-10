package EndtoEndFrameWork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
	LoginPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="user_email")
	private WebElement UserId;
	public WebElement getUserId()
	{
		return UserId;
	}
	
	@FindBy(id="user_password")
	private WebElement Password;
	public WebElement getPassword()
	{
		return Password;
	}
	
	@FindBy(xpath="//input[@value='Log In']")
	private WebElement login;
	public WebElement Login()
	{
		return login;
	}
	

}
