package Academy;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import resources.base;

public class MyProgramScreenshot extends base {
	
	 public static Logger log =LogManager.getLogger(base.class.getName());

	
	WebDriver driver;
	
	@Test
	public void printscreen() throws IOException
	{
		
		System.setProperty("webdriver.chrome.driver", "E:\\webdriver\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		
		driver.get("http://google.com");
		String url = driver.getCurrentUrl();
		driver.getTitle();
		String handles = driver.getWindowHandle();
		System.out.println(handles);

		System.out.println(url);
		String pagesrc =  driver.getPageSource();
		//System.out.println(pagesrc);
		
		
		
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("F://test1//screenshot.png"));

		driver.close();
		
		
		File src1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src1, new File("F://test1//screenshot1.png"));
		
	}

}
