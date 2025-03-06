package TestingPractice;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestComponent.BaseClass;
import TestingPractice.pageobject.CheckoutPage;
import TestingPractice.pageobject.LandinPage;
import TestingPractice.pageobject.ProductCatalogue;
import TestingPractice.pageobject.cartPage;
import junit.framework.Assert;

public class FirstPage extends BaseClass{
	static ChromeDriver driver = new ChromeDriver();

	@Test (dataProvider = "getData", groups= {"Purchase"})
	public void submitOrder(HashMap<String,String> input) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:/Users/Vinita/Downloads/chromedriver_win32 (1)/chromedriver.exe");
		driver.get("https://rahulshettyacademy.com/client");
		LandinPage landing = new LandinPage(driver);
		landing.loginApp(input.get("email"),input.get("pass"));
//		Thread.sleep(1000);
		       //ProductCatalogue pc = new ProductCatalogue(driver);
		       //List<WebElement> products = pc.getProductList();
		        //pc.addProductToCart(input.get("prodName"));
//		pc.goToCartPage();
//		Thread.sleep(100);
//		cartPage cp = new cartPage(driver);
//		Boolean match = cp.verifyProducts(prodName);
//		Assert.assertTrue(match);
//		cp.goToCheckout();
//		CheckoutPage checkout = new CheckoutPage(driver);
//		checkout.countryLocation("India");
		       //driver.findElement(By.cssSelector("li:nth-child(5) button:nth-child(1)")).click();
		}
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//TestingPract//data//PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)},{data.get(2)}};
	}
	
	
//	@DataProvider
//	public Object[][] getData()
//	{
//		
//		HashMap<String,String> map = new HashMap<String,String>();
//		map.put("email","vinitest@test.com");
//		map.put("pass", "Test@123");
//		map.put("prodName", "ZARA COAT 3");
//		
//		HashMap<String,String> map1 = new HashMap<String,String>();
//		map1.put("email","vinitaest@test.com");
//		map1.put("pass", "Test@123");
//		map1.put("prodName", "ZARA COAT 3");
//		
//		HashMap<String,String> map2 = new HashMap<String,String>();
//		map2.put("email","vinit@test.com");
//		map2.put("pass", "Test@123");
//		map2.put("prodName", "ZARA COAT 3");
//		
//		return new Object[][] {{map},{map1},{map2}};
//	}
	
	
	
	
//	@DataProvider
//	public Object[][] getData()
//	{
//		Object[][] data = {{"vinitest@test.com", "Test@123","ZARA COAT 3"},{"vinitaest@test.com", "Test@123","ZARA COAT 3"},
//				{"vinit@test.com", "Test@123","ZARA COAT 3"}};
//		return data;
//	}
	
	
	
	
	
	
	//@Test(dependsOnMethods = {"submitOrder"})
//	@Test
//	public void OrderHistoryTab() throws InterruptedException
//	{
//		Thread.sleep(100);
//		//LandinPage landing = new LandinPage(driver);
//		ProductCatalogue pc = landing.loginApp("vinitest@test.com", "Test@123");
//		landing.MyOrders();
//		
//	}
}
