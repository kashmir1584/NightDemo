package testpagemodel;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pagemodel.HomePage;
import pagemodel.LoginPage;
import utilities.ReadingExcelfile;
import utilities.TestBase;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	public static ReadingExcelfile excelfile;
	
	
	public LoginPageTest() throws IOException 
	{
		super();
	}
	
	
	@BeforeMethod
	public void Setup() throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InterruptedException
	{
		BrowserSetup();
		loginpage = new LoginPage();
		Thread.sleep(5000); 
	}
	
	/*
	@Test()
	public void MHover() throws InterruptedException
	{
		loginpage.MouseHover();
	}*/
	
	
	/*@Test
	public void LoginTest() throws InterruptedException, IOException
	{
		homepage = loginpage.LoginIntoAccount(property.getProperty("username"), property.getProperty("password"));
		String title = loginpage.VerifyTitle();
		Assert.assertEquals(title, "(1) LinkedIn", "title doesn't match");
		Thread.sleep(5000);
	}*/
	
	
	@Test
	public void XYCoord()
	{
		loginpage.coord();
	}
	
	@Test
	public void managecookies()
	{
		driver.manage().deleteAllCookies();
	}
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
