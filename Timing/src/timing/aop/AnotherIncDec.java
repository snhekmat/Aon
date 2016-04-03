package timing.aop;

import timing.IncDec;

/**
 * This is another code in the app that needs timing investigation. To reach that point, its methods are
 * marked with @Timing annotation to be considered by TimingIntercepter.
 * @author Sara
 *
 */
public class AnotherIncDec implements IncDec {

    private int x;

    public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	@Timing
 	@Override	
    public void increment() {
        this.x++;
    }

    @Timing
 	@Override	
    public void decrement() {
        this.x--;
    }   
}
