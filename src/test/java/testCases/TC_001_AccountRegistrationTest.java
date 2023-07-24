package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	
	
	@Test(groups= {"Regression","Master"}) //Step8 groups added
	public void test_account_Registration() throws InterruptedException
	{
			
		
		logger.info("***  Starting TC_001_AccountRegistrationTest ***");
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on My account link");
		
		hp.clickRegister();
		logger.info("Clicked on register link");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		logger.info("Providing customer data");
		
		regpage.setFirstName(randomeString().toUpperCase());
		
		regpage.setLastName(randomeString().toUpperCase());
		
		regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
		
		
		
		String password=randomAlphaNumeric();
		regpage.setPassword(password);
		
		WebElement agree = driver.findElement(By.xpath("//input[@name='agree']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", agree);
		Thread.sleep(500);
		
		
		regpage.setPrivacyPolicy();
		
		regpage.clickContinue();
		logger.info("Clicked on continue");
		
		String confmsg=regpage.getConfirmationMsg();
		
		logger.info("Validating expected message");
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("***  Finished TC_001_AccountRegistrationTest ***");
		
	}
	
	
}
