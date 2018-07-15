package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.WebDriverServiceImpl;

public class FindLeads extends WebDriverServiceImpl{

	public FindLeads(EventFiringWebDriver driver, ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	

	@FindBy(xpath="(//input[@name='firstName'])[3]")
	WebElement eleFirstName;
	
	@FindBy(xpath="//button[text()='Find Leads']")
	WebElement eleSearchButton;
	
	@FindBy(xpath="(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a)[1]")
	WebElement eleResult;
		
	@FindBy(id="updateLeadForm_companyName")
	WebElement eleUpdateComp;
	
	@FindBy(xpath="//input[@value='Update']")
	WebElement eleUpdateButton;
	
	@FindBy(xpath="//span[contains(text(),comp)]")
	WebElement eleViewComp;
	//variable declarations
	public static String name;
	public static String resultFname;
	public static String leadId;
	
	@FindBy(xpath="//span[text()='Email']")
	WebElement eleEmail;
	
	@FindBy(xpath="//input[@name='emailAddress']")
	WebElement eleEmailAddress;
	
	@FindBy(xpath="(//div[@class='x-grid3-cell-inner x-grid3-col-firstName'])[1]/a")
	WebElement eleResultFname;
	
	@FindBy(xpath="//span[text()='Phone']")
	WebElement elePhoneTab;
	
	@FindBy(xpath="//input[@name='phoneNumber']")
	WebElement elePhoneNumber;
	
	@FindBy(xpath="//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")
	WebElement eleResultId;
	
	@FindBy(xpath="//input[@name='id']")
	WebElement eleSearchId;
	
	@FindBy(xpath="//div[text()='No records to display']")
	WebElement eleErrorMess;
	
	@FindBy(xpath="//input[@name='firstName']")
	WebElement eleFname;
	
	@FindBy(xpath="(//a[@class='linktext'])[1]")
	WebElement eleResultLead;
	/*
	@FindBy(xpath="(//input[contains(@class,'x-form-text x-form-field')])[28]")
	WebElement eleLeadid;*/
	
	
	public String getLead()
	{
		String lead=getText(eleResultLead);
		return lead;
	}
	
	public MergeLeads clickResultLead()
	{
		click(eleResultLead);
		return new MergeLeads(driver, test);
	}
	
	public FindLeads typefname(String fname)
	{
		type(eleFname,fname);
		return this;
	}
	public FindLeads typeLeadId(String id)
	{
		type(eleSearchId,id);
		return this;
	}
	
	public FindLeads verifyError(String error)
	{
		verifyExactText(eleErrorMess,error);
		return this;
	}
	public FindLeads clickPhoneTab()
	{
		click(elePhoneTab);
		return this;
	}
	
	public FindLeads typePhoneNumber(String phone)
	{
		type(elePhoneNumber,phone);
		return this;
	}
	
	public String getLeadId()
	{
		leadId=getText(eleResultId);
		return leadId;
	}
	
	public ViewLead clickResultId()
	{
		click(eleResultId);
		return new ViewLead(driver, test);
	}
	
	public FindLeads typeFirstName(String fname)
	{
		type(eleFirstName,fname);
		return this;

	}
	
	public FindLeads clickEmail()
	{
		click(eleEmail);
		return this;

	}
	
	public FindLeads typeEmail(String email)
	{
		type(eleEmailAddress,email);
		return this;
	}
	
	public FindLeads clickFindLeads() throws InterruptedException
	{
		click(eleSearchButton);
		Thread.sleep(3000);
		return this;

	}
	
	public ViewLead clickResult() throws InterruptedException
	{
		click(eleResult);
		Thread.sleep(20000);
		return new ViewLead(driver, test);
		

	}
	
	public String getLeadFname()
	{
		resultFname=getText(eleResultFname);
		return resultFname;
	}
	
	public ViewLead clickResultfname() throws InterruptedException
	{   
		click(eleResultFname);
		Thread.sleep(20000);
		return new ViewLead(driver, test);

	}
	
	}
