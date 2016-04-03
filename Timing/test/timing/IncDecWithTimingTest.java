package timing;

import org.junit.Test;

import timing.IncDec;
import timing.IncDecFactory;

public class IncDecWithTimingTest {	
	
	@Test
	public void testIncDec() {
		IncDec incDec = IncDecFactory.createIncDec(5);
		incDec.increment();
		incDec.decrement();
	}
}
