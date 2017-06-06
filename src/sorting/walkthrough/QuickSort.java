package sorting.walkthrough;

import static sorting.auxiliary.SortHelpers.swap;

import java.util.Random;

import sorting.Sorter;

public class QuickSort<E extends Comparable<E>> implements Sorter<E> {
	public static final Random RND = new Random();
	public static boolean RANDOMPI = true;
	int call_number;

	@Override
	public void sort(E[] a) {
		call_number = 0;
		qsort(a, 0, a.length - 1, 0);
	}

	public void qsort(E[] a, int begin, int end, int depth) {
		int my_call_number = ++call_number;
		int pivotIndex = -1;
		Util.log("quicksort start", my_call_number, depth, a, begin, end);
		if (!(end > begin)) {
			return;
		} else {
			pivotIndex = partition(a, begin, end);
			qsort(a, begin, pivotIndex - 1, depth + 1);
			qsort(a, pivotIndex + 1, end, depth + 1);
		}
		Util.log("quicksort end  ", my_call_number, depth, a, begin, end, pivotIndex);
	}

	private int partition(E[] a, int begin, int end) {
		int pivotIndex = begin;
		if (RANDOMPI)
			pivotIndex += RND.nextInt(end - begin + 1);
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
