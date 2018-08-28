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

public class HomePageTest extends TestBase {
	
	HomePage homepage;
	LoginPage loginpage;
	ConnectionsPage cpage;
	
	public static ReadingExcelfile excelfile;
	
	public HomePageTest() throws IOException 
	{
		super();
	}
	
	
	@BeforeMethod
	public void Setup() throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InterruptedException
	{
		BrowserSetup();
		loginpage = new LoginPage();
		homepage = loginpage.LoginIntoAccount(property.getProperty("username"), property.getProperty("password"));
		Thread.sleep(3000);
	}
	
	
	@Test
	public void TotalfriendsCount() throws InterruptedException, IOException
	{
		cpage = homepage.ConnectionsList();
		String title = homepage.VerifyTitle();
		Assert.assertEquals(title, "(1) LinkedIn", "title doesn't match");
	}
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	
	
}
