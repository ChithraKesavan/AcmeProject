package miniproject.acmeproject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AcmeLogin {

	@Test
	public static void acmelogin()  {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://acme-test.uipath.com/account/login/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElementById("email").sendKeys("kumar.testleaf@gmail.com",Keys.TAB);
		driver.findElementById("password").sendKeys("leaf@12");
		driver.findElementById("buttonLogin").click();
		WebElement menuoption = driver.findElementByXPath("//*[@id='dashmenu']/div[5]");
		
		Actions action = new Actions(driver);
		action.moveToElement(menuoption).perform();
		driver.findElementByPartialLinkText("Search for Vendor").click();
		driver.findElementById("vendorName").sendKeys("Blue Lagoon");
		driver.findElementById("buttonSearch").click();
	String output = driver.findElementByXPath("//*[contains(text(),'Blue')]/following-sibling::td[4]").getText();
	  System.out.println(output);  
	  driver.findElementByLinkText("Log Out").click();
		driver.close();

	}

}
