package com.pack.common.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
	protected WebDriver driver;
	private By bookButton = By.xpath("//button[@id='flightmanager-tab-1']");
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickImagesLink() {
		//It should have a logic to click on images link
		//And it should navigate to google images page
	}
	
	public String getPageTitle(){
		String title = driver.getTitle();
		System.out.println(title);
		return title;
	}
	
	public boolean verifyBasePageTitle() {
		String expectedPageTitle="Znajdź tanie loty teraz online";
		return getPageTitle().contains(expectedPageTitle);
	}
	
	public BookFlightPage clickBookFlightBtn() {
		System.out.println("Clicking on 'Rezerwacja rejsów' button");
		WebElement signInBtnElement=driver.findElement(bookButton);
		if(signInBtnElement.isDisplayed()||signInBtnElement.isEnabled())
			signInBtnElement.click();
		else System.out.println("Element not found");
		return new BookFlightPage(driver);
	}
}