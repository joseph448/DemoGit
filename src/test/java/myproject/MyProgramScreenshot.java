package myproject;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MyProgramScreenshot {
	
	WebDriver driver;
	
	@Test
	public void printscreen()
	{
		
		System.setProperty("webdriver.chrome.driver", "E:\\webdriver\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://google.com");
		
		
	}

}
