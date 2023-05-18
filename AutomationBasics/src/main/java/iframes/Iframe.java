package iframes;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Iframe {
	public WebDriver driver;
  @Test
  public void switchFrame() {
	  int size = driver.findElements(By.tagName("iframe")).size();
	  System.out.println("Count of Iframes found : "+size);
	  //driver.switchTo().frame(0);
	  //driver.findElement(By.xpath("/html/body/div[2]")).click();
	  System.out.println("Iframe found");
	  driver.switchTo().parentFrame();
	  System.out.println("Switching successfull");
	  driver.switchTo().frame("a077aa5e");
	  driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.http.factory", "jdk-http-client");
	  System.setProperty("Webdriver.Chrome.driver","\"C:\\Users\\HP\\OneDrive\\Desktop\\Automation Testing\\ChromeDriver\\chromedriver_win32 (1)\\chromedriver.exe\"");
	  driver = new ChromeDriver();
	  driver.get("https://demo.guru99.com/test/guru99home/");
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	  //driver.quit();
  }

}
