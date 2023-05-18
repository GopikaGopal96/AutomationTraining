package webelements;

	import org.testng.annotations.Test;
import org.testng.AssertJUnit;
	import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.WebElement;

public class WebCommands {
	public WebDriver driver;
	public WebElement element;
  @Test
  public void commands() throws InterruptedException {
	  element = driver.findElement(By.id("single-input-field"));
	  element.sendKeys("Hello");
	  Thread.sleep(3000);
	  element.clear();
	  element.sendKeys("Morning");
	  element= driver.findElement(By.id("button-one"));
	  element.click();
	  element = driver.findElement(By.id("message-one"));
	  String message = element.getText();
	  System.out.println(message);
	  String expected = "Your Message : Morning";
	  AssertJUnit.assertEquals(message, expected);
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("Webdriver.Chrome.driver", "C:\\Users\\HP\\OneDrive\\Desktop\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
  }

}
