package webelements;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class ElementVsElements {
	public WebDriver driver;
	public WebElement element;
	
  @Test
  public void difference() throws InterruptedException {
	  SoftAssert s =new SoftAssert();
	  List<WebElement> ob = driver.findElements(By.name("inlineRadioOptions"));
	  ob.get(1).click();
	  element = driver.findElement(By.id("button-one"));
	  element.click();
	  Thread.sleep(3000);
	  element = driver.findElement(By.id("message-one"));
	  String message = element.getText();
	  String expected ="Radio button 'Female' is checked";
	  AssertJUnit.assertEquals(message, expected);
	  
	  ob.get(0).click();
	  element = driver.findElement(By.id("button-one"));
	  element.click();
	  Thread.sleep(3000);
	  element = driver.findElement(By.id("message-one"));
	  String message1 = element.getText();
	  String expected1 ="Radio button 'Male' is checked";
	  AssertJUnit.assertEquals(message1, expected1);
	  s.assertAll();
	  
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("Webdriver.Chrome.driver", "C:\\Users\\HP\\OneDrive\\Desktop\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("https://selenium.obsqurazone.com/radio-button-demo.php");
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
