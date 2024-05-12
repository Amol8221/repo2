package com.utilis;



import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;

import com.testbase.BasePage;

public class ExcelDataSheet  extends BasePage{
	 

	//public  static String TEST_DATA_SHEET_PATH = "./src/main/java/com/resources/ExcelData.xlsx";
	
	//public static Sheet sheet;
	
	public static    Sheet sheet;
	public  static Workbook book;
	public static Object[][] getTestDataString (String name) throws InvalidFormatException, IOException {
	
		//System.out.println("reading test data from sheet : " + name);
		
		/* 2 D object array as null */

		Object data[][] = null;
		System.out.println("pass1");
		
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/resources/ExcelData.xlsx");
			System.out.println("pass2"+ip);
			//BufferedReader buff= new BufferedReader();
	//		OPCPackage p= OPCPackage.open(ip);
			book= new  XSSFWorkbook  (ip);
			//book=WorkbookFactory.create(ip);
			System.out.println("pass3");
			//System.out.println(book);
			 //book = new XSSFWorkbook(ip);
			 //sheet = book.getSheetAt(0);
			//book = new XSSFWorkbook(ip);
//book =   (XSSFWorkbook) WorkbookFactory.create(ip);
			//sheet=book.getSheetAt(0);
			/* Return a sheet reference by using getSheet function */
			sheet = book.getSheet(name);
			
			try {

//			    Workbook workbook = WorkbookFactory.create(ip);
//			    sheet = workbook.getSheet(name);
//			    //sheet=workbook.getSheetAt(0);
			}
			catch (Exception e) {
			}
			data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
					data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
				}
			}

		



		

	

		
		return data;
}
}

		
		
	

