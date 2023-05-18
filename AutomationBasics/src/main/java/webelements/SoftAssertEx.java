package webelements;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class SoftAssertEx {
	public WebDriver driver;
  @Test
  public void multipleCheckbox() {
	  SoftAssert obj = new SoftAssert();
	  WebElement checkbox1 = driver.findElement(By.id("check-box-one"));
	  checkbox1.click();
	  WebElement checkbox2 = driver.findElement(By.id("check-box-two"));
	  checkbox2.click();
	  WebElement checkbox3 = driver.findElement(By.id("check-box-three"));
	  checkbox3.click();
	  WebElement checkbox4 = driver.findElement(By.id("check-box-four"));
	  checkbox4.click();
	  boolean b = checkbox1.isSelected();
	  System.out.println(b);
	  AssertJUnit.assertTrue(b);
	  String title = driver.getTitle();
	  title.equals("Obsqura Testing");
	  AssertJUnit.assertNull(driver);
	  obj.assertAll();
	  
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
	  //driver.quit();
  }

}
