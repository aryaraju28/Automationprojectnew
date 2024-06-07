package Testpkg;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Basepkg.Baseclass;
import Pagepkg.Loginpage;
import utilities.Exelutilities;


public class Logintest extends Baseclass {
	@Test(priority = 1)
	public void verifylogin() throws Exception
	{
		Loginpage loginpage=new Loginpage(driver);
		String xl="E:\\hmexcel.xlsx";
		String Sheet="Sheet1";
		int rowCount=Exelutilities.getRowCount(xl, Sheet);
		for(int i=1;i<=rowCount;i++)
		{
			driver.navigate().refresh();
			String usernameString=Exelutilities.getCellValue(xl, Sheet, i, 0);
			System.out.println(usernameString);
			String pwdString=Exelutilities.getCellValue(xl, Sheet, i, 1);
			System.out.println(pwdString);
			loginpage.setValues(usernameString, pwdString);
			loginpage.clickLoginBtn();
			String exString="https://www.giva.co/account";
			String acString=driver.getCurrentUrl();
			if(acString.equals(exString))
			{
				
				System.out.println("pass");
			}
			else {
				System.out.println(acString);
				System.out.println("failed");
			}
			
		}
		
		
	}
	@Test(priority = 2)
	public void wishlist() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		WebElement category=driver.findElement(By.xpath("//*[@id=\"HeaderMenu-shop-by-category\"]/span"));
		Actions act=new Actions(driver);
		act.moveToElement(category);
		act.perform();
		
		driver.findElement(By.xpath("//*[@id=\"HeaderMenu-shop-by-category-all\"]")).click();
		Thread.sleep(3000);
		
	

		List<WebElement>list=driver.findElements(By.xpath("//*[@id=\"product-grid\"]/li"));
	
		
		for(WebElement e:list)
		{
			String textString=e.getAttribute("href");
			String textString2=e.getText();
			System.out.println(textString2);
			
		
			
			if(textString.equals("https://www.giva.co/products/silver-snowflake-earrings?_pos=2&_sid=6cd0e926f&_ss=r"))
			{
				
				e.click();
				
				
				
			}
			
			
		}	
		

}	
	
	@Test(priority = 3)
	public void wishcart() throws Exception
	{
		
		Wait<WebDriver> wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement wish2=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/div[2]/div/div/div/div/ul/li[1]/button")));
       wish2.click();
		
		
		
		
	}
	
	

	
	
	
	
/*@Test(priority = 3)
	public void test3() throws Exception {
		List<WebElement>list=driver.findElements(By.tagName("a"));
		System.out.println(list.size());
		for(WebElement element:list)
		{
			String links=element.getAttribute("href");
			verifyresponse(links);
		}
		
		
	}
	private void verifyresponse(String links) throws IOException {
		// TODO Auto-generated method stub
		try {
			URL url=new URL(links);
			HttpURLConnection connection=(HttpURLConnection)url.openConnection();
			int code=connection.getResponseCode();
			if(code==200)
			{
				System.out.println("success"+links);
				
			}
			else if (code==404){
				System.out.println("failed"+links);
				
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		

}*/
	
	@Test(priority = 4)
	public void testlogo()
	{

		boolean element= driver.findElement(By.xpath("/html/body/div[2]/sticky-header/header/a/div/img")).isDisplayed();
		if(element==true)
		{
			System.out.println("passed logo is present");
		}
		 else {
			 System.out.println("failed");
			
		}
		
	
	}
	
			
		
		
		


	}

