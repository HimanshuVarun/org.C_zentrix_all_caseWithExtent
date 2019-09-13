package org.C_zentrix.org.C_zentrix;
import java.io.InputStream;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import junit.framework.Assert;
public class service 
{
	public static int j=0;
	public static ExtentReports extent;
	public static  ExtentTest   logger;
	public  static  String serviceName[];    //declaring array
	public static void CS() 
       {   
	
	    String s1,s2;
	    String host="172.16.2.25";
	    String user="root";
	    String password="rootroot";
	    String command1="ps -ef |grep zentrix";
    try{
    
	    serviceName = new String[8];  // allocating memory to array
        // initialize the first elements of the array
                 serviceName[0] = "cz_dialer_data.pl";
	             serviceName[1] = "channel_health.pl";
	             serviceName[2] = "dialer_manager_listen.pl";
	             serviceName[3] = "erp_manager.pl";
	             serviceName[4] = "dialer_reporter.pl";
	             serviceName[5] = "czentrix_dialer.pl";
	             serviceName[6] = "ftp-client.pl";
	             serviceName[7] = "sfgskjgfsdsh";
	            //dialer_manager_listen.pi
	             //channel_health.pi
	             //
	        
       // accessing the elements of the specified array
	             for (int i = 0; i <serviceName.length; i++)
	             {
	                System.out.println("Element at index " + i +  ":"+ serviceName[i]);
	             }
	                System.out.println(serviceName.toString());
       //command1.substring(TIME, CMD);
	             java.util.Properties config = new java.util.Properties();
	             config.put("StrictHostKeyChecking", "no");
	             JSch jsch = new JSch();
	             Session session=jsch.getSession(user, host, 22);
	             session.setPassword(password);
	             session.setConfig(config);
	             session.connect();
	             System.out.println("Connected");
                 Channel channel=session.openChannel("exec");
	             ((ChannelExec)channel).setCommand(command1);
	             channel.setInputStream(null);
	             ((ChannelExec)channel).setErrStream(System.err);
                  InputStream in=channel.getInputStream();
	             channel.connect();
	             byte[] tmp=new byte[1024];
	           //System.out.println("hello 1");
	             while(true)
	             {
	                while(in.available()>0){
	            	int i=in.read(tmp, 0, 1024);
	                if(i<0)break;
	            //System.out.println("hello 2");
	                 System.out.println(new String(tmp,0,i));
	                 s1=new String(tmp,0,i);
	               for(int k=0;k<serviceName.length;k++)
	                 {
	                	s2=serviceName[k];
	                 	System.out.println(s2);
	                 	  j=s1.indexOf(s2);
	                      System.out.println(j);
	                    //  s3=s1.substring(j);
	                      //System.out.println(s3);
	                    //  System.out.println(s3.equals(s3));
	                     // if(s3.equals(s3))
	                      if(j!=-1)
	                      {
	                     	 System.out.println("string match");
	                      }
	                      else
	                      {
	                    	  System.out.println("string is not match");
                          }
	                  }
	              System.out.println("hello 6");
                   }
                    System.out.println(channel.hashCode());
                    
	                //System.out.println("---- End OF Line ----");
if(channel.isClosed())
                   {
	                 System.out.println("exit-status: "+channel.getExitStatus());
	                 break;
	               }
	               try{Thread.sleep(1000);}catch(Exception ee){}
	             }
	             channel.disconnect();
	             session.disconnect();
	             System.out.println("DONE");
	         }catch(Exception e){
	             e.printStackTrace();
	         }
 
      
	     }
  
   
}
