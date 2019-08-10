package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YatraSearchResult {
	
	WebDriver driver;
	By BookNowButton = By.xpath("//p[@yatratrackable=\"Flights|Search|Book Type|Book Now\"]");
	

	public YatraSearchResult(WebDriver driver) {
		this.driver	= driver;
	}


	public void clickFlightTab() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(BookNowButton));

		WebElement element = driver.findElement(BookNowButton);
		Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
	}
	
	public void selectFlightForBooking() {
		this.clickFlightTab();
	}

}
