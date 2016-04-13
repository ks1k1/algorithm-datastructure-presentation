package topo_sort;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Graph_ks {
	Set<Node> graph = new HashSet<Node>();

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

	private void topologicalSortUtil(Node v, Deque<Node> stack,
			Set<Node> visited) {

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
		gks.printAllNodes();
		if (gks.isCyclic()) {
			System.out.println("Cycle present, topological sort not possible");
		} else {
			Deque<Node> sorted = gks.topologicalSort();

			while (!sorted.isEmpty()) {
				System.out.print(sorted.poll() + " ");
			}
		}
	}

	public void printAllNodes() {

		for (Node node : graph) {
			System.out.println(node.debugString());
		}
	}
}
