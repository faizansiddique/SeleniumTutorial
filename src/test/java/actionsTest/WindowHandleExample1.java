package actionsTest;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandleExample1 {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/browser-windows");

		driver.findElement(By.id("windowButton")).click();
		Thread.sleep(2000);

		String mainWindowHandle = driver.getWindowHandle();
		System.out.println("Main Window Handle : " + mainWindowHandle);

		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> itr = allWindows.iterator();

		while (itr.hasNext()) {
			String childWindow = itr.next();
			System.out.println("Child Window : " + childWindow);
			if (!mainWindowHandle.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);
				WebElement text = driver.findElement(By.id("sampleHeading"));
				System.out.println("Heading of child window is : " + text.getText());
				driver.close();
			}
		}

	}

}
