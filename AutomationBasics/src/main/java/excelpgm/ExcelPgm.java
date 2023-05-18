package excelpgm;

import org.testng.annotations.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class ExcelPgm {
	public WebDriver driver;
  @Test(dataProvider = "userData")
  public void f(String n, String s) {
	  driver.get("http://executeautomation.com/demosite/Login.html");
		 WebElement user = driver.findElement(By.name("UserName"));
		 user.sendKeys(n);
		 WebElement pass = driver.findElement(By.name("Password"));
		 
		 pass.sendKeys(s);
		 //WebElement login = driver.findElement(By.name("Login"));
		WebElement login = driver.findElement(By.xpath("//input[@value=\"Login\"]"));
		 login.click();
  }

  @DataProvider
  public Object[][] userData() throws InvalidFormatException, IOException {

		Object[][] data= getDataFromExcel("C:\\Users\\HP\\OneDrive\\Desktop\\Snapshots\\ExcelReadData.xlsx", "LoginData");
		return data;

  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.http.factory", "jdk-http-client");
	  System.setProperty("Webdriver.Chrome.driver","\"C:\\Users\\HP\\OneDrive\\Desktop\\Automation Testing\\ChromeDriver\\chromedriver_win32 (1)\\chromedriver.exe\"");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
  }
  
  public static Object[][] getDataFromExcel(String filePath, String sheetName) throws InvalidFormatException, IOException
	 {//here getting excel data to an 2D(3x2) array using getDataFromExcel(path,value)
//init
Object[][] data;
FileInputStream inputStream = new FileInputStream(new File(filePath));
Workbook wb = WorkbookFactory.create(inputStream);
Sheet s = wb.getSheet(sheetName);

//sheet range
int rowCount = s.getLastRowNum();
int colCount = s.getRow(0).getLastCellNum();
data = new Object[rowCount][colCount];
for (int i = 1; i <= rowCount; i++) {
	for (int j = 0; j <= colCount - 1; j++) {
		if (!getCellValue(s, 0, j).equals("")) {
			data[i - 1][j] = getCellValue(s, i, j);
		}
	}
}

return data;
}
	private static String getCellValue(Sheet sheet, int row, int col) {
		String value = "";
		if (sheet.getRow(row).getCell(col) == null) {
			value = "";
		} else if (sheet.getRow(row).getCell(col).getCellType() == Cell.CELL_TYPE_STRING) {
			value = sheet.getRow(row).getCell(col).getStringCellValue();
		} else {
			sheet.getRow(row).getCell(col).setCellType(Cell.CELL_TYPE_STRING);
			value = sheet.getRow(row).getCell(col).getStringCellValue();
		}
		return value;
	}

}