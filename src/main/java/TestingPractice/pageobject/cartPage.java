package TestingPractice.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestingPractice.absractmethod.AbstractClasses;

public class cartPage extends AbstractClasses {
	public cartPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	WebDriver driver;
	
	@FindBy (css = ".cartSection h3")
	List<WebElement> prodlist;
	
	@FindBy (css = ".totalRow button")
	WebElement checkout;
	
	
	public Boolean verifyProducts(String prodName) {
		Boolean match = prodlist.stream().anyMatch(list -> list.getText().equalsIgnoreCase(prodName));
		return match;
	}
	
	public CheckoutPage goToCheckout() {
		checkout.click();
		return new CheckoutPage(driver);
	}
	
	
}
