package core;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome_P1 {

	static WebDriver driver;

	public static void main(String[] cla) throws InterruptedException {
		
		Logger.getLogger("").setLevel(Level.OFF);
		
		System.out.println("Browser: Chrome");

		System.setProperty("webdriver.gecko.driver", "/usr/local/bin/chromedriver");
		System.setProperty("webdriver.chrome.silentOutput", "true"); // Chrome
		ChromeOptions option = new ChromeOptions();                  // Chrome
		option.addArguments("disable-infobars");                     // Chrome
		option.addArguments("--disable-notifications");              // Chrome

		driver = new ChromeDriver(option);

		driver.get("http://facebook.com");
		driver.manage().window().maximize();
		System.out.println("Title: " + driver.getTitle());
		driver.findElement(By.id("email")).sendKeys("nicolaevaa113@agmail.com");
		Thread.sleep(3000);
		driver.findElement(By.id("pass")).sendKeys(System.getenv("fb_password"));
		Thread.sleep(3000);
		driver.findElement(By.id("u_0_b")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='u_0_a']/div[1]/div[1]/div/a/span/span")).click();
		Thread.sleep(3000);
		String friends = driver.findElement(By.xpath("//div/div[3]/div/div[2]/div[3]/ul/li[3]/a/span[1]")).getText();
		Thread.sleep(3000);	
		driver.findElement(By.id("userNavigationLabel")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Log Out")).click();
		driver.quit();
		System.out.println("You have " + friends + " friends");
	}
}
