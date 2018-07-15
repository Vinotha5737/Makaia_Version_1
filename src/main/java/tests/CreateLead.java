package tests;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dataReporter.ExcelReader;
import lib.selenium.PreAndPost;
import pages.CreateLeads;
import pages.MyHome;
import pages.MyLeads;
import pages.ViewLead;

public class CreateLead extends PreAndPost{
	
	@BeforeTest
	public void setValue()
	{   testCaseName="CreateLead1";
	    testDesc="Create a new Lead";
	    nodeName="Lead";
	    category="sanity";
	    author="Vinotha";
		excelFileName = "CreateLead";
	}
	
    @Test(dataProvider="Testing")//(groups= {"smoke"})	//@Test(invocationCount=2,timeOut=30000)
	public void createLead(String cname,String fname,String lname) {
		
    	MyHome home = new MyHome(driver, test);
    	home.clickLeads()
    	.clickCreateLead()
    	.typeCompanyName(cname)
       .typeFirstName(fname)
       .typeLastName(lname)
       .clickCreateLead()
       .verifyLead();
    	
    		
    	/*WebElement eleUserName = locateElement("id", "username");
		type(eleUserName, "DemoSalesManager");
		
		WebElement elePassword = locateElement("id", "password");
		type(elePassword, "crmsfa");
		*/
		/*WebElement eleLogin = locateElement("class", "decorativeSubmit");
		click(eleLogin);
		
		WebElement eleCRM = locateElement("link", "CRM/SFA");
		click(eleCRM);*/
		
		/*WebElement elecreate = locateElement("link","Create Lead");
		click(elecreate);
		
		WebElement elecomp = locateElement("id","createLeadForm_companyName");
		type(elecomp,cname);
		
		WebElement elefname = locateElement("id","createLeadForm_firstName");
		type(elefname,fname);
		
		WebElement elelname = locateElement("id","createLeadForm_lastName");
		type(elelname,lname);
		
		WebElement elelmail = locateElement("id","createLeadForm_primaryEmail");
		type(elelmail,email);
		
		WebElement elephone = locateElement("id","createLeadForm_primaryPhoneNumber");
		type(elephone,phone);//""+phone converting integer to string
		
		WebElement elesubmit = locateElement("name","submitButton");
		click(elesubmit);*/
		
			
	}
    
  
	
	
}




