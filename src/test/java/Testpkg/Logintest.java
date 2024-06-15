package Testpkg;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.awt.Window;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Basepkg.Baseclass;
import Pagepkg.Loginpage;
import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;
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
	public void carttest() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		WebElement category=driver.findElement(By.xpath("//*[@id=\"HeaderMenu-shop-by-category\"]/span"));
		Actions act=new Actions(driver);
		act.moveToElement(category);
		act.perform();
		
		driver.findElement(By.xpath("//*[@id=\"HeaderMenu-shop-by-category-all\"]")).click();
		driver.findElement(By.xpath("/html/body/main/div[2]/div/div/div/div/ul/li[1]/div/div/div[2]/div[1]/h3/a")).click();
		driver.findElement(By.xpath("/html/body/main/section/section/div/div[2]/product-info/delivery-time/form/input[1]")).sendKeys("683562");
		driver.findElement(By.xpath("/html/body/main/section/section/div/div[2]/product-info/delivery-time/form/button")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/main/section/section/div/div[2]/product-info/div[4]/product-form/form/div/div[2]/button[2]")).click();
	
		//driver.findElement(By.xpath("html/body/main/div[2]/div/div/div/div/ul/li[1]/button")).click();
		//driver.findElement(By.xpath("/html/body/div[2]/sticky-header/header/div/a[3]/div[1]/span")).click();
	
	//	driver.findElement(By.className("swym-add-to-cart-btn swym-button swym-button-1 swym-is-button swym-bg-2 swym-color-4 swym-is-button")).click();
	
Set<String>	hSet=driver.getWindowHandles();
Iterator wIterator=hSet.iterator();
String pString= (String) wIterator.next();
String cString=(String) wIterator.next();
System.out.println(pString);
System.out.println(cString);
driver.switchTo().window(cString);
Thread.sleep(3000);
driver.findElement(By.id("cart-notification-button")).click();
//driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/cart-items/form/div/div/table/tbody/tr[4]/td[2]/div[3]/cart-remove-button/a")).click();

		
	

	
				
			
			
		
		

}
	@Test(priority = 3)
	public void logo() throws Exception
	{
		Thread.sleep(3000);
		boolean logo=driver.findElement(By.xpath("//*[@id=\"shopify-section-sections--16317651026082__header\"]/sticky-header/header/a/div/img")).isDisplayed();
		if(logo)
		{
			System.out.println("logo is displayed");
			
		}
		else {
			System.out.println("logo is not displayed");
			
		}
	}
	@Test(priority = 4)
	public void screenshot() throws Exception
	{
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler .copy(srcFile,new File("D://d2.png"));

			
			WebElement element=driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/cart-items/form/div/div/table/tbody/tr[1]/td[2]/div[3]/move-to-wishlist-button"));
		File bFile=element.getScreenshotAs(OutputType.FILE);
		FileHandler .copy(bFile, new File("./Screenshot123/new23.png"));
			
	}
	@Test(priority = 5)
	public void search() throws Exception
	{
		
	
		driver.findElement(By.xpath("/html/body/div[3]/sticky-header/header/predictive-search/form/div[1]/input[1]")).sendKeys("gold rings");
		driver.findElement(By.xpath("/html/body/div[3]/sticky-header/header/predictive-search/form/div[2]/div/div[1]/div[1]/div/ul/li[2]/a/div/p/mark")).click();
		driver.findElement(By.xpath("/html/body/main/section/div/div[2]/div/div/ul/li[1]/button")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[3]/sticky-header/header/div/a[2]")).click();
	}
	
	
	


	@Test(priority = 6)
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
		
	}
	@Test(priority = 7)
	public void logout()
	{
		driver.findElement(By.xpath("/html/body/main/div/div/div[3]/a")).click();
	}
		

}
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
			
		
		
		

	

