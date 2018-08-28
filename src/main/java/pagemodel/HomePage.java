package pagemodel;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.TestBase;

public class HomePage extends TestBase 
{
	
	LoginPage loginpage = new LoginPage();

	@FindBy(id="mynetwork-nav-item")
	WebElement MyNetworkLinkText;
	
	@FindBy(xpath="//div[@class='left-rail-container']/div/div[1]/a[2]")
	WebElement SeeAllLinkText;

	@FindBy(id="jobs-nav-item")
	WebElement JobLinkText;
	
	/*@FindBy(className="//div[@class='nav-main__content full-height display-flex']/ul/li[3]/a")
	WebElement JobLinkText;*/
	
	public HomePage() throws IOException
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public ConnectionsPage ConnectionsList() throws InterruptedException, IOException
	{
		MyNetworkLinkText.click();
		Thread.sleep(10000);
		SeeAllLinkText.click();
		Thread.sleep(10000);
		return new ConnectionsPage();
	}
	
	
	public JobPage JobList() throws InterruptedException, IOException
	{
		JobLinkText.click();
		Thread.sleep(3000);
		return new JobPage();
	}
	
	
	public String VerifyTitle()
	{
		 String title = driver.getTitle();
		 System.out.println("page title is -- " +title);
		 return title;
	}
}