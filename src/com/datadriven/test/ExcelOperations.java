package com.datadriven.test;

import com.excel.utility.Xls_Reader1;

public class ExcelOperations {

	public static void main(String[] args) {
		
		
		Xls_Reader1 reader = new Xls_Reader1("C:\\Users\\sai\\Desktop\\workspace\\SeleniumSessions\\src\\com\\testdata\\HalfEbayTestData.xlsx");
		
		if(!reader.isSheetExist("HomePage")){
			reader.addSheet("HomePage");
		}
		
		int columnCount = reader.getColumnCount("RegTestData");
		System.out.println("Total columns are "+columnCount);
		
	}

}
