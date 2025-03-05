package TestingPractice.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestingPractice.absractmethod.AbstractClasses;

public class OrderCartPage extends AbstractClasses {
	public OrderCartPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	WebDriver driver;
	
	@FindBy (css = "tr td:nth-child(3)")
	List<WebElement> orderproduct;
	
	@FindBy (css = ".totalRow button")
	WebElement checkout;
	
	
	public Boolean verifyOrderDisplay(String prodName) {
		Boolean match = orderproduct.stream().anyMatch(list -> list.getText().equalsIgnoreCase(prodName));
		return match;
	}
	
	public CheckoutPage goToCheckout() {
		checkout.click();
		return new CheckoutPage(driver);
	}
	
	
}
