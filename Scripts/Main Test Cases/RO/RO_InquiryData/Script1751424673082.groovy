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
import pemadananData.IncrementingDataKodeBU as IncrementingDataKodeBU

WebUI.comment('Project Path Sudah Dinamis untuk Upload File')

String projectpath = RunConfiguration.getProjectDir()

println(projectpath)

String filepath = projectpath + '/Pemadanan Data.xlsx'

println(filepath)

WebUI.callTestCase(findTestCase('Common Test Cases/LoginRO'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Inquiry Data/MenuInquiryData'))

WebUI.comment('Gunakan DatePicker Periode')

WebUI.click(findTestObject('Inquiry Data/Periode/parentdatePickerPeriode'))

WebUI.verifyElementPresent(findTestObject('Inquiry Data/Periode/btnDatePickerTahunPrevious'), 0)

WebUI.enhancedClick(findTestObject('Inquiry Data/Periode/btnDatePickerTahunPrevious'))

WebUI.delay(3)

WebUI.enhancedClick(findTestObject('Inquiry Data/Periode/btnDatePickerTahunPrevious'))

WebUI.click(findTestObject('Inquiry Data/Periode/btnDatePickerJuly'))

WebUI.comment('New Popup Badan Usaha')

WebUI.click(findTestObject('Inquiry Data/btnMorePilihBadanUsaha'))

WebUI.selectOptionByValue(findTestObject('Inquiry Data/dropdownPilihOpsiPencarianBadanUsaha'), '2', false)

WebUI.setText(findTestObject('Inquiry Data/textBoxMasukkanKataPencarian'), GlobalVariable.kodeBU_Global)

WebUI.click(findTestObject('Inquiry Data/btnCariBadanUsaha'))

WebUI.click(findTestObject('Inquiry Data/btnConfirmPilihBadanUsaha'))

WebUI.comment('Upload File Dinamis sesuai Project Masing2')

CustomKeywords.'pemadananData.IncrementingDataKodeBU.readAndIncrementExcelCell'('inquiry', 1, 0)

WebUI.uploadFile(findTestObject('Inquiry Data/btnUploadFileInquiry'), filepath)

WebUI.click(findTestObject('Inquiry Data/btnProsesGreen'))

WebUI.click(findTestObject('Inquiry Data/btnDownloadtoExcel'))

WebUI.click(findTestObject('Inquiry Data/btnDownloadtoCSV'))

WebUI.click(findTestObject('Inquiry Data/btnDownloadPDF-Print'))

WebUI.switchToWindowIndex(1)

WebUI.takeFullPageScreenshot()

