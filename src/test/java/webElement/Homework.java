package webElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Homework {

	WebDriver driver;
	Faker faker = new Faker();
	Random random = new Random();

	@BeforeClass
	public void setUp() {
		System.out.println("Setting up WebDriver in BeforeClass...");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
	/*
	 * Homework: Loop through each inputbox and enter random names 
	 * Loop through each dropDown and randomly select by index 
	 * Loop through each checkBoxes and select each one 
	 * Loop through each radioButton and click one by one by waiting one second intervals 
	 * Click all buttons
	 */

	@Test
	public void seleniumWebElementsForm() throws InterruptedException {
		
		for (int i = 0; i < 3; i++) {
			
		driver.get(
				"https://forms.zohopublic.com/murodil/form/SeleniumWebElements/formperma/eCecYgX4WMcmjxvXVq6UdhA2ABXIoqPAxnAF8H8CCJg");
		
		List<WebElement> inputs = driver.findElements(By.xpath("//input[@type='text']"));
		List<WebElement> dropDownBoxes = driver.findElements(By.tagName("Select"));
		List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		List<WebElement> radios = driver.findElements(By.xpath("//input[@type='radio']"));
		List<WebElement> buttons = driver.findElements(By.tagName("button"));
		
            //Loop through each inputbox and enter random names 
			for (WebElement input : inputs) {
				input.sendKeys(faker.name().firstName());
			}
			//Loop through each dropDown and randomly select by index 
			for (WebElement dropDownBox : dropDownBoxes) {
				Select selectDropDown = new Select(dropDownBox);
				selectDropDown.selectByIndex(random.nextInt(3) + 1);
			}
			// Loop through each checkBoxes and select each one 
			for (WebElement checkBox : checkBoxes) {
				checkBox.click();
			}
			//Loop through each radioButton and click one by one by waiting one second intervals 
			for (WebElement radio : radios) {
				Thread.sleep(1000);
				radio.click();
			}
			//Click all buttons
			for (WebElement button : buttons) {
				Thread.sleep(1000);
				button.click();
			}
		    
		}
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}
}
