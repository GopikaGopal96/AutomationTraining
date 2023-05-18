package javascriptexecutor;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.TakesScreenshot;

public class Scroll {
	public WebDriver driver;

	@Test
	public void screenshot() {
		driver.get("https://www.wikipedia.org/");
	}
	
	@AfterMethod
	public void beforeMethod(ITestResult r) throws IOException {
		if(ITestResult.SUCCESS==r.getStatus()) {
			File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(f, new File ("C:\\Users\\HP\\Downloads\\Scrnsht\\"+r.getName()+".jpeg"));
		}
	}
	
  @Test
  public void upload() {
	  driver.get("https://demoqa.com/upload-download");
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  js.executeScript("window.scrollBy(0,1000)","down");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  js.executeScript("window.scrollBy(0,1000)","up");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  WebElement choosefile = driver.findElement(By.id("uploadFile"));
	  choosefile.sendKeys("C:\\Users\\HP\\Downloads\\Beautiful-Aesthetic-Laptop-Wallpaper.jpg");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  WebElement download = driver.findElement(By.id("downloadButton"));
	  download.click();
	 
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.http.factory", "jdk-http-client");
	  System.setProperty("Webdriver.Chrome.driver","C:\\Users\\HP\\OneDrive\\Desktop\\Automation Testing\\ChromeDriver\\chromedriver_win32 (1)\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
  }

}
