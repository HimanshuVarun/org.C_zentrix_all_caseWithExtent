package org.C_zentrix.org.C_zentrix;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.Select;
public class AgentForm extends MethodClass
{
	 public static int  agent_count;
	 public static void agent() throws Exception
	 	{
		 Logger logger=Logger.getLogger("AgentForm");
		  PropertyConfigurator.configure("Log4j.properties");
		 logger.info("agent method is started");
		 System.out.println("agent method is start");
		 driver.findElement(By.xpath("/html/body/div[4]/table/tbody/tr/td[1]/table/tbody/tr[2]/td/ul[2]/li[3]/a")).click();
		 driver.findElement(By.xpath("//*[@id=\"Campaigns_li_a\"]")).click();
		 System.out.println("agent method is start  2");
		 System.out.println(campaign_id);
		 System.out.println(campaign_state);
	String cs="ACTIVE";	 
	System.out.println(campaign_state.equals(cs));
	if(campaign_state.equals(cs))
	{
		driver.findElement(By.name("campaign_d["+campaign_id+"#User1]")).click();
	}	
	    // driver.findElement(By.name("campaign_d[289#User1]")).click();
		 System.out.println("agent method is start 3");
         driver.findElement(By.xpath("/html/body/div[4]/table/tbody/tr/td[1]/table/tbody/tr[2]/td/ul[2]/li[3]/a")).click();
		 driver.findElement(By.name("agent_add_ui")).click();
		  String s1=driver.findElement(By.xpath("/html/body/div[4]/table/tbody/tr/td[2]/div[3]/div/div/div/form/div[1]")).getText();
	 	  assertion.assertEquals(s1, "Add Agent");
	 	  assertion.assertAll();
	   // collect data from excel sheet
		 Hs=Hw.getSheet("Sheet2");
		String camId =Hs.getRow(1).getCell(7).getStringCellValue();
	     agent_count=Hs.getLastRowNum()-2;
	   		 System.out.println("total roww is"+agent_count);
	   	   
	   	     for(int i=1;i<=agent_count;i++)
			   {
	   	    	  logger.info("start for loop");
	   	          System.out.println("agent in for loop");
				  String agentId =Hs.getRow(i).getCell(0).getStringCellValue();
				  String agentSecret =Hs.getRow(i).getCell(1).getStringCellValue();
	   			  String agentName =Hs.getRow(i).getCell(2).getStringCellValue();
	   			  String  agentExt=Hs.getRow(i).getCell(3).getStringCellValue();
	   			  String  agentEmail=Hs.getRow(i).getCell(4).getStringCellValue();
	   			  String callerId =Hs.getRow(i).getCell(5).getStringCellValue();
	   			  String sipPhone =Hs.getRow(i).getCell(6).getStringCellValue();
	   			  driver.findElement(By.xpath("//*[@id=\"agent_id\"]")).clear();
				  driver.findElement(By.xpath("//*[@id=\"agent_id\"]")).sendKeys(agentId);
				  driver.findElement(By.name("agent_secret")).clear();
				  driver.findElement(By.name("agent_secret")).sendKeys(agentSecret);
				  driver.findElement(By.name("secretcheck")).click();
				  driver.findElement(By.name("agent_name")).clear();
				  driver.findElement(By.name("agent_name")).sendKeys(agentName);
				  driver.findElement(By.name("agent_ext")).clear();
				  driver.findElement(By.name("agent_ext")).sendKeys(agentExt);
				  driver.findElement(By.name("email_id")).clear();
				  driver.findElement(By.name("email_id")).sendKeys(agentEmail);
				  driver.findElement(By.name("caller_id")).clear();
				  driver.findElement(By.name("caller_id")).sendKeys(callerId);
				  System.out.println("add campaign name");
                 Select sel2=new Select(driver.findElement(By.name("campaign_id")));
       			        sel2.selectByValue(campaign_id1);
				  driver.findElement(By.name("sip_pass")).clear();
				  driver.findElement(By.name("sip_pass")).sendKeys(sipPhone);
				  driver.findElement(By.name("nat")).click();
			   //Select sel=new Select(driver.findElement(By.name("agent_dtmf")));
			  //       sel.selectByValue("info");
				  System.out.println("Scroll down");
				JavascriptExecutor jsee = (JavascriptExecutor)driver;
	                               jsee.executeScript("window.scrollBy(0,300)", "");
			 //   Select sel3=new Select(driver.findElement(By.name("phoneType")));
			 //         sel3.selectByValue("1");
			 //   Select sel4=new Select(driver.findElement(By.className("selectlist")));
			 //          sel4.selectByValue("1");
			    driver.findElement(By.name("reg_mech")).click();
			    driver.findElement(By.name("preview_ckh")).click();
			    //driver.findElement(By.name("previewSave")).click();
			    driver.findElement(By.name("callback_ckh")).click();
			    driver.findElement(By.name("lock_agent")).click();
			    driver.findElement(By.name("call_termination_msg")).click();
			    driver.findElement(By.name("disable_asterisk_key")).click();
			    driver.findElement(By.name("screen_barging")).click();
			    driver.findElement(By.name("add_agent")).click();
			    System.out.println("there is alert");
			   logger.info("handle alert");
                if(isAlertPresent())
				   {
					  closeAlertAndGetItsText();
					  driver.findElement(By.xpath("//*[@id=\"Agents_li_a\"]")).click();
					  Thread.sleep(500);
				   }
			    driver.findElement(By.className("buttons")).click();
			   // driver.findElement(By.name("agent_add_ui")).click();
			    System.out.println("agent in for loop last");
			 }
	   	  MethodClass.Data();
	   	   logger.info("agent creation successful");
	   	      logger.info("agent method is closed");
	          System.out.println("agent method is closed");
       }
}
