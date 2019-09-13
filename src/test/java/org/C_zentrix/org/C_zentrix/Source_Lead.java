package org.C_zentrix.org.C_zentrix;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class Source_Lead extends MethodClass
{
	  public static int  Source_count_excel;
	  public static String source_name,source_cam,map_phone,List_Weight,ip,Timezone,List_Start_Time,Call_Duration  ;
   public static void sourceLead()
   {
	   System.out.println("start source lead method");
	   Hs=Hw.getSheet("Sheet8");
	   Source_count_excel=Hs.getLastRowNum();
	   System.out.println("total Source_count from excel is "+Source_count_excel);
	 
	//  if(Source_Lead_name!="source1")
	try   {   
	   for(int i=1;i<=Source_count_excel;i++)
	   {	   
	   driver.findElement(By.xpath("/html/body/div[4]/table/tbody/tr/td[1]/table/tbody/tr[2]/td/ul[2]/li[3]/a")).click();
 	   driver.findElement(By.xpath("//*[@id=\"tabExpandCollapseMarkLi\"]")).click();
       driver.findElement(By.xpath("//*[@id=\"SourceLead_li_a\"]")).click();
       driver.findElement(By.name("add_source_lead")).click();
       source_name =Hs.getRow(i).getCell(0).getStringCellValue();
       driver.findElement(By.name("txtsource_name")).clear();
       driver.findElement(By.name("txtsource_name")).sendKeys(source_name);
       source_cam =Hs.getRow(i).getCell(1).getStringCellValue();
       Select sel=new Select(driver.findElement(By.name("slcampaign_name")));
       sel.selectByVisibleText(source_cam);
       map_phone =Hs.getRow(i).getCell(2).getStringCellValue();
       driver.findElement(By.name("txtMapPhone1")).clear();
       driver.findElement(By.name("txtMapPhone1")).sendKeys(map_phone);
     //  driver.findElement(By.name("remove_replace_flag")).click();
       driver.findElement(By.name("dnc_lookup")).click();
       driver.findElement(By.name("skill_lookup")).click();
       List_Weight =Hs.getRow(i).getCell(3).getStringCellValue();
       driver.findElement(By.name("list_weight")).clear();
       driver.findElement(By.name("list_weight")).sendKeys(List_Weight);
       driver.findElement(By.name("auto_activate_list")).click();
       driver.findElement(By.name("txtsource_ip[]")).click();
       driver.findElement(By.name("txtsource_ip[]")).clear();
       ip =Hs.getRow(i).getCell(4).getStringCellValue();
       driver.findElement(By.name("txtsource_ip[]")).sendKeys(ip);
       Timezone  =Hs.getRow(i).getCell(5).getStringCellValue();
       Select se2=new Select(driver.findElement(By.name("slTimeZone")));
       se2.selectByVisibleText(Timezone );
       List_Start_Time  =Hs.getRow(i).getCell(6).getStringCellValue();
       driver.findElement(By.name("list_start_time")).clear();
       driver.findElement(By.name("list_start_time")).sendKeys(List_Start_Time);
       Call_Duration  =Hs.getRow(i).getCell(7).getStringCellValue();
       driver.findElement(By.name("list_end_time")).clear();
       driver.findElement(By.name("list_end_time")).sendKeys(Call_Duration);
      driver.findElement(By.name("save_source_lead")).click();

       if(isAlertPresent())
	   {
		  closeAlertAndGetItsText();
	   }
	 }
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("exception block");
	}
	 MethodClass.Data();
   }
}
