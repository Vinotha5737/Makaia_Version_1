package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.WebDriverServiceImpl;

public class MergeLeads extends WebDriverServiceImpl{

	public MergeLeads(EventFiringWebDriver driver, ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
	    PageFactory.initElements(driver,test);
	  
	}
	
	List<String> windows=getWindows();
	
	@FindBy(xpath="((//img[@src='/images/fieldlookup.gif'])[1])")
	WebElement eleFirstImage;
	
	@FindBy(xpath="//img[@src='/images/fieldlookup.gif'])[2]")
	WebElement eleSecondImage;
	
	@FindBy(xpath="//a[text()='Merge']")
	WebElement eleMergeButton;
	
	//WebDriverWait wdw=new WebDriverWait(driver, 1000);
	
			
	
	public MergeLeads clickMerge()
	{
		click(eleMergeButton);
		return this;
	}
	
	
	public FindLeads clickFirstImage()
	{
		click(eleFirstImage);
		switchToWindow(1);
		//wdw.until(ExpectedConditions.elementToBeClickable(eleFirstImage));
		return new FindLeads(driver, test);
	}
	
	public MergeLeads clickSecondImage()
	{
		click(eleSecondImage);
		//wdw.until(ExpectedConditions.elementToBeClickable(eleSecondImage));
		return this;
	}
	
	
	
}
