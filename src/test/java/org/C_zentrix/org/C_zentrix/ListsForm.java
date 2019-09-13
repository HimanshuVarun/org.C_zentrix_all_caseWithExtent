package org.C_zentrix.org.C_zentrix;

import java.io.FileInputStream;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.Select;
public class ListsForm extends MethodClass
{

	public static int  list_co;
	public static void list() throws Exception
	{ 
		Logger logger=Logger.getLogger("ListsForm");
		PropertyConfigurator.configure("Log4j.properties");
		 logger.info("start list method");
		 System.out.println("list method is start");
		 driver.findElement(By.xpath("/html/body/div[4]/table/tbody/tr/td[1]/table/tbody/tr[2]/td/ul[2]/li[3]/a")).click();
		 driver.findElement(By.id("Campaigns_li_a")).click();
		// driver.findElement(By.name("campaign_d["+campaign_id+"#User1]")).click();
	   //  driver.findElement(By.name("campaign_a["+campaign_id+"#User1]")).click();
	     Thread.sleep(1000);
	     driver.findElement(By.id("Lists_li_a")).click();
		 driver.findElement(By.name("list_add_ui")).click();
		  String s1=driver.findElement(By.xpath("/html/body/div[4]/table/tbody/tr/td[2]/div[3]/div/div/div/div[1]")).getText();
	 	  assertion.assertEquals(s1, "Add List","list form not found ");
	 	  assertion.assertAll();
	  //collect data from excel sheet
		 Hs=Hw.getSheet("Sheet5");
		 excel_L_name =Hs.getRow(1).getCell(0).getStringCellValue();
   		 String countryTimezone =Hs.getRow(1).getCell(6).getStringCellValue();
   		list_co=Hs.getLastRowNum();
   		 System.out.println("total row is"+list_co);
		  for(int i=1;i<=list_co;i++)
		   {
			  logger.info("start loop");
			  String Listname =Hs.getRow(i).getCell(0).getStringCellValue();
   			  String Startdate =Hs.getRow(i).getCell(1).getStringCellValue();
   			  String Enddate =Hs.getRow(i).getCell(2).getStringCellValue();
   			  String  Localstart_time=Hs.getRow(i).getCell(3).getStringCellValue();
   			  String  CallingDuration=Hs.getRow(i).getCell(4).getStringCellValue();
   			  String ListWeight =Hs.getRow(i).getCell(5).getStringCellValue();
   		    driver.findElement(By.name("list_name")).clear();
			driver.findElement(By.name("list_name")).sendKeys(Listname);
		    driver.findElement(By.name("startdate")).clear();
	        driver.findElement(By.name("startdate")).sendKeys(Startdate);
	        driver.findElement(By.name("enddate")).clear();
			driver.findElement(By.name("enddate")).sendKeys(Enddate);
			driver.findElement(By.name("local_start_time")).clear();
			driver.findElement(By.name("local_start_time")).sendKeys(Localstart_time);
		    driver.findElement(By.name("local_end_time")).clear();
			driver.findElement(By.name("local_end_time")).sendKeys(CallingDuration);
		    driver.findElement(By.className("selectlist")).click();
			driver.findElement(By.name("listWeight")).clear();
			driver.findElement(By.name("listWeight")).sendKeys(ListWeight);
		//	driver.findElement(By.xpath("//*[@id=\"auto_upload_data\"]")).click();
		//	driver.findElement(By.name("select_timezone_code")).click();
		//	driver.findElement(By.name("select_timezone_code")).click();
		    driver.findElement(By.name("select_multi_timezones")).click();
		    Thread.sleep(1000);
		    Select sel2=new Select(driver.findElement(By.name("country_timezone")));
		    sel2.selectByValue(countryTimezone);
		    Thread.sleep(1000);
		     driver.findElement(By.name("moveAllRight")).click();
			//driver.findElement(By.xpath("//*[@id=\"select_multi_timezones\"]")).click();
			 Thread.sleep(1000);
		    JavascriptExecutor jsee = (JavascriptExecutor)driver;
                              jsee.executeScript("window.scrollBy(0,300)", "");
            driver.findElement(By.name("add_list")).click();
  		    Thread.sleep(1000);
  		//  MethodClass.Data();
  		  logger.info("list creation successful");
  		    logger.info("handle alert");
  		if(isAlertPresent())
		   {
		     closeAlertAndGetItsText();
			 driver.findElement(By.xpath("//*[@id=\"Lists_li_a\"]")).click();
			 Thread.sleep(500);
		   }
		   driver.findElement(By.name("list_add_ui")).click();
		   // driver.findElement(By.id("Lists_li_a")).click();
		}
		  MethodClass.Data();
		//  campaign_state="INACTIVE";
		  logger.info("closed list method");
		 System.out.println("list method is closed");
    }
	
}
