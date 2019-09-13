package org.C_zentrix.org.C_zentrix;

public class DB 
{
	/*static String s1,LicenseVersion,s3,s4,s5,zap_provider_name,campaign_id1,server_output,excel_user,campaign_user,campaign_state,sip_name,gateway_Interface,disposition_name,list_name,Source_Lead_name;
    static int state, Feature_Details_agents,SIP_Extensions,agent_id,group_id,campaign_id,camp_count,agent_coun,list_count,sip_count,gateway_count,list_id,source_count;
	{
	   String sql="select * from license";//for licences version
	   String sql1="select * from features"; // for agent detail
	   String sql2="select*from maximum";
	   String sql3="select max_value from maximum where maximum_id=5";
	   String sql4="select list_id from list where list_name='User4_INBOUND'"; 
	   String sql5= "select list_name from list where list_name='List1'";  
	   String sql6="select provider_name from zap where zap_id='zap/9'"; // for provider name value
	   String sql7="select groupId from zap where zap_id='zap/9'"; // for zap group id 
	   String sql8="select campaign_id from campaign where campaign_name='User1'";// for inactive campaign
	   String sql9="select campaign_name from campaign where campaign_name='User1'";
	   String sql10="select campaign_state from campaign where campaign_name='User1'";
	   String sql11="select count(*) from campaign"; //for check campaign count
	   String sql12="select count(*) from agent"; //for check agent count
	   String sql13="select count(*) from list"; //for check list count
	   String sql14="select  sip_gateway_name from sip_gateway where  sip_gateway_name='server25'";
	   String sql15="select count(*) from sip_gateway";
	   String sql18="select list_id from list where list_name ='List1'";
	   String sql19="select count(*) from  source_lead_integration ";
	   String sql20="select source_lead_name from  source_lead_integration where source_lead_name='source1'";
		 rs=st.executeQuery(sql);
		 System.out.println("database table row is\t"+rs.getRow()); 
	     while(rs.next())
		 {
		  LicenseVersion =rs.getString(2);
		  System.out.println("License version is::"+LicenseVersion);
         }
	     rs=st.executeQuery(sql1);
		 while(rs.next())
		 {
	       //state =rs1.getString(2);
	         state=rs.getInt(2);
	         System.out.println("state value is::"+state);
	         break;
	     }
	     rs=st.executeQuery(sql2);
		 while(rs.next())
		 {
			 System.out.println("Feature_Details for agents ");
			 Feature_Details_agents=rs.getInt(3);
	         System.out.println("Feature_Details_agents::" + Feature_Details_agents);
		 }
		 rs=st.executeQuery(sql3);
		 while(rs.next())
		 {
			 System.out.println("Feature_Details for sip extensions");
		    SIP_Extensions=rs.getInt(1);
			 System.out.println("SIP_Extensions::" + SIP_Extensions);
		 }
		 rs=st.executeQuery(sql4);
	     while(rs.next())
		 {
			 System.out.println("upload list");
			 agent_id=rs.getInt(1);//for list upload
			 System.out.println("agent id is :" + agent_id);
		 }
	     rs=st.executeQuery(sql5);
	     while(rs.next())
		 {
			 System.out.println("list_name ");
			 list_name=rs.getString(1);//for list list_name
			 System.out.println("list_name  is :" + list_name);
		 }
	    rs=st.executeQuery(sql6);
		 while(rs.next())
		 {
		    System.out.println("zap");
			 zap_provider_name=rs.getString(1);
			// zap_provider_name=rs4.getInt(1);
			 System.out.println("zap provider name  is :" + zap_provider_name);
		 }
		rs=st.executeQuery(sql7);
		 while(rs.next())
		 {
			 System.out.println("zap group id");
			 group_id=rs.getInt(1);
			 System.out.println("zap group id  is :" + group_id);
		 } 
		rs=st.executeQuery(sql8);
		 while(rs.next())
		 {
			 System.out.println("campaign id");
			 campaign_id=rs.getInt(1);//for Sip_channel_configuration_Form
			 campaign_id1=rs.getString(1);
			 System.out.println(" campaign id  is :" + campaign_id);
		 }
		rs=st.executeQuery(sql9);
		 while(rs.next())
		 {
			 System.out.println("campaign_user");
		     campaign_user=rs.getString(1);
			 System.out.println(" campaign_user  is :" + campaign_user);
		 }
	    rs=st.executeQuery(sql10);
		 while(rs.next())
		 {
			 System.out.println("campaign_state");
			 campaign_state=rs.getString(1);
			 System.out.println(" campaign_state  is :" + campaign_state);
		 }
	    rs=st.executeQuery(sql11);
		 while(rs.next())
		 {
		   System.out.println("campaign count");
		   camp_count=rs.getInt(1);
		   System.out.println(" camp_count   is :" + camp_count);
		 }
	    rs=st.executeQuery(sql12);
		 while(rs.next())
		 {
		   System.out.println("campaign count");
		   agent_coun=rs.getInt(1);
		   System.out.println(" agent_coun   is :" + agent_coun);
		 }
	    rs=st.executeQuery(sql13);
		 while(rs.next())
		 {
		   System.out.println("list_count count");
		   list_count=rs.getInt(1);
		   System.out.println(" list_count   is :" + list_count);
		 }
	   rs=st.executeQuery(sql14);
		 while(rs.next())
		 {
		   System.out.println("sip_gateway_namet");
		   sip_name=rs.getString(1);
		   System.out.println(" sip_gateway_name   is :" + sip_name);
		 }
		rs=st.executeQuery(sql15);
		 while(rs.next())
		 {
		   System.out.println("sip_count");
		   sip_count=rs.getInt(1);
		   System.out.println(" sip_count   is :" + sip_count);
		 }
		 String sql16="select exIfc from gateway where exIfc='eth1'";
		 rs=st.executeQuery(sql16);
		 while(rs.next())
		 {
		   System.out.println("gateway_Interface");
		   gateway_Interface=rs.getString(1);
		   System.out.println(" gateway_Interface   is :" + gateway_Interface);
		 }
		 String sql17="select count(*) from gateway";
		 rs=st.executeQuery(sql17);
		 while(rs.next())
		 {
		   System.out.println("gateway_count");
		   gateway_count=rs.getInt(1);
		   System.out.println(" gateway_count   is :" + gateway_count);
		 }
		rs=st.executeQuery(sql18);
		 while(rs.next())
		 {
		   System.out.println("List_id");
		   list_id=rs.getInt(1);
		   System.out.println(" list_id   is :" + list_id);
		 }
		rs=st.executeQuery(sql19);
		 while(rs.next())
		 {
		   System.out.println("source_count");
		   source_count=rs.getInt(1);
		   System.out.println(" source_count   is :" + source_count);
		 }
	    rs=st.executeQuery(sql20);
		 while(rs.next())
		 {
		   System.out.println("Source_Lead_name");
		   Source_Lead_name=rs.getString(1);
		   System.out.println(" Source_Lead_name   is :" + Source_Lead_name);
		 }
	}
*/
}
