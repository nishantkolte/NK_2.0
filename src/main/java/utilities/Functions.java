package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Functions {
	public static WebDriver driver=DriverInit.driver;
	
	public static void click(WebElement element) throws InterruptedException{
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	public static void setText(WebElement locator, String value) throws InterruptedException{
		Thread.sleep(1000);
		locator.clear();
		locator.sendKeys(value);
	}
	
	public static void mousehover(WebElement element) throws InterruptedException{
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	public static void doubleClick(WebElement element) throws InterruptedException{
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
		Actions action = new Actions(driver);
		action.doubleClick(element).build().perform();
	}
	
	public static void verifyElementDisplayed(WebElement element) throws InterruptedException{
		Thread.sleep(1000);
		Assert.assertTrue(element.isDisplayed());
	}
	
	public static void verifyText(WebElement element, String text) throws InterruptedException{
		Thread.sleep(1000);
		Assert.assertEquals(element.getText(), text);
	}

	public static void takescreenshot(String testname) throws IOException {
		File myfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(myfile, new File ("Screenshots\\"+testname+"fail.png"));
		
	}

}
