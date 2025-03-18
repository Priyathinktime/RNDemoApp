package testcode;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
    
    protected static AppiumDriver driver;  // Make driver generic for both Android and iOS
    private static AppiumDriverLocalService service;
    protected static Properties properties;
    public static ExtentReports extent;
    public static ExtentTest test;

    // Constructor to initialize driver based on platform
    public BaseTest(String platform) throws IOException {
        properties = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config.properties");
        properties.load(fis);
        

        if (driver == null) { // Ensure driver is initialized once
            service = new AppiumServiceBuilder()
                    .withIPAddress("127.0.0.1")
                    .withAppiumJS(new File("/Users/thinktime/.nvm/versions/node/v23.10.0/lib/node_modules/appium/build/lib/main.js")) // Correct path
                    .usingDriverExecutable(new File("/Users/thinktime/.nvm/versions/node/v23.10.0/bin/node")) // Update path
                    .usingPort(4723)
                    .withTimeout(Duration.ofSeconds(10))
                    .build();
//            service.start();

            if (platform.equalsIgnoreCase("android")) {
                UiAutomator2Options options = new UiAutomator2Options()
                        .setPlatformName("Android")
                        .setDeviceName("Pixel_3a")
                        .setApp(System.getProperty("user.dir") + "/src/test/resources/resources/Android-MyDemoAppRN.1.3.0.build-244 (1).apk")
                        .setAutomationName("UiAutomator2");

                driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
            } else if (platform.equalsIgnoreCase("ios")) {
            	XCUITestOptions options = new XCUITestOptions()
            		    .setPlatformName("iOS")  // Always use "iOS"
            		    .setDeviceName("iPhone 16") // Match an available simulator
            		    .setPlatformVersion("18.3")
            		    .setUdid("63688843-17A2-4733-B5BC-6E1411474538")// Match iOS version
            		    .setApp(System.getProperty("user.dir") + "/src/test/resources/resources/MyRNDemoApp.app") // Ensure correct path
            		    .setAutomationName("XCUITest"); // Always "XCUITest" for iOS

            		driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options); 
            } else {
                throw new IllegalArgumentException("Invalid platform: " + platform);
            }
        }
    }
    
    //Wait until element visible
    
    public static WebElement waitForElement(By locator) {
  		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
  		
  	}
    //  Get property by key
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
  


    @AfterClass
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
        if (service != null) {
            service.stop();
            service = null;
        }
    }
}
