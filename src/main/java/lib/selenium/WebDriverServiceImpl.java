package lib.selenium;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

import lib.listeners.WebDriverListener;

public class WebDriverServiceImpl extends WebDriverListener implements WebDriverService{
	
	public Alert alert;
	
	public List<WebElement> locateElements(String locator, String locValue)
	{
		switch(locator)
		{
    	case "id": return driver.findElements(By.id(locValue));
		
		case "class": return driver.findElements(By.className(locValue));
		
		case "link" : return driver.findElements(By.linkText(locValue));
		
		case "name" : return driver.findElements(By.name(locValue));
		
		case "xpath": return driver.findElements(By.xpath(locValue));
		
		case "tagname": return driver.findElements(By.tagName(locValue));
		
		case "css": return driver.findElements(By.cssSelector(locValue));

		default:
			break;
		}
		return null;
	}

	public WebElement locateElement(String locator, String locValue) {
		
		try {
			switch (locator) {
			case "id": return driver.findElement(By.id(locValue));
			
			case "class": return driver.findElement(By.className(locValue));
			
			case "link" : return driver.findElement(By.linkText(locValue));
			
			case "name" : return driver.findElement(By.name(locValue));
			
			case "xpath": return driver.findElement(By.xpath(locValue));
			
			case "tagname": return driver.findElement(By.tagName(locValue));
			
			case "css": return driver.findElement(By.cssSelector(locValue));

			default:
				break;
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Element not found "+locator);
		}
		return null;
	}

	public void type(WebElement ele, String data) {
		try {
			ele.sendKeys(data);
		} catch (InvalidElementStateException e) {
	System.err.println("The element " + ele +" is not ready or typing" );
		}		
	}

	public void click(WebElement ele) {
		try {
			ele.click();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Element not found "+ele );
		}		
	}
	
	public void clear(WebElement ele) {
		try {
			driver.unregister(this);
			ele.clear();		
			driver.register(this);
		} catch (NoSuchElementException e) {
			throw new RuntimeException("Element not found "+ele );
		}
	}

	public String getText(WebElement ele) {
		try {
			String text;
			text=ele.getText();
			return text;
		} catch (NoSuchElementException e) {
			throw new RuntimeException("Element not found "+ ele);
		}
	}

	public void selectDropDownUsingVisibleText(WebElement ele, String value) {
		// TODO Auto-generated method stub
		Select sel=new Select(ele);
		try {
			sel.selectByVisibleText(value);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("No Element found");
		}
        		
	}

	public void selectDropDownUsingValue(WebElement ele, String value) {
		// TODO Auto-generated method stub
		Select sel=new Select(ele);
		try {
			sel.selectByValue(value);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("No Element found");
		}
        	
		
	}

	public void selectDropDownUsingIndex(WebElement ele, int index) {
		Select sel=new Select(ele);
		try {
			sel.selectByIndex(index);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("No Element found");
		}
        	
		
	}

	public boolean verifyExactTitle(String expectedTitle) {
	
		try {
			String title;
			title=driver.getTitle();
			System.out.println(title);
			if(title.equals(expectedTitle))
			{
				System.out.println("The title displayed correctly "+title);
				return true;
			}
			else
			{
				System.out.println("Title is unavailable");
				return false;
			}
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("The element not found ");
		}
	}

	public boolean verifyPartialTitle(String expectedTitle) {
		// TODO Auto-generated method stub
		try {
			String title;
			title=driver.getTitle();
			System.out.println(title);
			if(title.contains(expectedTitle))
			{
				System.out.println("The title displayed correctly "+title);
				return true;
			}
			else
			{
				System.out.println("Title is unavailable");
				return false;
			}
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("The element not found ");
		}
	}

	public void verifyExactText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub
		try {
			String actual=getText(ele);
			if(actual.equals(expectedText))
			{
				System.out.println("The message verified successfully "+actual);
			}
		} catch (NoSuchElementException e) {
			throw new RuntimeException("No Such element to get the text" + ele);
		}
	}

