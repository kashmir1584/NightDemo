package testpagemodel;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pagemodel.ConnectionsPage;
import pagemodel.HomePage;
import pagemodel.LoginPage;
import utilities.ReadingExcelfile;
import utilities.TestBase;

public class ConnectionsPageTest extends TestBase
{
	HomePage homepage;
	LoginPage loginpage;
	ConnectionsPage cpage;
	
	public static ReadingExcelfile excelfile;

	
	public ConnectionsPageTest() throws IOException 
	{
		super();
	}
	
	
	@BeforeMethod
	public void Setup() throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InterruptedException
	{
		BrowserSetup();
		loginpage = new LoginPage();
		homepage = loginpage.LoginIntoAccount(property.getProperty("username"), property.getProperty("password"));
		cpage = homepage.ConnectionsList();
		Thread.sleep(3000);
	}
	
	
	@Test
	public void TotalfriendsCount() throws InterruptedException, IOException
	{
		cpage.ScrollingFriendList();
		String title = homepage.VerifyTitle();
		Assert.assertEquals(title, "LinkedIn", "title doesn't match");
	}
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
