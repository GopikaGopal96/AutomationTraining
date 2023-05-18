package waitcommands;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class DragAndDrop {
	public WebDriver driver;
	
  @Test
  public void dragdrop() {
	  SoftAssert s = new SoftAssert();
	  //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  //wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("card")));
	  WebElement drag1 = driver.findElement(By.xpath("//span[text()='Draggable n°1']"));
	  /*WebElement drag2 = driver.findElement(By.xpath("//span[text()='Draggable n°2']"));
	  WebElement drag3 = driver.findElement(By.xpath("//span[text()='Draggable n°3']"));
	  WebElement drag4 = driver.findElement(By.xpath("//span[text()='Draggable n°4']"));*/
	  WebElement drop = driver.findElement(By.xpath("//div[@id='mydropzone']"));
	  Actions act = new Actions(driver);
	  act.dragAndDrop(drag1, drop);
	  WebElement element1 = driver.findElement(By.xpath("//a[@href = 'date-picker.php']"));
	  act.contextClick(element1);
	  act.build().perform();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  /*act.dragAndDrop(drag2, drop).build().perform();
	  act.dragAndDrop(drag3, drop).build().perform();
	  act.dragAndDrop(drag4, drop).build().perform();*/
	  s.assertAll();
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.http.factory", "jdk-http-client");
	  System.setProperty("Webdriver.Chrome.driver","\"C:\\Users\\HP\\OneDrive\\Desktop\\Automation Testing\\ChromeDriver\\chromedriver_win32 (1)\\chromedriver.exe\"");
	  driver = new ChromeDriver();
	  driver.get("https://selenium.obsqurazone.com/drag-drop.php");
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
  }

}
