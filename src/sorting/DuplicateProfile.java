package sorting;

public class DuplicateProfile {
	private int key;
	private int[] indices;
	
	public DuplicateProfile(int k, int[] a ){
		key = k;
		indices = a;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public int[] getIndices() {
		return indices;
	}

	public void setIndices(int[] indices) {
		this.indices = indices;
	};
	
	
}
