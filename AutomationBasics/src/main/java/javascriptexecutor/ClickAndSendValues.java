package javascriptexecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ClickAndSendValues {
	
	public WebDriver driver;
@Test
  public void clickAndSend() {
	  driver.get("https://demoqa.com/upload-download");
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  WebElement textbox = driver.findElement(By.id("item-0"));
	  js.executeScript("arguments[0].click();", textbox);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	  WebElement userName = driver.findElement(By.id("userName"));
	  js.executeScript("arguments[0].value='Gopika'",userName);
	  WebElement userEmail = driver.findElement(By.id("userEmail"));
	  js.executeScript("arguments[0].value='gopikagopal25@gmail.com'",userEmail);
	  WebElement curr_Address = driver.findElement(By.id("currentAddress"));
	  js.executeScript("arguments[0].value='Cochin'",curr_Address);
	  WebElement perm_Address = driver.findElement(By.id("permanentAddress"));
	  js.executeScript("arguments[0].value='Trivandrum'",perm_Address);
	  WebElement submit_btn= driver.findElement(By.id("submit"));
	  js.executeScript("arguments[0].click();", submit_btn);
  }
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.http.factory", "jdk-http-client");
	  System.setProperty("Webdriver.Chrome.driver","\"C:\\Users\\HP\\OneDrive\\Desktop\\Automation Testing\\ChromeDriver\\chromedriver_win32 (1)\\chromedriver.exe\"");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();  
  }

  @AfterTest
  public void afterTest() {
	  //driver.quit();
  }
}
