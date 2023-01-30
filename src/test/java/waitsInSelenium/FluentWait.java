package waitsInSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWait {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("cheese" + Keys.ENTER);
		
		/*
		 * Wait<WebDriver> wait = new FluentWait<WebDriver>(driver) .withTimeout(30,
		 * TimeUnit.SECONDS) .pollingEvery(5, TimeUnit.SECONDS)
		 * .ignoring(NoSuchElementException.class);
		 */
				
	}

}
