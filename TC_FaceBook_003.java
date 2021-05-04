package com.qa.testscript;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.testbase.TestBase;

public class TC_FaceBook_003 extends TestBase{
	
	@Test
	@Parameters({"email"})
	public void forgetPassword(String identifyEmail) {
		
		fb.getForgotPassword().click();
		
		boolean checkForgotPasswordPage = cDriver.getCurrentUrl().contains("login&privacy_mutation_token");
		
		Assert.assertEquals(checkForgotPasswordPage, true);
		
		Reporter.log("The user has moved to forget password page",true);
		
	}

}
