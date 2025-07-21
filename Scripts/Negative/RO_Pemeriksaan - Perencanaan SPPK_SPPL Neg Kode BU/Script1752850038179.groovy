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
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.WebElement as WebElement
import java.time.LocalDate as LocalDate
import java.time.format.DateTimeFormatter as DateTimeFormatter

// Define today's date in the expected format (adjust format if needed)
LocalDate today = LocalDate.now()

String formattedDate = today.format(DateTimeFormatter.ofPattern('dd/MM/yyyy'))

WebUI.callTestCase(findTestCase('Common Test Cases/LoginRO'), [('Username') : 'John Doe', ('Password') : 'ThisIsNotAPassword'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.takeScreenshot()

WebUI.click(findTestObject('Pemeriksaan - Perencanaan/sideMenuExpandPemeriksaan'))

WebUI.click(findTestObject('Pemeriksaan - Perencanaan/radioButtonPerencanaan'))

WebUI.click(findTestObject('Inquiry Data/btnMorePilihBadanUsaha'))

WebUI.selectOptionByValue(findTestObject('Inquiry Data/dropdownPilihOpsiPencarianBadanUsaha'), '2', false)

WebUI.setText(findTestObject('Pemeriksaan - Perencanaan/textboxPencarianBadanUsaha'), '12345678', FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Inquiry Data/btnCariBadanUsaha'))

WebUI.takeScreenshot()

WebUI.verifyElementPresent(findTestObject('Pemeriksaan - Perencanaan/labelDataNotFound'), 0)


