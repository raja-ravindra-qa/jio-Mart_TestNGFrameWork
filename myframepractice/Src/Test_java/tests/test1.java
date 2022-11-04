package tests;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import abstractcomponent.abstractComponent;
import abstractcomponent.baseclass;
import abstractcomponent.retryAnalyzer;
import pageobject.cartpage;


public class test1 extends baseclass{

	
@Test()
public void hi() {
	String hi="hello"; String Hi="Hello";
	Assert.assertEquals(hi, Hi);
	System.out.println("Hello Dear");
}

	@Test(dataProvider="getDataforSearch",retryAnalyzer=retryAnalyzer.class)
	public void method_Name_print(String item) throws IOException {
				//landingpage landingpage = new landingpage(driver);
		
		
		
		List<WebElement> itemsall =	lp.find(item); 
		System.out.println(itemsall.size());
		itemsall.stream().forEach(s->{System.out.println(s.findElement(By.cssSelector(".clsgetname")).getText());});
		itemsall.stream().forEach(s->{System.out.println(s.findElement(By.id("final_price")).getText());
		s.findElement(By.xpath("//span[@class='add_plus']")).click();});
		
		

		cartpage crt=lp.gotocart();
		crt.prnttotalamount();
		crt.prnttonetpay();  
		
			}
	
	
	
	@DataProvider
	public Object[] getDataforSearch()
	{
		String[] data = {"vegetables","fruits","groceries","laptop"};
		
		return data;
	}  
	


	
	
}
