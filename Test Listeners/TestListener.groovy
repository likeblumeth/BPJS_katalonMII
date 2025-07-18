import com.katalon.KatalonHelper
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.context.TestSuiteContext
import java.time.LocalDate as LocalDate
import java.time.format.DateTimeFormatter as DateTimeFormatter
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.configuration.RunConfiguration

class TestListener {
	
	File kodeBUFile = new File(RunConfiguration.getProjectDir() + "/kodeBU.txt")
	/**
	 * Executes before every test suite starts.
	 * @param testSuiteContext: related information of the executed test suite.
	 */
	@BeforeTestSuite
	def sampleBeforeTestSuite(TestSuiteContext testSuiteContext) {
		
		String currentValue = kodeBUFile.text.trim()
	    int value = Integer.parseInt(currentValue)
	
	    if (testSuiteContext.getTestSuiteId().contains("Positive Flow Awasrik-1")) {
	        value += 1
	        kodeBUFile.text = String.format('%08d', value)
	    }
		//Set Global Variable from KodeBU File for all Test Suite
	    GlobalVariable.kodeBU_Global = String.format('%08d', value)
	    println "kodeBU for this suite: " + GlobalVariable.kodeBU_Global
	
		KatalonHelper.updateInfo()
	}
}