package webelements;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class HardAssert {
	public WebDriver driver;
	public WebElement element;
  @Test
  public void hardassert() {
	  element = driver.findElement(By.id("gridCheck"));
	  element.click();
	  boolean b = element.isSelected();
	  System.out.println(b);
	  AssertJUnit.assertTrue(b);
	  //Assert.assertFalse(b);
	  AssertJUnit.assertNotNull(driver);
	  element = driver.findElement(By.id("message-one"));
	  String message = element.getText();
	  String expected = "Success - Check box is checked";
	  AssertJUnit.assertEquals(message, expected);
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("Webdriver.Chrome.driver", "C:\\Users\\HP\\OneDrive\\Desktop\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("https://selenium.obsqurazone.com/check-box-demo.php");
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }
}