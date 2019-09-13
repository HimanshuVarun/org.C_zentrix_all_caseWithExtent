package org.C_zentrix.org.C_zentrix;
import java.io.InputStream;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
//import org.apache.tools.ant.types.resources.selectors.Compare;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import junit.framework.Assert;
public class Test_czentrix extends MethodClass
{   
	
  //private static final Assertion Assert = null;
	public static ExtentReports extent;
	public static  ExtentTest   logger;
  @BeforeTest
    public  void before() throws Exception 
	{
	  System.out.println("Start Browser test case");
	  Logger loggerr=Logger.getLogger("Test_czentrix");
	  PropertyConfigurator.configure("Log4j.properties");
	  extent=new ExtentReports(System.getProperty("user.dir")+"/test-output/STMExtentReport.html",true);
	  extent.addSystemInfo("Host name", "softwsre Testing Material");
	  extent.addSystemInfo("Environment", "Automation Testing");
	  extent.addSystemInfo("User Name", "Himanshu");
	  loggerr.info("start before testcase");
try {
	  System.out.println("Start Try block ");
	 logger = extent.startTest("openbrowser");
    //Assert.assertTrue(true);
	  logger.log(LogStatus.PASS, "browser test case is pass");
	  System.out.println("call open Browser method ");
	  MethodClass.openBrowser();
	  System.out.println("close open broeser method in try block");
	  loggerr.info("close browser test case in try block");
  } 
 catch(Exception e)
	  {
	   System.out.println(e.getMessage()+" catch block");
	  } 
        System.out.println(" closed Browser test case");
		loggerr.info("close Browser testcase");
	}
  
   @Test(priority=1)
	public void license() throws Exception
	{
	  System.out.println("Start license test case");
	  Logger loggerr=Logger.getLogger("Test_czentrix");
 	  PropertyConfigurator.configure("Log4j.properties");
 	  loggerr.info("start license testcase");
 try {
      System.out.println("call license method in try block");
      License.license();
      System.out.println("close license method in try block");
      if(state==1&&LicenseVersion!=null&&Feature_Details_agents>1&&SIP_Extensions>1)
      {
     	logger = extent.startTest("license");
	    //Assert.assertTrue(true);
      	logger.log(LogStatus.PASS, "license test case is pass");
      	logger.log(LogStatus.PASS,"License state   is :: \t "+state);
      	logger.log(LogStatus.PASS,"License version is :: \t "+LicenseVersion);
   	    logger.log(LogStatus.PASS,"agents :: \t "+Feature_Details_agents);
   	    logger.log(LogStatus.PASS,"SIP_Extensions :: "+SIP_Extensions);
      }
     else
      {
       	logger = extent.startTest("license");
	 	//Assert.assertTrue(true);
   		logger.log(LogStatus.FAIL, "license test case is fail because some data not available in data base");
        if(state<1)
   		{	
          	logger.log(LogStatus.FAIL,"License Expired :: \t"+state);
   		}
   		else if(LicenseVersion==null) 
   		{
           	logger.log(LogStatus.FAIL,"LicenseVersion not available ::  \t"+LicenseVersion);
   		}
   		else if(Feature_Details_agents<1) 
   		{
           	logger.log(LogStatus.FAIL,"Agent not available :: \t"+Feature_Details_agents);
   		}
   		else if(SIP_Extensions<1) 
   		{
           	logger.log(LogStatus.FAIL,"SIP_Extensions not available :: \t"+SIP_Extensions);
   		}
   }
	       System.out.println("agent test is closed in try block");
     }
	  catch(Exception e)
	  {
		  System.out.println(e.getMessage()+" catch block");
	  }
	}
  @Test(priority=2)
 public void tdm() throws Exception
 {
       System.out.println("Start tdm test case  ");
          Logger loggerr=Logger.getLogger("Test_czentrix");
		  PropertyConfigurator.configure("Log4j.properties");
		  loggerr.info("Start tdm test case ");
	      logger = extent.startTest("TDM");
  	      //Assert.assertTrue(true);
  	      logger.log(LogStatus.PASS, "tdm test case is pass");
  	      System.out.println("call tdm method");
          TDM.tdm(); 
          System.out.println("close tdm  test method in tdm test case");
      System.out.println("tdm  test is closed");
      loggerr.info("close tdm  test");
  }
  
