package com.cybertek;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownDemo {
	
	public static void main(String[] args) {
		
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	String url = "https://tutorialehtml.com/en/html-tutorial-drop-down-lists-menu/";
	driver.get(url);

	WebElement selectTag = driver.findElement(By.name("my_html_select_box"));
	
	Select list = new Select(selectTag); 
	//.getAllSelectedOptions() --> returns the selected value
	//print the selected value: oprion 1

	WebElement selected = list.getFirstSelectedOption();
	
	//print the selected value: option 2
	System.out.println(list.getFirstSelectedOption().getText());
	
	//print all the available options
	//return a lis of all the options (selected and not selected, everything)

    System.out.println(selected.getText());
    System.out.println("-------------------------");
    List<WebElement> options = list.getOptions();
    for (WebElement webElement : options) {
        System.out.println(webElement.getText());
    }
    list.deselectByVisibleText("Bucharest");
    System.out.println("selected:\t"+ list.getFirstSelectedOption().getText());	

	
	//select using the index(count starts from 0):
    list.selectByIndex(0);
    System.out.println("select:\t"+list.getFirstSelectedOption().getText());
   
	System.out.println("-----------------");
	
	Select secondList = new Select(driver.findElement(By.cssSelector("select[multiple='yes'")));
	
	secondList.selectByVisibleText("New York");
    secondList.selectByVisibleText("Madrid");
    
    List<WebElement> allSelectedOptions = secondList.getAllSelectedOptions();
    for(WebElement we: allSelectedOptions) {
    	System.out.println(we.getText());
    }
    System.out.println(allSelectedOptions.size());
    secondList.deselectAll();
    allSelectedOptions = secondList.getAllSelectedOptions();
    System.out.println(allSelectedOptions.size());
	

	driver.close();
	
	
	}
}
