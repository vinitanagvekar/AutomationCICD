package TestingPractice.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import TestingPractice.absractmethod.AbstractClasses;

public class CheckoutPage extends AbstractClasses{
	
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy (css = "[placeholder*='Country']")
	WebElement Country;
	
	@FindBy (css = ".ta-results button:last-of-type")
	WebElement Button;
	
	@FindBy (css = ".action__submit")
	WebElement Submit;
	
	By result = By.cssSelector(".ta-results");

	
	public void countryLocation(String country) {
		Actions act = new Actions(driver);
		act.sendKeys(Country, country).build().perform();
		waitForElementToAppear(result);
		Button.click();
		confirmationPage();
	}
	
	public void confirmationPage() {
		Submit.click();
	}

}
