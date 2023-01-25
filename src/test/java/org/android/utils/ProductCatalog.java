package org.android.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class ProductCatalog extends AndroidActions {
	AndroidDriver driver;
	
	private List<WebElement> addToCart;
	
	private WebElement cart;
	
	public ProductCatalog(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		addToCart = driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']"));
		cart = driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart"));
	}
	
	public void addItemsToCartByIndex(int index) {
		addToCart.get(index).click();
		addToCart = driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']"));
	}
	
	public CartPage goToCartPage() throws InterruptedException {
		cart.click();
		Thread.sleep(2000);
		return new CartPage(driver);
	}
}
