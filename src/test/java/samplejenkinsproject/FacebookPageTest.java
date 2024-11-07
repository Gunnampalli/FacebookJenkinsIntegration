package samplejenkinsproject;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FacebookPageTest {
	WebDriver driver = null;

	@BeforeMethod
	@Parameters("browser")
	public void setUp(String browser) throws MalformedURLException {
		if(browser.equalsIgnoreCase("chrome"))
		{
		ChromeOptions opt = new ChromeOptions();
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), opt);
		}
		driver.get("https://facebook.com");
	}

	@Test
	public void validateTitle() {
		Assert.assertEquals(driver.getTitle(), "Facebook – log in or sign up");
	}

	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
}
