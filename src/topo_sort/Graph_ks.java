package topo_sort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import topo_sort.Graph.Edge;
import topo_sort.Graph.Node;

public class Graph_ks {
	Set<Node> graph = new HashSet<Node>();

	public Graph_ks(Node[] nodes) {
		for (Node node : nodes) {
			graph.add(node);
		}
	}

	static class Node {
		public String nodeName;
		public Set<Edge> edgesIn;
		public Set<Edge> edgesOut;

		public Node(String name) {
			nodeName = name;
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
	}

	static class Edge {
		public Node to;
		public Node from;

		public Edge(Node t, Node f) {
			to = t;
			from = f;
		}

		@Override
		public boolean equals(Object obj) {
			Edge other = (Edge) obj;
			return other.to == to && other.from == from;
		}
	}

	public Deque<Node> topologicalSort() {

		Deque<Node> stack = new ArrayDeque<>(); // no-kids
		Set<Node> visited = new HashSet<Node>();

		for (Node v : graph) {
			if (visited.contains(v)) {
				continue;
			}
			topologicalSortUtil(v, stack, visited);
		}

		return stack;
	}

	private void topologicalSortUtil(Node v, Deque<Node> stack,
			Set<Node> visited) {

		visited.add(v);
		for (Edge e : v.edgesOut) {
			Node nextNode = e.to;
			if (!nextNode.isALeaf(nextNode)) {
				continue;
			}
		}
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
		// L <- Empty list that will contain the sorted elements
		ArrayList<Node> L = new ArrayList<Node>();

	}

}
