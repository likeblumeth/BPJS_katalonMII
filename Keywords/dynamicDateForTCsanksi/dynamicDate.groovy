package dynamicDateForTCsanksi

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

import java.time.LocalDate
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import com.kms.katalon.core.webui.driver.DriverFactory

public class dynamicDate {
	
	@Keyword
	def selectCurrentMonthInDatePicker() {
		// Get current month number (1-12)
		int currentMonth = LocalDate.now().getMonthValue()

		// Month names as displayed in the datepicker
		def monthNames = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
						  'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']

		// Get the matching month name
		String targetMonth = monthNames[currentMonth - 1]
		println ("Target Month: " + targetMonth)

		// Build XPath
		String xpath = "//div[contains(@class, 'datepicker-months')]//span[contains(@class, 'month') and text()='${targetMonth}']"
		println xpath

        // Create dynamic TestObject
        TestObject dynamicMonth = new TestObject("selectedMonth")
        dynamicMonth.addProperty("xpath", ConditionType.EQUALS, xpath)

        // Click the month using Katalon
        WebUI.click(dynamicMonth)

		}
}
