package actionsTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SliderExample {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/resources/demos/slider/default.html");
		
		WebElement mainSlider = driver.findElement(By.id("slider"));
		int centre = mainSlider.getSize().width/2;
		
		WebElement slider = driver.findElement(By.xpath("//*[@id='slider']/span"));
		
		new Actions(driver).dragAndDropBy(slider, centre, 0).perform();
	}

}
