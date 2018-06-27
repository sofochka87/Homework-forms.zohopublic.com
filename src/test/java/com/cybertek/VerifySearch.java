package com.cybertek;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String url = "http://Etsy.com";
		driver.get(url);
		
		String searchTerm = "fathers day gift";
		//driver.findElement(By.id("search-query")).clear();
		//driver.findElement(By.id("search-query")).sendKeys(searchTerm);
		
		WebElement input = driver.findElement(By.id("search-query"));
		input.sendKeys(searchTerm + Keys.ENTER);
		//locate the element again
		input = driver.findElement(By.id("search-query"));
		//get the  text of the element
		String actual = input.getAttribute("value");
		
		System.out.println(actual);
		
		if(actual.equals(searchTerm)) {
			System.out.println("pass");
		}else {
			System.out.println("fail");
			System.out.println("Expected:\t"+ searchTerm);
			System.out.println("fount:\t"+actual);
		}
		
		driver.findElement(By.partialLinkText("Sell on")).click();
			
		}
		
		
		
		
	}


