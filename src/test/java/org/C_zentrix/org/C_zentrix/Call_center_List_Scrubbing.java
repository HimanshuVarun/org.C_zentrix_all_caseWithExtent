package org.C_zentrix.org.C_zentrix;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.mysql.jdbc.Driver;

public class Call_center_List_Scrubbing extends MethodClass
{
    public static void list_Scrubbing()
    {
 	   try {
		driver.findElement(By.xpath("/html/body/div[4]/table/tbody/tr/td[1]/table/tbody/tr[2]/td/ul[2]/li[3]/a")).click();
		   driver.findElement(By.xpath("//*[@id=\"tabExpandCollapseMarkLi\"]")).click();
		   driver.findElement(By.xpath("//*[@id=\"ListScrubbing_li_a\"]")).click();
		   Select sel=new Select(driver.findElement(By.name("campaign")));
		   sel.selectByVisibleText("User1");
		   Select sel1=new Select(driver.findElement(By.id("list")));
		   sel1.selectByVisibleText("List1");
		   driver.findElement(By.name("selectList")).click();
		   driver.findElement(By.name("File_Name")).clear();
		   driver.findElement(By.name("File_Name")).sendKeys("D:\\himanshu\\list.csv");
		   driver.findElement(By.name("UploadFile")).click();
		   Select sel2=new Select(driver.findElement(By.id("list")));
		   sel2.selectByVisibleText("List1");
		   Select sel3=new Select(driver.findElement(By.id("AcLists")));
		   sel3.selectByValue("DEACTIVATE");
		   driver.findElement(By.name("selectAcList")).click();
		   Select sel4=new Select(driver.findElement(By.name("compareTo[]")));
		   sel4.selectByValue("customer.name");
		   Select sel5=new Select(driver.findElement(By.name("relationship[]")));
		   sel5.selectByValue("AND");
		   driver.findElement(By.name("saveRule")).click();
		   Select sel6=new Select(driver.findElement(By.name("list_scrub_type")));
		   sel6.selectByValue("1");
		   driver.findElement(By.name("import")).click();
	} 
 	   catch (Exception e) 
 	   {
		
		   e.printStackTrace();
		   System.out.println("already exists");
	  }
       
       
    
    	
    }

}