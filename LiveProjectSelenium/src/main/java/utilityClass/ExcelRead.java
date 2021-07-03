package utilityClass;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	XSSFWorkbook w;
	XSSFSheet sh;

	public ExcelRead() {
		try {

			File f = new File(
					"C:\\Users\\rose\\eclipse-workspace\\LiveProjectSelenium\\src\\main\\resources\\excelread.xlsx");
			FileInputStream fis = new FileInputStream(f);
			w = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("file not found");
		}
	}

	public String getinputFromExcel(int s, int r, int c) {
		sh = w.getSheetAt(s);
		XSSFRow row = sh.getRow(r);
		XSSFCell cell = row.getCell(c);
		switch (cell.getCellType()) {
		case STRING: {
			String t;
			t = cell.getStringCellValue();
			return t;
		}
		case NUMERIC: {
			long l = (long) cell.getNumericCellValue();

			return String.valueOf(l);
		}
		default:
			return null;
		}
	}
}
