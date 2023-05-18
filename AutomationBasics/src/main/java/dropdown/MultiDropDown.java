package dropdown;

import org.testng.annotations.Test;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

public class MultiDropDown {
	public WebDriver driver;

  @Test
  public void multiselect() throws AWTException, InterruptedException {
	  SoftAssert sa = new SoftAssert();
	  WebElement values = driver.findElement(By.xpath("//select[@class='spTextField']"));
	  Select s = new Select(values);
	  List<WebElement>options = s.getOptions();
	  int size = options.size();
	  System.out.println("Size :"+size);
	  for(int i=0;i<size;i++) {
		  String value = options.get(i).getText();
		  System.out.println(value);
	  }
	  Robot r = new Robot();
	  r.keyPress(KeyEvent.VK_CONTROL);
	  Thread.sleep(1000);
	  s.selectByIndex(1);
	  Thread.sleep(1000);
	  s.selectByValue("Performance Testing");
	  Thread.sleep(1000);
	  s.selectByVisibleText("Agile Methodology");
	  Thread.sleep(1000);
	  //r.keyRelease(KeyEvent.VK_CONTROL);
	  String first = s.getFirstSelectedOption().getText();
	  System.out.println("First Selected Option : "+first);
	  s.deselectAll();
	  sa.assertAll();
  }
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.http.factory", "jdk-http-client");
	  System.setProperty("Webdriver.Chrome.driver","\"C:\\Users\\HP\\OneDrive\\Desktop\\Automation Testing\\ChromeDriver\\chromedriver_win32 (1)\\chromedriver.exe\"");
	  driver = new ChromeDriver();
	  driver.get("https://www.softwaretestingmaterial.com/sample-webpage-to-automate/");
	  driver.manage().window().maximize();
  }
}
