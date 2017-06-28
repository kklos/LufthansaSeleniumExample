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
	private BookFlightPage bookFlightPage;
	private BasePage basePage;
	private ResultBookFlightPage resultBookFlightPage;
		
		@BeforeClass
		public void setUp() {
			driver=getDriver();
		}
		
		@Test
		public void verifyCreateAnAccounPage() throws InterruptedException {
			System.out.println("Create An Account page test...");
			basePage = new BasePage(driver);
			bookFlightPage = basePage.clickBookFlightBtn();
			bookFlightPage.enterFromPLace("Warszawa");
			bookFlightPage.enterToPlace("Paderborn");
			bookFlightPage.checkInOneDestinationCheckbox();
			bookFlightPage.enterDate("Śr, 28.06.2017");
			
			resultBookFlightPage = bookFlightPage.clickonGetResultFlights();
			
			Thread.sleep(90000);
			//createAccountPage = signInPage.clickonCreateAnAccount();
			//Assert.assertTrue(createAccountPage.verifyPageTitle(), "Page title not matching");
			//Assert.assertTrue(createAccountPage.verifyCreateAccountPageText(), "Page text not matching");
			//Assert.assertTrue(createAccountPage.verifySignUp(), "Unable to sign up");
		}
}