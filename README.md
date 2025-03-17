# RNDemoApp
 Appium Setup and Running Guide

1. What the Project Does ?

The Appium Setup and Running Guide provides a comprehensive guide for setting up and running Appium for automated mobile testing on both iOS and Android platforms. It includes stepbystep instructions for configuring the necessary environment variables, installing required software like Java, Node.js, Maven, and Appium, and running tests using TestNG.

The guide also covers setting up the Appium server, starting it, and verifying that devices (both real and emulated) are connected and recognized. Additionally, it explains how to run tests on both iOS and Android devices using Appium.

2. Why the Project is Useful ?

This project is useful for anyone who is looking to automate the testing of mobile applications on iOS and Android devices. By setting up Appium, users can:

 Automate the testing process, saving time and reducing human errors during testing.
 Support testing across multiple mobile platforms, both iOS and Android, using a  framework.
 Ensure consistency in testing, as tests can be repeated with the same configurations on different devices.
 Use a free and opensource solution for mobile automation testing, which makes it accessible to everyone, from individual developers to large teams.

3. How Users Can Get Started with the Project ?
  1. Appium Setup and Running on iOS

  1.1 Path Setup

  Ensure that the following paths are set in your environment variables:

  Java Path
   Set `JAVA_HOME` to the path where Java is installed.

 Mac/Linux:
  export JAVA_HOME=/path/to/jdk  
  export PATH=$JAVA_HOME/bin:$PATH  

 Windows:
   Set `JAVA_HOME` in System Environment Variables and add `%JAVA_HOME%\bin` to the      `Path`.

 Maven Path
Set `MAVEN_HOME` to the Maven installation directory.

 Mac/Linux:
  export MAVEN_HOME=/path/to/maven  
  export PATH=$MAVEN_HOME/bin:$PATH  

 Windows:
   Set `MAVEN_HOME` in System Environment Variables and add `%MAVEN_HOME%\bin` to the `Path`.

 Homebrew Install (for macOS)
Install Homebrew if not already installed by running the following command:  
/bin/bash c "$(curl fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"

 Node Path
Install Node.js (which includes npm):  
brew install node  


Or using nvm (Node Version Manager):  
nvm install node  
nvm use node  

Ensure `npm` is installed and accessible:  
npm v

 Appium Path
Install Appium globally:  
npm install g appium  

Verify Appium installation:  
appium v

2. Android Working

 2.1 In Script: Add Path to main.js
In your Appium script, ensure you reference the correct path to the main.js file:  
var appium = require('/path/to/appium/main.js');

 2.2 Android Home Path Setup
Set `ANDROID_HOME` to the location where the Android SDK is installed:

 Mac/Linux:
  export ANDROID_HOME=/path/to/android/sdk  
  export PATH=$ANDROID_HOME/tools:$ANDROID_HOME/platformtools:$PATH  

 Windows:
   Set `ANDROID_HOME` in System Environment Variables and add `ANDROID_HOME/tools` and `ANDROID_HOME/platformtools` to the `Path`.

 2.3 Android Studio SDK Path Setup
Ensure that the Android SDK path is correctly configured in Android Studio. Check the SDK path in Android Studio and set it in the environment variable if needed.

 2.4 Appium Terminal On
To start the Appium server, run the following command in a new terminal window:  
appium  

This will start the Appium server, and you'll see logs indicating that Appium is running and waiting for connections.

 2.5 Manually Check Devices in New Terminal
To list all connected devices, run:  
adb devices  

This will show all devices/emulators connected to your system.

 2.6 Run as TestNG
If you're using TestNG for running tests, ensure that TestNG is added to your pom.xml:  
<dependency>  
    <groupId>org.testng</groupId>  
    <artifactId>testng</artifactId>  
    <version>7.0.0</version>  
    <scope>test</scope>  
</dependency>  

Run your tests using Maven:  
mvn test

3. iOS Working

 3.1 In Script: Add Path to main.js
In your Appium script, ensure you reference the correct path to the main.js file:  
var appium = require('/path/to/appium/main.js');

 3.2 Appium Terminal On
To start the Appium server, run the following command in a terminal window:  
appium  

This will start the Appium server for iOS testing.

 3.3 List of Devices
To list available iOS devices and simulators, run:  
xcrun simctl list devices  

This will show all available iOS devices and simulators on your system.

 3.4 Insecure WebView
To allow Appium to interact with Insecure WebViews, start the Appium server with the `allowinsecure=webview` flag:  
appium allowinsecure=webview  

This will allow Appium to bypass security restrictions on insecure webviews and interact with them during tests.

 3.5 Run as TestNG
If you're using TestNG for running iOS tests, ensure that TestNG is added to your pom.xml:  
<dependency>  
    <groupId>org.testng</groupId>  
    <artifactId>testng</artifactId>  
    <version>7.0.0</version>  
    <scope>test</scope>  
</dependency>  

Run your iOS tests using Maven:  
mvn test

Support Documents
 [Appium Documentation](https://appium.io/docs/)
 [TestNG Documentation](https://testng.org/doc/)
 [Node.js Documentation](https://nodejs.org/en/docs/)
 [Android Studio Documentation](https://developer.android.com/studio)





