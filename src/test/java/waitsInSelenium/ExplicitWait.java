package waitsInSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWait {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("cheese" + Keys.ENTER);
		
		WebElement firstResult = new WebDriverWait(driver, 10)
		        .until(ExpectedConditions.elementToBeClickable(By.xpath("//a/h3")));
		System.out.println(firstResult.getText());
		
		driver.close();
		driver.quit();

	}

}
