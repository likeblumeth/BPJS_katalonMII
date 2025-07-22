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

WebUI.comment('Done Approval Kabag dan Kacab Dahulu')

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

println(GlobalVariable.kodeBU_Global)

WebUI.setText(findTestObject('Pemeriksaan - Perencanaan/textboxPencarianBadanUsaha'), GlobalVariable.kodeBU_Global, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Inquiry Data/btnCariBadanUsaha'))

WebUI.click(findTestObject('Inquiry Data/btnConfirmPilihBadanUsaha'))

WebUI.selectOptionByValue(findTestObject('Pemeriksaan - Perencanaan/dropdownSelectKategori'), '4', false)

WebUI.click(findTestObject('Pengawasan - Canvassing/btnCariGreen'))

WebUI.takeScreenshot()

TestObject tableRow = new TestObject().addProperty('xpath', com.kms.katalon.core.testobject.ConditionType.EQUALS, '//td[contains(text(),\'017\')]')

WebUI.waitForElementVisible(tableRow, 10)

WebUI.click(findTestObject('Pemeriksaan - Perencanaan/checkboxTableRowPerencanaan'))

for (def index : (0..5)) {
    WebUI.sendKeys(findTestObject('Pemeriksaan - Perencanaan/buttonAksiTabel'), Keys.chord(Keys.TAB))
}

WebUI.waitForElementClickable(findTestObject('Pemeriksaan - Perencanaan/buttonAksiTabel'), 0)

WebUI.click(findTestObject('Pemeriksaan - Perencanaan/buttonAksiTabel'))

WebUI.takeScreenshot()

WebUI.click(findTestObject('Pemeriksaan - Perencanaan/buttonAksiHistoryPemeriksaan'))

WebUI.click(findTestObject('Pemeriksaan - Perencanaan/buttonTutupPopup'))

WebUI.click(findTestObject('Pemeriksaan - Perencanaan/buttonAksiTabel'))

WebUI.takeScreenshot()

WebUI.click(findTestObject('Pemeriksaan - Perencanaan/buttonAksiSPFPK_PeringatanProses'))

WebUI.click(findTestObject('Pemeriksaan - Perencanaan/btnOKProses'))

WebUI.selectOptionByValue(findTestObject('Pemeriksaan - Perencanaan/dropdownSPPKorSPFK'), '2', false)

WebUI.click(findTestObject('Pemeriksaan - Perencanaan/checkboxTableRowPerencanaan'))

WebUI.scrollToElement(findTestObject('Pemeriksaan - Perencanaan/buttonAjukan'), 5)

WebUI.click(findTestObject('Pemeriksaan - Perencanaan/buttonAjukan'))

WebUI.click(findTestObject('Pemeriksaan - Perencanaan/buttonKonfirmasiYa'))

WebUI.click(findTestObject('Pemeriksaan - Perencanaan/btnOKProses'))

WebUI.takeScreenshot()

WebUI.comment('Next Perlu Approval_SPFPK_Peringatan Kabag dan Kacab')

