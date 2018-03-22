package com.test.utility;

import java.util.ArrayList;

import com.excel.utility.Xls_Reader1;

public class TestUtil {
	
	
	static Xls_Reader1 reader;
	
	public static ArrayList<Object[]> getDataFromExcel(){
		
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		
		reader = new Xls_Reader1("C:\\Users\\sai\\Desktop\\workspace\\SeleniumSessions\\src\\com\\testdata\\HalfEbayTestData.xlsx");
		
		
		for(int rowCnt=2; rowCnt<=reader.getRowCount("RegTestData"); rowCnt++){
			
			
			String firstname = reader.getCellData("RegTestData", "firstname", rowCnt);
			String lastname = reader.getCellData("RegTestData", "lastname", rowCnt);
			String emailaddress = reader.getCellData("RegTestData", "emailaddress", rowCnt);
			String password = reader.getCellData("RegTestData", "password", rowCnt);
			
			Object ob[] = {firstname, lastname, emailaddress, password};
			myData.add(ob);
			
		}
		return myData;
		
		
		
	}

}
