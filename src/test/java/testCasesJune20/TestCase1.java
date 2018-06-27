package testCasesJune20;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;

public class TestCase1 {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test
	public void SearchTest() throws InterruptedException {

		driver.get(" http://amazon.com");
		String str = "Selenium Testing Tools Cookbook";
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("twotabsearchtextbox")));

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(str + Keys.ENTER);
		/*
		 * css-->> that returns all of the results in the amazon result page
		 * //h2.a-size-medium.s-inline.s-access-title.a-text-normal css does not handle
		 * text, we should have start with xpath 
		 * XPATH: 
		 * 1) only matches the results on the page
         * 2) can filter the results by text //h2[@class='a-size-medium s-inline s-access-title a-text-normal'] in Xpath , 
         * means exact text
		 * //*[.='Shop now'] //h2[.='Selenium Testing Tools CookBook'] 
		 * 3) add those
		 * xpaths //tag[@id='asdf' and class = 'asdfghh'] --> using two attributes of an
		 * element
		 * 
		 * //h2[@class='a-size-medium s-inline s-access-title a-text-normal' and
		 * .='Selenium testing Tools CookBook']
		 */
		String xpath = "//h2[@class='a-size-medium s-inline  s-access-title  a-text-normal' ][.='Selenium Testing Tools Cookbook']";
		// isDisplayed -> returns true of the element we located is displayed on the page
		// isDisplayed -> verifies if the the element which is already located is displayed
		Assert.assertTrue(driver.findElement(By.xpath(xpath)).isDisplayed());
		driver.findElement(By.id("twotabsearchtextbox")).clear();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java OCA Book"+ Keys.ENTER);
		Thread.sleep(2000);
		// .assertFalse(1==1) ---> will return FALSE
		try { //  if the element is still in the mail, this line will handle
			Assert.assertFalse(driver.findElement(By.xpath(xpath)).isDisplayed());
		} catch (Exception e) {
			// if the element is not in the html at all, exception will be thrown
			//since are verify does not exist, NoSuchElementException means should pass
			e.printStackTrace();
		}
		
	}

	@AfterMethod
	public void tearDownMethod() {
		driver.close();
	}

}
