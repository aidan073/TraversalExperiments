package com.aidan.traversalexperiments.algorithms;

import java.util.HashSet;
import java.util.Set;

import org.graphstream.graph.Graph;

import com.aidan.traversalexperiments.common.Node;

public class DFS {
	public static void traverse(Node start) {
		traverse(start, null);
	}
	public static void traverse(Node start, Graph graph) {
		if(start == null) {
			System.out.println("Start node is null. No traversal performed");
			return;
		}
		Set<Node> visited = new HashSet<>();
		System.out.println("DFS Traversal:");
		recursiveTraverse(start, visited, graph);
	}
	
	private static void recursiveTraverse(Node curr, Set<Node> visited, Graph graph) {
		if(curr == null) {
			return;
		}
		if(visited.add(curr)) {
//			System.out.println("Visited: " + curr);
			// update node appearance to visited, if graph is supplied
			if(graph != null) {
				graph.getNode(String.valueOf(curr.getId())).setAttribute("ui.class", "visited"); // change node appearance
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
        if(start == null) {
            System.out.println("Start node is null. No search performed.");
        	return false;
        }
        Set<Node> visited = new HashSet<>();
        return searchTraverse(start, visited, targetId);
	}
	
	// traversal specifically for search function
	private static boolean searchTraverse(Node curr, Set<Node> visited, int targetId) {
		if(curr == null) {
			return false;
		}
		else if(curr.getId() == targetId) {
			return true;
		}
		else if(visited.add(curr)) {
			for(Node neighbor : curr.getNeighbors()) {
				if(searchTraverse(neighbor, visited, targetId)) {
					return true;
				}
			}
		}
		return false;
		
	}
}
