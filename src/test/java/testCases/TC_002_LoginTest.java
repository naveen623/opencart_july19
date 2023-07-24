package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
	
	@Test(groups= {"Sanity","Master"}) //Step8 groups added
	public void test_login() {
		
		logger.info("Starting TC_002_LoginTest");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(rb.getString("email"));
		lp.setPassword(rb.getString("password"));
		logger.info("Set Password");
		lp.clickLogin();
		logger.info("Clicked on Login Button");
		
		
		MyAccount macc = new MyAccount(driver);
		boolean targetPage = macc.isMyAcountPageExists();
		Assert.assertEquals(targetPage, true);
	}
		
	
	catch(Exception e) {
		Assert.fail();
	
	}
	logger.info(" Finished TC_002_LoginTest");
		
 }
	
}
