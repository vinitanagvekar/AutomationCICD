package TestingPractice.pageobject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import TestingPractice.absractmethod.AbstractClasses;

public class ProductCatalogue extends AbstractClasses{
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".mb-3")
	List<WebElement> prod;
	
	By productsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toast = By.cssSelector("#toast-container");
	By animat = By.cssSelector(".ng-animating");
	
	public List<WebElement> getProductList(){
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return prod;
	}
	
	
	public WebElement getProductByName(String prodName) {
		WebElement item = prod.stream()
				.filter(prods -> prods.findElement(By.cssSelector("b")).getText().equals(prodName)).findFirst()
				.orElse(null);
		return item;
	}
	
	public void addProductToCart(String prodName) {
		WebElement item  = 	getProductByName(prodName);
		item.findElement(addToCart).click();
		waitForElementToAppear(toast);
		waitForElementToDissapear(animat);
	}
	

}
