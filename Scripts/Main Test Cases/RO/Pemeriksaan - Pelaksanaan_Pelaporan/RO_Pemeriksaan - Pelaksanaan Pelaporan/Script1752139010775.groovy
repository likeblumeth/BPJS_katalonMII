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

try {
    LocalDate today = LocalDate.now()

    String formattedDate = today.format(DateTimeFormatter.ofPattern('dd/MM/yyyy'))

    println(formattedDate)

    WebUI.callTestCase(findTestCase('Common Test Cases/LoginRO'), [('Username') : 'John Doe', ('Password') : 'ThisIsNotAPassword'], 
        FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Pemeriksaan - Perencanaan/sideMenuExpandPemeriksaan'), FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Pemeriksaan - Pelaksanaan - Pelaporan/radiobuttonPelaksanaanPelaporan'), FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Inquiry Data/btnMorePilihBadanUsaha'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(5, FailureHandling.STOP_ON_FAILURE)

    WebUI.selectOptionByValue(findTestObject('Inquiry Data/dropdownPilihOpsiPencarianBadanUsaha'), '2', false, FailureHandling.STOP_ON_FAILURE)

    WebUI.setText(findTestObject('Pemeriksaan - Perencanaan/textboxPencarianBadanUsaha'), GlobalVariable.kodeBU_Global, 
        FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Inquiry Data/btnCariBadanUsaha'), FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Inquiry Data/btnConfirmPilihBadanUsaha'), FailureHandling.STOP_ON_FAILURE)

    WebUI.selectOptionByValue(findTestObject('Pemeriksaan - Perencanaan/dropdownSelectKategori'), '4', false, FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Pengawasan - Canvassing/btnCariGreen'), FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Inquiry Data/btnDownloadtoExcel'), FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Inquiry Data/btnDownloadtoCSV'), FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Inquiry Data/btnDownloadPDF-Print'), FailureHandling.STOP_ON_FAILURE)

    WebUI.switchToWindowIndex(1)

    WebUI.takeFullPageScreenshot()

    WebUI.closeWindowIndex(1)

    WebUI.switchToWindowIndex(0)

    WebUI.takeScreenshot(FailureHandling.STOP_ON_FAILURE)

    TestObject tableRow = new TestObject().addProperty('xpath', com.kms.katalon.core.testobject.ConditionType.EQUALS, '//td[contains(text(),\'017\')]')

    WebUI.waitForElementVisible(tableRow, 10, FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Pemeriksaan - Perencanaan/checkboxTableRowPerencanaan'), FailureHandling.STOP_ON_FAILURE)

    WebUI.scrollToElement(findTestObject('Pemeriksaan - Perencanaan/buttonEditTabelRowPerencanaan'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Pemeriksaan - Perencanaan/buttonEditTabelRowPerencanaan'), FailureHandling.STOP_ON_FAILURE)

    WebUI.setText(findTestObject('Pemeriksaan - Pelaksanaan - Pelaporan/textboxNomorBA'), (GlobalVariable.kodeBU_Global + 
        'BA') + formattedDate, FailureHandling.STOP_ON_FAILURE)

    WebUI.setText(findTestObject('Pemeriksaan - Pelaksanaan - Pelaporan/textboxNomorSPHP'), (GlobalVariable.kodeBU_Global + 
        'SPHP') + formattedDate, FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Pemeriksaan - Perencanaan/buttonSimpanPerencanaan'), FailureHandling.STOP_ON_FAILURE)

    WebUI.takeScreenshot(FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Pemeriksaan - Perencanaan/btnOKProses'), FailureHandling.STOP_ON_FAILURE)

    // Declare and assign the project path first
    String projectPath = RunConfiguration.getProjectDir()

    // Now use it to create your file path
    String filePath = projectPath + '/Pemadanan Data.xlsx'

    println(filePath)

    WebUI.scrollToElement(findTestObject('Pemeriksaan - Pelaksanaan - Pelaporan/buttonUnggahPelaksanaan'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Pemeriksaan - Pelaksanaan - Pelaporan/buttonUnggahPelaksanaan'), FailureHandling.STOP_ON_FAILURE)

    WebUI.uploadFile(findTestObject('Pemeriksaan - Pelaksanaan - Pelaporan/buttonUpload_PelaksanaanPelaporan'), filePath, 
        FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Pemeriksaan - Pelaksanaan - Pelaporan/buttonProsesExcel'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(10, FailureHandling.STOP_ON_FAILURE)

    WebUI.takeScreenshot(FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Pemeriksaan - Perencanaan/buttonSimpanPerencanaan'), FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Analisa Data Mandiri/btnOkPopup'), FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('Pemeriksaan - Pelaksanaan - Pelaporan/buttonUnduhPelaksanaan'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.scrollToElement(findTestObject('Pemeriksaan - Pelaksanaan - Pelaporan/buttonUnduhPelaksanaan'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Pemeriksaan - Pelaksanaan - Pelaporan/buttonUnduhPelaksanaan'), FailureHandling.STOP_ON_FAILURE)

    WebUI.takeScreenshot(FailureHandling.STOP_ON_FAILURE)

    WebUI.scrollToElement(findTestObject('Pemeriksaan - Pelaksanaan - Pelaporan/buttonProsesOuterTable'), 10, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('Pemeriksaan - Pelaksanaan - Pelaporan/buttonProsesOuterTable'), 10, FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Pemeriksaan - Pelaksanaan - Pelaporan/buttonProsesOuterTable'), FailureHandling.STOP_ON_FAILURE)

    WebUI.takeScreenshot(FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Pemeriksaan - Pelaksanaan - Pelaporan/buttonKembaliAfterProses'), FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Pemeriksaan - Perencanaan/checkboxTableRowPerencanaan'), FailureHandling.STOP_ON_FAILURE)

    WebUI.scrollToElement(findTestObject('Pemeriksaan - Pelaksanaan - Pelaporan/buttonHapusPelaksanaan'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Pemeriksaan - Pelaksanaan - Pelaporan/buttonEditLHPS'), FailureHandling.STOP_ON_FAILURE)

    WebUI.takeScreenshot(FailureHandling.STOP_ON_FAILURE)

    WebUI.setText(findTestObject('Pemeriksaan - Pelaksanaan - Pelaporan/textareaPelaksanaanCatatanTemuan'), 'Tidakada', 
        FailureHandling.STOP_ON_FAILURE)

    WebUI.setText(findTestObject('Pemeriksaan - Pelaksanaan - Pelaporan/textareaPelaksanaanTanggapanBA'), 'Tidakada12', 
        FailureHandling.STOP_ON_FAILURE)

    WebUI.setText(findTestObject('Pemeriksaan - Pelaksanaan - Pelaporan/textareaRekomendasiPemeriksa'), 'Tidakada123', FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Pemeriksaan - Perencanaan/buttonSimpanPerencanaan'), FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Pemeriksaan - Perencanaan/btnOKProses'), FailureHandling.STOP_ON_FAILURE)

    WebUI.takeScreenshot(FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Pemeriksaan - Perencanaan/checkboxTableRowPerencanaan'), FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Pemeriksaan - Perencanaan/buttonAjukan'), FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Pemeriksaan - Perencanaan/buttonKonfirmasiYa'), FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Pemeriksaan - Perencanaan/btnOKProses'), FailureHandling.STOP_ON_FAILURE)

    WebUI.takeScreenshot(FailureHandling.STOP_ON_FAILURE)
}
catch (Exception e) {
	WebUI.comment('⚠️ An error occurred: ' + e.getMessage())
	WebUI.comment('Check Excel Pemadanan Data - Mismatch')
	
		WebUI.takeScreenshot()
} 

