package core;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox_P1 {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		Logger.getLogger("").setLevel(Level.OFF);	               // Suppress Warnings
		
		System.out.println("Browser: Firefox");

		System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver.sh");
		driver = new FirefoxDriver();

		driver.get("http://facebook.com");
		driver.manage().window().maximize();
		System.out.println("Title: " + driver.getTitle());
		
		Thread.sleep(3000);
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("nicolaevaa113@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.id("pass")).clear();
		driver.findElement(By.id("pass")).sendKeys(System.getenv("fb_password"));
		Thread.sleep(3000);
		driver.findElement(By.id("u_0_b")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='u_0_a']/div[1]/div[1]/div/a/span/span")).click();
		Thread.sleep(3000);
		String friends = driver.findElement(By.xpath("//div/div[3]/div/div[2]/div[3]/ul/li[3]/a/span[1]")).getText();
		Thread.sleep(3000);	
		driver.findElement(By.id("userNavigationLabel")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Log Out")).click();
		driver.quit();
		System.out.println("You have " + friends + " friends");
	}
}