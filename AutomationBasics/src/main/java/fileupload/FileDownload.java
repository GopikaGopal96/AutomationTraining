
package fileupload;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class FileDownload {
	public WebDriver driver;
  @Test
  public void download() {
	  WebElement textbox = driver.findElement(By.id("textbox"));
	  textbox.sendKeys("Hello Everyone");
	   //Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	  WebElement create_btn = driver.findElement(By.id("create"));
	  create_btn.click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	  WebElement download_btn = driver.findElement(By.id("download-file"));
	  download_btn.click();
	  
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.http.factory", "jdk-http-client");
	  System.setProperty("Webdriver.Chrome.driver","C:\\Users\\HP\\OneDrive\\Desktop\\Automation Testing\\ChromeDriver\\chromedriver_win32 (1)\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("https://selenium.obsqurazone.com/file-download.php");
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
  }

}
