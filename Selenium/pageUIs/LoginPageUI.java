package pageUIs;

import org.openqa.selenium.By;

public class LoginPageUI {
	public static final By EMAIL_TEXTBOX = By.xpath("//input [@name='email']");
	public static final By PASSWORD_TEXTBOX = By.xpath("//input [@name='password']");
	public static final By LOGIN_BUTTON = By.xpath("//button [contains(@class,'btn-primary btn-block')]");
	public static final By REMEMBERME_CHECKBOX = By.xpath("//div[contains(@class,'icheckbox_square-grey')]");
}
