package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.DriverInit;

public class MFAPage {
	static WebDriver driver=DriverInit.driver;
	public MFAPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (xpath="//h2[text()=\"You're almost there!\"]")
	public static WebElement MFApageTitle;

	@FindBy (xpath="//label[contains(text(),\"Email ni*****@mercer.com\")]")
	public static WebElement SelectEmail;
	
}
