package pemadananData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import com.kms.katalon.core.configuration.RunConfiguration
import org.apache.poi.ss.usermodel.*
import org.apache.poi.xssf.usermodel.XSSFWorkbook


class IncrementingDataKodeBU {

	@Keyword
	def String readAndIncrementExcelCell(String sheetName = "inquiry", int rowIdx = 0, int colIdx = 0) {
		String filePath = RunConfiguration.getProjectDir() + "/Pemadanan Data.xlsx"

		// Initialize Excel input
		FileInputStream fis = new FileInputStream(filePath)
		Workbook workbook = new XSSFWorkbook(fis)
		Sheet sheet = workbook.getSheet(sheetName)
		Row row = sheet.getRow(rowIdx)
		Cell cell = row.getCell(colIdx)

		// Read, increment, format
		String valueStr = cell.getStringCellValue().trim()
		println("Old Value: " + valueStr)
		int valueInt = Integer.parseInt(valueStr)
		valueInt += 1
		String newValue = String.format('%08d', valueInt)
		println ("New Value: " + newValue)

		// Write back to Excel
		cell.setCellValue(newValue)
		fis.close()
		FileOutputStream fos = new FileOutputStream(filePath)
		workbook.write(fos)
		fos.close()
		workbook.close()

		return newValue
	}
}