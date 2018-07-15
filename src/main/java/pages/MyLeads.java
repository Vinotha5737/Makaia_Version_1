package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.And;
import lib.selenium.WebDriverServiceImpl;

public class MyLeads extends WebDriverServiceImpl{

	public MyLeads(EventFiringWebDriver driver, ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
		
	
	@FindBy(linkText="Merge Leads")
	WebElement eleMergeLead;

	
	public MergeLeads clickMergeLead()
	{
		click(eleMergeLead);
		//wdw.until(ExpectedConditions.elementToBeClickable(eleFirstImage));
		return new MergeLeads(driver, test);

	}
	
	@FindBy(linkText="Create Lead")
	WebElement eleCreateLead;
	
	@And("Click Create Lead link")
	public CreateLeads clickCreateLead()
	{
		click(eleCreateLead);
		return new CreateLeads(driver,test);

	}
	
	@FindBy(linkText="Find Leads")
	WebElement eleFindLeads;
	public FindLeads clickFindLead()
	{
		click(eleFindLeads);
		return new FindLeads(driver,test);

	}
	
}
