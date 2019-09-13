package org.C_zentrix.org.C_zentrix;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class License extends MethodClass
{
	
	public static void license()
	{
		JavascriptExecutor jsee = (JavascriptExecutor)driver;
        jsee.executeScript("window.scrollBy(0,400)", "");
        driver.findElement(By.xpath("/html/body/div[4]/table/tbody/tr/td[1]/table/tbody/tr[2]/td/ul[4]/li[1]/a")).click();
        driver.findElement(By.xpath("/html/body/div[4]/table/tbody/tr/td[2]/ul/li[2]")).click();
        //DataBase method calling
        System.out.println(LicenseVersion+"\n"+state+"\n"+ Feature_Details_agents+"\n"+SIP_Extensions);
        if(state==1)
        {
    	  System.out.println("License Enabled");
        }
        else
        {
        	 System.out.println("License Expired");
        }
        if(LicenseVersion!=null)
        {
    	  System.out.println("LicenseVersion is"+LicenseVersion);
        }
        else
        {
           System.out.println("LicenseVersion not in data base");
        }
        if(Feature_Details_agents>1)
        {
        	 System.out.println("agent is:"+Feature_Details_agents);
        }
        else
        {
        	System.out.println("agents not available"+Feature_Details_agents);
        }
        if(SIP_Extensions>1)
        {
    	  System.out.println("SIP_Extensions is:"+Feature_Details_agents);
        }
        else
        {
        	 System.out.println("SIP_Extensions not available"+SIP_Extensions);
        }
   }
}
