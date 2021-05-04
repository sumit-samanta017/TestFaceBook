package com.qa.testscript;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.testbase.TestBase;
import com.qa.utility.ExcelUtility;

public class TC_FaceBook_002 extends TestBase{
	
	@Test(dataProvider = "supply")
	public void checkLogin(String email, String pwd) throws InterruptedException {
		
		Thread.sleep(4000);
		fb.getUserNameOrPhnTextField().clear();
		Thread.sleep(2000);
		fb.getUserNameOrPhnTextField().sendKeys(email);
		fb.getPassWordField().clear();
		Thread.sleep(2000);
		fb.getPassWordField().sendKeys(pwd);
		Thread.sleep(4000);
		
		fb.getLoginButton().submit();
		Thread.sleep(3000);
	}
	
	@DataProvider(name="supply")
	public String[][] supplyDatas() throws IOException{
		
		String xPathName = "C:\\Users\\Sumit Samanta\\workspace\\SeleniumVirtusa\\SeleniumAutomation\\src\\test\\java\\com\\qa\\testdata\\Book1.xlsx";
		String xSheetName = "Sheet3";

		int rowCount = ExcelUtility.getRowCount(xPathName, xSheetName);

		int cellCount = ExcelUtility.getCellCount(xPathName, xSheetName, rowCount);

		String[][] data = new String[rowCount][cellCount];

		for(int i=1; i<=rowCount; i++) {
			for(int j=0; j<cellCount; j++) {
				data[i-1][j] = ExcelUtility.getCellValue(xPathName, xSheetName, i, j);
			}
		}
		
		return data;
		
	}

}
