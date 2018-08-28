package pagemodel;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.TestBase;

public class LoginPage extends TestBase 
{
	
	@FindBy(id="login-email")
	WebElement loginId;
	
	@FindBy(id="login-password")
	WebElement loginpassword;
	
	@FindBy(id="login-submit")
	WebElement loginbtn;
	
		
	JavascriptExecutor jse =  (JavascriptExecutor)driver;
	
	
	public LoginPage() throws IOException
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void MouseHover() throws InterruptedException 
	{
		/*Actions action = new Actions(driver);
		action.moveToElement(ProfileLink).build().perform();
		SignInLink.click();
		Thread.sleep(5000);*/
	}
	
	
	public HomePage LoginIntoAccount(String un, String pw) throws InterruptedException, IOException
	{
		loginId.sendKeys(un);
		loginpassword.sendKeys(pw);
		loginbtn.click();
		return new HomePage();
	}
	
	
	public String VerifyTitle()
	{
		 String title = driver.getTitle();
		 System.out.println("page title is -- " +title);
		return title; 
	}
	
	public void coord()
	{
		Point coords = loginbtn.getLocation();
		int x = coords.getX();
		int y = coords.getY();
		System.out.println("x & y cood are -- "+x +","+y);		
	}
	
}
