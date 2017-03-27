package refresh;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.ie.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class hjRefresh {
	public static void main(String[]args) {
		
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver",  "C:\\Selenium\\WebDrivers\\geckodriver.exe");
		driver =new FirefoxDriver();
		
		driver.get("https://insights.hotjar.com/sites/327726/playbacks/list");
		
		driver.findElement(By.id("email")).sendKeys("devops@ipartnr.com");
		driver.findElement(By.id("password")).sendKeys("$X^F34^ye3&A");
		driver.findElement(By.id("password")).submit();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException el) {
			el.printStackTrace();
		}
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("social")));
		
		next(driver, "https://insights.hotjar.com/sites/327726/playbacks/list");
		System.out.println("1/9 Done!");
		next(driver, "https://insights.hotjar.com/sites/196620/playbacks/list");
		System.out.println("2/9 Done!");
		next(driver, "https://insights.hotjar.com/sites/196621/playbacks/list");
		System.out.println("3/9 Done!");
		next(driver, "https://insights.hotjar.com/sites/196619/playbacks/list");
		System.out.println("4/9 Done!");
		next(driver, "https://insights.hotjar.com/sites/227854/playbacks/list");
		System.out.println("5/9 Done!");
		next(driver, "https://insights.hotjar.com/sites/196624/playbacks/list");
		System.out.println("6/9 Done!");
		next(driver, "https://insights.hotjar.com/sites/196626/playbacks/list");
		System.out.println("7/9 Done!");
		next(driver, "https://insights.hotjar.com/sites/196623/playbacks/list");
		System.out.println("8/9 Done!");
		next(driver, "https://insights.hotjar.com/sites/319646/playbacks/list");
		System.out.println("9/9 Done!");
		
		driver.quit();
		System.out.println("All Done!");
		
	}
	
	public static void next(WebDriver driver, String url) {
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException el) {
			el.printStackTrace();
		}
		
		if (driver.findElement(By.id("stop-recording")).isDisplayed())
		{
		 driver.findElement(By.id("stop-recording")).click();
			 WebDriverWait wait3 = new WebDriverWait(driver, 10);
			 wait3.until(ExpectedConditions.elementToBeClickable(By.id("record-visitors")));
			 driver.findElement(By.id("record-visitors")).click();
			 WebDriverWait wait1 = new WebDriverWait(driver, 10);
			 wait1.until(ExpectedConditions.elementToBeClickable(By.id("section-review")));
		}else
		{
		 driver.findElement(By.id("record-visitors")).click();
			WebDriverWait wait1 = new WebDriverWait(driver, 10);
			wait1.until(ExpectedConditions.elementToBeClickable(By.id("section-review")));
		}
				
		driver.findElement(By.id("section-review")).click();
				WebDriverWait wait2 = new WebDriverWait(driver, 10);
				wait2.until(ExpectedConditions.elementToBeClickable(By.id("start-recording")));
				
				driver.findElement(By.id("start-recording")).click();
					
				driver.get(url);
	}
}
