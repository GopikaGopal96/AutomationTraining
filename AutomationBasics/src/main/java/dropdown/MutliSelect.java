package dropdown;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class MutliSelect {
	public WebDriver driver;
	
  @Test
  public void multipleSelect() throws AWTException, InterruptedException {
	  //SoftAssert ob =new SoftAssert();
	  WebElement color = driver.findElement(By.id("multi-select-field"));
	  Select s = new Select(color);
	  Robot r = new Robot();
	  r.keyPress(KeyEvent.VK_CONTROL);
	  s.selectByVisibleText("Yellow");
	  //Thread.sleep(1000);
	  //s.deselectAll();
	  s.selectByVisibleText("Green");
	  //Thread.sleep(1000);
	  //s.deselectAll();
	  r.keyRelease(KeyEvent.VK_CONTROL);
	  WebElement button1 =driver.findElement(By.id("button-first"));
	  button1.click();
	  WebElement message = driver.findElement(By.id("message-two"));
	  String actual = message.getText();
	  System.out.println(actual);
	  String expected = "First selected color is : Yellow";
	  AssertJUnit.assertEquals(actual,expected);
	  List<WebElement>options = s.getOptions();
	  int size = options.size();
	  System.out.println("Size :"+size);
	  for(int i=0;i<size;i++) {
		  String value = options.get(i).getText();
		  System.out.println(value);
	  }
	  Thread.sleep(3000);
	  System.out.println("First Selected : "+s.getFirstSelectedOption().getText());
	  WebElement button2 = driver.findElement(By.id("button-all"));
	  button2.click();
	  Thread.sleep(3000);
	  /*String actual1 = message.getText();
	  System.out.println(actual1);
	  String expected1 = "First selected color is : Yellow";
	  ob.assertEquals(actual1,expected1);*/
	  s.deselectAll();
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.http.factory", "jdk-http-client");
	  System.setProperty("Webdriver.Chrome.driver","\"C:\\Users\\HP\\OneDrive\\Desktop\\Automation Testing\\ChromeDriver\\chromedriver_win32 (1)\\chromedriver.exe\"");
	  driver = new ChromeDriver();
	  driver.get("https://selenium.obsqurazone.com/select-input.php");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	  //driver.quit();
  }

}
