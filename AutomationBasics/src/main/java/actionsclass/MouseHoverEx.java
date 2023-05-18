package actionsclass;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class MouseHoverEx {
	public WebDriver driver;
  @Test
  public void mousehover() {
	  WebElement element1 = driver.findElement(By.xpath("//a[@href='simple-form-demo.php']"));
	  WebElement element2 = driver.findElement(By.xpath("//a[@href='date-picker.php']"));
	  Actions act = new Actions(driver);
	  act.moveToElement(element1);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	  act.moveToElement(element2).click();
	  act.build().perform();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.http.factory", "jdk-http-client");
	  System.setProperty("Webdriver.Chrome.driver","\"C:\\Users\\HP\\OneDrive\\Desktop\\Automation Testing\\ChromeDriver\\chromedriver_win32 (1)\\chromedriver.exe\"");
	  driver = new ChromeDriver();
	  driver.get("https://selenium.obsqurazone.com/index.php");
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
