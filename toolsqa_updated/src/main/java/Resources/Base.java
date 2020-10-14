package Resources;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class Base {
	
	public static WebDriver driver;
	public 	 Properties prop;

 public WebDriver initializeDriver() throws IOException 
 {
	prop = new Properties(); 
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/Resources/data.properties");
	prop.load(fis);
	 String browsername =prop.getProperty("browser");
	 System.out.println(browsername);
	 
	 if(browsername.equals("chrome"))	
	 {
		 System.setProperty("webdriver.chrome.driver","C:\\Chromedriver\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();	
		 }
	 
	 
	 else if (browsername.equals("firefox"))
	 {
		
		 System.setProperty("webdriver.gecko.driver","C:\\firefoxdriver\\geckodriver.exe");
		 driver = new FirefoxDriver();
		 driver.manage().window().maximize();	
     }
	 
	 else if (browsername.equals("IE"))
	 {
		 System.setProperty("webdriver.ie.driver","C:\\IEDriverServer\\IEDriverServer.exe");
		 driver = new InternetExplorerDriver();
		 driver.manage().window().maximize();	
	 }
	return driver;

}
 
 }
	