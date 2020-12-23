package SF1;
import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class VF1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File a = new File("C:\\Users\\user\\Desktop\\Selenium Code\\Password.xlsx");
		FileInputStream fs = new FileInputStream(a);
		XSSFWorkbook wb = new XSSFWorkbook(fs);
		XSSFSheet sheet = wb.getSheetAt(0);
		String data = sheet.getRow(1).getCell(0).getStringCellValue();
		String data2 = sheet.getRow(1).getCell(1).getStringCellValue();
		System.out.println("Data is " +data);
		System.out.println("Data is " +data2);
		
	}

}
