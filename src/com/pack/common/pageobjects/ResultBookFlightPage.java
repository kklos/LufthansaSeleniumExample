package com.pack.common.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.pack.tools.Tools;

public class ResultBookFlightPage {
private WebDriver driver;
	
	private By headerPageTxt = By.cssSelector(".lato-light");
	private By emailTextBox = By.id("email");
	private By emailConfirmationTextBox = By.id("emailConfirmation");
	private By passwordTextBox = By.id("password");
	private By passwordConfirmationTextBox = By.id("passwordConfirmation");
	
	private By SingUpBtn = By.xpath("//button[@type='submit' and contains(., 'Zarejestruj')]");
	private By errorMsgTxt = By.cssSelector(".error");
	private By positiveMsgTxt = By.cssSelector(".alert_ok");
	private By acceptTermsOfUse = By.id("termsOfUse");
	private By acceptProcessingOfPersonalData = By.id("agreementPrivacy");
	
	 private By dropDownPassengers = By.id("ADVANCED_SEARCH_FLIGHTS_NUMBER_OF_ADULTS_0");
	 private By dropDownChildren = By.id("ADVANCED_SEARCH_FLIGHTS_NUMBER_OF_CHILDREN_0");
	 private By dropDownInfants = By.id("ADVANCED_SEARCH_FLIGHTS_NUMBER_OF_INFANTS_0");
	
	private List<String> errorItems = new ArrayList<String>();
	private boolean flaga = true;
	
	public ResultBookFlightPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getPageTitle() {
		String title = driver.getTitle();
		System.out.print("Page title for create account " + title );
		return title;
	}
	
	public boolean verifyPageTitle() {
		String pageTitle = "Dieta odchudzająca, diety, odchudzanie, fitness – Vitalia.pl";
		return getPageTitle().contains(pageTitle);
	}
	public boolean verifyCreateAccountPageText() {
		WebElement element = driver.findElement(headerPageTxt);
		String pageText ="Zarejestruj";
		return element.getText().contains(pageText);
	}
	
	public boolean verifySignUp() {
		errorItems.add("Musisz");
		errorItems.add("Te adresy email nie są takie same");
		errorItems.add("Twoje hasło jest za");
		errorItems.add("Te hasła nie są");
		enterEmail("test@mail.com");
		enterEmailConform("test@mail.com");
		enterPassword("Qwerty123");
		enterPasswordConform("Qwerty123");
		clickCheckbox(acceptTermsOfUse);
		clickCheckbox(acceptProcessingOfPersonalData);
		clickOnSignUp();
		
		flaga = true;
		if(!getPositiveMessage().contains("Aby aktywować konto, odbierz e-maila") 
				|| Tools.stringContainsItemFromList(getErrorMessage(), errorItems) )
		{
			flaga = false;
		}
		return flaga;
	}
	

	public void enterEmail(String userName) {
		WebElement emailTxtBox = driver.findElement(emailTextBox);
		if(emailTxtBox.isDisplayed())
			emailTxtBox.sendKeys(userName);
	}
	
	public void enterEmailConform(String userName) {
		WebElement emailTxtBox = driver.findElement(emailConfirmationTextBox);
		if(emailTxtBox.isDisplayed())
			emailTxtBox.sendKeys(userName);
	}
	
	public void enterPassword(String password) {
		WebElement passwordTxtBox = driver.findElement(passwordTextBox);
		if(passwordTxtBox.isDisplayed())
			passwordTxtBox.sendKeys(password);
	}
	
	public void enterPasswordConform(String password) {
		WebElement passwordTxtBox = driver.findElement(passwordConfirmationTextBox);
		if(passwordTxtBox.isDisplayed())
			passwordTxtBox.sendKeys(password);
	}
	
	
	public void selectValueToDropdownPassengers(String valuePassenger) {
		Select oSelect = new Select(driver.findElement(dropDownPassengers));
		 
		oSelect.selectByValue(valuePassenger);
	}
	
	public void selectValueToDropdownChildren(String valueChildren) {
		Select oSelect = new Select(driver.findElement(dropDownChildren));
		 
		oSelect.selectByValue(valueChildren);
	}
	
	public void selectValueToDropdownInfant(String valueInfant) {
		Select oSelect = new Select(driver.findElement(dropDownInfants));
		 
		oSelect.selectByValue(valueInfant);
	}
	
	
	
	public void clickOnSignUp() {
		WebElement signInBtn = driver.findElement(SingUpBtn);
		if(signInBtn.isDisplayed())
			signInBtn.click();
	}
	
	public void clickCheckbox(By idOfTheElement)
	{
		if ( !driver.findElement(idOfTheElement).isSelected() )
		{
		     driver.findElement(idOfTheElement).click();
		}
	}
	
	public String getErrorMessage() {
		String strErrorMsg = null;
		WebElement errorMsg = driver.findElement(errorMsgTxt);
		if(errorMsg.isDisplayed()&&errorMsg.isEnabled())
			strErrorMsg = errorMsg.getText();
		return strErrorMsg;
	}
	
	public String getPositiveMessage() {
		String strErrorMsg = null;
		WebElement errorMsg = driver.findElement(positiveMsgTxt);
		if(errorMsg.isDisplayed()&&errorMsg.isEnabled())
			strErrorMsg = errorMsg.getText();
		return strErrorMsg;
	}
}
