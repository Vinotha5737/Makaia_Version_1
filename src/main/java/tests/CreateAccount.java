package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import lib.selenium.WebDriverServiceImpl;

public class CreateAccount extends WebDriverServiceImpl{
	
	@Test
	public void createAccount() throws InterruptedException
	{
		 //Login using username and password
		 WebElement user=locateElement("id","username");
			type(user,"DemoSalesManager");
			
			WebElement elePassword = locateElement("id", "password");
			type(elePassword, "crmsfa");
			
			WebElement eleLogin = locateElement("class", "decorativeSubmit");
			click(eleLogin);
			//click CRM/SFA link
			WebElement eleCRM = locateElement("link", "CRM/SFA");
			click(eleCRM);
			//click Accounts Tab
			WebElement acc=locateElement("link","Accounts");
			click(acc);
			//Click Create Account link
			WebElement createacc=locateElement("link","Create Account");
			click(createacc);
			//Enter the account name
			WebElement accname=locateElement("id","accountName");
			type(accname,"manojkumar");
			//Select Industry 
			WebElement ind=locateElement("name","industryEnumId");
			selectDropDownUsingVisibleText(ind,"Computer Software");
			//Select preferred currency
			WebElement currency=locateElement("id","currencyUomId");
			selectDropDownUsingVisibleText(currency,"INR - Indian Rupee");
			//Select the source
			WebElement source=locateElement("id","dataSourceId");
			selectDropDownUsingVisibleText(source,"Employee");
			//select the marketing Campaign
			WebElement Mcomp=locateElement("id","marketingCampaignId");
			selectDropDownUsingVisibleText(Mcomp,"Automobile");
			//Enter the phone number
			WebElement phone=locateElement("id","primaryPhoneNumber");
			type(phone,"9566026181");
			//Enter the email id
			WebElement mail=locateElement("id","primaryEmail");
			type(mail,"manoj@gmail.com");
			//Select the country
			WebElement count=locateElement("id","generalCountryGeoId");
			selectDropDownUsingVisibleText(count,"India");
			//Select state
			WebElement state=locateElement("id","generalStateProvinceGeoId");
			selectDropDownUsingVisibleText(state,"TAMILNADU");
			//click create account button
			WebElement create=locateElement("class","smallSubmit");
			click(create);
			//Capture the account id from the details
			WebElement captid=locateElement("xpath","//span[text()='Account Name']/following::td");
			String id=getText(captid);
			String val1=id.replaceAll("\\D", "");
			System.out.println(val1);
			//click Find Leads
			WebElement find=locateElement("link","Find Accounts");
			click(find);
			//Enter the account id in the account id text feild
			WebElement enterid=locateElement("xpath","//input[@name='id']");
			type(enterid,val1);
			//Enter the account name
			WebElement entername=locateElement("xpath","(//input[@name='accountName'])[2]");
			type(entername,"manojkumar");
			
			//Search for account details
			WebElement clickfind=locateElement("xpath","//button[text()='Find Accounts']");
			click(clickfind);
			
            Thread.sleep(3000);
            //Verify the account details using account id and account name
            WebElement verify=locateElement("xpath","//div[@class='x-grid3-cell-inner x-grid3-col-groupName']/a");
            verifyPartialText(verify,"manojkumar");
            
            WebElement verify1=locateElement("xpath","//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
            verifyExactText(verify1,val1);
            //close the browser
            closeActiveBrowser();
			
			
			//
			
			
			
	}

}
