package webelements;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class HandlingWindows {
	public WebDriver driver;
  @Test
  public void newWindow() throws AWTException {
	  Robot r = new Robot();
	  r.keyPress(KeyEvent.VK_CONTROL);
	  r.keyPress(KeyEvent.VK_T);
	  r.keyRelease(KeyEvent.VK_CONTROL);
	  r.keyRelease(KeyEvent.VK_T);
	  String parentTab = driver.getWindowHandle();
	  System.out.println("Parent Tab : "+parentTab);
	  Set<String>allTabs = driver.getWindowHandles();
	  System.out.println("All Tabs: "+allTabs);
	  System.out.println("Size :"+allTabs.size());
	  //String tab1 = (String)allTabs.toArray()[0];
	  String tab2 = (String)allTabs.toArray()[1];
	  driver.switchTo().window(tab2);
	  driver.get("https://www.wikipedia.org/");
 }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.http.factory", "jdk-http-client");
	  System.setProperty("Webdriver.Chrome.driver","\"C:\\Users\\HP\\OneDrive\\Desktop\\Automation Testing\\ChromeDriver\\chromedriver_win32 (1)\\chromedriver.exe\"");
	  driver = new ChromeDriver();
	  driver.get("https://selenium.obsqurazone.com/radio-button-demo.php");
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
  }

}
