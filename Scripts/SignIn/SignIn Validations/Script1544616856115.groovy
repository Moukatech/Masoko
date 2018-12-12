import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

TestData data = findTestData('SigninValidations')

WebUI.openBrowser(findTestData('SigninValidations').getValue(1, 1))

WebUI.maximizeWindow()

WebUI.delay(3)

WebUI.click(findTestObject('Signin Page/Link- SignIn'))

for (def index : (0..data.getRowNumbers() - 1)) {
    WebUI.setText(findTestObject('Signin Page/Input-Email'), data.internallyGetValue('Email', index))

    WebUI.delay(2)

    WebUI.setText(findTestObject('Signin Page/Input-Password'), data.internallyGetValue('Password', index))

    WebUI.delay(2)

    WebUI.click(findTestObject('Signin Page/Button-Signin'))

    WebUI.delay(5)

    not_run: WebUI.verifyTextPresent(data.internallyGetValue('VerificationMessage', index), false)

    if (((index == 0) && (index == 1)) && (index == 3)) {
        WebUI.verifyElementPresent(findTestObject('Signin Page/Error Message-Email'), 0)
    }
    
    if (index == 2) {
        WebUI.verifyElementPresent(findTestObject('Signin Page/Error Message-Email'), 0)

        WebUI.verifyElementPresent(findTestObject('Signin Page/Error Message-Password Required'), 0)
    }
    
    if (index == 4) {
        WebUI.verifyElementPresent(findTestObject('Signin Page/Error Message- Invalid passwrd and email'), 0)
    }
    
    if (index == 5) {
        WebUI.verifyElementPresent(findTestObject('Signin Page/Element -My Account'), 0)
    }
}

WebUI.delay(2)

WebUI.mouseOver(findTestObject('Signin Page/Element -My Account'))

WebUI.click(findTestObject('Signin Page/Link-Logout'))

