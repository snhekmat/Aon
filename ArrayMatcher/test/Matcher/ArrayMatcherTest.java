package Matcher;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ArrayMatcherTest {
	private int[] mainArray;
	private int[] subArray;
	private int expectedMatch;
	
	public ArrayMatcherTest(int[] mainArray, int[] subArray, int expectedMatch) {
		this.mainArray = mainArray;
		this.subArray = subArray;
		this.expectedMatch = expectedMatch;
	}

	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] {
			{new int[]{4,9,3,7,8}, new int[]{3, 7}, 2},
			{new int[]{1,2,2,3,2,2,2,2,2,1,7,9}, new int[]{2,2,2,1}, 6},
			{new int[]{1,2,3}, new int[]{1,2,3,4}, -1},
			{new int[]{}, new int[]{}, -1},
			{null, null, -1}
		};
		return Arrays.asList(data);
	}
	
	@Test
	public void testTotalPrice() {
		int resultMatch = ArrayMatcher.FindMatchIndex(mainArray, subArray);
		Assert.assertEquals("Test failed for " + Arrays.toString(mainArray) + " matching " + Arrays.toString(subArray), 
							expectedMatch, resultMatch);
	}	
}
