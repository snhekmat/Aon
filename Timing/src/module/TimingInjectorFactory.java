package module;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Helper class to Initialize Guice modules.
 * @author Sara
 *
 */
public class TimingInjectorFactory {
	public static Injector injector;
	
	static {
		injector = Guice.createInjector(new TimingInjector());
	}
	
	public static Injector getInjector() {
		return injector;
	}
}
