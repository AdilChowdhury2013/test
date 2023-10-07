package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest_Junit {

	WebDriver driver;

	@Before
	public void launchChrome() {
		System.out.println("launchChrome");

		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();

		// clear cookies
		driver.manage().deleteAllCookies();

		// go to website
		driver.get("https://techfios.com/billing/?ng=admin/");

		// maximize
		driver.manage().window().maximize();

		// manage time
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@After
	public void clearBrowser() throws InterruptedException {
		System.out.println("clearbrowser");

		Thread.sleep(3000);
		// Close
		driver.close();
		driver.quit();
	}

	@Test
	public void positiveLoginTest() {
		System.out.println("positiveLoginTest");
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.name("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();
	}

	@Test
	public void negativeLoginTest() {
		System.out.println("negativeLoginTest");
		driver.findElement(By.id("username")).sendKeys("demo@techfios123.com");
		driver.findElement(By.name("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();
	}
	
	

}
