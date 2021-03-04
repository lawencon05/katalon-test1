package com.lawencon.wedemy
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


class Login {
		
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("User open browser and navigates to Login Page")
	def openBrowserAndNavigateToLoginPage() {
		println 'User open browser and navigates to Login Page'
		
		WebUI.openBrowser('')		
		WebUI.navigateToUrl('http://localhost:90')
	}

	@When("^User input \"([^\"]*)\"$ and \"([^\"]*)\"$")
	def setUsernameAndPass(String username, String password) {
		WebUI.click(findTestObject('WEB/Login/menu masuk'))
		WebUI.setText(findTestObject('WEB/Login/input username'), username)		
		WebUI.setText(findTestObject('WEB/Login/input password'), password)
		
		println "User input "+username+" and "+password
	}

	@Then("System validates it and User navigates to Home Page")
	def validateCredentials() {
		WebUI.click(findTestObject('WEB/Login/button masuk'))
	}
	
//	@DataTableType(replaceWithEmptyString = "[blank]")
//	public String stringType(String cell) {
//		return cell;
//	}
}