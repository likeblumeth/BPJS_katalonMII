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

WebUI.callTestCase(findTestCase('Common Test Cases/LoginRO'), [('Username') : 'John Doe', ('Password') : 'ThisIsNotAPassword'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Pemeriksaan - Perencanaan/sideMenuExpandPemeriksaan'))

WebUI.click(findTestObject('Pemeriksaan - Pelaksanaan - Pelaporan/radiobuttonPelaksanaanPelaporan'))

WebUI.click(findTestObject('Inquiry Data/btnMorePilihBadanUsaha'))

WebUI.delay(5)

WebUI.selectOptionByValue(findTestObject('Inquiry Data/dropdownPilihOpsiPencarianBadanUsaha'), '2', false)

WebUI.setText(findTestObject('Pemeriksaan - Perencanaan/textboxPencarianBadanUsaha'), GlobalVariable.kodeBU_Global, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Inquiry Data/btnCariBadanUsaha'))

WebUI.click(findTestObject('Inquiry Data/btnConfirmPilihBadanUsaha'))

WebUI.selectOptionByValue(findTestObject('Pemeriksaan - Perencanaan/dropdownSelectKategori'), '4', false)

WebUI.click(findTestObject('Pengawasan - Canvassing/btnCariGreen'))

TestObject tableRow = new TestObject().addProperty('xpath', com.kms.katalon.core.testobject.ConditionType.EQUALS, '//td[contains(text(),\'017\')]')

WebUI.waitForElementVisible(tableRow, 10)

WebUI.click(findTestObject('Pemeriksaan - Perencanaan/checkboxTableRowPerencanaan'))

WebUI.scrollToElement(findTestObject('Pemeriksaan - Pelaksanaan - Pelaporan/buttonLanjutPemantauan'), 0)

WebUI.click(findTestObject('Pemeriksaan - Pelaksanaan - Pelaporan/buttonLanjutPemantauan'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Pemeriksaan - Perencanaan/buttonKonfirmasiYa'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Analisa Data Mandiri/btnOkPopup'), FailureHandling.STOP_ON_FAILURE)

