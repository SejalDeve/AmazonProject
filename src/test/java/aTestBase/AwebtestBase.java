package aTestBase;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AwebtestBase {
	
		public static WebDriver driver;
		public static Properties prop;  //properties -help to read config prop file
		
		
		public AwebtestBase() 
		{
			
			try
			{
			   //for read file config.propertes //user.dir-scope under the project//System.getProperty is path of project
			   FileInputStream fileInputStream=new FileInputStream(System.getProperty("user.dir")+"//properties//config.properties");
				
				prop=new Properties();
				prop.load(fileInputStream);			}
			   catch(Exception e)
		    	{
				  e.printStackTrace();	
			    }
			
	    	}		
		   public void  initialization() 
		   {
			String browserName =prop.getProperty("browser");
			
			if(browserName.equals("chrome")) {
				//to load the driver
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//driver//chromedriver.exe");
				ChromeOptions options=new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				driver=new ChromeDriver(options);
				
				//navigate-used for not wait for page load to move forward and backward
				driver.navigate().to(prop.getProperty("url"));
				//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
				driver.manage().window().maximize();
				//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				driver.manage().deleteAllCookies();//delete all the cookies
			}
			
		}

	}