  @Test(priority=3)
	public void GateWay() throws Exception
	{
     System.out.println("Start gateway configuration test case");
	  Logger loggerr=Logger.getLogger("Test_czentrix");
	  PropertyConfigurator.configure("Log4j.properties");
	  loggerr.info("start gateway configuration test case");

try {
  System.out.println("start gateway configuration test in try block");
  System.out.println("call gateway configuration method in try block");
  Gateway_ConfigurationForm.gateWay();
  System.out.println("closed gateway configuration method in try block");
  System.out.println("total Gateway from excel \t"+Gateway_ConfigurationForm.gateway_excel_count);
  System.out.println("total Gateway from database"+gateway_count);
  if(gateway_count>=Gateway_ConfigurationForm.gateway_excel_count)
    {
  	 logger = extent.startTest("gateway configuration");
	 //Assert.assertTrue(true);
 	 logger.log(LogStatus.PASS, "gateway configuration test case is pass ");
 	 logger.log(LogStatus.PASS, "total gateway in database::"+gateway_count);
 	 logger.log(LogStatus.PASS, "total gateway in excel::"+Gateway_ConfigurationForm.gateway_excel_count);
    }
  else
   {
	   logger = extent.startTest("gateway configuration");
	   //Assert.assertTrue(true);
	   logger.log(LogStatus.FAIL, "gateway configuration test case is fail because campaign not available in data base");
	   logger.log(LogStatus.FAIL, "total gateway in database::"+gateway_count);
	   logger.log(LogStatus.FAIL, "total gateway in excel::"+Gateway_ConfigurationForm.gateway_excel_count);
      System.out.println("gateway configuration test case is fail because campaign not available in data base(some column missing in table campaign)");
   }
	   System.out.println("gateway configuration test is closed");
  }
	  catch(Exception e)
	  {
		  System.out.println(e.getMessage()+" catch block");
	  }
	}
  
