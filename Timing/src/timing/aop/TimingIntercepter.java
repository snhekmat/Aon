package timing.aop;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * The app needs to investigate timing of various methods in
 * many places, so, it is a cross-cutting feature and a common solution is
 * using AOP. Here, I have used Guice as a light AOP framework to
 * implement Timing Intercepter. The method invoke() will be called by
 * Guice container for each intercepted method and logs its timing.
 * @author Sara
 * 
 */
public class TimingIntercepter implements MethodInterceptor {

	private static final Logger logger = Logger.getLogger(TimingIntercepter.class.getName());

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		long start = System.nanoTime();

		try {
			return invocation.proceed();
		} finally {
			logger.log(Level.INFO, "Duration of {0}{1} method is {2} milliseconds",
					new Object[] { invocation.getMethod().getName(), 
							       Arrays.toString(invocation.getArguments()),
							       (System.nanoTime() - start) / 1000000.0 });
		}
	}

}
