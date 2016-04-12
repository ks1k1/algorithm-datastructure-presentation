package sorting;

public class BinarySearchImpl extends SortingAlgorithm {
	private int mid;

	public BinarySearchImpl() {
		super();
	}

	public BinarySearchImpl(int a, int b, int c) {
		super(a, b, c);
	}

	public int iterativeBinarySearch(int key, int high, int low) {

		mid = -1;

		while (high >= low) {
			mid = (int) Math.round((high + low) / 2.);

			if (A[mid] == key) {
				return mid;
			}

			if (A[mid] > key) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}

		}
		return -1;
	}

	public int recursiveBinarySearch(int key, int high, int low) {
		if (A[mid] == key) {
			System.out.println("key=" + key + "\t== A[mid]=" + A[mid]);
			return mid;
		}
		if (low > high) {
			return -1;
		}

		mid = (int) Math.round((high + low) / 2.);
		System.out.println("key=" + key + "\tmid=" + mid + "\tA[mid]=" + A[mid]
				+ "\thigh" + high + "\tlow=" + low);

		if (A[mid] > key) {
			return recursiveBinarySearch(key, mid - 1, low);
		} else {
			return recursiveBinarySearch(key, high, mid + 1);
		}

	}
}
