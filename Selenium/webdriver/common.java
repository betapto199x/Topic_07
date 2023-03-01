package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class common {
	public WebDriver driver;
	protected void inputElement(By location, String value){ 
	WebElement element = driver.findElement(location); 
	element.clear();
	element.sendKeys(value); 
	} 
	
	protected void clickElement(By location){ 
	WebElement element = driver.findElement(location); 
	element.click(); 
	} 
	
	protected void waitForElementVisible(By location){ 
	WebDriverWait wait = new WebDriverWait(driver, 10); wait.until(ExpectedConditions.visibilityOfElementLocated(location)); 
	}
	
	protected boolean isElementDisplayed(By location){ 
	WebElement element = driver.findElement(location); 
	Boolean value = element.isDisplayed();
	return value; 
	} 
	
	protected String getTitlePage() {
		String pageTitle = driver.getTitle();
		return pageTitle;
	}
	
	protected String getPlaceholderValue(By location) {
		WebElement element = driver.findElement(location);
		return element.getAttribute("placeholder");
	}
	
	protected void clickCheckbox(By location) {
		WebElement element = driver.findElement(location);
		element.click();
	}
	protected String getSelectValue(By location) {
		WebElement element = driver.findElement(location);
		String value = element.getAttribute("Class");
		return value;
	}
	protected boolean isSelectValue(By location) {
		WebElement element = driver.findElement(location);
		boolean value1 = false;
		String value = element.getAttribute("class");
		if(value.contains("checked")) {
			value1 = true;
		}
		return value1;
	}
}
