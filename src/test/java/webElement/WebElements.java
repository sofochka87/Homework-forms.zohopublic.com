package webElement;

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

public class WebElements {

	WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.out.println("Setting up WebDriver in BeforeClass...");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}

	@Test
	public void myLinks() {
		driver.get("https://github.com");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		//how many links on github homepage
		int numberOfLinksOnGitHub = links.size();
		System.out.println("number of links: "+numberOfLinksOnGitHub);
		
		//prink text of each link
		List<String> list2 = new ArrayList<>();
		
		for(WebElement link :links) {
			if(!link.getText().isEmpty()) {
			System.out.println(link.getText());
		//ad each link text into a list of sting
			list2.add(link.getText());
			
			}	
		}
		//System.out.println(list2.toString());
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
		driver.get("Navigate to https://forms.zohopublic.com/murodil/form/SeleniumWebElements/formperma/eCecYgX4WMcmjxvXVq6UdhA2ABXIoqPAxnAF8H8CCJg");
		List<WebElement> links = driver.findElements(By.tagName("input"));
		int numberOfLinks = links.size();
		System.out.println("number of links: "+numberOfLinks);
	}
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
}
