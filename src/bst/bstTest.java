package bst;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class bstTest {
	Random rd = new Random();

	@Test
	public void testpop() {
		BST_INT<Integer> bst = populateBST(10);
		bst.inOrderTreeWalk(bst.getRoot());
//		Node d = new Node(14);
//		bst.inOrderTreeWalk(bst.getRoot());
//		System.out.println();
//		bst.insert(bst, d);
//		bst.inOrderTreeWalk(bst.getRoot());
//		bst.delete(bst, d);
//		System.out.println();
//		bst.inOrderTreeWalk(bst.getRoot());
		// System.out.println("\nmax: " + bst.max(bst.getRoot()).getValue());
	}
	
//	@Test
	public void testDelete() {
		BST_INT<Integer> bst = initBST();

		Node d = new Node(14);
		bst.inOrderTreeWalk(bst.getRoot());
		System.out.println();
		bst.insert(bst, d);
		bst.inOrderTreeWalk(bst.getRoot());
		bst.delete(bst, d);
		System.out.println();
		bst.inOrderTreeWalk(bst.getRoot());
		// System.out.println("\nmax: " + bst.max(bst.getRoot()).getValue());
	}

	// @Test
	public void testMax() {
		BST_INT<Integer> bst = populateBST(10);
		bst.inOrderTreeWalk(bst.getRoot());
		System.out.println("\nmax: " + bst.max(bst.getRoot()).getValue());
	}

	// @Test
	public void testMin() {
		BST_INT<Integer> bst = populateBST(10);
		bst.inOrderTreeWalk(bst.getRoot());
		System.out.println("\nmin: " + bst.minimum(bst.getRoot()).getValue());
	}

	// @Test
	public void testSearchRec() {
		BST_INT<Integer> bst = populateBST(10);
		bst.inOrderTreeWalk(bst.getRoot());
		System.out.println(bst.treeSearchRec(bst.getRoot(), 15));
	}

	// @Test
	public void testSearchItr() {
		BST_INT<Integer> bst = populateBST(10);
		bst.inOrderTreeWalk(bst.getRoot());
		System.out.println(bst.treeSearchItr(bst.getRoot(), 15));
	}

	// @Test
	public void testInitBST() {

		BST_INT<Integer> bst = initBST();
		// System.out.println(bst.getRoot());
		bst.inOrderTreeWalk(bst.getRoot());
	}

	// @Test
	// TODO finalize testAutoPopBST
	public void testAutoPopulateBST() {

		BST_INT<Integer> bst = populateBST(10);
		// System.out.println("root = " + bst.getRoot());
		bst.inOrderTreeWalk(bst.getRoot());
	}

	// @Test
	public void testInOrderWalk() {
		BST_INT<Integer> bst = populateBST(10);
		System.out.println("\n\n");
		// System.out.println(bst.getRoot());
		System.out.println("\n\n");
		// bst.inOrderTreeWalk(bst.getRoot());
	}

	// @Test
	public void testInsert() {
		BST_INT<Integer> bst = new BST_INT<Integer>();
		// BST_INT<Integer> bst = new BST_INT<Integer>(534);
		System.out.println("root = " + bst.getRoot());

		bst.insert(bst, new Node(14));
		bst.insert(bst, new Node(24));
		bst.insert(bst, new Node(4));
		bst.insert(bst, new Node(25));
		bst.insert(bst, new Node(25));
		bst.insert(bst, new Node(5));
		bst.insert(bst, new Node(1));
		bst.insert(bst, new Node(240));
		bst.insert(bst, new Node(423));
		bst.insert(bst, new Node(21));
		bst.insert(bst, new Node(53));
		bst.insert(bst, new Node(6));
		bst.insert(bst, new Node(6));
		bst.insert(bst, new Node(6));
		bst.insert(bst, new Node(6));

		bst.inOrderTreeWalk(bst.getRoot());
	}

	public BST_INT<Integer> populateBST(int size) {
		// TODO --- somehow, this method does not assign root correctly.
		int[] A = new int[size];
		autoPopulateArrayNoDuplicates(0, 100, A);

		BST_INT<Integer> bst = new BST_INT<Integer>();

		for (int i = 0; i < A.length; i++) {
			bst.insert(bst, new Node(A[i]));
		}
		System.out.println(bst.getRoot());
		return bst;
	}

	public void populateArray(int min, int max, int[] A) {

		for (int i = 0; i < A.length; i++) {
			A[i] = randomNumberGenerator(min, max);
		}
	}

	public void autoPopulateArrayNoDuplicates(int min, int max, int[] A) {

		Set<Integer> set = new LinkedHashSet<Integer>();
		int num = 0, i = 0;
		while (set.size() < A.length && set.size() < (max - min + 1)) {

			num = randomNumberGenerator(min, max);
			set.add(num);
		}

		// printIterable(set);

		for (Integer integer : set) {
			A[i++] = integer;
		}
	}

	public int randomNumberGenerator(int min, int max) {
		return (rd.nextInt(max + 1) + min);
	}

	public <T> void printIterable(Iterable<T> c) {
		for (Object i : c) {
			System.out.println(i.toString());
		}
	}

	public BST_INT<Integer> initBST() {
		BST_INT<Integer> bst = new BST_INT<Integer>();
		// Node temp = new Node(14);
		// bst.insert(bst, temp);

		bst.insert(bst, new Node(14));
		bst.insert(bst, new Node(24));
		bst.insert(bst, new Node(4));
		bst.insert(bst, new Node(25));
		bst.insert(bst, new Node(25));
		bst.insert(bst, new Node(5));
		bst.insert(bst, new Node(1));
		bst.insert(bst, new Node(240));
		bst.insert(bst, new Node(423));
		bst.insert(bst, new Node(21));

		// System.out.println(bst.getRoot());

		return bst;
	}
}