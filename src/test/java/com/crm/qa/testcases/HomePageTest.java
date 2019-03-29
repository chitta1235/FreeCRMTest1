package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	TasksPage tasksPage;
	
	
	
	public  HomePageTest(){
		super();
		
	}
	@BeforeMethod
	public void setUp(){
		intialization();
		testUtil=new TestUtil();
		 loginPage=new LoginPage();
		 contactsPage=new ContactsPage();
		 dealsPage=new DealsPage();
		  tasksPage=new TasksPage();
		 homePage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		 

}
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
	String homePageTitle=homePage.verifyHomePageTitle();
	Assert.assertEquals(homePageTitle, "CRMPRO");
}
	@Test(priority=2)
	public void verifyCorrectUserNameTest(){
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName());
		
	
}
	@Test(priority=3)
	public void clickOnContactsLinkTest(){
		testUtil.switchToFrame();
		contactsPage=homePage.clickOnContactsLink();
	}
	@Test(priority=4)
	public void clickOnDealsLinkTest(){
		testUtil.switchToFrame();
		dealsPage=homePage.clickOnDealsLink();
		
	}
	@Test(priority=5)
	public void clickOnTasksLinkTest(){
		testUtil.switchToFrame();
		tasksPage=homePage.clickOnTasksLink();
		
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
