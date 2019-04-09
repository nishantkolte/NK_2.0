package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.DriverInit;

public class HomePage {
	static WebDriver driver=DriverInit.driver;
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (xpath="//a[text()=\"Home\"]")
	public static WebElement HomeTab;

	@FindBy (xpath="//a[contains(text(),\"Login Management\")]")
	public static WebElement LoginManagementLink;
	
	@FindBy (xpath="//a[contains(text(),\"sitemap\")]")
	public static WebElement Sitemap;
	
}
