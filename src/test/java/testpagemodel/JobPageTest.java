package testpagemodel;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pagemodel.HomePage;
import pagemodel.JobPage;
import pagemodel.LoginPage;
import utilities.ReadingExcelfile;
import utilities.TestBase;

public class JobPageTest extends TestBase{

	
	
	HomePage homepage;
	LoginPage loginpage;
	JobPage jobpage;
	
	public static ReadingExcelfile excelfile;

	
	public JobPageTest() throws IOException 
	{
		super();
	}
	
	
	@BeforeMethod
	public void Setup() throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InterruptedException
	{
		BrowserSetup();
		loginpage = new LoginPage();
		homepage = loginpage.LoginIntoAccount(property.getProperty("username"), property.getProperty("password"));
		jobpage = homepage.JobList();
		Thread.sleep(3000);
	}
	
	
	@Test
	public void JobPosting() throws InterruptedException, IOException
	{
		jobpage.scrollIntoAView();
		String title = homepage.VerifyTitle();
		Assert.assertEquals(title, "Jobs | LinkedIn", "title doesn't match");
	}
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
