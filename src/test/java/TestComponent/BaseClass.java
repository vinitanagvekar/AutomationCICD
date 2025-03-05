package TestComponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import TestingPractice.pageobject.LandinPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	public LandinPage landing;
	public WebDriver initializeDriver() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//TestingPractice//resources//GlobleData.properties");
		prop.load(fis);
		String BrowserName = System.getProperty("browser")!=null ? System.getProperty("browser"):prop.getProperty("browser");
		
		if(BrowserName.equalsIgnoreCase("Chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		else if(BrowserName.equalsIgnoreCase("Firefox"))
		{
			FirefoxDriver driver = new FirefoxDriver();
		}
		
		else if(BrowserName.equalsIgnoreCase("edge"))
		{
			//System.setProperties(prop);
			EdgeDriver driver = new EdgeDriver();
		}
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException
	{
		//convert json to string
		String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
		
		//convert string to hashmap using dependency Jackson databid
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){});
		return data;
		
	}
	
	//@BeforeMethod
	public LandinPage launchApp() throws IOException
	{
		driver = initializeDriver();
		landing = new LandinPage(driver);
		landing.goTo();
		return landing;
	}
	
//	@AfterMethod
	public void close()
	{
		driver.close();
	}
}
