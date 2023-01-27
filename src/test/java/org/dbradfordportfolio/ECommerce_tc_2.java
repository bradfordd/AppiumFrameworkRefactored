package org.dbradfordportfolio;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

public class ECommerce_tc_2 extends EcommerceBaseTest{

	@BeforeMethod
	public void preSetup() throws InterruptedException {
		//screen to home page
		Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.SplashActivity");
		driver.startActivity(activity);
		Thread.sleep(5000);
	}
	
	@Test
	public void FillForm() throws InterruptedException {
//		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Rahul Shetty");
//		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Male']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Cambodia\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Cambodia']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("Text");
		Assert.assertEquals(toastMessage, "Please enter your name");
		Thread.sleep(3000);
	}
	
	@Test
	public void FillForm_PositiveFlow() throws InterruptedException {
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Rahul Shetty");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Male']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Cambodia\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Cambodia']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Assert.assertTrue(driver.findElements(By.xpath("(//android.widget.Toast)[1]")).size() < 1);
		//String toastMessage = driver.findElements(By.xpath("(//android.widget.Toast)[1]")).size();
		//Assert.assertEquals(toastMessage, "Please enter your name");
		Thread.sleep(3000);
	}
	
	
}
