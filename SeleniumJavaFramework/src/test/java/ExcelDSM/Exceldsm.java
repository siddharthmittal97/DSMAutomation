package ExcelDSM;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class Exceldsm {
	 XSSFWorkbook wb;
	 XSSFSheet sheet;
	 public void ExcelReader1(String ExcelPath)
	 {
		 try {
			 File a = new File(ExcelPath);
			 FileInputStream fs = new FileInputStream(a);
			 wb = new XSSFWorkbook(fs);		 	 
		     }
		 catch(Exception e) {
			System.out.println(e.getMessage()); 
		 }  		 
       }
	 
	 public String getData(int sheetNumber,int row , int coloumn)
	 {
		sheet = wb.getSheetAt(0);
		String data = sheet.getRow(row).getCell(coloumn).getStringCellValue();
		return data;		
	 }	 
}
