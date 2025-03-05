package TestingPractice;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import TestComponent.BaseClass;
import TestingPractice.pageobject.CheckoutPage;
import TestingPractice.pageobject.LandinPage;
import TestingPractice.pageobject.ProductCatalogue;
import TestingPractice.pageobject.cartPage;
import junit.framework.Assert;

public class ErrorValidations extends BaseClass{
	static ChromeDriver driver = new ChromeDriver();

	@Test
	public void submitOrder() throws InterruptedException, IOException {


		landing.loginApp("vinitest@test.com", "Test@123");
		
		Assert.assertEquals("Incorrect email or password.", landing.getErrorMessage());
	}
	
	@Test
	public void submitOrder1() throws InterruptedException, IOException {


		landing.loginApp("vinitest@test.com1", "Test@123");
		
		Assert.assertEquals("Incorrect email or password.", landing.getErrorMessage());
	}
}
