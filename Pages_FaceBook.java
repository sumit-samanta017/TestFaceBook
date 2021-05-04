package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pages_FaceBook {
	
	WebDriver driver;
	
	public Pages_FaceBook(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//*[@id=\"email\"]")
	WebElement userNameOrPhnTextField;
	
	@FindBy(xpath="//*[@id=\"pass\"]")
	WebElement passWordField;
	
	@FindBy(xpath="//button[@name='login']")
	WebElement loginButton;
	
	@FindBy(xpath = "(//span[@class='a8c37x1j ni8dbmo4 stjgntxs l9j0dhe7 ltmttdrg g0qnabr5'])[1]")
	WebElement checkProfileHome;
	
	@FindBy(xpath = "/html/body/div[1]/div/div[1]/div/div[2]/div[4]/div[1]/span/div/div[1]/i")
	WebElement dropDown;
	
	@FindBy(xpath = "(//span[@class='d2edcug0 hpfvmrgz qv66sw1b c1et5uql lr9zc1uh a8c37x1j keod5gw0 nxhoafnm aigsh9s9 d3f4x2em fe6kdd0r mau55g9w c8b282yb iv3no6db jq4qci2q a3bd9o3v ekzkrbhg oo9gr5id hzawbc8m'])[5]")
	WebElement logOut;
	
	@FindBy(linkText = "Forgotten password?")
	WebElement forgotPassword;

	public WebElement getForgotPassword() {
		return forgotPassword;
	}

	public WebElement getLogOut() {
		return logOut;
	}

	public WebElement getDropDown() {
		return dropDown;
	}

	public WebElement getCheckProfileHome() {
		return checkProfileHome;
	}

	public WebElement getUserNameOrPhnTextField() {
		return userNameOrPhnTextField;
	}

	public WebElement getPassWordField() {
		return passWordField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
}
