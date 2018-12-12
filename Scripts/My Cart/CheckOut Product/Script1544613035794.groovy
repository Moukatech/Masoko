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

WebUI.setText(findTestObject('My Cart/Checkout Product/Input- Street Address'), findTestData('Checkout').getValue(1, 1))

WebUI.delay(3)

WebUI.setText(findTestObject('My Cart/Checkout Product/Input- Town'), findTestData('Checkout').getValue(4, 1))

WebUI.delay(3)

WebUI.click(findTestObject('My Cart/Checkout Product/DropDown-Province'))

WebUI.delay(3)

WebUI.click(findTestObject('My Cart/Checkout Product/Select Province', [('province') : findTestData('Checkout').getValue(
                5, 1)]))

WebUI.delay(3)

WebUI.setText(findTestObject('My Cart/Checkout Product/Input- Mobile No'), findTestData('Checkout').getValue(6, 1))

WebUI.delay(3)

WebUI.click(findTestObject('My Cart/Checkout Product/CheckBox- Save address'))

