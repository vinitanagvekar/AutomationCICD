package Testing.stepDefinator;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import TestComponent.BaseClass;
import TestingPractice.pageobject.CheckoutPage;
import TestingPractice.pageobject.LandinPage;
import TestingPractice.pageobject.ProductCatalogue;
import TestingPractice.pageobject.cartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class stepDefinatorImple extends BaseClass{
	
	public LandinPage landing;
	public ProductCatalogue pc;
	@Given("I landed on Ecommerce page")
	public void I_landed_on_Ecommerce_page() throws IOException
	{
		landing = launchApp();
	}
	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void Logged_in_with_username_and_password(String name, String password)
	{
		pc = landing.loginApp(name,password);
	}
	
	@When("^I add product (.+) in the cart$")
	public void I_add_product_in_the_cart(String prodname)
	{
		List<WebElement> products = pc.getProductList();
		pc.addProductToCart(prodname);
	}
	
    @And("Checkout (.+) and submit the order")
    public void Checkout_and_submit_the_order(String prodname)
    {
    	cartPage cp = new cartPage(driver);
		Boolean match = cp.verifyProducts(prodname);
		Assert.assertTrue(match);
		cp.goToCheckout();
		CheckoutPage checkout = new CheckoutPage(driver);
		checkout.countryLocation("India");
		driver.findElement(By.cssSelector("li:nth-child(5) button:nth-child(1)")).click();
    }
    
    @Then("{string} message is displayed on confirmation page")
    public void message_is_displayed_on_confirmation_page(String string)
    {
    	WebElement Message = driver.findElement(By.xpath("//h1[@class=\"hero-primary\"]"));
    	String confirmMessage = Message.getText();
    	Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
    	driver.close();
    }



}
