package parameterisation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;

public class Parameterisation {
	public WebDriver driver;
	
  @Test
  @Parameters({"username","password"})
  public void mainMethod(String name, String pass) {
	  //WebElement user = driver.findElement(By.xpath("//input[@name='UserName']"));
	  WebElement user = driver.findElement(By.cssSelector("input[name^='User']"));
	  user.sendKeys(name);
	  //WebElement password = driver.findElement(By.xpath("//input[@name='Password']"));
	  WebElement password = driver.findElement(By.cssSelector("input[name$='word']"));
	  password.sendKeys(pass);
	  //WebElement login = driver.findElement(By.xpath("//input[@name='Login']"));
	  WebElement login = driver.findElement(By.cssSelector("input[name*='ogi']"));
	  login.click();
  }
	
  @BeforeTest
  @Parameters("browser")
  public void beforeTest(@Optional("chrome") String b){
	  getBrowser(b);
	  driver.get("https://demosite.executeautomation.com/Login.html");
	  
  }

  @AfterTest
  public void afterTest() {
	  //driver.quit();
  }
  
  public void getBrowser(String br) {
	  if(br.equals("chrome")) {
		  System.setProperty("webdriver.http.factory", "jdk-http-client");
		  System.setProperty("Webdriver.Chrome.driver","C:\\Users\\HP\\OneDrive\\Desktop\\Automation Testing\\ChromeDriver\\chromedriver_win32 (1)\\chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  System.out.println("Chrome Browser");
	  }
	  else {
		  System.setProperty("webdriver.http.factory", "jdk-http-client");
		  System.setProperty("Webdriver.Edge.driver","C:\\Users\\HP\\OneDrive\\Desktop\\Automation Testing\\EdgeDriver\\edgedriver_win64\\msedgedriver.exe");
		  driver = new EdgeDriver();
		  driver.manage().window().maximize();
		  System.out.println("Edge Browser");
		  
	  }
  }
}
