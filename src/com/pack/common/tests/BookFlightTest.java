package com.pack.common.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pack.base.TestBaseSetup;

import com.pack.common.pageobjects.BasePage;
import com.pack.common.pageobjects.BookFlightPage;
import com.pack.common.pageobjects.ResultBookFlightPage;

public class BookFlightTest extends TestBaseSetup {
	private WebDriver driver;
	private BookFlightPage signInPage;
	private BasePage basePage;
	private ResultBookFlightPage createAccountPage;
		
		@BeforeClass
		public void setUp() {
			driver=getDriver();
		}
		
		@Test
		public void verifyCreateAnAccounPage() {
			System.out.println("Create An Account page test...");
			basePage = new BasePage(driver);
			signInPage = basePage.clickBookFlightBtn();
			createAccountPage = signInPage.clickonCreateAnAccount();
			Assert.assertTrue(createAccountPage.verifyPageTitle(), "Page title not matching");
			Assert.assertTrue(createAccountPage.verifyCreateAccountPageText(), "Page text not matching");
			Assert.assertTrue(createAccountPage.verifySignUp(), "Unable to sign up");
		}
}