package org.C_zentrix.org.C_zentrix;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;


public class Skill extends MethodClass
{
	public static int  skill_count;
	static String skill_name,skill_length,state;
	public static void skill() throws Exception
	{
		 driver.findElement(By.xpath("/html/body/div[4]/table/tbody/tr/td[1]/table/tbody/tr[2]/td/ul[2]/li[3]/a")).click();
		  driver.findElement(By.xpath("//*[@id=\"Campaigns_li_a\"]")).click();
		    driver.findElement(By.name("add_skills["+campaign_id+"]")).click();
		 Hs=Hw.getSheet("Sheet7");
   	    skill_count=Hs.getLastRowNum();
   		 System.out.println("total skill from excel "+skill_count);
   	   for(int i=1;i<=skill_count;i++)
   	   {
	    driver.findElement(By.name("radio")).click();
	     skill_name =Hs.getRow(i).getCell(0).getStringCellValue();
	    driver.findElement(By.name("skill_name")).clear();
	    driver.findElement(By.name("skill_name")).sendKeys(skill_name);
	     skill_length =Hs.getRow(i).getCell(1).getStringCellValue();
	    driver.findElement(By.name("max_queue_len")).clear();
	    driver.findElement(By.name("max_queue_len")).sendKeys(skill_length);
	     state =Hs.getRow(i).getCell(2).getStringCellValue();
	    Select sel2=new Select(driver.findElement(By.name("skill_state")));
         sel2.selectByValue(state);
         driver.findElement(By.name("add_skill_set")).click();
        }
      //assing_campaign
   	 driver.findElement(By.xpath("/html/body/div[4]/table/tbody/tr/td[2]/div[3]/div/div[2]/div/div[2]/form/table/tbody/tr[2]/td[7]/input")).click();
     Select sel3=new Select(driver.findElement(By.name("agent_skill_name[]")));
     sel3.selectByValue("245656");
     driver.findElement(By.name("assign_camp_skill_to_agent")).click();
     if(isAlertPresent())
	   {
		  closeAlertAndGetItsText();
	   }
      driver.findElement(By.xpath("/html/body/div[4]/table/tbody/tr/td[2]/div[3]/div/div[2]/form[1]/table/tbody/tr/td/div/a/span/font/u")).click();//for back
      driver.findElement(By.xpath("/html/body/div[4]/table/tbody/tr/td[2]/div[3]/div/div[2]/div/div[2]/form/table/tbody/tr[3]/td[7]/input")).click();
      Select sel4=new Select(driver.findElement(By.name("agent_skill_name[]")));
      sel4.selectByValue("245656");
      driver.findElement(By.name("assign_camp_skill_to_agent")).click();
      if(isAlertPresent())
	   {
		  closeAlertAndGetItsText();
	   }
      driver.findElement(By.xpath("/html/body/div[4]/table/tbody/tr/td[2]/div[3]/div/div[2]/form[1]/table/tbody/tr/td/div/a/span/font/u")).click();//for back
      driver.findElement(By.xpath("/html/body/div[4]/table/tbody/tr/td[2]/div[3]/div/div[2]/div/div[2]/form/table/tbody/tr[4]/td[7]/input")).click();
      Select sel5=new Select(driver.findElement(By.name("agent_skill_name[]")));
      sel5.selectByValue("245656");
      Thread.sleep(1000);
      Select sel55=new Select(driver.findElement(By.name("weight")));
             sel55.selectByValue("20");
             Thread.sleep(1000);
      driver.findElement(By.name("assign_camp_skill_to_agent")).click();
      if(isAlertPresent())
	   {
		  closeAlertAndGetItsText();
	   }
   	
   	 driver.findElement(By.xpath("/html/body/div[4]/table/tbody/tr/td[2]/div[3]/div/div[2]/form[1]/table/tbody/tr/td/div/a/span/font/u")).click();//for back
     driver.findElement(By.xpath("/html/body/div[4]/table/tbody/tr/td[2]/div[3]/div/div[2]/div/div[2]/form/table/tbody/tr[5]/td[7]/input\r\n")).click();
     Select sel6=new Select(driver.findElement(By.name("agent_skill_name[]")));
     sel6.selectByValue("245656");
     driver.findElement(By.name("assign_camp_skill_to_agent")).click();
     if(isAlertPresent())
	   {
		  closeAlertAndGetItsText();
	   }
   	 driver.findElement(By.xpath("/html/body/div[4]/table/tbody/tr/td[2]/div[3]/div/div[2]/form[1]/table/tbody/tr/td/div/a/span/font/u")).click();//for back
   // for global skill
    
    
   	 driver.findElement(By.xpath("//*[@id=\"tabExpandCollapseMark\"]")).click();
   	 driver.findElement(By.xpath("//*[@id=\"GlobalSkills_li_a\"]")).click();//click on Global skill button
   	 for(int i=1;i<=skill_count-2;i++)
   	 {
   		  skill_name =Hs.getRow(i).getCell(0).getStringCellValue();
   		 driver.findElement(By.name("assign_skill")).clear();
   		 driver.findElement(By.name("assign_skill")).sendKeys(skill_name);
   	     Thread.sleep(500);
   		 driver.findElement(By.name("skill_save")).click();
   		 Thread.sleep(500);
   	  if(isAlertPresent())
	   {
   		  System.out.println("");
		  closeAlertAndGetItsText();
		  Thread.sleep(1000);
	   }
     }
   	 for(int i=1;i<=skill_count-2;i++)
   	 {
        driver.findElement(By.xpath("//*[@id=\"Campaigns_li_a\"]")).click();
	    driver.findElement(By.name("add_skills["+campaign_id+"]")).click();
	    driver.findElement(By.id("radio2")).click();// click on Global button
	   // driver.findElement(By.name("skill_global_name")).click();
  		  skill_name =Hs.getRow(i).getCell(0).getStringCellValue();
        Select sel7=new Select(driver.findElement(By.name("skill_global_name")));
	      sel7.selectByVisibleText(skill_name);
		 skill_length =Hs.getRow(i).getCell(1).getStringCellValue();
        driver.findElement(By.name("max_queue_len")).clear();
		driver.findElement(By.name("max_queue_len")).sendKeys(skill_length);
		 state =Hs.getRow(i).getCell(2).getStringCellValue();
		Select sel2=new Select(driver.findElement(By.name("skill_state")));
	           sel2.selectByValue(state);
   	 }

	}
}
