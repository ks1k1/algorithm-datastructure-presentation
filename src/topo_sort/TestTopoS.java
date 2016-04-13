package topo_sort;

import static org.junit.Assert.*;

import java.util.Deque;

import org.junit.Test;

import topo_sort.Graph_ks.Node;

public class TestTopoS {
	 @Test
	public void testTopo2() {
		Node a = new Node("a");
		Node b = new Node("b");
		Node c = new Node("c");
		Node d = new Node("d");
		Node e = new Node("e");
		Node f = new Node("f");
		Node g = new Node("g");
		Node h = new Node("h");
		a.addEdge(c);
		b.addEdge(c);
		b.addEdge(d);
		c.addEdge(e);
		e.addEdge(h);
		e.addEdge(f);
		f.addEdge(g);

		Node[] allNodes = { e, h, f, g, b, c, d, a };
		Graph_ks gks = new Graph_ks(allNodes);
		//gks.printAllNodes();
		if (gks.isCyclic()) {
			System.out.println("Cycle present, topological sort not possible");
		} else {
			Deque<Node> sorted = gks.topologicalSort();

			for (Node n : sorted) {
				System.out.print(n + " ");
			}
		}
	}

	// @Test
	public void testIsALeaf() {
		Node a = new Node("a");
		Node b = new Node("b");
		Node c = new Node("c");
		Node d = new Node("d");
		Node e = new Node("e");
		Node f = new Node("f");
		Node g = new Node("g");
		Node h = new Node("h");
		a.addEdge(c);
		b.addEdge(c);
		b.addEdge(d);
		c.addEdge(e);
		e.addEdge(h);
		e.addEdge(f);
		f.addEdge(g);

		System.out.println("is a a leaf? " + a.isALeaf(a));
		System.out.println("is b a leaf? " + a.isALeaf(b));
		System.out.println("is c a leaf? " + a.isALeaf(c));
		System.out.println("is d a leaf? " + a.isALeaf(d));
		System.out.println("is e a leaf? " + a.isALeaf(e));
		System.out.println("is g a leaf? " + a.isALeaf(g));

	}

	// @Test
	public void test() {
		Graph_ks gks = new Graph_ks();
		System.out.println("hello test");
	}

	// @Test
	public void testTopo1() {
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

		if (gks.isCyclic()) {
			System.out.println("Cycle present, topological sort not possible");
		} else {
			Deque<Node> sorted = gks.topologicalSort();

			for (Node n : sorted) {
				System.out.print(n + " ");
			}
		}
	}

}
