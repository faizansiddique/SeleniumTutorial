package handlingDropdown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingMultipleDropdown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/select-menu");

		Select select = new Select(driver.findElement(By.id("cars")));
		List<WebElement> list = select.getOptions();

		for (WebElement option : list) {
			System.out.println(option.getText());
		}

		if (select.isMultiple()) {
			Thread.sleep(2000);
			System.out.println("Select option Opel by Index");
			select.selectByIndex(2);

			Thread.sleep(2000);
			System.out.println("Select option Audi by Text");
			select.selectByVisibleText("Audi");

			Thread.sleep(2000);
			System.out.println("The selected values in the dropdown options are -");

			List<WebElement> selectedOptions = select.getAllSelectedOptions();

			for (WebElement selectedOption : selectedOptions)
				System.out.println(selectedOption.getText());
			
			Thread.sleep(2000);
			System.out.println("DeSelect option Audi by Index");
            select.deselectByIndex(3);
            
            Thread.sleep(2000);
            System.out.println("Select option Opel by Text");
            select.deselectByVisibleText("Opel");
            
            Thread.sleep(2000);
            System.out.println("The selected values after deselect in the dropdown options are -");
            List<WebElement> selectedOptionsAfterDeselect = select.getAllSelectedOptions();

            for(WebElement selectedOptionAfterDeselect: selectedOptionsAfterDeselect)
                System.out.println(selectedOptionAfterDeselect.getText());

            select.deselectAll();
            
            driver.close();
            driver.quit();

		}

	}

}
