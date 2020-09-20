package testcases;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;
import steps.HomePageSteps;

@Concurrent(threads = "4")
@UseTestDataFrom(".//src//test//resources//testdata//data.csv")
@RunWith(SerenityParameterizedRunner.class)
public class DataDrivenWithCSV 
{
	 private String userName;
     private String password;
     
	   public void setUserName(String userName) 
	   {
		 this.userName = userName;
	   }

	   public void setPassword(String password) 
	  {
		 this.password = password;
	  }
	   

	   @Managed
	   WebDriver driver;
	   
	   @Steps
	   HomePageSteps homePageSteps;
	   
	   @Title("Executing login test")
	   @Test
	   public void loginTest()
	   {
		   homePageSteps.doLogin(userName);
		   System.out.println(userName);
		   homePageSteps.doEnterPwd(password);
		   System.out.println(password);
		   System.out.println("-----Next Iteration--------");
	   }
}
