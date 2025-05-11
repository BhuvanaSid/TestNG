package testNGPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SampleNG1 {
	
	
	

		
		// Declare a WebDriver instance variable to be used across test methods
		WebDriver browserObject;
		
		@Test(priority=1) //This test runs first
		public void xyz()
		{
			
			
			System.setProperty("webdriver.chrome.driver", "/Users/bhuvana/Downloads/chromedriver-mac-x64/chromedriver"); //setting the path for the driver location
			
			 browserObject =new ChromeDriver(); //object browser_object  is created
			 browserObject.manage().window().maximize(); //Maximize the browser window for better visibility
			
		}
		
		@Test(priority=2) //// This test runs after xyz
		public void abc() throws InterruptedException
		{
			
			browserObject.get("http://www.google.com"); //Navigate to Google's homepage
			
			Thread.sleep(3000); //Pause the execution for 3 seconds to allow the page to load
			
		}
		
		
		@Test(priority=3) //This test runs last
		public void pqr() 
		{
			
			browserObject.close(); //Close the browser window
			
			
		}
		
	}



