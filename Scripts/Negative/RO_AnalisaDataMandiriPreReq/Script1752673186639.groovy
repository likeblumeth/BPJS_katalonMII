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
import java.awt.Robot as Robot
import java.awt.event.KeyEvent as KeyEvent

// Define today's date in the expected format (adjust format if needed)
LocalDate today = LocalDate.now()

String formattedDate = today.format(DateTimeFormatter.ofPattern('dd/MM/yyyy'))

try {
    WebUI.callTestCase(findTestCase('Common Test Cases/LoginRO'), [('Username') : 'John Doe', ('Password') : 'ThisIsNotAPassword'], 
        FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Analisa Data Mandiri/MenuAnalisaDataMandiri'))

    WebUI.setText(findTestObject('Analisa Data Mandiri/textboxKodeBU_PKS'), GlobalVariable.kodeBU_backup)

    println(GlobalVariable.kodeBU_backup)

    WebElement btnCari = WebUiCommonHelper.findWebElement(findTestObject('Pengawasan - Canvassing/btnCariGreen'), 10)

    WebUI.executeJavaScript('arguments[0].click()', [btnCari])

    TestObject tableRow = new TestObject().addProperty('xpath', com.kms.katalon.core.testobject.ConditionType.EQUALS, '//td[contains(text(),\'017\')]')

    WebUI.waitForElementVisible(tableRow, 10)

    WebUI.comment('Take Screenshot Tabel')

    WebUI.takeScreenshot()

    WebUI.click(findTestObject('Pengawasan - Canvassing/btnEditCanvassingRow1'))

    WebUI.waitForElementPresent(findTestObject('Pengawasan - Canvassing/lblEditRecord'), 5)

    WebUI.comment('Input Edit Date Today')

    // Set the date into the input field
    TestObject dateInput = findTestObject('Pengawasan - Canvassing/datepickerForEditRecord' // Update this with your real test object path
        )

    WebUI.setText(dateInput, formattedDate)

    WebUI.sendKeys(findTestObject('Pengawasan - Canvassing/datepickerForEditRecord'), Keys.chord(Keys.ENTER))

    WebUI.click(findTestObject('Pengawasan - Canvassing/iconSimpanEditRecord'))

    WebUI.click(findTestObject('Analisa Data Mandiri/btnOkPopup'))
}
catch (Exception e) {
    WebUI.comment('⚠️ An error occurred: ' + e.getMessage())

    WebUI.takeScreenshot()
} 

