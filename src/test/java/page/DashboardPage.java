package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

	
	
	@FindBy(xpath="//h6[text()='Dashboard']")
	private WebElement dashbrd;
	
	public DashboardPage(WebDriver driver)
	{
	
		PageFactory.initElements(driver, this);
	}
	
	//We should wait and check
	public boolean VerifyDashboardisDisplayed(WebDriverWait wait)
	
	{
		try {
			
			wait.until(ExpectedConditions.visibilityOf(dashbrd) );
			System.out.println("Dashboard is displayed");
			return true;
		} 
		catch (Exception e) 
		{
      
			System.out.println("Dashboard is not displayed");
			return false;

		}
		
			
	}
	
	
}
