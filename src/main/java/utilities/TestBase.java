package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase {
	
	
	public static Properties property = new Properties();
	public static FileInputStream fis;
	public static File file;
	public static WebDriver driver;
	
	
	//***Reading property file***
	public TestBase() throws IOException
	{
			System.out.println("--Going to read properties file");
			file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\PropFile.properties");
			fis = new FileInputStream(file);
			property.load(fis);
			System.out.println("property file load complete");		
	}
	
	
	//***This is browser setup section***
	public static void BrowserSetup() throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException 
	{
		String browserName = property.getProperty("browser"); 
		System.out.println("browser name is -- " +browserName);
		
			System.out.println("------Entering Invoking browser method-----------");
			if(browserName.equalsIgnoreCase("chrome")){
				System.out.println("------Invoking chrome browser-----------");
				System.setProperty("webdriver.chrome.driver", 
						"C:\\Users\\kashmir\\Documents\\SELENIUM_TOOLS\\chromedriver.exe");
				driver = new ChromeDriver();
				}else if(browserName.equalsIgnoreCase("firefox")){
					System.out.println("------Invoking firefox browser-----------");
					System.setProperty("webdriver.gecko.driver", 
						"C:\\Users\\kashmir\\Documents\\SELENIUM_TOOLS\\geckodriver.exe");
					driver = new FirefoxDriver();
					}else if(browserName.equalsIgnoreCase("IE")){
						System.out.println("------Invoking IE browser-----------");
						System.setProperty("webdriver.MicrosoftWeb.driver", 
								"C:\\Users\\kashmir\\Documents\\SELENIUM_TOOLS\\MicrosoftWebDriver.exe");
						driver = new InternetExplorerDriver();
			}else{
				System.out.println("no matching web browser found");
			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(property.getProperty("URL"));
		}	
}