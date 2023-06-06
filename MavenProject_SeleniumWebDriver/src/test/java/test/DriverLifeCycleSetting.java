package test;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class DriverLifeCycleSetting {
	
	protected WebDriver driver;
	
	@BeforeAll
    public static void before_all() {
        // Set the ChromeDriver location using System.setProperty()
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver\\latest\\chromedriver.exe");
    }

	@BeforeEach
	void setUp() throws Exception {
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("--headless");
		//driver = new ChromeDriver(options);
		driver = new ChromeDriver(); //see the pages
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterEach
	void tearDown() throws Exception {
		if(driver != null) {
			driver.quit();
		}
	}
}

