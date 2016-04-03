package timing;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;

public class TestRunner {
	
	@RunWith(Suite.class)
	@Suite.SuiteClasses({ 
		IncDecWithTimingTest.class,
		IncDecAopTest.class
	})
	public class JunitTestSuite {
	}

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(JunitTestSuite.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println(result.wasSuccessful());
	}
}
