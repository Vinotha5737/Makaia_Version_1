package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.WebDriverServiceImpl;

public class OpenTapsCRM extends WebDriverServiceImpl{

	public OpenTapsCRM(EventFiringWebDriver driver, ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);//why the above two lines should be placed before this code????
		
	}
	
	
	@FindBy(id="updateLeadForm_companyName")
	WebElement eleUpdateComp;
	
	@FindBy(xpath="//input[@value='Update']")
	WebElement eleUpdateButton;
	
	
	public static String name;
	
	public OpenTapsCRM clearCompanyName()
	{
		
	    clear(eleUpdateComp);
	    return this;

	}
	
	public OpenTapsCRM typeCompanyName(String comp)
	{
	    type(eleUpdateComp,comp);
		return this;

	}
	
	
	
	public ViewLead clickUpdate()
	{
		click(eleUpdateButton);
		return new ViewLead(driver, test);

	}
	
	
}
