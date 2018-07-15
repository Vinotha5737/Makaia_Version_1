package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.WebDriverServiceImpl;

public class ViewLead extends WebDriverServiceImpl{

	//CreateLead cl=new CreateLead();
	public ViewLead(EventFiringWebDriver driver, ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="viewLead_firstName_sp")
	WebElement eleViewLeads;
	
	@FindBy(xpath="//a[text()='Edit']")
	WebElement eleClickEdit;
	
	@FindBy(xpath="//span[contains(text(),comp)]")
	WebElement eleViewComp;
	
	@FindBy(xpath="//a[text()='Duplicate Lead']")
	WebElement eleDuplicate;
	
	@FindBy(id="viewLead_firstName_sp")
	WebElement eleVerifyDuplicate;
	
	@FindBy(xpath="//a[text()='Delete']")
	WebElement eleDeleteButton;
	
	public MyLeads clickDeleteButton()
	{
		click(eleDeleteButton);
		return new MyLeads(driver, test);
		
	}
	public ViewLead verifyLead()
	{
		verifyExactText(eleViewLeads,CreateLeads.name);
		return this;
	}
	
	public OpenTapsCRM clickEditButton()
	{
	click(eleClickEdit);
	return new OpenTapsCRM(driver, test);
	}
	
	public DuplicateLead clickDuplicateButton()
	{
	click(eleDuplicate);
	return new DuplicateLead(driver, test);
	}
	
	public ViewLead verifyComp(String comp)
	{
		verifyExactText(eleViewComp,comp);
		return this;
	}
	
	public ViewLead verifyDuplicate(String resultfname)
	{
		verifyExactText(eleVerifyDuplicate,resultfname);
		return this;
	}
}
