package bst;

public class Node {
	private int value;
	private Node left, right, parent;

	// public Node() {
	//
	// }
	//
	public Node(int key) {
		super();
		this.value = key;
	}

	public Node() {
		super();
	}

	public Node(int value, Node left, Node right, Node parent) {
		super();
		this.value = value;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}

//	@Override
//	public String toString() {
//
//		StringBuilder sb = new StringBuilder();
//		sb.append("value: " + value);
//		if (left != null) {
//			sb.append("left: " + left);
//		}
//		if (right != null) {
//			sb.append("right: " + right);
//		}
//		if (parent != null) {
//			sb.append("parent: " + parent);
//		}
//
//		return sb.toString();
//	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}
}