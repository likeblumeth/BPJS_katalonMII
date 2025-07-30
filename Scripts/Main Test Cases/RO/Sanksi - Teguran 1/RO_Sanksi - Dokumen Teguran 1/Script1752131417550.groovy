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
import com.kms.katalon.core.testobject.ConditionType as ConditionType

// Define today's date in the expected format (adjust format if needed)
LocalDate today = LocalDate.now()

String formattedDate = today.format(DateTimeFormatter.ofPattern('dd/MM/yyyy'))

WebUI.callTestCase(findTestCase('Common Test Cases/LoginRO'), [('Username') : 'John Doe', ('Password') : 'ThisIsNotAPassword'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Sanksi/sidemenuExpandSanksi'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Sanksi/radiobuttonSanksiTeguran1'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Inquiry Data/Periode/parentdatePickerPeriode'), FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'dynamicDateForTCsanksi.dynamicDate.selectCurrentMonthInDatePicker'()

WebUI.selectOptionByValue(findTestObject('Pemeriksaan - Perencanaan/dropdownSelectKategori'), '4', false, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Pengawasan - Canvassing/btnCariGreen'), FailureHandling.STOP_ON_FAILURE)

WebUI.takeScreenshot(FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Inquiry Data/btnDownloadtoExcel'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Inquiry Data/btnDownloadtoCSV'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Inquiry Data/btnDownloadPDF-Print'), FailureHandling.STOP_ON_FAILURE)

WebUI.switchToWindowIndex(1)

WebUI.takeFullPageScreenshot()

WebUI.closeWindowIndex(1)

WebUI.switchToWindowIndex(0)

WebUI.takeScreenshot()

//Get Dynamic Object untuk Pilih Tabel By Global Variable
String dynamicXpath = ('//table[@id=\'tblCari\']//tbody//td[contains(@class,\'dt-type-numeric\') and text()=\'' + GlobalVariable.kodeBU_Global) + '\']'
println(dynamicXpath)

TestObject dynamicCell = new TestObject('dynamicCell')
dynamicCell.addProperty('xpath', ConditionType.EQUALS, dynamicXpath)

TestObject nextButton = findTestObject('Sanksi/buttonNextPageTabelSanksi')

boolean found = false

while (true) {
    if (WebUI.verifyElementPresent(dynamicCell, 5, FailureHandling.OPTIONAL)) {
        // Found the element
        WebUI.waitForElementClickable(dynamicCell, 10)
        WebUI.scrollToElement(dynamicCell, 0)
        WebUI.click(dynamicCell)
        found = true
        break
    } else {
        // Check if next button is disabled or not present
        if (!WebUI.verifyElementClickable(nextButton, FailureHandling.OPTIONAL)) {
            println("Element not found and no more pages.")
            break
        }

        // Scroll and click next page
        WebUI.scrollToElement(nextButton, 0)
        WebUI.click(nextButton)
        WebUI.delay(1) // small wait for table to refresh
    }
}

if (!found) {
   println("Element with value '${GlobalVariable.kodeBU_Global}' not found in any page.")
}

WebUI.scrollToElement(findTestObject('Pemeriksaan - Perencanaan/buttonAjukan'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.takeScreenshot(FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Pemeriksaan - Perencanaan/buttonAjukan'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Pemeriksaan - Perencanaan/btnOKProses'), FailureHandling.STOP_ON_FAILURE)

WebUI.comment('Buat Approval kabag dan Kacab')

