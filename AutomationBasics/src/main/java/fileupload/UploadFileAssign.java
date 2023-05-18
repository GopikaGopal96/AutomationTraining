package fileupload;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class UploadFileAssign {
	public WebDriver driver;
	
  @Test
  public void fileUpload() {
	  //WebDriverWait wait = new WebDriverException(driver, Duration.ofSeconds(10));
	 // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("main")));
	  WebElement choose_file = driver.findElement(By.id("uploadfile_0"));
	  choose_file.sendKeys("C:\\Users\\HP\\Downloads\\Beautiful-Aesthetic-Laptop-Wallpaper.jpg");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	  WebElement term_chkbox = driver.findElement(By.id("terms"));
	  term_chkbox.click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	  WebElement submit_btn = driver.findElement(By.id("submitbutton"));
	  submit_btn.click();
  }
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.http.factory", "jdk-http-client");
	  System.setProperty("Webdriver.Chrome.driver","C:\\Users\\HP\\OneDrive\\Desktop\\Automation Testing\\ChromeDriver\\chromedriver_win32 (1)\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("https://demo.guru99.com/test/upload/");
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
  }

}
