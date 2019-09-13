package org.C_zentrix.org.C_zentrix;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
public class Sip_channel_configuration_Form extends MethodClass 
{
	public static void sip_channel_Configuration()
	{
		Logger logger=Logger.getLogger("Sip_channel_configuration_Form");
		  PropertyConfigurator.configure("Log4j.properties");
		  logger.info(" start sip_channel configuration method ");
		System.out.println("sip_channel_Configuration method is start");
		 driver.findElement(By.xpath("/html/body/div[4]/table/tbody/tr/td[1]/table/tbody/tr[2]/td/ul[2]/li[3]/a")).click();
         driver.findElement(By.xpath("//*[@id=\"Campaigns_li_a\"]")).click();
         driver.findElement(By.name("campaign_edit_ui["+campaign_id+"]")).click();
      
         JavascriptExecutor jse = (JavascriptExecutor)driver;
         jse.executeScript("window.scrollBy(0,400)", "");
         Select sel3=new Select(driver.findElement(By.name("sipGateway[]")));
         System.out.println("sip cofiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
                sel3.selectByVisibleText("server25");
         driver.findElement(By.name("edit_campaign")).click(); 
         driver.findElement(By.xpath("/html/body/div[4]/table/tbody/tr/td[1]/table/tbody/tr[2]/td/ul[2]/li[2]/a")).click();
	     driver.findElement(By.id("SIPChannelConfiguration_li_a")).click();
	     driver.findElement(By.id("add_ui")).click();
	     
	     Select sel4=new Select(driver.findElement(By.name("combosipcamp")));
                sel4.selectByValue(campaign_id1);
         Select sel5=new Select(driver.findElement(By.name("combosipcamp1")));
                sel5.selectByVisibleText("server25");
	    driver.findElement(By.name("moveAllRight")).click();       
	    driver.findElement(By.name("campSip")).click();
	    logger.info("sip channel creation successful");
	    logger.info("closed sip channel configuration");
	   System.out.println("sip_channel_Configuration method is closed");
    }
}
