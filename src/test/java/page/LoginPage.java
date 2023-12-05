package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	// Declaration
	@FindBy(name = "username")
	private WebElement uname;

	@FindBy(name = "password")
	private WebElement pwd;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement btn;

	// Initialization

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public void setUsername(String name) {
		uname.sendKeys(name);
	}

	public void setPassword(String password) {
		pwd.sendKeys(password);
	}

	public void clickBtn() {
		btn.click();
	}
	
	
	
	
	
}
