package testngPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPriorityAnnotation {

	// Declare WebDriver object at class level to be accessible in all test methods
	WebDriver browserObject;
		
	
	// TestNG test method with Before Test: This method runs first and sets up the browser
		@BeforeTest
		public void setUp() throws InterruptedException
		{
			
			
			// Set the path for the ChromeDriver executable
			System.setProperty("webdriver.chrome.driver", "/Users/bhuvana/Downloads/chromedriver-mac-x64/chromedriver"); //which driver and it's location
			
			// Initialize Chrome browser instance
			browserObject = new ChromeDriver();
			
			// Open the website URL in the browser using get method
			browserObject.get("http://demo.itlearn360.com/");
			
			//Maximize the browser window  to full screen for better visibility
			browserObject.manage().window().maximize(); 
			
	        // Pause execution for 3 seconds to allow page to load
			Thread.sleep(3000);
			
			
		}
		
		
		// TestNG test method with priority 1: This method runs after setUp and performs login
		@Test(priority=1)
		public void verify()
		{
			
			// Locate the login label/button by its ID and click it to open the login form
			WebElement loginImage = browserObject.findElement(By.id("loginlabel"));
			loginImage.click();
			
			// Locate the username input field and enter the username
			WebElement userName = browserObject.findElement(By.id("user_login"));
			userName.sendKeys("Demo12");
			
			
			// Locate the password input field and enter the password
			WebElement pass = browserObject.findElement(By.id("user_pass"));
			pass.sendKeys("Test123456$");
			
			// Locate the submit/login button by its name and click it
			WebElement sub=browserObject.findElement(By.name("wp-submit"));
			sub.click();
			
		}
	
		// TestNG test method with priority 2: This method logs out after login is done
		@Test(priority=2)
		public void logoutProcess() throws InterruptedException
		{
			
			// Wait for 3 seconds to ensure page and user data is fully loaded
			Thread.sleep(3000);
			
			// Locate the logout icon or menu by its XPath and click to open logout options
			WebElement logoutImage=browserObject.findElement(By.xpath("//*[@id=\"gk-login-toggle\"]/i"));
			logoutImage.click();
			
			// Wait for 3 seconds to allow the logout dropdown to appear
			Thread.sleep(3000);
			
			// Locate the "Logout" link by XPath in the dropdown and click it
			WebElement logoutclick=browserObject.findElement(By.xpath("//*[@id=\"login_drop_panel\"]/div/ul/li[3]/a "));
			logoutclick.click();
			
			
		}
	
		@AfterTest
		public void tearDown() {
			
			browserObject.close();
		}
		
	
	
	
}
