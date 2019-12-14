package myproject;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutils {
	static String projectpath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	public Excelutils(String excelpath, String sheetname)
	{
		try {

			workbook = new XSSFWorkbook(excelpath);
			sheet = workbook.getSheet(sheetname);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		getrowcount();
		getCellDataString(0,0);
		getCellDataNumber(1,1);
	}

	public static int getrowcount()
	{
		int rowCount=0;
		
		try {


			 rowCount = sheet.getPhysicalNumberOfRows();
			//System.out.println("No of Rows: "+rowCount);

		} catch (Exception e) {

			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return rowCount;
		

	}
	public static int getColCount()
	{
		
		int colCount=0;
		try {


			 colCount = sheet.getRow(0).getPhysicalNumberOfCells();
			//System.out.println("No of columns: "+colCount);

		} catch (Exception e) {

			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return colCount;
	}

	public static String getCellDataString(int rowNum, int colNum)
	{
		String cellData = null;
		try {

			 cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			//System.out.println(cellData);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return cellData;
	}
	public static double getCellDataNumber(int rowNum, int colNum)
	{
		double cellData=0;
		try {

			 cellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			//System.out.println(cellData);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
			
		}
		return cellData;

	}
}


