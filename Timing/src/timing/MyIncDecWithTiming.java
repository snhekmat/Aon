package timing;

import java.util.logging.Level;
import java.util.logging.Logger;

import timing.aop.TimingIntercepter;

/**
 * MyIncDecWithTiming is a wrapper on MyIncDec class to log timing of its different methods.
 * In this way, the old code of MyIncDec will not be affected and Timing concept is decoupled
 * from the main functionality of MyIncDec. Whenever, the app needs to investigate the timings,
 * it needs to replace MyIncDec with MyIncDecWithTiming in IncDecFactory class. 
 * @author Sara
 * 
 */
public class MyIncDecWithTiming extends MyIncDec {

	/**
	 * Is used to log timings
	 */
	private static final Logger logger = Logger.getLogger(TimingIntercepter.class.getName());
	
	public MyIncDecWithTiming(int x) {
		super(x);
	}
		
	@Override
	public void increment() {
		long start = System.nanoTime();
		
		super.increment();
		
		float elapsedTime = (System.nanoTime() - start) / 1000000.0F;
		
		logger.log(Level.INFO, "Duration of increment method is {0} milliseconds", elapsedTime);
	}

	@Override
	public void decrement() {
		long start = System.nanoTime();
		
		super.decrement();
		
		float elapsedTime = (System.nanoTime() - start) / 1000000.0F;
		
		logger.log(Level.INFO, "Duration of decrement method is {0} milliseconds", elapsedTime);
	}
}
