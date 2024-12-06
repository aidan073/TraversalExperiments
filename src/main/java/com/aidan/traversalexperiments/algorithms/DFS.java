package com.aidan.traversalexperiments.algorithms;

import java.util.HashSet;
import java.util.Set;

import org.graphstream.graph.Graph;

import com.aidan.traversalexperiments.common.Node;
import com.aidan.traversalexperiments.utils.Visualize;

public class DFS {
	// traverse
	public static void traverse(Node start) {
		traverse(start, null);
	}
	// traverse (and display traversal)
	public static void traverse(Node start, Graph graph) {
		if(start == null) {
			System.out.println("Start node is null. No traversal performed");
			return;
		}
		if(graph != null) {
			Visualize.displayGraph(graph);
		}
		Set<Node> visited = new HashSet<>();
		recursiveTraverse(start, visited, graph);
	}
	
	private static void recursiveTraverse(Node curr, Set<Node> visited, Graph graph) {
		if(curr == null) {
			return;
		}
		if(visited.add(curr)) {
			// update node appearance to visited, if graph is supplied
			if(graph != null) {
				graph.getNode(String.valueOf(curr.getId())).setAttribute("ui.class", "visited");
		        try {
		            Thread.sleep(2000);
		        } catch (InterruptedException e) {
		            System.out.println("Traversal interrupted.");
		            Thread.currentThread().interrupt();
		        }
			}
			for(Node neighbor : curr.getNeighbors()) {
				recursiveTraverse(neighbor, visited, graph);
			}
		}
		return;
	}
	
	// find target node
	public static boolean search(Node start, int targetId) {
		return search(start, targetId, null);
	}
	
	// find target node (and display search)
	public static boolean search(Node start, int targetId, Graph graph) {
        if(start == null) {
            System.out.println("Start node is null. No search performed.");
        	return false;
        }
        if(graph != null) {
        	graph.getNode(String.valueOf(targetId)).setAttribute("ui.class", "target");
        	Visualize.displayGraph(graph);
        }
        Set<Node> visited = new HashSet<>();
        return searchTraverse(start, visited, targetId, graph);
	}
	
	// traversal specifically for search function
	private static boolean searchTraverse(Node curr, Set<Node> visited, int targetId, Graph graph) {
		if(curr == null) {
			return false;
		}
		else if(curr.getId() == targetId) {
			if(graph != null) {
				graph.getNode(String.valueOf(curr.getId())).setAttribute("ui.class", "found");
			}
			return true;
		}
		else if(visited.add(curr)) {
			// update node appearance to visited, if graph is supplied
			if(graph != null) {
				graph.getNode(String.valueOf(curr.getId())).setAttribute("ui.class", "visited");
		        try {
		            Thread.sleep(2000);
		        } catch (InterruptedException e) {
		            System.out.println("Traversal interrupted.");
		            Thread.currentThread().interrupt();
		        }
			}
			for(Node neighbor : curr.getNeighbors()) {
				if(searchTraverse(neighbor, visited, targetId, graph)) {
					return true;
				}
			}
		}
		return false;
		
	}
}
