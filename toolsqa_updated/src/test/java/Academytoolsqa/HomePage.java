package Academytoolsqa;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.Base;
import Resources.WriteExcel_Utility;

public class HomePage extends Base {

	public static WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());



	TakesScreenshot ts = (TakesScreenshot) driver;

	@BeforeTest
	public void initiateall() throws Exception {
		driver = initializeDriver();
		log.info("Driver is Initialized");
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		log.info("Navigated to home page ");
		driver.switchTo().frame("master-1");
	}

	@Test(description = "Firsttimerun_code")
	public void clickingLinksFirstrun() throws Exception {

		List<WebElement> links = driver.findElements(By.tagName("a"));
		int count = links.size();

	      
		log.info("Successfully counted total numer of links from the page" + count);
		ArrayList<String> hrefs = new ArrayList<String>();

		for (WebElement link : links) {
			System.out.println(link.getAttribute("href"));
			hrefs.add(link.getAttribute("href"));
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			System.out.println("************************");

		}

//Navigating to each link
		
		for (String href : hrefs) {

			 if (href.contains("http")) 
			 {
				
			driver.navigate().to(href);
			//driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
			Thread.sleep(4000);

			 String title=driver.getTitle();
		System.out.println(title);
			//String parts[]= title.split("-", 0);
			//System.out.println(parts[0]);	
			if(title.contains("oo")) {
				  File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				  String currentDir = System.getProperty("user.dir");
				  String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());

				  
				  FileUtils.copyFile(scrFile, new File(currentDir+ "\\screenshots\\" + title +timestamp+ ".png"));

				  log.info("Screenshot taken successfully"); 
				  WriteExcel_Utility excelwrite =new WriteExcel_Utility(System.getProperty("user.dir")+ "/src/main/java/Resources/TestDataa.xlsx");
				  excelwrite.setCellData("Credentials",2,1,"PASS");

			}

		}
	}
		
			  
			  
			 
		}


	@Test(description = "Secondtimerun_code")
	public void clickingLinksSecondrun() throws Exception {

		List<WebElement> links = driver.findElements(By.tagName("a"));
		int count = links.size();

		log.info("Successfully counted total numer of links from the page" + count);
		ArrayList<String> hrefs = new ArrayList<String>();

		for (WebElement link : links) {
			System.out.println(link.getAttribute("href"));
			hrefs.add(link.getAttribute("href"));
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

			System.out.println("***********************");
		}

//Navigating to each link
		
		for (String href : hrefs) 
		{
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);//wait for 60 sec.

			if (href.contains("http")) {

			driver.navigate().to(href);
			Thread.sleep(4000);

			//driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

			String title=driver.getTitle();
			System.out.println(title);
			//String parts[]= title.split("-", 0);
			//System.out.println(parts[0]);	
			if(title.contains("oo")) {
				  File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				  String currentDir = System.getProperty("user.dir");
				  String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
				  
				  FileUtils.copyFile(scrFile, new File(currentDir+ "\\screenshotsfirst\\" + title + timestamp + ".png"));

				  log.info("Screenshot taken successfully"); 
				  WriteExcel_Utility excelwrite =new WriteExcel_Utility(System.getProperty("user.dir")+ "/src/main/java/Resources/TestDataa.xlsx");
				  excelwrite.setCellData("Credentials",2,2,"PASS");
			}

			 }
			 
		}
		
	}
	
	



	@AfterTest
	public void exit() throws Exception {
		driver.quit();
	}

}
