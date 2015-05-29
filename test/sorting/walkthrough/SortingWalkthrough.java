package sorting.walkthrough;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import sorting.HeapSort;
import sorting.InsertionSort;
import sorting.walkthrough.MergeSort;
import sorting.walkthrough.QuickSort;
import sorting.RadixSort;
import sorting.SelectionSort;
import sorting.Sorter;

@RunWith(Parameterized.class)
public class SortingWalkthrough {
	static final boolean PRINT_LISTS = false;

	static abstract class Factory {
		abstract Sorter<Integer> createSorter();
	}

	public Factory factory;
	public String algorithm;
	public Sorter<Integer> sorter;

	public SortingWalkthrough(String algorithm, Factory factory) {
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
		Util.VERBOSE = true;
		QuickSort.RANDOMPI = false;
	}

	@Test
	public void testSort() {
		int[] a = { 15, 23, 4, 8, 42, 16 };
		Integer[] testArray = new Integer[a.length];
		for (int i = 0; i < testArray.length; i++) {
			testArray[i] = a[i];
		}
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
}
