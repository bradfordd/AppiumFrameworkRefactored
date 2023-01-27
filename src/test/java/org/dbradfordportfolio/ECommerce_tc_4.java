package org.dbradfordportfolio;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.android.utils.CartPage;
import org.android.utils.FormPage;
import org.android.utils.ProductCatalog;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

public class ECommerce_tc_4 extends EcommerceBaseTest {
	
	@Test(dataProvider="getData")
	public void FillForm(String name, String gender, String country) throws InterruptedException {
		formPage = new FormPage(driver);
		formPage.setNameField(name);
		formPage.setGender(gender);
		formPage.setCountryfield(country);
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
	
	@BeforeMethod
	public void preSetup() throws InterruptedException {
		formPage.setActivity();
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		//System.out.println(System.getProperty("user.dir") +"//src//test//java//org//dbradfordportfolio//testData//eCommerce.json");
		return new Object[][] { {"Dylan Bradford", "Male", "Cambodia"},  {"Monica Bradford", "female", "Argentina"} };
//		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") +"//src//test//java//org//dbradfordportfolio//testData//eCommerce.json");
//		return new Object[][] { {data.get(0)},   {data.get(1)} };
	}
	
	// { {hash}, {hash} } 
}