	public void verifyPartialText(WebElement ele, String expectedText) {
		
		try {
			String actual=getText(ele);
			if(actual.contains(expectedText))
			{
				System.out.println("The message verified successfully "+actual);
			}
		} catch (NoSuchElementException e) {
			throw new RuntimeException("No Such element to get the text" + ele);
		}
		
	}

	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub
		try {
			String attr=ele.getAttribute(attribute);
			if(attr.equals(value))
			{
				System.out.println("Attribute is equal");
			}
			else
			{
				System.out.println("Attribute is not equal");
			}
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			System.out.println("No such attribute exception");
		}
		
	}

	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub
		try {
			String attr=ele.getAttribute(attribute);
			if(attr.contains(value))
			{
				System.out.println("Attribute is equal");
			}
			else
			{
				System.out.println("Attribute is not equal");
			}
		} catch (WebDriverException e) {
			System.err.println("No attribute exception");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void verifySelected(WebElement ele) {
		// TODO Auto-generated method stub
		boolean result=ele.isSelected();
		if(result==true)
		{
			System.out.println("Value is selected");
		}
		else
		{
			System.out.println("Value not selected");
		}
		
	}

	public void verifyDisplayed(WebElement ele) {
		boolean result=ele.isDisplayed();
		if(result==true)
		{
			System.out.println("element is displayed");
		}
		else
		{
			System.out.println("Element not displayed");
		}
		
	}

	public List<String> getWindows()
	{
		Set<String> wind = driver.getWindowHandles();
	    List<String> newwind=new ArrayList<String>();
	    newwind.addAll(wind);
	    return newwind;
	}
	/*public void switchToWindow(List<String> var,int index) {
		try {
			driver.switchTo().window(var.get(index));
		}
		catch (NoSuchWindowException e)
		{
		throw new RuntimeException("There is no window available to switch");
		}
	}*/

	public void switchToFrame(WebElement ele) {
		try 
		{
			driver.switchTo().frame(ele);
		}
		catch (NoSuchFrameException e)
		{
		throw new RuntimeException("There is no frame available to switch "+ele);
		}
		
	}

	public void acceptAlert() {
		try {
			alert = driver.switchTo().alert();
			alert.accept();
		}
		catch (NoAlertPresentException e) 
		{
			throw new RuntimeException("No such Alert is available");
		}
		catch (UnhandledAlertException e)
		{
			throw new RuntimeException("Alert is available but not handled properly");
		}
		
	}

	public void dismissAlert() {
		try {
			alert = driver.switchTo().alert();
			alert.dismiss();
		}
		catch (NoAlertPresentException e)
		{
			throw new RuntimeException("No such Alert is available");
		}
		catch (UnhandledAlertException e)
		{
			throw new RuntimeException("Alert is available but not handled properly");
		}
		
	}

	public String getAlertText() {
		String text;
		try {
			alert = driver.switchTo().alert();
			 text=alert.getText();
			} 
		catch (NoAlertPresentException e) 
		{
			throw new RuntimeException("No such Alert is available");
		}
		catch (UnhandledAlertException e)
		{
			throw new RuntimeException("Alert is available but not handled properly");
		}
		return text;
	}

	public void closeActiveBrowser() {
		try {
			driver.close();
		} catch (WebDriverException e) {
			throw new RuntimeException("Browser is already closed");			
		}
		
	}

	public void closeAllBrowsers() {
		try {
			driver.quit();
		} catch (WebDriverException e) {
			throw new RuntimeException("No browsers to close");			
		}
		
	}

	@Override
	public void switchToWindow(int index) {
		// TODO Auto-generated method stub
		try {
			List<String> windows1=getWindows();
			driver.switchTo().window(windows1.get(index));
		} catch (NoSuchWindowException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("No window to switch");
		}
		
	}

	

	
}
