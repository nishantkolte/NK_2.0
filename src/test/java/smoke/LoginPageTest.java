package smoke;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import data.TestData;
import pages.LoginPage;
import pages.MFAPage;
import utilities.DriverInit;
import utilities.Functions;
import utilities.TestListeners;

@Listeners (utilities.TestListeners.class)
public class LoginPageTest {
	
	public static WebDriver driver;
	
	@Parameters("environment")
	@BeforeClass (groups="smoke")
	public void initDriver(String env){
	InitTestData(env);
	initPages();
	driver=DriverInit.driver;
	driver.get(TestData.url);
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
	}


	@Test (priority=1, groups="smoke") 
	public void successful_Login_Test() throws InterruptedException, IOException{
	try{	
		TestListeners.test.setDescription("to verifiy successful login with valid credentials");
		
	Functions.setText(LoginPage.Username, TestData.username);
	Functions.setText(LoginPage.Password, TestData.password);
	Functions.click(LoginPage.LoginButton);
	Functions.verifyElementDisplayed(MFAPage.MFApageTitle);
	}
	catch(Exception e){
	e.printStackTrace();
	Assert.fail("Test case failed!");
	}
}
	

	@Test (priority=2, groups="smoke")
	public void invalid_Login_Test() throws InterruptedException, IOException{
	try{	
		TestListeners.test.setDescription("to verifiy error message on login page when invalid credentials are entered");
		driver.get(TestData.url);
		Thread.sleep(2000);
		Functions.verifyElementDisplayed(MFAPage.MFApageTitle);
		//Assert.fail();
	
	}
	catch(Exception e){
	e.printStackTrace();
	Assert.fail("Test case failed!");
	}
	
	}
	
	@AfterClass
	public void after(){
	driver.close();
	}

	private void initPages() {
	LoginPage page1=new LoginPage();
	MFAPage page2=new MFAPage();		
	}

	private void InitTestData(String env) {
		TestData data = new TestData(env);
}
}


