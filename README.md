Appium Setup and Usage Guide (Android & iOS) - Java

Prerequisites

Ensure you have the following installed on your machine before setting up Appium:

General Requirements

Java JDK (8 or later)

Maven

Node.js and npm

Appium Server

Appium Desktop (optional, for GUI control)

Appium Inspector

Android Requirements

Android Studio

Android SDK & ADB

Set environment variables for Android SDK

Enable Developer Mode & USB Debugging on the Android device

App APK file for testing

iOS Requirements (Mac Only)

macOS with Xcode

Carthage (Dependency Manager)

WebDriverAgent setup

iOS Device or Simulator

Provisioning Profile & Signing Certificate (For real device testing)

Project Setup

Create a Maven Project

Configure required dependencies

Writing Test Scripts

Initialize Appium Driver

Set Desired Capabilities for Android and iOS

Perform UI interactions using Appium commands

Implement assertions for validation

Running Tests

Start Appium Server

Execute tests using Maven or TestNG

Troubleshooting

Android

Ensure the emulator/device is connected

Verify Appium Server is running

Use UIAutomatorViewer for element inspection

iOS

Verify WebDriverAgent is set up

Trust the developer profile on the device

Ensure the bundle ID matches the installed app

Conclusion
