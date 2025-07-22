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
import java.time.LocalDate as LocalDate
import java.time.format.DateTimeFormatter as DateTimeFormatter
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.WebElement as WebElement

// Define today's date in the expected format (adjust format if needed)
LocalDate today = LocalDate.now()

String formattedDate = today.format(DateTimeFormatter.ofPattern('dd/MM/yyyy'))

String todayDate = today.format(DateTimeFormatter.ofPattern('dd'))

println(todayDate)

WebUI.callTestCase(findTestCase('Common Test Cases/LoginRO'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Pemeriksaan - Pemantauan/Page_Awasrik Selamat Datang/p_Pemeriksaan'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Pemeriksaan - Pemantauan/Page_Awasrik Selamat Datang/p_Pemantauan'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Pemeriksaan - Pemantauan/Page_Awasrik Pemantauan/button_Badan Usaha_btnSearchBU'), FailureHandling.STOP_ON_FAILURE)

WebUI.selectOptionByValue(findTestObject('Pemeriksaan - Pemantauan/Page_Awasrik Pemantauan/select_Nama BUKode BU'), '2', 
    true, FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Pemeriksaan - Pemantauan/Page_Awasrik Pemantauan/input_Opsi Pencarian_paramCariBU'), GlobalVariable.kodeBU_Global,
	FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Pemeriksaan - Pemantauan/Page_Awasrik Pemantauan/button_Cari'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Pemeriksaan - Pemantauan/Page_Awasrik Pemantauan/button_Pilih'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Pemeriksaan - Pemantauan/Page_Awasrik Pemantauan/input_Tanggal Pemeriksaan_periode'), FailureHandling.STOP_ON_FAILURE)

String DynamicDatePicker = ('//div[contains(@class, \'datepicker-days\')]//td[@class=\'day\' and text()=\'' + todayDate) + 
'\']'

println(DynamicDatePicker)

TestObject dynamicDate = new TestObject('dynamicDate')

dynamicDate.addProperty('xpath', ConditionType.EQUALS, DynamicDatePicker)

WebUI.waitForElementClickable(dynamicDate, 10, FailureHandling.STOP_ON_FAILURE)

WebUI.click(dynamicDate, FailureHandling.STOP_ON_FAILURE)

WebUI.selectOptionByValue(findTestObject('Pemeriksaan - Perencanaan/dropdownSelectKategori'), '4', false, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Pemeriksaan - Pemantauan/Page_Awasrik Pemantauan/button_Cari_1'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Inquiry Data/btnDownloadtoExcel'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Inquiry Data/btnDownloadtoCSV'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Inquiry Data/btnDownloadPDF-Print'), FailureHandling.STOP_ON_FAILURE)

WebUI.switchToWindowIndex(1)

WebUI.takeFullPageScreenshot()

WebUI.closeWindowIndex(1)

WebUI.switchToWindowIndex(0)

WebUI.takeScreenshot()

WebUI.click(findTestObject('Pemeriksaan - Pemantauan/Page_Awasrik Pemantauan/button_Cek Ulang'), FailureHandling.STOP_ON_FAILURE)

WebUI.takeScreenshot()

WebUI.click(findTestObject('Pemeriksaan - Pemantauan/Page_Awasrik Pemantauan/button_XLS'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Pemeriksaan - Pemantauan/Page_Awasrik Pemantauan/button_Kembali'), FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('Pemeriksaan - Pemantauan/Page_Awasrik Pemantauan/button_Unduh'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Pemeriksaan - Pemantauan/Page_Awasrik Pemantauan/button_Unduh'), FailureHandling.STOP_ON_FAILURE)

WebUI.takeScreenshot()

WebUI.click(findTestObject('Pemeriksaan - Pemantauan/Page_Awasrik Pemantauan/button_Update'), FailureHandling.STOP_ON_FAILURE)

WebUI.takeScreenshot()

WebUI.selectOptionByValue(findTestObject('Pemeriksaan - Pemantauan/Page_Awasrik Pemantauan/select_PatuhPatuh Dengan CatatanTidak Patuh'), 
    '3', true, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Pemeriksaan - Pemantauan/Page_Awasrik Pemantauan/button_Simpan'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Pemeriksaan - Pemantauan/Page_Awasrik Pemantauan/button_OK'), FailureHandling.STOP_ON_FAILURE)

WebUI.takeScreenshot()

