package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import lib.selenium.WebDriverServiceImpl;
import pages.FindLeads;
import pages.MyHome;
import pages.ViewLead;

public class DuplicateLead extends PreAndPost {

	@BeforeTest
	public void sendvalue()
	{
		testCaseName="DuplicateLead";
		testDesc="Duplicate the Lead details using Email";
		nodeName="Lead";
		category="sanity";
		author="Vinotha";
		excelFileName="DuplicateLead";
	}

	@Test(dataProvider="Testing")
	public void duplicate(String email) throws InterruptedException
	{

		String leadFname = new MyHome(driver,test)
				.clickLeads()
				.clickFindLead()
				.clickEmail()
				.typeEmail(email)
				.clickFindLeads()
				.getLeadFname();

		System.out.println(leadFname);

		new FindLeads(driver, test)
		.clickResultfname()
		.clickDuplicateButton()
		.getTitle()
		.clickCreateLead();
		
		new ViewLead(driver, test).verifyDuplicate(leadFname);



		/*
		WebElement user=locateElement("id","username");
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

		WebElement mail=locateElement("xpath","//span[text()='Email']");
		click(mail);

		WebElement eaddress=locateElement("xpath","//input[@name='emailAddress']");
		type(eaddress,email);

		WebElement slead=locateElement("xpath","//button[text()='Find Leads']");
		click(slead);
		Thread.sleep(5000);

		 WebElement name = locateElement("xpath","//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a");
		 String leadname=getText(name);
		 System.out.println(leadname);
		 click(name);
		 Thread.sleep(5000);

		 WebElement duplead=locateElement("xpath","//a[text()='Duplicate Lead']");
		 click(duplead);
		 boolean result=verifyPartialTitle("Duplicate Lead");
		 if(result==true)
		 {
			 System.out.println("Title Verified");
		 }
		 else 
		 {
			 System.out.println("Title not verified");
		 }

		 WebElement clead=locateElement("xpath","//input[@value='Create Lead']");
		 click(clead);

		 WebElement getduplicate = locateElement("id","viewLead_firstName_sp");
		 String duplicate=getText(getduplicate);
		 if(leadname.contains(duplicate))
	    	  System.out.println("The lead is duplicated successfully");*/




	}
	/*@DataProvider(name="DupData")
	public Object[][] dupData()
	{
		Object[][] data=new Object[2][1];
		data[0][0]="@gmail.com";
		data[1][0]="vino@gmail.com";
		return data;

	}*/

}
