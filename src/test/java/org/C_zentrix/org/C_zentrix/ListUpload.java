package org.C_zentrix.org.C_zentrix;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

public class ListUpload extends MethodClass 

{
	 public static void List()throws Exception
	  {

		  driver.findElement(By.xpath("/html/body/div[4]/table/tbody/tr/td[1]/table/tbody/tr[2]/td/ul[2]/li[3]/a")).click();
			driver.findElement(By.id("Lists_li_a")).click();
		  //click on List ( c ) function             
		 //driver.findElement(By.name("list_condition_ui[11]")).click();
		driver.findElement(By.name("list_condition_ui["+agent_id+"]")).click();
		  //driver.findElement(By.xpath("/html/body/div[4]/table/tbody/tr/td[2]/div[3]/div/div/div/form/div[2]/table/tbody/tr[2]/td[4]/input")).click();
		  driver.findElement(By.name("File_Name")).clear();
		  driver.findElement(By.name("File_Name")).sendKeys("D:\\himanshu\\list.csv");
		  System.out.println("browse the list");
		  driver.findElement(By.name("Upload")).click();
		  System.out.println("upload list");

		  new Select(driver.findElement(By.id("field_name"))).selectByVisibleText("name");
		  new Select(driver.findElement(By.id("mob1"))).selectByVisibleText("phoneno");
		  driver.findElement(By.name("map_list")).click();
		   if(isAlertPresent())
		   {
               closeAlertAndGetItsText();
			   Thread.sleep(500);
		   }
		 //scroll down  
		  JavascriptExecutor js = ((JavascriptExecutor) driver);
		  js.executeScript("window.scrollTo(0, document.body.scrollHeight)");	
		  System.out.println("Scroll Down");
		  Thread.sleep(1000);
		  if(isElementPresent((By.name("cmdImport")))){
		  driver.findElement(By.name("cmdImport")).click();
		  Thread.sleep(1000);
		  }
		  System.out.println("list uploaded suceesfully");
		  
		  if(isAlertPresent()){
		  	Thread.sleep(5000);
		  	 System.out.println("Records effected");
		  	closeAlertAndGetItsText();
		  }
		  driver.findElement(By.id("Campaigns_li_a")).click();
		  //driver.findElement(By.name("campaign_d["+TestBase.camp_id+"#smriti_in]")).click();
	  }
			private static boolean isElementPresent(By by) {
			// TODO Auto-generated method stub
			return false;
		}	
}
