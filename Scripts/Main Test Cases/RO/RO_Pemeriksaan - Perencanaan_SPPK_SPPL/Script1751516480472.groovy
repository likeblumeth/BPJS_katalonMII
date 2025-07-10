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

WebUI.callTestCase(findTestCase('Main Test Cases/RO/RO_AnalisaDataMandiri'), [('kodeBU') : GlobalVariable.kodeBU_bpstatistik_semarang], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Analisa Data Mandiri/textboxKodeBU_PKS'), 0)

if (WebUI.verifyElementPresent(findTestObject('Analisa Data Mandiri/popupLabelPerhatian'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Analisa Data Mandiri/btnOkPopup'))

    WebUI.click(findTestObject('Pemeriksaan - Perencanaan/sideMenuExpandPemeriksaan'))

    WebUI.click(findTestObject('Pemeriksaan - Perencanaan/radioButtonPerencanaan'))
} else {
    WebUI.click(findTestObject('Pemeriksaan - Perencanaan/sideMenuExpandPemeriksaan'))

    WebUI.click(findTestObject('Pemeriksaan - Perencanaan/radioButtonPerencanaan'))
}

WebUI.click(findTestObject('Inquiry Data/btnMorePilihBadanUsaha'))

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

WebUI.setText(findTestObject('Pemeriksaan - Perencanaan/textboxSPT'), (GlobalVariable.kodeBU_bpstatistik_semarang + 'SPT') + 
    formattedDate)

WebUI.setText(findTestObject('Pemeriksaan - Perencanaan/textboxSusunanTim'), '03864')

WebUI.click(findTestObject('Pemeriksaan - Perencanaan/btnTambahTim'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Pemeriksaan - Perencanaan/btnTambahTim'), FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Pemeriksaan - Perencanaan/textboxSusunanTim'), '06529')

WebUI.click(findTestObject('Pemeriksaan - Perencanaan/btnTambahTim'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Pemeriksaan - Perencanaan/btnTambahTim'), FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Pemeriksaan - Perencanaan/textboxEmail'), 'azis.boy@gmail.com')

WebUI.selectOptionByValue(findTestObject('Pemeriksaan - Perencanaan/dropdownMekanismePemeriksaan'), '2', false)

WebUI.selectOptionByValue(findTestObject('Pemeriksaan - Perencanaan/dropdownMetodePemeriksaan'), '2', false)

WebUI.selectOptionByValue(findTestObject('Pemeriksaan - Perencanaan/dropdownJenisTidakPatuh'), '3', false)

WebUI.click(findTestObject('Pemeriksaan - Perencanaan/buttonSimpanPerencanaan'))

WebUI.click(findTestObject('Pemeriksaan - Perencanaan/btnOKProses'))

WebUI.click(findTestObject('Pemeriksaan - Perencanaan/btnUnduhSPT'))

WebUI.click(findTestObject('Pemeriksaan - Perencanaan/btnUnduhSPPL'))

WebUI.delay(10)

WebUI.click(findTestObject('Pemeriksaan - Perencanaan/checkboxTableRowPerencanaan'))

WebUI.selectOptionByValue(findTestObject('Pemeriksaan - Perencanaan/dropdownSPPKorSPPL'), '1', false)

WebUI.scrollToElement(findTestObject('Pemeriksaan - Perencanaan/buttonAjukan'), 5)

WebUI.click(findTestObject('Pemeriksaan - Perencanaan/buttonAjukan'))

WebUI.click(findTestObject('Pemeriksaan - Perencanaan/buttonKonfirmasiYa'))

WebUI.click(findTestObject('Pemeriksaan - Perencanaan/btnOKProses'))

