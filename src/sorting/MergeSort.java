package sorting;

import java.util.Arrays;

public class MergeSort<E extends Comparable<E>> implements Sorter<E> {

	@Override
	public void sort(E[] a) {
		mergesort(a, 0, a.length);
	}

	/**
	 * mergesort
	 * 
	 * @param a   - the array that will be sorted
	 * @param begin
	 *            - first index to be sorted
	 * @param end
	 *            - index behind the last element
	 */
	void mergesort(E[] a, int begin, int end) {
		if (end - begin < 2)
			return;
		else {
			int middle = begin + ((end - begin) / 2);
			mergesort(a, begin, middle);
			mergesort(a, middle, end);
			merge(a, begin, middle, end);
		}
	}

	void merge(E[] a, int begin, int middle, int end) {
		E[] scratch = Arrays.copyOfRange(a, begin, end);
		int left_cursor = 0, start_of_right = middle - begin, right_cursor = start_of_right;
		int index = begin;
		while ((left_cursor < start_of_right)
				&& (right_cursor < scratch.length)) {
			if (scratch[left_cursor].compareTo(scratch[right_cursor]) < 0) {
				a[index++] = scratch[left_cursor++];
			} else
				a[index++] = scratch[right_cursor++];
		}
		if (left_cursor == start_of_right) {
			while (right_cursor < scratch.length)
				a[index++] = scratch[right_cursor++];
		} else
			while (left_cursor < start_of_right)
				a[index++] = scratch[left_cursor++];
	}

}
