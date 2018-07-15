package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import lib.selenium.WebDriverServiceImpl;

public class FlipKart extends WebDriverServiceImpl{
@Test
	public void flip() throws InterruptedException 
	{
		WebElement closebut=locateElement("xpath","//button[@class='_2AkmmA _29YdH8']");
		click(closebut);
		
		WebElement TVS=locateElement("xpath","//span[text()='TVs & Appliances']");
		WebElement sam=locateElement("xpath","(//a[@title='Samsung'])[2]");
	//	builder.moveToElement(TVS).pause(2000).perform();
		//builder.pause(2000).click(sam).perform();
		
		WebElement min=locateElement("xpath","(//select[@class='fPjUPw'])[1]");
		selectDropDownUsingValue(min,"25000");
		
		Thread.sleep(2000);
		WebElement max=locateElement("xpath","(//select[@class='fPjUPw'])[2]");
		selectDropDownUsingValue(min,"60000");
		
		Thread.sleep(5000);
		
		WebElement screen=locateElement("xpath","(//div[@class='_2yccxO D0YrLF']/preceding::div[@class='_3xglSm _1iMC4O'])[2]");
		click(screen);
		
		Thread.sleep(5000);
		WebElement selsize=locateElement("xpath","(//div[@class='_1GEhLw'])[10]");
		click(selsize);
		
		WebElement first=locateElement("xpath","(//div[@class='_3BTv9X']/img)[1]");
		click(first);
		
		WebElement price1=locateElement("xpath","(//div[@class='_1vC4OE _2rQ-NK'])[1]");
		String p1=price1.getText();
		
		
		switchToWindow(1);
		
		WebElement price2=locateElement("xpath","//div[@class='_1vC4OE _3qQ9m1']");
		String p2=price2.getText();
		
		if(p1==p2)
		{
			System.out.println("Both price are same");
		}
		
		closeActiveBrowser();
		
		switchToWindow(0);
		
		WebElement compare1=locateElement("xpath","(//label[@class='_10TB-Q']/span)[1]");
		click(compare1);
		
		WebElement compare2=locateElement("xpath","(//label[@class='_10TB-Q']/span)[2]");
		click(compare2);
		
		
		WebElement clickcomp=locateElement("xpath","(//a[@class='_1h5zc_ sTOdGz']//span)[2]");
		click(clickcomp);
		
		WebElement text=locateElement("xpath","(//div[@class='_3wM930']/span)[1]");
		String val = getText(text);
		verifyExactText(text, val);
		WebElement finalprice1=locateElement("xpath","(//div[@class='_1vC4OE'])[1]");
		String fp1=getText(finalprice1);
		String val1=fp1.replaceAll("\\D", "");
		int res1=Integer.parseInt(val1);
		
		
		WebElement finalprice2=locateElement("xpath","(//div[@class='_1vC4OE'])[2]");
		String fp2=getText(finalprice2);
		String val2=fp2.replaceAll("\\D", "");
		int res2=Integer.parseInt(val2);
		
		if(res1<res2)
			System.out.println("The lowest price is "+res1);
		else
			System.out.println("The loweset price is "+res2);
		
		
		
		
	}
}
