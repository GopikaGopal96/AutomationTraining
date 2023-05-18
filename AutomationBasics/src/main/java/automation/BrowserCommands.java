package automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserCommands {

	public static void main(String[] args) {

		System.setProperty("webdriver.http.factory", "jdk-http-client");
		System.setProperty("Webdriver.Chrome.driver","\"C:\\Users\\HP\\OneDrive\\Desktop\\Automation Testing\\ChromeDriver\\chromedriver_win32 (1)\\chromedriver.exe\"");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.javatpoint.com/");
		String url = driver.getCurrentUrl();
		System.out.println(url);
		driver.manage().window().maximize();
		String title = driver.getTitle();
		if (title.equals("Tutorials List - Javatpoint")) {
			System.out.println("Title verfified.");
		}
		else {
			System.out.println("Title not verified.");
		}
		String page = driver.getPageSource();
		System.out.println(page);
		driver.close();
	}

}
