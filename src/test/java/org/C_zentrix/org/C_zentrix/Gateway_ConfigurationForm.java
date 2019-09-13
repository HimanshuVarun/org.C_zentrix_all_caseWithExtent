package org.C_zentrix.org.C_zentrix;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.tools.ant.types.resources.selectors.Compare;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;
public class Gateway_ConfigurationForm extends MethodClass
{
	static int gateway_excel_count;
	public static void gateWay() throws IOException
	  {
			Logger logger=Logger.getLogger("Gateway_ConfigurationForm");
			  PropertyConfigurator.configure("Log4j.properties");
			  logger.info("start gatWay method");
		  driver.findElement(By.xpath("/html/body/div[4]/table/tbody/tr/td[1]/table/tbody/tr[2]/td/ul[1]/li[10]/a")).click();
		  driver.findElement(By.id("tabExpandCollapseMark")).click();
		  driver.findElement(By.id("GWConfiguration_li_a")).click();
		  driver.findElement(By.name("host_name")).click();
		 //collect data from excel sheet
		    Hs=Hw.getSheet("Sheet4");
	         gateway_excel_count=Hs.getLastRowNum()-2;
	    System.out.println("total gateway_excel_count is"+gateway_excel_count);
	 		for(int i=1;i<=gateway_excel_count;i++)
			   {
	 			// logger.info("start loop");
				  System.out.println("gateway in loop");
			     if(i==1)
			     {
				   String s1="eth0";
				   Select sel1=new Select(driver.findElement(By.name("ExdeviceInfo")));
		   		   sel1.selectByValue(s1);
				  }
				  else if(i==2)
				  {
					  String s2="eth1";
					  Select sel2=new Select(driver.findElement(By.id("a")));
			   		   sel2.selectByValue(s2);
				  }
			      String Downlink_BW =Hs.getRow(i).getCell(0).getStringCellValue();
	 			  String  Uplink_BW =Hs.getRow(i).getCell(1).getStringCellValue();
	 			  String  RTP_Timeout  =Hs.getRow(i).getCell(2).getStringCellValue();
	 			//driver.findElement(By.name("DownlinkBW")).clear();
				driver.findElement(By.name("DownlinkBW")).sendKeys(Downlink_BW);
	            driver.findElement(By.name("UplinkBW")).clear();
		        driver.findElement(By.name("UplinkBW")).sendKeys(Uplink_BW);
		        driver.findElement(By.name("rtpTimeout")).clear();
				driver.findElement(By.name("rtpTimeout")).sendKeys(RTP_Timeout);
				driver.findElement(By.name("NAT")).click();
				driver.findElement(By.name("QOS")).click();
				driver.findElement(By.name("gwconfsubmit")).click();
				driver.findElement(By.xpath("//*[@id=\"GWConfiguration_li_a\"]")).click();
				 driver.findElement(By.name("host_name")).click();
	           if(i==2)
	           {
	        	   System.out.println(i+"fhshgfgfdghvdj");
	   		       driver.findElement(By.name("Close")).click();
               }
			 } 
	 		 MethodClass.Data();
	           logger.info("Gateway creation  successful");
			 //  String s8=driver.findElement(By.name("host_name")).getText();
			 //	assertion.assertEquals(s8, "Duplicate Data Found.. Change inteface combination.");
			 //assertion.assertAll();
			 // assertion.assertTrue(driver.findElement(By.name("host_name")).isDisplayed(),"Duplicate Data Found.. Change inteface combination.");
			  logger.info("closed gateway method");
		
	}
}
