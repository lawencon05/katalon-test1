package com.lawencon.wedemy

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import cucumber.api.java.en.And

class Login {

	@When("User opens The Browser")
	def openBrowser() {
		WebUI.openBrowser('')
	}

	@Then("navigates to Home Page")
	def navigateToHomePage() {
		WebUI.navigateToUrl('http://localhost:90')
	}

	@When("click masuk menu")
	def clickMasukMenu() {
		WebUI.click(findTestObject('WEB/Login/menu masuk'))
	}

	@When("navigates to Login Page")
	def navigateToLoginPage() {}

	@When("input valid (.*) and (.*)")
	def setUsernameAndPassValid(String username, String password) {
		username = valInput(username)
		password = valInput(password)

		WebUI.setText(findTestObject('WEB/Login/input username'), username)
		WebUI.setText(findTestObject('WEB/Login/input password'), password)
	}

	@When("input invalid (.*) and (.*)")
	def setUsernameAndPassInvalid(String username, String password) {
		setUsernameAndPassValid(username, password)
	}

	@And("click masuk button")
	def clickMasukButton() {
		WebUI.click(findTestObject('WEB/Login/button masuk'))
	}

	@Then("navigates to The Dashboard Page Admin")
	def navigateToDashboardPageAdmin() {
		WebUI.verifyElementPresent(findTestObject('WEB/Dashboard/Admin/Page_Homepage/dashboard admin'), 5)
		WebUI.closeBrowser()
	}

	@Then("navigates to The Dashboard Page Student")
	def navigateToDashboardPageStudent() {
		def test = WebUI.verifyElementPresent(findTestObject('WEB/Dashboard/Student/Page_Homepage/student profile'), 5)
		WebUI.closeBrowser()
	}

	@Then("still in Login Page")
	def stillInLoginPage() {
		WebUI.delay(5)
		WebUI.verifyElementPresent(findTestObject('WEB/Login/box login'), 1)
		WebUI.closeBrowser()
	}

	def valInput(def val) {
		if(val.equals("[blank]")) return ""
		return val;
	}
}