package com.lawencon.util

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import groovy.json.JsonOutput
import groovy.json.JsonSlurper
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

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

class ApiUtil {

	def setToken(def variable) {
		for(def datas in variable.properties.getAt("allData")) {
			try {
				def data = convertToJsonMap(datas)
				setToken(data.username, data.userPassword)
			} catch (Exception e) {
				e.printStackTrace()
			}
		}
	}

	def setToken(String username, String pass) {
		String token = GlobalVariable.token
		if(token.equals("")) {
			def response = WS.sendRequest(findTestObject('API/Login/POST Login',
					["data": JsonOutput.toJson(["username":username, "userPassword":pass])]))

			def check = WS.verifyResponseStatusCode(response, 200, FailureHandling.CONTINUE_ON_FAILURE)

			if(check) {
				JsonSlurper slurper = new JsonSlurper()
				Map parsedJson = slurper.parseText(extractResponse(response))

				GlobalVariable.token = parsedJson.get("token")
			}
		}
	}

	def extractResponse(response) {
		return response.properties.get("responseText")
	}

	def convertToJsonStr(def data) {
		JsonSlurper slurper = new JsonSlurper()
		Map parsedJson = slurper.parseText(data)
		return JsonOutput.toJson(parsedJson)
	}

	def convertToJsonMap(def data) {
		JsonSlurper slurper = new JsonSlurper()
		return slurper.parseText(data)
	}
}