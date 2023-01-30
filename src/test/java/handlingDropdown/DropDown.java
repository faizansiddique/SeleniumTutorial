package handlingDropdown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/select-menu");
		
		Select select = new Select(driver.findElement(By.id("oldSelectMenu")));
		List<WebElement> list = select.getOptions();
		System.out.println("The dropdown options are:");
		for(WebElement options : list) {
			System.out.println(options.getText());
		}
		
		//Selecting the option as 'Purple'-- selectByIndex
		Thread.sleep(3000);
        System.out.println("Select the Option by Index 4");
        select.selectByIndex(4);
        System.out.println("Select value is: " + select.getFirstSelectedOption().getText());

        //Selecting the option as 'Magenta'-- selectByVisibleText
        Thread.sleep(3000);
        System.out.println("Select the Option by Text Magenta");
        select.selectByVisibleText("Magenta");
        System.out.println("Select value is: " + select.getFirstSelectedOption().getText());

        //Selecting an option by its value
        Thread.sleep(3000);
        System.out.println("Select the Option by value 6");
        select.selectByValue("6");
        System.out.println("Select value is: " + select.getFirstSelectedOption().getText());

        driver.quit();
		
	}

}
