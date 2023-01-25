package org.dbradfordportfolio;

import java.time.Duration;
import java.util.List;

import org.android.utils.CartPage;
import org.android.utils.FormPage;
import org.android.utils.ProductCatalog;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class ECommerce_tc_4 extends EcommerceBaseTest {
	@Test
	public void FillForm() throws InterruptedException {
		formPage.setNameField("Dylan Bradford");
		formPage.setGender("male");
		formPage.setCountryfield("Cambodia");
		ProductCatalog productCatalog = formPage.submitForm();
		productCatalog.addItemsToCartByIndex(0);
		productCatalog.addItemsToCartByIndex(0);
		//productCatalog.goToCartPage();
		CartPage cartPage = productCatalog.goToCartPage(); 
		
		Thread.sleep(2000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		
		double sum = cartPage.getProductsSum();
		double displaySum = cartPage.getTotalAmountDisplayed();
		Assert.assertEquals(sum, displaySum);
		cartPage.acceptTermsConditions();
		cartPage.submitOrder();
	    Thread.sleep(2000);
	     
	}
}
