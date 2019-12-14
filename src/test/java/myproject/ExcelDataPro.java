package myproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataPro {
	
	@Test(dataProvider="test1Data")
	public void test1(String username,String password) throws InterruptedException{
		
		
		
		System.setProperty("webdriver.chrome.driver", "E:\\webdriver\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.simplesite.com/pages/service-login.aspx");
		driver.findElement(By.id("loginBox_username")).sendKeys(username);
		driver.findElement(By.id("loginBox_password")).sendKeys(password);
		Thread.sleep(2000);

		
		
		System.out.println(username+" | "+password);
	}
	
	
	@DataProvider(name = "test1Data")
    public static Object[][] getData()
	{
		String excelpath = "F:\\test\\E2EProject\\excel\\data1.xlsx";

		Object data[][] = testData(excelpath, "Sheet1");
		return data;
	}
	

	public static  Object[][] testData(String excelpath, String sheetname)
	{
		Excelutils excel = new Excelutils(excelpath,sheetname);
		
		int rowCount = excel.getrowcount();
		int colCount = excel.getColCount();
		
		Object data[][] = new Object[rowCount-1][colCount];
		
		
		for(int i=1;i<rowCount;i++)
		{
			for(int j=0;j<colCount;j++)
			{
				String cellData = excel.getCellDataString(i, j);
				//System.out.print(cellData+" | ");
				data[i-1][j] = cellData;
			}
			System.out.println();
		}
		return data;
	}

}
