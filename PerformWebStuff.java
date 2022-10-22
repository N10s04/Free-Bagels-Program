
//takes the survey using the 20-digit receipt code
//returns the free bagel code

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.chrome.ChromeOptions;

public class PerformWebStuff {
	static String code;

	public static String performWebStuff(String receiptCode) {		
		
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("headless");
		
		System.setProperty("webdriver.chrome.driver", "/Users/ndt/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		//launch website
		driver.navigate().to("https://www.bagelexperience.com/");
		
		//click on the first entry box and type the receipt code
		driver.findElement(By.name("CN1")).sendKeys(receiptCode);
		
		//hit continue max 30 times
		for (int i=0; i<30; i++) {
			try {
				continueSurvey(driver);
			}
			catch (org.openqa.selenium.NoSuchElementException e) {
				//whatever
			}
		}
		
		//find the "bagelcode" element and set variable code to its value
		code = driver.findElement(By.xpath("//*[@id=\"finishIncentiveHolder\"]/p[5]")).getText();
		
		//quit the driver
		driver.quit();
		
		return code;
	}
	
	public static void continueSurvey(WebDriver driver) {
		//continue
		driver.findElement(By.id("NextButton")).click();
	}

}
