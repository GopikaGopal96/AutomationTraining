package annotations;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class DriverAnnotations {
	
	public WebDriver driver;

  @Test
  public void verifyTitle() {
	  String title = driver.getTitle();
		if (title.equals("Tutorials List - Javatpoint")) {
			System.out.println("Title verfified.");
		}
		else {
			System.out.println("Title not verified.");
		}
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.http.factory", "jdk-http-client");
	  System.setProperty("Webdriver.Chrome.driver","\"C:\\Users\\HP\\OneDrive\\Desktop\\Automation Testing\\ChromeDriver\\chromedriver_win32 (1)\\chromedriver.exe\"");
	  driver = new ChromeDriver();
	  driver.get("https://www.javatpoint.com/");
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
