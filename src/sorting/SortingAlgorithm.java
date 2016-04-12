package sorting;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class SortingAlgorithm {
	// private int length = -1;
	protected int[] A = null;
	protected Random rd = new Random();

	public SortingAlgorithm() {
	}

	public SortingAlgorithm(int len) {
		A = new int[len];
	}
	
	public SortingAlgorithm(int len, int min, int max) {
		A = new int[len];
		autoPopulateArrayNoDuplicates(min, max);
	}

	public int[] selectionSort() {

		int[] sorted = cloneArray();
		int i = -1;
		int idxMin = -1;

		for (int j = 0; j < sorted.length - 1; j++) {
			idxMin = minIndex(j, sorted.length);
			if (sorted[j] != sorted[idxMin]) {
				swap(j, idxMin, sorted);
			}
			// DEBUG
			System.out
					.print("[j= " + j + " ]\t min value: " + sorted[j] + "\t");
			printArray(sorted);
		}
		return sorted;
	}

	public int[] duplicateIndices(int[] B, int key) {
		int[] indices = new int[countKey(B, key)];

		for (int i = 0, j = 0; i < B.length; i++) {
			if (B[i] == key) {
				indices[j++] = i;
			}
		}
		return indices;
	}

	public int countKey(int[] B, int key) {
		int num = 0;
		for (int i : B) {
			if (i == key) {
				num++;
			}
		}
		return num;
	}

	public void swap(int a, int b, int[] B) {
		int temp = B[a];
		B[a] = B[b];
		B[b] = temp;
	}

	public int minIndex(int idxLow, int idxHigh) {

		int idxMin = idxLow;
		for (int i = idxLow; i < idxHigh; i++) {
			if (A[i] < A[idxMin]) {
				idxMin = i;
			}
		}
		return idxMin;
	}

	public void printArray() {

		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}

	public void printArray(int[] B) {

		for (int i = 0; i < B.length; i++) {
			System.out.print(B[i] + " ");
		}
		System.out.println();
	}

	public void autoPopulateArray(int min, int max) {
		for (int i = 0; i < A.length; i++) {
			A[i] = randomNumberGenerator(min, max);
		}
	}
	
	public void autoPopulateArrayNoDuplicates(int min, int max) {
		
		Set<Integer> set = new TreeSet<Integer>();
		int num=0, i=0;
		while (set.size() < A.length && set.size() < (max - min + 1)){
			
			num = randomNumberGenerator(min, max);
			set.add(num);
			System.out.println(num + "added (size = "+set.size()+").");			
		}
		
		printIterable(set);
		
		for (Integer integer : set) {
			A[i++] = integer;
		}
	}

	public int randomNumberGenerator(int min, int max) {
		return rd.nextInt(max + 1) + min;
	}

	public int[] getA() {
		return A;
	}

	public void setA(int[] a) {
		A = a;
	}

	public int[] cloneArray() {

		int[] clone = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			clone[i] = A[i];
		}
		return clone;
	}
	
	public <T> void printIterable(Iterable<T> c){
		for (Object i : c) {
			System.out.println(i.toString());
		}
	}

}
