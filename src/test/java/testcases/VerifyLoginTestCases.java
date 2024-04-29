package testcases;

import org.openqa.selenium.By;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjectModel.LoginPageObjects;
import pageObjectModel.RegistrationPageObjects;
import resources.baseclass;
import resources.constant;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjectModel.LoginPageObjects;
import pageObjectModel.RegistrationPageObjects;
import resources.baseclass;

public class VerifyLoginTestCases extends baseclass {

	@Test
	public void verifyLoginithValidData() throws IOException, InterruptedException {

		RegistrationPageObjects rpo = new RegistrationPageObjects(driver);
		rpo.clickOnMyAccount().click();

		LoginPageObjects lpo = new LoginPageObjects(driver);

		lpo.clickOnLogin().click();

		lpo.enterEmail().sendKeys(email);
		Thread.sleep(2000);
		lpo.enterPassword().sendKeys(constant.password);
		lpo.clickOnSubmitButton().click();

		SoftAssert sa = new SoftAssert();

		String actual = driver.findElement(By.xpath("//h2[text()='My Account']")).getText();
		String expected = "My Account";
		sa.assertEquals(actual, expected);
		sa.assertAll();

	}

	@Test
	public void verifyLoginithInValidData() throws IOException, InterruptedException {

		RegistrationPageObjects rpo = new RegistrationPageObjects(driver);
		rpo.clickOnMyAccount().click();

		LoginPageObjects lpo = new LoginPageObjects(driver);

		lpo.clickOnLogin().click();

		lpo.enterEmail().sendKeys(email);
		Thread.sleep(2000);
		lpo.enterPassword().sendKeys(constant.invalidPassword);
		lpo.clickOnSubmitButton().click();

		SoftAssert sa = new SoftAssert();

		String actual = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		String expected = "Warning: No match for E-Mail Address and/or Password.";
		sa.assertEquals(actual, expected);
		sa.assertAll();

	}

}
