package hospiolpkg;


	import java.io.IOException;
	import java.net.HttpURLConnection;
	import java.net.MalformedURLException;
	import java.net.URL;
	import java.util.Iterator;
	import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class BrokenLinks {
	    
	   // private static WebDriver driver = null;

	    public static void main(String[] args) throws Exception, IOException {
	        // TODO Auto-generated method stub
	        
	        String homePage = "http://www.amazon.in";
	        
	        HttpURLConnection huc = null;
	        int respCode = 200;
	        System.setProperty("webdriver.chrome.driver", "D:/chromedriver-win64/chromedriver.exe");
	        
	        WebDriver   driver = new ChromeDriver();
	        driver.get(homePage);
	        driver.manage().window().maximize();
	        
	       
	        
	        List<WebElement> links = driver.findElements(By.tagName("a"));
	        int size =links.size();
	        System.out.println(size);
	        for (WebElement link : links) {
	            String url = link.getAttribute("href");
	          
	           System.out.println(url);
	        if(url!=null && !url.isEmpty()) {
	        	HttpURLConnection connection = (HttpURLConnection)new URL(url).openConnection();
	        	connection.setRequestMethod("HEAD");
	        	connection.connect();
	        int Responsecode=	connection.getResponseCode();
	        if(Responsecode>400) {
	        	System.out.println("BROKEN LINK "+url);
	        }
	       
	        }

	    }
	}
}
