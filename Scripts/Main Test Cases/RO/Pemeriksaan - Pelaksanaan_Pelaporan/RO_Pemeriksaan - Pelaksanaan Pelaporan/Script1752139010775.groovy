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

LocalDate today = LocalDate.now()

String formattedDate = today.format(DateTimeFormatter.ofPattern('dd/MM/yyyy'))

println(formattedDate)

WebUI.callTestCase(findTestCase('Common Test Cases/LoginRO'), [('Username') : 'John Doe', ('Password') : 'ThisIsNotAPassword'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Pemeriksaan - Perencanaan/sideMenuExpandPemeriksaan'))

WebUI.click(findTestObject('Pemeriksaan - Pelaksanaan - Pelaporan/radiobuttonPelaksanaanPelaporan'))

WebUI.click(findTestObject('Inquiry Data/btnMorePilihBadanUsaha'))

WebUI.delay(5)

WebUI.selectOptionByValue(findTestObject('Inquiry Data/dropdownPilihOpsiPencarianBadanUsaha'), '2', false)

WebUI.setText(findTestObject('Pemeriksaan - Perencanaan/textboxPencarianBadanUsaha'), GlobalVariable.kodeBU_bpstatistik_semarang, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Inquiry Data/btnCariBadanUsaha'))

WebUI.click(findTestObject('Inquiry Data/btnConfirmPilihBadanUsaha'))

WebUI.selectOptionByValue(findTestObject('Pemeriksaan - Perencanaan/dropdownSelectKategori'), '4', false)

WebUI.click(findTestObject('Pengawasan - Canvassing/btnCariGreen'))

TestObject tableRow = new TestObject().addProperty('xpath', com.kms.katalon.core.testobject.ConditionType.EQUALS, '//td[contains(text(),\'017\')]')

WebUI.waitForElementVisible(tableRow, 10)

WebUI.click(findTestObject('Pemeriksaan - Perencanaan/checkboxTableRowPerencanaan'))

WebUI.click(findTestObject('Pemeriksaan - Perencanaan/buttonEditTabelRowPerencanaan'), FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Pemeriksaan - Pelaksanaan - Pelaporan/textboxNomorBA'), (GlobalVariable.kodeBU_bpstatistik_semarang + 'BA') + 
    formattedDate)

WebUI.setText(findTestObject('Pemeriksaan - Pelaksanaan - Pelaporan/textboxNomorSPHP'), (GlobalVariable.kodeBU_bpstatistik_semarang + 
    'SPHP') + formattedDate)

WebUI.click(findTestObject('Pemeriksaan - Perencanaan/buttonSimpanPerencanaan'))

WebUI.click(findTestObject('Pemeriksaan - Perencanaan/btnOKProses'))

// Declare and assign the project path first
String projectPath = RunConfiguration.getProjectDir()

// Now use it to create your file path
String filePath = projectPath + '/Pemadanan Data.xlsx'

println(filePath)

WebUI.click(findTestObject('Pemeriksaan - Pelaksanaan - Pelaporan/buttonUnggahPelaksanaan'))

WebUI.uploadFile(findTestObject('Pemeriksaan - Pelaksanaan - Pelaporan/buttonUpload_PelaksanaanPelaporan'), filePath)

WebUI.delay(2)

WebUI.click(findTestObject('Pemeriksaan - Pelaksanaan - Pelaporan/buttonProsesExcel'))

WebUI.delay(10)

WebUI.click(findTestObject('Pemeriksaan - Perencanaan/buttonSimpanPerencanaan'))

WebUI.click(findTestObject('Analisa Data Mandiri/btnOkPopup'))

WebUI.click(findTestObject('Pemeriksaan - Pelaksanaan - Pelaporan/buttonProsesOuterTable'))

WebUI.click(findTestObject('Pemeriksaan - Pelaksanaan - Pelaporan/buttonKembaliAfterProses'))

WebUI.click(findTestObject('Pemeriksaan - Perencanaan/checkboxTableRowPerencanaan'))

WebUI.click(findTestObject('Pemeriksaan - Pelaksanaan - Pelaporan/buttonEditLHPS'))

WebUI.setText(findTestObject('Pemeriksaan - Pelaksanaan - Pelaporan/textareaPelaksanaanCatatanTemuan'), 'Tidakada')

WebUI.setText(findTestObject('Pemeriksaan - Pelaksanaan - Pelaporan/textareaPelaksanaanTanggapanBA'), 'Tidakada12')

WebUI.setText(findTestObject('Pemeriksaan - Pelaksanaan - Pelaporan/textareaRekomendasiPemeriksa'), 'Tidakada123')

WebUI.click(findTestObject('Pemeriksaan - Perencanaan/buttonSimpanPerencanaan'))

WebUI.click(findTestObject('Pemeriksaan - Perencanaan/buttonAjukan'))

WebUI.click(findTestObject('Pemeriksaan - Perencanaan/buttonKonfirmasiYa'))

WebUI.click(findTestObject('Pemeriksaan - Perencanaan/btnOKProses'))

