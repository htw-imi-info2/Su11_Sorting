package sorting;

import java.util.Random;

import static sorting.auxiliary.SortHelpers.swap;

public class QuickSort<E extends Comparable<E>> implements Sorter<E> {
	public static final Random RND = new Random();

	@Override
	public void sort(E[] a) {
		qsort(a, 0, a.length-1);
	}

	/**
	 * @param a - array to be sorted
	 * @param begin  -> first element
	 * @param end -> last element
	 */
	public void qsort(E[] a, int begin, int end) {
		if (!(end > begin))
			return;
		int pivotIndex = partition(a, begin, end);
		qsort(a, begin, pivotIndex - 1);
		qsort(a, pivotIndex + 1, end);
	}

	private int partition(E[] a, int begin, int end) {
		int pivotIndex = begin + RND.nextInt(end - begin + 1);
		E pivot = a[pivotIndex];
		swap(a, pivotIndex, end);
		for (int i = pivotIndex = begin; i < end; i++) {
			if (a[i].compareTo(pivot) < 0)
				swap(a, pivotIndex++, i);
		}
		swap(a, pivotIndex, end);
		return pivotIndex;
	}

}
