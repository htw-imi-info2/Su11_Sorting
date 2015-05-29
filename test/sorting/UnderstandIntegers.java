package sorting;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UnderstandIntegers {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		int bit = 1;
		assertEquals(2, 1 << bit);
		bit = Integer.SIZE - 1;
		assertEquals(-1 * (Math.pow(2, Integer.SIZE - 1)), 1 << bit, 0.1);
		assertEquals(-1 * (Math.pow(2, 31)), 1 << bit, 0.1);
		bit = 2;
		assertEquals(4, (4 & (1 << bit)));
	}

}
