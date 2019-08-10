package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class YatraHomePage {

	WebDriver driver;
	
	By FlightTab = By.id("booking_engine_flights");
	By OrginCity =  By.id("BE_flight_origin_city");
	By ArrivalCity =  By.id("BE_flight_arrival_city");
	By OrginDate = By.xpath("//input[@id='BE_flight_origin_date']");
	By FirstSunday = By.xpath("//td[contains(@title,'Sunday,')]");
	By NonStopFlightCheckBox =By.xpath("//input[@id='BE_flight_non_stop']/ancestor::a");
	By PassagerTab = By.id("BE_flight_paxInfoBox");
	By AdultCount = By.xpath("//*[@id='BE_flight_passengerBox']/div[1]/div[1]/div/div/span[2]");
	By BusinessClass = By.xpath("//div[@id='flight_class_select_child']/ul/li[3]/span");
	By SearchButton = By.xpath("//input[@id='BE_flight_flsearch_btn']");
	
	public YatraHomePage(WebDriver driver) {
		this.driver	= driver;
	}


	public void clickFlightTab() {
		driver.findElement(FlightTab).click();
	}

	public void setOrginCity(String orginCity) {
		WebElement OrginCity1 =  driver.findElement(OrginCity);
		OrginCity1.click();
		OrginCity1.clear();
        ((JavascriptExecutor) driver).executeScript("arguments[0].value='" + orginCity + "';", "BE_flight_origin_city");
        driver.findElement(By.xpath("//span[text()='(MAA)']")).click();
	}

	public void setArrivalCity(String arrivalCity) {
		WebElement ArrivalCity1 =  driver.findElement(ArrivalCity);
        ArrivalCity1.click();
        ArrivalCity1.clear();
        ((JavascriptExecutor) driver).executeScript("arguments[0].value='" + arrivalCity + "';", "BE_flight_arrival_city");
        driver.findElement(By.xpath("//span[text()='(DEL)']")).click();
        
	}

	public void ClickOrginDate() {
		driver.findElement(OrginDate).click();
	}

	public void selectFirstSunday() {
		driver.findElement(FirstSunday).click();
	}

	public void selectNonStopFlightCheckBox() {
		driver.findElement(NonStopFlightCheckBox).click();
	}

	public void clickPassagerTab() {
		driver.findElement(PassagerTab).click();
	}

	public void selectAdultCount() {
		driver.findElement(AdultCount).click();
	}

	public void selectBusinessClass() throws InterruptedException {
		WebElement element = driver.findElement(BusinessClass);
        Actions actions = new Actions(driver);
        Thread.sleep(200);
        actions.moveToElement(element).click().build().perform();
	}

	public void clickSearchButton() {
		driver.findElement(SearchButton).click();
	}
	
	public void SearchFlight(String orginCity, String arrivalCity) throws InterruptedException {
		this.clickFlightTab();
		this.setOrginCity( orginCity);
		this.setArrivalCity(arrivalCity);
		this.ClickOrginDate();
		this.selectFirstSunday();
		this.selectNonStopFlightCheckBox();
		this.clickPassagerTab();
		this.selectAdultCount();
		this.selectBusinessClass();
		this.clickSearchButton();
		
	}
    
}
