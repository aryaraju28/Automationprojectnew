package Basepkg;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;

public class Baseclass {
public static WebDriver driver;
	
	@BeforeTest
	public void setup() {
		
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("disable notifications");
		driver=new ChromeDriver(options);
		
		driver.get("https://www.giva.co/account/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		
		
		
		
	}

}
