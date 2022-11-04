package pageobject;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponent.abstractComponent;

public class cartpage extends abstractComponent {
public WebDriver driver;
	public cartpage(WebDriver driver) {
		 super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy (css=".available-amt")
		WebElement totalamount;
	@FindBy(css="#cart_netpay_amt1")
	WebElement netpay;
	
	public void prnttotalamount() {
		System.out.println(totalamount.getText());
	}
	public void prnttonetpay() {
		System.out.println(netpay.getText());
	}
	

}
