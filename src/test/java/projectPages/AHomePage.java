package projectPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aTestBase.AwebtestBase;

public class AHomePage extends AwebtestBase{
	@FindBy(xpath= "//*[@id=\"nav-link-accountList\"]/span")
    WebElement AccountSignin;
	
    public AHomePage(){
        PageFactory.initElements(driver,this);
    }

    public void SigninClick(){
        AccountSignin.click();
   
    }
	

}



