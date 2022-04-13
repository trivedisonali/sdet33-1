package com.crm.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcelTest {

	public static void main(String[] args) throws Exception {
		
		//Step:1:We should convert the physical file into java readable object
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData.xlsx");
		
		//Step:2:Open the excel file using WorkbookFactory class and create(--)
		Workbook wb = WorkbookFactory.create(fis);
		
		//Step:3:We should get the control of particular sheet by using getSheet()
		Sheet sh = wb.getSheet("SDET33");
		
		//Step:4:We should get the control of particular row using getRow()
		Row row = sh.getRow(1);
		
		//Step:5:We should get the control of particular cell using getCell()
		Cell cell = row.getCell(0);
		
		//Step:6:Fetch the data by using "getStringCellValue()",toString()
		String data = cell.getStringCellValue();
		System.out.println(data);
		
		//Step:7:Close the workbook by using "close()", belongs to WorkBook Interface
		wb.close();
		
				
		

	}

}
