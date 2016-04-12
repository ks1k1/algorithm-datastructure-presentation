package topo_sort;

import java.util.Set;
import java.util.HashSet;
import java.util.Deque;
import java.util.ArrayDeque;

import org.jgrapht.experimental.dag.DirectedAcyclicGraph;
/** Given a directed acyclic graph, sort the vertices so that ascendents always comes before descendents*/
public class TopologicalSort<T>{

	public Deque<Vertex<T>> topologicalSort(Graph<T> graph){
		
		Deque<Vertex<T>> stack = new ArrayDeque<>(); // no-kids
		Set<Vertex<T>> visited = new HashSet<Vertex<T>>();
		
		for(Vertex<T> v : graph.getAllVertex()){
			if(visited.contains(v)){
				continue;
			}
			topologicalSortUtil(v, stack, visited);
		}
		
		return stack;
	}

	private void topologicalSortUtil(Vertex v, Deque stack, Set visited){
	
			while(!isALeaf(v)){
				if(!(v.getLeft()==null)){
					v = v.getLeft;
				}else if(!(v.getRight()==null)){
					v = v.getRighft;
				}
			}
			// if v has child
				// go to that child
	}
	
	private boolean isALeaf(Vertex v){
	
		return v.Left() == null && v.getRight() == null;
	}


}