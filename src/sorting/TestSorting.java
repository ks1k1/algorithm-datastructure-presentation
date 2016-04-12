package sorting;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class TestSorting {

	@Test
	public void testRecurBinarySearch() {

		int key = 7, length = 30, min = 0, max = 30, high = 9, low = 0;

		BinarySearchImpl bs = (BinarySearchImpl) initBinarySearchImplObj(
				length, min, max);
		printIdx(bs.getA().length);
		bs.printArray();
		System.out.println(bs.getClass());

		System.out.println(bs.recursiveBinarySearch(key, high, low));
	}
	
	//@Test
	public void testItrBinarySearch() {

		int key = 7, length = 10, min = 0, max = 9, high = 9, low = 0;

		BinarySearchImpl bs = (BinarySearchImpl) initBinarySearchImplObj(
				length, min, max);
		printIdx(bs.getA().length);
		bs.printArray();
		System.out.println(bs.getClass());

		System.out.println(bs.iterativeBinarySearch(key, high, low));
	}

	// @Test
	public void testautoPopulateArrayNoDuplicates() {

		SortingAlgorithm sa = initSortingAlgorithmsObj(10, 0, 9);
		printIdx(sa.getA().length);
		sa.printArray();
	}

	// @Test
	public void testPrintIterable() {

		SortingAlgorithm sa = new SortingAlgorithm();
		List<Integer> list = new LinkedList<Integer>();
		list.add(3);
		list.add(33);
		list.add(34);
		list.add(243);
		list.add(33);
		list.add(23);
		list.add(13);
		sa.printIterable(list);
	}

	// @Test
	public void testSelectionSort() {
		SortingAlgorithm sa = initSortingAlgorithmsObj(10, 0, 9);

		System.out.println("BEFORE:");
		printIdx(sa.getA().length);
		sa.printArray();

		int[] sorted = sa.selectionSort();

		System.out.println("AFTER:");
		printIdx(sa.getA().length);
		printArray(sorted);
	}

	// @Test
	public void testChkForDuplicateVals() {
		SortingAlgorithm sa = initSortingAlgorithmsObj(10, 0, 9);
		int[] A = sa.getA();
		printIdx(A.length);
		sa.printArray();

		int key = -1;

		for (int j = 0; j < A.length; j++) {
			System.out.println("j=" + j + "\tkey=" + A[j] + "\t#="
					+ sa.countKey(A, A[j]));
			if (sa.countKey(A, A[j]) > 1) {
				key = A[j];
				break;
			}
		}

		if (key <= -1) {
			return;
		}

		int[] duplicateIndices = sa.duplicateIndices(sa.getA(), key);
		printArray(duplicateIndices);

	}

	// @Test
	public void test() {
		fail("Not yet implemented");
	}

	// @Test
	public void testSwap() {
		SortingAlgorithm sa = initSortingAlgorithmsObj(10, 0, 9);

		System.out.println("BEFORE:");
		printIdx(sa.getA().length);
		sa.printArray();

		sa.swap(1, 4, sa.getA());

		System.out.println("AFTER:");
		printIdx(sa.getA().length);
		printArray(sa.getA());
	}

	// @Test
	public void testAutoPopulateArray() {
		SortingAlgorithm sa = new SortingAlgorithm(10);
		sa.autoPopulateArray(0, 50);
		sa.printArray();
	}

	// @Test
	public void testMinIdx() {
		SortingAlgorithm sa = initSortingAlgorithmsObj(10, 0, 9);
		printIdx(sa.getA().length);
		sa.printArray();
		System.out.println(sa.minIndex(0, sa.getA().length));
	}

	// @Test
	public void testRdmNumGen() {
		SortingAlgorithm sa = new SortingAlgorithm(10);
		System.out.println(sa.randomNumberGenerator(0, 50));
	}

	public SortingAlgorithm initSortingAlgorithmsObj(int length, int min,
			int max) {

		SortingAlgorithm sa = new SortingAlgorithm(length);

		// duplicates allowed
		// sa.autoPopulateArray(min, max);

		// duplicate element NOT allowed
		sa.autoPopulateArrayNoDuplicates(min, max);

		return sa;
	}

	public SortingAlgorithm initBinarySearchImplObj(int length, int min, int max) {

		BinarySearchImpl ba = new BinarySearchImpl(length, min, max);
		ba.autoPopulateArrayNoDuplicates(min, max);

		return ba;
	}

	public void printIdx(int n) {

		for (int i = 0; i < n; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public void printArray(int[] A) {

		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}

}
