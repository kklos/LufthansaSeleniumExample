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
			//bookFlightPage.enterFromPLace("Warszawa");
			Thread.sleep(4000);
			bookFlightPage.enterToPlace("Paderborn");
			Thread.sleep(3000);
			bookFlightPage.checkInOneDestinationCheckbox();
			Thread.sleep(3000);
			bookFlightPage.enterDate();
			Thread.sleep(3000);
			
			//resultBookFlightPage = bookFlightPage.clickonGetResultFlights();
			
			//Thread.sleep(8000);
			
			//resultBookFlightPage.selectValueToDropdownPassengers("2");
			
			//Thread.sleep(5000);
			//resultBookFlightPage.selectValueToDropdownInfant("3");
			
			//Thread.sleep(5000);
			//resultBookFlightPage.selectValueToDropdownChildren("4");
			
			//Thread.sleep(90000);
			//createAccountPage = signInPage.clickonCreateAnAccount();
			//Assert.assertTrue(createAccountPage.verifyPageTitle(), "Page title not matching");
			//Assert.assertTrue(createAccountPage.verifyCreateAccountPageText(), "Page text not matching");
			//Assert.assertTrue(createAccountPage.verifySignUp(), "Unable to sign up");
		}
}