  @Test(priority=4)
 	public void sip() throws Exception
 	{
	  System.out.println("start sip configuration testcase");
 	  Logger loggerr=Logger.getLogger("Test_czentrix");
 	  PropertyConfigurator.configure("Log4j.properties");
 	  loggerr.info("start sip configuration testcase");

 try {
     System.out.println("start sip configuration test in try block ");
     System.out.println("call sip configuration method in try block");
     SipChannelsForm.sipChannels();
     System.out.println("closed sip configuration method in try block");
     System.out.println("Total sip configuration from excel sheet "+SipChannelsForm.sip_count_excel);
     System.out.println("Total sip configuration from database"+sip_count);
     if(sip_count>=SipChannelsForm.sip_count_excel)
       {
     	 logger = extent.startTest("sip configuration");
 	     //Assert.assertTrue(true);
    	 logger.log(LogStatus.PASS, "sip configuration test case is pass ");
    	 logger.log(LogStatus.PASS, "total sip configuration from excel sheet ::\t"+SipChannelsForm.sip_count_excel);
    	 logger.log(LogStatus.PASS, "total sip configuration from database ::\t"+sip_count);
       }
     else
      {
   	   logger = extent.startTest("sip configuration");
 	   //Assert.assertTrue(true);
 	   logger.log(LogStatus.FAIL, "sip configuration test case is fail because campaign not available in data base");
 	   logger.log(LogStatus.FAIL, "total sip configuration from excel sheet ::\t"+SipChannelsForm.sip_count_excel);
 	   logger.log(LogStatus.FAIL, "total sip configuration from database ::\t"+sip_count);
       System.out.println("sip configuration test case is fail because campaign not available in data base(some column missing in table campaign)");
      }
 	   System.out.println("sip configuration test is closed");
     }
 	  catch(Exception e)
 	  {
 		  System.out.println(e.getMessage()+" catch block");
 	  }
 	}
   @Test(priority=5)
 	public void campaignTest() throws Exception
 	{
       System.out.println("Start campaign testcase");
 	  Logger loggerr=Logger.getLogger("Test_czentrix");
 	  PropertyConfigurator.configure("Log4j.properties");
 	  loggerr.info("start campaign testcase");
 try {
     System.out.println("start campaign test in try block");
     System.out.println("call campaign method in try block");
 	CampaignForm.cam();
 	System.out.println("closed campaign method in try block");
 	System.out.println(" first campaign from excel in test class "+excel_user);
 	System.out.println("database first campaign in test class "+campaign_user);
 	System.out.println(" campaign count from database"+camp_count);
 	System.out.println("campaign count from excel "+CampaignForm.campaign_count);
	
 if(camp_count>=CampaignForm.campaign_count&&campaign_user.equals(excel_user))
  {
 	 logger = extent.startTest("campaign");
 	 //Assert.assertTrue(true);
 	 logger.log(LogStatus.PASS, "campaign test case is pass ");
 	 logger.log(LogStatus.PASS, "total campaign in database::"+camp_count);
 	 logger.log(LogStatus.PASS, "total campaign in excel sheet ::"+CampaignForm.campaign_count);
 	 logger.log(LogStatus.PASS, "campaign name from excel ::\t"+excel_user);
	 logger.log(LogStatus.PASS, "campaign name in campaign table ::\t"+campaign_user);
	 logger.log(LogStatus.PASS, "all campaign in campaign table"+all_cam_name2);
	
  }
 else
  {
 	 logger = extent.startTest("campaign");
 	 //Assert.assertTrue(true);
 	 logger.log(LogStatus.FAIL, "campaign test case is fail because campaign not available in data base");
 	 logger.log(LogStatus.FAIL, "total campaign in database::"+camp_count);
 	 logger.log(LogStatus.FAIL, "total campaign in excel shrrt ::"+CampaignForm.campaign_count);
 	 logger.log(LogStatus.FAIL, "campaign name from excel ::\t"+excel_user);
 	 logger.log(LogStatus.FAIL, "campaign name in campaign table ::\t"+campaign_user);
 	 logger.log(LogStatus.FAIL, "all campaign in campaign table"+all_cam_name2);
	
 	 System.out.println("campaign test case is fail because campaign not available in data base(some column missing in table campaign)");
  }
 	 System.out.println("campaign test is closed");
 }
 	 catch(Exception e)
 	  {
 		  System.out.println(e.getMessage()+" catch block");
 	  }
 }
  @Test(priority=6)
public void agentTest() throws Exception
	{
	  System.out.println("Start agent test case");
	  Logger loggerr=Logger.getLogger("Test_czentrix");
	  PropertyConfigurator.configure("Log4j.properties");
	  loggerr.info("start agent testcase");

try {
 System.out.println("start agent testcase in try block ");
 System.out.println("call agent method in try block");
AgentForm.agent();
System.out.println("closed agent method in try block");
System.out.println("Total agent count from excel "+AgentForm.agent_count);
System.out.println("Total agent count from database"+agent_coun);


if(agent_coun>=AgentForm.agent_count&&sql21.equals(Agent_n_f_E))
  {
    logger = extent.startTest("agent");
	   //Assert.assertTrue(true);
	   logger.log(LogStatus.PASS, "agent test case is pass ");
	   logger.log(LogStatus.PASS, "total agent in agent table::"+agent_coun);
       logger.log(LogStatus.PASS, "total agent in excel::"+AgentForm.agent_count);
       logger.log(LogStatus.PASS, "first agent in excel ::"+Agent_n_f_E);
      logger.log(LogStatus.PASS, " agent in agent table ::"+sql21);
     logger.log(LogStatus.PASS,"all agent in agent table"+all_agent2+"\n");
   }
else
  {
	   logger = extent.startTest("agent");
	   //Assert.assertTrue(true);
	   logger.log(LogStatus.FAIL, "agent test case is fail because campaign not available in data base");
	   logger.log(LogStatus.FAIL, "total agent in agent table::"+agent_coun);
       logger.log(LogStatus.FAIL, "total agent in excel::"+AgentForm.agent_count);
       logger.log(LogStatus.FAIL, "first agent in excel ::"+Agent_n_f_E);
       logger.log(LogStatus.FAIL, "agent in agent table ::"+sql21);
       logger.log(LogStatus.FAIL,"all agent in agent table"+all_agent2+"\n");
	   System.out.println("agent test case is fail because campaign not available in data base(some column missing in table campaign)");
  }
	   System.out.println("agent test is closed");
 }
	  catch(Exception e)
	  {
		  System.out.println(e.getMessage()+" catch block");
	  }
	}
  @Test(priority=7)
	public void sip_Channel() throws Exception
	{
	    System.out.println("Start sip channel configuration test case ");
		 Logger loggerr=Logger.getLogger("Test_czentrix");
		  PropertyConfigurator.configure("Log4j.properties");
		  loggerr.info("Start sip channel configuration test case");
	logger = extent.startTest("Sip_channel");
	//Assert.assertTrue(true);
	logger.log(LogStatus.PASS, "sip test case is pass");
	System.out.println("call sip channel configuration method ");
	Sip_channel_configuration_Form.sip_channel_Configuration();
	System.out.println("call sip channel configuration method in test case ");
   System.out.println("sip channel configuration test is closed");
   loggerr.info("close sip channel configuration test");
	}
  @Test(priority=8)
 	public void listForm() throws Exception
 	{
 	  System.out.println("Start list test case");
 	  Logger loggerr=Logger.getLogger("Test_czentrix");
 	  PropertyConfigurator.configure("Log4j.properties");
 	  loggerr.info("start list testcase");
 try {
     System.out.println("start list test in try block ");
     System.out.println("call list method in try block");
     ListsForm.list();
     System.out.println("closed list method in try block");
     System.out.println("Total list from excel :: \t"+ListsForm.list_co);
     System.out.println("Total list from database ::\t"+list_count);
     if(list_count>=ListsForm.list_co&&excel_L_name.equals(list_name))
      {
     	 logger = extent.startTest("list");
 	     //Assert.assertTrue(true);
    	 logger.log(LogStatus.PASS, "list test case is pass ");
    	logger.log(LogStatus.PASS, "total list in database::"+list_count);
    	logger.log(LogStatus.PASS, "total list in excel::"+ListsForm.list_co);
  	logger.log(LogStatus.PASS, "list name from excel::"+excel_L_name);
 	logger.log(LogStatus.PASS, "list name from List table::"+list_name);
	logger.log(LogStatus.PASS, "all list in list table"+all_list2);
      	
      }
     else
      {
   	   logger = extent.startTest("list");
 	 	      //Assert.assertTrue(true);
 	     	 logger.log(LogStatus.FAIL, "list test case is fail because campaign not available in data base");
 	     	logger.log(LogStatus.FAIL, "total list in database::"+list_count);
 	     	logger.log(LogStatus.FAIL, "total list in excel::"+ListsForm.list_co);
 	    	logger.log(LogStatus.FAIL, "list name from excel::"+excel_L_name);
 	    	logger.log(LogStatus.FAIL, "list name from List table::"+list_name);
 	    	logger.log(LogStatus.FAIL, "all list in list table"+all_list2);
 	         	
    	  System.out.println("list test case is fail because campaign not available in data base(some column missing in table campaign)");
      }
 	  System.out.println("list test is closed");
     }
 	  catch(Exception e)
 	  {
 		  System.out.println(e.getMessage()+" catch block");
 	  }
 	}
 	
