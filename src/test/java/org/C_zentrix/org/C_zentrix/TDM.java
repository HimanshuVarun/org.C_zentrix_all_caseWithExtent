package org.C_zentrix.org.C_zentrix;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class TDM extends MethodClass
{
	

	public static void tdm() throws Exception
	{
		driver.findElement(By.xpath("/html/body/div[4]/table/tbody/tr/td[1]/table/tbody/tr[2]/td/ul[2]/li[1]/a")).click();
		driver.findElement(By.name("add_card")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("txt_BChannel")).sendKeys("1-15,17-31");
		driver.findElement(By.name("txt_DChannel")).sendKeys("16");
		//Thread.sleep(4000);
		driver.findElement(By.name("card_save")).click();
		closeAlertAndGetItsText();
		driver.findElement(By.id("AddTDMGroup_li_a")).click();
		driver.findElement(By.name("agent_channel_group")).click();
		driver.findElement(By.name("virtualGroupCapability[virtualGroupAll]")).click();
		driver.findElement(By.name("selectCapWiseProvider")).click();
		driver.findElement(By.name("group_name")).sendKeys("E_22");
		System.out.println("add group name");
		new Select(driver.findElement(By.id("providerName"))).selectByVisibleText(zap_provider_name);
		driver.findElement(By.id("selectAllChannels")).click();
		driver.findElement(By.cssSelector("[name='addGroup']")).click();//customized css selector
		//closeAlertAndGetItsText(true);
		if(isAlertPresent())
		 {
			 closeAlertAndGetItsText();
		  	 System.out.println("alert");
		 }
		 System.out.println("hello tdm");
		 JavascriptExecutor jso = (JavascriptExecutor) driver;
		 jso.executeScript("window.document.getElementById('AssignTDMGroup_li_a').click()");
		 Thread.sleep(2000);
		 driver.findElement(By.name("add_assign_group_1")).click();
		 driver.findElement(By.name("add_AssignCampaign")).click();
		 if(isAlertPresent())
		 {
			 closeAlertAndGetItsText();
		  	 System.out.println("alert");
		 }
		 Thread.sleep(2000);
		 jso.executeScript("window.document.getElementById('DIDBasedRouting_li_a').click()");
		 Thread.sleep(4000);
		 driver.findElement(By.name("add_did_ui")).click();
		 driver.findElement(By.name("startrange")).sendKeys("10");
		 driver.findElement(By.name("endrange")).sendKeys("20");
		 driver.findElement(By.name("add_values")).click();
		 Thread.sleep(1000);
		 jso.executeScript("window.document.getElementById('TestCall_li_a').click()");
		 Thread.sleep(1000);
		 Select sel=new Select(driver.findElement(By.name("channel_type")));
		        sel.selectByValue("E1");
		 driver.findElement(By.name("phone_no")).sendKeys("9756256856");  
		 driver.findElement(By.name("dial_button_zap")).click();
		
	
		
		 
		}
 
	
}
//input[@name='add_assign_group[1][E1_5_grp]']
