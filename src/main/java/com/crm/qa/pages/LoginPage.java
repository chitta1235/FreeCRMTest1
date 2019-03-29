package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//we have created page factory
	
	@FindBy(name="username")
	WebElement username;
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@class='btn btn-small']")
	WebElement loginBtn;
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement SignUpBtn;
	@FindBy(xpath="//img[@src='https://d3lh3kd7bj2evy.cloudfront.net/img/logo.png']")
	WebElement CrmProImage;
	//create constructor
	public LoginPage(){
		PageFactory.initElements(driver, this);// this- means current class object
		//intialization elements
	}
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	public boolean validateCrmProImage(){
		return CrmProImage.isDisplayed();
	}
	public HomePage login(String un,String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",loginBtn );
		return new HomePage();
	}
	
	
	
	
	
	
	

}
