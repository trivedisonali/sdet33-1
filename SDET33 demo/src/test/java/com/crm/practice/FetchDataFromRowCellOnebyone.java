package com.crm.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.mysql.cj.result.Row;

public class FetchDataFromRowCellOnebyone {

	public static void main(String[] args) throws Throwable, IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData1");
		Workbook wk = WorkbookFactory.create(fis);
		Sheet sh = wk.getSheet("Login");
		for(int i=1;i<=sh.getLastRowNum();i++) {
			
		  Row row = sh.getRow(i);
		}
		
		

	}

}
