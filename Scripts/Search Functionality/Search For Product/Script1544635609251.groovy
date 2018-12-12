import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

TestData data = findTestData('Search')

KeywordLogger log = new KeywordLogger()


WebUI.openBrowser(GlobalVariable.baseURL)

WebUI.maximizeWindow()

WebUI.delay(2)

for (def index : (0..data.getRowNumbers() - 1)) {
    WebUI.click(findTestObject('Search Product/Dropdown- Category'))

    WebUI.delay(2)

    WebUI.click(findTestObject('Search Product/Select- Category_VAR', [('Category') : data.internallyGetValue('Category', 
                    index)]))

    WebUI.delay(1)

    WebUI.setText(findTestObject('Search Product/Search Box'), data.internallyGetValue('SearchInput', index))

    WebUI.delay(1)

    WebUI.click(findTestObject('Search Product/Search Button'))

    WebUI.delay(2)

    Results_After_Search = WebUI.getText(findTestObject('Search Product/Grid- Returned Items'))

    if(Results_After_Search.contains(data.internallyGetValue('SearchInput', index))){
		KeywordUtil.markPassed("Search Result Matches Input")
	}
	
	else{
		KeywordUtil.markFailed("ERROR!!Search Result NOT Matching Input")
	}
}

