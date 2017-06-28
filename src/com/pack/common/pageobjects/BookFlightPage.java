package com.pack.common.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookFlightPage {
	protected WebDriver driver;
   
    private By startPlaceTextBox = By.xpath("//input[@id='flightmanagerFlightsFormOrigin']");
    private By targetTextBox = By.xpath("//input[@id='flightmanagerFlightsFormDestination']");
    private By searchFlightBtn = By.xpath("//button[@type='submit' and contains(., 'Zaloguj')]");
    private By inOneDestinationCheckbox = By.xpath("//input[@type='checkbox' and @id='lhfaToggleRoundtrip']");
    private By exitDateTextBox = By.id("flightmanagerFlightsFormOutboundDateDisplay");
    
	public BookFlightPage(WebDriver driver) {
		this.driver=driver;
	}
		public ResultBookFlightPage clickonGetResultFlights() {
			System.out.format("Get result btn was clicked");
			WebElement element=driver.findElement(searchFlightBtn);
			if(element.isDisplayed()||element.isEnabled())
				element.click();
			return new ResultBookFlightPage(driver);
	   }
		public void enterFromPLace(String fromPlace) {
			System.out.format("Place to start: %s was entered \n", fromPlace);
			WebElement fromTxtBox = driver.findElement(startPlaceTextBox);
			if(fromTxtBox.isDisplayed())
				fromTxtBox.sendKeys(fromPlace);
		}
		
		public void enterToPlace(String toPlace) {
			System.out.format("Place destination: %s was entered \n", toPlace);
			WebElement toTxtBox = driver.findElement(targetTextBox);
			if(toTxtBox.isDisplayed())
				toTxtBox.sendKeys(toPlace);
		}
		
		public void enterDate(String date) {
			System.out.format("Date to start: %s was entered \n", date);
			WebElement exitDateTxtBox = driver.findElement(exitDateTextBox);
			if(exitDateTxtBox.isDisplayed())
				exitDateTxtBox.sendKeys(date);
		}
		
		public void checkInOneDestinationCheckbox(){
			System.out.println("Checkbox in one direction was checked");	
	    WebElement checkInOnDestCHxBox = driver.findElement(inOneDestinationCheckbox);
		if ( checkInOnDestCHxBox.isSelected())
			{
				checkInOnDestCHxBox.click();
			}
		}
		
		// see other
		//public String getErrorMessage() {
		//	String strErrorMsg = null;
		//	WebElement errorMsg = driver.findElement(errorMsgTxt);
		//	if(errorMsg.isDisplayed()&&errorMsg.isEnabled())
		//		strErrorMsg = errorMsg.getText();
		//	return strErrorMsg;
		// }
}
