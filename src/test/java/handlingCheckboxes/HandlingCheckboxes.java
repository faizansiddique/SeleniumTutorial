package handlingCheckboxes;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingCheckboxes {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.tizag.com/htmlT/htmlcheckboxes.php");
		
		WebElement block = driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]"));
		//driver.findElement(By.xpath("(//input[@name='sports'])[1]")).click();
		Thread.sleep(2000);
		
		List<WebElement> checkboxes = block.findElements(By.xpath("//input[@name='sports']"));
		System.out.println("Total Checkboxes are :: "+checkboxes.size());
		
		Thread.sleep(2000);
		for(WebElement checkbox : checkboxes ) {
			Thread.sleep(2000);
			checkbox.click();
		}
		
		driver.close();
		
	}

}
