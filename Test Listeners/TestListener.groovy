import com.katalon.KatalonHelper
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.context.TestSuiteContext
import java.time.LocalDate as LocalDate
import java.time.format.DateTimeFormatter as DateTimeFormatter

class TestListener {
	/**
	 * Executes before every test suite starts.
	 * @param testSuiteContext: related information of the executed test suite.
	 */
	@BeforeTestSuite
	def sampleBeforeTestSuite(TestSuiteContext testSuiteContext) {
		
		LocalDate today = LocalDate.now()
		
		String formattedDate = today.format(DateTimeFormatter.ofPattern('dd/MM/yyyy'))
		
		KatalonHelper.updateInfo()
	}
}