package webElement;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Elements {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.out.println("Setting up WebDriver in BeforeClass...");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(
				"https://forms.zohopublic.com/murodil/form/JobApplicationForm/formperma/kOqgtfkv1dMJ4Df6k4_mekBNfNLIconAHvfdIk3CJSQ");
	}
	@Test
	public void WebElementExamples() {
		WebElement email = driver.findElement(By.name("Email"));
		String value = email.getAttribute("value");
		String maxLength = email.getAttribute("maxLength");
		String type = email.getAttribute("type");
		String tag = email.getAttribute("tag");
		
		System.out.println("value: "+value+"\n"+"maxLegth: "+maxLength+"\n"+"type: "+type+"\n"+"tag: "+ tag);
		assertEquals(value,"youremail@mail.com");
		email.clear();
		email.sendKeys("another@mail.com");
		
		WebElement country = driver.findElement(By.id("Address_Country"));
		Select selectCountry = new Select(country);
		System.out.println(selectCountry.getFirstSelectedOption().getText());
		
		String d = selectCountry.getFirstSelectedOption().getText();
		System.out.println(d);
		selectCountry.selectByIndex(69);
		
		//Lets to generate StaleElementException
		WebElement cSalary = driver.findElement(By.name("Number"));
		assertEquals(cSalary.isDisplayed(),true);
		
		//driver.get("http://google.com");
		driver.findElement(By.xpath("//em[.=' Next ']")).click();
		cSalary.sendKeys("123456");
	}
	
	@AfterClass
	public void tearDown() {
		//driver.close();
	}
}
