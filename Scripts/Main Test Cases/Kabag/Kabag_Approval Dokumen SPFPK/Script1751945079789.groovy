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
import java.awt.Robot as Robot
import java.awt.event.KeyEvent as KeyEvent

WebUI.callTestCase(findTestCase('Common Test Cases/LoginKabag'), [('Username') : 'John Doe', ('Password') : 'ThisIsNotAPassword'], 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Approval - Perencanaan/buttonExpandApprovalPerencanaan'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Approval - Perencanaan/radioButtonApproveDokumenSPFK'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Approval - Perencanaan/datepickerPeriodePeriksa'), FailureHandling.STOP_ON_FAILURE)

WebUI.comment('Gunakan DatePicker Periode')

WebUI.click(findTestObject('Inquiry Data/Periode/btnDatePickerJuly'), FailureHandling.STOP_ON_FAILURE)

WebUI.selectOptionByValue(findTestObject('Pemeriksaan - Perencanaan/dropdownSelectKategori'), '4', false, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Pengawasan - Canvassing/btnCariGreen'), FailureHandling.STOP_ON_FAILURE)

WebUI.takeScreenshot(FailureHandling.STOP_ON_FAILURE)

TestObject tableRow = new TestObject().addProperty('xpath', com.kms.katalon.core.testobject.ConditionType.EQUALS, '//td[contains(text(),\'017\')]')

WebUI.waitForElementVisible(tableRow, 10, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Inquiry Data/btnDownloadtoExcel'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Inquiry Data/btnDownloadtoCSV'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Inquiry Data/btnDownloadPDF-Print'), FailureHandling.STOP_ON_FAILURE)

WebUI.closeWindowIndex(1, FailureHandling.STOP_ON_FAILURE)

WebUI.switchToWindowIndex(0, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(tableRow, 10, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Pemeriksaan - Perencanaan/checkboxTableRowPerencanaan'), FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('Approval - Perencanaan/buttonApproveSPPKSimpan'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Pemeriksaan - Pelaksanaan - Pelaporan/buttonUnduhSPFK'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Pemeriksaan - Perencanaan/checkboxTableRowPerencanaan'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Approval - Perencanaan/buttonApproveSPPKSimpan'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Pemeriksaan - Perencanaan/buttonKonfirmasiYa'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Analisa Data Mandiri/btnOkPopup'), FailureHandling.STOP_ON_FAILURE)

WebUI.takeScreenshot(FailureHandling.STOP_ON_FAILURE)

