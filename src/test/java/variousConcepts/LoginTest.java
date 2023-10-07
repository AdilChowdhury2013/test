package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		LoginTest.launchChrome();
		LoginTest.positiveLoginTest();
		LoginTest.negativeLoginTest();
		LoginTest.clearBrowser();
		

	}

	public static void launchChrome() {
		// System.setProperty("webdriver.chrome.driver", "D:\\selenium installer
		// files\\chromedriver-win32");
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();

		// clear cookies
		driver.manage().deleteAllCookies();

		// maximize
		driver.manage().window().maximize();

		// manage time
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// go to website
		driver.get("https://techfios.com/billing/?ng=admin/");

	}

	public static void clearBrowser() throws InterruptedException {
		Thread.sleep(3000);
		// Close
		driver.close();

	}

	public static void positiveLoginTest() {
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.name("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();

	}

	public static void negativeLoginTest() {
		driver.findElement(By.id("username")).sendKeys("demo@techfios123.com");
		driver.findElement(By.name("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();

	}
}
