package pageobject;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponent.abstractComponent;

public class mainpagemenu extends abstractComponent {
public WebDriver driver;
	public mainpagemenu(WebDriver driver) {
		 super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[normalize-space()='Home']")
	private WebElement home;
	
	@FindBy(xpath="//a[normalize-space()='Shop by Category']")
	WebElement shopByCategory;
	
	@FindBy(xpath="//a[normalize-space()='My List']")
	WebElement myList;
	
	@FindBy(xpath="//a[normalize-space()='JioMart Wallet']")
	WebElement jioMartWallet;
	
	@FindBy(xpath="//a[normalize-space()='JioMart Gift Store']")
	WebElement jioMartGiftStore;
	
	@FindBy(xpath="//a[normalize-space()='JioMart Gift Card']")
	WebElement jioMartGiftCard;
	
	
	@FindBy(xpath="//a[@class='jiomart-giftcard']")
	WebElement goGreenWithJioMart;
	
	@FindBy(xpath="//a[normalize-space()='All Offers']")
	WebElement allOffers;
	
	public void gotoHome() {home.click();}
	
	public void gotoshopbycategory() {shopByCategory.click();}
	
	public void gotomyList() {myList.click();}
	
	public void gotojioMartWallet() {jioMartWallet.click();}
	
	public void gotojiomartgiftstore() {jioMartGiftStore.click();}
	
	public void gotojioMartGiftCard() {jioMartGiftCard.click();}
	
	public void gotogoGreenWithJioMart() {goGreenWithJioMart.click();}
	
	public void gotoallOffers() {allOffers.click();}
	
	

}
