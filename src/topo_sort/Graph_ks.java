package topo_sort;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Graph_ks {
	Set<Node> graph = new HashSet<Node>();
	Node root1, root2, root3;

	public Graph_ks() {
	}

	public Graph_ks(Node[] nodes) {
		for (Node node : nodes) {
			graph.add(node);
		}
	}

	static class Node {
		public final String nodeName;
		public final Set<Edge> edgesIn;
		public final Set<Edge> edgesOut;

		public Node(String name) {
			nodeName = name;
			edgesIn = new HashSet<Edge>();
			edgesOut = new HashSet<Edge>();
		}

		public Node addEdge(Node newNode) {

			Edge e = new Edge(this, newNode);
			edgesOut.add(e);
			newNode.edgesIn.add(e);
			return this;
		}

		public boolean isARoot() {

			return edgesIn == null;
		}

		public boolean isALeaf(Node v) {

			return v.edgesOut == null || v.edgesOut.size() == 0;
		}

		@Override
		public String toString() {
			return nodeName;
		}

		public String debugString() {
			StringBuilder sb = new StringBuilder();
			sb.append(nodeName);
			sb.append("\noutgoing edges:");
			for (Edge edge : edgesOut) {
				sb.append("\n" + edge);
			}
			sb.append("\nincoming edges:");
			for (Edge edge : edgesIn) {
				sb.append("\n" + edge);
			}
			sb.append("\n");
			return sb.toString();
		}
	}

	static class Edge {
		public final Node to;
		public final Node from;

		public Edge(Node f, Node t) {
			to = t;
			from = f;
		}

		@Override
		public boolean equals(Object obj) {
			Edge other = (Edge) obj;
			return other.to == to && other.from == from;
		}

		@Override
		public String toString() {
			return "from " + from.toString() + " to " + to.toString();
		}
	}

	public void DFS_iteration(Node startNode) {
		Set<Node> visited = new HashSet<Node>();
		visited.add(startNode);
		Node currNode = startNode, childNode;
		System.out.print(startNode + " ");
		for (Edge e : currNode.edgesOut) {
			childNode = e.to;
			if (!(childNode == null) && !visited.contains(childNode)) {
				DFS_iteration(childNode);
			}
		}
	}

	public void BFS_iteration(Node startNode) {

		Queue<Node> q = new LinkedList<Node>();
		Set<Node> visited = new HashSet<Node>();
		Node currNode = startNode, childNode;

		while (visited.size() > 0) {
			visited.add(currNode);
			for (Edge e : currNode.edgesOut) {
				childNode = e.to;
				if (!(childNode == null) && !visited.contains(childNode)) {
					q.add(childNode);
				}
			}

		}

		System.out.print(startNode + " ");

	}

	public Deque<Node> topologicalSort() {

		Deque<Node> stack = new ArrayDeque<>(); // no-kids
		Set<Node> visited = new HashSet<Node>();

		for (Node n : graph) {
			if (visited.contains(n)) {
				continue;
			}
			topologicalSortUtil(n, stack, visited);
		}

		return stack;
	}

	public void topologicalSortUtil(Node v, Deque<Node> stack, Set<Node> visited) {

		System.out.println(v + " has been visited, added to visited set");
		visited.add(v);
		for (Edge e : v.edgesOut) {
			Node childNode = e.to;
			if (visited.contains(childNode)) {
				continue;
			}
			topologicalSortUtil(childNode, stack, visited);
		}
		System.out.println("add " + v + " to the sorted stack");
		stack.offerFirst(v);
	}

	public boolean isCyclic() {
		Node currNode, nextNode;
		for (Node node : graph) {
			currNode = node;
			for (Edge e : node.edgesOut) {
				nextNode = e.to;

				if (nextNode.edgesOut.contains(currNode)) {
					return true;
				}
			}
		}
		return false;
	}

	// public void dummy() {
	public static void main(String[] args) {

		Graph_ks gks = populateGraph01();

		gks.printAllNodes();

		if (gks.isCyclic()) {
			System.out.println("Cycle present, topological sort not possible");
		} else {
			// runTopologicalSort(gks);
			gks.DFS_iteration(gks.root1);
		}
	}

	private static Graph_ks populateGraph01() {

		Node seven = new Node("7");
		Node five = new Node("5");
		Node three = new Node("3");
		Node eleven = new Node("11");
		Node eight = new Node("8");
		Node two = new Node("2");
		Node nine = new Node("9");
		Node ten = new Node("10");
		seven.addEdge(eleven).addEdge(eight);
		five.addEdge(eleven);
		three.addEdge(eight).addEdge(ten);
		eleven.addEdge(two).addEdge(nine).addEdge(ten);
		eight.addEdge(nine).addEdge(ten);

		Node[] allNodes = { seven, five, three, eleven, eight, two, nine, ten };
		Graph_ks gks = new Graph_ks(allNodes);

		return gks;
	}

	private static Graph_ks populateGraph02() {

		Node a = new Node("a");
		Node b = new Node("b");
		Node c = new Node("c");
		Node d = new Node("d");
		Node e = new Node("e");
		Node f = new Node("f");
		Node g = new Node("g");
		Node h = new Node("h");
		a.addEdge(b).addEdge(c);
		b.addEdge(d).addEdge(e);
		c.addEdge(f).addEdge(g);
		d.addEdge(h);

		Node[] allNodes = { e, h, f, g, b, c, d, a };
		Graph_ks gks = new Graph_ks(allNodes);
		gks.setRoot1(a);
		return gks;
	}

	private static void runTopologicalSort(Graph_ks gks) {
		Deque<Node> sorted = gks.topologicalSort();

		while (!sorted.isEmpty()) {
			System.out.print(sorted.poll() + " ");
		}
	}

	public Set<Node> getGraph() {
		return graph;
	}

	public void setGraph(Set<Node> graph) {
		this.graph = graph;
	}

	public Node getRoot1() {
		return root1;
	}

	public void setRoot1(Node root1) {
		this.root1 = root1;
	}

	public Node getRoot2() {
		return root2;
	}

	public void setRoot2(Node root2) {
		this.root2 = root2;
	}

	public Node getRoot3() {
		return root3;
	}

	public void setRoot3(Node root3) {
		this.root3 = root3;
	}

	public void printAllNodes() {

		for (Node node : graph) {
			System.out.println(node.debugString());
		}
	}

}
