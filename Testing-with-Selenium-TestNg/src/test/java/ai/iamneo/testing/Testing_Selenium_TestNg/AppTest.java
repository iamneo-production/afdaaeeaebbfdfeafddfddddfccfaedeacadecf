package ai.iamneo.testing.Testing_Selenium_TestNg;

import org.testng.annotations.Test;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class AppTest {

	ChromeOptions chromeOptions = new ChromeOptions();
	WebDriver driver = null;

	@BeforeTest
	public void beforeTest() throws Exception
	 {
		driver = new RemoteWebDriver(new URL("http://localhost:4444"), chromeOptions);
	}

	@Test
//Checking the title of iamNeo (Home - iamneo)
	public void iamNeo() throws InterruptedException 
	{
		 driver.get("http://www.fb.com");
		 String title ="Get your title";
		Assert.assertEquals(title, "");
	}
	@Test
//Moving to FACEBOOK
	public void nextPage() throws InterruptedException 
	{
		 	
		 String title ="Get your title";
		Assert.assertEquals(title, "");

	}
	@Test
//Back to iamNeo
	public void backPage() throws InterruptedException 
	{
		 String title ="Get your title";
		Assert.assertEquals(title, "");

	}
	@Test
//Current URL
public void currentURL() throws InterruptedException 
{
		 String title ="Get your title";
		Assert.assertEquals(title, "");

}

	@AfterTest
	public void afterTest() 
	{
		driver.quit();
	}

}
