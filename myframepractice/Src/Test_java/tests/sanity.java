package tests;

import org.testng.annotations.Test;

import abstractcomponent.baseclass;
import pageobject.cartpage;
import pageobject.mainpagemenu;

public class sanity extends baseclass {
	
	@Test
	public void urlcheck() {
		lp.launch();
	}
	
	@Test
	public void search() {
		lp.find("veg");
	}
	
	@Test
	public void signin() {
		lp.signIn();
		
	}
	
	@Test
	public void cart() {
		lp.gotocart();
	}
	
	@Test
	public void mainPageMenu() {
		mainpagemenu mmpm=lp.gotomainpagemenu();
	}
	
	@Test
	public void mainPageMenu1() {
		mainpagemenu mpm=lp.gotomainpagemenu();
		mpm.gotoHome();
	}

	
	@Test
	public void mainPageMenu2() {
		mainpagemenu mpm=lp.gotomainpagemenu();
		mpm.gotoshopbycategory();
	}
	
	@Test
	public void mainPageMenu3() {
		mainpagemenu mpm=lp.gotomainpagemenu();
		mpm.gotomyList();
	}
	
	@Test
	public void mainPageMenu4() {
		mainpagemenu mpm=lp.gotomainpagemenu();
		mpm.gotojioMartWallet();
	}
	
	@Test
	public void mainPageMenu5() {
		mainpagemenu mpm=lp.gotomainpagemenu();
		mpm.gotojiomartgiftstore();
	}
	
	@Test
	public void mainPageMenu6() {
		mainpagemenu mpm=lp.gotomainpagemenu();
		mpm.gotojioMartGiftCard();
	}
	
	
	@Test
	public void mainPageMenu7() {
		mainpagemenu mpm=lp.gotomainpagemenu();
		mpm.gotogoGreenWithJioMart();
	}
	
	
	@Test
	public void mainPageMenu8() {
		mainpagemenu mpm=lp.gotomainpagemenu();
		mpm.gotoallOffers();
	}
	
}
		
		