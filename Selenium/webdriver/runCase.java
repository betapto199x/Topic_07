package webdriver;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.DashboardPageObject;
import pageObjects.LoginPageObject;

public class runCase{

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	LoginPageObject loginPage;

	@BeforeMethod
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserdriver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://phptravels.net/api/admin");
	}
	
	@Test(priority = 1)
	public void loginSucessful() {
		LoginPageObject loginPage = new LoginPageObject(driver);
		loginPage.inputToEmailTextbox("admin@phptravels.com");
		loginPage.inputToPasswordTextbox("demoadmin");
		loginPage.clickToLoginButton();
		DashboardPageObject dashboardPage = new DashboardPageObject(driver);
		Assert.assertTrue(dashboardPage.isDashboardPageTitleDisplayed());
	}
	
	@Test(priority=2)
	public void loginPageTest() {
		LoginPageObject loginPage = new LoginPageObject(driver);
		String emailPlaceHolder = loginPage.getEmailPlaceholder();
		System.out.println("Emamil placeholder is: " + emailPlaceHolder);
		String passwordPlaceHolder = loginPage.getPasswordPlaceholder();
		System.out.println("Password placeholder is: " + passwordPlaceHolder);
		loginPage.clickRememberMe();
		boolean rememberMeIsSelect = loginPage.checkRememberMe();
		assertTrue(rememberMeIsSelect, "Remember Me is selected");
		
	}
	
	@AfterMethod
	public void afterClass() {
	driver.quit();
    }
	


}
