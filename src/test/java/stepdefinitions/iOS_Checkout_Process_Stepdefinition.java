package stepdefinitions;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.*;
import testcode.BaseTest;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class iOS_Checkout_Process_Stepdefinition extends BaseTest {

	public iOS_Checkout_Process_Stepdefinition() throws IOException {
		super("iOS");


	}  

	@Given("The user launches the MyRNDemo App on an iOS device")
	public void the_user_launches_the_my_rn_demo_app_on_an_i_os_device() {
		String ActualHomePageText = waitForElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Products\"]")).getText();
		//System.out.println(getProperty("ExpectedHomePageText"));
		Assert.assertEquals(ActualHomePageText,getProperty("ExpectedHomePageText"));
	  
	}
	@When("The user selects the first product from the list")
	public void the_user_selects_the_first_product_from_the_list() {
		 if (driver == null) {
	            throw new IllegalStateException("Driver is not initialized. Ensure BaseTest.setUp() runs first.");
	        }

	        WebElement firstItem = waitForElement(By.xpath("//XCUIElementTypeOther[@name='Sauce Labs Backpack']"));
	        firstItem.click();
	        String ActualProductText = waitForElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Sauce Labs Backpack\"]")).getText();
			Assert.assertEquals(ActualProductText, getProperty("ExpectedProductText"));
	}
	@When("The user sets the quantity to {int}")
	public void the_user_sets_the_quantity_to(Integer int1) {
		waitForElement(By.xpath("//XCUIElementTypeOther[@name='counter plus button']")).click();
		String ActualProductCount = waitForElement(By.xpath("//XCUIElementTypeStaticText[@name=\"2\"]")).getText();
		Assert.assertEquals(ActualProductCount, getProperty("ExpectedProductCount"));
		

	}
	@When("The user taps on {string}")
	public void the_user_taps_on(String string) {
		waitForElement(By.xpath("//XCUIElementTypeOther[@name='Add To Cart button']")).click();

      
	}
	@When("The user proceeds to the cart")
	public void the_user_proceeds_to_the_cart() {

    	//waitForElement(By.xpath("//XCUIElementTypeButton[contains(@name, \"Cart\")]")).click();
    	
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	Map<String, Object> params = new HashMap<>();
    	params.put("x", 200);
    	params.put("y", 790);
    	js.executeScript("mobile: tap", params);
    	String ActualCartPageText = waitForElement(By.xpath("//XCUIElementTypeStaticText[@name=\"My Cart\"]")).getText();
		Assert.assertEquals(ActualCartPageText, getProperty("ExpectedCartPageText"));
    	
      	waitForElement(By.xpath("//XCUIElementTypeOther[@name='Proceed To Checkout button']")).click();
      	String ActualLoginPageText = waitForElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Login\"]")).getText();
		Assert.assertEquals(ActualLoginPageText, getProperty("ExpectedLoginPageText"));

      	

	}
	@When("The user login with email {string} and password {string}")
	public void the_user_login_with_email_and_password(String username, String password) {
		waitForElement(By.xpath("//XCUIElementTypeTextField[@name='Username input field']")).sendKeys(username);
    	waitForElement(By.xpath("//XCUIElementTypeSecureTextField[@name=\"Password input field\"]")).sendKeys(password+Keys.RETURN);
    	waitForElement(By.xpath("//XCUIElementTypeOther[@name=\"Login button\"]")).click();
    	
    	String ActualCheckoutPageText = waitForElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Checkout\"]")).getText();
    	//System.out.println(ActualCheckoutPageText);
		Assert.assertEquals(ActualCheckoutPageText, getProperty("ExpectedCheckoutPageText"));

	}
	@When("The user provides the shipping details:")
	public void the_user_provides_the_shipping_details(io.cucumber.datatable.DataTable dataTable) {
		
		 Map<String, String> data = dataTable.asMap(String.class, String.class);

		    // Fetch values dynamically from DataTable
		    String fullName = data.get("Full Name");
		    String address = data.get("Address Line 1");
		    String city = data.get("City");
		    String zipCode = data.get("Zip Code");
		    String country = data.get("Country");

	   	waitForElement(By.xpath("//XCUIElementTypeTextField[@name='Full Name* input field']")).sendKeys(fullName);
    	waitForElement(By.xpath("//XCUIElementTypeTextField[@name='Address Line 1* input field']")).sendKeys(address+Keys.RETURN);


   
    	waitForElement(By.xpath("//XCUIElementTypeTextField[@name='City* input field']")).sendKeys(city);
    	waitForElement(By.xpath("//XCUIElementTypeTextField[@name='Zip Code* input field']")).sendKeys(zipCode);
    	waitForElement(By.xpath("//XCUIElementTypeTextField[@name='Country* input field']")).sendKeys(country+Keys.RETURN);
// 

	}
	@When("The user presses {string}")
	public void the_user_presses(String string) {
		waitForElement(By.xpath("//XCUIElementTypeOther[@name='To Payment']")).click();

	}
	@Then("The user verifies the presence of {string}")
	public void the_user_verifies_the_presence_of(String string) {
        String expectedPaymentText = waitForElement(By.xpath("//XCUIElementTypeStaticText[@name='Enter a payment method']")).getText();
        Assert.assertEquals(expectedPaymentText, "Enter a payment method");
        System.out.println(expectedPaymentText);
      

	}
	@Then("The user should find the {string} button")
	public void the_user_should_find_the_button(String string) {
		  String expectedReviewOrderText = waitForElement(By.xpath("//XCUIElementTypeOther[@name='Review Order']")).getText();
	        Assert.assertEquals(expectedReviewOrderText, "Review Order");

	        
	        System.out.println(expectedReviewOrderText);

	}
	
}
