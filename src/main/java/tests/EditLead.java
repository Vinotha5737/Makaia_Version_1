package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import pages.MyHome;

public class EditLead extends PreAndPost{
	@BeforeTest
	public void setValue()
	{
		 testCaseName="EditLead";
	     testDesc="Edit the existing  Lead";
		 nodeName="Lead";
		 category="sanity";
		 author="Vinotha";
		excelFileName="EditLead";
	}
	
    @Test(dataProvider="Testing")//(groups= {"smoke"})
	//@Test(dependsOnMethods= {"tests.CreateLead.createLead"},description="Editing lead details")
	public void editlead(String name,String comp) throws InterruptedException
	{
    	new MyHome(driver,test).clickLeads()
    	.clickFindLead()
    	.typeFirstName(name)
    	.clickFindLeads()
    	.clickResult()
    	.clickEditButton()
    	.clearCompanyName()
    	.typeCompanyName(comp)
    	.clickUpdate()
    	.verifyComp(comp);
    
		/*WebElement eleUserName = locateElement("id", "username");
		type(eleUserName, "DemoSalesManager");
		
		WebElement elePassword = locateElement("id", "password");
		type(elePassword, "crmsfa");
		
		WebElement eleLogin = locateElement("class", "decorativeSubmit");
		click(eleLogin);
		
		WebElement eleCRM = locateElement("link", "CRM/SFA");
		click(eleCRM);*/
		
	/*	WebElement elefind = locateElement("link","Leads");
		click(elefind);
		
		WebElement elefindLead = locateElement("link","Find Leads");
		click(elefindLead);
		//Enter name
		WebElement eleFname = locateElement("xpath","(//input[@name='firstName'])[3]");
		type(eleFname,name);
		//click search				
		WebElement elesearch = locateElement("xpath","//button[text()='Find Leads']");
		click(elesearch);
		Thread.sleep(5000);
		//Click the first searched row.
	    WebElement searchname=locateElement("xpath","(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a)[1]");
	    click(searchname);
	    //click edit
	    WebElement clickedit=locateElement("xpath","//a[text()='Edit']");
	    click(clickedit);
	    //clear the existing company name
	    WebElement clearcomp=locateElement("id","updateLeadForm_companyName");
	    clear(clearcomp);
	    //enter the new company name
	   // WebElement compname=locateElement("id","updateLeadForm_companyName");
	    type(clearcomp,comp);
	     //click update button
	    WebElement updatebutton=locateElement("xpath","//input[@value='Update']");
	    click(updatebutton);
		//Verify company name is updated correctly
	    WebElement company=locateElement("xpath","//span[contains(text(),comp)]");
	    String value=getText(company);
	    if(value.contains(comp))
	    {
	    	System.out.println("company name is updated succesfully");
	    }*/
	    
	}
 
    
}
