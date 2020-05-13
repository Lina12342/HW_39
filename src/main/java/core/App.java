package core;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class App {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		Logger.getLogger("").setLevel(Level.OFF);
		System.setProperty("webdriver.edge.driver", "/usr/local/bin/edge");
		driver = new EdgeDriver();
		driver.get("http://alex.academy");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.quit();
	}
}