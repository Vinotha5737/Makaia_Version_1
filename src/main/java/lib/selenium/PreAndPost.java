package lib.selenium;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import dataReporter.ExcelReader;

public class PreAndPost extends WebDriverServiceImpl{
	public String excelFileName,testCaseName,testDesc,nodeName,author,category;
	
	@Parameters({"URL","userName"})
	@BeforeMethod
	public void beforeMethod(String url,String uName) {
		//for reports
		startTestModule(nodeName);
		test.assignAuthor(author);
		test.assignCategory(category);
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		webdriver = new ChromeDriver();
		driver = new EventFiringWebDriver(webdriver);
		driver.register(this);
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		type(locateElement("id", "username"), uName);	
		type(locateElement("id", "password"), "crmsfa");
		click(locateElement("class", "decorativeSubmit"));
		click(locateElement("link", "CRM/SFA"));
	}

	@AfterMethod
	public void afterMethod() {
		closeActiveBrowser();
	}

	@BeforeClass
	public void beforeClass() {
		startTestCase(testCaseName,testDesc);		
	}

	@AfterClass
	public void afterClass() {
		System.out.println("afterClass");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("beforeTest");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("afterTest");
	}

	@BeforeSuite
	public void beforeSuite() {
		startReport();
	}


	@AfterSuite
	public void afterSuite() {
		endResult();
	}
 
	@DataProvider(name="Testing")
    public String[][] getData() throws IOException
    {
    	ExcelReader reader=new ExcelReader();
    	String[][] data = reader.readExcel(excelFileName);
    	
    	/*data[0][0]="IBM";
    	data[0][1]="Prathyusha";
    	data[0][2]="K";
    	data[0][3]="PK@gmail.com";
    	data[0][4]=989487534;
    	
    	data[1][0]="CTS";
    	data[1][1]="Vinotha";
    	data[1][2]="T";
    	data[1][3]="vino@gmail.com";
    	data[1][4]=765843533;*/
    	
    	
    	return data;
    }
	
	
	
	
	
	
	
	
	
}
