package bst;

public class BST_INT<Integer> {

	private Node root;

	public BST_INT() {
	}

	public BST_INT(int key) {
		root = new Node();
		root.setValue(key);
	}

	public void transplant(BST_INT<Integer> bst, Node u, Node v) {
		if (u.getParent() == null) {
			bst.root = v;
		} else if (u == u.getParent().getLeft()) {
			u.getParent().setLeft(v);
		} else {
			u.getParent().setRight(v);
		}
		if (v != null) {
			v.setParent(u.getParent());
		}
	}

	public void delete(BST_INT<Integer> bst, Node z) {

		if (z.getLeft() == null) {
			transplant(bst, z, z.getRight());
		} else if (z.getRight() == null) {
			transplant(bst, z, z.getLeft());
		} else {
			Node y = minimum(z.getRight());
			if (y.getParent() != z) {
				transplant(bst, y, y.getRight());
				y.setRight(z.getRight());
				y.getRight().setParent(y);
			}
			transplant(bst, z, y);
			y.setLeft(z.getLeft());
			y.getLeft().setParent(y);
		}
	}

	public Node treeSuccessor(Node n) {

		if (n.getRight() != null) {
			return minimum(n.getRight());
		}
		Node above = n.getParent();
		while (above != null && n == above.getRight()) {
			n = above;
			above = n.getParent();
		}
		return above;
	}

	public Node minimum(Node n) {

		while (n.getLeft() != null) {
			n = n.getLeft();
		}
		return n;
	}

	public Node max(Node n) {

		while (n.getRight() != null) {
			n = n.getRight();
		}
		return n;
	}

	public void insert(BST_INT<Integer> bst, Node newNode) {
		// Node newNode = new Node(nn.getValue());
		Node n1 = bst.getRoot(), n2 = null;
		while (n1 != null) {
			n2 = n1;

			if (newNode.getValue() > n1.getValue()) {
				n1 = n1.getRight();
			} else {
				n1 = n1.getLeft();
			}
		}

		newNode.setParent(n2);

		if (n2 == null) {
			bst.setRoot(newNode);

		} else if (n2.getValue() > newNode.getValue()) {
			n2.setLeft(newNode);
			if (n2 == bst.getRoot()) {
				System.out.println("setting newNode[" + newNode
						+ "] as left of the root");

			}
		} else {
			n2.setRight(newNode);
			if (n2 == bst.getRoot()) {
				System.out.println("setting newNode[" + newNode
						+ "] as right of the root");
			}
		}
//DEBUG
//		if (bst.getRoot() != null) {
//			System.out.println("root: " + bst.getRoot() + "\troot.r: "
//					+ bst.getRoot().getRight() + "\troot.l: "
//					+ bst.getRoot().getLeft());
//		}

	}

	public Node treeSearchRec(Node n, int key) {
		if (n == null || key == n.getValue()) {
			return n;
		}
		if (key < n.getValue()) {
			return treeSearchRec(n.getLeft(), key);
		} else {
			return treeSearchRec(n.getRight(), key);
		}
	}

	public Node treeSearchItr(Node n, int key) {
		while (!(key == n.getValue() || n == null)) {
			if (key < root.getValue()) {
				return treeSearchRec(n.getLeft(), key);
			} else {
				return treeSearchRec(n.getRight(), key);
			}
		}
		return n;

	}

	public void inOrderTreeWalk(Node begin) {
		if (begin != null) {
			inOrderTreeWalk(begin.getLeft());
			System.out.print(begin.getValue() + " ");
			inOrderTreeWalk(begin.getRight());
		}
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

}
