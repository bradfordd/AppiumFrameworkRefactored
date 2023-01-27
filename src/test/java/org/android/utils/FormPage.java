package org.android.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.android.utils.AndroidActions;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

public class FormPage extends AndroidActions {
	
	//AndroidDriver driver;
	
	private WebElement nameField;
	private WebElement femaleOption;
	private WebElement maleOption;
	private WebElement countryBox;
	private WebElement shopButton;
	
	
	public FormPage(AndroidDriver driver) {
		super(driver);
		nameField = driver.findElement(By.id("com.androidsample.generalstore:id/nameField"));
		maleOption = driver.findElement(By.xpath("//android.widget.RadioButton[@text='Male']"));
		femaleOption = driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']"));
		countryBox = driver.findElement(By.id("android:id/text1"));
		shopButton = driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop"));
	}
	
	public void setNameField(String name) {
		nameField.sendKeys(name);
		driver.hideKeyboard();
	}
	
	public void setActivity() throws InterruptedException {
		Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.SplashActivity");
		driver.startActivity(activity);
		Thread.sleep(10000);
	}
	
	public void setGender(String gender) {
		gender = gender.toLowerCase();
		if (gender.contains("female")) 
			femaleOption.click();
		else
			maleOption.click();
	}
	
	public void setCountryfield(String country) {
		country = country.substring(0,1).toUpperCase() + country.substring(1);
		countryBox.click();
		scrollToText(country);
		//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(country));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + country + "']")).click();
	}
	
	public ProductCatalog submitForm() {
		shopButton.click();
		return new ProductCatalog(driver);
	}
}
