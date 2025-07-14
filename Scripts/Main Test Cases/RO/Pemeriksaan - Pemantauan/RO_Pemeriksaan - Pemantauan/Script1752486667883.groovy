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
import com.kms.katalon.core.testobject.ConditionType

// Define today's date in the expected format (adjust format if needed)
LocalDate today = LocalDate.now()

String formattedDate = today.format(DateTimeFormatter.ofPattern('dd/MM/yyyy'))

String todayDate = today.format(DateTimeFormatter.ofPattern('dd'))

println(todayDate)

WebUI.callTestCase(findTestCase('Common Test Cases/LoginRO'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Pemeriksaan - Pemantauan/Page_Awasrik Selamat Datang/p_Pemeriksaan'))

WebUI.click(findTestObject('Pemeriksaan - Pemantauan/Page_Awasrik Selamat Datang/p_Pemantauan'))

WebUI.click(findTestObject('Pemeriksaan - Pemantauan/Page_Awasrik Pemantauan/button_Badan Usaha_btnSearchBU'))

WebUI.selectOptionByValue(findTestObject('Pemeriksaan - Pemantauan/Page_Awasrik Pemantauan/select_Nama BUKode BU'), '2', 
    true)

WebUI.setText(findTestObject('Pemeriksaan - Pemantauan/Page_Awasrik Pemantauan/input_Opsi Pencarian_paramCariBU'), GlobalVariable.kodeBU_Global)

WebUI.click(findTestObject('Pemeriksaan - Pemantauan/Page_Awasrik Pemantauan/button_Cari'))

WebUI.click(findTestObject('Pemeriksaan - Pemantauan/Page_Awasrik Pemantauan/button_Pilih'))

WebUI.click(findTestObject('Pemeriksaan - Pemantauan/Page_Awasrik Pemantauan/input_Tanggal Pemeriksaan_periode'), FailureHandling.STOP_ON_FAILURE)

String DynamicDatePicker = ('//div[contains(@class, \'datepicker-days\')]//td[@class=\'day\' and text()=\'' + todayDate) + 
'\']'

println(DynamicDatePicker)

// 3. Create TestObject with dynamic XPath
TestObject dynamicDate = new TestObject('dynamicDate')
dynamicDate.addProperty("xpath", ConditionType.EQUALS, DynamicDatePicker)

// 4. Wait for element (optional, but recommended)
WebUI.waitForElementClickable(dynamicDate, 10)

// 5. Click the date
WebUI.click(dynamicDate)

WebUI.click(findTestObject('Pemeriksaan - Pemantauan/Page_Awasrik Pemantauan/button_Cari_1'))

WebUI.click(findTestObject('Pemeriksaan - Pemantauan/Page_Awasrik Pemantauan/span_Excel'))

WebUI.click(findTestObject('Pemeriksaan - Pemantauan/Page_Awasrik Pemantauan/span_CSV'))

WebUI.click(findTestObject('Pemeriksaan - Pemantauan/Page_Awasrik Pemantauan/span_Print'))

Robot robot = new Robot()

// Delay for a few seconds to allow time to switch to the desired window
Thread.sleep(2000)

// Press Escape key
robot.keyPress(KeyEvent.VK_ESCAPE)

robot.keyRelease(KeyEvent.VK_ESCAPE)

WebUI.click(findTestObject('Pemeriksaan - Pemantauan/Page_Awasrik Pemantauan/button_Cek Ulang'))

WebUI.click(findTestObject('Pemeriksaan - Pemantauan/Page_Awasrik Pemantauan/button_XLS'))

WebUI.click(findTestObject('Pemeriksaan - Pemantauan/Page_Awasrik Pemantauan/button_Kembali'))

WebUI.click(findTestObject('Pemeriksaan - Pemantauan/Page_Awasrik Pemantauan/button_Unduh'))

WebUI.click(findTestObject('Pemeriksaan - Pemantauan/Page_Awasrik Pemantauan/button_Update'))

WebUI.selectOptionByValue(findTestObject('Pemeriksaan - Pemantauan/Page_Awasrik Pemantauan/select_PatuhPatuh Dengan CatatanTidak Patuh'), 
    '3', true)

WebUI.click(findTestObject('Pemeriksaan - Pemantauan/Page_Awasrik Pemantauan/button_Simpan'))

WebUI.click(findTestObject('Pemeriksaan - Pemantauan/Page_Awasrik Pemantauan/button_OK'))

