package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.WebDriverServiceImpl;

public class DuplicateLead extends WebDriverServiceImpl{

	public DuplicateLead(EventFiringWebDriver driver, ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	

	@FindBy(xpath="//input[@value='Create Lead']")
	WebElement eleCreateLead;
	
	public DuplicateLead getTitle()
	{
		verifyPartialTitle("Duplicate Lead");
		return this;
	}
	
	public ViewLead clickCreateLead()
	{
		click(eleCreateLead);
		return new ViewLead(driver, test);
		
	}
}
