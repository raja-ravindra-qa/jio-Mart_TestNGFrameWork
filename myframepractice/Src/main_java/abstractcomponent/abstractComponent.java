package abstractcomponent;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobject.cartpage;
import pageobject.mainpagemenu;

public class abstractComponent {

public WebDriver driver;

	public abstractComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	
	
@FindBy (css=".cart_text")
WebElement cart;

@FindBy (xpath="//a[normalize-space()='Sign in / Sign up']")
WebElement signin;

@FindBy (xpath="//div[@class='menu_section']")
WebElement mpmenu;

public cartpage gotocart() {
	cartpage crt=new cartpage(driver);
	cart.click();
	return crt;
}

public void signIn() {
	signin.click();
}

public mainpagemenu gotomainpagemenu() {
	mainpagemenu mpm = new mainpagemenu(driver);
	mpmenu.click();
	return mpm;
	
}

	
	
	
	}
	
	
	
	


