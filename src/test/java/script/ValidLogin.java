package script;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import page.DashboardPage;
import page.LoginPage;

public class ValidLogin extends BaseTest {

	@Test(priority=1)
	public void testValidLogin()
	{
		LoginPage page = new LoginPage(driver);
		page.setUsername("Aadmin");
		page.setPassword("admin123");
		page.clickBtn();
		DashboardPage page1 = new DashboardPage(driver);
		boolean result = page1.VerifyDashboardisDisplayed(wait);
		Assert.assertEquals(result, true);
		
	}
}
