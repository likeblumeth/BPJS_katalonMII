import com.katalon.KatalonHelper
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.context.TestSuiteContext
import java.time.LocalDate as LocalDate
import java.time.format.DateTimeFormatter as DateTimeFormatter
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.configuration.RunConfiguration

class TestListener {
	
	File kodeBUFile = new File(RunConfiguration.getProjectDir() + "/kodeBU.txt")
	File kodeBUNegativeFile = new File(RunConfiguration.getProjectDir() + "/kodeBUNegative.txt")
	/**
	 * Executes before every test suite starts.
	 * @param testSuiteContext: related information of the executed test suite.
	 */
	@BeforeTestSuite
	def sampleBeforeTestSuite(TestSuiteContext testSuiteContext) {
		
		// Always load the latest Kode BU value into GlobalVariable
		String currentValue = kodeBUFile.text.trim()
		int value = Integer.parseInt(currentValue)
		println "kodeBU Before: " + (currentValue)
		
		//Incremental Kode BU for Positive
	    if (testSuiteContext.getTestSuiteId().contains("Positive Flow Awasrik-1")) {
			//Increment Kode BU Value in File - Text to Int to Text Again
	        value += 1
	        kodeBUFile.text = String.format('%08d', value)
			
			//Convert Updated Int Value to String and Assign to Global Variable
			GlobalVariable.kodeBU_Global = String.format('%08d', value)
			println "kodeBU for this suite: " + GlobalVariable.kodeBU_Global
	    }

		else if (testSuiteContext.getTestSuiteId().contains("Negative Flow")) {
			//Increment Kode BU Value in File - Text to Int to Text Again
			String currentValueNeg = kodeBUNegativeFile.text.trim()
			int valueNeg = Integer.parseInt(currentValue)
			valueNeg += 1
			kodeBUNegativeFile.text = String.format('%08d', valueNeg)
			
			//Convert Updated Int Value to String and Assign to Global Variable
			GlobalVariable.kodeBU_Negative = String.format('%08d', valueNeg)
			println "kodeBU for this suite: " + GlobalVariable.kodeBU_Negative
		}
		
		else if (testSuiteContext.getTestSuiteId().contains("Negative Flow for Approval Kacab")) {
			//Increment Kode BU Value in File - Text to Int to Text Again
			String currentValueNeg = kodeBUNegativeFile.text.trim()
			int valueNeg = Integer.parseInt(currentValue)
			valueNeg += 1
			kodeBUNegativeFile.text = String.format('%08d', valueNeg)
			
			//Convert Updated Int Value to String and Assign to Global Variable
			GlobalVariable.kodeBU_Negative = String.format('%08d', valueNeg)
			println "kodeBU for this suite: " + GlobalVariable.kodeBU_Negative
		}
		
		// Set global variable for all dependent test suites
		GlobalVariable.kodeBU_Global = String.format('%08d', value)
		println "[Listener] GlobalVariable.kodeBU_Global set to: " + GlobalVariable.kodeBU_Global
		KatalonHelper.updateInfo()
	}
}