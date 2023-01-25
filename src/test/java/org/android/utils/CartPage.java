package org.android.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class CartPage extends AndroidActions {
	
	AndroidDriver driver;
	
	private List<WebElement> productList;
	
	private WebElement totalAmount;
	
	//private String displaySum;
	
	private WebElement terms;
	
	private WebElement acceptButton;
	
	private WebElement proceed;
	
	private WebElement checkBox;
	
	public CartPage(AndroidDriver driver)  {
		super(driver);
		this.driver = driver;
		productList = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		totalAmount = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl"));
		terms = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		//acceptButton = driver.findElement(By.id("android:id/button1"));
		proceed = driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed"));
		checkBox = driver.findElement(AppiumBy.className("android.widget.CheckBox"));
	}
	public List<WebElement> getProductList() {
		return productList;
	}
	
	public double getProductsSum() {
		int count = productList.size();
		double totalSum = 0;
		for (int i = 0; i < count; i++) {
			String amountString = productList.get(i).getText();
			Double price = getFormattedAmount(amountString);
			totalSum = totalSum + price;
		}
		return totalSum;
	}
	
	public Double getTotalAmountDisplayed() {
		return getFormattedAmount(totalAmount.getText());
	}
	
	public void acceptTermsConditions() {
		longPressAction(terms);
		acceptButton = driver.findElement(By.id("android:id/button1"));
		acceptButton.click();
	}
	
	public Double getFormattedAmount(String amount) {
		Double price = Double.parseDouble(amount.substring(1));
		return price;
	}
	
	public void submitOrder() {
		proceed = driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed"));
		checkBox = driver.findElement(AppiumBy.className("android.widget.CheckBox"));
		checkBox.click();
		proceed.click();
	}
}
