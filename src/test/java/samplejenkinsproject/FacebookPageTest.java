package samplejenkinsproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FacebookPageTest {
	WebDriver driver = null;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
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
