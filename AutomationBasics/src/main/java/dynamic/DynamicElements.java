package dynamic;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class DynamicElements {
	
	public WebDriver driver;
	
  @Test
  public void dynamic() {
	  //column 
	  List<WebElement>column = driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/thead/tr/th"));
	  int col_size = column.size();
	  System.out.println("Column size : "+col_size);
	  //row
	  List<WebElement>row = driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr"));
	  int row_size = row.size();
	  System.out.println("Row size : "+row_size);
	  //Value of third row and fourth column
	  WebElement el = driver.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[3]/td[4]"));
	  System.out.println("Element in third row and fourth column : "+el.getText());
	  //print the values of all the elements in the table
	  for(int i=0;i<row_size;i++) {
		  List<WebElement>current_row=row.get(i).findElements(By.tagName("td"));
		  for(int j=0;j<col_size;j++) {
			  String data = current_row.get(j).getText();
			  System.out.println("Value is "+data);
		  }
	  }
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.http.factory", "jdk-http-client");
	  System.setProperty("Webdriver.Chrome.driver","\"C:\\Users\\HP\\OneDrive\\Desktop\\Automation Testing\\ChromeDriver\\chromedriver_win32 (1)\\chromedriver.exe\"");
	  driver = new ChromeDriver();
	  driver.get("https://demo.guru99.com/test/web-table-element.php");
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
