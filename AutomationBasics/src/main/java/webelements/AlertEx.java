package webelements;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class AlertEx {
	public WebDriver driver;
  @Test
  public void alertMethods() throws InterruptedException {
	  List<WebElement> ob= driver.findElements(By.xpath("//button[text()='Click me!']"));
	  ob.get(0).click();
	  Thread.sleep(3000);
	  Alert a1 = driver.switchTo().alert();
	  String message1 = a1.getText();
	  System.out.println(message1);
	  String expected1 = "I am a Javascript alert box!";
	  a1.accept();
	  SoftAssert s = new SoftAssert();
	  AssertJUnit.assertEquals(message1, expected1);
	  Thread.sleep(3000);
	  ob.get(1).click();
	  Alert a2 = driver.switchTo().alert();
	  Thread.sleep(3000);
	  String message2 = a2.getText();
	  String expected2 = "Press a button!";
	  a2.accept();
	  //a2.dismiss();
	  AssertJUnit.assertEquals(message2,expected2);
	  System.out.println(message2);
	  Thread.sleep(3000);
	  WebElement el = driver.findElement(By.xpath("//button[text()='Click for Prompt Box']"));
	  el.click();
	  Alert a3 = driver.switchTo().alert();
	  Thread.sleep(3000);
	  a3.sendKeys("Gopika");
	  Thread.sleep(3000);
	  a3.accept();
	  WebElement element =driver.findElement(By.id("prompt-demo"));
	  String message3 = element.getText();
	  System.out.println(message3);
	  String expected3 = "You have entered 'Gopika' !";
	  AssertJUnit.assertEquals(message3,  expected3);
	  s.assertAll();
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("Webdriver.Chrome.driver", "C:\\Users\\HP\\OneDrive\\Desktop\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("https://selenium.obsqurazone.com/javascript-alert.php");
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	  //driver.close();
  }

}
