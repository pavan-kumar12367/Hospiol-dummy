package hospiol;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
public static void main(String[] args) throws Exception {
	
	System.setProperty("webdriver.chrome.driver", "D:/chromedriver-win64/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://testing.hospiol.com/site/login");
	driver.manage().window().maximize();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@id='email']")).sendKeys("sampath.marolix@gmail.com");
	driver.findElement(By.xpath("//input[@id='password']")).sendKeys("sampath@777");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[@class='btn']")).click();
	driver.findElement(By.xpath("//img[@class='topuser-image']")).click();
	Thread.sleep(2000);
	//driver.quit();
	
}
}
