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


public class Android_Checkout_Process_Stepdefinition extends BaseTest {

	public Android_Checkout_Process_Stepdefinition() throws IOException {
		super("Android");
			}  
	@Given("The user opens the MyRNDemo App on an Android device")
	public void the_user_opens_the_my_rn_demo_app_on_an_android_device() {
		String ActualHomePageText = waitForElement(By.xpath("//android.widget.TextView[@text=\"Products\"]")).getText();
		//System.out.println(getProperty("ExpectedHomePageText"));
		Assert.assertEquals(ActualHomePageText, "Products");
	   
	}
	@When("The user navigates to the first item in the list")
	public void the_user_navigates_to_the_first_item_in_the_list() {
		  if (driver == null) {
	            throw new IllegalStateException("Driver is not initialized. Ensure BaseTest.setUp() runs first.");
	        }

	        WebElement firstItem = waitForElement(By.xpath("(//android.view.ViewGroup[@content-desc=\"store item\"])[1]/android.view.ViewGroup[1]/android.widget.ImageView"));
	        firstItem.click();
	        String ActualProductText = waitForElement(By.xpath("//android.widget.TextView[@text=\"Sauce Labs Backpack\"]")).getText();
			Assert.assertEquals(ActualProductText, getProperty("ExpectedProductText"));

	}
	@When("The user modifies the quantity to {int}")
	public void the_user_modifies_the_quantity_to(Integer int1) {
       
		waitForElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Add To Cart\"));"));
		waitForElement(By.xpath("//android.view.ViewGroup[@content-desc=\"counter plus button\"]/android.widget.ImageView")).click();
		String ActualProductCount = waitForElement(By.xpath("//android.widget.TextView[@text=\"2\"]")).getText();
		Assert.assertEquals(ActualProductCount, getProperty("ExpectedProductCount"));
		
	}
	
	@When("The user clicks {string}")
	public void the_user_clicks(String string) {
		waitForElement(By.xpath("//android.widget.TextView[@text=\"Add To Cart\"]")).click();
		   
	}
	@When("The user navigates to the cart section")
	public void the_user_navigates_to_the_cart_section() {
		waitForElement(By.xpath("//android.view.ViewGroup[@content-desc=\"cart badge\"]/android.widget.ImageView")).click();
		String ActualCartPageText = waitForElement(By.xpath("//android.widget.TextView[@text=\"My Cart\"]")).getText();
		Assert.assertEquals(ActualCartPageText, getProperty("ExpectedCartPageText"));
		
    	waitForElement(By.xpath("//android.widget.TextView[@text=\"Proceed To Checkout\"]")).click();
    	
    	String ActualLoginPageText = waitForElement(By.xpath("(//android.widget.TextView[@text=\"Login\"])[1]")).getText();
		Assert.assertEquals(ActualLoginPageText, getProperty("ExpectedLoginPageText"));
    	

	}
	@When("The user signin with email {string} and password {string}")
	public void the_user_signin_with_email_and_password(String username, String password) {
		waitForElement(By.xpath("//android.widget.EditText[@content-desc=\"Username input field\"]")).sendKeys(username);
    	waitForElement(By.xpath("//android.widget.EditText[@content-desc=\"Password input field\"]")).sendKeys(password);
    	waitForElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Login button\"]")).click();
    	
    	String ActualCheckoutPageText = waitForElement(By.xpath("//android.widget.TextView[@text=\"Checkout\"]")).getText();
		Assert.assertEquals(ActualCheckoutPageText, getProperty("ExpectedCheckoutPageText"));

	}
	@When("The user fills in the shipping details:")
	public void the_user_fills_in_the_shipping_details(io.cucumber.datatable.DataTable dataTable) {
	    Map<String, String> data = dataTable.asMap(String.class, String.class);

	    // Fetch values dynamically from DataTable
	    String fullName = data.get("Full Name");
	    String address = data.get("Address Line 1");
	    String city = data.get("City");
	    String zipCode = data.get("Zip Code");
	    String country = data.get("Country");

	    // Fill in the fields using extracted data
	    waitForElement(By.xpath("//android.widget.EditText[@content-desc=\"Full Name* input field\"]")).sendKeys(fullName);
	    waitForElement(By.xpath("//android.widget.EditText[@content-desc=\"Address Line 1* input field\"]")).sendKeys(address);

	    // Scroll to the city field before interacting
	    waitForElement(AppiumBy.androidUIAutomator(
	        "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"City*\").instance(0))")).click();

	    waitForElement(By.xpath("//android.widget.EditText[@content-desc=\"City* input field\"]")).sendKeys(city);
	    waitForElement(By.xpath("//android.widget.EditText[@content-desc=\"Zip Code* input field\"]")).sendKeys(zipCode);
	    waitForElement(By.xpath("//android.widget.EditText[@content-desc=\"Country* input field\"]")).sendKeys(country);
	}

	
	@When("The user hits on {string}")
	public void the_user_taps_on(String string) {

		waitForElement(By.xpath("//android.widget.TextView[@text=\"To Payment\"]")).click();
	}
	@Then("The user should confirm the text {string} is displayed")
	public void the_user_should_confirm_the_text_is_displayed(String string) {
		 String expectedPaymentText = waitForElement(By.xpath("//android.widget.TextView[@text=\"Enter a payment method\"]")).getText();
	        Assert.assertEquals(expectedPaymentText, "Enter a payment method");
	        System.out.println(expectedPaymentText);

	}
	@Then("The user should locate the {string} button")
	public void the_user_should_locate_the_button(String string) {
		 String expectedReviewOrderText = waitForElement(By.xpath("//android.widget.TextView[@text=\"Review Order\"]")).getText();
	        Assert.assertEquals(expectedReviewOrderText, "Review Order");

	        System.out.println(expectedReviewOrderText);

	}


}
