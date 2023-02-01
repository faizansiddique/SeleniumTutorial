package actionsTest;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandlesExample {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com");

		driver.findElement(By.name("q")).sendKeys("HDFC");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

		driver.findElement(By.xpath("(//h3/a)[1]")).click();

		WebElement loginBtn = driver.findElement(By.xpath("//*[@id='custom-button']/div/a/button"));
		Thread.sleep(2000);

		Actions action = new Actions(driver);
		action.moveToElement(loginBtn).perform();
		
		System.out.println("--- Generating window Ids for First Window---");
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);
		
		WebElement netBanking = driver.findElement(By.xpath("(//a[contains(text(),'NetBanking')])[1]"));
		netBanking.click();
		Thread.sleep(3000);
		
		// SECOND WINDOW KNOW MORE
		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> itr = allWindows.iterator();
		
		while(itr.hasNext()) {
			String childWindow = itr.next();
			System.out.println(childWindow);
			if(!parentWindow.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);
				driver.findElement(By.xpath("//input[@name='fldLoginUserId']")).click();
				driver.findElement(By.xpath("//input[@name='fldLoginUserId']")).sendKeys("fsiddique");
				driver.close();
			}
		}
		
		/*
		 * System.out.println("--- Generating window Ids for Second Window---");
		 * windowID = driver.getWindowHandles(); itr = windowID.iterator();
		 * 
		 * System.out.println(itr.next()); //first Window String secondWindow =
		 * itr.next(); //Second Window System.out.println(secondWindow);
		 * Thread.sleep(2000);
		 * 
		 * driver.switchTo().window(secondWindow); Thread.sleep(4000);
		 * driver.switchTo().frame("//html/frameset/frameset/frame");
		 * driver.findElement(By.xpath("//input[@name='fldLoginUserId']")).click();
		 * driver.findElement(By.xpath("//input[@name='fldLoginUserId']")).sendKeys(
		 * "fsiddique");
		 */
		
		/*
		 * //THIRD WINDOW
		 * System.out.println("--- Generating window Ids for Second Window---");
		 * windowID = driver.getWindowHandles(); itr = windowID.iterator();
		 * 
		 * System.out.println(itr.next()); //first Window
		 * System.out.println(itr.next()); //Second Window String thirdWindow =
		 * itr.next(); //third Window System.out.println(thirdWindow);
		 * 
		 * driver.switchTo().window(thirdWindow);
		 * 
		 * driver.findElement(By.xpath("//h1[contains(text(),'Secure Banking Online')]")
		 * );
		 */		
		
	}

}
