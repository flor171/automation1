package com.selenium;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class example1 {
	WebDriver driver;
	@Test
	public void enterDataTextField() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\flor.rada\\eclipse-workspace\\selenium\\drivers\\chromedriver.exe")
		driver = new ChromeDriver();
		//amazon page 
		driver.get("https://www.amazon.com.mx/");
		//Enter Samsung s9 Search
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("Samsung s9");;
		//Select first option displayed 
		driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[4]/div[1]/div[1]/div/span/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/h2")).click();
		//store price 
		driver.manage().window().maximize();
		List<WebElement> listOfOptions = driver.findElements(By.xpath(".//*[@id='content']/section/section/div[5]/div[2]"));
		for(WebElement listOfOption :listOfOptions ){
		System.out.println(listOfOption.getText());
	}
		//add to cart
		driver.findElement(By.xpath("//*[@id=\"wishListMainButton-announce\"]")).click();
		
		//Go to Amazon main page 
		driver.findElement(By.xpath("//*[@id=\"nav-logo\"]/a[1]")).click();
		//Click on "Create Your Amazon Account" 
		driver.findElement(By.xpath("//*[@id=\"a-autoid-0-announce\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"createAccountSubmit\"]")).click();
		//Fill all the fields and do not click on Create your Amazon account button
		driver.findElement(By.id("ap_customer_name")).sendKeys("Flor Gonzalez");;
		driver.findElement(By.id("ap_email")).sendKeys("flor.gonzalez@gmail.com");;
		driver.findElement(By.id("ap_password")).sendKeys("12345678S");;
		driver.findElement(By.id("ap_password_check")).sendKeys("12345678S");;
		Assert.assertEquals("Crear cuenta",driver.findElement(By.xpath("//*[@id=\"ap_register_form\"]/div/div/h1")).getText());  
		
}
