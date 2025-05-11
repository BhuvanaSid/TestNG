
// Declare the package name for organizing the class
package testNGPackage;

//Import required Selenium and TestNG classes
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

//This program helps us to understand the dependency in TestNG
public class DependencyClass {
	
	// Declare a WebDriver object that will be used in test methods
	WebDriver browserObject;
	
	// First test method to open Google
	
	@Test()
	
	public void openingGoogleSite() throws InterruptedException
	{
		
		// Set the path to the ChromeDriver executable and mentioning which driver has been used
		System.setProperty("webdriver.chrome.driver", "/Users/bhuvana/Downloads/chromedriver-mac-x64/chromedriver"); 
		
		// Instantiate the ChromeDriver, launching a new Chrome browser session
		browserObject = new ChromeDriver();
		
		 // Navigate to the Google homepage
		browserObject.get("http:www.google.com/");
		
		
		// Maximize the browser window to full screen
		browserObject.manage().window().maximize(); 
		
		 // Wait for 3 seconds (hard wait for demonstration)
		Thread.sleep(3000);
		
		// Close the browser
		browserObject.close();
		
	}
	
	// Second test method to open Twitter, runs only if openingGoogleSite() passes
	@Test(dependsOnMethods = "openingGoogleSite")
	
	public void openingTwitterSite() throws InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver", "/Users/bhuvana/Downloads/chromedriver-mac-x64/chromedriver"); //which driver and it's location
		
		// Instantiate the ChromeDriver, launching a new Chrome browser session
		browserObject = new ChromeDriver();
		
		// Navigate to the twitter homepage
		browserObject.get("https://twitter.com/");
		
		browserObject.manage().window().maximize(); //Maximize the browser window for better visibility
		
		// Wait for 3 seconds (hard wait for demonstration)
		Thread.sleep(3000);
		
		// Close the browser
		browserObject.close();
		
	}
	
	// Third test method to open Amazon, runs only if openingTwitterSite() passes
	@Test(dependsOnMethods = "openingTwitterSite")
	
	public void openingAmazonSite() throws InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver", "/Users/bhuvana/Downloads/chromedriver-mac-x64/chromedriver"); //which driver and it's location
		
		// Instantiate the ChromeDriver, launching a new Chrome browser session
		browserObject = new ChromeDriver();
		
		// Navigate to the amazon homepage
		browserObject.get("https://www.amazon.com/");
		
		browserObject.manage().window().maximize(); //Maximize the browser window  to full screen for better visibility
		
		// Wait for 3 seconds (hard wait for demonstration)
		Thread.sleep(3000);
		
		// Close the browser
		browserObject.close();
		
	}
	
	
	

}
