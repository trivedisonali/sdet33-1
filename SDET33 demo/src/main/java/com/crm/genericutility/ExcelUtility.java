package com.crm.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This class contains excel specific methods
 * @param args
 */


public class ExcelUtility {
	static Workbook wb;
	/**
	 * This method is used to fetch single data from the cell
	 * @param sheetname
	 * @param rowNumber
	 * @param cellNumber
	 * @return
	 */
	

	public static String fetchData(String sheetname,int rowNumber,int cellNumber) {
		
		   Sheet sh=wb.getSheet(sheetname);
		   String data = sh.getRow(rowNumber).getCell(cellNumber).getStringCellValue();
		   return data;
	}

	
	/**
	 * This method is used to write Data In New Row 
	 * @param path 
	 * @param sheetname
	 * @param rowNumber
	 * @param cellNumber
	 * @param data
	 * @throws Exception
	 */
	public static void writeDataInNewRow(String path,String sheetname,int rowNumber,int cellNumber,String data) throws Exception {
		Sheet sh = wb.getSheet(sheetname);
		sh.getRow(rowNumber).getCell(cellNumber).setCellValue(data);
		FileOutputStream fosexcel=new FileOutputStream(path);
		wb.write(fosexcel);
		
	}
	
	/**
	 * To write Data In Existing Row 
	 * @param path
	 * @param sheetname
	 * @param rowNumber
	 * @param cellNumber
	 * @param data
	 * @throws Exception
	 */
	
	public static void writeDataInExistingRow(String path,String sheetname,int rowNumber,int cellNumber,String data) throws Exception {
		Sheet sh = wb.getSheet(sheetname);
		sh.getRow(rowNumber).createCell(cellNumber).setCellValue(data);
		FileOutputStream fosexcel=new FileOutputStream(path);
		wb.write(fosexcel);
		System.out.println("Data is written successfully");
	}
	/**
	 * To open Excel
	 * @param path
	 * @throws Throwable
	 */
	
	public static void openExcel(String path) throws Throwable {
		FileInputStream fisexcel=new FileInputStream(path);
		 wb = WorkbookFactory.create(fisexcel);
		System.out.println("Opened the excel successfully");
	}
	
	/**
	 * To close Excel
	 * @param path
	 * @throws IOException
	 */
	
	public static void closeExcel() throws IOException {
		wb.close();
		System.out.println("Closed the file successfully");
	}
	
	
	public static Object[][] fetchMultipleData(String sheetname) {
		 Sheet sh = wb.getSheet(sheetname);
		 Object[][] arr=new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
		 
		 for(int i=0;i<sh.getLastRowNum();i++) {
			 
			 for(int j=0;j<sh.getRow(0).getLastCellNum();j++) {
				 
				 arr[i][j]=sh.getRow(i+1).getCell(j).toString();//getstringcellvalue instead of tostring
			 }
		 }
		
		 return arr;
	}
	
	

	
	
}
