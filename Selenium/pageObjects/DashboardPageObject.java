package pageObjects;

import org.openqa.selenium.WebDriver;

import pageUIs.DashboardPageUI;
import webdriver.common;

public class DashboardPageObject extends common{
	
	public DashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isDashboardPageTitleDisplayed() {
		waitForElementVisible(DashboardPageUI.DASHBOARD_PAGE_TITLE);
		return isElementDisplayed(DashboardPageUI.DASHBOARD_PAGE_TITLE);
	}

}
