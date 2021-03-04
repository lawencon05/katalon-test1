import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

'test without login'
for (def datas : dataProfile.properties.getAt('allData')) {
    response = WS.sendRequest(findTestObject('API/Student/Profile/GET Profile', [('id') : datas[0]]))

    WS.verifyResponseStatusCode(response, 401, FailureHandling.CONTINUE_ON_FAILURE)
}

WebUI.callTestCase(findTestCase('API/Login/Admin/TC_Login_Valid'), [('dataLogin') : findTestData('Data Valid/Login/TD_Login_Admin')], 
    FailureHandling.STOP_ON_FAILURE)

'test with success login but wrong value'
for (def datas : dataProfile.properties.getAt('allData')) {
    response = WS.sendRequest(findTestObject('API/Student/Profile/GET Profile', [('id') : datas[0]]))

    WS.verifyResponseStatusCodeInRange(response, 400, 500, FailureHandling.CONTINUE_ON_FAILURE)
}

