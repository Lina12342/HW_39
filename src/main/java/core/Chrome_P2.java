package core;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Chrome_P2 {

	static WebDriver driver;

	public static void main(String[] cla) throws InterruptedException {

		Logger.getLogger("").setLevel(Level.OFF);

		System.out.println("Browser: Chrome");

		System.setProperty("webdriver.gecko.driver", "/usr/local/bin/chromedriver");
		System.setProperty("webdriver.chrome.silentOutput", "true"); // Chrome
		ChromeOptions option = new ChromeOptions(); // Chrome
		option.addArguments("disable-infobars"); // Chrome
		option.addArguments("--disable-notifications"); // Chrome

		driver = new ChromeDriver(option);

		WebDriverWait wait = new WebDriverWait(driver, 15);
		final long start = System.currentTimeMillis();
		driver.get("http://facebook.com");
		driver.manage().window().maximize();

		System.out.println("Title: " + driver.getTitle());

		// driver.findElement(By.id("email")).sendKeys("nicolaevaa113@gmail.com");
		// Thread.sleep(3000);
		driver.findElement(By.id("email")).clear();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email"))).sendKeys("nicolaevaa113@gmail.com");
		driver.findElement(By.id("pass")).clear();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pass"))).sendKeys(System.getenv("fb_password"));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("u_0_b"))).click();

		// driver.findElement(By.xpath("//*[@id='u_0_a']/div[1]/div[1]/div/a/span/span")).click();
		// Thread.sleep(5000);
		wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='u_0_a']/div[1]/div[1]/div/a/span/span")))
				.click();

		// String friends =
		// driver.findElement(By.xpath("//div/div[3]/div/div[2]/div[3]/ul/li[3]/a/span[1]")).getText();
		// Thread.sleep(5000);
		String friends = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/div[3]/div/div[2]/div[3]/ul/li[3]/a/span[1]"))).getText().toString();

		// driver.findElement(By.id("userNavigationLabel")).click();
		// Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("userNavigationLabel"))).click();

		// driver.findElement(By.linkText("Log Out")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Log Out"))).click();
		final long finish = System.currentTimeMillis();
		driver.quit();
		System.out.println("You have " + friends + " friends");
		System.out.println("Response time: " + (finish - start) / 1000.0 + " seconds");
	}
}