  @Test(priority=9)
	public void uploadList() throws Exception
	{
	 Logger loggerr=Logger.getLogger("Test_czentrix");
		  PropertyConfigurator.configure("Log4j.properties");
		  loggerr.info("start uploadList test");
		System.out.println("uploadList test is start");
logger = extent.startTest("uploadList");
	//Assert.assertTrue(true);
	logger.log(LogStatus.PASS, "uploadList test case is pass");
ListUpload.List();
System.out.println("uploadList test is closed");
loggerr.info("close uploadList test");
}
  
 @Test(priority=10)
  public void applyConfiguration() throws Exception
  {
 	 Logger loggerr=Logger.getLogger("Test_czentrix");
 	  PropertyConfigurator.configure("Log4j.properties");
 	  loggerr.info("start apply configuration test");
 	System.out.println("apply configuration test is start");
 logger = extent.startTest("apply configuration");
 //Assert.assertTrue(true);
 logger.log(LogStatus.PASS, "apply coniguration test case is pass");
 ApplyConfigurations.apply();
 System.out.println("apply configuration test is closed");
 loggerr.info("close apply configuration test");
  }
  

  
 
 /*   @Test
	public void test2()
	{
		System.out.println("skip test is start");
		logger = extent.startTest("skipTest");
		System.out.println("skip test is close");
	
    	//throw new SkipException("Skipping - this is not ready for testing");
     }
  @Test
public void source_lead() throws Exception
	{
	  System.out.println("Start Source_Lead test case");
	  Logger loggerr=Logger.getLogger("Test_czentrix");
	  PropertyConfigurator.configure("Log4j.properties");
	  loggerr.info("start Source_Lead testcase");

try {
 System.out.println("start Source_Lead testcase in try block ");
 System.out.println("call Source_Lead method in try block");
 Source_Lead.sourceLead();
System.out.println("closed Source_Lead method in try block");
System.out.println("Total Source_Lead count from excel "+Source_Lead.Source_count_excel);
System.out.println("Total Source_Lead count from database"+source_count);
if(source_count>=Source_Lead.Source_count_excel)
  {
    logger = extent.startTest("Source_Lead");
	   //Assert.assertTrue(true);
	   logger.log(LogStatus.PASS, "Source_Lead test case is pass ");
	   logger.log(LogStatus.PASS, "total Source_Lead in database::"+source_count);
    logger.log(LogStatus.PASS, "total Source_Lead in excel::"+Source_Lead.Source_count_excel);
	 
  }
else
  {
	   logger = extent.startTest("Source_Lead");
	   //Assert.assertTrue(true);
	   logger.log(LogStatus.FAIL, "Source_Lead test case is fail because Source_Lead not available in data base");
	   logger.log(LogStatus.FAIL, "total Source_Lead in database::"+source_count);
    logger.log(LogStatus.FAIL, "total Source_Lead in excel::"+Source_Lead.Source_count_excel);
	   System.out.println("Source_Lead test case is fail because Source_Lead not available in data base(some column missing in table campaign)");
  }
	   System.out.println("Source_Lead test is closed");
 }
	  catch(Exception e)
	  {
		  System.out.println(e.getMessage()+" catch block");
	  }
	}
	
 @Test
  public void List_Scrubbing() throws Exception
  {
 	 Logger loggerr=Logger.getLogger("Test_czentrix");
 	  PropertyConfigurator.configure("Log4j.properties");
 	  loggerr.info("start List_Scrubbing test");
 	System.out.println("List_Scrubbing test is start");
 logger = extent.startTest("List_Scrubbing");
 //Assert.assertTrue(true);
 logger.log(LogStatus.PASS, "List_Scrubbing test case is pass");
 Call_center_List_Scrubbing.list_Scrubbing();
 System.out.println("List_Scrubbing test is closed");
 loggerr.info("close List_Scrubbing test");
  }
   @Test
  public void Dnc() throws Exception
  {
 	 Logger loggerr=Logger.getLogger("Test_czentrix");
 	  PropertyConfigurator.configure("Log4j.properties");
 	  loggerr.info("start Dnc test");
 	System.out.println("Dnc test is start");
 logger = extent.startTest("Dnc");
 //Assert.assertTrue(true);
 logger.log(LogStatus.PASS, "Dnc test case is pass");
 Call_center_DNC_List.dnc();
 System.out.println("Dnc test is closed");
 loggerr.info("close Dnc test");
  }
 
  @Test
  public void skill_test() throws Exception
  {
 	 Logger loggerr=Logger.getLogger("Test_czentrix");
 	  PropertyConfigurator.configure("Log4j.properties");
 	  loggerr.info("start skill_test test");
 	System.out.println("skill_test  is start");
 logger = extent.startTest("skill_test");
 //Assert.assertTrue(true);
 logger.log(LogStatus.PASS, "skill_test case is pass");
 Skill.skill();
 System.out.println("skill_test  is closed");
 loggerr.info("close skill test");
  }
   */	
 
   
 
 	@AfterMethod
	 public void getResult(ITestResult result)
	 {     
	  if(result.getStatus()==ITestResult.FAILURE) 
	   {
	    logger.log(LogStatus.FAIL, "Test case failed is "+result.getName());
	    logger.log(LogStatus.FAIL, "Test case failed is "+result.getThrowable());
	   }
	  else if(result.getStatus()==ITestResult.SKIP)
	   {
	    logger.log(LogStatus.SKIP, "Test case skipped is"+result.getName());
	   }
	   extent.endTest(logger);
	}
	    @AfterTest
	    public void endReport()
	    {
	    	extent.flush();
	    	//extent.close();
	    }
}
