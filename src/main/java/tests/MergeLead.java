package tests;

import java.util.List;

//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
//import lib.selenium.WebDriverServiceImpl;
import pages.FindLeads;
import pages.MergeLeads;
import pages.MyHome;
import pages.MyLeads;

public class MergeLead extends PreAndPost {
	@BeforeTest
	public void sendValue()
	{
		 testCaseName="MergeLead";
	     testDesc="Merge two leads";
		 nodeName="Lead";
		 category="sanity";
		 author="Vinotha";
		excelFileName="MergeLead";
	}
	 public void clickResult1()
	   {
	   new FindLeads(driver, test)
	   .clickResultLead();
	   }
	@Test(dataProvider="Testing")//(groups= {"sanity"})
	//@Test(enabled=false)
	 public void merge(String name1,String name2) throws InterruptedException
	 {
		
		    new MyHome(driver, test)
		    .clickLeads()
		    .clickMergeLead()
		    .clickFirstImage();
		    			
		   String fromlead=	new FindLeads(driver, test)
			.typefname(name1)
			.clickFindLeads()
			.getLead();
		   
		   clickResult1();
		  	
		   new MergeLeads(driver, test)
		   .clickSecondImage();
		   
		   List<String> windows1=getWindows();
		    switchToWindow(1);
		    
		    String tolead=	new FindLeads(driver, test)
					.typefname(name2)
					.clickFindLeads()
					.getLead();
		    
		    clickResult1();
		    
		    switchToWindow(0);
			
		    String alert=getAlertText();
		    System.out.println("The displayed alert is "+ alert);
		    
		    acceptAlert();
		    
		    new MyLeads(driver,test)
		    .clickFindLead()
		    .typeLeadId(fromlead)
		    .clickFindLeads()
		    .verifyError("No records to display");
		    
			
		    /* WebElement user=locateElement("id","username");
			type(user,"DemoSalesManager");
			
			WebElement elePassword = locateElement("id", "password");
			type(elePassword, "crmsfa");
			
			WebElement eleLogin = locateElement("class", "decorativeSubmit");
			click(eleLogin);
			
			WebElement eleCRM = locateElement("link", "CRM/SFA");
			click(eleCRM);*/
			
			/*WebElement elefind = locateElement("link","Leads");
			click(elefind);
			
			Thread.sleep(2000);
			
			WebElement MerLead=locateElement("link","Merge Leads");
			click(MerLead);
			
			WebElement img1=locateElement("xpath","((//img[@src='/images/fieldlookup.gif'])[1])");
			click(img1);
			
		    List<String> windows=getWindows();
		    switchToWindow(1);
		    
		    /*WebElement fname1=locateElement("xpath","//input[@name='firstName']");
			type(fname1,name1);
			
			WebElement findbut1=locateElement("xpath","//button[text()='Find Leads']");
			click(findbut1);
		    Thread.sleep(5000);
			
		    WebElement selead1=locateElement("xpath","(//a[@class='linktext'])[1]");
		    String fromlead=selead1.getText();
		    click(selead1);
		    
		    switchToWindow(0);
		    
		    WebElement img2=locateElement("xpath","(//img[@src='/images/fieldlookup.gif'])[2]");
		    click(img2);
		    
		    List<String> windows1=getWindows();
		    switchToWindow(1);
		    
		    WebElement fname2=locateElement("xpath","//input[@name='firstName']");
		    type(fname2,name2);
		    
		    WebElement findbut2=locateElement("xpath","//button[text()='Find Leads']");
			click(findbut2);
		    Thread.sleep(5000);
		    
		    WebElement selead2=locateElement("xpath","(//a[@class='linktext'])[1]");
		    click(selead2);
		    
		    switchToWindow(0);
		    WebElement merge=locateElement("xpath","//a[text()='Merge']");
		    click(merge);
		    
		    String alert=getAlertText();
		    System.out.println("The displayed alert is "+ alert);
		    
		    acceptAlert();
		    
		    WebElement find=locateElement("xpath","//a[text()='Find Leads']");                                                                                                                                                          
		    click(find);
		    
		    WebElement checklead=locateElement("xpath","(//input[contains(@class,'x-form-text x-form-field')])[28]");
		    type(checklead,fromlead);
		    
		    WebElement buttonfind=locateElement("xpath","//button[text()='Find Leads']");
		    click(buttonfind);
		    
		    WebElement error =locateElement("class","x-paging-info");
		    verifyPartialText(error,"No records to display");
		    */
		    
		   
		    
		    /*driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		      driver.findElement(By.xpath(" //input[@class=' x-form-text x-form-field ']")).sendKeys("10087");
		      driver.findElement(By.xpath("//button[text()='Find Leads']")).click();*/
	 }

	/*private void clickResult() {
		// TODO Auto-generated method stub
		
	}*/
	
/*	@DataProvider(name="mergedata")
	public String[][] mergedata()
	{
		String[][] data=new String[1][2];
		data[0][0]="vino";
		data[0][1]="Demo";
		return data;
	}*/
}
