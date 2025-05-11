package testNGPackage; // Declare the package name for the class

//Import TestNG classes required for annotations and skip exception
import org.testng.SkipException;
import org.testng.annotations.Test;


//Define the class that contains test methods

public class TestCasePhases {

	// Demonstrating enabling/disabling/skipping of test cases in TestNG
	
	@Test(enabled=false)  // This test method is disabled and will not be executed by TestNG
	void test1()
	
	{
		System.out.println("The test case disabled");
	}

	
	@Test  //This test method is enabled and will be executed by TestNG (By default it is always enabled if we don't mention "enabled =false"
	void test2()

	{
	System.out.println("The test case enabled");
	
	}

	
	// This test method is also enabled, but will be skipped programmatically
	
	@Test 
	void test3()
	
	{
		
		System.out.println("Skip the test case"); // This message will be printed before the test is skipped
		
		throw new SkipException("I am skipping the test case"); // This throws a SkipException to instruct TestNG to skip this test at runtime
	}

	
	
}
