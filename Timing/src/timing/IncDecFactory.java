package timing;


/**
 * Using factory pattern gives the app flexibility to change the IncDec implementation 
 * without changing the dependent code. If the app is already using a Dependency
 * Injection framework, such as Guice or Spring, this code can be enhanced using them. 
 * @author Sara
 * 
 */
public class IncDecFactory {
	/**
	 * All clients need to get their IncDec instances by calling createIncDec method. 
	 * @param x 
	 * @return a new IncDec instance
	 */
	public static IncDec createIncDec(int x) {
		return new MyIncDecWithTiming(x);
	}
}
