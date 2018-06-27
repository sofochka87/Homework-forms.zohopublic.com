package webElement;


	import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
	import java.util.List;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class WelementsCount {

		WebDriver driver;

		@BeforeClass
		public void setUp() {
			System.out.println("Setting up WebDriver in BeforeClass...");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
		}
		@Test
		public void seleniumWebElementsForm() {
			/*Navigate to https://forms.zohopublic.com/murodil/form/SeleniumWebElements/formperma/eCecYgX4WMcmjxvXVq6UdhA2ABXIoqPAxnAF8H8CCJg
			 * Find all input boxes and assign to List of elements =>2
			 * Find all drop down boxes and assign to another List of WebElements => 3
			 * Find all check boxes and assign to another List of WebElements => 9
			 * Find all radio boxes and assign to another List of WebElements => 9
			 * Find all buttons boxes and assign to another List of WebElements => 1
			 * assert each one's count*/
			driver.get("https://forms.zohopublic.com/murodil/form/SeleniumWebElements/formperma/eCecYgX4WMcmjxvXVq6UdhA2ABXIoqPAxnAF8H8CCJg");
			List<WebElement> input = driver.findElements(By.xpath("//input[@type='text']"));
			int numberOfInputs = input.size();
			System.out.println("number of links: "+numberOfInputs);
			List<WebElement> dropDownBoxes = driver.findElements(By.tagName("Select"));
			int numberOfDropDownBoxes = dropDownBoxes.size();
			System.out.println("number of DropDown Boxes: "+ numberOfDropDownBoxes);
			List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
			int numberOfCheckBoxes = checkBoxes.size();
			System.out.println("number of DropDown Boxes: "+ numberOfCheckBoxes);
			List<WebElement> radio = driver.findElements(By.xpath("//input[@type='radio']"));
			int numberOfRadioBoxes = radio.size();
			System.out.println("number of DropDown Boxes: "+ numberOfRadioBoxes);
			List<WebElement> button = driver.findElements(By.tagName("button"));
			int numberOfButtons = button.size();
			System.out.println("number of buttons: "+ numberOfButtons);
			assertEquals(input.size(), 2);
			assertEquals(dropDownBoxes.size(), 3);
			assertEquals(checkBoxes.size(), 9);
			assertEquals(radio.size(), 9, "Message will show if it's fails");
			assertEquals(button.size(), 1);
		
			
		}
		
		@AfterClass
		public void tearDown() {
			driver.close();
		}
		
}
