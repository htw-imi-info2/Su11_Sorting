package sorting;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SortingTests {
	static final boolean PRINT_LISTS = false;

	static abstract class Factory {
		abstract Sorter<Integer> createSorter();
	}

	public Factory factory;
	public String algorithm;
	public Sorter<Integer> sorter;

	public SortingTests(String algorithm, Factory factory) {
		this.algorithm = algorithm;
		this.factory = factory;
	}

	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] {

		{ "Radix Sort", new Factory() {
			Sorter<Integer> createSorter() {
				return new RadixSort<Integer>();
			}
		} }, { "Insertion Sort", new Factory() {
			Sorter<Integer> createSorter() {
				return new InsertionSort<Integer>();
			}
		} }, { "Selection Sort", new Factory() {
			Sorter<Integer> createSorter() {
				return new SelectionSort<Integer>();
			}
		} }, { "Merge Sort", new Factory() {
			Sorter<Integer> createSorter() {
				return new MergeSort<Integer>();
			}
		} }, { "Quick Sort", new Factory() {
			Sorter<Integer> createSorter() {
				return new QuickSort<Integer>();
			}
		} }, { "HeapSort", new Factory() {
			Sorter<Integer> createSorter() {
				return new HeapSort<Integer>();
			}
		} }

		};
		return Arrays.asList(data);
	}

	@Before
	public void setUp() throws Exception {
		sorter = factory.createSorter();
	}

	@Test
	public void testSort5() {
		Integer[] testArray = generateTestArray(5, 100);
		testSortingOn(testArray);
	}

	@Test
	public void testSort100() {
		Integer[] testArray = generateTestArray(100, 1000);
		testSortingOn(testArray);
	}

	@Test
	public void testSortWithNegative() {
		Integer[] testArray = generateTestArray(100, 1000, true);
		testSortingOn(testArray);
	}

	private void testSortingOn(Integer[] testArray) {
		sorter.sort(testArray);
		if (PRINT_LISTS) {
			System.out.println(algorithm);
			printArray(testArray);
		}
		assertSorted(algorithm, testArray);
	}

	static void printArray(Integer[] a) {

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ", ");
		}
		System.out.println();
	}

	static void assertSorted(String algorithm, Integer[] testArray) {
		for (int i = 0; i < testArray.length - 1; i++) {
			assertTrue(algorithm + " ta[" + i + "]=" + testArray[i] + " <= ta["
					+ (i + 1) + "]=" + testArray[i + 1] + " ",
					testArray[i] <= testArray[i + 1]);
		}
	}

	private Integer[] generateTestArray(int n, int max) {
		return generateTestArray(n, max, false);
	}

	private Integer[] generateTestArray(int n, int max, boolean includeNegative) {
		Integer[] theArray = new Integer[n];
		for (int i = 0; i < theArray.length; i++) {
			if (includeNegative)
				theArray[i] = (int) (Math.random() * max * 2) - max;
			else
				theArray[i] = (int) (Math.random() * max);
		}
		return theArray;
	}

}
