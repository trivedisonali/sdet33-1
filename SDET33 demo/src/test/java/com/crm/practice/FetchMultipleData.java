package com.crm.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchMultipleData {

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub;
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData1.xlsx");
		Workbook wk = WorkbookFactory.create(fis);
		Sheet sh = wk.getSheet("Login");
		for(int i=1;i<=sh.getLastRowNum();i++) {  //starting from 1st index ie i=1 and less than eql sheet name
			String username = sh.getRow(1).getCell(0).getStringCellValue();
			String password = sh.getRow(1).getCell(1).getStringCellValue();
			System.out.println(username+"--------"+password);
		}

	}

}
