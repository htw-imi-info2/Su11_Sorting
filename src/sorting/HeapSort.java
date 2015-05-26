package sorting;

import sorting.auxiliary.Heap;

public class HeapSort<E extends Comparable<E>> implements Sorter<E> {

	@Override
	public void sort(E[] a) {
		// Build-Max-Heap(A)
		Heap<E> h = new Heap<E>(a);
		// for i = A.length downto 2
		for (int i = h.size() - 1; i >= 1; i--) {
			// exchange A[1] with A[i]
			h.exchange(0, i);
			// A.heap-size = A.heap-size-1
			h.removeLastElementFromHeap();
			// Max-Heapify(A,1)
			h.maxHeapify(0);
		}
	}

}
