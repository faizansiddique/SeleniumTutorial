package handlingWebTable;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingWebTable {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://money.rediff.com/gainers/bse/daily/groupall");
		
		//table[@class='dataTable']/tbody/tr
		//table[@class='dataTable']/tbody/tr[1]/td
		
		List<WebElement> rowNums =  driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
		System.out.println(rowNums.size());
		
		List<WebElement> colNums =  driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr[1]/td"));
		System.out.println(colNums.size());
		
		for(int row=1; row<=rowNums.size(); row++) {
			
			for(int col=1; col<=colNums.size(); col++) {
				System.out.print(driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+row+"]/td["+col+"]")).getText()+"      ");
			}
			
			System.out.println();
		}
		

	}

}
