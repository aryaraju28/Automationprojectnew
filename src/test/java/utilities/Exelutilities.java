package utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exelutilities {
	public static String getCellValue(String xl, String Sheet, int r, int c)
	{
		try {
			FileInputStream fileInputStream=new FileInputStream(xl);
			XSSFWorkbook workbook=new XSSFWorkbook(fileInputStream);
			XSSFCell cell=workbook.getSheet(Sheet).getRow(r).getCell(c);
			if(cell.getCellType()==CellType.STRING)
			{
				return cell.getStringCellValue();
				
			}
			else {
				return cell.getRawValue();
			}
		} catch (Exception e) {
			// TODO: handle exception
			return"";
		}
	}
	public static int getRowCount(String xl,String Sheet) {
		try {
			FileInputStream fileInputStream=new FileInputStream(xl);
					XSSFWorkbook workbook=new XSSFWorkbook(fileInputStream);
					return workbook.getSheet(Sheet).getLastRowNum();
					
			
		} catch (Exception e) {
			return 0;
			// TODO: handle exception
		}
		
	}

}
