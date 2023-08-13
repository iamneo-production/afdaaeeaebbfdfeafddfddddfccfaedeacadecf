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

        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals("http://www.facebook.com")) {
            System.out.println("URL redirected correctly.");
        } else {
            System.out.println("URL redirection failed.");
        }

        WebElement createAccountSection = driver.findElement(By.id("createAccountSection"));
        if (createAccountSection.isDisplayed()) {
            System.out.println("Create an account section is present.");
        } else {
            System.out.println("Create an account section is not present.");
        }

        driver.findElement(By.name("firstname")).sendKeys("John");
        driver.findElement(By.name("lastname")).sendKeys("Doe");
        driver.findElement(By.name("reg_email__")).sendKeys("example@example.com");
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("example@example.com");
        driver.findElement(By.name("reg_passwd__")).sendKeys("password123");

        Select dayDropdown = new Select(driver.findElement(By.id("day")));
        dayDropdown.selectByValue("15");

        Select monthDropdown = new Select(driver.findElement(By.id("month")));
        monthDropdown.selectByValue("6");

        Select yearDropdown = new Select(driver.findElement(By.id("year")));
        yearDropdown.selectByValue("1990");

        driver.findElement(By.cssSelector("input[value='2']")).click();

        driver.findElement(By.name("websubmit")).click();

        if (driver.getCurrentUrl().contains("https://www.facebook.com/welcome")) {
            System.out.println("Account created successfully.");
        } else {
            System.out.println("Account creation failed.");
        }

	}
	

	@AfterTest
	public void afterTest() 
	{
		driver.quit();
	}

}
