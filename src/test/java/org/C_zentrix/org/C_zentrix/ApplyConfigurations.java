package org.C_zentrix.org.C_zentrix;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ApplyConfigurations extends MethodClass
{
	@Test
	public static void apply() throws Exception
	{
		driver.findElement(By.xpath("/html/body/div[4]/table/tbody/tr/td[1]/table/tbody/tr[2]/td/ul[1]/li[10]/a")).click();//system module click
		System.out.println("click 1");
		driver.findElement(By.xpath("//*[@id=\"ApplyConfigurations_li_a\"]")).click();//apply confi button
		System.out.println("click 2");
		driver.findElement(By.name("generateConfiguration")).click();
		
		closeAlertAndGetItsText();
		Thread.sleep(1000);
		System.out.println("click 3");
		Thread.sleep(1000);
		driver.findElement(By.name("commitConfAll")).click();//commit all button
		Thread.sleep(1000);
		System.out.println("click 4");
		
		closeAlertAndGetItsText();
	}

}
