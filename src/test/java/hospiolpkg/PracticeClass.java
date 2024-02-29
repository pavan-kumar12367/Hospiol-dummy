package hospiolpkg;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeClass {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
	
		List<WebElement> links=driver.findElements(By.tagName("a"));
		for(WebElement link : links) {
			String url =link.getAttribute("href");
			verifylink(url);
			
		}
		
		
	}

public static void verifylink(String url) throws Exception {
	try {

	URL linkurl = new URL(url);
	HttpURLConnection http = (HttpURLConnection)linkurl.openConnection();
	int code = http.getResponseCode();
	if(code<200 || code>=400) {
		System.out.println("Broken link "+url+"response code"+code);
	}
	else {
		System.out.println("valid link"+url+"response code"+ code);
	}
	}
	catch(Exception e){
		System.out.println("Exception while checking the link"+e.getMessage());
		
	}
}
}

