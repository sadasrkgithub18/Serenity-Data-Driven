package testcases;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.TestData;
import steps.HomePageSteps;
import utilities.ExcelReader;

@Narrative(text={"In order to Run Parameterized test",
		"As a Serenity Runner",
		"We need to Integrate Excel Reading"})
@Concurrent(threads = "4")
@RunWith(SerenityParameterizedRunner.class)
public class Parametarization 
{
     private String userName;
     private String password;
  
      public Parametarization(String userName, String password)
     {
	  this.userName = userName;
	  this.password = password;
	  
     }  
	  
      @TestData
	  public static Collection<Object[]> testData()
	  {
		  ExcelReader excel = new ExcelReader(".//src//test//resources//testdata//TData.xlsx");
		  
		  String sheetName = "LoginTest";
		  int rows = excel.getRowCount(sheetName);
		  int cols = excel.getColumnCount(sheetName);
			
		  System.out.println("Rows are : "+rows+"  cols are : "+cols);
		  System.out.println(excel.getCellData("LoginTest", 0, 2));
		  
		  Object[][] data = new Object[rows-1][cols];
		  
			/*
			 * data[0][0] = excel.getCellData("LoginTest", 0, 2); data[0][1] =
			 * excel.getCellData("LoginTest", 1, 2);
			 * 
			 * data[1][0] = excel.getCellData("LoginTest", 0, 3); data[1][1] =
			 * excel.getCellData("LoginTest", 1, 3);
			 */
		  

			for(int rowNum=2; rowNum<=rows; rowNum++) 
			{
				
				for(int colNum=0; colNum<cols; colNum++) 
				{
					
				 
					data[rowNum-2][colNum] = excel.getCellData(sheetName, colNum, rowNum); 
					
				}
				
			}
		  return Arrays.asList(data);
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
  
  
  
  

