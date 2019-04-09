package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.DriverInit;

public class LoginPage {
	static WebDriver driver=DriverInit.driver;
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//input[@id='username']")
	public static WebElement Username;
	
	@FindBy (xpath="//input[@id='password']")
	public static WebElement Password;
	
	@FindBy (xpath="//button[text()='Login']")
	public static WebElement LoginButton;
	
}
