package hospiolpkg;


	//import java.io.IOException;
	import java.net.HttpURLConnection;
	import java.net.URL;
	import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	//import org.openqa.selenium.interactions.Actions;

	public class BrokenImages {


	    public static void main(String[] args) {
	    	System.setProperty("webdriver.chrome.driver", "D:/chromedriver-win64/chromedriver.exe");
	    	ChromeDriver driver = new ChromeDriver();
	        driver.get("https://www.amazon.in");
	        driver.manage().window().maximize();
	         By image = By.tagName("img");
	     List<WebElement> eles= driver.findElements(image);
	 
	        for (WebElement images : eles) {
	            String imagelink= images.getAttribute("src");
	    //      System.out.println(imagelink);
	    			
	    			try {
	    				HttpURLConnection connection=(HttpURLConnection)new URL(imagelink).openConnection();
	    				connection.setRequestMethod("HEAD");
	    				
	    				connection.connect();
	    				int responseCode=connection.getResponseCode();
	    				
	    				if(responseCode<=200) {
	    					System.out.println("Broken IMAGE:"+imagelink);
	    				}
	    			}catch (Exception e) {
	    				System.out.println("Exception occured while checking URL:"+imagelink);
	    			
	    		
	    		
	    			}
	    			

	    		}
	       driver.close();
	    		}
	    
	    		
	}

