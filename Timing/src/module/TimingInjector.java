package module;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.matcher.Matchers;
import com.google.inject.name.Names;

import timing.IncDec;
import timing.aop.AnotherIncDec;
import timing.aop.Timing;
import timing.aop.TimingIntercepter;

/**
 * This class initializes Google Guice dependency module and helps in injecting defined dependencies
 * and calling the intercepters.
 * @author Sara
 *
 */
@Singleton
public class TimingInjector extends AbstractModule{

	@Override
	protected void configure() {
		bind(IncDec.class).annotatedWith(Names.named("Another")).to(AnotherIncDec.class);
		
		// Binding of TimingIntercepter with @Timing marker
		bindInterceptor(Matchers.any(), Matchers.annotatedWith(Timing.class), new TimingIntercepter());
	}

}
