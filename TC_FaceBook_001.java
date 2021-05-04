package com.qa.testscript;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.testbase.TestBase;
import com.qa.utility.ExcelUtility;

public class TC_FaceBook_001 extends TestBase {

	
	@Test(dataProvider = "provideDatas")
	public void checkWholeFuntionality1(String email, String pswd) throws InterruptedException {
		
		fb.getUserNameOrPhnTextField().clear();
		Thread.sleep(2000);
		fb.getUserNameOrPhnTextField().sendKeys(email);
		fb.getPassWordField().clear();
		Thread.sleep(2000);
		fb.getPassWordField().sendKeys(pswd);
		Thread.sleep(2000);
		
		fb.getLoginButton().submit();
		Thread.sleep(2000);
		
		boolean checkHomePageTitle = cDriver.getCurrentUrl().contains("facebook");
		
		Assert.assertEquals(checkHomePageTitle, true);
		
		fb.getCheckProfileHome().click();
		
		Thread.sleep(7000);
		
		boolean checkUserPageTitle = cDriver.getCurrentUrl().contains("sumit");
		
		Assert.assertEquals(checkUserPageTitle, true);
		
		fb.getDropDown().click();
		
		Thread.sleep(5000);
		
		fb.getLogOut().click();
		
	}
	
	@DataProvider
	public String[][] provideDatas() throws IOException{

		String xPathName = "C:\\Users\\Sumit Samanta\\workspace\\SeleniumVirtusa\\SeleniumAutomation\\src\\test\\java\\com\\qa\\testdata\\Book1.xlsx";
		String xSheetName = "Sheet2";

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
