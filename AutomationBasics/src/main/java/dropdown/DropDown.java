package dropdown;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class DropDown {
	public WebDriver driver;
  @Test
  public void dropDown() throws InterruptedException {
	  WebElement color = driver.findElement(By.id("single-input-field"));
	  Select s = new Select(color);
	  s.selectByIndex(2);
	  Thread.sleep(3000);
	  s.selectByVisibleText("Red");
	  Thread.sleep(3000);
	  s.selectByValue("Green");
	  Thread.sleep(3000);
	  String first = s.getFirstSelectedOption().getText();
	  System.out.println("First Selected Option: "+first);
	  
	  List<WebElement>options = s.getOptions();
	  int size = options.size();
	  System.out.println("Size :"+size);
	  
	  for(int i=0;i<size;i++) {
		  String value = options.get(i).getText();
		  System.out.println(value);
	  }
	  
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.http.factory", "jdk-http-client");
	  System.setProperty("Webdriver.Chrome.driver","\"C:\\Users\\HP\\OneDrive\\Desktop\\Automation Testing\\ChromeDriver\\chromedriver_win32 (1)\\chromedriver.exe\"");
	  driver = new ChromeDriver();
	  driver.get("https://selenium.obsqurazone.com/select-input.php");
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
  }

}
