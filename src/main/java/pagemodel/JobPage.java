package pagemodel;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.TestBase;

public class JobPage extends TestBase
{
	
	/*@FindBy(className="card-list card-list--tile pl3 pr3 pb3")
	WebElement LastJobSection;*/

	@FindBy(className="dpi-1")
	WebElement LastJobSection;
	
	
	public JobPage() throws IOException
	{
		PageFactory.initElements(driver, this);
	}
	
	public void scrollIntoAView() throws InterruptedException
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", LastJobSection );
		Thread.sleep(5000);
	}
	
	public String VerifyTitle()
	{
		 String title = driver.getTitle();
		 System.out.println("page title is -- " +title);
		 return title;
	}
}
