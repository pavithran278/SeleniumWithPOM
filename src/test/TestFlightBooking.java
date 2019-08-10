package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.YatraHomePage;
import pages.YatraSearchResult;

public class TestFlightBooking {

	WebDriver driver;
	YatraHomePage objYatraHome;
	YatraSearchResult objYatraSearch;
	
	@BeforeTest
	public void launchBrowser() {
//      declaration and instantiation of objects/variables and driver
		System.setProperty("webdriver.chrome.driver","driver\\chromedriver.exe");
    	driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	@AfterTest                           
    public void terminateBrowser(){
        driver.close();
    }
	
	@Test
	public void FlightBooking() throws InterruptedException {

		driver.get("https://www.yatra.com/");
		
		objYatraHome = new YatraHomePage(driver);
		objYatraHome.SearchFlight("MAA","DEL");
		
		objYatraSearch = new YatraSearchResult(driver);
		objYatraSearch.selectFlightForBooking();
		
	}
}
