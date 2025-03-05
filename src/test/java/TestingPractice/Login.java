package TestingPractice;

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

import junit.framework.Assert;

public class Login {
	static ChromeDriver driver = new ChromeDriver();

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:/Users/Vinita/Downloads/chromedriver_win32 (1)/chromedriver.exe");
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		driver.findElement(By.id("userEmail")).sendKeys("vinitest@test.com");
		driver.findElement(By.id("userPassword")).sendKeys("Test@123");
		driver.findElement(By.id("login")).click();
		Thread.sleep(1000);
		List<WebElement> prod = driver.findElements(By.cssSelector(".mb-3"));

		WebElement item1 = prod.stream()
				.filter(prods -> prods.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst()
				.orElse(null);

		item1.findElement(By.cssSelector(".card-body button:last-of-type")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));

		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		Thread.sleep(1000);

		List<WebElement> prodlist = driver.findElements(By.cssSelector(".cartSection h3"));

		Boolean match = prodlist.stream().anyMatch(list -> list.getText().equalsIgnoreCase("ZARA COAT 3"));
		Assert.assertTrue(match);

		driver.findElement(By.cssSelector(".totalRow button")).click();

		Actions act = new Actions(driver);
		act.sendKeys(driver.findElement(By.cssSelector("[placeholder*='Country']")), "India").build().perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.cssSelector(".ta-results button:last-of-type")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();

	}
}
