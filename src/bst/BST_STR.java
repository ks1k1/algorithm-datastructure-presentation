package bst;
//package sorting;
//
//import java.util.Comparator;
//import java.util.Iterator;
//import java.util.LinkedHashMap;
//import java.util.LinkedHashSet;
//import java.util.List;
//import java.util.Random;
//import java.util.Set;
//
//public class BST<E extends Comparable<E>> implements Iterable<E> {
//
//	private Node root;
//	private Comparator<E> comparator;
//
//	public BST() {
//	}
//
//	public BST(int len) {
//		A = new int[len];
//	}
//
//	public int[] selectionSort() {
//
//		int[] sorted = cloneArray();
//		int i = -1;
//		int idxMin = -1;
//
//		for (int j = 0; j < sorted.length - 1; j++) {
//			idxMin = minIndex(j, sorted.length);
//			if (sorted[j] != sorted[idxMin]) {
//				swap(j, idxMin, sorted);
//			}
//			// DEBUG
//			System.out
//					.print("[j= " + j + " ]\t min value: " + sorted[j] + "\t");
//			printArray(sorted);
//		}
//		return sorted;
//	}
//
//	public List duplicates() {
//		return null;
//	}
//
//	public int[] duplicateIndices(int[] B, int key) {
//		int[] indices = new int[countKey(B, key)];
//
//		for (int i = 0, j = 0; i < B.length; i++) {
//			if (B[i] == key) {
//				indices[j++] = i;
//			}
//		}
//		return indices;
//	}
//
//	public int countKey(int[] B, int key) {
//		int num = 0;
//		for (int i : B) {
//			if (i == key) {
//				num++;
//			}
//		}
//		return num;
//	}
//
//	public void swap(int a, int b, int[] B) {
//		int temp = B[a];
//		B[a] = B[b];
//		B[b] = temp;
//	}
//
//	public class Node<E> {
//		private E key;
//		private Node left, right;
//
//		public Node() {
//		}
//
//		public Node(E key) {
//			this.key = key;
//		}
//
//		public Node(E key, Node l, Node r) {
//			this.key = key;
//			left = l;
//			right = r;
//		}
//
//		@Override
//		public String toString() {
//			return "key: " + key + "left: " + left + "right: " + right;
//		}
//	}
//	
//
//	@Override
//	public Iterator<E> iterator() {
//		Iterator<E> itr = new Iterator<E>() {
//			@Override
//			public boolean hasNext() {
//				return left != null && right != nulltrue;
//			}
//
//			@Override
//			public E next() {
//				// TODO Auto-generated method stub
//				return null;
//			}
//
//			@Override
//			public void remove() {
//				// TODO Auto-generated method stub
//
//			}
//		};
//
//		return null;
//	}
//}
