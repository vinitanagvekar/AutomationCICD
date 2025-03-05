package TestingPractice.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestingPractice.absractmethod.AbstractClasses;

public class LandinPage extends AbstractClasses {
	WebDriver driver;
	
	public LandinPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//page factory 	
	@FindBy(id = "userEmail")
	WebElement userEmail;
	
	@FindBy(id = "userPassword")
	WebElement userPassword;

	@FindBy(id = "login")
	WebElement submit;
	
	@FindBy(css = "[class*='flyInOut']")
	WebElement errorMessage;
	
	public ProductCatalogue loginApp(String email, String pass) {
		userEmail.sendKeys(email);
		userPassword.sendKeys(pass);
		submit.click();
		ProductCatalogue pc = new ProductCatalogue(driver);
		return pc;
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String getErrorMessage()
	{
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}

	
	
	
	
	
	
	
	
	
	
}
