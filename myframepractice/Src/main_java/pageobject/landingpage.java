package pageobject;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponent.abstractComponent;

public class landingpage extends abstractComponent {
public WebDriver driver;
	public landingpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (id="autocomplete-0-input")
		WebElement search;
	@FindBy(css="div[class='right-block'] li")
	List<WebElement> items;
	

	
	public void launch() {
		driver.get("https://www.jiomart.com/");
	}
	
	public List<WebElement> find(String name) {
		search.sendKeys(name, Keys.ENTER);
		return items;
	}
	
	
	}


