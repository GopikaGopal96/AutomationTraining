package formvalidation;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class FormValidation {
	public WebDriver driver;
  @Test
  public void insertvalue() throws InterruptedException {
	  WebElement fname = driver.findElement(By.cssSelector("input#validationCustom01"));
	  fname.sendKeys("Gopika");
	  WebElement lname = driver.findElement(By.cssSelector("input.form-control[id=validationCustom02]"));
	  lname.sendKeys("Gopal");
	  //WebElement user = driver.findElement(By.id("validationCustomUsername"));
	  WebElement user = driver.findElement(By.cssSelector("input[placeholder=Username]"));
	  user.sendKeys("gopika25");
	  WebElement city = driver.findElement(By.id("validationCustom03"));
	  city.sendKeys("Kochi");
	  WebElement state = driver.findElement(By.id("validationCustom04"));
	  state.sendKeys("Kerala");
	  WebElement zip =driver.findElement(By.id("validationCustom05"));
	  zip.sendKeys("682028");
	  //WebElement condition = driver.findElement(By.id("invalidCheck"));
	  WebElement condition = driver.findElement(By.cssSelector("input#invalidCheck"));
	  condition.click();
	  Thread.sleep(1000);
	  WebElement submit = driver.findElement(By.xpath("//button[text()='Submit form']"));
	  submit.click();
	  Thread.sleep(3000);
	  boolean b = condition.isEnabled();
	  if (b) {
		  System.out.println("Checkbox is checked.");
	  }
	  SoftAssert obj = new SoftAssert();
	  AssertJUnit.assertTrue(b);
	  WebElement message = driver.findElement(By.id("message-one"));
	  String actual = message.getText();
	  String expected = "Form has been submitted successfully!";
	  AssertJUnit.assertEquals(actual, expected);
	  obj.assertAll();
  }

  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.http.factory", "jdk-http-client");
	  System.setProperty("Webdriver.Chrome.driver","\"C:\\Users\\HP\\OneDrive\\Desktop\\Automation Testing\\ChromeDriver\\chromedriver_win32 (1)\\chromedriver.exe\"");
	  driver = new ChromeDriver();
	  driver.get("https://selenium.obsqurazone.com/form-submit.php");
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
