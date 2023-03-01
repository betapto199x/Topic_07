package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import pageUIs.LoginPageUI;
import webdriver.common;

public class LoginPageObject extends common {

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPageObject inputToEmailTextbox(String value) {
		waitForElementVisible(LoginPageUI.EMAIL_TEXTBOX);
		Reporter.log("");
		inputElement(LoginPageUI.EMAIL_TEXTBOX, value);
		Reporter.log(value);
		return this;
	}

	public LoginPageObject inputToPasswordTextbox(String value) {
		waitForElementVisible(LoginPageUI.PASSWORD_TEXTBOX);
		inputElement(LoginPageUI.PASSWORD_TEXTBOX, value);
		return this;
	}

	public LoginPageObject clickToLoginButton() {
		clickElement(LoginPageUI.LOGIN_BUTTON);
		return this;
	}

	public String getEmailPlaceholder() {
		waitForElementVisible(LoginPageUI.EMAIL_TEXTBOX);
		String value = getPlaceholderValue(LoginPageUI.EMAIL_TEXTBOX);
		Reporter.log(value);
		return value;
	}

	public String getPasswordPlaceholder() {
		waitForElementVisible(LoginPageUI.PASSWORD_TEXTBOX);
		String value = getPlaceholderValue(LoginPageUI.PASSWORD_TEXTBOX);
		Reporter.log(value);
		return value;
	}

	public LoginPageObject clickRememberMe() {
		clickCheckbox(LoginPageUI.REMEMBERME_CHECKBOX);
		Reporter.log("");
		return this;
	}

	public boolean checkRememberMe() {
		boolean value = isSelectValue(LoginPageUI.REMEMBERME_CHECKBOX);
		Reporter.log(String.valueOf(value));
		return value;
	}

}
