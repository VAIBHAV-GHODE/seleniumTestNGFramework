package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjectModel.RegistrationPageObjects;

import java.io.IOException;
//import org.openqa.selenium.By; 
import resources.baseclass;
import resources.constant;

public class VerifyResgistrationTestCases extends baseclass {

	@Test 
 	public void verifyRegisterationWithValidData() throws IOException, InterruptedException { 
  
		RegistrationPageObjects rpo = new RegistrationPageObjects(driver); 
  
 		rpo.clickOnMyAccount().click(); 
 		rpo.clickOnMyRegister().click(); 
 		rpo.enterFirstName().sendKeys(constant.firstname); 
 		rpo.enterlastName().sendKeys(constant.lastname); 
 		rpo.enteremailid().sendKeys(email); 
 		Thread.sleep(4000); 
 		rpo.entertelephoneno().sendKeys(constant.phone); 
 		rpo.enterPassword().sendKeys(constant.password); 
 		rpo.enterconfirmpassword().sendKeys(constant.confirmpassword); 
 		rpo.clickoncheckbox().click(); 
 		rpo.clickoncontinue().click(); 
  
 		SoftAssert sa = new SoftAssert(); 
  
 		String actual = rpo.actualText().getText(); 
 		String expected = constant.expectedRegisteration; 
 		sa.assertEquals(actual, expected); 
 		sa.assertAll(); 
  
 	} 
  
 	@Test 
 	public void verifyRegisterationWithInValidData() throws IOException, InterruptedException { 
  
 	 
  
 		RegistrationPageObjects rpo = new RegistrationPageObjects(driver); 
  
 		rpo.clickOnMyAccount().click(); 
 		rpo.clickOnMyRegister().click(); 
 		rpo.clickoncontinue().click(); 
  
 		SoftAssert sa = new SoftAssert(); 
  
 		String fnActual = driver 
 				.findElement(By.xpath("//div[text()='First Name must be between 1 and 32 characters!']")).getText(); 
 		String fnExpected = "First Name must be between 1 and 32 characters!"; 
  
 		String lnActual = driver.findElement(By.xpath("//div[text()='Last Name must be between 1 and 32 characters!']")) 
 				.getText(); 
 		String lnExpected = "Last Name must be between 1 and 32 characters!"; 
  
 		sa.assertEquals(fnActual, fnExpected); 
  
 		sa.assertEquals(lnActual, lnExpected); 
 		sa.assertAll(); 
  
 	} 

}
