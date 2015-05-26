package sorting;

import org.junit.Before;
import org.junit.Test;

public class MergeTest {
	MergeSort<Integer> m = new MergeSort<>();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Integer[] a = new Integer[] { 1, 2, 3, 4, 5 };
		m.merge(a, 0, 3, a.length);
		SortingTests.assertSorted("MergeTest", a);
	}

	@Test
	public void test2() {
		Integer[] a = new Integer[] { 1, 5, 2, 4, 5 };
		m.merge(a, 0, 2, a.length);
		SortingTests.assertSorted("MergeTest", a);
	}

	@Test
	public void test3() {
		Integer[] a = new Integer[] { 4, 5, 6, 0, 1, 2 };
		m.merge(a, 0, 3, a.length);
		SortingTests.printArray(a);
		SortingTests.assertSorted("MergeTest", a);

	}

	@Test
	public void test4() {
		Integer[] a = new Integer[] { 4, 5, 6, 7, 8, 9, 10, 0, 1, 2 };

		m.merge(a, 0, 7, a.length);
		SortingTests.printArray(a);
		SortingTests.assertSorted("MergeTest", a);

	}

}
