package sorting;

public class RadixSort<E extends Comparable<E>> implements Sorter<E> {
	/**
	 * Although this is too defined in a generic way, Radix Sort needs to "know"
	 * something about the things it is sorting beyond the possibility to
	 * compare two items. Thus, this only works for Integer Arrays.
	 */

	@Override
	@SuppressWarnings("unchecked")
	public void sort(E[] a) {
		/*
		 * as radix
		 */
		int[] intArray = new int[a.length];

		for (int i = 0; i < a.length; i++) intArray[i] = (Integer) a[i];

		intArray = sort(intArray);

		for (int i = 0; i < intArray.length; i++) a[i] = (E) Integer.valueOf(intArray[i]);

	}
	
	/**
	 * http://rosettacode.org/wiki/Sorting_algorithms/Radix_sort#Java
	 * 
	 * @param old
	 * @return
	 */
	public static int[] sort(int[] old) {
		// Loop for every bit in the integers
		for (int shift = Integer.SIZE - 1; shift > -1; shift--) {
			// The array to put the partially sorted array into
			int[] tmp = new int[old.length];
			// The number of 0s
			int j = 0;

			// Move the 0s to the new array, and the 1s to the old one
			for (int i = 0; i < old.length; i++) {
				// If there is a 1 in the bit we are testing, the number will be
				// negative
				boolean move = old[i] << shift >= 0; // move is false if bit was
														// set

				// If this is the last bit, negative numbers are actually lower
				if (shift == 0 ? !move : move) {
					tmp[j] = old[i];
					j++;
				} else {
					// It's a 1, so stick it in the old array for now
					old[i - j] = old[i];
				}
			}

			// Copy over the 1s from the old array
			for (int i = j; i < tmp.length; i++) {
				tmp[i] = old[i - j];
			}

			// And now the tmp array gets switched for another round of sorting
			old = tmp;
		}

		return old;
	}
}
