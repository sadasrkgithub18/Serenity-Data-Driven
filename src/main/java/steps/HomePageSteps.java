package steps;

import net.thucydides.core.annotations.Step;
import pages.HomePage;

public class HomePageSteps 
{
	HomePage homePage;
	
	@Step("Performing Login")
	public void doLogin(String username)
	{
		homePage.navigate();
		homePage.enterUN(username);
		
	}
	
	@Step("Entering password")
	public void doEnterPwd(String password)
	{
		homePage.clickNext();
		homePage.enterPWD(password);
	}
	
	
}
