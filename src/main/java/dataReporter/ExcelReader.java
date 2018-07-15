package dataReporter;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelReader {

	 @Test
	 public String[][] readExcel(String fileName) throws IOException
	 {
		 XSSFWorkbook wbook=new XSSFWorkbook("./data/"+fileName+".xlsx");
		// wbook.getSheet("sheet1"); to move to the particular sheet, sheet name should be mentioned mandatory
		 XSSFSheet sheet=wbook.getSheetAt(0);//to get the 0th sheet
		 int lastRowNum = sheet.getLastRowNum();//to get the number of rows in a sheet
		 System.out.println(lastRowNum);
		 XSSFRow header = sheet.getRow(0);
		 int lastCellNum = header.getLastCellNum();
		 System.out.println(lastCellNum);
		 String[][] data=new String[lastRowNum][lastCellNum];
		 for(int i=1;i<=lastRowNum;i++)
		 {
			  XSSFRow row = sheet.getRow(i);
			 for(int j=0;j<lastCellNum;j++)
			 {
				XSSFCell cell = row.getCell(j);
				String value = cell.getStringCellValue();
				
				data[i-1][j]=value;
			 }
		 }
		 wbook.close();
		return data;
		 
	 }
}
