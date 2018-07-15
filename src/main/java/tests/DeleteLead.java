package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import pages.FindLeads;
import pages.MyHome;


public class DeleteLead extends PreAndPost {
	
	@BeforeTest
	public void sendvalue()
	{
		 testCaseName="DeleteLead";
	     testDesc="Delete Lead details using phone number";
		 nodeName="Lead";
		 category="sanity";
		 author="Vinotha";
		excelFileName="DeleteLead";
	}
	
	@Test(dataProvider="Testing")  //(groups= {"sanity"})
	//@Test(dependsOnMethods= {"tests.CreateLead.createLead"},alwaysRun=true)
	public void deletelead(String phoneNum) throws InterruptedException
	{
	    String error="No records to display";
		String id=new MyHome(driver,test)
		.clickLeads()
		.clickFindLead()
		.clickPhoneTab()
		.typePhoneNumber(phoneNum)
		.clickFindLeads()
		.getLeadId();
		
		new FindLeads(driver,test)
		.clickResultId()
		.clickDeleteButton()
		.clickFindLead()
		.typeLeadId(id)
		.clickFindLeads()
		.verifyError(error);
		
		
		
	/*WebElement user=locateElement("id","username");
	type(user,"DemoSalesManager");
	
	WebElement elePassword = locateElement("id", "password");
	type(elePassword, "crmsfa");
	
	WebElement eleLogin = locateElement("class", "decorativeSubmit");
	click(eleLogin);
	
	WebElement eleCRM = locateElement("link", "CRM/SFA");
	click(eleCRM);
	
	WebElement elefind = locateElement("link","Leads");
	click(elefind);
	
	WebElement elefindLead = locateElement("link","Find Leads");
	click(elefindLead);
	
	WebElement phone=locateElement("xpath","//span[text()='Phone']");
	click(phone);
	
	WebElement pno=locateElement("xpath","//input[@name='phoneNumber']");
	type(pno,phoneNum);
	
	WebElement leadbut=locateElement("xpath","//button[text()='Find Leads']");
	click(leadbut);
	Thread.sleep(5000);
	
	WebElement leadid=locateElement("xpath","//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
	String lead=getText(leadid);
	System.out.println(lead);
	
	click(leadid);
	
	WebElement del=locateElement("xpath","//a[text()='Delete']");
	click(del);
	
	WebElement find=locateElement("xpath","//a[text()='Find Leads']");
	click(find);
	
	WebElement selead=locateElement("xpath","//input[@name='id']");
	type(selead,lead);
	
    WebElement result=locateElement("xpath","//button[text()='Find Leads']");
    click(result);
    
    WebElement error =locateElement("class","x-paging-info");
    verifyPartialText(error,"No records to display");*/
   
	}
	
/*	@DataProvider(name="TestDelete")
	public Object[][] deletedata()
	{
		Object[][] data=new Object[2][1];
		data[0][0]=4;
		data[1][0]=3;
		
	return data;
	}*/
	

}
