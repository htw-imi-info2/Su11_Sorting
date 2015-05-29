package sorting.walkthrough;

import java.util.Arrays;

import sorting.Sorter;

public class MergeSort<E extends Comparable<E>> implements Sorter<E> {
	int n = 0;
	@Override
	public void sort(E[] a) {
		n = 0;
		mergesort(a, 0, a.length,0);
	}

	/**
	 * mergesort
	 * 
	 * @param a
	 *            - the array that will be sorted
	 * @param begin
	 *            - first index to be sorted
	 * @param end
	 *            - index behind the last element
	 */
	void mergesort(E[] a, int begin, int end, int depth) {
		int myn = ++n;
		Util.log("mergesort start",myn,depth,a,begin,end-1);
		
		if (end - begin < 2){
			//return;
		}
		else {
			int middle = begin + ((end - begin) / 2);
			mergesort(a, begin, middle,depth+1);
			mergesort(a, middle, end,depth+1);
			merge(a, begin, middle, end);
		}
		Util.log("mergesort end  ",myn,depth,a,begin,end-1);	
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
