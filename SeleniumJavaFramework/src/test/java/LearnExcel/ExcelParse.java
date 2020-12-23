package LearnExcel;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFComment;
//import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelParse {
	public static void main(String[] args) throws Exception {
		int i;
		File a = new File("C:\\Users\\user\\Desktop\\Selenium Code\\Password.xlsx");
		FileInputStream fs = new FileInputStream(a);
		XSSFWorkbook wb = new XSSFWorkbook(fs);
		XSSFSheet sheet = wb.getSheetAt(0);
		//String data = sheet.getRow(1).getCell(0).getStringCellValue();
		//String data2 = sheet.getSheetName(); 
		//System.out.println(data2);
		int data9 = sheet.getLastRowNum();
		//System.out.println(data9);
		for(i=1;i<data9;i++)
		{
			String automation = sheet.getRow(i).getCell(0).getStringCellValue();
			System.out.println(automation);
		}
		/* Not working if loop
		 //System.out.println(data3);
		// System.out.println(data4);
		if (data2 == "Sheet1") {
			  System.out.println("Sheet is present");
			} else {
			  System.out.println("Not exist");
			}
		*/
	}
}	


