package sitePackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class siteCheck {
	public static void main(String[] args) {
        
        String url = "";
		String offer = "";
		List<String> offers = new ArrayList<String>();
		
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        
        	List<String> skinOffers = new ArrayList<String>();
        	/*aao*/skinOffers.add("aao-s-i");skinOffers.add("aao-e-i");
        	
        	/*aff*/ skinOffers.add("aff-s-i");skinOffers.add("aff-e-i");skinOffers.add("aff-s-j");skinOffers.add("aff-e-j");

        	/*lim*/ skinOffers.add("lim-s-i");skinOffers.add("lim-e-i");skinOffers.add("lim-s-j");skinOffers.add("lim-e-j");

        	//List<String> garciniaOffers = new ArrayList<String>();
        	//garciniaOffers.add("om");garciniaOffers.add("oma");
        
        	//List<String> garciniaOffers = new ArrayList<String>();
        	//garciniaOffers.add("home");
        
        	map.put("skinvtechnologies.com/", skinOffers);
        	//map.put("mypowerfulgarcinia.com/", garciniaOffers);
        	//map.put("dev2.ipartnrdev.com/home/", garciniaOffers);
    		
	//Firefox
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver",  "C:\\Selenium\\WebDrivers\\geckodriver.exe");
		driver =new FirefoxDriver();

/*---------------------------------------------------------------
*				Test Launch
*----------------------------------------------------------------*/	
	System.out.println("Launch prep");
	
	try {
		Thread.sleep(3000);
	} catch (InterruptedException el) {
		el.printStackTrace();
	}
	
	driver.get("https://www.google.com");
	driver.manage().deleteAllCookies();
	System.out.println("Ready");
	System.out.println("-----------------------------------------");
	System.out.println("----------------Start Testing------------");
	System.out.println("-----------------------------------------");
	
	for (Map.Entry<String, List<String>> entry : map.entrySet()) {
		url = entry.getKey();
		offers = entry.getValue();
	
	

/*---------------------------------------------------------------
*				Initialize
*----------------------------------------------------------------*/	
	driver.get("https://" + url + "/home");

/*---------------------------------------------------------------
*				Test Loop
*----------------------------------------------------------------*/	
	for (int i=0; i<offers.size(); i++) {
		offer = offers.get(i);
		System.out.println(offer + " Started");
		next(driver, "https://" + url + offer + "/home", offer);
		System.out.println(offer + " passed");
		System.out.println("-----------------------------------------");
	}
		
	System.out.println("---------------All Done!-----------------");
	System.out.println("---------------End Logging---------------");
	System.out.println("-----------------------------------------");
	
	}		
}

	
/*---------------------------------------------------------------
*				Method
*----------------------------------------------------------------*/	
public static void next(WebDriver driver, String url, String offer) {
	
	driver.get(url);
	
	WebDriverWait wait4 = new WebDriverWait(driver, 10);
	wait4.until(ExpectedConditions.urlContains("home"));
	
/*---------------------------------------------------------------
*				First Form
*----------------------------------------------------------------*/
	driver.findElement(By.name("zip")).sendKeys("44444");
	driver.findElement(By.name("firstName")).sendKeys(offer);
	driver.findElement(By.name("lastName")).sendKeys("testLastName");
	driver.findElement(By.name("address1")).sendKeys("123 Test Address");
	driver.findElement(By.name("phone")).sendKeys("4444444444");
	driver.findElement(By.name("email")).sendKeys("test@test.com");
	
	try {
		Thread.sleep(3000);
	} catch (InterruptedException el) {
		el.printStackTrace();
	}
	
	driver.findElement(By.name("email")).submit();
	System.out.println("First Form Completed");
	
	try {
		Thread.sleep(3000);
	} catch (InterruptedException el) {
		el.printStackTrace();
	}
	
/*---------------------------------------------------------------
*				Billing Form
*----------------------------------------------------------------*/
	driver.findElement(By.name("card")).sendKeys("1444444444444440");
	driver.findElement(By.name("month")).sendKeys("o");
	driver.findElement(By.name("year")).sendKeys("2222");
	driver.findElement(By.name("cvv")).sendKeys("444");
	
	driver.findElement(By.name("cvv")).submit();
	System.out.println("Billing Form Completed");
	
/*---------------------------------------------------------------
*				First Offer
*----------------------------------------------------------------*/
	WebDriverWait wait0 = new WebDriverWait(driver, 10);
	wait0.until(ExpectedConditions.urlContains("bonus-1"));
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.elementToBeClickable(By.className("confirm")));
	
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e1) {
		e1.printStackTrace();
	}
	
	driver.findElement(By.className("confirm")).click();
	System.out.println("First Offer Accepted");
	
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e1) {
		e1.printStackTrace();
	}
	
/*---------------------------------------------------------------
*				Second Offer
*----------------------------------------------------------------*/
	WebDriverWait wait1 = new WebDriverWait(driver, 10);
	wait1.until(ExpectedConditions.urlContains("bonus-2"));
		
	WebDriverWait wait2 = new WebDriverWait(driver, 10);
	wait2.until(ExpectedConditions.elementToBeClickable(By.className("decline")));
	
	driver.findElement(By.className("decline")).click();
	System.out.println("Second Offer Declined");
	
	driver.manage().deleteAllCookies();
	
	driver.get(url);

	}
}