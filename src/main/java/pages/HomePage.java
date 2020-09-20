package pages;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;

public class HomePage extends PageObject
{
  public void navigate()
  {
	  open();
	  //getDriver().manage().deleteAllCookies();
  }
  
  public void enterUN(String username)
  {
	  $("//input[@id='identifierId']").sendKeys(username);
  }
  
  public void clickNext()
  {
	  $("//*[@id=\"identifierNext\"]/div/button").click();
	  Serenity.takeScreenshot();
  }
  
  public void enterPWD(String password)
  {
	  $("//*[@id=\"password\"]/div[1]/div/div[1]/input").sendKeys(password);
	  
  }
  
  
}
