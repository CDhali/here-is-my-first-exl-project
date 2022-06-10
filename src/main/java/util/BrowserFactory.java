package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
static WebDriver driver;
static String browser;
static String url;
	public static void readconfig() {
		try {
			InputStream input = new FileInputStream("src\\main\\java\\config\\config.properties");
		     Properties prop = new Properties();
		     prop.load(input);// input the config file this way...
		     browser = prop.getProperty("browser");
		     url = prop.getProperty("url");
		}catch(IOException e) {
		  e.printStackTrace();
		}		
	}
	public static WebDriver init() {
		readconfig();
		if(browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://techfios.com/billing/?ng=login/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public static void tearDown() {
		driver.close();
		driver.quit();
	}
	
	
}


//two depenticied; apache poi.. apachi poi ooxml..
// filr is older 
//xssf is use for 2010
//hssf 2007..
// to make java read xml to make special class
