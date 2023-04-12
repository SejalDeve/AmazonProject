package aTestCase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import aTestBase.AwebtestBase;

import projectPages.AHomePage;
import projectPages.ALoginPage;
import projectPages.AccountPage;

public class Atc01 extends AwebtestBase{
	AccountPage myAccountPage;
	AHomePage homePage;
	ALoginPage loginPage;
	
	
	//loading the config file
	public Atc01() {
		super(); 
	}
	@BeforeMethod
	public void BeforeMethod()
	{			
		
		initialization();
					
		homePage = new AHomePage();
		loginPage = new ALoginPage();
		myAccountPage=new AccountPage();
		
		}

			@Test		
			public void verifyLoginWithValidCredential(){
				//softAssert-
			SoftAssert softAssert = new SoftAssert();
			homePage.SigninClick();
			loginPage.Amazlogin(prop.getProperty("phoneno"), prop.getProperty("password"));
			softAssert.assertAll();
			}

			
			@Test
			public void verifySearchBar(){
			SoftAssert softAssert = new SoftAssert();
			myAccountPage.search();						
			softAssert.assertAll();
			}

            @Test
            public void verifyDropDown() {
            	SoftAssert softAssert = new SoftAssert();
            	myAccountPage.selectDropDown("byVisibleText", "Under ₹500");
            	softAssert.assertAll();
            }
            
			//mouse hovering on the user
			@Test
			public void verifyMouseHover(){
			SoftAssert softAssert = new SoftAssert();
			myAccountPage.mouseHover();
			softAssert.assertAll();
			}

			//to scroll down upto facebook
			@Test
			public void verifyScrollDown(){
			SoftAssert softAssert = new SoftAssert();
			myAccountPage.scrollDownMethod();
			softAssert.assertAll();
			}
			
			@Test
			public void verifyScrollUp() {
				SoftAssert softAssert = new SoftAssert();
				myAccountPage.scrollUpMethod();
				softAssert.assertAll();
				
			}

			//click utube option and switching to that window
			@Test
			public void verifyGetWindowHandle(){
			SoftAssert softAssert = new SoftAssert();
			myAccountPage.windowHandle();
			softAssert.assertAll();
			}

			//printing the cookies in the window
			@Test
			public void verifyCookiesHandle(){
			SoftAssert softAssert = new SoftAssert();
			myAccountPage.getCookiesHandle();
			softAssert.assertAll();
			}
			
	@AfterMethod
	public void afterMethod(){
	driver.close();
	}

}
