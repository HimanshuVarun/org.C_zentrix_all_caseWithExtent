package org.C_zentrix.org.C_zentrix;

import java.io.FileInputStream;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

public class SipChannelsForm extends MethodClass
{
  public static int sip_count_excel;
	 public static void sipChannels() throws Exception
		{
			Logger logger=Logger.getLogger("SipChannelsForm");
			  PropertyConfigurator.configure("Log4j.properties");
			  logger.info(" start sipChannels method ");
		 System.out.println("sipChannels method is start");
		  driver.findElement(By.xpath("/html/body/div[4]/table/tbody/tr/td[1]/table/tbody/tr[2]/td/ul[2]/li[2]/a")).click();
		  driver.findElement(By.name("add_ui")).click();
		  String s1=driver.findElement(By.xpath("/html/body/div[4]/table/tbody/tr/td[2]/div[3]/div/div[1]")).getText();
	 		assertion.assertEquals(s1, "Sip Details");
	 		assertion.assertAll();
	      // collect data from excel sheet
		  Hs=Hw.getSheet("Sheet6");
	   	   sip_count_excel=Hs.getLastRowNum();
	   	  System.out.println("total row is"+sip_count_excel);
	   		 for(int i=1;i<=sip_count_excel;i++)
			   {
	   			 logger.info("start loop");
				  String SIP_Registrar_Name  =Hs.getRow(i).getCell(0).getStringCellValue();
	   			  String SIP_Registrar_Server  =Hs.getRow(i).getCell(1).getStringCellValue();
	   			  String Phone_Number  =Hs.getRow(i).getCell(2).getStringCellValue();
	   			  String  Secret=Hs.getRow(i).getCell(3).getStringCellValue();
	   			  String  Port_Number=Hs.getRow(i).getCell(4).getStringCellValue();
	   			  String Dialing_Code_prefix =Hs.getRow(i).getCell(5).getStringCellValue();
	   			  String Allocate_Bandwidth_kbps =Hs.getRow(i).getCell(6).getStringCellValue();
	   			  String Unit_Cost_Minute =Hs.getRow(i).getCell(7).getStringCellValue();
	   			  String Optional_User =Hs.getRow(i).getCell(8).getStringCellValue();
	   			  String ani =Hs.getRow(i).getCell(9).getStringCellValue();
	   			  String Provider_Name =Hs.getRow(i).getCell(10).getStringCellValue();
	   			  String ACD_Context =Hs.getRow(i).getCell(11).getStringCellValue();
		        driver.findElement(By.name("sip_gateway_name")).clear();
				driver.findElement(By.name("sip_gateway_name")).sendKeys(SIP_Registrar_Name);
				driver.findElement(By.name("ipaddress")).clear();
				driver.findElement(By.name("ipaddress")).sendKeys(SIP_Registrar_Server);
				driver.findElement(By.name("Phone_no")).clear();
				driver.findElement(By.name("Phone_no")).sendKeys(Phone_Number);
				driver.findElement(By.name("password")).clear();
				driver.findElement(By.name("password")).sendKeys(Secret);
				driver.findElement(By.name("port")).clear();
				driver.findElement(By.name("port")).sendKeys(Port_Number);
				driver.findElement(By.name("dial_code")).clear();
				driver.findElement(By.name("dial_code")).sendKeys(Dialing_Code_prefix);
				Select sel1=new Select(driver.findElement(By.name("dtmf")));
			    sel1.selectByValue("auto");
			    Select sel2=new Select(driver.findElement(By.name("transport_type")));
			    sel2.selectByValue("TCP");
			    driver.findElement(By.name("can_reinvite")).click();
			    Select sel3=new Select(driver.findElement(By.name("codec")));
			    sel3.selectByValue("g722");
			//	driver.findElement(By.name("allocated_bandwidth")).clear();
		    //		driver.findElement(By.name("allocated_bandwidth")).sendKeys(Allocate_Bandwidth_kbps);
				driver.findElement(By.name("pulse_rate")).clear();
				driver.findElement(By.name("pulse_rate")).sendKeys(Unit_Cost_Minute);
				driver.findElement(By.name("optional_user")).clear();
				driver.findElement(By.name("optional_user")).sendKeys(Optional_User);
				driver.findElement(By.name("ANI")).clear();
				driver.findElement(By.name("ANI")).sendKeys(ani);
				driver.findElement(By.name("provider_name")).clear();
				driver.findElement(By.name("provider_name")).sendKeys(Provider_Name);
				driver.findElement(By.name("acd_context")).clear();
				driver.findElement(By.name("acd_context")).sendKeys(ACD_Context);
				 driver.findElement(By.name("mul_did_ipforwarding")).click();
				 driver.findElement(By.name("registration_required")).click();
				 driver.findElement(By.name("cisco_gateway")).click();
				 driver.findElement(By.name("pbx")).click();
				 driver.findElement(By.name("add_sip")).click();
				 Thread.sleep(1000);
				 driver.findElement(By.xpath("//*[@id=\"SIPConfiguration_li_a\"]")).click();
				 driver.findElement(By.name("add_ui")).click();
				logger.info("SipChannels creation successful");
			}
	   		 MethodClass.Data();
	   		     logger.info("closed sipChannels method");
			     System.out.println("sip method is close");
       }
}
