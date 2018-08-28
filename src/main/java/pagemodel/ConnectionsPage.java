package pagemodel;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.TestBase;

public class ConnectionsPage extends TestBase
{

	
	HomePage homepage = new HomePage();

	@FindBy(id="mynetwork-nav-item")
	WebElement MyNetworkLinkText;
 
	
	public ConnectionsPage() throws IOException
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void ScrollingFriendList() throws InterruptedException
	{
		List<WebElement> friends = driver.findElements(By.xpath("//div[@class='mn-person-info__details']/a"));
		System.out.println("no of friends :: " + friends.size());
		
		JavascriptExecutor js = (JavascriptExecutor)driver;

		int totalfrnds = friends.size();
		int oldfrnds = 0;
		
		while(totalfrnds != oldfrnds){
			oldfrnds = totalfrnds;
			WebElement lastfriend = friends.get(friends.size()-1);
			int y = lastfriend.getLocation().getY();
			js.executeScript("window.scrollTo(0, "+y+")");
			Thread.sleep(3000);
			friends = driver.findElements(By.xpath("//div[@class='mn-person-info__details']/a"));
			totalfrnds = friends.size();
			System.out.println("no of friends :: " + friends.size());
			
		/*int totalfrnds = friends.size();
		int oldfrnds = 0;
		Actions action = new Actions(driver);
		
		while(totalfrnds != oldfrnds){
			oldfrnds = totalfrnds;
			WebElement lastFriend = friends.get(friends.size()-1);
		action.moveToElement(lastFriend).build().perform();
		Thread.sleep(3000);
		friends = driver.findElements(By.xpath("//div[@class='mn-person-info__details']/a"));
		totalfrnds = friends.size();
		System.out.println("no of friends :: " + friends.size());*/
		}
		System.out.println("total no of friends :: " + friends.size());
	}
	
	
	public String VerifyTitle()
	{
		 String title = driver.getTitle();
		 System.out.println("page title is -- " +title);
		 return title;
	}
}
