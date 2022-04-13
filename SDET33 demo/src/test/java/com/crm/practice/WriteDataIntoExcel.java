package com.crm.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcel {

	public static void main(String[] args) throws Exception, Exception {
		// to enter data into cell,example for status
		
		//convert physical file to java readable file
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData.xlsx");
		
		//Open the excel using
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("SDET");
		Row row = sh.getRow(1);
		Cell cell = row.createCell(1);//create cell to pass value
		cell.setCellValue("Pass");//RT is void
		
		FileOutputStream fos=new FileOutputStream("./src/test/resources/TestData.xlsx");
		wb.write(fos);//to save the file
		wb.close();
		System.out.println("Data is stored in excel");
		
		

	}

}