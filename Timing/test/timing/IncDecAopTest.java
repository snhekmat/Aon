package timing;

import org.junit.Test;

import com.google.inject.Key;
import com.google.inject.name.Names;

import module.TimingInjectorFactory;
import timing.IncDec;

public class IncDecAopTest {

	@Test
	public void testIncDecAop() {
		IncDec incDec = TimingInjectorFactory.getInjector().getInstance(Key.get(IncDec.class, Names.named("Another")));
		incDec.decrement();
		incDec.increment();
	}
}
