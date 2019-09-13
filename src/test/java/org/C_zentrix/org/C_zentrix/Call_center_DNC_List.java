package org.C_zentrix.org.C_zentrix;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class Call_center_DNC_List extends MethodClass
{
	public static void dnc()
	{
	   driver.findElement(By.xpath("/html/body/div[4]/table/tbody/tr/td[1]/table/tbody/tr[2]/td/ul[2]/li[3]/a")).click();
       driver.findElement(By.xpath("//*[@id=\"DNCLists_li_a\"]")).click();
       driver.findElement(By.name("dnc_list_add_ui")).click();
       driver.findElement(By.name("dnc_list_name")).clear();
       driver.findElement(By.name("dnc_list_name")).sendKeys("dnc1");
       driver.findElement(By.name("dncGlobalList")).click();
       Select sel=new Select(driver.findElement(By.name("campaign_id")));
           sel.selectByVisibleText("User1");
       driver.findElement(By.name("dnc_add_list")).click();    
       if(isAlertPresent())
	   {
		  closeAlertAndGetItsText();
	   }
       
	}
	
}
