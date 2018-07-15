package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lib.selenium.WebDriverServiceImpl;

public class CreateLeads extends WebDriverServiceImpl{

	public CreateLeads(EventFiringWebDriver driver, ExtentTest test)
	{
		this.driver=driver;
	    this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	public static String name;
	
	@FindBy(id="createLeadForm_companyName")
	WebElement eleCompany;
	
	//@And("Enter Company name (.*)")	
	public CreateLeads typeCompanyName(String company)
	{
		type(eleCompany,company);
		return this;

	}
	
	@FindBy(id="createLeadForm_firstName")
	WebElement eleFirstName;
	//@And("Enter FirstName (.*)")
	public CreateLeads typeFirstName(String firstName)
	{
		name = firstName;
		type(eleFirstName,firstName);
		return this;

	}
	
	@FindBy(id="createLeadForm_lastName")
	WebElement eleLastName;
	//@And("Enter LastName (.*)")
	public CreateLeads typeLastName(String lastName)
	{
		type(eleLastName,lastName);
		return this;

	}
	
	@FindBy(name="submitButton")
	WebElement eleCreateLead;
	
	//@When("Click create Lead button")
	public ViewLead clickCreateLead()
	{
		click(eleCreateLead);
		return new ViewLead(driver, test);

	}
	
	//@Then("New lead should be created")
	 public void successMessage()
	 {
		 System.out.println("New Lead created successfully");
	 }
}
